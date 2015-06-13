
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
            
        <!-- td> 
          <select id="iclasificacionId" name="iclasificacionId" class="text" style="width: 150px">
                <option value="1">PRODUCTOS</option>
                <option value="2">MATERIAS PRIMAS</option>
                <option value="3">SUMINISTROS Y REPUESTOS</option>
                <option value="4">ENVASES Y EMBALAJES</option>
               
           </select >
        </td-->
        <td> 
          <!-- select id="selTipoDocumento" name="selTipoDocumento" class="text" style="width: 150px">
                <option value="1">FACTURA</option>
                <option value="2">BOLETA</option>
                <!-- option value="3">NOTA DE DEBITO</option> -->
                <!-- option value="4">GUIA DE REMISI&Oacute;N</option>
                <!--<option value="5">PEDIDO</option> -->
           <!-- /select-->
        </td>
        <% 
	   for (String per: listapermiso) {
			if(per!=null){
	   if(per.equals("1311")){%>
        <td><button  class="button" onclick="fn_nuevoDocumento()">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <!-- td><button  class="button" onclick="eliminar('tabla','','ingresoProducto.do?metodo=iduIngresoproducto&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td> -->
         <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("1313")){%>
        <td><button  class="button" onclick="popup('ingresoProducto.do?metodo=mantenimientoOrdenCompra&mode=F',580,470)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("1315")){%>
        <td><button class="button" onclick="fn_exportarExcel('ingresoProducto.do?metodo=exportarExcel&plantilla=compra')">
                <span class="excel">Exportar</span>
            </button>
        </td>
        <% break;}}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Compras</caption>
        <!-- tr>
            <th width="5%" >Nombre IngresoProducto:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        
          
	         
        <th colspan="1"width="5%" >Ope.</th>       
        <th align="left">Proveedor</th>
        <th align="left">Tipo Documento</th>
	    <th align="left">Nro. Documento</th>
	    
	    <th align="left">Fecha Emisi&oacute;n</th>
	    <th align="right">Monto Total</th>
	    <th align="left">Usuario</th>
        <th align="left">Estado Documento</th>
   
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="ingresoProductoForm" property="lista">
				<tr>
					<td colspan="13">No hay informaci&oacute;n de ingresoProductos</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="ingresoProductoForm" property="lista">
	    <logic:iterate name="ingresoProductoForm" property="lista" id="x">	
			<tr>
				<!-- td align="center"><input type="checkbox" id="<bean:write name="x" property="iOrdenCompraId" />"/></td--> 
				<td align="center">
				<%
					for (String per: listapermiso) {
					if(per!=null){
					if(per.equals("1312")){%>
				<img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('ingresoProducto.do?metodo=mantenimientoOrdenCompra&mode=U&id=<bean:write name="x" property="iOrdenCompraId" />&idTipoDocumento=<bean:write name="x" property="tipoDocumento.iTipoDocumentoGestionId" />',1150,500)" />
		           <% break;}}}%> 
		           </td>
		 	    <!--  td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iOrdenCompraId" />','ingresoProducto.do?metodo=iduIngresoproducto&mode=D')" /></td-->	
				<td><bean:write name="x" property="proveedor.vProveedorRazonSocial" /></td>
				<td><bean:write name="x" property="tipoDocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="vNroOrden" /></td>
				
				<td><bean:write name="x" property="dFechaPedido"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="fTotal" format="#,##0.00" locale="Localidad" /></td>
				<td><bean:write name="x" property="usuario.personal.vPersonalNombres" /></td>					
				<td><bean:write name="x" property="vEstadoDocumento" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="ingresoProductoForm" property="paginas">	
    <bean:size id="listSizes" name="ingresoProductoForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="ingresoProductoForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="ingresoProductoForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp; </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();

$("#inventario, #ordenCompra").addClass("active");
function fn_nuevoDocumento(){
	var tipoDoc= 2;//$("#selTipoDocumento").val();
	var iclasificacionId= 1;//$("#iclasificacionId").val();
	popup("ingresoProducto.do?metodo=mantenimientoOrdenCompra&mode=I&idTipoDocumento="+tipoDoc+"&iclasificacionId="+iclasificacionId,1150,700);
}
 </script> 
 