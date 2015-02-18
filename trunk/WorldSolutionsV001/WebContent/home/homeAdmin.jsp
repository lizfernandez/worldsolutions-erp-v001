<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div>

<p align="center">
 <span class="font_00">
       <span class="color_11"><span class="color_11">ERP </span></span>                </span>
      <span class="font_00"> <span class="color_18">Bienvenido al Sistema de Gestion Empresarial   </span> </span>  
<div id="listatos" style="width: 45%;float:left">	

    <table class="tabla" border="0" width="100%" id="tabla">
    <caption>Productos con Stock Minimo </caption>
    <thead>
     <tr>
        <th colspan="" width="5%">Ope.</th>
        <th align="left">C&oacute;digo</th>
        <th width="23%" align="left">Nombre</th>
        <th align="left">Cantidad</th>        
        <th align="left">Precio Compra</th>
        <th align="left">Precio Venta</th>
        <th align="left">Stock Min</th>
      </tr>
    </thead>
    <tbody>
    
<logic:empty name="loginForm" property="lista">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del producto</td>
			</tr>
</logic:empty>
<logic:notEmpty name="loginForm" property="lista">
      
	<logic:iterate name="loginForm" property="lista" id="x">
	
	<tr>
	    
		<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('productos.do?metodo=mantenimientoProducto&mode=U&iclasificacionId=1&id=<bean:write name="x" property="iProductoId" />',600,660)" /></td>
		
	    <td><bean:write name="x" property="cProductoCodigo" /></td>
		<td><bean:write name="x" property="vProductoNombre" /></td>
		<td>
		    <bean:write name="x" property="iProductoStockCantidad" />
		    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
		</td>
		
	    <td><bean:write name="x" property="fProductoPrecioCompra" /></td>
	    <td><bean:write name="x" property="fProductoPrecioVenta" /></td>
	    <td><bean:write name="x" property="iProductoStockMinimo" /></td>
		
		
	   

	</tr>
	</logic:iterate>
</logic:notEmpty>

<!-- ?php }$i++; endforeach;?>
<?php endif;?> -->
 
</tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="loginForm" property="paginas">	
    <bean:size id="listSizes" name="loginForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="loginForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="loginForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
</div>
<div id="estadoCuentaClientes" style="width: 45%; float:left">
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Estado Cuenta Cliente</caption>
    <thead>
    <tr>
          <th colspan="2" width="5%">Ope.</th>
          <th align="left">Cliente</th>
          <th align="left">Tipo Doc.</th>
	      <th align="left">Nro. Doc.</th>
	      <th align="left">Forma pago</th>
	      <th align="left">Fecha Emis.</th>
	      <th align="right">Monto Total</th>
	      <th align="right">Pago Total</th>
	      <th align="right">Saldo Total</th>
	      <th align="left">Estado Doc.</th>
           
    </tr>
    </thead>
    <tbody>
	 <logic:empty name="loginForm" property="listaDeudaCliente">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del estado Cuenta del Cliente</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="loginForm" property="listaDeudaCliente">
	     	<logic:iterate name="loginForm" property="listaDeudaCliente" id="x">	
				<tr>
					<!-- Primera operacion --> 
					<logic:equal name="x" property="venta.vPrincipal" value="1">
			            <td align="center"><img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
			                     onclick="popup('venta.do?metodo=mantenimientoVenta&mode=U&id=<bean:write name="x" property="venta.iVentaId" />&idTipoDocumento=<bean:write name="x" property="venta.tipoDocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',900,700)" /></td>
			          </logic:equal>
			        <logic:equal name="x" property="venta.vPrincipal" value="0">  
					<td align="center"><img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
			                     onclick="popup('venta.do?metodo=mantenimientoVenta&mode=UE&id=<bean:write name="x" property="venta.iVentaId" />&idTipoDocumento=<bean:write name="x" property="venta.tipoDocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',520,430)" /></td>
			        </logic:equal>
			          
			        
				    <!-- Cuarta Operacion -->
			        <logic:notEmpty name="x" property="venta.estadocuentaclientes">
			        	<td id="img_<bean:write name="x" property="venta.iVentaId" />">
			        		<img title="Visualizar Detalle" src="${pageContext.request.contextPath}/media/imagenes/mas.png" onclick="fn_pagosMas('<bean:write name="x" property="venta.iVentaId" />')" />
	                	</td> 
	                </logic:notEmpty>                
	                <logic:empty name="x" property="venta.estadocuentaclientes"> 
		            	<td id="img_<bean:write name="x" property="venta.iVentaId" />"></td> 
	                </logic:empty>
	                
	                <td><bean:write name="x" property="venta.cliente.vClienteRazonSocial" /></td>
	           		<td><bean:write name="x" property="venta.tipoDocumento.vTipoDocumentoDescripcion" /></td>
					<td><bean:write name="x" property="venta.nVentaNumero" /></td>
					<td><bean:write name="x" property="venta.formaPago.vFormaPagoDescripcion" /></td>
					<td><bean:write name="x" property="venta.dVentaFecha" format="dd/MM/yyyy"/></td>
					<td align="right"><bean:write name="x" property="venta.fVentaTotal" format="#,##0.00" locale="Localidad"/></td>
					<td align="right"><bean:write name="x" property="pagoTotal" format="#,##0.00" locale="Localidad" /></td>
					<td align="right"><bean:write name="x" property="saldoTotal" format="#,##0.00" locale="Localidad" /></td>
					<td><bean:write name="x" property="venta.vEstadoDocumento" /></td>
				</tr>
			<logic:notEmpty name="x" property="venta.estadocuentaclientes">
			<tr class="textInvisible" id="tr_<bean:write name="x" property="venta.iVentaId" />" >
   				 <td colspan="11"  align="right">
   				 
   				 <table class="tabladetalle" width="71%" border="0">
					<caption>Lista de Detalle de Pagos</caption>
					<thead>
						<tr>
						<th colspan="2" width="5%" >Operaciones</th>
						
						<th  align="center">Fecha Pago</th>
						<th align="right">Monto Pago</th>
						</tr>
					</thead>
					<tbody>
					  <logic:iterate name="x" property="venta.estadocuentaclientes" id="z">
					  <logic:equal name="z" property="cEstadoCodigo" value="AC">
					  <tr>
					        <td align="center"><img title="Editar Pago" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
			                     onclick="popupModal('estadoCuentaCliente.do?metodo=mantenimientoEstadoCuentaCliente&mode=U&id=<bean:write name="z" property="iEstadoCuentaCliente" />&montoTotal=<bean:write name="x" property="venta.fVentaTotal" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',350,200)" />
			                </td>
					        <td align="center"><img title="Eliminar Pago" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="z" property="iEstadoCuentaCliente" />','estadoCuentaCliente.do?metodo=iduEstadoCuentaCliente&mode=D')"/>
		                    </td>
					      
						   <td align="center"><bean:write name="z" property="dFechaPago" format="dd/MM/yyyy" /></td>
						   <td align="right"><bean:write name="z" property="fMontoPago" format="#,##0.00" locale="Localidad" /></td>
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
					 
					 <td align="right" colspan="7"><strong>Monto Totales:</strong></td>
					  <td align="right"><bean:write name="x" property="montosTotales" format="#,##0.00" locale="Localidad" /></td>
					 <td align="right"><bean:write name="x" property="pagosTotales" format="#,##0.00" locale="Localidad"/></td>
					 <td align="right"><bean:write name="x" property="saldosTotales" format="#,##0.00" locale="Localidad"/></td>
					 <td align="right"></td>
					
				</tr>
			</logic:notEqual>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="loginForm" property="paginasDeudaCliente">	
    <bean:size id="listSizes" name="loginForm" property="paginasDeudaCliente"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicioDeudaCliente" value="<bean:write name="loginForm" property="pagInicioDeudaCliente"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="loginForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;  </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div>
</div> 
<div id="estadoCuentaClientesLetra">	  </div> 
<div id="estadoCuentaProveedores">	  </div>  
<div id="estadoCuentaProveedoresLetra">	  </div>  
          
</div>
 <script>   
 $(".menuVertical").hide();
 $("#btns").hide(); 
 $("#listado").css("width","99%");
 paginacion();
 $("#dVentaFecha,#dVentaFechaFin").datepicker(
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