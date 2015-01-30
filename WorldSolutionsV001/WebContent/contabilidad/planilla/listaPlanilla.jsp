<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
     <tr>
        <td><button  class="button" onclick="popup('contabilidad.do?metodo=mantenimientoPlanilla&mode=I',630,550)">
                <span class="new">Agregar</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','contabilidad.do?metodo=iduPlanilla&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('contabilidad.do?metodo=mantenimientoPlanilla&mode=F',430,500)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Planilla del Personal </caption>
    <thead>
    <tr><th colspan="17"><bean:write name="contabilidadForm" property="mes"/> </th></tr>
    <tr>
        <th colspan="3" rowspan="2" width="5%">Operaciones</th>
        <th align="left"  rowspan="2">Nombres</th> 
        <th align="left" rowspan="2">Cargo</th>               
        <th align="left" rowspan="2" >Sueldo</th>        
        <th align="center" rowspan="2" >Asig. Familiar</th> 
        <th align="center" rowspan="2" >Total Remuner.</th>
        <th align="center" colspan="4">Descuentos del trabajador</th>
         <th align="left" rowspan="2" >Total Desc.</th>  
        <th align="center" colspan="2">Aportes del empleador</th>
         <th align="left"  rowspan="2">Total Aport.</th>
        <th align="left"  rowspan="2" >Neto a Pagar</th>                       
       
      </tr>
      <tr>
        <th align="center" >NSP   <bean:write name="contabilidadForm" property="fPorDesSNP"/> %</th>  
        <th align="center" >AFP  <bean:write name="contabilidadForm" property="fPorDesAFP"/> %</th>  
        <th align="center" >P.S  <bean:write name="contabilidadForm" property="fPorDesPS"/> %</th>
        <th align="center" >V.C  <bean:write name="contabilidadForm" property="fPorDesCV"/> %</th>  
       <th align="center" >ESSALUD  <bean:write name="contabilidadForm" property="fPorApoESSALUD"/>  %</th>  
        <th align="center" >I.E.S  <bean:write name="contabilidadForm" property="fPorApoIES"/>  %</th>  
       
      </tr>
    </thead>
    <tbody>    
<logic:empty name="contabilidadForm" property="lista">
	<tr>
		<td colspan="17">No hay informaci&oacute;n en Planilla</td>
	</tr>
</logic:empty>
<logic:notEmpty name="contabilidadForm" property="lista">      
	<logic:iterate name="contabilidadForm" property="lista" id="x">	
	<tr>
	    <td align="center"><input type="checkbox" id="<bean:write name="x" property="iPlanillaId" />"/></td> 
		<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('contabilidad.do?metodo=mantenimientoPlanilla&mode=U&id=<bean:write name="x" property="iPlanillaId" />',630,550)" /></td>
		<td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iPlanillaId" />','contabilidad.do?metodo=iduPlanilla&mode=D')" /></td>	
		
		
	    <td><bean:write name="x" property="personal.vPersonalNombres" /></td>
	    <td><bean:write name="x" property="personal.ocupacion.vOcupacionDescripcion" /></td>
	     <td><bean:write name="x" property="fSueldo" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fAsignacionFamiliar" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fTotalRemuneracion" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fDesSNP" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fDesAFP" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fDesPS" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fDesCV" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fTotalDescuento" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fApoESSALUD" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fApoIES" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fTotalAportes" format="#,##0.00" locale="Localidad"/></td>
	     <td><bean:write name="x" property="fNetoPago" format="#,##0.00" locale="Localidad"/></td>
	    
	</tr>
	
	</logic:iterate>
</logic:notEmpty>
<tr>
	<td align="center" colspan="15"></td> 
	<td align="right"><strong style="font-size: 13px">TOTAL:</strong> </td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalDebe" format="#,##0.00" locale="Localidad"/></strong></td> 

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
$("#planillas").children('li').show();
$("#planilla").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#planilla").children('a').css("color","#D0D2D7");

for(var i=1;i<=8;i++){
	$(".tr_"+i).hide();
	$(".tr_"+i+":first").show();
	
}
</script> 