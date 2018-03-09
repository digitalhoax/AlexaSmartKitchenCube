package de.uniks.alexa.smartkitchencube.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;

public interface RequestHandler {
	String handleRequest(String input, Context context) throws Exception;
}
