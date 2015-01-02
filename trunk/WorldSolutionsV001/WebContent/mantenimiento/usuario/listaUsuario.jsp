
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('usuario.do?metodo=mantenimientoUsuario&mode=I',400,350)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','usuario.do?metodo=iduUsuario&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('usuario.do?metodo=mantenimientoUsuario&mode=F',400,350)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de usuario</caption>
        <!-- tr>
            <th width="5%" >Nombre usuario:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        <th colspan="3"width="5%" >Operaciones</th>
        <th width="10%" align="left">Usuario</th>
        <th width="10%" align="left">Nombres</th>
        <th width="10%"align="left">Ap. Paterno</th>
        <th width="10%"align="left">Ap. Materno</th>
        <th width="10%" align="left">Perfil</th>
        <th width="8%" align="left">Estado</th>
         
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="usuarioForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del usuario</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="usuarioForm" property="lista">
	     	<logic:iterate name="usuarioForm" property="lista" id="x">	
			<tr>
				<td align="center"><input type="checkbox" id="<bean:write name="x" property="iUsuarioId" />"/></td> 
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('usuario.do?metodo=mantenimientoUsuario&mode=U&id=<bean:write name="x" property="iUsuarioId" />',350,250)" /></td>
		 	    <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iUsuarioId" />','usuario.do?metodo=iduUsuario&mode=D')" /></td>	
				<td><bean:write name="x" property="vUsuarioLogin" /></td>
				<td><bean:write name="x" property="personal.vPersonalNombres" /></td>
				<td><bean:write name="x" property="personal.vPersonalApellidoPaterno" /></td>
				<td><bean:write name="x" property="personal.vPersonalApellidoMaterno" /></td>
				<td><bean:write name="x" property="perfil.vPerfilDescripcion" /></td>
				<td><bean:write name="x" property="cEstadoCodigo" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="usuarioForm" property="paginas">	
    <bean:size id="listSizes" name="usuarioForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="usuarioForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&lt;</div>
	<div class="btnPagInactivo" id="back">&lt;&lt; </div>	
	<div id="pag">	
		<logic:iterate name="usuarioForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&gt;&gt;  </div>
	<div class="btnPagInactivo" id="Final" >&gt; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#admin,#usuarios").addClass("active");
</script> 
 