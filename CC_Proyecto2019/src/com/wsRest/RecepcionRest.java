package com.wsRest;



import java.text.DateFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ServiciosBean.BeanRecepciones;
import com.entidades.Producto;
import com.entidades.Recepcion;
import com.exception.ServiciosException;


@Path("recepcion")
public class RecepcionRest {
	
	@EJB
	BeanRecepciones BeanRecepciones;
	
	@GET
	@Path("/todas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recepcion> getTodas() {
		
		List<Recepcion> lista= null;
		lista= BeanRecepciones.obtenerTodas();
		
		return lista;

	}

	
	@POST
	@Path("/{id}/borrar")
	@Produces(MediaType.APPLICATION_JSON)
	public void borrar(@PathParam("id") Long id) {
		
		try {
			BeanRecepciones.borrar(id);
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@GET
	@Path("/{id}/traer")
	@Produces(MediaType.APPLICATION_JSON)
	public Recepcion buscarR(@PathParam("id") Long id) {
		Recepcion r;			
			
			r = BeanRecepciones.obtenerPorCodi(id);
			System.out.println(r.toString());
			System.out.println(r.getRec_comentario());
		
		
		return r;
		
	}
	
	@GET
	@Path("/{id}/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public Recepcion buscar(@PathParam("id") Long id) {
		Recepcion r;
		
		try {
			
			
			r = BeanRecepciones.buscarRecepcion(id);
			System.out.println(r.toString());
			System.out.println(r.getRec_comentario());
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void crearRec(Recepcion r) {
		try {
			BeanRecepciones.crear(r);
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizarRec(Recepcion r){
		
		try {
			BeanRecepciones.actualizar(r);
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
