
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="personal" styleId="formPersonal">
    <tr>
	    <td align="right">C&oacute;digo:</td>
	    <td>   
	        <html:text property="cPersonalCodigo"  styleId="cPersonalCodigo"  onkeyup="return mayuscula('cPersonalCodigo')" onkeypress="return LetrasNumeros(event)" maxlength="5"/>
	        <span id="m_cPersonalCodigo" class="importante"></span>
	    </td>
        <td align="right">Nombres:</td>
	    <td><html:text property="vPersonalNombres" styleId="vPersonalNombres" onkeyup="return mayuscula('vPersonalNombres')"/>
	        <span id="m_vPersonalNombres" class="importante"></span>
	    </td>
	    <td rowspan="2"><button  class="button"  onclick="buscarPopup('tab-grupo')">
                <span class="find">Buscar</span>
            </button>
        </td>
	 </tr> 
	 <tr>
	   <td align="right">Ap. Paterno:</td>
	   <td><html:text property="vPersonalApellidoPaterno" styleId="vPersonalApellidoPaterno"  onkeyup="return mayuscula('vPersonalApellidoPaterno')"/>
	        <span id="m_vPersonalApellidoPaterno" class="importante"></span>
	    </td>
	     <td align="right">Ap. Materno:</td>
	    <td><html:text property="vPersonalApellidoMaterno" styleId="vPersonalApellidoMaterno" onkeyup="return mayuscula('vPersonalApellidoMaterno')"/>
	        <span id="m_vPersonalApellidoMaterno" class="importante"></span>
	    </td>	    
    </tr>
<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaPersonal" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Personal</caption>
        <!-- tr>
            <th width="5%" >Apellidos Personal:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
        -->
    <thead>
    <tr >
        <th align="left">C&oacute;digo</th>
        <th align="left">Nombres</th>
        <th align="left">Ap. Paterno</th>
        <th align="left">Ap. Materno</th>
        
      </tr>
    </thead>
    <tbody>
	     <logic:empty name="personalForm" property="lista">
				<tr>
					<td colspan="11">No hay informaci&oacute;n del personal</td>
				</tr>
	     </logic:empty>
         <logic:notEmpty name="personalForm" property="lista">
		 <logic:iterate name="personalForm" property="lista" id="x">	
			<tr onclick="retornar($_GET('iPersonalId') ,'<bean:write name="x" property="iPersonalId" />',$_GET('codigo'),'<bean:write name="x" property="cPersonalCodigo" />',$_GET('nombre'),'<bean:write name="x" property="vPersonalNombres" />  <bean:write name="x" property="vPersonalApellidoPaterno" />','fSueldo','<bean:write name="x" property="fSueldo" />','vOcupacionDescripcion','<bean:write name="x" property="ocupacion.vOcupacionDescripcion" />')">
		 		<td><bean:write name="x" property="cPersonalCodigo" /></td>
				<td><bean:write name="x" property="vPersonalNombres" /></td>
				<td><bean:write name="x" property="vPersonalApellidoPaterno" /></td>
				<td><bean:write name="x" property="vPersonalApellidoMaterno" /></td>
				
	    	</tr>
		</logic:iterate>
	  </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="personalForm" property="paginas">	
    <bean:size id="listSizes" name="personalForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="personalForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="personalForm" property="paginas" id="p">				
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