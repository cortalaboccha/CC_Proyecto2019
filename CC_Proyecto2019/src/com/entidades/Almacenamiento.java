package com.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Almacenamiento
 *
 */
@Entity
@Table(name = "ALMACENAMIENTOS")
public class Almacenamiento implements Serializable {

	   
	@Id
	@GeneratedValue (strategy= GenerationType.SEQUENCE)
	@Column(nullable = false, name= "ALMA_ID")
	private Long Alma_Id;
	
	@Column(nullable = false, name= "ALMA_VOLUMEN")	
	private Long alma_volumen;
	
	@Column(nullable = false, name= "ALMA_DESCRIPCION")
	private String descripcion;
	
	@Column(nullable = false, length= 10, name= "ALMA_COSTOOP")
	private Long alma_costoop;
	
	@Column(nullable = false, name= "ALMA_CAPESTIBA")
	private String alma_capEstiba;
	
	@Column(nullable = false, name= "ALMA_CAPPESO")
	private Long alma_capPeso;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name= "LOC_ID")
	private Local local;
	private static final long serialVersionUID = 1L;

	public Almacenamiento() {
		super();
	}   
	public Long getAlma_Id() {
		return this.Alma_Id;
	}

	public void setAlma_Id(Long Alma_Id) {
		this.Alma_Id = Alma_Id;
	}   
	public Long getAlma_volumen() {
		return this.alma_volumen;
	}

	public void setAlma_volumen(Long alma_volumen) {
		this.alma_volumen = alma_volumen;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Long getAlma_costoop() {
		return this.alma_costoop;
	}

	public void setAlma_costoop(Long alma_costoop) {
		this.alma_costoop = alma_costoop;
	}   
	public String getAlma_capEstiba() {
		return this.alma_capEstiba;
	}

	public void setAlma_capEstiba(String alma_capEstiba) {
		this.alma_capEstiba = alma_capEstiba;
	}   
	public Long getAlma_capPeso() {
		return this.alma_capPeso;
	}

	public void setAlma_capPeso(Long alma_capPeso) {
		this.alma_capPeso = alma_capPeso;
	}   
	public Local getLocal() {
		return this.local;
	}

	public void setLoc_id(Local local) {
		this.local = local;
	}
	@Override
	public String toString() {
		return "Almacenamiento [Alma_Id=" + Alma_Id + ", alma_volumen=" + alma_volumen + ", descripcion=" + descripcion
				+ ", alma_costoop=" + alma_costoop + ", alma_capEstiba=" + alma_capEstiba + ", alma_capPeso="
				+ alma_capPeso + ", local=" + local + "]";
	}
	
	
   
}
