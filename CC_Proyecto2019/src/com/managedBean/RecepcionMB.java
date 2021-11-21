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

import com.ServiciosBean.BeanAlmacenamientos;
import com.ServiciosBean.BeanRecepciones;
import com.ServiciosBean.BeanRenglones;
import com.entidades.Almacenamiento;
import com.entidades.Recepcion;
import com.entidades.RenglonPedido;
import com.exception.ServiciosException;

@ManagedBean(name = "receMB")
@SessionScoped
public class RecepcionMB implements Serializable{
	
	@EJB
	BeanRecepciones bRecepciones;
	
	@EJB
	BeanAlmacenamientos bAlmacenamientos;
	
	@EJB
	BeanRenglones bRenglones;
	
	
	private ArrayList<SelectItem> combo;
	private Long select;
	
	
	
	
	public Long getSelect() {
		return select;
	}




	public void setSelect(Long select) {
		this.select = select;
	}




	public ArrayList<SelectItem> getCombo() throws NamingException {
		
		
		
		
		if (combo == null || combo !=null) {

			combo = new ArrayList<>();
			

			for (Recepcion r : bRecepciones.obtenerTodas()) {
				SelectItem s = new SelectItem(r.getRec_codigo());
				combo.add(s);
			}
		}
		
		
		
		return combo;
	}




	public void setCombo(ArrayList<SelectItem> combo) {
		this.combo = combo;
	}




	private Recepcion recepcion;
	
	private long codigo;
	private Date fecha;
	private String comentario;
	private String renglon;
	private Long alma;
	
	
	
	public long getCodigo() {
		return codigo;
	}




	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}




	public Date getFecha() {
		return fecha;
	}




	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	public String getComentario() {
		return comentario;
	}




	public void setComentario(String comentario) {
		this.comentario = comentario;
	}




	public String getRenglon() {
		return renglon;
	}




	public void setRenglon(String renglon) {
		this.renglon = renglon;
	}




	public Long getAlma() {
		return alma;
	}




	public void setAlma(Long alma) {
		this.alma = alma;
	}




	private static final long serialVersionUID = 1L;
	
public RecepcionMB (){
		
		if (recepcion == null){
			recepcion = new Recepcion();
		}
	}
	
	
	
	
	public Recepcion getRecepcion() {
		return recepcion;
	}




	public void setRecepcion(Recepcion recepcion) {
		this.recepcion = recepcion;
	}
	
	
	@SuppressWarnings("null")
	public void altaRecepcion() throws NamingException, ServiciosException {
		
		Long a= alma;
		
		
		Almacenamiento alm= bAlmacenamientos.buscarAlmacenamiento(a);
		
		
		RenglonPedido ren= bRenglones.buscarRPedido(renglon); 
			
		Recepcion r= new Recepcion();
		
		r.setAlmacenamiento(alm);
		r.setRec_comentario(comentario);
		r.setRec_fecha(fecha);
		r.setRenglonPedido(ren);
		
		
		bRecepciones.crear(r);
		addMessage("Recepción ingresada correctamente!!");
		vaciarCampos();
		
		
		
	}
	
	@SuppressWarnings("null")
	public void modificarRecepcion() throws NamingException, ServiciosException {
		
		Long a= alma;
		
		
		Almacenamiento alm= bAlmacenamientos.buscarAlmacenamiento(a);
		
		
		RenglonPedido ren= bRenglones.buscarRPedido(renglon); 
			
		Recepcion r= new Recepcion();
		
		r.setRec_codigo(codigo);
		r.setAlmacenamiento(alm);
		r.setRec_comentario(comentario);
		r.setRec_fecha(fecha);
		r.setRenglonPedido(ren);
		
		bRecepciones.actualizar(r);
		addMessage("Recepción modificada correctamente!!");
		vaciarCampos();
		
		
		
	}

	public void bajaRecepcion(Long id ) throws NamingException, ServiciosException {
		bRecepciones.borrar(id);
		addMessage("Recepción eliminada correctamente!!");
		vaciarCampos();
	}
	
	public void mostrarDatos() throws NamingException {
		try {
			Recepcion r= bRecepciones.buscarRecepcion(select);
			
			renglon= r.getRenglonPedido().getRenPed_nro();
			comentario= r.getRec_comentario();
			alma= r.getAlmacenamiento().getAlma_Id();
			fecha= r.getRec_fecha();
			codigo= r.getRec_codigo();
			
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void vaciarCampos() {
		renglon= null;
		comentario= null;
		alma= null;
		fecha=null;
		select= null;
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage("Éxito!!", message);
    }

}
