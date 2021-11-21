package com.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.enumerados.Perfil;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

	   
	@Id
	@Column(name= "USU_CODIGO")
	private String usu_codigo;
	
	@Column (nullable= false, length= 50, name= "USU_NOMBRE")
	private String usu_nombre;
	
	@Column (nullable= false, length= 50, name= "USU_APELLIDO")
	private String usu_apellido;
	
	@Column (nullable= false, length= 50, name= "USU_NOMACCESO")
	private String usu_nomAcceso;
	
	@Column (nullable= false, length= 16, name= "USU_CONTRASEÑA")
	private String usu_contrasenia;
	
	@Column (nullable= false, length= 50, name= "USU_CORREO")
	private String usu_correo;
	
	@Enumerated(EnumType.STRING)
	@JoinColumn(name= "PERF_TIPO")
	private Perfil perf_tipo;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public String getUsu_codigo() {
		return this.usu_codigo;
	}

	public void setUsu_codigo(String usu_codigo) {
		this.usu_codigo = usu_codigo;
	}   
	public String getUsu_nombre() {
		return this.usu_nombre;
	}

	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}   
	public String getUsu_apellido() {
		return this.usu_apellido;
	}

	public void setUsu_apellido(String usu_apellido) {
		this.usu_apellido = usu_apellido;
	}   
	public String getUsu_nomAcceso() {
		return this.usu_nomAcceso;
	}

	public void setUsu_nomAcceso(String usu_nomAcceso) {
		this.usu_nomAcceso = usu_nomAcceso;
	}   
	public String getUsu_contrasenia() {
		return this.usu_contrasenia;
	}

	public void setUsu_contrasenia(String usu_contrasenia) {
		this.usu_contrasenia = usu_contrasenia;
	}   
	public String getUsu_correo() {
		return this.usu_correo;
	}

	public void setUsu_correo(String usu_correo) {
		this.usu_correo = usu_correo;
	}   
	public Perfil getPerf_tipo() {
		return this.perf_tipo;
	}

	public void setPerf_tipo(Perfil perf_tipo) {
		this.perf_tipo = perf_tipo;
	}
	@Override
	public String toString() {
		return "Usuario [usu_codigo=" + usu_codigo + ", usu_nombre=" + usu_nombre + ", usu_apellido=" + usu_apellido
				+ ", usu_nomAcceso=" + usu_nomAcceso + ", usu_contrasenia=" + usu_contrasenia + ", usu_correo="
				+ usu_correo + ", perf_tipo=" + perf_tipo + "]";
	}
	
	
   
}
