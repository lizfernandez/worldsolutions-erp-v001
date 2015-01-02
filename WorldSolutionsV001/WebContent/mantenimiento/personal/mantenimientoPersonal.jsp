
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="personal" styleId="formPersonal">
<tr class="trCodigo">
    <td align="right">C&oacute;digo:</td>
    <td>   
        <html:text property="cPersonalCodigo"  styleId="cPersonalCodigo" styleClass="text" onkeyup="return mayuscula('cPersonalCodigo')" onkeypress="return LetrasNumeros(event)" maxlength="5"/>
        <span id="m_cPersonalCodigo" class="importante">**</span>
    </td>
</tr>
<tr>
    <td align="right">Nombres:</td>
    <td>
    <html:text property="vPersonalNombres" styleId="vPersonalNombres" styleClass="text" onkeyup="return mayuscula('vPersonalNombres')"/>
        <span id="m_vPersonalNombres" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Ap. Paterno:</td>
    <td><html:text property="vPersonalApellidoPaterno" styleId="vPersonalApellidoPaterno" styleClass="text" onkeyup="return mayuscula('vPersonalApellidoPaterno')"/>
        <span id="m_vPersonalApellidoPaterno" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Ap. Materno:</td>
    <td><html:text property="vPersonalApellidoMaterno" styleId="vPersonalApellidoMaterno" styleClass="text" onkeyup="return mayuscula('vPersonalApellidoMaterno')"/>
        <span id="m_vPersonalApellidoMaterno" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Tipo Doc.:</td>
    <td><html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" style="width:154px">       
              <html:options collection="listaDoc" property="iTipoDocumentoId" labelProperty="vTipoDocuumentoDescripcion"/>
         </html:select>
    </td>
</tr>
<tr>
    <td align="right">Nro Doc.:</td>
    <td><html:text property="nPersonalNumeroDocumento"  styleId="nPersonalNumeroDocumento" styleClass="text" onkeypress="return Numeros(event)" maxlength="10"/>
        <span id="m_nPersonalNumeroDocumento" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Sexo:</td>
    <td><html:select  property="iSexoId" styleId="iSexoId" styleClass="combo" style="width:154px">              
              <html:options collection="listaSex" property="iSexoId" labelProperty="vSexoDescripcion"/>
         </html:select>
    </td>
         
</tr>
<tr>
    <td align="right">Area:</td>
    <td><html:select  property="iAreaId" styleId="iAreaId"  styleClass="combo" style="width:154px" >       
              <html:options collection="listaArea" property="iAreaId" labelProperty="vAreaDescripcion" />
         </html:select>
     </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" style="width:154px">       
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td>
    
</tr>
<tr>
    
    <td align="center" colspan="2">
    <br>
     <button onclick="insertar('tab-grupo')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
      <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iPersonalId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduPersonal" />


	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
   
    if(mode=='I') {
    	
        document.getElementById('cPersonalCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
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