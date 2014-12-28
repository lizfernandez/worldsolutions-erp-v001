
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('configuracion.do?metodo=mantenimientoImpuestos&mode=I',370,300)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('configuracion.do?metodo=mantenimientoImpuestos&mode=F',370,300)">
                <span class="find">Buscar</span>
            </button>
        </td> 
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Impuestos</caption>
        <!-- tr>
            <th width="5%" >Nombre Impuestos:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        
        <th width="16%" align="center">Operaci&oacute;n</th>        
        <th width="22%" align="left">Nombre Impuesto</th>
        <th width="22%" align="left">% aplicado</th>
        <th width="15%" align="left">Aplicado a</th>
        <th width="15%" align="left">Fecha Inserci&oacute;n </th>
        <th width="8%" align="left">Estado</th>
       
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="configuracionForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del Impuestos Fiscal</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="configuracionForm" property="lista">
	     	<logic:iterate name="configuracionForm" property="lista" id="x">	
			<tr>
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('configuracion.do?metodo=mantenimientoImpuestos&mode=U&id=<bean:write name="x" property="iImpuestosId" />',370,300)" /></td>
		 	  				
				<td><bean:write name="x" property="vNombreImpuesto" /></td>
				<td><bean:write name="x" property="vPorcentaje" /></td>
				<td><bean:write name="x" property="vAplicacionImpuesto" /></td>
				<td><bean:write name="x" property="dFechaInserta"  format="dd/MM/yyyy"/></td>				
				<td><bean:write name="x" property="cCodigoEstado" /></td>
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="configuracionForm" property="paginas">	
    <bean:size id="listSizes" name="configuracionForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="configuracionForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="configuracionForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#configuracion").children('li').show();
$("#impuestos").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#impuestos").children('a').css("color","#D0D2D7");
$("#admin").addClass("active");
</script> 

 