
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="cliente" styleId="formPersonal">
    <tr>
	    <td align="right">C&oacute;digo:</td>
	    <td>   
	        <html:text property="vClienteCodigo"  styleId="vClienteCodigo"  onkeyup="return mayuscula('vClienteCodigo')" onkeypress="return LetrasNumeros(event)" maxlength="5" styleClass="text "/>
	        
	    </td>
        <td align="right">Ruc:</td>
	   <td><html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  onkeypress="return Numeros(event)" styleClass="text "/>
	        <span id="m_vPersonalApellidoPaterno" class="importante"></span>
	    </td>
	    <td rowspan="2"><button  class="button"  onclick="buscarPopup('tab-grupo')">
                <span class="find">Buscar</span>
            </button>
            <button  class="button" type="button" onclick="popupModal('cliente.do?metodo=mantenimientoCliente&mode=I',380,450)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        
	 </tr> 
	 <tr>
	   <td align="right">Raz&oacute;n Social:</td>
	    <td colspan="3">
	    <html:text property="vClienteRazonSocial" styleId="vClienteRazonSocial" onkeyup="return mayuscula('vClienteRazonSocial')" size="45" styleClass="text "/>
	        
	    </td>
	   	    
    </tr>
<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaCliente" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Cliente</caption>
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
	     <logic:empty name="clienteForm" property="lista">
				<tr>
					<td colspan="11">No hay informaci&oacute;n del cliente</td>
				</tr>
	     </logic:empty>
         <logic:notEmpty name="clienteForm" property="lista">
		 <logic:iterate name="clienteForm" property="lista" id="x">	
			<tr onclick="retornarProv('iClienteId','<bean:write name="x" property="iClienteId" />','vClienteCodigo','<bean:write name="x" property="vClienteCodigo" />','vClienteRazonSocial','<bean:write name="x" property="vClienteRazonSocial" />','nClienteNumeroDocumento','<bean:write name="x" property="nClienteNumeroDocumento" />','vClienteDireccion','<logic:notEmpty name="x" property="direccionclientes"><logic:iterate name="x" property="direccionclientes" id="z"><logic:equal name="z"  property="vPrincipal" value="1"><bean:write name="z" property="vDireccion" /></logic:equal></logic:iterate></logic:notEmpty>','vVentaPuntoLlegada','vClasificacion','<bean:write name="x" property="clasificacion.vNombre" />','fDescuentoCliente','<bean:write name="x" property="fDescuento" />')">
		 		<td><bean:write name="x" property="vClienteCodigo" /></td>
				<td><bean:write name="x" property="vClienteRazonSocial" /></td>
				<td><bean:write name="x" property="nClienteNumeroDocumento" /></td>
				
	    	</tr>
		</logic:iterate>
	  </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="clienteForm" property="paginas">	
    <bean:size id="listSizes" name="clienteForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="clienteForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="clienteForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
</script> 