package com.wsRest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ServiciosBean.BeanPedidos;
import com.entidades.Pedido;
import com.exception.ServiciosException;

@Path("pedido")
public class PedidoRest {
	
	@EJB
	BeanPedidos bp;
	
	@GET
	@Path("{nomPed}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pedido getPedido(@PathParam("nomPed") Long nomPed) throws ServiciosException {
		Pedido pedido= bp.buscarPedido(nomPed);
		System.out.println(pedido.toString());
		return pedido;
	}

}
