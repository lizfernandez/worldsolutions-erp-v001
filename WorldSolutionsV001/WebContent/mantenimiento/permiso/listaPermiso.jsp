
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
//if(listapermiso!=null){	
%> 
<table border="0">
    <tr> 
        <% 
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("841")){%>
        <td><button  class="button" onclick="fn_GrabarPermisos()">
                <span class="save">Guardar</span>
            </button>
        </td>
          <% break;}}}%>
        <td>
        <span id="resultado"></span>
        </td>
        
        <!-- td><button  class="button" onclick="popup('perfil.do?metodo=mantenimientoPerfil&mode=F',350,180)">
                <span class="find">Buscar</span>
            </button>
        </td> -->
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
        <caption>Lista de Permisos </caption>
        <!--  tr>
            <th width="5%" >Nombre Perfil:</th>
            <td colspan="7"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr-->

    <thead>
     <tr>  
	       <!--Lista de usuarios  -->
	        <td width="50%">
	        <table class="tabladetalle" border="0" width="100%" id="tabla">
	            <thead>
		           <tr> 
			           <th colspan="4">LISTA USUARIOS
			           </th>
		            </tr>
		            <tr> 
			           <th>       </th>
			           <th align="left"> Nombres      </th>
			           <th align="left"> Usuario      </th>
			           <th align="left"> Perfil      </th>
		            </tr>
	             </thead>
	             <tbody>
	             <!--Lista de usuarios con permisos otorgados  -->
	              <logic:iterate name="perfilForm" property="listaUsuarioPermiso" id="u" indexId="i">
		                <tr onclick="permisoUsuario('<bean:write name="u" property="usuario.iUsuarioId" />','<bean:write name="u" property="idpermisos" />','<bean:write name="u" property="usuario.personal.vPersonalNombres" />  <bean:write name="u" property="usuario.personal.vPersonalApellidoPaterno" />')"> 
		                   <td align="center"><input type="checkbox" id="usu_<bean:write name="u" property="usuario.iUsuarioId" />" checked/></td>
		                   <td><bean:write name="u" property="usuario.personal.vPersonalNombres" />  <bean:write name="u" property="usuario.personal.vPersonalApellidoPaterno" /></td>
				           <td><bean:write name="u" property="usuario.vUsuarioLogin" /></td>
				           <td><bean:write name="u" property="usuario.perfil.vPerfilDescripcion" /></td>
			            </tr>
			       </logic:iterate>
			       <!--Lista de usuarios Sin permisos otorgados  -->
			       <logic:iterate name="perfilForm" property="listaUsuario" id="u" indexId="i">
		                <tr onclick="permisoUsuario('<bean:write name="u" property="iUsuarioId" />','0','<bean:write name="u" property="personal.vPersonalNombres" />  <bean:write name="u" property="personal.vPersonalApellidoPaterno" />')"> 
		                   <td align="center"><input type="checkbox" id="usu_<bean:write name="u" property="iUsuarioId" />" /></td>
		                   <td><bean:write name="u" property="personal.vPersonalNombres" />  <bean:write name="u" property="personal.vPersonalApellidoPaterno" /></td>
				           <td><bean:write name="u" property="vUsuarioLogin" /></td>
				           <td><bean:write name="u" property="perfil.vPerfilDescripcion" /></td>
			            </tr>
			       </logic:iterate>
	             </tbody>
	        </table>
	        </td> 
	        <!--end lista de usuarios  -->
	        <!--Lista de contenido del sistema  -->
	        <td width="50%"  >
	        <table class="tabladetalle" border="0" width="100%" id="tablaPermisos">
	            <thead>
		           <tr> 
			           <th>
			          <span  id="permisoUsuario">PERMISOS DEL SISTEMA</span> 
			             <input type="text" id="iUsuarioId" class="textInvisible" value=""/> 
			             <input type="text" id="iPermisoId" class="textInvisible" value=""/> 
			           </th>
		            </tr>
		            
	             </thead>
	             <tbody>
	              	<!--Lista contenido cabecera del sistema -->	
	             <logic:iterate name="perfilForm" property="lista" id="x" indexId="i">
	             <logic:equal name="x" property="cEstadoCodigo" value="AC">
	              <tr>
	              <th width="" align="left">
	                 <span id="img_<bean:write name="x" property="idMenu" />" style="width: 2%">
	      				  <img    src="${pageContext.request.contextPath}/media/imagenes/mas.png"
                        onclick="fn_pagosMas('<bean:write name="x" property="idMenu" />')" />
          			  </span>
			          <input type="checkbox" id="<bean:write name="x" property="vCodigo" />" onclick="Cktodo('<bean:write name="x" property="vCodigo" />','<bean:write name="x" property="idMenu" />')" 
			           	  		class="ck_<bean:write name="x" property="idMenu" />"/>
			           <bean:write name="x" property="vMenu" />
			           	<!--Lista Opciones -->		            
			           <table class="tabladetalle" border="0" style="display: none; width: 47%" id="op<bean:write name="x" property="idMenu" />">	
							<tbody>
				           		   <logic:iterate name="x" property="menutitulo" id="d" indexId="i">
				           		   <logic:equal name="d" property="cEstadoCodigo" value="AC">	           		    
									<tr>
				                      <td>
					                      	<div style="margin-left: 10%"  id="op<bean:write name="x" property="idMenu" />" >
								           		 <span id="img_op<bean:write name="d" property="idmenuTitulo" />" style="width: 2%">
								      				  <img    src="${pageContext.request.contextPath}/media/imagenes/mas.png"
							                        onclick="fn_pagosMas('op<bean:write name="d" property="idmenuTitulo" />')" />
							          			  </span>
								           		 <input type="checkbox" id="<bean:write name="d" property="vCodigo" />"
								           		     onclick="CktodoHijos('<bean:write name="d" property="vCodigo" />','opop<bean:write name="d" property="idmenuTitulo" />','<bean:write name="x" property="vCodigo" />','0')"
								           		     
								           		      class="ck_<bean:write name="x" property="idMenu" />"/><bean:write name="d" property="vMenuTitulo" />
		           							</div>
		           							
		           							 <div align="right">
								           		<table class="tabladetalle" border="0" style="display: none " id="opop<bean:write name="d" property="idmenuTitulo" />">	
													<tbody>
										           		   <logic:iterate name="d" property="menuopciones" id="m" indexId="i">	
										           		   <logic:equal name="m" property="cEstadoCodigo" value="AC">           		    
															<tr>
										                      <td>
										                      <div style="margin-left: 10%"  id="op<bean:write name="x" property="idMenu" />" >
																<span
																	id="img_opop<bean:write name="m" property="idmenuOpciones" />"
																	style="width: 2%"> <img
																	src="${pageContext.request.contextPath}/media/imagenes/mas.png"
																	onclick="fn_pagosMas('opop<bean:write name="m" property="idmenuOpciones" />')" />
																</span> 
																<input type="checkbox" 
										                        class="ck_<bean:write name="x" property="idMenu"/>" 
										                        onclick="CktodoHijos('<bean:write name="m" property="vCodigo" />','opopop<bean:write name="m" property="idmenuOpciones" />','<bean:write name="x" property="vCodigo" />','<bean:write name="d" property="vCodigo" />')"
								                                 id="<bean:write name="m" property="vCodigo" />"/><bean:write name="m" property="vOpciones" />
																</div>
										                       

														<table class="tabladetalle" border="0"
															style="display: none; margin-left: 26%; width:70%;"
															id="opopop<bean:write name="m" property="idmenuOpciones" />">
															<tbody>
																<logic:iterate name="m" property="menuacciones"	id="n" indexId="i">
																<logic:equal name="n" property="cEstadoCodigo" value="AC">   
																	<tr>
																		<td>
																		 
																			<input type="checkbox"
																			class="ck_<bean:write name="x" property="idMenu"/>"
																			onclick="CkPadres('<bean:write name="n" property="vCodigo" />','<bean:write name="x" property="vCodigo" />','<bean:write name="d" property="vCodigo" />','<bean:write name="m" property="vCodigo" />')"
																			id="<bean:write name="n" property="vCodigo" />" />
																		<bean:write name="n" property="vAccion" /></td>
																	</tr>
																	</logic:equal> 
																</logic:iterate>
															</tbody>
														</table>
																	</td>
										                      </tr>	
										                  </logic:equal>                    
										                 </logic:iterate>
								                     </tbody>
											    </table>
				  							  </div>
				                      </td>
				                      </tr>	 
				                  </logic:equal>                       
				                 </logic:iterate>
		                     </tbody>
				       </table>              
	             
	              </th>  
	              </tr>     
	           </logic:equal>   
	          </logic:iterate>
	             </tbody>
	        </table>
	        </td>
	        <!--end contenido del sistema-->
	        
    </tr>
    </thead>
     
</table>

<div id="paginacion">
<logic:notEmpty name="perfilForm" property="paginas">	
    <bean:size id="listSizes" name="perfilForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="perfilForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="perfilForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>

</logic:notEmpty>	  
</div> 
<script>   
paginacion();

$("#admin,#permisos").addClass("active");

function fn_pagosMas(valor){
	
    $("#op"+valor).show();
    var tag = "<img title='Ocultar Detalle'src='${pageContext.request.contextPath}/media/imagenes/menos.png' onclick=\"fn_pagosMenos('"+valor+"')\" />";
    $("#img_"+valor).html(tag);
  
   }
  function fn_pagosMenos(valor){
    $("#op"+valor).hide();
    var tag = "<img title='Visualizar Detalle' src='${pageContext.request.contextPath}/media/imagenes/mas.png' onclick=\"fn_pagosMas('"+valor+"')\" />";
    $("#img_"+valor).html(tag);
  }
  
function Cktodo(id,codigo){
 if($("#"+id).is(':checked')) {  
		  $(".ck_"+codigo).attr('checked', true); 
      } else {  
    	  $(".ck_"+codigo).attr('checked', false);
      }
	
}
function CktodoHijos(id,idform,padre1,padre2){
	$(document).find('#'+idform+' input:checkbox').each(function(key,val){ 	 
		if($("#"+id).is(':checked')) {  
			  $("#"+this.id).attr('checked', true); 
			  $("#"+padre1).attr('checked', true);
			  if(padre2!="0")
			  $("#"+padre2).attr('checked', true); 
			  
	      } else {  
	    	  $("#"+this.id).attr('checked', false);
	      }    	
	   });
	 
		
	}


function CkPadres(id, padre1, padre2,padre3){
	
	if($("#"+id).is(':checked')) {  
		  $("#"+padre1).attr('checked', true);
		  $("#"+padre2).attr('checked', true); 
		  $("#"+padre3).attr('checked', true);
		  
    } 
}

function permisoUsuario(idUsu,iPermiso, nomUsu){
//	var htm="<span style='background-color:#0D63A20'>"+nomUsu+"</span>";
	$("#permisoUsuario").text("PERMISOS DEL SISTEMA - "+nomUsu);	
	$("#iUsuarioId").val(idUsu);
	$("#iPermisoId").val(iPermiso);
	$("#tablaPermisos").find("input:checkbox").each(function(key,val){ 
    	$("#"+this.id).attr('checked', false); 
	});			
	if(iPermiso!=0){
		 var cad = "perfil.do?metodo=listaPermisoUsuario&iUsuarioId="+idUsu;
         $.getJSON(cad, function retorna(obj){
        	 $.each(obj,function(key,data){         		
         		$("#"+data).attr('checked', true); 
         	});
         });
	}
	
	
}
function fn_GrabarPermisos() {
   
    var vCodigoPermiso="";
    var iUsuarioId =  $("#iUsuarioId").val(); 
    $("#tablaPermisos").find("input:checkbox").each(function(key,val){ 
    	if($("#"+this.id).is(':checked')) { 
    		vCodigoPermiso=vCodigoPermiso+this.id+"-"; 
    		
    	}
    	
	   });
    
    if(iUsuarioId!=0 && vCodigoPermiso!=""){
      
      $.ajax({
          type: "GET",
          url: "perfil.do?metodo=iduPerfil&mode=UP&iUsuarioId="+iUsuarioId+"&vCodigoPermiso="+vCodigoPermiso.substring(0, vCodigoPermiso.length-1),
          data: "",
          beforeSend: function () {
        	 //$("#resultado").html("Procesando, espere por favor...");
        	 
        	 $("#CapaModal").html("<div class='loading'> <img src='/WorldSolutionsV001/media/imagenes/loading.gif' /></div>");
        	 $("#transp").show();
        	} ,
          error: function() {
        	  alert("Al parecer ocurrio un error, intente nuevamente"); 
           },
          success: function(obj){ 
        	  $("#CapaModal").html("");
        	  $("#transp").hide();
        	  alert("OPERACION CON EXITO"); 
          }
      }); 
      
    }
    else{
    	if(iUsuarioId==0)
    		alert("Debe de seleccionar usuario");
    	if(vCodigoPermiso=="")
    			alert("Debe de seleccionar permisos al sistema");
    	
    	
    }
 /*  for(var k=0;k<sise;k++){
    	 var idPerfil  = $("#id_"+k).attr('class');
    	 var valor="";
           $(document).find("#id_"+k+"  input:checkbox").each(function(key,val){          	 
        	  
                   if($("#"+this.id).is(":checked")){
                	    valor=valor+"1,";
                    }
                    else{
                    	valor=valor+"0,";
                    }                
        	   
              });
              
           permisos = "&mode=UP&ids="+ idPerfil+"&valores="+valor.substring(0, valor.length-1);          
           $.ajax({
               type: "GET",
               url: "perfil.do?metodo=iduPerfil"+permisos,
               data: "",
               success: function(obj){             	
               }
           });
           
      }*/
    

     }  
  
 
 
 </script> 