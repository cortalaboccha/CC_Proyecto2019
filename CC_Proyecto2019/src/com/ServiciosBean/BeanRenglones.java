package com.ServiciosBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.RenglonPedido;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class BeanRenglones
 */
@Stateless
@LocalBean
public class BeanRenglones {

	
    /**
     * Default constructor. 
     */
    public BeanRenglones() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    
    
	public void crearRenglonPedido(RenglonPedido renglonPedido) throws ServiciosException {
		try {System.out.println("holaMundo");
				em.persist(renglonPedido);			
					em.flush();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo crear el renglon pedido");}
		}
    
    
	public RenglonPedido buscarRPedido(String renPed_nro) throws ServiciosException {
		try {
			return em.find(RenglonPedido.class, renPed_nro);
		} catch (PersistenceException e) {
			throw new ServiciosException("No existe el Renglonde Pedido con ID:" +  renPed_nro);
		}
	}
 
	
 	public List<RenglonPedido> obtenerTodos() {
 		TypedQuery<RenglonPedido> query = em.createQuery("SELECT r FROM RenglonPedido	r", RenglonPedido.class);
 		return query.getResultList();
 	}


}
