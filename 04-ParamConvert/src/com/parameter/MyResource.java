package com.parameter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MyResource {

	/**
	 * Não funciona se for uma singleton
	 * MyResource é instanciado depois da requisição ser feita
	 * Já com a anotação @Singleton, MyResources é criado antes
	 * da requisição, o que gera um problema já que pathParamExample
	 *  e queryParamExample não terão um valor.
	 *  
	 *  
	 *  Como MyResource é instanciado após a requisição, os valores
	 *  de pathParam e query funcionam normalmente.
	 *  Ocorre um "match" de valores.
	 */
	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){	
		return "Isso funciona! Path=" + pathParamExample + " query=" + queryParamExample;
	}
	
}
