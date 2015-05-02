<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
     for (String per: listapermiso) {
		if(per!=null){
	   if(per.equals("511")){%>
	   
	   <div class="btn_admin" id="mantVentas">
           <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
           <a href="venta.do?metodo=listaVenta">MANT. DE VENTAS</a>
       </div>
       <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("512")){%> 
       <div  class="btn_admin" id="devolVentas" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="venta.do?metodo=listaVentaDevolucion">Devoluci&oacute;n de VENTAS </a>
       </div>
      <% break;}}}%> 
       