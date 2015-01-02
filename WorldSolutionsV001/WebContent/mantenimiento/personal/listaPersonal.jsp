
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('personal.do?metodo=mantenimientoPersonal&mode=I',350,450)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','personal.do?metodo=iduPersonal&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('personal.do?metodo=mantenimientoPersonal&mode=F',350,450)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
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
        <th colspan="3">Operaciones</th>
        <th align="left">C&oacute;digo</th>
        <th align="left">Nombres</th>
        <th align="left">Ap. Paterno</th>
        <th align="left">Ap. Materno</th>
        <th align="left">Tipo Doc.</th>
        <th align="left">Nro Doc.</th>
        <th align="left">Area</th>
        <th align="left">Estado</th>     
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
			<tr>
				<td align="center"><input type="checkbox" id="<bean:write name="x" property="iPersonalId" />"/></td> 
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('personal.do?metodo=mantenimientoPersonal&mode=U&id=<bean:write name="x" property="iPersonalId" />',350,350)" /></td>
		 	    <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iPersonalId" />','personal.do?metodo=iduPersonal&mode=D')" /></td>
		 		<td><bean:write name="x" property="cPersonalCodigo" /></td>
				<td><bean:write name="x" property="vPersonalNombres" /></td>
				<td><bean:write name="x" property="vPersonalApellidoPaterno" /></td>
				<td><bean:write name="x" property="vPersonalApellidoMaterno" /></td>
				<td><bean:write name="x" property="tipodocumento.vTipoDocuumentoDescripcion" /></td>
				<td><bean:write name="x" property="nPersonalNumeroDocumento" /></td>
				<td><bean:write name="x" property="area.vAreaDescripcion" /></td>
				<td><bean:write name="x" property="cEstadoCodigo" /></td>
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
$("#admin,#personal").addClass("active");
</script> 