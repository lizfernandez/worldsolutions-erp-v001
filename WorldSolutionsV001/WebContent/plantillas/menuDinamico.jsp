<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
if(listapermiso!=null){
%>
 <!-- <div id="menu">
      <div class="dock" id="dock2" >
          <div class="dock-container2">
              <!--% if(usu.getPerfil().getcInventario().equals("1")){%>
              <a class="dock-item2" href="productos.do?metodo=listaProducto&iclasificacionId=1">
                  <img src="${pageContext.request.contextPath}/media/imagenes/design.png" alt="Inventario" />
                  <span>Inventario</span>
              </a>
               <!--% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Inventario')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/design_enable.png" alt="Inventario" />
                  <span>Inventario</span>
              </a> 
              <!%}if(usu.getPerfil().getcProveedor().equals("1")){%>
              <a class="dock-item2" href="proveedor.do?metodo=listaProveedor">
                  <img src="${pageContext.request.contextPath}/media/imagenes/folder_user.png" alt="Proveedores" />
                  <span>Proveedores</span>
              </a>
              <!% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Proveedores')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/folder_user_enable.png" alt="Proveedores" />
                  <span>Proveedores</span>
              </a>
               <!% }if(usu.getPerfil().getcClientes().equals("1")){%>
              <a class="dock-item2" href="cliente.do?metodo=listaCliente">
                  <img src="${pageContext.request.contextPath}/media/imagenes/user_group.png" alt="Clientes" />
                  <span>Clientes</span>
              </a>
               <"% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Clientes')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/user_group_enable.png" alt="Clientes" />
                  <span>Clientes</span>
              </a>
               <"% }if(usu.getPerfil().getcCompras().equals("1")){%>
              <a class="dock-item2" href="ingresoProducto.do?metodo=listaIngresoproducto">
                  <img src="${pageContext.request.contextPath}/media/imagenes/delivery.png" alt="Compras" />
                  <span>Compras</span>
              </a>
               <!% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Compras')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/delivery_enable.png" alt="Compras" />
                  <span>Compras</span>
              </a>
               <!% }if(usu.getPerfil().getcVentas().equals("1")){%>
              <a class="dock-item2" href="venta.do?metodo=listaVenta">
                  <img src="${pageContext.request.contextPath}/media/imagenes/address_book.png" alt="Ventas" />
                  <span>Ventas</span>
              </a>
              <!% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Ventas')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/address_book_enable.png" alt="Ventas" />
                  <span>Ventas</span>
              </a>
               <!% }if(usu.getPerfil().getcVentas().equals("1")){%>
              <a class="dock-item2" href="contabilidad.do?metodo=listaVenta">
                  <img src="${pageContext.request.contextPath}/media/imagenes/calculator.png" alt="Contabilidad" />
                  <span>Contabilidad</span>
              </a>
              <!% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Contabilidad')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/calculator_enable.png" alt="Contabilidad" />
                  <span>Contabilidad</span>
              </a>
               <!% }if(usu.getPerfil().getcEstadisticas().equals("1")){%>
              <a class="dock-item2"  href="estadistica.do?metodo=estadisticaGeneral&mode=GE" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/estadisticas.png" alt="Estadisticas" />
                  <span>Estadisticas</span>
              </a>
              <!% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Estadisticas')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/estadisticas_enable.png" alt="Estadisticas" />
                  <span>Estadisticas</span>
              </a>
               <!% }if(usu.getPerfil().getcMantenimiento().equals("1")){%>
              <a class="dock-item2" href="perfil.do?metodo=listaPerfil">
                  <img src="${pageContext.request.contextPath}/media/imagenes/tools.png" alt="Recursos" />
                  <span>Mantenimiento</span>
              </a>
              <!% } else{%>
               <a class="dock-item2" onclick="fn_acceso('Mantenimiento')" >
                  <img src="${pageContext.request.contextPath}/media/imagenes/tools_enable.png" alt="Mantenimiento" />
                  <span>Mantenimiento</span>
              </a>
              <!% }%>
              <a class="dock-item2" href="login.do?metodo=logout">
                 <img src="${pageContext.request.contextPath}/media/imagenes/CerrarS.png" alt="Cerrar" />
                 <span>Cerrar</span>
              </a>
              
          </div>
      </div>
</div> Menu -->


<!-- div id="header"></div> -->
	<div id="navigation" class="container">
	<% for (String per: listapermiso) {
		if(per!=null){
	   if(per.equals("10")){%>
		<div id="inventario" class="pri-nav"><div><a href="productos.do?metodo=listaProducto&iclasificacionId=1">inventario</a></div></div>
	 <%}if(per.equals("20")){ %>	
		<div id="cliente" class="pri-nav"><div><a href="cliente.do?metodo=listaCliente">cliente</a></div></div>
	 <%}if(per.equals("30")){ %>
		<div id="proveedor" class="pri-nav"><div><a href="proveedor.do?metodo=listaProveedor">proveedor</a></div></div>
     <%} if(per.equals("40")){%>
		<div id="compra" class="pri-nav"><div><a href="ingresoProducto.do?metodo=listaIngresoproducto">compra</a></div></div>
	 <%} if(per.equals("50")){%>
		<div id="venta" class="pri-nav"><div><a href="venta.do?metodo=listaVenta">venta</a></div></div>
	 <%} if(per.equals("60")){%>
		<div id="contabilidad" class="pri-nav"><div><a href="contabilidad.do?metodo=listaVenta">contabilidad</a></div></div>
	 <%}if(per.equals("70")){ %>
		<div id="estadistica" class="pri-nav"><div><a href="estadistica.do?metodo=estadisticaGeneral&mode=GE">estadistica</a></div></div>
	 <%} if(per.equals("80")){%>
		<div id="admin" class="pri-nav"><div><a href="perfil.do?metodo=listaPerfil">admin</a></div></div>
	 <%}}
	 }// for %>
	 
	</div>
	<%} //if %>
	
	<!-- div class="container">
		<div class="content">
			<div id="content-title"></div>
			
		</div> 
	</div>-->
