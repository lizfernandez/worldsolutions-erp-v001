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
	   if(per.equals("8211")){%>
        <td><button  class="button" onclick="popup('ocupacion.do?metodo=mantenimientoOcupacion&mode=I',350,220)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <% break; }}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("8214")){%>
        <td><button  class="button" onclick="eliminar('tabla','','ocupacion.do?metodo=iduOcupacion&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <% break; }}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("8213")){%>
        <td><button  class="button" onclick="popup('ocupacion.do?metodo=mantenimientoOcupacion&mode=F',350,220)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <% break; }}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Ocupacion</caption>
        <!-- tr>
            <th width="5%" >Nombre Ocupacion:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        <th colspan="3"width="5%" >Operaciones</th>
        <th width="10%" align="left">C&oacute;digo</th>
        <th width="15%" align="left">Descripci&oacute;n</th>
        <th width="8%" align="left">Estado</th>
       
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="ocupacionForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del ocupacion</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="ocupacionForm" property="lista">
	     	<logic:iterate name="ocupacionForm" property="lista" id="x">	
			<tr>
				<td align="center"><input type="checkbox" id="<bean:write name="x" property="iOcupacionId" />"/></td> 
				<td align="center">
				<% 
			   for (String per: listapermiso) {
			   if(per!=null){
			   if(per.equals("8212")){%>
				<img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('ocupacion.do?metodo=mantenimientoOcupacion&mode=U&id=<bean:write name="x" property="iOcupacionId" />',350,180)" />
		        <% break; }}}%>             
		        </td>
		 	    <td align="center">
		 	    <% 
			   for (String per: listapermiso) {
			   if(per!=null){
			   if(per.equals("8214")){%>
		 	    <img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iOcupacionId" />','ocupacion.do?metodo=iduOcupacion&mode=D')" />
		        <% break; }}}%>
		        </td>	
				<td><bean:write name="x" property="cOcupacionCodigo" /></td>
				<td><bean:write name="x" property="vOcupacionDescripcion" /></td>
				<td><bean:write name="x" property="cEstadoCodigo" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="ocupacionForm" property="paginas">	
    <bean:size id="listSizes" name="ocupacionForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="ocupacionForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="ocupacionForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();

$("#admin").addClass("active");
$("#personal").children('li').show();
$("#ocupacion").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#ocupacion").children('a').css("color","#D0D2D7");

</script> 

 