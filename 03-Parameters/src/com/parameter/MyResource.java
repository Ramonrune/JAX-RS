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
	 * N�o funciona se for uma singleton
	 * MyResource � instanciado depois da requisi��o ser feita
	 * J� com a anota��o @Singleton, MyResources � criado antes
	 * da requisi��o, o que gera um problema j� que pathParamExample
	 *  e queryParamExample n�o ter�o um valor.
	 *  
	 *  
	 *  Como MyResource � instanciado ap�s a requisi��o, os valores
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
