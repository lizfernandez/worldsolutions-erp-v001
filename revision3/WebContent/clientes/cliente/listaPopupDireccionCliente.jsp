
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="cliente" styleId="formPersonal">
    <tr>
	    <td align="right">C&oacute;digo:</td>
	    <td>   
	        <html:text property="vClienteCodigo"  styleId="vClienteCodigo"  onkeyup="return mayuscula('vClienteCodigo')" onkeypress="return LetrasNumeros(event)" maxlength="5"/>
	        
	    </td>
        <td align="right">Ruc:</td>
	   <td><html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  onkeypress="return Numeros(event)"/>
	        <span id="m_vPersonalApellidoPaterno" class="importante"></span>
	    </td>
	    <td rowspan="2"><button  class="button"  onclick="buscarPopup('tab-grupo')">
                <span class="find">Buscar</span>
            </button>
        </td>
	 </tr> 
	 <tr>
	   <td align="right">Raz&oacute;n Social:</td>
	    <td colspan="3">
	    <html:text property="vClienteRazonSocial" styleId="vClienteRazonSocial" onkeyup="return mayuscula('vClienteRazonSocial')" size="45"/>
	        
	    </td>
	   	    
    </tr>
<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaCliente" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Cliente</caption>
     <thead>
    <tr >
        <th align="left">Direcci&oacute;n</th>
        <th align="left">Pricipal</th>    
        
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
		  <logic:iterate name="x" property="direccionclientes" id="z">
			<tr onclick="retornar('iClienteId','<bean:write name="x" property="iClienteId" />','vClienteCodigo','<bean:write name="x" property="vClienteCodigo" />','vVentaPuntoLlegada','<bean:write name="z" property="vDireccion" />')">
		 		<td><bean:write name="z" property="vDireccion" /></td>
		 		 <logic:equal name="z" property="vPrincipal" value="1" >
				    <td>PRINCIPAL</td>
			    </logic:equal> 
			    <logic:equal name="z" property="vPrincipal" value="0" >
				    <td>SEGUNDARIO</td>
			    </logic:equal> 
				
	    	</tr>
	    </logic:iterate>
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
	<div class="btnPagInactivo" id="Next" >&emsp;  </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
</script>   