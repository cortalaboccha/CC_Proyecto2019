package com.ServiciosBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Usuario;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
@LocalBean
public class BeanUsuarios {

    /**
     * Default constructor. 
     */
    public BeanUsuarios() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
	private EntityManager em;
    
    public Usuario traerCuenta(String nomAcceso, String contra) {
		try {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.usu_nomAcceso LIKE:usu_nomAcceso  AND u.usu_contrasenia LIKE:usu_contrasenia", Usuario.class)
		.setParameter("usu_nomAcceso", nomAcceso)
		.setParameter("usu_contrasenia", contra);
		return query.getSingleResult();
		} catch(PersistenceException e) {
			e.printStackTrace();
		}
		return null;
	
	}
    
    public List<Usuario> obtenerTodos() {
 		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
 		return query.getResultList();
 	}
    
    public Usuario obtenerPorNomb(String filtro) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.usu_nomAcceso LIKE :usu_nomAcceso", Usuario.class).setParameter("usu_nomAcceso", filtro);
		return query.getSingleResult();
	}


}
