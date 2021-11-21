package com.managedBean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

import org.primefaces.PrimeFaces; 

import com.ServiciosBean.BeanUsuarios;
import com.entidades.Usuario;

@ManagedBean(name = "usuario")
@SessionScoped
public class Validar implements Serializable {
	
	@EJB
	BeanUsuarios bUsuarios;
	
	private ArrayList<SelectItem> combo = null;

	// Declaro los atributos a validar
	private static final long serialVersionUID = 1L;
	public String nomAcceso;
	public String contra;

	
	
	
	
	public ArrayList<SelectItem> getCombo() throws NamingException {
		
		if (combo == null) {

			combo = new ArrayList<>();

			for (Usuario u : bUsuarios.obtenerTodos()) {
				SelectItem s = new SelectItem(u.getUsu_nomAcceso());
				System.out.println(u.getUsu_nomAcceso());
				combo.add(s);
			}
		}		
		
		return combo;
	}

	public void setCombo(ArrayList<SelectItem> combo) {
		this.combo = combo;
	}

	// Genero los getters y setters
	public String getNomAcceso() {
		return nomAcceso;
	}

	public void setNomAcceso(String nomAcceso) {
		this.nomAcceso = nomAcceso;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String validarUsuario(String nomAcceso, String contra){
		// Verifico que el usuario ingredado exista en la base
		Usuario usuarioAcc;
		System.out.println("------------------Datos del Usuario--------------");
		System.out.println("El usuario ingresado fue: " + nomAcceso);
		System.out.println("La password ingresada fue: " + contra);

		// Valido que el usuario ingresado exista en la base, de no ser asì mandamos
		// mensaje
		usuarioAcc = bUsuarios.traerCuenta(nomAcceso, contra);
		if (usuarioAcc == null) {
			System.out.println("MENSAJE AL USUARIO: El usuario ingresado no existe");
			showMessage();
		} else {
			if(usuarioAcc.getPerf_tipo().toString() == "ADMINISTRADOR") {
				return "Principal";
			}
			if(usuarioAcc.getPerf_tipo().toString() == "OPERARIO") {
				return "PantallaOperario";
			}
			System.out.println(usuarioAcc.getPerf_tipo().toString());
		}
		return null;
	

		
		
	}
	
	public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos Incorrectos", "Usuario/Contraseña son incorrectos");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
	
	
	public String cerrarSesion() {
		return "IniciarSesion";
		
	}

}