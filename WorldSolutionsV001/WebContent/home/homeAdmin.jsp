<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div>

<p align="center">
 <span class="font_00">
       <span class="color_11"><span class="color_11">ERP </span></span>                </span>
      <span class="font_00"> <span class="color_18">Bienvenido al Sistema de Gestion Empresarial   </span> </span>  
<div id="listatosHome" style="width: 100%;">	      
<div id="listatos" style="float: left; min-height: 231px; overflow: auto; width: 49%; margin-right: 2%;">	

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
		    <bean:write name="x" property="iProductoStockTotal" />
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
<div id="listatos" style="min-height: 231px; overflow: auto; width: 49%; margin-right: 2%;">	

    <table class="tabla" border="0" width="100%" id="tabla">
    <caption>Productos con Stock M&aacute;ximo </caption>
    <thead>
     <tr>
        <th colspan="" width="5%">Ope.</th>
        <th align="left">C&oacute;digo</th>
        <th width="23%" align="left">Nombre</th>
        <th align="left">Cantidad</th>        
        <th align="left">Precio Compra</th>
        <th align="left">Precio Venta</th>
        <th align="left">Stock Max</th>
      </tr>
    </thead>
    <tbody>
    
<logic:empty name="loginForm" property="listaProductoMax">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del producto</td>
			</tr>
</logic:empty>
<logic:notEmpty name="loginForm" property="listaProductoMax">
      
	<logic:iterate name="loginForm" property="listaProductoMax" id="x">
	
	<tr>
	    
		<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('productos.do?metodo=mantenimientoProducto&mode=U&iclasificacionId=1&id=<bean:write name="x" property="iProductoId" />',600,660)" /></td>
		
	    <td><bean:write name="x" property="cProductoCodigo" /></td>
		<td><bean:write name="x" property="vProductoNombre" /></td>
		<td>
		    <bean:write name="x" property="iProductoStockTotal" />
		    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
		</td>
		
	    <td><bean:write name="x" property="fProductoPrecioCompra" /></td>
	    <td><bean:write name="x" property="fProductoPrecioVenta" /></td>
	    <td><bean:write name="x" property="iProductoStockMaximo" /></td>
		
		
	   

	</tr>
	</logic:iterate>
</logic:notEmpty>

<!-- ?php }$i++; endforeach;?>
<?php endif;?> -->
 
</tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="loginForm" property="paginasProductoMax">	
    <bean:size id="listSizes" name="loginForm" property="paginasProductoMax"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="loginForm" property="paginasProductoMax"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="loginForm" property="paginasProductoMax" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
</div><!-- productos maximos -->


<div id="estadoCuentaClientes" style="min-height: 231px; overflow: auto; float: left; width: 50%;">
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
		<logic:iterate name="loginForm" property="paginasDeudaCliente" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;  </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div>
</div><!-- ESTADO DE CUENTA CLIENTE--->
<div id="estadoCuentaClientesLetra" style="min-height: 231px; float: right; width: 49%;overflow:auto">	  
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista Letra Cliente</caption>    
    <thead>
    <tr>
          <th width="5%" colspan="1" >Ope.</th>
          <th align="left">Fecha Giro</th>
          <th align="left">Fecha Venc.</th>
          <th align="left">Fecha Pago</th>
          <th align="left">Nro Factura</th>	
          <th align="left">Nro Letra</th>
          <th align="left">Cliente</th>      
	      <th align="left">Plazo</th>
	      <th align="left">Importe</th>	    
	      <th align="left">Estado Letra</th>
           
    </tr>
    </thead>
    <tbody>
	 <logic:empty name="loginForm" property="listaDeudaClienteLetra">
				<tr>
					<td colspan="8">No hay informaci&oacute;n de letrass Cliente</td>
				</tr>
	 </logic:empty>
	    <logic:notEmpty name="loginForm" property="listaDeudaClienteLetra">
	     	<logic:iterate name="loginForm" property="listaDeudaClienteLetra" id="x">	
			<tr>
		         <td align="center"><img title="Editar Letra" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popupModal('estadoCuentaCliente.do?metodo=mantenimientoLetraCliente&mode=U&id=<bean:write name="x" property="iLetraClienteId" />',530,530)" />
		         </td>
		        		         
		         <td><bean:write name="x" property="dFechaGiro"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="dFechaVencimiento"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="dFechaPago"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="venta.nVentaNumero" /></td>
		         <td><bean:write name="x" property="nNumeroLetra" /></td>
                 <td><bean:write name="x" property="cliente.vClienteRazonSocial" /></td>  
           		 <td><bean:write name="x" property="nPlazoLetra" /></td>
				 <td align="right"><bean:write name="x" property="nImporte"  format="#,##0.00" locale="Localidad" /></td>
				 <td><bean:write name="x" property="vEstadoLetra" /></td>
				 
			</tr>
		 </logic:iterate>
	      </logic:notEmpty>
			
    </tbody>
</table>
<div id="paginacion">
	<logic:notEmpty name="loginForm" property="paginasDeudaClienteLetra">	
	    <bean:size id="listSizes" name="loginForm" property="paginasDeudaClienteLetra"/>	
	    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
		<input type="hidden" id="pagInicioDeudaClienteLetra" value="<bean:write name="loginForm" property="pagInicioDeudaClienteLetra"/>"/>
		<div class="btnPagInactivo" id="principio">&emsp;</div>
		<div class="btnPagInactivo" id="back">&emsp;</div>	
		<div id="pag">	
			<logic:iterate name="loginForm" property="paginasDeudaClienteLetra" id="p">				
				        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
			</logic:iterate>
		</div>
		<div class="btnPagInactivo" id="Next" >&emsp;</div>
		<div class="btnPagInactivo" id="Final" >&emsp; </div>
	</logic:notEmpty>	  
</div> 
</div> <!-- ESTADO DE CUENTA CLIENTE  LETRA--->
<div id="estadoCuentaProveedores" style="min-height: 231px; overflow: auto; float: left; width: 50%;overflow:auto">	
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Estado Cuenta por Proveedor</caption>
    <thead>
    <tr>
         <th colspan="2" width="5%">Ope.</th>
          <th align="left">Proveedor</th>
          <th align="left">Tipo Doc.</th>
	      <th align="left">Nro. Doc.</th>
	      <th align="left">Forma pago</th>
	      <th align="left">Fecha Emis.</th>
	      <th align="right">Monto Total</th>
	      <th align="right">Pago Total</th>
	      <th align="right">Saldo Total</th>
	      
           
    </tr>
    </thead>
    <tbody>
	 <logic:empty name="loginForm" property="listaDeudaProveedor">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del estado Cuenta Proveedor</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="loginForm" property="listaDeudaProveedor">
	     	<logic:iterate name="loginForm" property="listaDeudaProveedor" id="x">	
			<tr>
				 
				  <logic:equal name="x" property="ingresoProducto.vPrincipal" value="1">
		             <td align="center"><img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popupModal('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=U&id=<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />&idTipoDocumento=<bean:write name="x" property="ingresoProducto.tipodocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',1320,620)" /></td>
		          </logic:equal>
		          <logic:equal name="x" property="ingresoProducto.vPrincipal" value="0">
		           <td align="center"><img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popupModal('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=UE&id=<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />&idTipoDocumento=<bean:write name="x" property="ingresoProducto.tipodocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',470,380)" /></td>
		       
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
						        <td align="center"><img title="Editar Pago" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
				                     onclick="popupModal('estadoCuentaProveedor.do?metodo=mantenimientoEstadoCuentaProveedor&mode=U&id=<bean:write name="z" property="iEstadoCuentaProveedor" />&montoTotal=<bean:write name="x" property="ingresoProducto.fIngresoProductoTotal" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',350,200)" />
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
			<logic:notEqual name="x" property="montosTotales" value="0.0">
				 <tr>
					
					 <td colspan="7" align="right"><strong>Monto Totales:</strong></td>
					  <td align="right"><bean:write name="x" property="montosTotales" /></td>
					 <td align="right"><bean:write name="x" property="pagosTotales" /></td>
					 <td align="right"><bean:write name="x" property="saldosTotales" /></td>
					 
					
				</tr>
			</logic:notEqual>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="loginForm" property="listaDeudaProveedor">	
    <bean:size id="listSizes" name="loginForm" property="listaDeudaProveedor"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="loginForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="loginForm" property="listaDeudaProveedor" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
</div>  <!-- ESTADO DE CUENTA PROVEEDOR--->
<div id="estadoCuentaProveedoresLetra" style="min-height: 231px; float: right; width: 49%;overflow:auto">	
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista Letra Proveedor</caption>
       <thead>
    <tr>
          <th width="5%" colspan="2" >Ope.</th>
          <th align="left">Fecha Giro</th>
          <th align="left">Fecha Vencimiento</th>
          <th align="left">Fecha Pago</th>
          <th align="left">Nro Factura</th>	
          <th align="left">Nro Letra</th>
          <th align="left">Proveedor</th>      
	      <th align="left">Plazo</th>
	      <th align="left">Importe</th>	    
	      <th align="left">Estado Letra</th>
           
    </tr>
    </thead>
    <tbody>
	 <logic:empty name="loginForm" property="listaDeudaProveedorLetra">
				<tr>
					<td colspan="8">No hay informaci&oacute;n letras de Proveedor</td>
				</tr>
	 </logic:empty>
	    <logic:notEmpty name="loginForm" property="listaDeudaProveedorLetra">
	     	<logic:iterate name="loginForm" property="listaDeudaProveedorLetra" id="x">	
			<tr>
		          
		          
		          
		         <td align="center"><img title="Ver Compra" src="${pageContext.request.contextPath}/media/imagenes/search.png"
		                     onclick="popupModal('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=U&id=<bean:write name="x" property="ingresoProducto.iIngresoProductoId" />&idTipoDocumento=<bean:write name="x" property="ingresoProducto.tipodocumento.iTipoDocumentoGestionId" />',900,700)" />
		         </td>
		         <td align="center"><img title="Editar Letra" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popupModal('estadoCuentaProveedor.do?metodo=mantenimientoLetraProveedor&mode=U&id=<bean:write name="x" property="iletraProveedorId" />',530,530)" />
		         </td>
		     		         
		         <td><bean:write name="x" property="dFechaGiro"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="dFechaVencimiento"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="dFechaPago"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="ingresoProducto.nIngresoProductoNumero" /></td>
		         <td><bean:write name="x" property="nNumeroLetra" /></td>
                 <td><bean:write name="x" property="proveedor.vProveedorRazonSocial" /></td>  
           		 <td><bean:write name="x" property="nPlazoLetra" /></td>
				 <td align="right"><bean:write name="x" property="nImporte"  format="#,##0.00" locale="Localidad" /></td>
				 <td><bean:write name="x" property="vEstadoLetra" /></td>
				 
			</tr>
		 </logic:iterate>
	      </logic:notEmpty>
			
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="loginForm" property="paginasDeudaProveedorLetra">	
    <bean:size id="listSizes" name="loginForm" property="paginasDeudaProveedorLetra"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicioDeudaProveedorLetra" value="<bean:write name="loginForm" property="pagInicioDeudaProveedorLetra"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="loginForm" property="paginasDeudaProveedorLetra" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
</div>  
          
</div>
</div>
 <script>   
 $(".menuVertical").hide();
 $("#btns").hide(); 
 $("#base").css("height","882px");
 
 $("#listado").css("width","99%");
 $("#listado").css("height","800px");

 $("#pie").css("top","749px");
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