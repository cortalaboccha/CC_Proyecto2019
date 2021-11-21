package com.managedBean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.ServiciosBean.BeanAlmacenamientos;
import com.entidades.Almacenamiento;

@SuppressWarnings("deprecation")
@ManagedBean(name ="almMB")
@SessionScoped
public class AlmacenamientoMB implements Serializable{
	
	ArrayList<SelectItem> combo;
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	BeanAlmacenamientos bAlm;

	public ArrayList<SelectItem> getCombo(){

		if (combo == null) {

			combo = new ArrayList<>();
		
			for (Almacenamiento a: bAlm.obtenerTodos()) {
				SelectItem s = new SelectItem(a.getAlma_Id());
				System.out.println(a.getAlma_Id());
				combo.add(s);
			}
		}

		return combo;
	}

	public void setCombo(ArrayList<SelectItem> combo) {
		this.combo = combo;
	}


}
