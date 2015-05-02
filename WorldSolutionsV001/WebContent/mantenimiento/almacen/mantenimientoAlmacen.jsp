
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="empresaSucursal" styleId="formSucursal">
<tr class="trCodigo">
    <td align="right">C&oacute;digo:</td>
    <td><html:text property="cAlmacenCodigo" styleId="cAlmacenCodigo" onkeyup="return mayuscula('cAlmacenCodigo')"  onkeypress="return LetrasNumeros(event)" maxlength="5" styleClass="text"/>
    	<span id="m_cSucursalCodigo" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Sucursal:</td>
   <td> <html:select  property="iSucursalId" styleId="iSucursalId" styleClass="combo" style="width:155px"
   >       
              <html:options collection="listaSucursal" property="iSucursalId" labelProperty="vSucursalNombre"/>
         </html:select>
    </td>
</tr>
<tr>
    <td align="right">Nombre:</td>
    <td>
       <html:text property="vAlmacenNombre" styleId="vAlmacenNombre" onkeyup="return mayuscula('vAlmacenNombre')" styleClass="text" size="45"/>
       <span id="m_vAlmacenNombre" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Direcci&oacute;n:</td>
    <td>
       <html:text property="vAlmacenDireccion" styleId="vAlmacenDireccion" onkeyup="return mayuscula('vAlmacenDireccion')" styleClass="text" size="45"/>
       <span id="m_vAlmacenDireccion" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right">Tel&eacute;fono:</td>
    <td>
       <html:text property="vAlmacenTelefono" styleId="vAlmacenTelefono" onkeyup="return mayuscula('vAlmacenTelefono')" styleClass="text"/>
       <span id="m_vAlmacenTelefono" class="importante">*</span>
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
<html:hidden property="iAlmacenId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduAlmacen" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    if(mode=='I') {
        document.getElementById('cSucursalCodigo').focus();
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