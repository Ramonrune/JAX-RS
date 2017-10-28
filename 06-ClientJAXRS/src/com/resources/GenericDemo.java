package com.resources;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resources.model.Message;

public class GenericDemo {

	public static void main(String[] args) {

		Client newClient = ClientBuilder.newClient();
		List<Message> messages = newClient
				.target("http://localhost:8080/01-HelloWorldJAXRS/webapi")
				.path("messages")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Message>>() {
					
				});
		
		System.out.println(messages.toString());
		
		
	}
}
