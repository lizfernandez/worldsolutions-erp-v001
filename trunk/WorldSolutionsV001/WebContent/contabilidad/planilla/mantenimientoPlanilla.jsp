
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="contabilidad" styleId="formContabilidad">
<tr class="trCodigo">
    <td align="right">Personal:</td>
    <td colspan="3">    
	    <html:text property="cPersonalCodigo"  styleId="cPersonalCodigo" maxlength="5" styleClass="textCodigo inputDisabled" />
	    <html:text property="vPersonalNombres"  styleId="vPersonalNombres"  styleClass="text inputDisabled" size="50"/>
	    <img  onclick="popupModal('personal.do?metodo=listaPersonal&mode=LP',580,250)" src="${pageContext.request.contextPath}/media/imagenes/imgpopup.png"/>
	    <span id="m_cPersonalCodigo" class="importante">*</span>
	    </td>
</tr>
<tr>
<td align="right">Profesi&oacute;n:</td>
    <td colspan="3">    
       <html:text property="vOcupacionDescripcion" styleId="vOcupacionDescripcion" styleClass="text inputDisabled"/>
       <span id="m_vOcupacionDescripcion" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Sueldo:</td>
    <td>
       <html:text property="fSueldo" styleId="fSueldo"  styleClass="textNumero" />
       <span id="m_fSueldo" class="importante">*</span>
   </td>
   <td align="right">Total Remunerac&oacute;n:</td>
    <td>
       <html:text property="fTotalRemuneracion" styleId="fTotalRemuneracion"  styleClass="textNumero" />
       <span id="m_fTotalRemuneracion" class="importante">*</span>
       
	  
   </td>
</tr>
<tr>
    <td align="right">Asig. Familiar:</td>
    <td colspan="3">
       <html:text property="fAsignacionFamiliar" styleId="fAsignacionFamiliar"  styleClass="textNumero" onblur="fn_calcular('fAsignacionFamiliar','fTotalRemuneracion')" />
       <span id="m_fAsignacionFamiliar" class="importante">*</span>
   </td>   
</tr>
<tr>
    <td align="right" colspan="4"></td>
    
</tr>
<tr>
    <td align="right">Desc. SNP  <bean:write name="contabilidadForm" property="fPorDesSNP"/> %:</td>
    <td>
       <html:text property="fDesSNP" styleId="fDesSNP"  styleClass="textNumero" />
       <span id="m_fDesSNP" class="importante">*</span>
       <input type="checkbox" id="ch_fDesSNP" onclick="fn_calcular('<bean:write name="contabilidadForm" property="fPorDesSNP"/>','fDesSNP')"/>
   </td>
   <td align="right">Total Desc.:</td>
    <td>
       <html:text property="fTotalDescuento" styleId="fTotalDescuento"  styleClass="textNumero" />
       <span id="m_fTotalDescuento" class="importante">*</span>
       
   </td>
</tr>
<tr>
    <td align="right">Desc. AFP  <bean:write name="contabilidadForm" property="fPorDesAFP"/> %:</td>
    <td colspan="3">
       <html:text property="fDesAFP" styleId="fDesAFP"  styleClass="textNumero" />
       <span id="m_fDesAFP" class="importante">*</span>
       <input type="checkbox" id="ch_fDesAFP" onclick="fn_calcular('<bean:write name="contabilidadForm" property="fPorDesAFP"/>','fDesAFP')"/>
   </td>
</tr>
<tr>
    <td align="right">Desc. P.S  <bean:write name="contabilidadForm" property="fPorDesPS"/> %:</td>
    <td colspan="3">
       <html:text property="fDesPS" styleId="fDesPS"  styleClass="textNumero" />
       <span id="m_fDesPS" class="importante">*</span>
       <input type="checkbox" id="ch_fDesPS" onclick="fn_calcular('<bean:write name="contabilidadForm" property="fPorDesPS"/>','fDesPS')"/>
   </td>
</tr>
<tr>
    <td align="right">Desc. C.V.  <bean:write name="contabilidadForm" property="fPorDesCV"/> %:</td>
    <td colspan="3">
       <html:text property="fDesCV" styleId="fDesCV"  styleClass="textNumero" />
       <span id="m_fDesCV" class="importante">*</span>
       <input type="checkbox" id="ch_fDesCV" onclick="fn_calcular('<bean:write name="contabilidadForm" property="fPorDesCV"/>','fDesCV')"/>
   </td>
</tr>
<tr>
    <td align="right" colspan="4"></td>
    
</tr>
<tr>
    <td align="right">Aport. Essalud  <bean:write name="contabilidadForm" property="fPorApoESSALUD"/> %:</td>
    <td>
       <html:text property="fApoESSALUD" styleId="fApoESSALUD"  styleClass="textNumero" />
       <span id="m_fApoESSALUD" class="importante">*</span>
       <input type="checkbox" id="ch_fApoESSALUD" onclick="fn_calcular('<bean:write name="contabilidadForm" property="fPorApoESSALUD"/>','fApoESSALUD')"/>
   </td>
       <td align="right">Total Aport:</td>
    <td>
       <html:text property="fTotalAportes" styleId="fTotalAportes"  styleClass="textNumero" />
       <span id="m_fTotalAportes" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Aport. I.E.S  <bean:write name="contabilidadForm" property="fPorApoIES"/> %:</td>
    <td colspan="3">
       <html:text property="fApoIES" styleId="fApoIES"  styleClass="textNumero" />
       <span id="m_fApoIES" class="importante">*</span>
        <input type="checkbox" id="ch_fApoIES" onclick="fn_calcular('<bean:write name="contabilidadForm" property="fPorApoIES"/>','fApoIES')"/>
   </td>
</tr>
<tr>
    <td align="right" colspan="4"></td>
    
</tr>

<tr>
    <td align="right">Neto a pagar:</td>
    <td colspan="3">
       <html:text property="fNetoPago" styleId="fNetoPago"  styleClass="textNumero" />
       <span id="m_fNetoPago" class="importante">*</span>
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
    <td align="center" colspan="4">
    <br>    
     <button onclick="insertar('tab-grupo')" class="button" ><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iPlanillaId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iPersonalId" styleId="iPersonalId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode"  />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduPlanilla" styleId="metodo" />
	
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
    
    $(document).find('#formContabilidad input:checkbox, input:text').each(function(key,val){ 	 
	    	 if($.trim(this.value)!='0.0'){
	    		 $("#ch_"+this.id).attr("checked",true);
		    	 
		    	}
	    	     	
	   });
    
    
    
    
    function fn_calcular(origen, destino){
    	
    	if(origen=="fAsignacionFamiliar"){
    		$("#"+destino).val(parseFloat($("#"+origen).val())+parseFloat($("#fSueldo").val()));
    	}
    	else{
    		 if($("#ch_"+destino).is(':checked')) {  
    			    var remuneracion= parseFloat($("#fTotalRemuneracion").val());	
    		        var porcentaje =parseFloat(origen)/100;
    		    	$("#"+destino).val(dosDecimales(remuneracion*porcentaje));  
    		    	
    	        } else {  
    	        	$("#"+destino).val("0.0");
    	        }  
          $("#fTotalDescuento").val(parseFloat($("#fDesSNP").val())+parseFloat($("#fDesAFP").val())+parseFloat($("#fDesPS").val())+parseFloat($("#fDesCV").val()));
          $("#fTotalAportes").val(parseFloat($("#fApoESSALUD").val())+parseFloat($("#fApoIES").val()));
          $("#fNetoPago").val(parseFloat($("#fTotalRemuneracion").val())-parseFloat($("#fTotalDescuento").val()));
    	}
    	
    }

</script>