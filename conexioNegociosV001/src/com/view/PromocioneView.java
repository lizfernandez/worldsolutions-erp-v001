package com.view;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


import com.entities.vo.PromocioneVo;
import com.service.PromocioneService;

@ManagedBean(name="promocioneView")
@ViewScoped
public class PromocioneView implements Serializable {
	     
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		private List<PromocioneVo> promociones;
		
	         
	    @ManagedProperty("#{promocioneService}")
	    private PromocioneService service;
	   
	    @PostConstruct
	    public void init() {
	    	promociones =  service.listaPromociones();
	    	System.out.println("promociones="+promociones.size());
	    }

		/**
		 * @return the promociones
		 */
		public List<PromocioneVo> getPromociones() {
			return promociones;
		}


		/**
		 * @param service the service to set
		 */
		public void setService(PromocioneService service) {
			this.service = service;
		}

		
	 
	   
}
