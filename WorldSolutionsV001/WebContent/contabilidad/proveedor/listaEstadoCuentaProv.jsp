
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
	   if(per.equals("6233")){%>
        <td><button  class="button" onclick="popup('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=F',580,470)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <% break;}}}
	   for (String per: listapermiso) {
	   if(per!=null){
	   if(per.equals("6235")){%>
        <td><button class="button" onclick="fn_exportarExcel('estadoCuentaProveedor.do?metodo=exportarExcel&plantilla=proveedor-estado-cuenta')">
                <span class="excel">Exportar</span>
            </button>
        </td>
        <% break;}}}%>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Estado Cuenta por Proveedor</caption>
        <!-- tr>
            <th width="5%" >Nombre EstadoCuentaProveedor:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
          <th colspan="4"width="5%" >Operaciones</th>
          <th align="left">Proveedor</th>
          <th align="left">Tipo Documento</th>
	      <th align="left">Nro. Documento</th>
	      <th align="left">Forma pago</th>
	      <th align="left">Fecha Emisi&oacute;n</th>
	      <th align="right">Monto Total</th>
	      <th align="right">Pago Total</th>
	      <th align="right">Saldo Total</th>
	      <th align="left">Estado Documento</th>
           
    </tr>
    </thead>
    <tbody>
	 <logic:empty name="contabilidadForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del estado Cuenta Proveedor</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="contabilidadForm" property="lista">
	     	<logic:iterate name="contabilidadForm" property="lista" id="x">	
			<tr>
				 
				  <logic:equal name="x" property="ingresoProducto.vPrincipal" value="1">
		             <td align="center">
		             <%
					for (String per: listapermiso) {
					if(per!=null){
					if(per.equals("6232")){%>
		             <img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popupModal('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=U&id=<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />&idTipoDocumento=<bean:write name="x" property="ingresoProducto.tipodocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',1320,620)" />
		          <% break;}}}%> 
		          </td>
		          </logic:equal>
		          <logic:equal name="x" property="ingresoProducto.vPrincipal" value="0">
		           <td align="center">
		           <%
					for (String per: listapermiso) {
					if(per!=null){
					if(per.equals("6232")){%>
		           <img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popupModal('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=UE&id=<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />&idTipoDocumento=<bean:write name="x" property="ingresoProducto.tipodocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',470,380)" />
		           <% break;}}}%> 
		           </td>
		       
		          </logic:equal>
		         
		        <logic:notEqual name="x" property="saldoTotal" value="0.00">
			        <td align="center"><img title="Agregar Pago" src="${pageContext.request.contextPath}/media/imagenes/new.png"
			                     onclick="popupModal('estadoCuentaProveedor.do?metodo=mantenimientoEstadoCuentaProveedor&mode=I&iIngresoProductoId=<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />&iProveedorId=<bean:write name="x" property="ingresoProducto.proveedor.iProveedorId" />&montoTotal=<bean:write name="x" property="ingresoProducto.fIngresoProductoTotal" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',350,200)" />
			         </td>
		          </logic:notEqual>
		          <logic:equal name="x" property="saldoTotal" value="0.00">
		              <td align="center"> </td>
		          </logic:equal>
		         <logic:equal name="x" property="ingresoProducto.vPrincipal" value="0">
		               <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />','ingresoProducto.do?metodo=iduIngresoproducto&mode=D')"/>
		               </td>
		          </logic:equal>
		          <logic:equal name="x" property="ingresoProducto.vPrincipal" value="1">
		              <td align="center"> </td>
		          </logic:equal>
		           
		         <logic:notEmpty name="x" property="ingresoProducto.estadocuentaproveedors">
		         <td id="img_<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />">
		               <img title="Visualizar Detalle" src="${pageContext.request.contextPath}/media/imagenes/mas.png"
                        onclick="fn_pagosMas('<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />')" />
                 </td> 
                 </logic:notEmpty>                 
                 <logic:empty name="x" property="ingresoProducto.estadocuentaproveedors"> 
	                 <td id="img_<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />">
	                     
	                 </td> 
                 </logic:empty>
                 <td><bean:write name="x" property="ingresoProducto.proveedor.vProveedorRazonSocial" /></td>  
           		 <td><bean:write name="x" property="ingresoProducto.tipodocumento.vTipoDocumentoDescripcion" /></td>
				 <td><bean:write name="x" property="ingresoProducto.nIngresoProductoNumero" /></td>
				 <td><bean:write name="x" property="ingresoProducto.formaPago.vFormaPagoDescripcion" /></td>
				 <td><bean:write name="x" property="ingresoProducto.dIngresoProductoFecha"  format="dd/MM/yyyy"/></td>
				 <td align="right"><bean:write name="x" property="ingresoProducto.fIngresoProductoTotal"  format="#,##0.00" locale="Localidad" /></td>
				 <td align="right"><bean:write name="x" property="pagoTotal" /></td>
				 <td align="right"><bean:write name="x" property="saldoTotal" /></td>
				 <td><bean:write name="x" property="ingresoProducto.vEstadoDocumento" /></td>
				 
			</tr>
			<logic:notEmpty name="x" property="ingresoProducto.estadocuentaproveedors">
			<tr class="textInvisible" id="tr_<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />" >
   				 <td colspan="11"  align="right">
   				 
   				 <table class="tabladetalle" width="71%" border="0">
					<caption>Lista de Detalle de Pagos</caption>
					<thead>
						<tr>
						<th colspan="2" width="5%" >Operaciones</th>
						<th width="46%" align="center">Nombre Vendedor</th>
						<th  align="center">Fecha Pago</th>
						<th align="right">Monto Pago</th>
						</tr>
					</thead>
					<tbody>
					  <logic:iterate name="x" property="ingresoProducto.estadocuentaproveedors" id="z">
					  <logic:equal name="z" property="cEstadoCodigo" value="AC">
						  <tr>
						        <td align="center">
						        <%
								for (String per: listapermiso) {
								if(per!=null){
								if(per.equals("6232")){%>
						        <img title="Editar Pago" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
				                     onclick="popupModal('estadoCuentaProveedor.do?metodo=mantenimientoEstadoCuentaProveedor&mode=U&id=<bean:write name="z" property="iEstadoCuentaProveedor" />&montoTotal=<bean:write name="x" property="ingresoProducto.fIngresoProductoTotal" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',350,200)" />
				                <% break;}}}%> 
				                </td>
						        <td align="center"><img title="Eliminar Pago" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
			                     onclick="eliminar('tabla','<bean:write name="z" property="iEstadoCuentaProveedor" />','estadoCuentaProveedor.do?metodo=iduEstadoCuentaProveedor&mode=D')"/>
			                    </td>
						       <td align="center"><bean:write name="z" property="sVendedor" /></td>
							   <td align="center"><bean:write name="z" property="dFechaPago" format="dd/MM/yyyy" /></td>
							   <td align="right"><bean:write name="z" property="fMontoPago" format="#,##0.00" locale="Localidad"/></td>
							</tr>
						</logic:equal>  
			           </logic:iterate>	
					</tbody>
					</table>
   				 </td>
   				 <td colspan="2">
   				 </td>
			</tr>
			</logic:notEmpty>
			<logic:notEqual name="x" property="montosTotales" value="0">
				 <tr>
					 <td colspan="8"></td>
					 <td align="right"><strong>Monto Totales:</strong></td>
					  <td align="right"><bean:write name="x" property="montosTotales" /></td>
					 <td align="right"><bean:write name="x" property="pagosTotales" /></td>
					 <td align="right"><bean:write name="x" property="saldosTotales" /></td>
					 <td align="right"></td>
					
				</tr>
			</logic:notEqual>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="contabilidadForm" property="paginas">	
    <bean:size id="listSizes" name="contabilidadForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="contabilidadForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="contabilidadForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#contabilidad").addClass("active");
$("#proveedores").children('li').show();
$("#estadoProveedor").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#estadoProveedor").children('a').css("color","#D0D2D7");

 $(".inputDisabled").attr("disabled",true);
 $("#dIngresoProductoFecha,#dIngresoProductoFechaFin").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    })
 function fn_pagosMas(valor){
     $("#tr_"+valor).show();
     var tag = "<img title='Ocultar Detalle'src='${pageContext.request.contextPath}/media/imagenes/menos.png' onclick=\"fn_pagosMenos('"+valor+"')\" />";
     $("#img_"+valor).html(tag);
   
    }
   function fn_pagosMenos(valor){
     $("#tr_"+valor).hide();
     var tag = "<img title='Visualizar Detalle' src='${pageContext.request.contextPath}/media/imagenes/mas.png' onclick=\"fn_pagosMas('"+valor+"')\" />";
     $("#img_"+valor).html(tag);
   }
 </script> 
 