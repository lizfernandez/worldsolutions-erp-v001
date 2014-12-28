<%@ page language="java"%>
<%@ page import="java.util.*" session="true"%>
<%@ page import="com.entities.Usuario" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%  String Fecha = (String) session.getAttribute("Fecha");
    Usuario usu = (Usuario) session.getAttribute("Usuario");
    if(usu!=null){
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>  
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
    <title><tiles:getAsString name="title" ignore="true"/></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery-1.4.2.js"></script>
    <!--  script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.widget.js"></script>    
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/interface.js"></script>-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/general.js"></script>
    <!--script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/acciones.js"></script-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/Plugin-estadisticas/extjs/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/Plugin-estadisticas/extjs/js/ext-all.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery-bp.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/navigation.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.datepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.multiselect.min.js"></script>
    
 
</head>
    <link href="${pageContext.request.contextPath}/media/styles/css/principal.css" rel="stylesheet" type="text/css"></link>
    <link href="${pageContext.request.contextPath}/media/styles/css/menu.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/css/tabla.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/css/botones.css" rel="stylesheet" type="text/css"/>
    <!-- link href="${pageContext.request.contextPath}/media/styles/css/menu-dock.css" rel="stylesheet" type="text/css"/ -->
    <link href="${pageContext.request.contextPath}/media/styles/css/paginacion.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/default/jquery-ui-1.7.1.custom.css" rel="stylesheet" type="text/css"  />
    <link href="${pageContext.request.contextPath}/media/Plugin-estadisticas/extjs/css/ext-all.css"rel="stylesheet" type="text/css"  />
    <link href="${pageContext.request.contextPath}/media/styles/css/formulario.css"rel="stylesheet" type="text/css"  />
    <link href="${pageContext.request.contextPath}/media/styles/css/letrasColor.css"rel="stylesheet" type="text/css"  />
    <link href="${pageContext.request.contextPath}/media/styles/css/menu_animate.css"rel="stylesheet" type="text/css"  />
    <link href="${pageContext.request.contextPath}/media/styles/css/jquery-ui-multiselect-widget.css"rel="stylesheet" type="text/css"  />
    
 
    <body>
       	<div id="CapaModal"></div>
        <div id="transp" class="transp"></div>
        <div id="base">
        <div id="cabecera">
				<div class="wrapper">
			            <div id="logo">				 
			              		 <a href="http://www.wordlsolutions.com"> 
			              		 <img alt="logo" src="${pageContext.request.contextPath}/media/imagenes/LOGO.png">
			             		  <!-- div id="logoImg"> </div>
					                <div id="logoLetra"> 
						                <p>
						                <span class="font_00">
						                	<span class="font_00"> <span class="color_18">Solutions </span> </span> <br> 
						                    <span class="color_11"><span class="color_11">ERP </span></span> </span> 
						                     
						                </p>
					                </div-->	             
			                      </a>    
			                </div><!--logo-->
			                <div id="datosLogeo">
			                      <span class="font_8" >
			                          <span class="color_15"><strong>Bienvenido:</strong>
			                            &ensp;<%=usu.getPersonal().getvPersonalNombres()+" "+usu.getPersonal().getvPersonalApellidoPaterno()+" "+usu.getPersonal().getvPersonalApellidoMaterno()%>
			                          </span>		                            
			                      
			                      &ensp;&ensp;&ensp;&ensp;&ensp;
			                      <a class="dock-item2" href="login.do?metodo=logout">
              							  <img src="${pageContext.request.contextPath}/media/imagenes/cancel.png" alt="Cerrar session" />
              							  <span class="color_16" >cerrar sesion  </span>
              					     
             					 </a>
             					 </span>
                            </div>
                     <div id="contenidoMenu"><tiles:insert attribute="menu"/> </div>
                            
	            </div> 
			</div>
        
		<div id="contenido">
			    <div id="btns" class="btnEntrada" onclick="menuVertical()"></div>
			    <div class="menuVertical">
			       <div class="btn_admin" id="home">
			          
			           <a href="#"><strong>Bienvenido:</strong>
			                            &ensp;<%=usu.getPersonal().getvPersonalNombres()+" "+usu.getPersonal().getvPersonalApellidoPaterno()%>
			                         </a>
			       </div> 
			      <div class="btn_admin" id="home">
			           <img src="${pageContext.request.contextPath}/media/imagenes/home.png" width="20" height="20" />
			           <a href="login.do?metodo=home">HOME</a>
			       </div>      
       		         <tiles:insert attribute="menuVertical"/>
       		       <div  class="logout btn_admin">
				       <img src="${pageContext.request.contextPath}/media/imagenes/sec.png" width="20" height="20" />
				        <a href="login.do?metodo=logout">   Cerrar Sesi&oacute;n</a>
			        </div>
       		    </div>
			    <div id="listado"> 
			        <div id="cont_admin"><tiles:insert attribute="body"/> </div> 
			    </div>            
			</div> 	    
            <div id="pie">
			    <div class="wrapper">  
			           <tiles:insert attribute="pie"/>
			    </div>
           </div>

            
        </div>
    </body>
</html>
<script>
function mensaje(opcion){
    alert("No tiene Permiso a "+opcion+",\n Consulte con su Administrador");
}
</script>
<% 
    }
    else{
    	response.sendRedirect("inicio.do");	
    }
 %>
