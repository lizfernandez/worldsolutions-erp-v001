<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:form action="proveedor" styleId="formPersonal">
    <tr>
	    <td align="right">C&oacute;digo:</td>
	    <td>   
	        <html:text property="cProveedorCodigo"  styleId="cProveedorCodigo"  onkeyup="return mayuscula('cProveedorCodigo')" maxlength="5" tabindex="1" styleClass="text"/>
	        
	    </td>
        <td align="right">Ruc:</td>
	   <td><html:text property="nProveedorNumeroDocumento" styleId="nProveedorNumeroDocumento"  tabindex="2" styleClass="text"/>
	        <span id="m_vPersonalApellidoPaterno" class="importante"></span>
	    </td>
	    <td rowspan="2">
	       <button  class="button"   onclick="buscarPopup('tab-grupo')" tabindex="4">
                <span class="find">Buscar</span>
            </button>
            <button  class="button" type="button" onclick="popupModal('proveedor.do?metodo=mantenimientoProveedor&mode=I',350,400)">
                <span class="new">Nuevo</span>
            </button>
        </td>
	 </tr> 
	 <tr>
	   <td align="right">Raz&oacute;n Social:</td>
	    <td colspan="3">
	    <html:text property="vProveedorRazonSocial" styleId="vProveedorRazonSocial" onkeyup="return mayuscula('vProveedorRazonSocial')" size="45" tabindex="3" styleClass="text"/>
	        
	    </td>
	   	    
    </tr>
<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaProveedor" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Proveedor</caption>
        <!-- tr>
            <th width="5%" >Apellidos Personal:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
        -->
    <thead>
    <tr >
        <th align="left">C&oacute;digo</th>
        <th align="left">Raz&oacute;n Social</th>
        <th align="left">Ruc</th>       
        
      </tr>
    </thead>
    <tbody>
	     <logic:empty name="proveedorForm" property="lista">
				<tr>
					<td colspan="11">No hay informaci&oacute;n del proveedor</td>
				</tr>
	     </logic:empty>
         <logic:notEmpty name="proveedorForm" property="lista">
		 <logic:iterate name="proveedorForm" property="lista" id="x">	
			<tr onclick="retornarProv('iProveedorId','<bean:write name="x" property="iProveedorId" />','cProveedorCodigo','<bean:write name="x" property="cProveedorCodigo" />','vProveedorRazonSocial','<bean:write name="x" property="vProveedorRazonSocial" />','nProveedorNumeroDocumento','<bean:write name="x" property="nProveedorNumeroDocumento" />','vProveedorDireccion','<bean:write name="x" property="vProveedorDireccion" />','vIngresoProductoPuntoLlegada')">
		 		<td><bean:write name="x" property="cProveedorCodigo" /></td>
				<td><bean:write name="x" property="vProveedorRazonSocial" /></td>
				<td><bean:write name="x" property="nProveedorNumeroDocumento" /></td>
				
	    	</tr>
		</logic:iterate>
	  </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="proveedorForm" property="paginas">	
    <bean:size id="listSizes" name="proveedorForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="proveedorForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="proveedorForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>		  
</div> 
<script>   
paginacion();
document.getElementById('cProveedorCodigo').focus();
</script>
 