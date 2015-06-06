
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
    <!-- tr>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoDistAlmacen&mode=I',430,500)">
                <span class="new">Agregar Producto al Inventarios</span></button>
        <select id="selTipo" name="selTipo">
                <option value="1">DISTRIBUCION</option>
                <option value="2">PRODUCIDO</option>
            </select>
        </td>
    </tr> -->
     <tr>
         <% 
	   for (String per: listapermiso) {
			if(per!=null){
	   if(per.equals("1311")){%>
        <td><button  class="button" onclick="nuevoEntrada()">
                <span class="new">Entrada</span>
            </button>
        </td>
        <% break; }}}
         for (String per: listapermiso) {
 			if(per!=null){
 	   if(per.equals("1311")){%>
         <td><button  class="button" onclick="nuevoSalida()">
                 <span class="new">Salida</span>
             </button>
         </td>
         <% break; }}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("1314")){%>
        <td><button  class="button" onclick="eliminar('tabla','','productos.do?metodo=iduDistAlmacen&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
         <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("1313")){%>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoDistAlmacen&mode=F&iclasificacionId=1',470,580)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("1315")){%>
        <td><button class="button" onclick="fn_exportarExcel('productos.do?metodo=exportarExcel&plantilla=producto')">
                <span class="excel">Exportar</span>
            </button>
        </td>
        <% break;}}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Productos </caption>
    <thead>
     <tr>
        <th colspan="3" width="5%">Operaciones</th>
        <th align="left">C&oacute;digo</th>
        <th width="20%" align="left">Tipo Operacion</th>
        <th width="20%" align="left">Almacen Salida</th>
        <th align="left">Almacen Entrada</th>
        <th align="left" width="8%" >Fecha Salida</th>
        <th align="left" width="8%" >Fecha Recepcion</th>        
        <th align="left">Estado</th>
      </tr>
    </thead>
    <tbody>
    
<logic:empty name="productosForm" property="produc">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del producto</td>
			</tr>
</logic:empty>
<logic:notEmpty name="productosForm" property="produc">
      
	<logic:iterate name="productosForm" property="produc" id="x">
	
	<tr>
	    <td align="center"><input type="checkbox" id="<bean:write name="x" property="iDistAlmacenId" />"/></td> 
		<td align="center">
		<%
		for (String per: listapermiso) {
		if(per!=null){
		if(per.equals("1312")){%>
		<img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('productos.do?metodo=mantenimientoDistAlmacen&mode=UE&iclasificacionId=1&id=<bean:write name="x" property="iDistAlmacenId" />',700,635)" />
         <% break; }}}%>
        </td>
		<td align="center">
		<%
		for (String per: listapermiso) {
		if(per!=null){
		if(per.equals("1314")){%>
		<img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iDistAlmacenId" />','productos.do?metodo=iduDistAlmacen&mode=D')" />
		<%break; }}}%>
		</td>	
		<logic:equal name="x" property="vTipoOperacion" value="S">
		<td><bean:write name="x" property="vNroSalida" /></td>
		<td>SALIDA</td>
		</logic:equal>
		<logic:equal name="x" property="vTipoOperacion" value="E">
		<td><bean:write name="x" property="vNroIngreso" /></td>
		<td>ENTRADA</td>
		</logic:equal>
		
	    <td><bean:write name="x" property="almacenSalida.vAlmacenNombre" /></td>
		<td><bean:write name="x" property="almacenEntrada.vAlmacenNombre" /></td>
		<td><bean:write name="x" property="dFechaSalida"  format="dd/MM/yyyy"/></td>
		<td><bean:write name="x" property="dFechaIngreso"  format="dd/MM/yyyy"/></td>
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
$("#inventario, #distAlmacen").addClass("active");
function nuevoEntrada(){
	popup('productos.do?metodo=mantenimientoDistAlmacen&mode=IE',700,635);
}
function nuevoSalida(){
	popup('productos.do?metodo=mantenimientoDistAlmacen&mode=IS',700,635);
}
</script> 