
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formVenta" enctype="echarset=utf-8">

	<tr>
		<td align="center">
			<table class="tabla" border="0" width="100%" id="tabla">
			    
			    <thead>
			    	<tr>
			    		<th align="right">FECHA</th>
			    		<td align="center" colspan="3"><bean:write name="ventaForm" property="fechaArqueo"/></td> 
			    	</tr>
			    	<tr>
			    		<th align="right">SUCURSAL</th>
			    		<td align="center" colspan="3"><bean:write name="ventaForm" property="nombreSucursal"/></td>
			    	</tr>
			    	<tr>
			    		<th colspan="4" align="center">VENTAS Y SERVICIOS</th>
			    	</tr>
			    	<tr>
			        	<th align="center" width="30%">DOCUMENTO</th>
			        	<th align="right">TOTAL PRODUCTOS</th>
			        	<th align="right">TOTAL SERVICIO</th>
			        	<th align="right">TOTAL VENTA</th>
			           
			      	</tr>
			    </thead>
			    <tbody>
				     <logic:empty name="ventaForm" property="lista">
							<tr>
								<td colspan="4">No hay informaci&oacute;n de Servicios ejecutados en hasta la fecha</td>
							</tr>
				     </logic:empty>
			         <logic:notEmpty name="ventaForm" property="lista">
				         <logic:iterate name="ventaForm" property="lista" id="x">
				         	<tr>
				         		<td align="center"><bean:write name="x" property="tipoDocumento"/></td>
				         		<td align="right"><bean:write name="x" property="totalVentaProducto" format="#####0.00"/></td>
				         		<td align="right"><bean:write name="x" property="totalVentaServicios" format="#####0.00"/></td>
				         		<td align="right"><bean:write name="x" property="totalVenta" format="#####0.00"/></td>
				         	</tr>
				         </logic:iterate>
			         	<tr>
			         		<td colspan="3" align="right">Total Ventas y Servicios: </td>
			         		<td align="right"><bean:write name="ventaForm" property="totalVentaArqueo" format="########0.00"/></td>
			         	</tr>
			         	<tr>
			         		<td colspan="3" align="right">Total Venta con Tarjetas: </td>
			         		<td align="right"><bean:write name="ventaForm" property="totalVentaTarjetaArqueo" format="########0.00"/></td>
			         	</tr>
			         	<tr>
			         		<td colspan="3" align="right">Total Venta con credito: </td>
			         		<td align="right"><bean:write name="ventaForm" property="totalVentaCreditoArqueo" format="########0.00"/></td>
			         	</tr>
			         	<tr>
			         		<td colspan="3" align="right">Total Efectivo: </td>
			         		<td align="right"><bean:write name="ventaForm" property="totalVentaEfectivoArqueo" format="########0.00"/></td>
			         	</tr>
			         	
			         </logic:notEmpty>
			    </tbody>
			</table>
		
		</td>
	</tr>

	<tr>
		<td align="center">
			<html:select property="impresoraID" styleId="impresoraID" styleClass="combo" style="width:100px" onchange="fn_PagoCredito()">
				<html:options collection="listaImpresora" property="impresoraID" labelProperty="impresoraID" />
			</html:select>
			<button onclick="fn_imprimir('<bean:write name="ventaForm" property="idPersonalArqueo"/>')" type="submit" class="button"
				id="btnImprimir">
				<span class='savePrint' id="btnGuardar">Imprimir</span>
			</button>
		</td>
	</tr>
	
	<html:hidden property="vTipoImpresion" styleId="vTipoImpresion" value="arqueoIndividual"/>

<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="imprimir" styleId="metodo" />

</html:form>
<script>
	$("#popupCabecera").text('DETALLE ARQUEO');
	$("#impresoraID option[value='BIXOLON SRP-270']").attr("selected",true); 

	function fn_imprimir(id){
		var cad="venta.do?metodo=imprimir&omitirPieBoleta=true&mode=A&id=" + id;
		 
		 $.ajax({
	         type: "GET",
	         url: cad,
	         data: "",
	         success: function(obj){   
	       	  alert("OPERACION CON EXITO"); 
	         }
	     });
		 window.close();
		 
	}
	
</script>