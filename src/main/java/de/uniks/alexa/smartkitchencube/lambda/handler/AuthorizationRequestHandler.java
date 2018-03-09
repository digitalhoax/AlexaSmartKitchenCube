package de.uniks.alexa.smartkitchencube.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;

public class AuthorizationRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(String input, Context context) {
		String response = "{\n" + 
				"    \"event\": {\n" + 
				"        \"header\": {\n" + 
				"            \"namespace\": \"Alexa.Authorization\",\n" + 
				"            \"name\": \"AcceptGrant.Response\",\n" + 
				"            \"payloadVersion\": \"3\",\n" + 
				"            \"messageId\": \"" + input.hashCode() + "\"\n" + 
				"        },\n" + 
				"        \"payload\": {}\n" + 
				"    }\n" + 
				"}";
		return response;
	}

}
