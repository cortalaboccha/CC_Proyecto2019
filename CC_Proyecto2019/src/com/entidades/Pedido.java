package com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity
@Table(name = "PEDIDOS")
public class Pedido implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name= "PED_ID")
	private long ped_id;
	
	@Column (nullable= false, length= 1, name= "PED_ESTADO")
	private char ped_estado;
	
	@Column (nullable= false, name= "PED_FEC_ESTIM_ENT")
	private Date ped_fechEstimEnt;
	
	@Column (nullable= false, name= "PED_FEC_ESTIM_REC")
	private Date ped_fechEstimRec;
	
	@Column (nullable= false, name= "PED_FECHA")
	private Date ped_fecha;
	private static final long serialVersionUID = 1L;

	public Pedido() {
		super();
	}   
	public long getPed_id() {
		return this.ped_id;
	}

	public void setPed_id(long ped_id) {
		this.ped_id = ped_id;
	}   
	public char getPed_estado() {
		return this.ped_estado;
	}

	public void setPed_estado(char ped_estado) {
		this.ped_estado = ped_estado;
	}   
	public Date getPed_fechEstimEnt() {
		return this.ped_fechEstimEnt;
	}

	public void setPed_fechEstimEnt(Date ped_fechEstimEnt) {
		this.ped_fechEstimEnt = ped_fechEstimEnt;
	}   
	public Date getPed_fechEstimRec() {
		return this.ped_fechEstimRec;
	}

	public void setPed_fechEstimRec(Date ped_fechEstimRec) {
		this.ped_fechEstimRec = ped_fechEstimRec;
	}   
	public Date getPed_fecha() {
		return this.ped_fecha;
	}

	public void setPed_fecha(Date ped_fecha) {
		this.ped_fecha = ped_fecha;
	}
	@Override
	public String toString() {
		return "Pedido [ped_id=" + ped_id + ", ped_estado=" + ped_estado + ", ped_fechEstimEnt=" + ped_fechEstimEnt
				+ ", ped_fechEstimRec=" + ped_fechEstimRec + ", ped_fecha=" + ped_fecha + "]";
	}
   
	
}
