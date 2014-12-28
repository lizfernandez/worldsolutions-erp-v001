
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="configuracion" styleId="formConfiguracion">
<tr>
    <td align="right">Nombre Impuesto:</td>
    <td>
       <html:text property="vNombreImpuesto" styleId="vNombreImpuesto" onkeyup="return mayuscula('vNombreImpuesto')" styleClass="text"/>
       <span id="m_vNombreImpuesto" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">% de impuesto:</td>
    <td>
       <html:text property="vPorcentaje" styleId="vPorcentaje" onkeyup="return mayuscula('vPorcentaje')" styleClass="text"/>
       <span id="m_vPorcentaje" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Aplicaci&oacute;n impuesto:</td>
    <td>
    <html:select  property="vAplicacionImpuesto" styleId="vAplicacionImpuesto" styleClass="combo">       
              <html:options collection="listaAplicacion" property="vTipoDocumentoDescripcion" labelProperty="vTipoDocumentoDescripcion"/>
    </html:select>
   </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td colspan="3"><html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo">       
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
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
<html:hidden property="iImpuestosId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduImpuestos" styleId="metodo" />
	
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