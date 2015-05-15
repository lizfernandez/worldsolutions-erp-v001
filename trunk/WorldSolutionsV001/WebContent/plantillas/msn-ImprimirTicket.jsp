<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<html:form action="venta" styleId="formVenta" enctype="echarset=utf-8">
<tr>
	<td align="center">
		<!--  html:textarea property="imprimirTicket" styleClass="text" rows="20" cols="50" readonly="true" disabled="true" /-->
		<div id="printableArea">
      <html:textarea property="imprimirTicket" styleClass="text" rows="35" cols="50" readonly="true" disabled="true" />
</div>
		<!--  -->bean:write name="ventaForm" property="imprimirTicket"/-->
	</td>
</tr>

<tr>
     <td align="center">				        
				        <button onclick="fn_imprimir('printableArea')"  class="button" id="btnImprimir" type="button"><span class='savePrint' id="btnGuardar">Imprimir</span></button>
	</td>
</tr>


  
				           
				       
</html:form>
<script>
 function fn_imprimir(divName){
	 var printContents = document.getElementById(divName).innerHTML;
     var originalContents = document.body.innerHTML;
     document.body.innerHTML = printContents;
     window.print();
     document.body.innerHTML = originalContents;
     
 window.opener.document.location.reload();
 window.close();
 }
 </script>