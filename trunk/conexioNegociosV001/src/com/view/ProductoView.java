package com.view;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


import com.entitie.Productos;
import com.service.ProductoService;

@ManagedBean
@ViewScoped
public class ProductoView implements Serializable {
	     
	  
	   private static final long serialVersionUID = 1L;

		private List<Productos> listaProductos;
	         
	    @ManagedProperty("#{carService}")
	    private ProductoService service;
	     
	    @PostConstruct
	    public void init() {
	        listaProductos = service.createCars(100);
	    }
	 
	    public List<Productos> getProductos() {
	        return listaProductos;
	    }
	 
	    public void setService(ProductoService service) {
	        this.service = service;
	    }
}
