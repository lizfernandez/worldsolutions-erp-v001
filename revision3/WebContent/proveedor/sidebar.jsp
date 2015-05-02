<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
     for (String per: listapermiso) {
		if(per!=null){
	   if(per.equals("311")){%> 
       <div class="btn_admin" id="proveedores">
           <img src="${pageContext.request.contextPath}/media/imagenes/cli.png" width="20" height="20" />
           <a href="proveedor.do?metodo=listaProveedor">MANT. DE PROVEEDOR</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("312")){%> 
       <div  class="btn_admin" id="cuentaProveedores" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="estadoCuentaProveedor.do?metodo=listaEstadoCuentaProveedor">EST. CUENTA PROVEEDOR</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("313")){%> 
       <div class="btn_admin" id="cuentaLetra">
       <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
        <a href="estadoCuentaProveedor.do?metodo=listaLetrasProveedor" >LETRAS POR PAGAR</a>
       </div>
        <% break;}}}%> 
       