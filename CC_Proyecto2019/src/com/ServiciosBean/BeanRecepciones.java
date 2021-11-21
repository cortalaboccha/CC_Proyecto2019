package com.ServiciosBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


import com.entidades.Recepcion;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class RecepcionesBean
 */
@Stateless
@LocalBean
public class BeanRecepciones {

    /**
     * Default constructor. 
     */
    public BeanRecepciones() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext
    private EntityManager em;
    
    
    
	public void crear(Recepcion recepcion) throws ServiciosException {
		try {
			em.persist(recepcion);
			em.flush();
		}catch(PersistenceException e) {
			throw new ServiciosException("no se pudo crear recepcion");
		}
		
	}
	
	

	
	public void actualizar(Recepcion recepcion) throws ServiciosException {
		try {
			em.merge(recepcion);
			em.flush();
		}catch(PersistenceException e) {
			e.getMessage();
		}
		
		
	}

	
	public void borrar(long id) throws ServiciosException {
		Recepcion recepcion = em.find(Recepcion.class, id);
		em.remove(recepcion);
		
	}
	
	public Recepcion buscarRecepcion(Long rec_codigo) throws ServiciosException {
		Recepcion recepcion= em.find(Recepcion.class, rec_codigo);
		return recepcion;
	}
	
	public List<Recepcion> obtenerTodas() {
 		TypedQuery<Recepcion> query = em.createQuery("SELECT r FROM Recepcion	r", Recepcion.class);
 		return query.getResultList();
 	}
	
	public Recepcion obtenerPorCodi(Long filtro) {
		TypedQuery<Recepcion> query = em
				.createQuery("SELECT r FROM Recepcion r WHERE r.rec_codigo LIKE :rec_codigo", Recepcion.class)
				.setParameter("rec_codigo", filtro);
		return query.getSingleResult();
	}


}
