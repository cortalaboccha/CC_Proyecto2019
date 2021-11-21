package com.ServiciosBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Almacenamiento;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class BeanAlmacenamiento
 */
@Stateless
@LocalBean
public class BeanAlmacenamientos {

    /**
     * Default constructor. 
     */
    public BeanAlmacenamientos() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;

	
	public void crearAlmacenamiento(Almacenamiento almacenamiento) throws ServiciosException {
		try {
			em.persist(almacenamiento); // el metodo persist persiste la entidad en la base de datos, por lo que queda gestionada por el proveedor de persistencia mientras dure la transaccion
			em.flush();// fuerza un commit en la base de datos
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear almacenamiento");
		}
		
	}
	
	
	public void actualizar(Almacenamiento alma) throws ServiciosException {
		try {
			em.merge(alma); // hace un insert y un update en la base de datos (actualiza datos)
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el Almacenamiento");
		}

	}

	
	public List<Almacenamiento> obtenerTodos() {
		TypedQuery<Almacenamiento> query = em.createQuery("SELECT a FROM Almacenamiento	a", Almacenamiento.class);
		return query.getResultList();
	}

	
	public Almacenamiento buscarAlmacenamiento(Long Alma_id) throws ServiciosException {
		try {
			return em.find(Almacenamiento.class, Alma_id);
		} catch (PersistenceException e) {
			throw new ServiciosException("No existeel almacenamiento con ID:" +  Alma_id);
		}
	}

	
	public List<Almacenamiento> traerAlmacenamientos(Long rangoinicial, Long rangoFinal) throws ServiciosException {
		try{
			TypedQuery<Almacenamiento> query = em.createQuery("FROM Almacenamiento  WHERE Alma_Id BETWEEN Like: inicial AND Like: final", Almacenamiento.class)
		
				.setParameter("incial", rangoinicial)
				.setParameter("final", rangoFinal);
				return query.getResultList();
				
		}catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;

	}


}
