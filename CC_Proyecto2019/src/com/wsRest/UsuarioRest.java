package com.wsRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ServiciosBean.BeanUsuarios;
import com.entidades.Usuario;

@Path("usuario")
public class UsuarioRest {
	
	
	
	@EJB
	BeanUsuarios BeanUsuarios;
	

	@GET
	@Path("{nomAcceso}/{contra}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("nomAcceso") String nomAcceso, @PathParam("contra") String contra){
		
		Usuario usu= BeanUsuarios.traerCuenta(nomAcceso, contra);
		return usu;
	}
	
	@GET
	@Path("{nomAcceso}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("nomAcceso") String nomAcceso){
		
		Usuario usu= BeanUsuarios.obtenerPorNomb(nomAcceso);
		System.out.println(usu.toString());
		return usu;
	}
	
	@GET
	@Path("/todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		
		List<Usuario> us= BeanUsuarios.obtenerTodos();
		
		return us;
		
	}

}
