
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="usuario" styleId="formUsuario">
<tr class="trCodigo">
    <td align="right">Personal:</td>
    <td>    
	    <html:text property="cPersonalCodigo"  styleId="cPersonalCodigo" maxlength="5" styleClass="textCodigo inputDisabled" />
	    <html:text property="vPersonalNombres"  styleId="vPersonalNombres"  styleClass="inputDisabled"/>
	    <img  onclick="popupModal('personal.do?metodo=listaPersonal&mode=LP&iPersonalId=iPersonalId&codigo=cPersonalCodigo&nombre=vPersonalNombres',580,250)" src="${pageContext.request.contextPath}/media/imagenes/imgpopup.png"/>
	    <span id="m_cPersonalCodigo" class="importante"></span>
	    <input type="hidden" id="vOcupacionDescripcion"/>
	    <input type="hidden" id="fSueldo"/>
	    </td>
</tr>
<tr>
<td align="right">Usuario:</td>
    <td>
       <html:text property="vUsuarioLogin" styleId="vUsuarioLogin" onkeyup="return mayuscula('vUsuarioLogin')" styleClass="text"/>
       <span id="m_vUsuarioLogin" class="importante"></span>
   </td>
</tr>
<tr>
    <td align="right">Password:</td>
    <td>
       <html:text property="vUsuarioPassword" styleId="vUsuarioPassword"  styleClass="text" />
       <span id="m_vUsuarioPassword" class="importante"></span>
   </td>
</tr>
<tr>
	<td align="right">Sucursal:</td>
	<td><html:select  property="iSucursalId" styleId="iSucursalId"  styleClass="combo" >       
	              <html:options collection="listaSucursal" property="iSucursalId" labelProperty="vSucursalNombre" />
	         </html:select>
	  </td>
</tr>
<tr>
	<td align="right">Perfil:</td>
	<td><html:select  property="iPerfilId" styleId="iPerfilId"  styleClass="combo" >       
	              <html:options collection="listaPerfil" property="iPerfilId" labelProperty="vPerfilDescripcion" />
	         </html:select>
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
     <button onclick="buscar('tab-grupo')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iUsuarioId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iPersonalId" styleId="iPersonalId" />


<%-- hidden field que contiene el id del producto --%>
<input type="text" id="iPersonalId" class="textInvisible" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaUsuario" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
   // $('#vUsuarioPassword').removeAttr("type","text"); 
   // $('#vUsuarioPassword').attr('type', 'password'); 
   /* var originalBtn = $("#vUsuarioPassword");
    var newBtn = originalBtn.clone();

    newBtn.attr("type", "password");
    newBtn.insertBefore(originalBtn);
    originalBtn.remove();
    newBtn.attr("id", "vUsuarioPassword");
    */
    
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