
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
	   if(per.equals("5121")){%>
        <td><button  class="button" onclick="popup('venta.do?metodo=mantenimientoVentaDevolucion&mode=I',930,700)">
                <span class="new">Nuevo</span>
            </button>
        </td>  
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("5123")){%>      
        <td><button  class="button" onclick="popup('venta.do?metodo=mantenimientoVentaDevolucion&mode=F',580,470)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("5125")){%>
        <td><button class="button" onclick="fn_exportarExcel('venta.do?metodo=exportarExcel&plantilla=venta-devolucion')">
                <span class="excel">Exportar</span>
            </button>
        </td>    
        <% break;}}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Listado de devoluci&oacute;n de Ventas</caption>
        <!-- tr>
            <th width="5%" >Nombre Venta:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        
          
	         
        <th align="center">Ope.</th>       
        <th align="left">Proveedor</th>
        <th align="left">Tipo Documento</th>
	    <th align="left">Nro. Documento</th>
	    <th align="left">Nro. NotaCred.</th>
	    <th align="left">Forma pago</th>
	    <th align="left">Fecha Emisi&oacute;n</th>
	    <th align="right">Monto Total</th>
	    <th align="left">Fecha Dev.</th>	    
	    <th align="right">Monto Dev.</th>
	    <th align="left">Usuario</th>
        <th align="left">Estado Documento</th>
   
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="ventaForm" property="lista">
				<tr>
					<td colspan="12">No hay informaci&oacute;n de devoluci&oacute;n de Ventas</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="ventaForm" property="lista">
	    <logic:iterate name="ventaForm" property="lista" id="x">	
			<tr>
				
				<td align="center">
				<%
					for (String per: listapermiso) {
					if(per!=null){
					if(per.equals("5122")){%>
				<img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('venta.do?metodo=mantenimientoVentaDevolucion&mode=U&id=<bean:write name="x" property="iVentaDevolucionId" />',930,700)" />
		        <% break;}}}%>             
		        </td>
				<td><bean:write name="x" property="venta.cliente.vClienteRazonSocial" /></td>
				<td><bean:write name="x" property="venta.tipoDocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="venta.nVentaNumero" /></td>
				<td><bean:write name="x" property="nNroNotaCredito" /></td>
				<td><bean:write name="x" property="venta.formaPago.vFormaPagoDescripcion" /></td>
				<td><bean:write name="x" property="venta.dVentaFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="venta.fVentaTotal" format="#,##0.00" locale="Localidad" /></td>
				<td><bean:write name="x" property="dVentaDevFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="fVentaDevTotal" format="#,##0.00" locale="Localidad" /></td>
				<td><bean:write name="x" property="venta.usuario.personal.vPersonalNombres" /></td>					
				<td><bean:write name="x" property="venta.vEstadoDocumento" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="ventaForm" property="paginas">	
    <bean:size id="listSizes" name="ventaForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="ventaForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="ventaForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp; </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion(); 
$("#venta,#devolVentas").addClass("active");

 </script> 
 