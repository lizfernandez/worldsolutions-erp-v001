<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 

List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
//if(listapermiso!=null){
	
	
%> 
<table border="0">
     <tr>
      <% 
	   for (String per: listapermiso) {
			if(per!=null){
	   if(per.equals("1151")){%>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&iclasificacionId=3&mode=I',450,520)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <% break; }}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("1154")){%>
        <td><button  class="button" onclick="eliminar('tabla','','productos.do?metodo=iduProducto&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <% break;}}}
	   for (String per: listapermiso) {
			if(per!=null){
	   if(per.equals("1153")){%>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&mode=F&iclasificacionId=3',450,510)">
                <span class="find">Buscar</span>
            </button>
        </td>
         <% break;}}}
	   for (String per: listapermiso) {
			if(per!=null){
	   if(per.equals("1155")){%>
        <td><button class="button" onclick="fn_exportarExcel('productos.do?metodo=exportarExcel&plantilla=suministros')">
                <span class="excel">Exportar</span>
            </button>
        </td>
        <% break;}}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Suministros y repuestos </caption>
    <thead>
     <tr>
        <th colspan="3">Operaciones</th>
        <th align="left">C&oacute;digo</th>
        <th width="23%" align="left">Nombre</th>
        <th align="left">Cantidad</th>
        <th align="left">Capacidad</th>
        <th align="left">Precio Compra</th>
        <th align="left">Stock Min</th>
        <th align="left">Stock Max</th>        
        <th align="left">Estado</th>
      </tr>
    </thead>
    <tbody>
    
<logic:empty name="productosForm" property="produc">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del Insumo</td>
			</tr>
</logic:empty>
<logic:notEmpty name="productosForm" property="produc"> 
	<logic:iterate name="productosForm" property="produc" id="x">
	
	<tr>
	    <td align="center"><input type="checkbox" id="<bean:write name="x" property="iProductoId" />"/></td> 
		<td align="center">
		<%
				for (String per: listapermiso) {
		if(per!=null){
		if(per.equals("1152")){%>
		<img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('productos.do?metodo=mantenimientoProducto&iclasificacionId=3&mode=U&id=<bean:write name="x" property="iProductoId" />',450,520)" />  
		 <% break; }}}%>
		</td>
		<td align="center">
		<%
				for (String per: listapermiso) {
		if(per!=null){
		if(per.equals("1154")){%>
		<img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iProductoId" />','productos.do?metodo=iduProducto&mode=D')" />
		<%break; }}}%>
		</td>	
		
		<td><bean:write name="x" property="cProductoCodigo" /></td>
		<td><bean:write name="x" property="vProductoNombre" /></td>
		<td>
		    <bean:write name="x" property="iProductoStockCantidad" />
		    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
		</td>
		<td>
			<bean:write name="x" property="vProductoCapacidad" />
			<bean:write name="x" property="vUnidadMedidaDescripcionC" />
	    </td>
	    <td><bean:write name="x" property="fProductoPrecioCompra" /></td>
	    <td><bean:write name="x" property="iProductoStockMinimo" /></td>
		<td><bean:write name="x" property="iProductoStockMaximo" /></td>
		<td><bean:write name="x" property="cEstadoCodigo" /></td>
	   

	</tr>
	</logic:iterate>
</logic:notEmpty>

<!-- ?php }$i++; endforeach;?>
<?php endif;?> -->
 
</tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="productosForm" property="paginas">	
    <bean:size id="listSizes" name="productosForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="productosForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="productosForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#inventario, #suministros").addClass("active");
</script> 
 
