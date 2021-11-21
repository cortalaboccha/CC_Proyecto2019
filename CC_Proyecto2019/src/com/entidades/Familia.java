package com.entidades;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Familia
 *
 */
@Entity
@Table(name = "FAMILIAS")
public class Familia implements Serializable {

	   
	@Id
	@Column(name= "FAMI_CODI")
	private Long Fami_Codi;
	
	@Column (nullable= false, length = 50, name= "FAMI_INCOMPAT")
	private String Fami_Incompat;
	
	@Column (nullable= false, length = 50, name= "FAMI_NOMBRE")
	private String Fami_Nombre;
	
	@Column (nullable= false, length = 50, name= "FAMI_DESCRIP")
	private String Fami_Descrip;
	private static final long serialVersionUID = 1L;

	public Familia() {
		super();
	}   
	public Long getFami_Codigo() {
		return this.Fami_Codi;
	}

	public void setFami_Codigo(Long Fami_Codi) {
		this.Fami_Codi = Fami_Codi;
	}   
	public String getFami_Incompat() {
		return this.Fami_Incompat;
	}

	public void setFami_Incompat(String Fami_Incompat) {
		this.Fami_Incompat = Fami_Incompat;
	}   
	public String getFami_Nombre() {
		return this.Fami_Nombre;
	}

	public void setFami_Nombre(String Fami_Nombre) {
		this.Fami_Nombre = Fami_Nombre;
	}   
	public String getFami_Descrip() {
		return this.Fami_Descrip;
	}

	public void setFami_Descrip(String Fami_Descrip) {
		this.Fami_Descrip = Fami_Descrip;
	}
	@Override
	public String toString() {
		return "Familia [Fami_Codigo=" + Fami_Codi + ", Fami_Incompat=" + Fami_Incompat + ", Fami_Nombre="
				+ Fami_Nombre + ", Fami_Descrip=" + Fami_Descrip + "]";
	}
	
	
   
}

