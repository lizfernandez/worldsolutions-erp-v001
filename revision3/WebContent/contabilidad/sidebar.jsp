<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
%>
     
		<div id ="cont2" class="cont">
		<ul id="clientes">
		 <%for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("61")){%>	    
        <div onclick="submenu('clientes')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/cli.png" width="20" height="20" />
	        <strong >CLIENTES</strong> <br>
	     </div>
	     <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("611")){ %>
         <li id="ventas"><a href="contabilidad.do?metodo=listaVenta"> <!--href="venta.do?metodo=listaVenta&mode=LContabilidad"-->
            <span class="gestion">Ventas</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("612")){ %>
         <li id="ventasDevolucion"><a href="contabilidad.do?metodo=listaVentaDevolucion">
            <span class="gestion">Devoluci&oacute;n de Ventas </span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("613")){ %>
         <li id="estadoCuentaCliente"><a href="contabilidad.do?metodo=listaEstadoCuentaCliente">
            <span class="gestion">Estado Cuenta Cliente</span></a>
        </li>   
         <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("614")){ %>
         <li id="estadoCuentaCliente"><a href="contabilidad.do?metodo=listaEstadoCuentaCliente">
            <span class="gestion">Estado Letra Cliente</span></a>
        </li>     
        <% break; }}} %>      
    </ul>
 
    <ul id="proveedores">
     <%for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("62")){%>	
        <div onclick="submenu('proveedores')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
	        <strong >PROVEEDORES</strong> <br>
	     </div>  
	     <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("621")){ %>    
         <li id="compras"><a href="contabilidad.do?metodo=listaIngresoproducto">
            <span class="gestion">Compras</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("622")){ %>
         <li id="comprasDevolucion"><a href="contabilidad.do?metodo=listaIngresoproductoDevolucion">
            <span class="gestion">Devoluci&oacute;n de Compras </span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("623")){ %>
         <li id="estadoProveedor"><a href="contabilidad.do?metodo=listaEstadoCuentaProveedor">
            <span class="gestion">Estado Cuenta Proveedor</span></a>
        </li>         
         <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("624")){ %>
         <li id="estadoProveedor"><a href="contabilidad.do?metodo=listaEstadoCuentaProveedor">
            <span class="gestion">Estado Letra Proveedor</span></a>
        </li> 
        <% break; }}}%>      
     </ul>
     <ul id="existencias">
     <% 
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("63")){ %>
        <div onclick="submenu('existencias')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
	        <strong >EXISTENCIAS</strong> <br>
	     </div> 
       <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("631")){ %>
       <li id="productos"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=1">
            <span class="gestion">Mercaderias</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("632")){ %>
        <li id="materiaPrima"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=2">
            <span class="gestion">Materia primas</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("633")){ %>
        <li id="suministros"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=3">
            <span class="gestion">Suministros y Repuestos</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("634")){ %>
        <li id="embases"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=4">
            <span class="gestion">Embases y Embalajes</span></a>
        </li>
        <% break; }}} %>
     </ul> 
     <ul id="tesoreria">
     <% 
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("64")){ %>
          <div onclick="submenu('tesoreria')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
	        <strong >TESORERIA</strong> <br>
	     </div>
	     <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("641")){ %>
        <li id="cuentas"><a href="contabilidad.do?metodo=listaCuentas">
            <span class="gestion">Ingreso de Cuentas</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("642")){ %>
        <li id="cajaBancos"><a href="contabilidad.do?metodo=listaCajaBanco">
            <span class="gestion">Caja y bancos</span></a>
        </li> 
        <% break; }}}%>      
     </ul>
      <ul id="planillas">
      <% 
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("65")){ %>
          <div onclick="submenu('planillas')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
	        <strong >PLANILLA</strong> <br>
	     </div>
	     <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("651")){ %>
	   <li id="parametros"><a href="configuracion.do?metodo=listaConfiguracion">
            <span class="gestion">Parametros de planilla</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("652")){ %>
        <li id="planilla"><a href="contabilidad.do?metodo=listaPlanilla">
            <span class="gestion">registro de planilla</span></a>
        </li>
        <% break; }}}%>
           
     </ul>
     <ul id="plancontable">
     <% 
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("66")){ %>
        <div onclick="submenu('plancontable')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
	        <strong >PLAN CONTABLE</strong> <br>
	     </div>
	     <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("661")){ %>
        <li id="diario"><a href="contabilidad.do?metodo=listaLibroDiario">
            <span class="gestion">Libro Diario</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("662")){ %>
        <li id="mayor"><a href="contabilidad.do?metodo=listaLibroMayor">
            <span class="gestion">Libro Mayor</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("663")){ %>
        <li id="balance"><a href="contabilidad.do?metodo=listaBalanceGeneral">
            <span class="gestion">Balance General</span></a>
        </li>
        <% break; }}}
         for (String per: listapermiso) {
   	     if(per!=null){
         if(per.equals("664")){ %>
        <li id="estadoFinanciero"><a href="contabilidad.do?metodo=listaEstadoFinanciero">
            <span class="gestion">Estados Financieros</span></a>
        </li-->
        <% break; }}} %>
      </ul>   
</div>

             