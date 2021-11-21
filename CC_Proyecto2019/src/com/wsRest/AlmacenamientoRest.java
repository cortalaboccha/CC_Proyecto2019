package com.wsRest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ServiciosBean.BeanAlmacenamientos;
import com.entidades.Almacenamiento;
import com.exception.ServiciosException;

@Path("alm")
public class AlmacenamientoRest {
	
	@EJB
	BeanAlmacenamientos bAlm;
	
	@GET
	@Path("/listarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Almacenamiento> getAlmacenamientos() throws NamingException {
		List<Almacenamiento> almacenamientos= bAlm.obtenerTodos();	
		return almacenamientos;
	}

	

	@GET
	@Path("{almaCodigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Almacenamiento getAlma(@PathParam("almaCodigo") Long codigo) throws ServiciosException, NamingException {
		
		Almacenamiento almacenamiento= bAlm.buscarAlmacenamiento(codigo);
		return almacenamiento;
	}
	
	@GET
	 @Path("/{id1}/{id2}")
	 @Produces({ MediaType.APPLICATION_JSON})
	 public List<Almacenamiento> getAlmacenamientos (@PathParam ("id1") String id1, @PathParam ("id2") String id2 ) throws ServiciosException {
			List<Almacenamiento> listalma = new ArrayList<>();
			List<Almacenamiento> rlist = new ArrayList<>();
			Long id3 = Long.parseLong(id1);
			Long id4 = Long.parseLong(id2);
			System.out.println("pi"+id1);
			System.out.println("pf" +id2);
		listalma = bAlm.obtenerTodos();
		
		List<Long> ids = new ArrayList<>();
		for (Long i = id3; i <= id4; i++) {
			ids.add(i);
		}
		
		for(Almacenamiento m : listalma) {
			Long id = m.getAlma_Id();
			if (ids.contains(id)) {
				rlist.add(m);
			}
						
			
		}
		
		return rlist;
		}


}
