package com.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Local
 *
 */
@Entity
@Table(name= "LOCALES")
public class Local implements Serializable {

	@Id
	@Column(nullable = false, name= "LOC_ID")
	private Long loc_id;
	
	@Column(nullable = false, name= "LOC_DESCRIP")
	private String loc_descrip;
	
	@Column(nullable = false, name= "LOC_DIRECCION")
	private String loc_direccion;
	
	@Column(nullable = false, name= "LOC_TIPO")
	private String loc_tipo;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name= "CIU_ID")
	private Ciudad ciudad;
	private static final long serialVersionUID = 1L;

	public Local() {
		super();
	}   
	public Long getLoc_id() {
		return this.loc_id;
	}

	public void setLoc_id(Long loc_id) {
		this.loc_id = loc_id;
	}   
	public String getLoc_descrip() {
		return this.loc_descrip;
	}

	public void setLoc_descrip(String loc_descrip) {
		this.loc_descrip = loc_descrip;
	}   
	public String getLoc_direccion() {
		return this.loc_direccion;
	}

	public void setLoc_direccion(String loc_direccion) {
		this.loc_direccion = loc_direccion;
	}   
	public String getLoc_tipo() {
		return this.loc_tipo;
	}

	public void setLoc_tipo(String loc_tipo) {
		this.loc_tipo = loc_tipo;
	}   
	public Ciudad getCiu_id() {
		return this.ciudad;
	}

	public void setCiu_id(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Local [loc_id=" + loc_id + ", loc_descrip=" + loc_descrip + ", loc_direccion=" + loc_direccion
				+ ", loc_tipo=" + loc_tipo + ", ciudad=" + ciudad + "]";
	}
	
	
  
}
