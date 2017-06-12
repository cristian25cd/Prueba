package test.java;

import java.net.URL;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import main.java.entities.*;
import main.java.rest.ClienteRest;

@RunWith(Arquillian.class)
public class ClienteRestT {


	@ArquillianResource
	URL deploymentUrl;


	@Deployment(testable=false)
	public static WebArchive createDeployment(){
		return ShrinkWrap.create(WebArchive.class, "Prueba.war")
				.addClasses(ClienteRest.class,
						Cliente.class,
						Tarjeta.class);

	}

	//Caso verdadero
	private Cliente ClienteCase1(){
		return new Cliente("pablo",1,"calle 2 # 111 - 40");
	}
	//Caso mismo id
	private Cliente ClienteCase2(){
		return new Cliente("juan",1,"calle 2 # 111 - 40");
	}
	//caso mismo nombre
	private Cliente ClienteCase3(){
		return new Cliente("pablo",2,"calle 2 # 111 - 40");
	}
	//Caso nombre no alfabetico
	private Cliente ClienteCase4(){
		return new Cliente("maria<4",4,"calle 2 # 111 - 40");
	}
	//Caso nombre mayor a 40 caracteres
	private Cliente ClienteCase5(){
		return new Cliente("Se encuentra en medio del desarrollo de una",5,"calle 2 # 111 - 40");
	}
	//Caso direccion menor a 50 caracteres
	private Cliente ClienteCase6(){
		return new Cliente("pablo",6,"Se encuentra en medio del desarrollo de una aplicacion Java EE");
	}

	//Caso base 
	private Tarjeta TarjetaCase1()
	{
		return new Tarjeta(1);
	}
	
	@Test
	@RunAsClient
	public void testNuevoUsuario(@ArquillianResteasyResource final WebTarget webTarget)
	{
		Cliente c = ClienteCase1();
		
		Response response = webTarget
		        .path("/cliente/nuevo")
		        .request(MediaType.APPLICATION_JSON)
		        .post(Entity.json(c));
		
		Assert.assertNotEquals("",response.getEntity().toString());

		c= ClienteCase2();
		response = webTarget
		        .path("/cliente/nuevo")
		        .request(MediaType.APPLICATION_JSON)
		        .post(Entity.json(c));
		Assert.assertEquals("", response.getEntity().toString());

		c= ClienteCase3();
		response = webTarget
		        .path("/cliente/nuevo")
		        .request(MediaType.APPLICATION_JSON)
		        .post(Entity.json(c));
		Assert.assertEquals("", response.getEntity().toString());

		c= ClienteCase4();
		response = webTarget
		        .path("/cliente/nuevo")
		        .request(MediaType.APPLICATION_JSON)
		        .post(Entity.json(c));
		Assert.assertEquals("", response.getEntity().toString());

		c= ClienteCase5();
		response = webTarget
		        .path("/cliente/nuevo")
		        .request(MediaType.APPLICATION_JSON)
		        .post(Entity.json(c));
		Assert.assertEquals("", response.getEntity().toString());

		c= ClienteCase6();
		response = webTarget
		        .path("/cliente/nuevo")
		        .request(MediaType.APPLICATION_JSON)
		        .post(Entity.json(c));
		Assert.assertEquals("", response.getEntity().toString());

	}

//	@Test
//	public void testAgregarTarjeta(@ArquillianResteasyResource ClienteRest rest)
//			throws Exception {
//		Tarjeta t = TarjetaCase1();
//		
//	}

}
