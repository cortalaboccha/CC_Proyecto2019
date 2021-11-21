package com.wsRest;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ServiciosBean.BeanRenglones;
import com.entidades.RenglonPedido;
import com.exception.ServiciosException;
@Path("renPedido")
public class RenPedidoRest {

	@EJB
	BeanRenglones bRen;

	@GET
	@Path("listarRenglones")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RenglonPedido> getRengTodos() throws NamingException {
		List<RenglonPedido> renglones = bRen.obtenerTodos();
		
		for (int i = 0; i < renglones.size(); i++) {
			
			return renglones;
			
			}

		return null;
	}

	@GET
	@Path("{nomReng}")
	@Produces(MediaType.APPLICATION_JSON)
	public RenglonPedido getReng(@PathParam("nomReng") String nomReng) throws NamingException, ServiciosException{
		
		RenglonPedido renglon = bRen.buscarRPedido(nomReng);
		System.out.println(renglon.getRenPed_nro());
		return renglon;
	}

}
