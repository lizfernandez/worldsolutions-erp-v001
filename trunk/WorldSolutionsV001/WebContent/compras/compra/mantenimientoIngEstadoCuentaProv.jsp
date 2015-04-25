
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="ingresoProducto" styleId="formUsuario">
<tr class="trCodigo">
    <td align="right">Raz&oacute;n Social:</td>
    <td>    
	    <html:text property="cProveedorCodigo"  styleId="cProveedorCodigo" maxlength="5" styleClass="textCodigo inputDisabled" />
	    <html:text property="vProveedorRazonSocial"  styleId="vProveedorRazonSocial"  styleClass="text inputDisabled" size="35"/>
	    <input type="hidden" id="vClasificacion"  class="text textCodigo inputDisabled" readonly="true" />
        <input type="hidden" id="fDescuentoProveedor"  class="text inputDisabled" readonly="true" size="6" />
  
	    <img  onclick="popupModal('proveedor.do?metodo=listaProveedor&mode=LP',580,250)" src="${pageContext.request.contextPath}/media/imagenes/imgpopup.png"/>
	    <span id="m_cProveedorCodigo" class="importante">*</span>
	    </td>
</tr>
<tr>
<td align="right">Direcci&oacute;n :</td>
    <td>
       <html:text property="vProveedorDireccion" styleId="vProveedorDireccion"   styleClass="text inputDisabled" size="46"/>
     </td>
</tr>
<tr>
    <td align="right"><span id="Ruc">Ruc :</span></td>
    <td>
       <html:text property="nProveedorNumeroDocumento" styleId="nProveedorNumeroDocumento"  styleClass="text inputDisabled" readonly="" />
       
   </td>
</tr>
<tr>
    <td align="right">Tipo Documento :</td>
    <td> <html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" style="width:152px"
    >       
              <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
         </html:select>
     </td>
</tr>

<tr>
	<td align="right">Nro Documento :</td>
	 <td><html:text property="nIngresoProductoNumero" styleId="nIngresoProductoNumero"   styleClass="text" onkeypress="return Numeros(event)"  size="11" maxlength="11" />
		     <span id="m_nIngresoProductoNumero" class="importante">*</span>
	</td>
</tr>
<tr>
    <td align="right">Fecha Emisi&oacute;n :</td>
    <td>
       <html:text property="dIngresoProductoFecha" styleId="dIngresoProductoFecha"   styleClass="text"  size="11" maxlength="11" readonly="true" />
      <span id="m_dIngresoProductoFecha" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Monto :</td>
    <td>
    <html:text property="fIngresoProductoTotal" styleId="fIngresoProductoTotal"   styleClass="text textNumero" onkeypress="return Numeros(event)" size="11" maxlength="11"/>
    <span id="m_fIngresoProductoTotal" class="importante">*</span>  
    </td>
</tr>
<tr>
    <td align="right">Forma de Pago :</td>
    <td>
         <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo" style="width:152px"
         onchange="fn_PagoCredito()">       
              <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
         </html:select>
        </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" style="width:152px"
    >       
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td>
    
</tr>
<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="insertar('tab-grupo')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span  class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iIngresoProductoId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iProveedorId" styleId="iProveedorId" />


<html:hidden property="pagoTotal" styleId="pagoTotal" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="vIngresoProductoPuntoLlegada" styleId="vIngresoProductoPuntoLlegada" />
<html:hidden property="vEstadoDocumento" styleId="vEstadoDocumento" value="CANCELADO"/>

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode"  />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduIngresoproducto" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    $("#dIngresoProductoFecha").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            maxDate: '+0d'
    })
    $("input:text.inputDisabled").attr("readonly",true);
    if(mode=='IE') {
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
    	$("#vEstadoDocumento").val("DEUDA");    	
    	if(i==1){$("#vEstadoDocumento").val("CANCELADO"); }
  
    }

</script>