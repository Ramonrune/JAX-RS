package com.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		
		InvocationDemo invocationDemo = new InvocationDemo();
		Invocation prepareRequestForMessagesByYear = invocationDemo.prepareRequestForMessagesByYear(2015);
		Response response = prepareRequestForMessagesByYear.invoke();
		
		System.out.println(response.getStatus());
		
	}

	public Invocation prepareRequestForMessagesByYear(int year) {
		
		Client newClient = ClientBuilder.newClient();
		return  newClient
				.target("http://localhost:8080/01-HelloWorldJAXRS/webapi")
				.path("messages")
				.queryParam("year", year)
				.request(MediaType.APPLICATION_JSON)
				.buildGet();
		
		

	}
}
