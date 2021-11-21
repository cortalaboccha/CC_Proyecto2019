package com.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: renglonPedido
 *
 */
@Entity
@Table(name = "RENGLONESPEDIDOS")
public class RenglonPedido implements Serializable {

	   
	@Id
	@Column(nullable= false, name= "RENPED_NRO")
	private String renPed_nro;
	
	@Column (nullable= false, name= "RENPED_CANT")
	private long renPed_cant;
	
	@ManyToOne(fetch= FetchType.EAGER, optional= false)
	@JoinColumn(name= "PROD_ID")
	private Producto producto;
	
	@ManyToOne(fetch= FetchType.EAGER, optional= false)
	@JoinColumn(name= "PED_ID")
	private Pedido pedido;
	private static final long serialVersionUID = 1L;

	public RenglonPedido() {
		super();
	}   
	public String getRenPed_nro() {
		return this.renPed_nro;
	}

	public void setRenPed_nro(String renPed_nro) {
		this.renPed_nro = renPed_nro;
	}   
	public long getRenPed_cant() {
		return this.renPed_cant;
	}

	public void setRenPed_cant(long renPed_cant) {
		this.renPed_cant = renPed_cant;
	}
	public Producto getProd_Id() {
		return producto;
	}
	public void setProd_Id(Producto producto) {
		this.producto = producto;
	}
	public Pedido getPed_Id() {
		return pedido;
	}
	public void setPed_Id(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		return "RenglonPedido [renPed_nro=" + renPed_nro + ", renPed_cant=" + renPed_cant + ", producto=" + producto
				+ ", pedido=" + pedido + "]";
	}   
	
   
}
