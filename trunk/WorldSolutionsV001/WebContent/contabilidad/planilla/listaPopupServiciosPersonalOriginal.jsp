
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
	</tr>
	<html:hidden property="metodo" value="listaServiciosPersonal" styleId="metodo"  />
</html:form>

<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Servicios por Personal</caption>
    <thead>
    	<tr >
        	<th align="left" width="15%">PERSONAL</th>
        	<th align="left" width="15%">SUCURSALES</th>
        	<logic:notEmpty name="contabilidadForm" property="listaFechas">
        		<logic:iterate name="contabilidadForm" property="listaFechas" id="x">	
				 	<th>
				 		<bean:write name="x" />
					</th>
				</logic:iterate>
        	</logic:notEmpty>        	
        	<th align="right" width="10%">TOTAL NETO</th>
        	<th align="right">PROCENTAJE 50%</th>
           
      	</tr>
    </thead>
    <tbody>
	     <logic:empty name="contabilidadForm" property="lista">
				<tr>
					<td >No hay informaci&oacute;n de Servicios ejecutados en hasta la fecha</td>
				</tr>
	     </logic:empty>
         <logic:notEmpty name="contabilidadForm" property="lista">
			<logic:iterate name="contabilidadForm" property="lista" id="x" >	
			 	<tr>
					<td><bean:write name="x" property="personal.vPersonalNombres"/> <bean:write name="x" property="personal.vPersonalApellidoPaterno"/></td>

					<!-- Informacion de servicios por sucursal -->
					<logic:iterate name="x" property="detalleServicioPersonalVo" id="y" indexId="i">
						<logic:equal name="i" value="0">>
							<td align="center">
								<table class="tablaSinBorde">
										<logic:iterate name="y" property="detalleServicioSucursalVo" id="z" indexId="i">
											<tr>
												<td align="center"><bean:write name="z" property="sucursal.vSucursalNombre" /></td>
											</tr>
										</logic:iterate>
								</table>
							</td>
						</logic:equal>
						<td align="center">
							<table class="tablaSinBorde">
								<logic:iterate name="y" property="detalleServicioSucursalVo" id="z" >
									<tr>
										<td align="right" ><bean:write name="z" property="totalServicioSucursal" format="##0.00"/></td>
									</tr>
								</logic:iterate>
							</table>
						</td>					
					</logic:iterate>
					<td align="right"><bean:write name="x" property="totalNeto" format="#####0.00"/></td>
					<td align="right"><bean:write name="x" property="porcentaje" format="#####0.00"/></td>
					
				</tr>
				
			</logic:iterate>
		 </logic:notEmpty>
		 <tr>
		 	<td>&nbsp;</td>
		 	<td>&nbsp;</td>
		 	<logic:notEmpty name="contabilidadForm" property="listaFechas">
        		<logic:iterate name="contabilidadForm" property="listaTotalDia" id="x">	
				 	<td align="right"><bean:write name="x" format="#####0.00"/></td>
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
	$("#fechaInicio, #fechaFin").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'dd/mm/yy',
		defaultDate : -1,
		maxDate : '+0d'
	});
	
</script>  