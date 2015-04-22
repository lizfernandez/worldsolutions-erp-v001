<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");

      for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("211")){%> 
       <div class="btn_admin" id="clasifCliente">
       <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="cliente.do?metodo=listaClasifCliente">CLAF. DE CLIENTES</a>
       </div>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("212")){ %>
       <div class="btn_admin" id="clientes">
           <img src="${pageContext.request.contextPath}/media/imagenes/cli.png" width="20" height="20" />
           <a href="cliente.do?metodo=listaCliente">MANT. DE CLIENTES</a>
       </div>
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("213")){ %>
       <div  class="btn_admin" id="cuentaCliente" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="estadoCuentaCliente.do?metodo=listaEstadoCuentaCliente">EST. CUENTA CLIENTE</a>
       </div>
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("214")){ %>
       <div class="btn_admin" id="cuentaLetra">
       <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
        <a href="estadoCuentaCliente.do?metodo=listaLetrasCliente" >EST. CUENTA LETRAS</a>
       </div>
       <% break; }}} %>
       