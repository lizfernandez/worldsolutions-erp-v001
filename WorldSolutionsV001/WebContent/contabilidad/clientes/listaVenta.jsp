
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
	   if(per.equals("6113")){%>
        <td><button  class="button" onclick="popup('venta.do?metodo=mantenimientoVenta&mode=F',580,470)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("6115")){%>
        <td><button class="button" onclick="fn_exportarExcel('contabilidad.do?metodo=exportarExcel&plantilla=contabilidad-venta')">
                <span class="excel">Exportar</span>
            </button>
        </td>
        <% break;}}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Ventas</caption>
        <!-- tr>
            <th width="5%" >Nombre Venta:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        
          
	         
         
        <th align="center">Operaciones</th>              
        <th align="left">Cliente</th>
        <th align="left">TIPO DOC.</th>
	    <th align="left">N&deg; DE DOC.</th>
	    <th align="left">Forma pago</th>
	    <th align="left">Fecha Emisi&oacute;n</th>
	    <th align="right">Valor Venta</th>
	    <th align="right">IGV <bean:write name="contabilidadForm" property="igvActual"/> %</th>
	    <th align="right">Total</th>
	    <th align="left">Usuario</th>
        <th align="left">Est. Doc.</th>
   
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="contabilidadForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n de contabilidads</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="contabilidadForm" property="lista">
	    <logic:iterate name="contabilidadForm" property="lista" id="x">	
			<tr>
			 
				<td align="center">
				<%
					for (String per: listapermiso) {
					if(per!=null){
					if(per.equals("6112")){%>
				<img title="Ver" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('venta.do?metodo=mantenimientoVenta&mode=U&id=<bean:write name="x" property="iVentaId" />&idTipoDocumento=<bean:write name="x" property="tipoDocumento.iTipoDocumentoGestionId" />',1120,620)" />
		        <% break;}}}%> 
		        </td>
		 	 	<td><bean:write name="x" property="cliente.vClienteRazonSocial" /></td>
				<td><bean:write name="x" property="tipoDocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="nVentaNumero" /></td>
				<td><bean:write name="x" property="formaPago.vFormaPagoDescripcion" /></td>
				<td><bean:write name="x" property="dVentaFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="fVentaSubTotal" format="#,##0.00" locale="Localidad" /></td>
				<td align="right"><bean:write name="x" property="fVentaIGV" format="#,##0.00" locale="Localidad" /></td>
				<td align="right"><bean:write name="x" property="fVentaTotal" format="#,##0.00" locale="Localidad" /></td>
				<td><bean:write name="x" property="usuario.personal.vPersonalNombres" /></td>					
				<td><bean:write name="x" property="vEstadoDocumento" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
		  <tr>
		  <td colspan="6"></td>
		   <td align="right"><strong>Total:</strong></td>
		  <td align="right"><strong><bean:write name="contabilidadForm" property="subTotalCompraVenta" format="#,##0.00" locale="Localidad" /></strong></td>
		  <td align="right"><strong><bean:write name="contabilidadForm" property="igvCompraVenta" format="#,##0.00" locale="Localidad" /></strong></td>
		  <td align="right"><strong><bean:write name="contabilidadForm" property="totalCompraVenta" format="#,##0.00" locale="Localidad" /></strong></td>
		  <td colspan="2"></td>
		  </tr>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="contabilidadForm" property="paginas">	
    <bean:size id="listSizes" name="contabilidadForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="contabilidadForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="contabilidadForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#contabilidad").addClass("active");
$("#clientes").children('li').show();
$("#ventas").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#ventas").children('a').css("color","#D0D2D7");

 </script> 
 