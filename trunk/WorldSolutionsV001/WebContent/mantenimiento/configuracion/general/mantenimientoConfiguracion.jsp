
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="configuracion" styleId="formConfiguracion">
<tr>
   
    <td align="right">Concepto:</td>
    <td> 
    <html:select  property="vConcepto" styleId="vConcepto" styleClass="combo" onchange="cambioTipo()">       
              <html:options collection="listaConfiguracion" property="vConcepto" labelProperty="vConcepto"/>
         </html:select>
    	<span id="m_vConcepto" class="importante">*</span>
    </td>
</tr>
<tr id="trTipoMoneda" style="display: none">
    <td align="right">Moneda:</td>
    <td>
             <select class="combo" id="vValorCombo" name="vValorCombo" onchange="cambioTipo()" style="width: 224px">
	    		 <option value="SOLES">SOLES</option>
	    		 <option value="DOLARES">DOLARES</option>
	        </select>
    </td>
</tr>
<tr id="tipoValor">
    <td align="right">Valor:</td>
    <td>
          <html:text property="vValor" styleId="vValor" onkeyup="return mayuscula('vValor')" styleClass="text"/>
          <span id="m_vValor" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td colspan="3"> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo">       
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
<html:hidden property="iConfiguracionId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduConfiguracion" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    if(mode=='I') {
        document.getElementById('vConcepto').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $("#popupCabecera").text('INSERTAR DATOS');	
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
         $("#popupCabecera").text('ACTUALIZAR DATOS');         
         $("#vValorCombo").val($("#vValor").val());
          cambioTipo();
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
    function cambioTipo(){
    	
    	if($("#vConcepto").val()=="TIPO MONEDA"){
    		$("#trTipoMoneda").show();  
    		$("#tipoValor").hide();
    		
    		    $("#vValor").val($("#vValorCombo").val());
    	
    	}
    	else{
    		$("#trTipoMoneda").hide(); 
    		$("#tipoValor").show();
    		$("#vValor").val("");
    	}
    }

</script>