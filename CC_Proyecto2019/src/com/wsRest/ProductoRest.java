
package com.wsRest;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.wildfly.security.sasl.gs2.Gs2;

import com.ServiciosBean.BeanProductos;
import com.entidades.Producto;
import com.exception.ServiciosException;
import com.google.gson.Gson;

@Path("producto")
public class ProductoRest {
	
	@EJB
	BeanProductos pb;

	

	@GET
	@Path("/todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getProdTodos() {
		
		List<Producto> lista= null;
		lista= pb.obtenerTodos();
		
		return lista;

	}
	
	

	@GET
	@Path("{nomProd}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto getProd(@PathParam("nomProd") String nomProd) {
		Producto prod= pb.obtenerPorNomb(nomProd);
		System.out.println(prod.getProd_Fven());
		return prod;
	}
	
	
	@POST
	@Path("/{id}/borrar")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProd(@PathParam("id") Long id) {
		try {
			pb.borrar(id);
			return "borrado";
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
	public void crearProducto(Producto p) {
		
		//Gson gson = new Gson();
		//Producto p= gson.fromJson(dato, Producto.class);		
		pb.crearProducto(p);
	}
	
	@POST
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizarProducto(Producto p){
		
		//Gson gson = new Gson();
		//Producto p= gson.fromJson(dato, Producto.class);
		try {
			pb.actualizar(p);
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
