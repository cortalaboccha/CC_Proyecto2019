package com.ServiciosBean;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Familia;
import com.entidades.Producto;
import com.entidades.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class ProductosObtener
 */
@Stateless
@LocalBean
public class BeanProductos {

	/**
	 * Default constructor.
	 */
	public BeanProductos() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	private EntityManager em;

	public List<Producto> obtenerTodos() {
		TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto	p", Producto.class);
		return query.getResultList();
	}

	public Producto obtenerPorNomb(String filtro) {
		TypedQuery<Producto> query = em
				.createQuery("SELECT p FROM Producto p WHERE p.Prod_Nombre LIKE :Prod_Nombre", Producto.class)
				.setParameter("Prod_Nombre", filtro);
		return query.getSingleResult();
	}

	public void borrar(Long Prod_Id) throws ServiciosException {
		Producto producto = em.find(Producto.class, Prod_Id);
		em.remove(producto);
		em.flush();

	}

	public void crearProducto(Producto producto) {
		em.persist(producto);
		em.flush();
	}
	
	public void actualizar(Producto producto) throws ServiciosException {
		try {
			em.merge(producto);
			em.flush();
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
    }
	
	public Producto insertarProducto(Long prod_Vol, Long prod_Peso, String prod_Lote, Date prod_Fven, Date prod_Felab,
			String prod_Nombre, String prod_Estiba, String prod_Segmentac, Long prod_Stkmin, Long prod_Stktotal,
			Long prod_Precio, Familia familia) {
		Producto producto= new Producto();
		
		producto.setProd_Nombre(prod_Nombre);
		producto.setProd_Lote(prod_Lote);
		producto.setProd_Estiba(prod_Estiba);
		producto.setProd_Peso(prod_Peso);
		producto.setProd_Precio(prod_Precio);
		producto.setProd_Stktotal(prod_Stktotal);
		producto.setProd_Stkmin(prod_Stkmin);
		producto.setProd_Vol(prod_Vol);
		producto.setProd_Segmentac(prod_Segmentac);
		producto.setProd_Felab(prod_Felab);
		producto.setProd_Fven(prod_Fven);
		producto.setFamilia(familia);
		
		try {    		
    		
	    	em.persist(producto);    	
	    	em.flush();    	   	    
			
	    	}catch (PersistenceException e) {
	    		e.printStackTrace();
			}
		
	    	return producto;
		
    }

}
