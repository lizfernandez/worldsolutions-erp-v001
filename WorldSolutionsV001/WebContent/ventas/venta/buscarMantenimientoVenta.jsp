
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formUsuario">
<tr class="trCodigo">
    <td align="right" width="30%">Raz&oacute;n Social:</td>
    <td>    
	    <html:text property="vClienteCodigo"  styleId="vClienteCodigo" maxlength="5" styleClass="textCodigo inputDisabled" />
	    <html:text property="vClienteRazonSocial"  styleId="vClienteRazonSocial"  styleClass="text inputDisabled" size="35"/>
	    <img  onclick="popupModal('cliente.do?metodo=listaCliente&mode=LP',580,250)" src="${pageContext.request.contextPath}/media/imagenes/imgpopup.png"/>
	    <span id="m_cClienteCodigo" class="importante">*</span>
	    </td>
</tr>
<tr>
<td align="right">Direcci&oacute;n :</td>
    <td>
       <html:text property="vClienteDireccion" styleId="vClienteDireccion"   styleClass="text inputDisabled" size="46"/>
     </td>
</tr>
<tr>
    <td align="right"><span id="Ruc">Ruc :</span></td>
    <td>
       <html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  styleClass="text inputDisabled" readonly="true" />
       <input type="hidden" id="vClasificacion"  class="text textCodigo inputDisabled" readonly="true" />
       <input type="hidden" id="fDescuentoCliente"  class="text inputDisabled" readonly="true" size="6" />
         
   </td>
</tr>
<tr>
    <td align="right">Tipo Documento :</td>
    <td> <html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" style="width:152px"> 
              <option value="00">::SELECCIONE::</option>       
              <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
         </html:select>
     </td>
</tr>

<tr>
	<td align="right">Nro Documento :</td>
	 <td><html:text property="nVentaNumero" styleId="nVentaNumero"   styleClass="text" onkeypress="return Numeros(event)"  size="11" maxlength="11" />
		     <span id="m_nVentaNumero" class="importante">*</span>
	</td>
</tr>
<tr>
    <td align="right">Fecha Emisi&oacute;n Inicio:</td>
    <td>
       <html:text property="dVentaFecha" styleId="dVentaFecha"   styleClass="text"  size="11" maxlength="11" readonly="true"/>
      <span id="m_dVentaFecha" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Fecha Emisi&oacute;n fin:</td>
    <td>
       <html:text property="dVentaFechaFin" styleId="dVentaFechaFin"   styleClass="text"  size="11" maxlength="11" readonly="true"/>
      <span id="m_dVentaFechaFin" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Monto :</td>
    <td>
    <html:text property="fVentaTotal" styleId="fVentaTotal"   styleClass="text textNumero" onkeypress="return Numeros(event)" size="11" maxlength="11"/>
    <span id="m_fVentaTotal" class="importante">*</span>  
    </td>
</tr>
<tr>
    <td align="right">Forma de Pago :</td>
    <td>
         <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo" style="width:152px">  
              <option value="00">::SELECCIONE::</option>      
              <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
         </html:select>
        </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" style="width:152px">   
                
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td>
    
</tr>
<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="buscar('tab-grupo')" class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');" class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span  class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iVentaId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden  property="iClienteId" styleId="iClienteId"/>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="vVentaPuntoLlegada" styleId="vVentaPuntoLlegada" />


<html:hidden property="pagoTotal" styleId="pagoTotal" />


<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode"/>
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    $("#dVentaFecha, #dVentaFechaFin").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            maxDate: '+0d'
    })
    $("input:text.inputDisabled").attr("readonly",true);
    if(mode=='IE') {
        document.getElementById('vClienteCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DATOS');	
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');	
        if(mode=='F'){
        	$("#popupCabecera").text('BUSCAR DATOS'); 
        	$("#dVentaFecha").val("");
        	//$("#fVentaTotal").val("");
         	/*$(":input").attr('disabled',true);
         	$(":hidden").attr('disabled',false);
         	$(":button").attr('disabled',false);*/
         	$("#btnGuardar").removeClass('save');
         	$("#btnGuardar").addClass('find');
        	$("#btnGuardar").text('Buscar');
         }
    }
    
   

</script>