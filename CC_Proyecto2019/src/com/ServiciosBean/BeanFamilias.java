package com.ServiciosBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Familia;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class FamiliaBean
 */
@Stateless
@LocalBean
public class BeanFamilias {

    /**
     * Default constructor. 
     */
    public BeanFamilias() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    
    public Familia obtenerPorNomb(String filtro) {
		TypedQuery<Familia> query = em
				.createQuery("SELECT f FROM Familia f WHERE f.Fami_Nombre LIKE :Fami_Nombre", Familia.class)
				.setParameter("Fami_Nombre", filtro);
		return query.getSingleResult();
	}

	// Metodo para listar todas las familias
	
	public List<Familia> obtenerTodos() {
		TypedQuery<Familia> query = em.createQuery("SELECT f FROM Familia	f", Familia.class);
		return query.getResultList();
	}
	
	public Familia buscarFamilia(String Fami_Codigo) throws ServiciosException {
		try {
			return em.find(Familia.class, Fami_Codigo);
		} catch (PersistenceException e) {
			throw new ServiciosException("No existe la familia con ID:" + Fami_Codigo);
		}
	}

}
