package com.managedBean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

import com.ServiciosBean.BeanFamilias;
import com.entidades.Familia;

@ManagedBean(name = "famiMB")
@SessionScoped
public class FamiliasMB implements Serializable {
	
	@EJB
	BeanFamilias bFamilias;

	private ArrayList<SelectItem> combo = null;

	private static final long serialVersionUID = 1L;

	public ArrayList<SelectItem> getCombo(){

		if (combo == null) {

			combo = new ArrayList<>();

			for (Familia f : bFamilias.obtenerTodos()) {
				SelectItem s = new SelectItem(f.getFami_Nombre());
				combo.add(s);
			}
		}

		return combo;
	}

	public void setCombo(ArrayList<SelectItem> combo) {
		this.combo = combo;
	}

}
