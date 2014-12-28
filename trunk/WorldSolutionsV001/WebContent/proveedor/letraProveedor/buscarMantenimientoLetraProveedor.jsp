<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="estadoCuentaProveedor" styleId="formUsuario">
<tr class="trCodigo">
    <td align="right">Nro Factura:</td>
    <td colspan="3">    
	    <html:text property="nIngresoProductoNumero"  styleId="nIngresoProductoNumero" maxlength="5" styleClass="textCodigo inputDisabled" />
	    <button type="button"  id="spanImgNroDoc" class="button" onclick="popupModal('ingresoProducto.do?metodo=listaIngresoproducto&mode=LPL',900,350)" >
                       <span  class="imgpopup">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
        </button>    
	    <span id="m_cProveedorCodigo" class="importante">*</span>
	    </td>
</tr>
<tr class="trCodigo">
    <td align="right">Raz&oacute;n Social:</td>
    <td colspan="3">    
	    <html:text property="cProveedorCodigo"  styleId="cProveedorCodigo" maxlength="5" styleClass="textCodigo inputDisabled" disabled="true"/>
	    <html:text property="vProveedorRazonSocial"  styleId="vProveedorRazonSocial"  styleClass="text inputDisabled" size="35"/>
	    <span id="m_cProveedorCodigo" class="importante">*</span>
	    </td>
</tr>

<tr>
    <td align="right"><span id="Ruc">Ruc :</span></td>
    <td colspan="3">
       <html:text property="nProveedorNumeroDocumento" styleId="nProveedorNumeroDocumento"  styleClass="text inputDisabled" readonly="" />
       
   </td>
</tr>
<tr>
    <td align="right">Tipo Documento :</td>
    <td colspan="3"><html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" disabled="true" style="width:160px">   
              <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
         </html:select>         
    </td>
</tr>

<tr>
    <td align="right">Forma de Pago :</td>
    <td colspan="3">
         <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo" style="width:160px" onchange="fn_PagoCredito()">       
              <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
         </html:select>
        </td>
</tr>
<tr>
    <td align="right">Nro &Uacute;nico Letra:</td>
    <td>
     <html:text property="nNumeroLetra" styleId="nNumeroLetra"   styleClass="text"  size="11" maxlength="11"/>
      <span id="m_nNumeroLetra" class="importante">*</span>
    </td>
    <td>Import  Factura: </td>
    <td>
    <html:text property="fIngresoProductoTotal" styleId="fIngresoProductoTotal"   styleClass="text textNumero" onkeypress="return Numeros(event)" size="11" maxlength="11"/>
    <span id="m_fIngresoProductoTotal" class="importante">*</span>  
    </td>
</tr>
<tr>
    <td align="right">Fecha Giro :</td>
    <td>
       <html:text property="dFechaGiro" styleId="dFechaGiro"   styleClass="text"  size="11" maxlength="11"/>
      <span id="m_dFechaGiro" class="importante">*</span>
      </td>
      <td> Fecha Vencimiento: </td>
      <td>
      <html:text property="dFechaVencimiento" styleId="dFechaVencimiento"   styleClass="text"  size="11" maxlength="11"/>
      <span id="m_dFechaVencimiento" class="importante">*</span>
    </td>
</tr>

<tr>
    <td align="right">Plazo(Dias):</td>
    <td>
       <html:text property="nPlazoLetra" styleId="nPlazoLetra"   styleClass="text textNumero"  size="11" maxlength="11"/>
      <span id="m_nPlazoLetra" class="importante">*</span>
       <td>Max. de Letras:</td>
      <td>      
	   <html:text property="iNumeroLetras" styleId="iNumeroLetras"   styleClass="text textNumero" size="11" maxlength="11"  onblur="fn_importeLetra()"/>
    </td>
</tr>
<tr>
    <td align="right">Importe De letra:</td>
    <td>
       <html:text property="nImporte" styleId="nImporte"   styleClass="text textNumero"  size="11" maxlength="11"/>
      <span id="m_nImporte" class="importante">*</span>
      <td> Importe de Interes:</td>
      <td>       
       <html:text property="fImporteIntereses" styleId="fImporteIntereses"   styleClass="textN textNumero"  size="11" maxlength="11" onblur="fn_importeLetra()"/>
     
    </td>
</tr>
<tr>
    <td align="right">Fecha de Pago:</td>
    <td>
       <html:text property="dFechaPagoLetra" styleId="dFechaPagoLetra"   styleClass="textN"  size="11" maxlength="11"/>      
      <td>Aplicar a todos:</td>
      <td>       
       <input type="checkbox" id="aplicarTodo" onclick="fn_aplicarTodos()"/>
    
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
     <button onclick="buscar('tab-grupo')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span  class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iIngresoProductoId"  styleId="iIngresoProductoId"/>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iProveedorId" styleId="iProveedorId" />

<html:hidden property="iletraProveedorId" styleId="iletraProveedorId" />


<html:hidden property="pagoTotal" styleId="pagoTotal" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="vIngresoProductoPuntoLlegada" styleId="vIngresoProductoPuntoLlegada" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode"  />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaLetrasProveedor" styleId="metodo" />
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
    $("#dFechaPagoLetra").datepicker(
            {
                changeMonth: true,
                changeYear: true,
                dateFormat: 'dd/mm/yy',
                defaultDate: -1,
                 
        });
    $("input:text.inputDisabled").attr("readonly",true);
    if(mode=='I') {
        document.getElementById('cProveedorCodigo').focus();
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
    	var total = dosDecimales(parseFloat($("#fIngresoProductoTotal").val()/$("#iNumeroLetras").val()))+dosDecimales(parseFloat($("#fImporteIntereses").val()));
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