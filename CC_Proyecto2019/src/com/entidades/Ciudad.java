package com.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ciudad
 *
 */
@Entity
@Table(name = "CIUDADES")
public class Ciudad implements Serializable {

	   
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE)
	@Column(name= "CIU_ID")
	private Long ciu_id;
	
	@Column(nullable = false, name= "CIU_NOMBRE")
	private String ciu_nombre;
	
	private static final long serialVersionUID = 1L;

	public Ciudad() {
		super();
	}   
	public Long getCiu_id() {
		return this.ciu_id;
	}

	public void setCiu_id(Long ciu_id) {
		this.ciu_id = ciu_id;
	}   
	public String getCiu_nombre() {
		return this.ciu_nombre;
	}

	public void setCiu_nombre(String ciu_nombre) {
		this.ciu_nombre = ciu_nombre;
	}
	@Override
	public String toString() {
		return "Ciudad [ciu_id=" + ciu_id + ", ciu_nombre=" + ciu_nombre + "]";
	}
	
	
   
}
