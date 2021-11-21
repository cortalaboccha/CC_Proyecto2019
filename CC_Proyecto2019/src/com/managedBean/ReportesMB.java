package com.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

import com.ServiciosBean.BeanAlmacenamientos;
import com.entidades.Almacenamiento;
import com.exception.ServiciosException;

@ManagedBean(name = "reportes")
@SessionScoped
public class ReportesMB implements Serializable {

	@EJB
	BeanAlmacenamientos bAlmacenamientos;

	Almacenamiento alma = new Almacenamiento();

	public Almacenamiento getAlma() {
		return alma;
	}

	public void setAlma(Almacenamiento alma) {
		this.alma = alma;
	}

	ArrayList<SelectItem> cInicial;
	ArrayList<SelectItem> cFinal;
	private Long inicial;
	private Long finall;
	Almacenamiento uno;
	Almacenamiento dos;

	public ArrayList<SelectItem> getcInicial() throws NamingException {

		if (cInicial == null) {

			cInicial = new ArrayList<>();

			for (Almacenamiento a : bAlmacenamientos.obtenerTodos()) {
				SelectItem s = new SelectItem(a.getAlma_Id());
				cInicial.add(s);
			}
		}

		return cInicial;
	}

	public void setcInicial(ArrayList<SelectItem> cInicial) {
		this.cInicial = cInicial;
	}

	public Long getInicial() {
		return inicial;
	}

	public void setInicial(Long inicial) {
		this.inicial = inicial;
	}

	public Long getFinall() {
		return finall;
	}

	public void setFinall(Long finall) {
		this.finall = finall;
	}

	public ArrayList<SelectItem> getcFinal() throws NamingException {

		if (cFinal == null) {

			cFinal = new ArrayList<>();

			for (Almacenamiento a : bAlmacenamientos.obtenerTodos()) {
				SelectItem s = new SelectItem(a.getAlma_Id());
				cFinal.add(s);
			}
		}

		return cFinal;
	}

	public void setcFinal(ArrayList<SelectItem> cFinal) {
		this.cFinal = cFinal;
	}

	List<Almacenamiento> listalma = new ArrayList<>();
	List<Almacenamiento> rlist = new ArrayList<>();

	public List<Almacenamiento> getListalma() {
		return listalma;
	}

	public void setListalma(List<Almacenamiento> listalma) {
		this.listalma = listalma;
	}

	public List<Almacenamiento> getRlist() {
		return rlist;
	}

	public void setRlist(List<Almacenamiento> rlist) {
		this.rlist = rlist;
	}

	public List<Almacenamiento> ejecutar() throws NamingException, ServiciosException {
		
		Long id3 = inicial;
		Long id4 = finall;

		listalma = bAlmacenamientos.obtenerTodos();
		rlist = new ArrayList<>();

		List<Long> ids = new ArrayList<>();
		for (Long i = id3; i <= id4; i++) {
			ids.add(i);
		}

		for (Almacenamiento m : listalma) {
			Long id = m.getAlma_Id();
			if (ids.contains(id)) {

				rlist.add(m);

			}
		}

		System.out.println(rlist);
		return rlist;
	}

	public void limpiar() throws NamingException, ServiciosException {

		rlist = new ArrayList<>();
	}

}
