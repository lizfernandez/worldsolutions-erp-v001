
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('ingresoProducto.do?metodo=mantenimientoIngresoproductoDevolucion&mode=I',900,700)">
                <span class="new">Nuevo</span>
            </button>
        </td>        
        <td><button  class="button" onclick="popup('ingresoProducto.do?metodo=mantenimientoIngresoproductoDevolucion&mode=F',580,470)">
                <span class="find">Buscar</span>
            </button>
        <td><button class="button" onclick="fn_exportarExcel('ingresoProducto.do?metodo=exportarExcel&plantilla=compra-devolucion')">
                <span class="excel">Exportar</span>
            </button>
        </td>
        </td>        
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Listado de devoluci&oacute;n de Compras</caption>
        <!-- tr>
            <th width="5%" >Nombre IngresoProducto:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        
          
	         
        <th align="center">Operaciones</th>       
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
	    <logic:empty name="ingresoProductoForm" property="lista">
				<tr>
					<td colspan="12">No hay informaci&oacute;n de devoluci&oacute;n de compras</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="ingresoProductoForm" property="lista">
	    <logic:iterate name="ingresoProductoForm" property="lista" id="x">	
			<tr>
				
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('ingresoProducto.do?metodo=mantenimientoIngresoproductoDevolucion&mode=U&id=<bean:write name="x" property="iIngresoProductoDevolucionId" />',900,700)" /></td>
				<td><bean:write name="x" property="ingresoProducto.proveedor.vProveedorRazonSocial" /></td>
				<td><bean:write name="x" property="ingresoProducto.tipodocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="ingresoProducto.nIngresoProductoNumero" /></td>
				<td><bean:write name="x" property="ingresoProducto.formaPago.vFormaPagoDescripcion" /></td>
				<td><bean:write name="x" property="ingresoProducto.dIngresoProductoFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="ingresoProducto.fIngresoProductoTotal" format="#,##0.00" locale="Localidad" /></td>
				<td><bean:write name="x" property="dIngresoProductoDevFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="fIngresoProductoDev" format="#,##0.00" locale="Localidad" /></td>
				<td><bean:write name="x" property="ingresoProducto.usuario.personal.vPersonalNombres" /></td>					
				<td><bean:write name="x" property="ingresoProducto.vEstadoDocumento" /></td>
		 
				
		
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
$("#compra,#devolCompras").addClass("active");

 </script> 
 