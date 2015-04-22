<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
     for (String per: listapermiso) {
		if(per!=null){
	   if(per.equals("111")){%>     
      
      <div class="btn_admin" id="categoria">
           <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
           <a href="categoria.do?metodo=listaCategoria">MANT. DE CATEGORIAS</a>
       </div>
       <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("112")){%> 
       <div  class="btn_admin" id="subcategoria" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="categoria.do?metodo=listaSubCategoria">MANT. DE SUBCATEGORIAS</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("113")){%> 
        <div class="btn_admin" id="producto">
       <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
        <a href="productos.do?metodo=listaProducto&iclasificacionId=1" > PRODUCTOS</a>
       </div>
       <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("114")){%> 
        
       <div class="btn_admin" id="materiaPrima">
       <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
        <a href="productos.do?metodo=listaProducto&iclasificacionId=2">MATERIAS PRIMAS</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("115")){%> 
       <div class="btn_admin" id="suministros">
       <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
        <a href="productos.do?metodo=listaProducto&iclasificacionId=3"> SUMINISTROS Y REPUESTOS</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("116")){%> 
       <div class="btn_admin" id="emvase">
        <img src="${pageContext.request.contextPath}/media/imagenes/ped.png" width="20" height="20" />
         <a href="productos.do?metodo=listaProducto&iclasificacionId=4"> EMVASES Y EMBALAJE</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("117")){%> 
          <div class="btn_admin" id="servicios">
       <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
        <a href="productos.do?metodo=listaProducto&iclasificacionId=5" > SERVICIOS</a>
       </div>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("118")){%> 
       <div class="btn_admin" id="produccion">
        <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
         <a  href="productos.do?metodo=listaProduccion"> Gesti&oacute;n de Producci&oacute;n</a>
       </div>      
        <% break; }}}%>