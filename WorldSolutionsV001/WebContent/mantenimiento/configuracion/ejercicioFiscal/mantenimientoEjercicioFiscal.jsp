
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="configuracion" styleId="formConfiguracion">
<tr>
    <td align="right">C&oacute;digo:</td>
    <td>
       <html:text property="vCodigoEjercicio" styleId="vCodigoEjercicio" onkeyup="return mayuscula('vCodigoEjercicio')" styleClass="text"/>
       <span id="m_vCodigoEjercicio" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Ejercicio Fiscal:</td>
    <td>
       <html:text property="vNombreEjercicio" styleId="vNombreEjercicio" onkeyup="return mayuscula('vNombreEjercicio')" styleClass="text"/>
       <span id="m_vNombreEjercicio" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Fecha inicio:</td>
    <td>
       <html:text property="dFechaInicio" styleId="dFechaInicio" styleClass="text"/>
       <span id="m_dFechaInicio" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Fecha Fin:</td>
    <td>
       <html:text property="dFechaFin" styleId="dFechaFin" styleClass="text"/>
       <span id="m_dFechaFin" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td colspan="3"> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo">       
              <html:options collection="listaEstado" property="vEstadoDescripcion" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td> 
</tr>
<tr id="listaPeridos" style="display: none">
    <td colspan="2">
    <table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Periodos</caption>
    <thead>
    <tr>       
        <th width="16%" align="center">C&oacute;digo</th>
        <th width="22%" align="left">Periodo</th>    
        <th width="15%" align="left">Fecha Inicio </th>
        <th width="15%" align="left">Fecha Fin </th>
        <th width="8%" align="left">Estado</th>
       
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="configuracionForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del Periodo Fiscal</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="configuracionForm" property="lista">
	     	<logic:iterate name="configuracionForm" property="lista" id="x">	
			<tr>
				<td><bean:write name="x" property="vCodigoPeriodo" /></td>
				<td><bean:write name="x" property="vNombrePeriodo" /></td>				
				<td><bean:write name="x" property="dFechaInicio"  format="dd/MM/yyyy"/></td>
				<td><bean:write name="x" property="dFechaFin"  format="dd/MM/yyyy"/></td>
				<td><bean:write name="x" property="cCodigoEstado" /></td>
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
    
    </td>
   
</tr>

<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="insertar('tab-grupo')" class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');" class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iEjercicioFiscalId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduEjercicioFiscal" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    $("#dFechaInicio, #dFechaFin").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1
	    });
    
    if(mode=='I') {
        document.getElementById('vConcepto').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $("#popupCabecera").text('INSERTAR DATOS');	
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
         $("#popupCabecera").text('ACTUALIZAR DATOS');
         $("#listaPeridos").show();
        if(mode=='F'){
        	$("#popupCabecera").text('BUSCAR DATOS');        	
         	/*$(":input").attr('disabled',true);
         	$(":hidden").attr('disabled',false);
         	$(":button").attr('disabled',false);*/
         	$("#btnGuardar").removeClass('save');
         	$("#btnGuardar").addClass('find');
        	$("#btnGuardar").text('Buscar');
         }
    }

</script>