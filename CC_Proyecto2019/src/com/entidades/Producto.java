package com.entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column (nullable= false, length= 38)
	private Long Prod_Id;
	
	@Column (nullable= false)
	private Long Prod_Vol;
	
	@Column (nullable= false)
	private Long Prod_Peso;
	
	@Column (nullable= false, length = 50)
	private String Prod_Lote;
	
	
	@Column (nullable= false)
	private Date Prod_Fven;
	
	
	@Column (nullable= false)
	private Date Prod_Felab;
	
	@Column (nullable= false, length = 50)
	private String Prod_Nombre;
	
	@Column (nullable= false, length = 50)
	private String Prod_Estiba;
	
	@Column (nullable= false, length = 50)
	private String Prod_Segmentac;
	
	@Column (nullable= false)
	private Long Prod_Stkmin;
	
	@Column (nullable= false)
	private Long Prod_Stktotal;
	
	@Column (nullable= false)
	private Long Prod_Precio;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name= "FAMI_CODI")
	private Familia familia;
	private static final long serialVersionUID = 1L;
	

	public Producto() {
		super();
	}   
	
	public Long getProd_Id() {
		return this.Prod_Id;
	}

	public void setProd_Id(Long Prod_Id) {
		this.Prod_Id = Prod_Id;
	}   
	public Long getProd_Vol() {
		return this.Prod_Vol;
	}

	public void setProd_Vol(Long Prod_Vol) {
		this.Prod_Vol = Prod_Vol;
	}   
	public Long getProd_Peso() {
		return this.Prod_Peso;
	}

	public void setProd_Peso(Long Prod_Peso) {
		this.Prod_Peso = Prod_Peso;
	}   
	public String getProd_Lote() {
		return this.Prod_Lote;
	}

	public void setProd_Lote(String Prod_Lote) {
		this.Prod_Lote = Prod_Lote;
	}   
	public Date getProd_Fven() {
		return this.Prod_Fven;
	}

	public void setProd_Fven(Date Prod_Fven) {
		this.Prod_Fven = Prod_Fven;
	}   
	public Date getProd_Felab() {
		return this.Prod_Felab;
	}

	public void setProd_Felab(Date Prod_Felab) {
		this.Prod_Felab = Prod_Felab;
	}   
	public String getProd_Nombre() {
		return this.Prod_Nombre;
	}

	public void setProd_Nombre(String Prod_Nombre) {
		this.Prod_Nombre = Prod_Nombre;
	}   
	public String getProd_Estiba() {
		return this.Prod_Estiba;
	}

	public void setProd_Estiba(String Prod_Estiba) {
		this.Prod_Estiba = Prod_Estiba;
	}   
	public String getProd_Segmentac() {
		return this.Prod_Segmentac;
	}

	public void setProd_Segmentac(String Prod_Segmentac) {
		this.Prod_Segmentac = Prod_Segmentac;
	}   
	public Long getProd_Stkmin() {
		return this.Prod_Stkmin;
	}

	public void setProd_Stkmin(Long Prod_Stkmin) {
		this.Prod_Stkmin = Prod_Stkmin;
	}   
	public Long getProd_Stktotal() {
		return this.Prod_Stktotal;
	}

	public void setProd_Stktotal(Long Prod_Stktotal) {
		this.Prod_Stktotal = Prod_Stktotal;
	}   
	public Long getProd_Precio() {
		return this.Prod_Precio;
	}

	public void setProd_Precio(Long Prod_Precio) {
		this.Prod_Precio = Prod_Precio;
	}
	
	
	public Familia getFamilia() {
		return familia;
	}
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Override
	public String toString() {
		return "Producto [Prod_Id=" + Prod_Id + ", Prod_Vol=" + Prod_Vol + ", Prod_Peso=" + Prod_Peso + ", Prod_Lote="
				+ Prod_Lote + ", Prod_Fven=" + Prod_Fven + ", Prod_Felab=" + Prod_Felab + ", Prod_Nombre=" + Prod_Nombre
				+ ", Prod_Estiba=" + Prod_Estiba + ", Prod_Segmentac=" + Prod_Segmentac + ", Prod_Stkmin=" + Prod_Stkmin
				+ ", Prod_Stktotal=" + Prod_Stktotal + ", Prod_Precio=" + Prod_Precio + ", familia=" + familia + "]";
	}
	
	
	
	
   
}

