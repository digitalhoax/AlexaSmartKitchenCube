package de.uniks.alexa.smartkitchencube.lambda.handler;

import java.util.LinkedList;
import java.util.TreeMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import de.uniks.alexa.smartkitchencube.Capability;
import de.uniks.alexa.smartkitchencube.Configuration;
import de.uniks.alexa.smartkitchencube.DiscoveryRequest;
import de.uniks.alexa.smartkitchencube.DiscoveryResponse;
import de.uniks.alexa.smartkitchencube.Endpoint;
import de.uniks.alexa.smartkitchencube.Event;
import de.uniks.alexa.smartkitchencube.Header;
import de.uniks.alexa.smartkitchencube.Payload;
import de.uniks.alexa.smartkitchencube.Properties;
import de.uniks.alexa.smartkitchencube.Supported;
import nl.infcomtec.jparticle.Cloud;
import nl.infcomtec.jparticle.Device;

public class DiscoverRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(String input, Context context) throws Exception {
		ObjectMapper om = new ObjectMapper();
		DiscoveryRequest request;
		request = om.readValue(input, DiscoveryRequest.class);

		String accessToken = request.getDirective().getPayload().getScope().getToken();

		long currentTimeMillis = System.currentTimeMillis();
		Cloud cloud = new Cloud(accessToken, false, false);
		context.getLogger().log("Cloud Initialization: " + (System.currentTimeMillis() - currentTimeMillis));

		TreeMap<String,Device> devices = cloud.devices;

		//forge a discovery response
		DiscoveryResponse response = new DiscoveryResponse();
		Event event = new Event();
		Header header = new Header();
		header.setNamespace("Alexa.Discovery");
		header.setName("Discover.Response");
		header.setPayloadVersion("3");
		header.setMessageId("" + response.hashCode());
		Payload payload = new Payload();
		response.setEvent(event);
		event.setHeader(header);
		event.setPayload(payload);


		currentTimeMillis = System.currentTimeMillis();
		LinkedList<Endpoint> endpoints = new LinkedList<>();
		for (Device device : devices.values()) {
			if(device.connected) {
				try {
					Device d = Device.getDevice(device.id, accessToken);
					if(d.variables != null && d.variables.has("alexa_device")) {
						//we now have a device d which identifies itself as "alexa_device via published variable
						//endpoint
						Endpoint endpoint = new Endpoint();
						endpoint.setEndpointId(d.id);
						endpoint.setManufacturerName("Smart Kitchen Cube Inc.");
						endpoint.setDescription("Smart Kitchen Cube that visualizes your kitchen timers.");
						endpoint.setFriendlyName(d.readString("alexa_device", accessToken));
						LinkedList<String> displayCategories = new LinkedList<>();
						displayCategories.add("MICROWAVE");
						endpoint.setDisplayCategories(displayCategories);
						LinkedList<Capability> capabilities = new LinkedList<>();
						capabilities.add(createCapability("AlexaInterface", "Alexa", "3", null, null));
						capabilities.add(createCapability("AlexaInterface", "Alexa.Cooking.TimeController", "3", createProperties(true, false, "cookTime"), null));
						endpoint.setCapabilities(capabilities);
						if(endpoint.getFriendlyName() != null) endpoints.add(endpoint);
					}
				} catch (Exception e) {
					context.getLogger().log(e.getMessage());
					break;
				}
			}
		}
		context.getLogger().log("Device Discovery: " + (System.currentTimeMillis() - currentTimeMillis));

		payload.setEndpoints(endpoints);
		response.setEvent(event);
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String respondJsonString = mapper.writeValueAsString(response);

		return respondJsonString;
	}

	private Capability createCapability(String typeName, 
			String interfaceName, 
			String versionName,
			Properties properties, Configuration configuration) {
		Capability cap = new Capability();
		cap.setType(typeName);
		cap.setInterface(interfaceName);
		cap.setVersion(versionName);
		cap.setProperties(properties);
		cap.setConfiguration(configuration);
		return cap;
	}

	private Properties createProperties(boolean proactivelyReported, boolean retrievable, String...supportedNames) {
		Properties props = new Properties();
		props.setProactivelyReported(proactivelyReported);
		props.setRetrievable(retrievable);
		LinkedList<Supported> supportedList = new LinkedList<>();
		for (String supportedName : supportedNames) {
			Supported supported = new Supported();
			supported.setName(supportedName);
			supportedList.add(supported);
		}
		props.setSupported(supportedList);
		return props;
	}
	
}
