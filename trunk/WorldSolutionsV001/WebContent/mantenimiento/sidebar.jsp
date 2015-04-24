<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
%>       
        <div id ="empresaSucursal" class="cont">
		        <ul id="empresax">
		        <%for (String per: listapermiso) {
				   if(per!=null){
				   if(per.equals("81")){%>
		        <div onclick="submenu('empresax')">
			        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
			        <strong >EMPRESA SUCURSAL</strong> <br>
			     </div>
			      <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("811")){ %>
		        <li id="empresas"><a href="empresaSucursal.do?metodo=listaEmpresa">
		            <span class="gestion">Mant. Empresas</span></a>
		        </li>
		         <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("812")){ %>
		        <li id="sucursal"><a href="empresaSucursal.do?metodo=listaSucursal">
		            <span class="gestion">Mant. Sucursal</span></a>
		        </li>
		         <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("813")){ %>
		        <li id="area"><a href="area.do?metodo=listaArea">
		            <span class="gestion">Mant. Area</span></a>
		        </li>
		         <% break; }}}%>
		       
		      </ul>   
         </div>
       
         <div id ="cont2" class="cont">
		        <ul id="personal">
		         <%
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("82")){ %>
		        <div onclick="submenu('personal')">
			        <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
			        <strong >PERSONAL</strong> <br>
			     </div>
			      <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("821")){ %>
		        <li id="ocupacion"><a href="ocupacion.do?metodo=listaOcupacion">
		            <span class="gestion">Mant. Ocupacion</span></a>
		        </li>
		         <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("822")){ %>
		        <li id="personas"><a href="personal.do?metodo=listaPersonal">
		            <span class="gestion">Mant. Personas</span></a>
		        </li>
		       
		        <% break; }}} %>
		      </ul>   
         </div>
           <div id ="cont2" class="cont">
		        <ul id="usuarios">
		         <% 
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("83")){ %>
		        <div onclick="submenu('usuarios')">
			        <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
			        <strong >USUARIOS</strong> <br>
			     </div>
			      <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("831")){ %>
		        <li id="perfil"><a href="perfil.do?metodo=listaPerfil">
		            <span class="gestion">Mant. Perfil</span></a>
		        </li>
		         <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("832")){ %>
		        <li id="usuario"><a href="usuario.do?metodo=listaUsuario">
		            <span class="gestion">Mant. Usuarios</span></a>
		        </li>
		         <% break; }}}%>
		       
		      </ul>   
         </div>
         
        <!-- iv  class="btn_admin" id="area" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="area.do?metodo=listaArea">MANT. DE AREA</a>
       </div
       <div class="btn_admin" id="perfil">
           <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
           <a href="perfil.do?metodo=listaPerfil">MANT. DE PERFIL</a>
       </div>
      <div class="btn_admin" id="ocupacion">
           <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
           <a href="ocupacion.do?metodo=listaOcupacion">MANT. DE OCUPACION</a>
       </div>
      
       <div class="btn_admin" id="personal">
       <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
        <a href="personal.do?metodo=listaPersonal" > MANT. DE PERSONAL</a>
       </div>
       <div class="btn_admin" id="usuarios">
       <img src="${pageContext.request.contextPath}/media/imagenes/cli.png" width="20" height="20" />
        <a href="usuario.do?metodo=listaUsuario">MANT. DE USUARIOS</a>
       </div>-->
        <% 
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("84")){ %>
       <div class="btn_admin" id="permisos">
       <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
        <a href="perfil.do?metodo=listaPermisos">PERMISOS</a>
       </div>
        <% break; }}} %>
       <div id ="cont2" class="cont">
		        <ul id="configuracion">
		         <% 
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("85")){ %>
		        <div onclick="submenu('configuracion')">
			        <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
			        <strong >CONFIGURACION</strong> <br>
			     </div>
			      <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("851")){ %>
		        <li id="ejercicioFiscal"><a href="configuracion.do?metodo=listaEjercicioFiscal">
		            <span class="gestion">Ejercicios fiscales</span></a>
		        </li>
		         <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("852")){ %>
		        <li id="periodo"><a href="configuracion.do?metodo=listaPeriodo">
		            <span class="gestion">Periodos</span></a>
		        </li>
		         <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("854")){ %>
		        <li id="impuestos"><a href="configuracion.do?metodo=listaImpuestos">
		            <span class="gestion">Impuestos</span></a>
		        </li>
		         <% break; }}}
		         for (String per: listapermiso) {
		   	     if(per!=null){
		         if(per.equals("853")){ %>
		        <li id="general"><a href="configuracion.do?metodo=listaConfiguracion">
		            <span class="gestion">Conf. General</span></a>
		        </li>
		         <% break; }}} %>
		      </ul>   
         </div>
        <!-- div class="btn_admin" id="opcionesMenu">
	       <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
	        <a href="perfil.do?metodo=listaPermisos">OPCIONES DEL MENU</a>
       </div> -->
      