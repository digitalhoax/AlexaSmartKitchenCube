package de.uniks.alexa.smartkitchencube.lambda;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import de.uniks.alexa.smartkitchencube.lambda.handler.AuthorizationRequestHandler;
import de.uniks.alexa.smartkitchencube.lambda.handler.DiscoverRequestHandler;
import de.uniks.alexa.smartkitchencube.lambda.handler.ErrorRequestHandler;
import de.uniks.alexa.smartkitchencube.lambda.handler.RequestHandler;
import de.uniks.alexa.smartkitchencube.lambda.handler.StateRequestHandler;
import de.uniks.alexa.smartkitchencube.lambda.handler.TimerAdjustRequestHandler;
import de.uniks.alexa.smartkitchencube.lambda.handler.TimerRequestHandler;

public class AlexaSmartKitchenCubeLambda implements RequestStreamHandler {

	private enum RequestType {
		AUTHORIZATION,
		DISCOVERY,
		TIMER,
		TIMER_ADJUST,
		STATE,
		DEFAULT
	}
	
	private HashMap<RequestType, RequestHandler> typeRequestMap = createTypeRequestMap();
	private HashMap<RequestType, RequestHandler> createTypeRequestMap() {
		HashMap<RequestType, RequestHandler> map = new HashMap<>();
		map.put(RequestType.AUTHORIZATION, new AuthorizationRequestHandler());
		map.put(RequestType.DISCOVERY, new DiscoverRequestHandler());
		map.put(RequestType.TIMER, new TimerRequestHandler());
		map.put(RequestType.STATE, new StateRequestHandler());
		map.put(RequestType.DEFAULT, new ErrorRequestHandler());
		map.put(RequestType.TIMER_ADJUST, new TimerAdjustRequestHandler());
		return map;
	}

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

		byte[] byteArray = IOUtils.toByteArray(input);
		String inputString = new String(byteArray);
		context.getLogger().log("\nREQUEST: " + inputString);
		RequestType requestType = getRequestType(inputString);

		try {
			String response = typeRequestMap.get(requestType).handleRequest(inputString, context);
			output.write(response.getBytes());
			context.getLogger().log("\nRESPONSE: " + response);
		} catch (Exception e) {
			//TODO respond with error message
			context.getLogger().log(e.getMessage());
		}
	}

	private RequestType getRequestType(String input) {
		if(input.contains("Alexa.Authorization") && input.contains("AcceptGrant")) {
			return RequestType.AUTHORIZATION;
		}
		if(input.contains("Alexa.Discovery") && input.contains("Discover")) {
			return RequestType.DISCOVERY;
		}
		if(input.contains("Alexa.Cooking.TimeController") && input.contains("CookByTime")) {
			return RequestType.TIMER;
		}
		if(input.contains("ReportState") && input.contains("Alexa")) {
			return RequestType.STATE;
		}
		if(input.contains("Alexa.Cooking.TimeController") && input.contains("AdjustCookTime")) {
			return RequestType.TIMER_ADJUST;
		}
		return RequestType.DEFAULT;
	}
}
