package de.uniks.alexa.smartkitchencube.lambda.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import de.uniks.alexa.smartkitchencube.AdjustCookTimeRequest;
import de.uniks.alexa.smartkitchencube.CookByTimeResponse;
import de.uniks.alexa.smartkitchencube.Event;
import de.uniks.alexa.smartkitchencube.Header;
import de.uniks.alexa.smartkitchencube.Payload;
import de.uniks.alexa.smartkitchencube.Property;
import nl.infcomtec.jparticle.Device;

public class TimerAdjustRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(String input, Context context) throws Exception {
		ObjectMapper om = new ObjectMapper();
		AdjustCookTimeRequest request;
		request = om.readValue(input, AdjustCookTimeRequest.class);

		String token = request.getDirective().getEndpoint().getScope().getToken();
		String endpointId = request.getDirective().getEndpoint().getEndpointId();
		String cookTime = request.getDirective().getPayload().getCookTimeDelta();
		Duration duration = Duration.parse(cookTime);

		int timeInSec = (int)duration.toMillis()/1000;
		int totalCountdown = Device.callFunction("adjust", ""+timeInSec, endpointId, token);

		context.getLogger().log("Adjusting timer on: " + endpointId + " to " + timeInSec + " with token: " + token);
		
		CookByTimeResponse response = new CookByTimeResponse();
		Event event = new Event();
		Header header = new Header();
		header.setNamespace("Alexa");
		header.setName("Response");
		header.setPayloadVersion("3");
		header.setMessageId(String.valueOf(input.hashCode()));
		header.setCorrelationToken(request.getDirective().getHeader().getCorrelationToken());
		Payload payload = new Payload();
		response.setEvent(event);
		event.setHeader(header);
		event.setPayload(payload);
		event.setEndpoint(request.getDirective().getEndpoint());
		
		de.uniks.alexa.smartkitchencube.Context responseContext = new de.uniks.alexa.smartkitchencube.Context();
		List<Property> properties = new LinkedList<>();
		Property property = new Property();
		property.setName("cookTime");
		property.setNamespace("Alexa.Cooking.TimeController");
		
		
		// TODO timeInSec to strange format
		// cookTime = (whatever) totalCountdown
		property.setValue(cookTime);
		properties.add(property);
		responseContext.setProperties(properties );
		response.setContext(responseContext);
		
		// timestamp
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		df.setTimeZone(tz);
		String timestamp = df.format(new Date());
		
		property.setTimeOfSample(timestamp);
		property.setUncertaintyInMilliseconds(0);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String respondJsonString = mapper.writeValueAsString(response);
		
		return respondJsonString;
	
	}

}
