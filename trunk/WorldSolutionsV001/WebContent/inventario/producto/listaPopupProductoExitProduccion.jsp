
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="productos" styleId="formPersonal">
    <tr>
        <td> <html:select  property="iclasificacionId" styleId="iclasificacionId" styleClass="combo" style="width:150px" onchange="fn_recargar()">       
              <html:options collection="listaClasificacioncategoria" property="iClasificacionId" labelProperty="vClasificacionDescripcion"/>
           </html:select>
        </td>
	    <td align="right">C&oacute;digo:</td>
	    <td>   
	        <html:text property="cProductoCodigo"  styleId="cProductoCodigo"  onkeyup="return mayuscula('cProductoCodigo')" onkeypress="return LetrasNumeros(event)" maxlength="5" styleClass="textCodigo"/>
	        
	    </td>
        <td align="right">Nombre:</td>
	   <td><html:text property="vProductoNombre" styleId="vProductoNombre"  onkeyup="return mayuscula('vProductoNombre')" onkeypress="return LetrasNumeros(event)" styleClass="text"/>
	        
	    </td>
	    <td rowspan="2"><button  class="button"  onclick="buscarPopup('tab-grupo')">
                <span class="find">Buscar</span>
            </button>
        </td>
	 </tr> 

<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaProducto" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Producto</caption>
        <!-- tr>
            <th width="5%" >Apellidos Personal:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
        -->
    <thead>
    <tr >
        <th align="left">C&oacute;digo</th>
        <th align="left">Nombre</th>        
        <th align="left">Stock</th>
        <th align="left">Unidad Medida</th>
        <th align="left">% Desc</th>
        <th align="right">P.Venta</th>
        <th align="right">P.Compra</th>
        
            
      </tr>
    </thead>
    <tbody>
	     <logic:empty name="productosForm" property="produc">
				<tr>
					<td colspan="11">No hay informaci&oacute;n del productos</td>
				</tr>
	     </logic:empty>
         <logic:notEmpty name="productosForm" property="produc">
		 <logic:iterate name="productosForm" property="produc" id="x">	
		 
			<tr onclick="fn_cargarProducto('<bean:write name="x" property="iProductoId" />',
			               '<bean:write name="x" property="cProductoCodigo" />',
			               '<bean:write name="x" property="vProductoNombre" />',
			               '<bean:write name="x" property="iProductoStockTotal" />',
			               '<bean:write name="x" property="unidadMedida.iUnidadMedidaId" />',
			               '<bean:write name="x" property="iUMPedido" />',			               
			               '<bean:write name="x" property="iUMBase" />',			               
			               '<bean:write name="x" property="fProductoPrecioCompra" format="#,##0.00"  locale="Localidad"/>',
			               '<bean:write name="x" property="fProductoPrecioVenta" format="#,##0.00"  locale="Localidad"/>',
			               '<bean:write name="x" property="moneda.iMonedaId" />',
			               '<bean:write name="x" property="fProductoGanancia" />',
			               '<bean:write name="x" property="fProductoDescuento" format="#,##0.00"  locale="Localidad"/>')">
			               
			 
		 		<td><bean:write name="x" property="cProductoCodigo" /></td>
				<td><bean:write name="x" property="vProductoNombre" /></td>
				
			
				<td>
				    <bean:write name="x" property="iProductoStockTotal" />				    
				</td>
				<td>
				    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
				</td>
				<td align="right"><bean:write name="x" property="fProductoDescuento" format="#,##0.00" locale="Localidad" /></td>
				<td align="right"><bean:write name="x" property="fProductoPrecioVenta" format="#,##0.00"  locale="Localidad"/></td>
				<td align="right"><bean:write name="x" property="fProductoPrecioCompra" format="#,##0.00"  locale="Localidad"/></td>
						
	    	</tr>
	    	<logic:notEmpty name="x" property="preciosproductodetallles">
	    	
			<tr class="textInvisible">
   				 <td colspan="11"  align="right" id="tr_<bean:write name="x" property="iProductoId"/>">   				 
   				 <table class="tabladetalle" width="100%" border="0">
					<caption>Lista de Precios</caption>
					<thead>
						<tr>
						<th  align="center">Cantidad</th>
						<th  align="center">Precio Venta</th>
						<th  align="center">Precio Compra</th>
						<th align="right">% Descuento</th>
						<th align="right">Fecha Compra</th>
						</tr>
					</thead>
					<tbody>
					  <logic:iterate name="x" property="preciosproductodetallles" id="z">
					  <logic:notEqual name="x" property="iProductoStockTotal" value="0">
					  <logic:equal name="z" property="cEstadoCodigo" value="AC">
					  <tr onclick="fn_cargarPrecio('<bean:write name="z" property="fPrecioVenta" />',
					  							   '<bean:write name="z" property="fPrecioCompra"/>',
					  							   '<bean:write name="z" property="fDescuento"/>')">				        
					       <td align="center"><bean:write name="z" property="iCantidadStock"/></td>
					       <td align="right"><bean:write name="z" property="fPrecioVenta" format="#,##0.00" locale="Localidad" /></td>
					       <td align="right"><bean:write name="z" property="fPrecioCompra" format="#,##0.00" locale="Localidad" /></td>					       
						   <td align="right"><bean:write name="z" property="fDescuento" format="#,##0.00" locale="Localidad" /></td>
						   <td align="center"><bean:write name="z" property="dFechaInserta" format="dd/MM/yyyy"  /></td>
						</tr> 						
						</logic:equal>  
						</logic:notEqual>
			           </logic:iterate>	
					</tbody>
					</table>
   				 </td>
   				 <td colspan="2">
   				 </td>
			</tr>
			 
			</logic:notEmpty>
		</logic:iterate>
	  </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="productosForm" property="paginas">	
    <bean:size id="listSizes" name="productosForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="productosForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="productosForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp; </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div>
<div id="tablaDetalle">

</div>   
<script>   
paginacion(); 
$("#iclasificacionId option[value=2]").attr('disabled', true).hide();
$("#iclasificacionId option[value=3]").attr('disabled', true).hide();
$("#iclasificacionId option[value=4]").attr('disabled', true).hide();
$("#iclasificacionId option[value=5]").attr('disabled', true).hide();

 function fn_cargarProducto(iProductoId,cProductoCodigo,vProductoNombre,
		 iProductoStockTotal,iUnidadMedidaId,iUMPedido,iUMBase,
		 fProductoPrecioCompra,fProductoPrecioVenta,iMonedaId,fProductoGanancia,fProductoDescuento){   
	 
	 retornarProducto(
				'iProductoId',iProductoId,
				'cProductoCodigo',cProductoCodigo,
				'vProductoNombre',vProductoNombre,
				'iProductoStockTotal',iProductoStockTotal,
				'iUnidadMedidadId',iUnidadMedidaId,
				'iUMPedido',iUMPedido,
				'iUMBase',iUMBase,
				'fProductoPrecioCompra',fProductoPrecioCompra,
				'fProductoPrecioVenta',fProductoPrecioVenta,
				'iMonedaId',iMonedaId,
				'.comboCodigo.change',iMonedaId,
				'fProductoGanancia',fProductoGanancia,
				'fProductoDescuento',fProductoDescuento);
	
				
							               
			           
	}
   
	
 </script>  