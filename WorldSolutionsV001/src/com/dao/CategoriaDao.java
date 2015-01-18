package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import com.entities.Categoria;
import com.entities.Subcategoria;
import com.interfaces.dao.ICategoriaDao;
import com.util.Constantes;

public class CategoriaDao  extends GenericaDao implements ICategoriaDao {
	
	public List<Categoria> listaCategoria(Categoria categoria) {

		String where = "";

		if (categoria.getcEstadoCodigo() == null) {
			where += " where c.cEstadoCodigo LIKE '%" + Constantes.estadoActivo + "%'";
		}
		if (categoria.getClasificacionCategoria() != null) {
			where += " and c.clasificacionCategoria.iClasificacionId  LIKE '%" + categoria.getClasificacionCategoria().getiClasificacionId() + "%'";
		}
		
		Query q = getInstancia().createQuery(
				"select c from Categoria c " + where);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Categoria> listaCategoria = q.getResultList();
		
        return listaCategoria;
	}
	@Override
	public List<Categoria> listaCategoria(int pagInicio, int pagFin, Categoria categoria) {
		String q ;
		List<Categoria> listaCategoria = null ;
		String where="";
    	
		if(categoria!=null){
			if(categoria.getcEstadoCodigo()==null){
	        	where+= " where p.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        } else {
	        	where+= " where p.cEstadoCodigo LIKE '%"+categoria.getcEstadoCodigo()+"%'";
	        }
	        if(categoria.getcCategoriaCodigo()!=null){
	        	where+=" and  p.cCategoriaCodigo LIKE '%"+categoria.getcCategoriaCodigo()+"%'";
	        }
	        if(categoria.getvCategoriaDescripcion()!=null){
	        	where+=" and  p.vCategoriaDescripcion LIKE '%"+categoria.getvCategoriaDescripcion()+"%'";
	        }
	        if(categoria.getClasificacionCategoria()!=null && categoria.getClasificacionCategoria().getiClasificacionId() > 0){
	        	where+=" and  p.clasificacionCategoria.iClasificacionId = "+categoria.getClasificacionCategoria().getiClasificacionId();
	        }
	        System.out.println(" where ="+ where);
	    	    q = "select p from Categoria p " + where+ " order by p.clasificacionCategoria.iClasificacionId";/**/
	    	    listaCategoria = listaEntidadPaginada(q, pagInicio, pagFin); 

			
		}// lista con busqueda
		else{
				listaCategoria = listaEntidadGenerica(categoria);
				
		 
		}//else , lista simple	        
 			
		
        return listaCategoria;
	}

	@Override
	public List<Subcategoria> listaSubcategoria(int pagInicio, int pagFin,
			Subcategoria subCategoria) {

		String where="";
		if (subCategoria != null) {
			if(subCategoria.getcEstadoCodigo()==null){
	        	where+= " where c.cEstadoCodigo LIKE '%"+Constantes.estadoActivo+"%'";
	        } else {
	        	where+= " where c.cEstadoCodigo LIKE '%"+subCategoria.getcEstadoCodigo()+"%'";
	        }
			if(subCategoria.getcSubCategoriaCodigo()!=null){
	        	where+= " and c.cSubCategoriaCodigo LIKE '%"+subCategoria.getcSubCategoriaCodigo()+"%'";
	        }
			if(subCategoria.getvSubCategoriaDescripcion()!=null){
	        	where+= " and c.vSubCategoriaDescripcion LIKE '%"+subCategoria.getvSubCategoriaDescripcion()+"%'";
	        }
		}
		Query q = getInstancia().createQuery("select c from Subcategoria c " + where);
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Subcategoria> listaCategoria = q.getResultList();

        return listaCategoria;
	}
	@Override
	public List<Subcategoria> listaSubcategoria(int iCategoriaId) {
		
		Query q = getInstancia().createQuery("select c from Subcategoria c where c.categoria.iCategoriaId="+iCategoriaId +" and c.cEstadoCodigo='AC'");
		q.setHint(QueryHints.REFRESH, HintValues.TRUE);
		List<Subcategoria> listaCategoria = q.getResultList();      
	
    return listaCategoria;
	}
}
