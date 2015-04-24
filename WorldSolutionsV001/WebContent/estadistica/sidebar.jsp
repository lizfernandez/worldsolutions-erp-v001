<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");

      for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("711")){%> 
	   <div class="btn_admin" id="general">
           <img src="${pageContext.request.contextPath}/media/imagenes/est.png" width="20" height="20" />
           <a href="estadistica.do?metodo=estadisticaGeneral&mode=GE">Gr&aacute;fico General</a>
       </div>
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("712")){ %>
       <div  class="btn_admin" id="compras" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="estadistica.do?metodo=estadisticaGeneral&mode=CO">Gr&aacute;fico Compras</a>
       </div>
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("713")){ %>
       <div  class="btn_admin" id="ventas" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="estadistica.do?metodo=estadisticaGeneral&mode=VE">Gr&aacute;fico ventas </a>
       </div>
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("714")){ %>
       <div  class="btn_admin" id="clientes" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="estadistica.do?metodo=estadisticaGeneral&mode=CL">Gr&aacute;fico clientes </a>
       </div>
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("715")){ %>
       <div  class="btn_admin" id="proveedores" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="estadistica.do?metodo=estadisticaGeneral&mode=PR">Gr&aacute;fico Proveedores</a>
       </div>
      <% break; }}} %>
       