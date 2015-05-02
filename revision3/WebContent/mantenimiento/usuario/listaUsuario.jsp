<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
//if(listapermiso!=null){	
%> 
<table border="0">
    <tr>
       <% 
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("8321")){%>
        <td><button  class="button" onclick="popup('usuario.do?metodo=mantenimientoUsuario&mode=I',400,350)">
                <span class="new">Nuevo</span>
            </button>
        </td>
          <% break; }}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("8324")){%>
        <td><button  class="button" onclick="eliminar('tabla','','usuario.do?metodo=iduUsuario&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
          <% break; }}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("8323")){%>
        <td><button  class="button" onclick="popup('usuario.do?metodo=mantenimientoUsuario&mode=F',400,350)">
                <span class="find">Buscar</span>
            </button>
        </td>
          <% break; }}}%>
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
        <th width="10%" align="left">Sucural</th>
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
				<td align="center">
				  <%
			   for (String per: listapermiso) {
			   if(per!=null){
			   if(per.equals("8322")){%>
				<img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('usuario.do?metodo=mantenimientoUsuario&mode=U&id=<bean:write name="x" property="iUsuarioId" />',400,350)" />
		          <% break; }}}%>
		        </td>
		 	    <logic:notEqual name="x" property="perfil.vPerfilDescripcion" value="ADMINISTRADOR">
		 	    <td align="center">
		 	      <% 
				   for (String per: listapermiso) {
				   if(per!=null){
				   if(per.equals("8324")){%>
		 	    <img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iUsuarioId" />','usuario.do?metodo=iduUsuario&mode=D')" />
		          <% break; }}}%>
		        </td>
		 	    </logic:notEqual>
		 	    <logic:equal name="x" property="perfil.vPerfilDescripcion" value="ADMINISTRADOR">
		 	    <td align="center"></td>
		 	    </logic:equal>	
				<td><bean:write name="x" property="vUsuarioLogin" /></td>
				<td><bean:write name="x" property="personal.vPersonalNombres" /></td>
				<td><bean:write name="x" property="personal.vPersonalApellidoPaterno" /></td>
				<td><bean:write name="x" property="personal.vPersonalApellidoMaterno" /></td>
				<td><bean:write name="x" property="sucursal.vSucursalNombre" /></td>
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

$("#admin").addClass("active");
$("#usuarios").children('li').show();
$("#usuario").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#usuario").children('a').css("color","#D0D2D7");

</script> 
 