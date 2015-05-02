
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="area" styleId="formArea">
<tr class="trCodigo">
    <td align="right">C&oacute;digo:</td>
    <td><html:text property="cAreaCodigo" styleId="cAreaCodigo" onkeyup="return mayuscula('cAreaCodigo')"  onkeypress="return LetrasNumeros(event)" maxlength="5" styleClass="text"/>
    	<span id="m_cAreaCodigo" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Nombre:</td>
    <td>
       <html:text property="vAreaDescripcion" styleId="vAreaDescripcion" onkeyup="return mayuscula('vAreaDescripcion')" styleClass="text"/>
       <span id="m_vAreaDescripcion" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo">       
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td>
    
</tr>
<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="insertar('tab-grupo')" class="button" ><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');" class="button"  type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iAreaId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduArea" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    if(mode=='I') {
        document.getElementById('cAreaCodigo').focus();
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