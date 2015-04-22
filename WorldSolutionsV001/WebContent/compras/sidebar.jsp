<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
     for (String per: listapermiso) {
		if(per!=null){
	   if(per.equals("411")){%>   
       <div class="btn_admin" id="mantCompras">
           <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
           <a href="ingresoProducto.do?metodo=listaIngresoproducto">MANT. DE COMPRAS</a>
       </div>
         <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("412")){%> 
       <div  class="btn_admin" id="devolCompras" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="ingresoProducto.do?metodo=listaIngresoproductoDevolucion">Devoluci&oacute;n de Compras </a>
       </div>
         <% break;}}}%> 
  
       