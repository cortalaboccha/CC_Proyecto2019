package com.ServiciosBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Pedido;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class BeanPedidos
 */
@Stateless
@LocalBean
public class BeanPedidos {

    /**
     * Default constructor. 
     */
    public BeanPedidos() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;


	
	public void actualizar(Pedido pedido) throws ServiciosException {
		try {
			em.merge(pedido);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("no se pudo actualizar pedido");
		}

	}

	
	
	public Pedido buscarPedido(Long ped_id) throws ServiciosException {
			try{
				return em.find(Pedido.class, ped_id);
			}catch (PersistenceException e) {
				e.printStackTrace();
			}
			return null;
	}


	public List<Pedido> obtenerTodos() {
		TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido	p", Pedido.class);
		return query.getResultList();
	}
}
