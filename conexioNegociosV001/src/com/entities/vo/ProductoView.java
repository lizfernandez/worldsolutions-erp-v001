package com.entities.vo;


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
	     
	    private List<Productos> cars;
	         
	    @ManagedProperty("#{carService}")
	    private ProductoService service;
	     
	    @PostConstruct
	    public void init() {
	        cars = service.createCars(100);
	    }
	 
	    public List<Productos> getCars() {
	        return cars;
	    }
	 
	    public void setService(ProductoService service) {
	        this.service = service;
	    }
}
