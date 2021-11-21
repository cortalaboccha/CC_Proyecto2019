package com.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

import com.ServiciosBean.BeanFamilias;
import com.ServiciosBean.BeanProductos;
import com.ServiciosBean.BeanUsuarios;
import com.entidades.Familia;
import com.entidades.Producto;
import com.entidades.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class ProductosMB
 */
@ManagedBean(name = "prodMB")
@SessionScoped
public class ProductosMB implements Serializable {
	
	@EJB
	BeanProductos bProductos;
	
	@EJB
	BeanFamilias bFamilias;
	
	@EJB
	BeanUsuarios bUsuarios;

	private ArrayList<SelectItem> combo = null;
	private String select;
	
	

	public String getSelect() {
		
		
		return select;
	}


	public void setSelect(String select) {
		this.select = select;
		
	}


	// Declaro los atributos a validar
	private static final long serialVersionUID = 1L;
	private Long Prod_Id;
	private Long Prod_Vol;
	private Long Prod_Peso;
	private String Prod_Lote;
	private Date Prod_Fven;
	private Date Prod_Felab;
	private String Prod_Nombre;
	private String Prod_Estiba;
	private String Prod_Segmentac;
	private Long Prod_Stkmin;
	private Long Prod_Stktotal;
	private Long Prod_Precio;
	private String familia;
	



	public ProductosMB() {
			

	}
	
	

	



	public ArrayList<SelectItem> getCombo() throws NamingException {

		if (combo == null || combo !=null) {

			combo = new ArrayList<>();
			
			

			for (Producto p : bProductos.obtenerTodos()) {
				SelectItem s = new SelectItem(p.getProd_Nombre());
				System.out.println(p.getProd_Nombre());
				combo.add(s);
			}
		}

		return combo;
	}

	public void setCombo(ArrayList<SelectItem> combo) {
		this.combo = combo;
	}

	public Long getProd_Id() {
		return Prod_Id;
	}

	public void setProd_Id(Long prod_Id) {
		Prod_Id = prod_Id;
	}

	public Long getProd_Vol() {

		//Prod_Vol = cargarDatos().getProd_Vol();

		return Prod_Vol;
	}

	public void setProd_Vol(Long prod_Vol) {
		Prod_Vol = prod_Vol;
	}

	public Long getProd_Peso() {

		//Prod_Peso= cargarDatos().getProd_Peso();

		return Prod_Peso;
	}

	public void setProd_Peso(Long prod_Peso) {
		Prod_Peso = prod_Peso;
	}

	public String getProd_Lote() {

		//Prod_Lote= cargarDatos().getProd_Lote();

		return Prod_Lote;
	}

	public void setProd_Lote(String prod_Lote) {
		Prod_Lote = prod_Lote;
	}

	public Date getProd_Fven() {

		//Prod_Fven= cargarDatos().getProd_Fven();

		return Prod_Fven;
	}

	public void setProd_Fven(Date prod_Fven) {
		Prod_Fven = prod_Fven;
	}

	public Date getProd_Felab() {

		//Prod_Felab= cargarDatos().getProd_Felab();

		return Prod_Felab;
	}

	public void setProd_Felab(Date prod_Felab) {
		Prod_Felab = prod_Felab;
	}

	public String getProd_Nombre() {

		//Prod_Nombre = cargarDatos().getProd_Nombre().toString();

		return Prod_Nombre;
	}

	public void setProd_Nombre(String prod_Nombre) {
		Prod_Nombre = prod_Nombre;

	}

	public String getProd_Estiba() {

		//Prod_Estiba= cargarDatos().getProd_Estiba();

		return Prod_Estiba;
	}

	public void setProd_Estiba(String prod_Estiba) {
		Prod_Estiba = prod_Estiba;
	}

	public String getProd_Segmentac() {

		//Prod_Segmentac= cargarDatos().getProd_Segmentac();

		return Prod_Segmentac;
	}

	public void setProd_Segmentac(String prod_Segmentac) {
		Prod_Segmentac = prod_Segmentac;
	}

	public Long getProd_Stkmin() {

		//Prod_Stkmin= cargarDatos().getProd_Stkmin();

		return Prod_Stkmin;
	}

	public void setProd_Stkmin(Long prod_Stkmin) {
		Prod_Stkmin = prod_Stkmin;
	}

	public Long getProd_Stktotal() {

		//Prod_Stktotal= cargarDatos().getProd_Stktotal();

		return Prod_Stktotal;
	}

	public void setProd_Stktotal(Long prod_Stktotal) {
		Prod_Stktotal = prod_Stktotal;
	}

	public Long getProd_Precio() {

		//Prod_Precio= cargarDatos().getProd_Precio();

		return Prod_Precio;
	}

	public void setProd_Precio(Long prod_Precio) {
		Prod_Precio = prod_Precio;
	}


	public String getFamilia() {

		//familia= cargarDatos().getFamilia().getFami_Nombre();

		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

		
	
	public void cargarDatos(){
		
		if(select.equals("--- Seleccionar ---")) {
			
			Prod_Nombre= null;
			Prod_Lote= null;
			Prod_Peso= null;
			Prod_Estiba= null;
			Prod_Felab= null;
			Prod_Fven= null;
			Prod_Id= null;
			Prod_Vol= null;
			Prod_Segmentac= null;
			Prod_Stkmin= null;
			Prod_Stktotal=null;
			Prod_Precio= null;
			familia= null;
			
		}else {
			
			Producto p= bProductos.obtenerPorNomb(select);
			
			Prod_Id= p.getProd_Id();
			Prod_Nombre= p.getProd_Nombre();
			Prod_Lote= p.getProd_Lote();
			Prod_Peso= p.getProd_Peso();
			Prod_Estiba= p.getProd_Estiba();
			Prod_Felab= p.getProd_Felab();
			Prod_Fven= p.getProd_Fven();
			Prod_Id= p.getProd_Id();
			Prod_Vol= p.getProd_Vol();
			Prod_Segmentac= p.getProd_Segmentac();
			Prod_Stkmin=p.getProd_Stkmin();
			Prod_Stktotal=p.getProd_Stktotal();
			Prod_Precio=p.getProd_Precio();
			familia=p.getFamilia().getFami_Nombre();
		}
	}

	


	
	public void registrar() throws NamingException {
		
		if(Prod_Fven.before(Prod_Felab)) {
			addMessage("Fecha de elaboración no puede ser mayor a la fecha de vencimiento!!");
		}else if(Prod_Stkmin > Prod_Stktotal){
			addMessage("El Stock mínimo no puede ser mayor al stock máximo!!");
		}else {
		
		Familia fa = bFamilias.obtenerPorNomb(familia);
		
		Long a= Prod_Vol;
		Long b= Prod_Peso;
		Long c= Prod_Stkmin;
		Long d= Prod_Stktotal;
		Long e= Prod_Precio;
		

		bProductos.insertarProducto(a, b, Prod_Lote, Prod_Fven, Prod_Felab, Prod_Nombre, Prod_Estiba, Prod_Segmentac, c, d, e, fa);
		addMessage("Producto ingresado correctamente!!");
		vaciarCampos();
		
	}
	}
	
	
	
public void modificar() throws NamingException, ServiciosException {
	
	if(Prod_Fven.before(Prod_Felab)) {
		addMessage("Fecha de elaboración no puede ser mayor a la fecha de vencimiento!!");
	}else if(Prod_Stkmin > Prod_Stktotal){
		addMessage("El Stock mínimo no puede ser mayor al stock máximo!!");
	}else {
		
		
		Familia fa = bFamilias.obtenerPorNomb(familia);
		
		
		Producto p= new Producto();
		
		p.setFamilia(fa);
		p.setProd_Estiba(Prod_Estiba);
		p.setProd_Felab(Prod_Felab);
		p.setProd_Fven(Prod_Fven);
		p.setProd_Lote(Prod_Lote);
		p.setProd_Nombre(Prod_Nombre);
		p.setProd_Peso(Prod_Peso);
		p.setProd_Precio(Prod_Precio);
		p.setProd_Segmentac(Prod_Segmentac);
		p.setProd_Stkmin(Prod_Stkmin);
		p.setProd_Stktotal(Prod_Stktotal);
		p.setProd_Vol(Prod_Vol);
		p.setProd_Id(Prod_Id);
		
		if(p != null) {
		
		bProductos.actualizar(p);
		addMessage("Producto modificado correctamente!!");
		vaciarCampos();
		}
	}
		
	}
	
	public void bajaProducto() throws ServiciosException{
		
		Producto pp= bProductos.obtenerPorNomb(select);
		
		
		bProductos.borrar(pp.getProd_Id());
		addMessage("Producto eliminado correctamente!!");
		vaciarCampos();
		
		
	}
	
	public void vaciarCampos() {
		
		select= null;
		Prod_Nombre= null;
		Prod_Lote= null;
		Prod_Peso= null;
		Prod_Estiba= null;
		Prod_Felab= null;
		Prod_Fven= null;
		Prod_Id= null;
		Prod_Vol= null;
		Prod_Segmentac= null;
		Prod_Stkmin= null;
		Prod_Stktotal=null;
		Prod_Precio= null;
		familia= null;
		
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage("Éxito!!", message);
    }
	
	
	

}
