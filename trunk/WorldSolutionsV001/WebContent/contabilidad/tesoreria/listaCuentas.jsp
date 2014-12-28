
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
     <tr>
        <td><button  class="button" onclick="popup('contabilidad.do?metodo=mantenimientoCuentas&mode=I',430,500)">
                <span class="new">Agregar</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','contabilidad.do?metodo=iduCuentas&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&mode=F&iclasificacionId=1',430,500)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Ingresos en Asientos Contables </caption>
    <thead>
    <tr>
        <th colspan="3" width="5%">Operaciones</th>
        <th align="left"  width="7%">Fecha Operaci&oacute;n</th> 
        <th align="left"  width="5%">C&oacute;digo</th>               
        <th align="left"  width="30%">Nombre de cuentas</th>        
        <th align="center"  width="5%">Monto Ingreso (D)</th> 
        <th align="center"  width="5%">Monto Egreso (H)</th>              
        <th align="left" width="5%">Estado</th>
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
	    <td align="center"><input type="checkbox" id="<bean:write name="x" property="iLibroDiarioId" />"/></td> 
		<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('contabilidad.do?metodo=mantenimientoCuentas&mode=U&id=<bean:write name="x" property="iLibroDiarioId" />',430,500)" /></td>
		<td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iLibroDiarioId" />','contabilidad.do?metodo=iduCuentas&mode=D')" /></td>	
		
		
	    <td><bean:write name="x" property="dFechaInserta" format="dd/MM/yyyy" /></td>
	    <td><bean:write name="x" property="cuenta.vCodigo" /></td>
	    <td><bean:write name="x" property="vConceptoGeneral" /></td>	    
		<logic:equal name="x" property="vTipoConcepto" value="D">		    
			<td align="right"><bean:write name="x" property="fMonto" format="#,##0.00" locale="Localidad"/></td>
			<td></td>	   
        </logic:equal>
        <logic:equal name="x" property="vTipoConcepto" value="H">		    
			<td></td>
			<td align="right"><bean:write name="x" property="fMonto" format="#,##0.00" locale="Localidad"/></td>			   
        </logic:equal>
        <td><bean:write name="x" property="cEstadoCodigo" /></td>
	</tr>
	
	</logic:iterate>
</logic:notEmpty>
<tr>
	<td align="center" colspan="5"></td> 
	<td align="right"><strong style="font-size: 13px">TOTAL:</strong> </td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalDebe" format="#,##0.00" locale="Localidad"/></strong></td> 
	<td align="right"><strong style="font-size: 13px"><bean:write name="contabilidadForm" property="totalHaber" format="#,##0.00" locale="Localidad"/></strong></td> 
	<td align="right"></td>
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
$("#tesoreria").children('li').show();
$("#cuentas").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#cuentas").children('a').css("color","#D0D2D7");

</script> 