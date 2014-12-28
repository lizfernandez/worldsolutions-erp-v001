
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('proveedor.do?metodo=mantenimientoProveedor&mode=I',350,400)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','proveedor.do?metodo=iduProveedor&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('proveedor.do?metodo=mantenimientoProveedor&mode=F',350,350)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Proveedores</caption>
        <!-- tr>
            <th width="5%" >Nombre Proveedor:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        <th colspan="3"width="5%" >Operaciones</th>
        <th width="10%" align="left">C&oacute;digo</th>
        <th width="33%" align="left">Razon Social</th>
        <th width="13%" align="left">RUC / DNI</th>
        <th width="8%" align="left">Telefono</th> 
        <th width="33%" align="left">Direcci&oacute;n</th>
        <th width="13%" align="left">Estado</th>
       
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="proveedorForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del proveedores</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="proveedorForm" property="lista">
	     	<logic:iterate name="proveedorForm" property="lista" id="x">	
			<tr>
				<td align="center"><input type="checkbox" id="<bean:write name="x" property="iProveedorId" />"/></td> 
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('proveedor.do?metodo=mantenimientoProveedor&mode=U&id=<bean:write name="x" property="iProveedorId" />',350,350)" /></td>
		 	    <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iProveedorId" />','proveedor.do?metodo=iduProveedor&mode=D')" /></td>	
				<td><bean:write name="x" property="cProveedorCodigo" /></td>
				<td><bean:write name="x" property="vProveedorRazonSocial" /></td>
				<td><bean:write name="x" property="nProveedorNumeroDocumento" /></td>
				<td><bean:write name="x" property="vProveedorTelefono" /></td>
				<td><bean:write name="x" property="vProveedorDireccion" /></td>	
				<td><bean:write name="x" property="cEstadoCodigo" /></td>
		 
				
		
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
$("#proveedor,#proveedores").addClass("active");
</script>
 