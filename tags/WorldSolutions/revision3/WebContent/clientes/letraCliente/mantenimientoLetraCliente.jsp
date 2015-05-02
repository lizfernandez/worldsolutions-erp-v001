<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="estadoCuentaCliente" styleId="formUsuario">
<tr class="trCodigo">
    <td align="right">Nro Factura:</td>
    <td colspan="3">    
	    <html:text property="nVentaNumero"  styleId="nVentaNumero" maxlength="5" styleClass="textCodigo inputDisabled" />
	    <button type="button"  id="spanImgNroDoc" class="button" onclick="popupModal('venta.do?metodo=listaVenta&mode=LPL',900,350)" tabindex="1" >
                       <span  class="imgpopup">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
        </button>    
	    <span id="m_vClienteCodigo" class="importante">*</span>
	    </td>
</tr>
<tr class="trCodigo">
    <td align="right">Raz&oacute;n Social:</td>
    <td colspan="3">    
	    <html:text property="vClienteCodigo"  styleId="vClienteCodigo" maxlength="5" styleClass="textCodigo inputDisabled" disabled="true" />
	    <html:text property="vClienteRazonSocial"  styleId="vClienteRazonSocial"  styleClass="text inputDisabled" size="35"/>
	    <span id="m_cClienteCodigo" class="importante">*</span>
	    </td>
</tr>

<tr>
    <td align="right"><span id="Ruc">Ruc :</span></td>
    <td colspan="3">
       <html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  styleClass="text inputDisabled" readonly="" />
       
   </td>
</tr>
<tr>
    <td align="right">Tipo Documento :</td>
    <td colspan="3"><html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" disabled="true" style="width:160px" tabindex="2">   
              <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
         </html:select>         
    </td>
</tr>

<tr>
    <td align="right">Forma de Pago :</td>
    <td colspan="3">
         <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo" style="width:160px" onchange="fn_PagoCredito()" tabindex="3">       
              <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
         </html:select>
        </td>
</tr>
<tr>
    <td align="right">Nro &Uacute;nico Letra:</td>
    <td>
     <html:text property="nNumeroLetra" styleId="nNumeroLetra"   styleClass="text"  size="11" maxlength="11" tabindex="4"/>
      <span id="m_nNumeroLetra" class="importante">*</span>
    </td>
    <td>Importe  Factura: </td>
    <td>
    <html:text property="fVentaTotal" styleId="fVentaTotal"   styleClass="text textNumero" onkeypress="return Numeros(event)" size="11" maxlength="11" tabindex="5"/>
    <span id="m_fVentaTotal" class="importante">*</span>  
    </td>
</tr>
<tr>
    <td align="right">Fecha Giro :</td>
    <td>
       <html:text property="dFechaGiro" styleId="dFechaGiro"   styleClass="text"  size="11" maxlength="11" tabindex="6" readonly="true"/>
      <span id="m_dFechaGiro" class="importante">*</span>
      </td>
      <td> Fecha Vencimiento: </td>
      <td>
      <html:text property="dFechaVencimiento" styleId="dFechaVencimiento"   styleClass="text"  size="11" maxlength="11" tabindex="7" readonly="true"/>
      <span id="m_dFechaVencimiento" class="importante">*</span>
    </td>
</tr>

<tr>
    <td align="right">Plazo(Dias):</td>
    <td>
       <html:text property="nPlazoLetra" styleId="nPlazoLetra"   styleClass="text textNumero"  size="11" maxlength="11" onkeypress="return Numeros(event)" tabindex="8"/>
      <span id="m_nPlazoLetra" class="importante">*</span>
       <td>Max. de Letras:</td>
      <td>      
	   <html:text property="iNumeroLetras" styleId="iNumeroLetras"   styleClass="text textNumero" size="11" maxlength="11"  onblur="fn_importeLetra()" onkeypress="return Numeros(event)" tabindex="9"/>
    </td>
</tr>
<tr>
    <td align="right">Importe De letra:</td>
    <td>
       <html:text property="nImporte" styleId="nImporte"   styleClass="text textNumero"  size="11" maxlength="11" onkeypress="return Numeros(event)" tabindex="10"/>
      <span id="m_nImporte" class="importante">*</span>
      <td> Importe de Interes:</td>
      <td>       
       <html:text property="fImporteIntereses" styleId="fImporteIntereses"   styleClass="textN textNumero"  size="11" maxlength="11" onblur="fn_importeLetra()" onkeypress="return Numeros(event)"  tabindex="11"/>
     
    </td>
</tr>
<tr>
    <td align="right">Fecha de Pago:</td>
    <td>
       <html:text property="dFechaPago" styleId="dFechaPago"   styleClass="textN"  size="11" maxlength="11" tabindex="12" readonly="true"/>      
      <td>Aplicar a todos:</td>
      <td>       
       <input type="checkbox" id="aplicarTodo" onclick="fn_aplicarTodos()" tabindex="13"/>
    
    </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td colspan="3"> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" tabindex="14">       
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td>
    
</tr>
<tr height="50px">   
    <td align="center" colspan="4">
    <br>    
     <button onclick="insertar('tab-grupo')"  class="button" tabindex="15"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button" tabindex="16"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span  class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iVentaId"  styleId="iVentaId"/>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iClienteId" styleId="iClienteId" />

<html:hidden property="iLetraClienteId" styleId="iLetraClienteId" />


<html:hidden property="pagoTotal" styleId="pagoTotal" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="vVentaPuntoLlegada" styleId="vVentaPuntoLlegada" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode"  />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduLetraCliente" styleId="metodo" />
<html:hidden property="aplicarTodos" value="" styleId="aplicarTodos" />


	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    $("#dFechaGiro").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            maxDate: '+0d'
    });
    $("#dFechaVencimiento").datepicker(
            {
                changeMonth: true,
                changeYear: true,
                dateFormat: 'dd/mm/yy',
                defaultDate: -1,
                minDate: 0,
                maxDate: '+30Y', 
        });
    $("#dFechaPago").datepicker(
            {
                changeMonth: true,
                changeYear: true,
                dateFormat: 'dd/mm/yy',
                defaultDate: -1,
	            maxDate: '+0d'
                 
        });
    $("input:text.inputDisabled").attr("readonly",true);
    if(mode=='I') {
        document.getElementById('spanImgNroDoc').focus();
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
    function fn_PagoCredito(){
    	var i = $("#iFormaPago").val();
    	if(i==2||i==5)$("#nPlazoLetra").val(15);
		if(i==3||i==4||i==6)$("#nPlazoLetra").val(30);
  
    }
    function fn_importeLetra(){
    	var total = dosDecimales(parseFloat($("#fVentaTotal").val()/$("#iNumeroLetras").val()))+dosDecimales(parseFloat($("#fImporteIntereses").val()));
    $("#nImporte").val(total);	
    }
    
    function fn_aplicarTodos(){
    	if($("#aplicarTodo").is(':checked')){
    		$("#aplicarTodos").val(1);
    	}
    	else{$("#aplicarTodos").val(0);
    		
    	}
    }
   

</script>