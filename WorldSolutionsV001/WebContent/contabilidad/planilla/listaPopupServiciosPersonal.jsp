
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="contabilidad" styleId="formPersonal" >
	<tr>
	    <td align="right">Fecha Emisi&oacute;n Inicio:</td>
	    <td>
	       	<html:text property="fechaInicio" styleId="fechaInicio" styleClass="text" size="11" maxlength="11" readonly="true"/>
	      	<span id="m_fechaInicio" class="importante">*</span>
	    </td>
			<td align="right">Fecha Emisi&oacute;n fin:</td>
	    <td>
	    	<html:text property="fechaFin" styleId="fechaFin" styleClass="text" size="11" maxlength="11" readonly="true"/>
	      	
	    </td>
	    <td align="center">
    		<button onclick="buscarPopup('tab-grupo')" class="button" ><span class='find' id="btnBuscar">Buscar</span></button>
     	</td>
	    <td align="center">
	    	<button class="button" onclick="fn_exportarExcel('contabilidad.do?metodo=exportarExcel&plantilla=servicios-tecnico')">
                <span class="excel">Exportar</span>
            </button>
        </td>
	</tr>
	<html:hidden property="metodo" value="listaServiciosPersonal" styleId="metodo"  />
</html:form>

<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Servicios por T&eacute;cnico</caption>
    <thead>
    	<tr >
        	<th align="left" width="18%">PERSONAL</th>
        	<th align="left" width="14%">SUCURSAL</th>
        	<logic:notEmpty name="contabilidadForm" property="listaFechas">
        		<logic:iterate name="contabilidadForm" property="listaFechas" id="x">	
				 	<th>
				 		<bean:write name="x" />
					</th>
				</logic:iterate>
        	</logic:notEmpty>        	
        	<th align="right" width="10%">TOTAL NETO</th>
        	<th align="right" width="10%">PAGO AL T&Eacute;CNICO</th>
           
      	</tr>
    </thead>
    <tbody>
	     <logic:empty name="contabilidadForm" property="lista">
				<tr>
					<td colspan="5">No hay informaci&oacute;n de las ventas</td>
				</tr>
	     </logic:empty>
         <logic:notEmpty name="contabilidadForm" property="lista">
			<logic:iterate name="contabilidadForm" property="lista" id="x" indexId="i">
				<tr>
					<td rowspan="<bean:write name="contabilidadForm" property="totalSucursales"/>" valign="middle"><bean:write name="x" property="personal.vPersonalNombres"/> <bean:write name="x" property="personal.vPersonalApellidoPaterno"/></td>
					
					<logic:iterate name="x" property="detalleServicioSucursalVo" id="y" indexId="j">
						<logic:equal name="j" value="0">
							<td><bean:write name="y" property="sucursal.vSucursalNombre"/></td>
							<logic:iterate name="y" property="detalleServicioDiarioVo" id="z" indexId="k">
								<td align="right">&nbsp;
									<logic:notEqual name="z" property="totalServicio" value="0">
										<bean:write name="z" property="totalServicio" format="###0.00"/>
									</logic:notEqual>
								</td>
								
							</logic:iterate>
						</logic:equal>
					</logic:iterate>
					<td rowspan="<bean:write name="contabilidadForm" property="totalSucursales"/>" align="right"><bean:write name="x" property="totalNeto" format="###0.00"/></td>
					<td rowspan="<bean:write name="contabilidadForm" property="totalSucursales"/>" align="right"><bean:write name="x" property="porcentaje" format="###0.00"/></td>
					
				</tr>		
				<logic:iterate name="x" property="detalleServicioSucursalVo" id="y" indexId="j">
					<logic:notEqual name="j" value="0">
						
						<tr>
							<td><bean:write name="y" property="sucursal.vSucursalNombre"/></td>
							<logic:iterate name="y" property="detalleServicioDiarioVo" id="z" indexId="k">
								<td align="right">&nbsp;
									<logic:notEqual name="z" property="totalServicio" value="0">
										<bean:write name="z" property="totalServicio" format="###0.00"/>
									</logic:notEqual>
								</td>
								
							</logic:iterate>
						</tr>
					</logic:notEqual>
				</logic:iterate>
			</logic:iterate>
		 </logic:notEmpty>
		 <tr>
		 	<td>&nbsp;</td>
		 	<td>&nbsp;</td>
		 	<logic:notEmpty name="contabilidadForm" property="listaFechas">
        		<logic:iterate name="contabilidadForm" property="listaTotalDia" id="x">	
				 	<td align="right"><bean:write name="x" format="###0.00"/></td>
				</logic:iterate>
        	</logic:notEmpty> 
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
		<div class="btnPagInactivo" id="Next" >&emsp; </div>
		<div class="btnPagInactivo" id="Final" >&emsp; </div>
	</logic:notEmpty>	  
</div>

<script>
	paginacion();
	$("#fechaInicio").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'dd/mm/yy',
		defaultDate : -1,
		maxDate : '+0d'
	});
	

	$("#fechaFin").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'dd/mm/yy',
		defaultDate : -1,
		maxDate : '+0d'
	});
	
</script>  