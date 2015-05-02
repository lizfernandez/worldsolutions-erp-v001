package com.interfaces.dao;

import java.util.List;
import com.entities.Categoria;
import com.entities.Subcategoria;


public interface ICategoriaDao {
	public List<Categoria> listaCategoria(Categoria categoria);
	public List<Categoria> listaCategoria(int pagInicio, int pagFin, Categoria categoria);
	public List<Subcategoria> listaSubcategoria(int pagInicio, int pagFin, Subcategoria subCategoria);
	public List<Subcategoria> listaSubcategoria(int iCategoriaId);
	/*public Categoria buscarCategoria(int iCategoriaId);
	public boolean insertarCategoria(Categoria categoria);
	public boolean actualizarCategoria(Categoria categoria);
	public boolean eliminarCategoria(String iCategoriaId);
*/
}
