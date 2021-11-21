package com.wsRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ServiciosBean.BeanFamilias;
import com.entidades.Familia;
import com.exception.ServiciosException;



@Path("familiaProd")
public class FamiliaProdRest {
	
	@EJB
	BeanFamilias BeanFamilias;
	
	@GET
	@Path("listarFamilias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Familia> getFamiTodas() {
		List<Familia> familias= BeanFamilias.obtenerTodos();
		
		return familias;
	}

	

	@GET
	@Path("{nomFami}")
	@Produces(MediaType.APPLICATION_JSON)
	public Familia getFami(@PathParam("nomFami") String nomFami) {
		Familia familia= BeanFamilias.obtenerPorNomb(nomFami);
		System.out.println(familia.toString());
		
		return familia;
	}
	
	@GET
	@Path("{codFami}/id")
	@Produces(MediaType.APPLICATION_JSON)
	public Familia getFamiCodi(@PathParam("codFami") String codFami) throws ServiciosException {
		Familia familia= BeanFamilias.buscarFamilia(codFami);
		
		return familia;
	}

}
