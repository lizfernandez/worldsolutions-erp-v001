package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.vo.UnidadmedidaVo;



/**
 * The persistent class for the unidadmedida database table.
 * 
 */
@Entity
@Table(name="unidadmedida")
public class Unidadmedida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int iUnidadMedidaId;

	@Column(nullable=false, length=2)
	private String cEstadoCodigo;

	@Column(nullable=false, length=5)
	private String cUnidadMedidaCodigo;

	@Column(nullable=false, length=45)
	private String vUnidadMedidaDescripcion;

	//bi-directional many-to-one association to Producto
//	@OneToMany(mappedBy="unidadmedida")
//	private List<Producto> productos;

    public Unidadmedida() {
    }

	public Unidadmedida(UnidadmedidaVo unidadMedida) {
		
		this.iUnidadMedidaId = unidadMedida.getiUnidadMedidaId();
		this.cEstadoCodigo = unidadMedida.getcEstadoCodigo();
		this.cUnidadMedidaCodigo = unidadMedida.getcUnidadMedidaCodigo();
		this.vUnidadMedidaDescripcion = unidadMedida.getvUnidadMedidaDescripcion();
	}

	public int getiUnidadMedidaId() {
		return iUnidadMedidaId;
	}

	public void setiUnidadMedidaId(int iUnidadMedidaId) {
		this.iUnidadMedidaId = iUnidadMedidaId;
	}

	public String getcEstadoCodigo() {
		return cEstadoCodigo;
	}

	public void setcEstadoCodigo(String cEstadoCodigo) {
		this.cEstadoCodigo = cEstadoCodigo;
	}

	public String getcUnidadMedidaCodigo() {
		return cUnidadMedidaCodigo;
	}

	public void setcUnidadMedidaCodigo(String cUnidadMedidaCodigo) {
		this.cUnidadMedidaCodigo = cUnidadMedidaCodigo;
	}

	public String getvUnidadMedidaDescripcion() {
		return vUnidadMedidaDescripcion;
	}

	public void setvUnidadMedidaDescripcion(String vUnidadMedidaDescripcion) {
		this.vUnidadMedidaDescripcion = vUnidadMedidaDescripcion;
	}

	/*public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
*/
	
	
}