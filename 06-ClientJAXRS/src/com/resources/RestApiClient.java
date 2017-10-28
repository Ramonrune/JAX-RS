package com.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resources.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();

/**		Alguns exemplos de chamada
 * 		Pode-se colocar get(Message.class)		
		String message = client
				.target("http://localhost:8080/01-HelloWorldJAXRS/webapi/messages/1")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
				
		Builder builder = target.request();
		Response response = builder.get();
		
		Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());
		System.out.println(message);
	*/
		
		/**
		 * Melhores práticas!
		 * 
		 */
		/**==================================================================
		 * GET
		 * ==================================================================
		 */
		WebTarget target = client
		.target("http://localhost:8080/01-HelloWorldJAXRS/webapi");
		WebTarget messagesTarget = target.path("messages");
		WebTarget singleMessagetarget = messagesTarget.path("{messageId}");
		
		
		
		String message1 = singleMessagetarget.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		String message2 = singleMessagetarget.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		System.out.println(message1);
		System.out.println(message2);
		
		/**==================================================================
		 * END-GET
		 * ==================================================================
		 */
		Message newMessage = new Message(4, "Minha nova mensagem do cliente JAX-RS", "Ramon Lacava");
		Response postResponse = messagesTarget
		.request()
		.post(Entity.json(newMessage));
		
		if(postResponse.getStatus() != 201){
			System.out.println("Erro!");
		}
		
		Message message = postResponse.readEntity(Message.class);
		//String postString = postResponse.readEntity(String.class);

		System.out.println(message.getMessage());
		//System.out.println(postString);


	}
	
}
