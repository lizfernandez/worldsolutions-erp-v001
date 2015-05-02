
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formPersonal">
    <tr>
	    <td align="right">Nro. Documento:</td>
	    <td>   
	        <html:text property="nVentaNumero"  styleId="nVentaNumero"  onkeyup="return mayuscula('nVentaNumero')" size="15"  styleClass="text"/>
	        
	    </td>
       <td align="right">Cliente:</td>
	   <td><html:text property="vClienteRazonSocial" styleId="vClienteRazonSocial"  size="50"  onkeyup="return mayuscula('vClienteRazonSocial')" styleClass="text"/>
	        
	    </td>
	    <td rowspan="2"><button  class="button"  onclick="buscarPopup('tab-grupo')">
                <span class="find">Buscar</span>
            </button>
        </td>
	 </tr>
	 <tr>
	    <td align="right">Fecha Emisi&oacute;n Inicio :</td>
	    <td>   
	        <html:text property="dVentaFecha"  styleId="dVentaFecha"  size="15" maxlength="11" styleClass="text"/>
	        
	    </td>
       <td align="right">Fecha Emisi&oacute;n Fin:</td>
	   <td><html:text property="dVentaFechaFin" styleId="dVentaFechaFin"   size="15" maxlength="11" styleClass="text"/>
	        
	    </td>
	    
	 </tr>

<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaVenta" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Listado de Ventas</caption>
        <!-- tr>
            <th width="5%" >Apellidos Personal:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
        -->
    <thead>
    <tr>
        <th align="left">Cliente</th>
        <th align="left">Tipo Documento</th>
	    <th align="left">Nro. Documento</th>
	    <th align="left">Forma pago</th>
	    <th align="left">Fecha Emisi&oacute;n</th>
	    <th align="right">Monto Total</th>
	    <th align="left">Estado Documento</th>
        
      </tr>
    </thead>
    <tbody>
	    <logic:empty name="ventaForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n de ventas</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="ventaForm" property="lista">
	    <logic:iterate name="ventaForm" property="lista" id="x">	
			<tr onclick="fn_cargarVenta(<bean:write name="x" property="iVentaId" />,'<bean:write name="x" property="dVentaFecha"  format="dd/MM/yyyy"/>','<bean:write name="x" property="vEstadoDocumento" />','<logic:notEmpty name="x" property="cliente.direccionclientes"><logic:iterate name="x" property="cliente.direccionclientes" id="z"><logic:equal name="z"  property="vPrincipal" value="1"><bean:write name="z" property="vDireccion" /></logic:equal></logic:iterate></logic:notEmpty>')">
				<td><bean:write name="x" property="cliente.vClienteRazonSocial" /></td>
				<td><bean:write name="x" property="tipoDocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="nVentaNumero" /></td>
				<td><bean:write name="x" property="formaPago.vFormaPagoDescripcion" /></td>
				<td><bean:write name="x" property="dVentaFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="fVentaTotal" locale="Localidad" /></td>				
				<td><bean:write name="x" property="vEstadoDocumento" /></td>
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
$("#dVentaFecha,#dVentaFechaFin").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            maxDate: '+0d'
    })
 function fn_cargarVenta(id,fecha,EstadoDocumento,Direccion){    
         var cad = "venta.do?metodo=detalleVenta&id="+id+"&mode=ID";
        if(EstadoDocumento=='DEVOLUCION PARCIAL' || EstadoDocumento=='DEVOLUCION TOTAL'){
        	alert("La compra seleccionada ya registra como devuelto, Seleccione otra compra!!");
        }else{        	       
         $.getJSON(cad, function retorna(obj){
        	// alert("obje"+obj.cProductoCodigo);
        	 
        	 if($("#mode").val()=='LP'){
        		 listar_detalleVentaDevolucion(obj, "padre",fecha,Direccion);
        	   }
        	   
        	   if($("#mode").val()=='LPL'){
          	     listar_ventaLetra(obj,fecha);
          	   }
        });
         
        } 
 }
 
 
 </script>  