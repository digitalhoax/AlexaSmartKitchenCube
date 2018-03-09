package de.uniks.alexa.smartkitchencube.lambda.handler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.uniks.alexa.smartkitchencube.ReportState;

public class StateRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(String input, Context context) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		ReportState request;
		String response = "";
			request = om.readValue(input, ReportState.class);

			String accessToken = request.getDirective().getEndpoint().getScope().getToken();
			String correlationToken = request.getDirective().getHeader().getCorrelationToken();
			String endpointId = request.getDirective().getEndpoint().getEndpointId();

			//date format: 2017-09-27T18:30:30.45Z

			TimeZone tz = TimeZone.getTimeZone("UTC");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
			df.setTimeZone(tz);
			String timestamp = df.format(new Date());

			response = "{\n" + 
					"    \"context\": {\n" + 
					"        \"properties\": [\n" + 
					"            {\n" + 
					"                \"namespace\": \"Alexa.EndpointHealth\",\n" + 
					"                \"name\": \"connectivity\",\n" + 
					"                \"value\": {\n" + 
					"                    \"value\": \"OK\"\n" + 
					"                },\n" + 
					"                \"timeOfSample\": \"" + timestamp + "\",\n" + 
					"                \"uncertaintyInMilliseconds\": 200\n" + 
					"            }\n" + 
					"        ]\n" + 
					"    },\n" + 
					"    \"event\": {\n" + 
					"        \"header\": {\n" + 
					"            \"namespace\": \"Alexa\",\n" + 
					"            \"name\": \"StateReport\",\n" + 
					"            \"payloadVersion\": \"3\",\n" + 
					"            \"messageId\": \"5f8a426e-01e4-4cc9-8b79-65f8bd0fd8a4\",\n" + 
					"            \"correlationToken\": \"" + correlationToken + "\"\n" + 
					"        },\n" + 
					"        \"endpoint\": {\n" + 
					"            \"scope\": {\n" + 
					"                \"type\": \"BearerToken\",\n" + 
					"                \"token\": \"" + accessToken + "\"\n" + 
					"            },\n" + 
					"            \"endpointId\": \"" + endpointId + "\"\n" + 
					"        },\n" + 
					"        \"payload\": {}\n" + 
					"    }\n" + 
					"}";

		return response;
	}
}
