
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formVenta" enctype="echarset=utf-8">

<tr>
	<td align="center">
		<html:textarea property="vTextoImpresion" styleClass="text" rows="20" cols="50" readonly="true" disabled="true" />
	</td>
</tr>

<tr>
	<td align="right">
		<button onclick="fn_imprimir()" class="button" id="btnImprimir"><span class='savePrint' id="btnGuardar">Imprimir</span></button>
				           
	</td>
</tr>
<html:hidden property="vTipoImpresion" styleId="vTipoImpresion" value="arqueoIndividual"/>

</html:form>
<script>
	$("#popupCabecera").text('VISUALIZAR ARQUEO');
	

	function fn_imprimir(id){
		var cad="venta.do?metodo=imprimir";
		 
		 $.ajax({
	         type: "GET",
	         url: cad,
	         data: "",
	         success: function(obj){   
	       	  alert("OPERACION CON EXITO"); 
	         }
	     });
		 
	}
	
</script>