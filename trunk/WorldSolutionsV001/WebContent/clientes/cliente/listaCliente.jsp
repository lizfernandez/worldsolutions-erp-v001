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
	   if(per.equals("2121")){%>
        <td><button  class="button" onclick="popup('cliente.do?metodo=mantenimientoCliente&mode=I',380,520)">
                <span class="new">Nuevo</span>
            </button>
        </td>
         <% break; }}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("2124")){%>
        <td><button  class="button" onclick="eliminar('tabla','','cliente.do?metodo=iduCliente&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
         <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("2123")){%>
        <td><button  class="button" onclick="popup('cliente.do?metodo=mantenimientoCliente&mode=F',380,520)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("2125")){%>
        <td><button class="button" onclick="fn_exportarExcel('cliente.do?metodo=exportarExcel&plantilla=cliente')">
                <span class="excel">Exportar</span>
            </button>
        </td>
        <% break;}}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Clientes</caption>
        <!-- tr>
            <th width="5%" >Nombre Cliente:</th>
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
		<logic:empty name="clienteForm" property="lista">
			<tr>
				<td colspan="8">No hay informaci&oacute;n del clientes</td>
			</tr>
		</logic:empty>
		<logic:notEmpty name="clienteForm" property="lista">
			<logic:iterate name="clienteForm" property="lista" id="x">
				<tr>
					<td align="center"><input type="checkbox"
						id="<bean:write name="x" property="iClienteId" />" /></td>
					<td align="center">
					<%
					for (String per: listapermiso) {
					if(per!=null){
					if(per.equals("2122")){%>
					<img title="Editar"
						src="${pageContext.request.contextPath}/media/imagenes/edit.png"
						onclick="popup('cliente.do?metodo=mantenimientoCliente&mode=U&id=<bean:write name="x" property="iClienteId" />',380,520)" />
				    <% break; }}}%>
				    </td>
					<td align="center">
					 <%
				     for (String per: listapermiso) {
		             if(per!=null){
	                 if(per.equals("2124")){%>
					<img title="Eliminar"
						src="${pageContext.request.contextPath}/media/imagenes/delete.png"
						onclick="eliminar('tabla','<bean:write name="x" property="iClienteId" />','cliente.do?metodo=iduCliente&mode=D')" />
					<% break; }}}%>
					</td>
					<td><bean:write name="x" property="vClienteCodigo" /></td>
					<td><bean:write name="x" property="vClienteRazonSocial" /></td>
					<td><bean:write name="x" property="nClienteNumeroDocumento" /></td>
					<td><bean:write name="x" property="nClienteTelefono" /></td>
					<td><logic:notEmpty name="x" property="direccionclientes">	
							<logic:iterate name="x" property="direccionclientes" id="z">
								<logic:equal name="z" property="vPrincipal" value="1">
									<bean:write name="z" property="vDireccion" /><br>
								</logic:equal>
							</logic:iterate>
						</logic:notEmpty></td>
					<td><bean:write name="x" property="cEstadoCodigo" /></td>



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
$("#cliente,#clientes").addClass("active");
</script> 

 