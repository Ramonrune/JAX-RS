package com.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * 
 * @author MyResource é instanciada toda vez, mas, utilizando @Singleton há apenas
 * uma instancia.
 * Sem @Singleton é criada uma instancia de MyResource a cada requisição
 *
 */
@Path("test")
@Singleton
public class MyResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		
		count++;
		
		return "Isso funciona! Esse metodo foi chamado " + count + " vez(es)";
	}
	

}
