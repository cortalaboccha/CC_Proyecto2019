package com.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Recepcion
 *
 */
@Entity
@Table(name = "RECEPCIONES")
public class Recepcion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable= false, name = "REC_CODIGO")
	private long rec_codigo;

	@Column(nullable = false, length= 30, name = "REC_FECHA")
	private Date rec_fecha;

	@Column(nullable = true, length = 200, name = "REC_COMENTARIO")
	private String rec_comentario;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "REN_PED")
	private RenglonPedido renglonPedido;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ALMA")
	private Almacenamiento almacenamiento;
	
	
	private static final long serialVersionUID = 1L;

	public Recepcion() {
		super();
	}

	public long getRec_codigo() {
		return this.rec_codigo;
	}

	public void setRec_codigo(long rec_codigo) {
		this.rec_codigo = rec_codigo;
	}

	public Date getRec_fecha() {
		return this.rec_fecha;
	}

	public void setRec_fecha(Date rec_fecha) {
		this.rec_fecha = rec_fecha;
	}

	public String getRec_comentario() {
		return this.rec_comentario;
	}

	public void setRec_comentario(String rec_comentario) {
		this.rec_comentario = rec_comentario;
	}

	public RenglonPedido getRenglonPedido() {
		return renglonPedido;
	}

	public void setRenglonPedido(RenglonPedido renglonPedido) {
		this.renglonPedido = renglonPedido;
	}

	public Almacenamiento getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(Almacenamiento almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	@Override
	public String toString() {
		return "Recepcion [rec_codigo=" + rec_codigo + ", rec_fecha=" + rec_fecha + ", rec_comentario=" + rec_comentario
				+ ", renglonPedido=" + renglonPedido + ", almacenamiento=" + almacenamiento + "]";
	}
	
	

}
