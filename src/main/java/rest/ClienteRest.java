package main.java.rest;

import main.java.entities.Cliente;
import main.java.entities.Tarjeta;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/cliente")
public class ClienteRest {

	@POST
	@Path("/nuevo")
	@Produces(MediaType.APPLICATION_JSON)
  public Response nuevoCliente(Cliente c)
  {
		String result = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("putty_buddy");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			em.persist(c);
			tx.commit();
			result = "1";
		} catch (Exception e) {
			result = "-1";
		} finally {
			em.close();
			emf.close();
			return Response.status(201).entity(result.equals("1") ? c.getName() : "").build();
		}

  }
	@POST
	@Path("{id}/asignarTarjeta")
	@Produces(MediaType.APPLICATION_JSON)
  public Response asignarTarjeta(Tarjeta t)
  {
		
  }


}