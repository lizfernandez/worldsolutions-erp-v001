
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('venta.do?metodo=mantenimientoVentaDevolucion&mode=I',900,700)">
                <span class="new">Nuevo</span>
            </button>
        </td>        
        <td><button  class="button" onclick="popup('venta.do?metodo=mantenimientoVentaDevolucion&mode=F',500,380)">
                <span class="find">Buscar</span>
            </button>
        </td>        
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
        
          
	         
        <th colspan="2" >Operaciones</th>       
        <th align="left">Proveedor</th>
        <th align="left">Tipo Documento</th>
	    <th align="left">Nro. Documento</th>
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
				
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('venta.do?metodo=mantenimientoVentaDevolucion&mode=U&id=<bean:write name="x" property="iVentaDevolucionId" />',900,700)" /></td>
				<td align="center">
			        <img  onclick="fn_reporteVenta('',1080,830)"
			                   src="${pageContext.request.contextPath}/media/imagenes/paste.png"  border="0" width="27%" title="Imprimir Venta"/>
			    </td>
				<td><bean:write name="x" property="venta.cliente.vClienteRazonSocial" /></td>
				<td><bean:write name="x" property="venta.tipoDocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="venta.nVentaNumero" /></td>
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
 