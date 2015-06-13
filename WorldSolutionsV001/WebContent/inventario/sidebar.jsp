<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
%> 
      <div id ="cont2" class="cont">
		<ul id="categorias">
		 <%for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("11")){%>	    
        <div onclick="submenu('categorias')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
	        <strong >CATEGORIAS</strong> <br>
	     </div>
	     <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("111")){ %>
         <li id="categoria"><a href="categoria.do?metodo=listaCategoria"> <!--href="venta.do?metodo=listaVenta&mode=LContabilidad"-->
            <span class="gestion">MANT. DE CATEGORIAS</span></a>
        </li>    
      
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("112")){ %>
         <li id="subcategoria"><a href="categoria.do?metodo=listaSubCategoria">
            <span class="gestion">MANT. DE SUBCATEGORIA</span></a>
        </li>       
	   <% break; }}}%>		       
	   </ul>   
     </div>
     <div id ="cont2" class="cont">
		<ul id="productos">		
		 <%for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("12")){%>	
		<div onclick="submenu('productos')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
	        <strong >PRODUCTOS</strong> <br>
	     </div>
	     <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("121")){ %>
         <li id="producto"><a href="productos.do?metodo=listaProducto&iclasificacionId=1"> <!--href="venta.do?metodo=listaVenta&mode=LContabilidad"-->
            <span class="gestion">productos</span></a>
        </li>    
      
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("122")){ %>
         <li id="materiaPrima"><a href="productos.do?metodo=listaProducto&iclasificacionId=2">
            <span class="gestion">MATERIA PRIMA </span></a>
        </li>  
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("123")){ %>
         <li id="suministros"><a href="productos.do?metodo=listaProducto&iclasificacionId=3">
            <span class="gestion">SUMINISTROS Y REPUESTOS </span></a>
        </li> 
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("124")){ %>
         <li id="emvase"><a href="productos.do?metodo=listaProducto&iclasificacionId=4">
            <span class="gestion">EMVASES Y EMBALAJE </span></a>
        </li>       
	   <% break; }}}%>		       
	   </ul>   
     </div>
       
        <% 
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("131")){%> 
       <div class="btn_admin" id="distAlmacen">
        <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
         <a href="productos.do?metodo=listaDistAlmacen">DISTRIBUCION ALMACEN</a>
       </div>
         <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("132")){%> 
       <div class="btn_admin" id="ordenCompra">
        <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
         <a href="ingresoProducto.do?metodo=listaOrdenCompra">ORDEN DE COMPRA</a>
       </div>
      
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("133")){%> 
          <div class="btn_admin" id="servicios">
       <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
        <a href="productos.do?metodo=listaProducto&iclasificacionId=5" > SERVICIOS</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("134")){%> 
       <div class="btn_admin" id="produccion">
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
         <a  href="productos.do?metodo=listaProduccion"> Gesti&oacute;n de Producci&oacute;n</a>
       </div>      
        <% break; }}}%>