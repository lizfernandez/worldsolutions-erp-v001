
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="ingresoProducto" styleId="formPersonal">
    <tr>
	    <td align="right">Nro. Documento:</td>
	    <td>   
	        <html:text property="nIngresoProductoNumero"  styleId="nIngresoProductoNumero"  onkeyup="return mayuscula('nIngresoProductoNumero')" onkeypress="return LetrasNumeros(event)" styleClass="text"/>
	        
	    </td>
       <td align="right">Proveedor:</td>
	   <td><html:text property="vProveedorRazonSocial" styleId="vProveedorRazonSocial"   onkeyup="return mayuscula('vProveedorRazonSocial')" onkeypress="return LetrasNumeros(event)" styleClass="text"/>
	        
	    </td>
	    <td rowspan="2"><button  class="button"  onclick="buscarPopup('tab-grupo')">
                <span class="find">Buscar</span>
            </button>
        </td>
	 </tr>
	 <tr>
	    <td align="right">Fecha Emisi&oacute;n Inicio :</td>
	    <td>   
	        <html:text property="dIngresoProductoFecha"  styleId="dIngresoProductoFecha"  size="11" maxlength="11" styleClass="text"/>
	        
	    </td>
       <td align="right">Fecha Emisi&oacute;n Fin:</td>
	   <td><html:text property="dIngresoProductoFechaFin" styleId="dIngresoProductoFechaFin"   size="11" maxlength="11" styleClass="text"/>
	        
	    </td>
	    
	 </tr>

<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaIngresoproducto" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Listado de compras</caption>
        <!-- tr>
            <th width="5%" >Apellidos Personal:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
        -->
    <thead>
    <tr>
        <th align="left">Proveedor</th>
        <th align="left">Tipo Documento</th>
	    <th align="left">Nro. Documento</th>
	    <th align="left">Forma pago</th>
	    <th align="left">Fecha Emisi&oacute;n</th>
	    <th align="right">Monto Total</th>
	    <th align="left">Estado Documento</th>
        
      </tr>
    </thead>
    <tbody>
	    <logic:empty name="ingresoProductoForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n de ingresoProductos</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="ingresoProductoForm" property="lista">
	    <logic:iterate name="ingresoProductoForm" property="lista" id="x">	
			<tr onclick="fn_cargarCompra(<bean:write name="x" property="iIngresoProductoId" />,'<bean:write name="x" property="dIngresoProductoFecha"  format="dd/MM/yyyy"/>','<bean:write name="x" property="vEstadoDocumento" />')">
				<td><bean:write name="x" property="proveedor.vProveedorRazonSocial" /></td>
				<td><bean:write name="x" property="tipodocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="nIngresoProductoNumero" /></td>
				<td><bean:write name="x" property="formaPago.vFormaPagoDescripcion" /></td>
				<td><bean:write name="x" property="dIngresoProductoFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="fIngresoProductoTotal" format="#,##0.00" locale="Localidad" /></td>				
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
<input  type="hidden" id="mode" value="<bean:write name="ingresoProductoForm" property="mode"/>" />	  
</div>  
<script>   
paginacion();
$("#dIngresoProductoFecha,#dIngresoProductoFechaFin").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            maxDate: '+0d'
    });
 function fn_cargarCompra(id,fecha,EstadoDocumento){  
	
		var cad = "ingresoProducto.do?metodo=detalleIngresoProducto&id="+id+"&mode=ID";
        if(EstadoDocumento=='DEVOLUCION PARCIAL' || EstadoDocumento=='DEVOLUCION TOTAL'){
        	alert("La compra seleccionada ya registra como devuelto, Seleccione otra compra!!");
        }else{ 
           $.getJSON(cad, function retorna(obj){       
        	   if($("#mode").val()=='LP'){
        	     listar_detalleCompraDevolucion(obj, "padre",fecha);
        	   }
        	   
        	   if($("#mode").val()=='LPL'){
          	     listar_compraLetra(obj,fecha);
          	   }
             });
	  }
	
         
 }
 
 
 </script>  