package com.managedBean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

import com.ServiciosBean.BeanRenglones;
import com.entidades.RenglonPedido;

@ManagedBean(name ="renMB")
@SessionScoped
public class RenPedidoMB implements Serializable{
	
	@EJB
	BeanRenglones bRenglones;
	
	ArrayList<SelectItem> combo;
	
	private static final long serialVersionUID = 1L;

	public ArrayList<SelectItem> getCombo() throws NamingException {

		if (combo == null) {

			combo = new ArrayList<>();

			for (RenglonPedido rp : bRenglones.obtenerTodos()) {
				SelectItem s = new SelectItem(rp.getRenPed_nro());
				combo.add(s);
			}
		}

		return combo;
	}

	public void setCombo(ArrayList<SelectItem> combo) {
		this.combo = combo;
	}


}
