<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
     <tr>     
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&mode=F&iclasificacionId=1',430,500)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('venta.do?metodo=reporteVenta',350,350)">
                <span class="pdf"> PDF</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Ingresos en Asientos Contables </caption>
    <thead>
    <tr><th colspan="8"><bean:write name="contabilidadForm" property="mes"/> </th></tr>
    <tr>
        
        
        <th align="left"  width="5%">C&oacute;digo</th>               
        <th align="left"  width="30%">Nombre de cuentas</th>        
        <th align="center"  width="9%">Suma (D)</th> 
        <th align="center"  width="9%">Suma (H)</th>  
        <th align="center"  width="9%">Saldo (D)</th> 
        <th align="center"  width="9%">Saldo (H)</th>  
        <th align="center"  width="9%">Balance (A)</th> 
        <th align="center"  width="9%">Balance (P)</th>              
        
      </tr>
    </thead>
    <tbody>    
<logic:empty name="contabilidadForm" property="lista">
	<tr>
		<td colspan="12">No hay informaci&oacute;n en Asientos contables</td>
	</tr>
</logic:empty>
<logic:notEmpty name="contabilidadForm" property="lista">      
	<logic:iterate name="contabilidadForm" property="lista" id="x">	
	<tr>
	    
	   
	    <td><bean:write name="x" property="cEstadoCodigo" /></td>
	    <td><bean:write name="x" property="vDescripcion" /></td>	    
				    
			<td align="right"><bean:write name="x" property="fMontoD" format="#,##0.00" locale="Localidad"/></td>		
			<td align="right"><bean:write name="x" property="fMontoH" format="#,##0.00" locale="Localidad"/></td>
			<td align="right"><bean:write name="x" property="fMontoSaldoD" format="#,##0.00" locale="Localidad"/></td>		
			<td align="right"><bean:write name="x" property="fMontoSaldoH" format="#,##0.00" locale="Localidad"/></td>
            <td align="right"><bean:write name="x" property="fMontoBalanceA" format="#,##0.00" locale="Localidad"/></td>		
			<td align="right"><bean:write name="x" property="fMontoBalanceP" format="#,##0.00" locale="Localidad"/></td>			   
    			   
    
        
	</tr>
	
	</logic:iterate>
</logic:notEmpty>
<tr>
	<td align="center"></td> 
	<td align="right"><strong style="font-size: 13px">TOTAL:</strong> </td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalDebe" format="#,##0.00" locale="Localidad"/></strong></td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalHaber" format="#,##0.00" locale="Localidad"/></strong></td>
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalfMontoSaldoD" format="#,##0.00" locale="Localidad"/></strong></td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalfMontoSaldoH" format="#,##0.00" locale="Localidad"/></strong></td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalfMontoBalanceA" format="#,##0.00" locale="Localidad"/></strong></td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalfMontoBalanceP" format="#,##0.00" locale="Localidad"/></strong></td> 
</tr>
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
$("#plancontable").children('li').show();
$("#balance").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#balance").children('a').css("color","#D0D2D7");

for(var i=1;i<=8;i++){
	$(".tr_"+i).hide();
	$(".tr_"+i+":first").show();
	
}
</script> 