
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="productos" styleId="formPersonal">
    <tr>
       <td> <html:select  property="iclasificacionId" styleId="iclasificacionId" styleClass="combo" style="width:150px " onchange="fn_recargar()">       
              <html:options collection="listaClasificacioncategoria" property="iClasificacionId" labelProperty="vClasificacionDescripcion"/>
           </html:select>
        </td>   
	    
	    <td align="right">C&oacute;digo:</td>
	    <td>   
	        <html:text property="cProductoCodigo" styleClass="text"  styleId="cProductoCodigo"  onkeyup="return mayuscula('cProductoCodigo')" onkeypress="return LetrasNumeros(event)" maxlength="5" size="5" />
	        
	    </td>
        <td align="right">Nombre:</td>
	   <td><html:text property="vProductoNombre" styleClass="text" styleId="vProductoNombre" onkeyup="return mayuscula('vProductoNombre')" onkeypress="return LetrasNumeros(event)"/>
	        
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
        <th width="23%" align="left">Nombre</th>
        <th align="left">Stock</th>
        <th align="left">Uni. Medida</th>        
        <th align="right">P.Compra</th>
        <th align="right">P.Venta</th>
            
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
			               '<bean:write name="x" property="vProductoNombre" />',
			               '<bean:write name="x" property="unidadMedida.iUnidadMedidaId" />',			               
			               '<bean:write name="x" property="iUnidadMedidadIdC" />',
			               '<bean:write name="x" property="vProductoCapacidad" />',
			               '<bean:write name="x" property="fProductoPrecioCompra" format="#,##0.00"  locale="Localidad"/>',
			               '<bean:write name="x" property="fProductoPrecioVenta" format="#,##0.00"  locale="Localidad"/>',
			               '<bean:write name="x" property="fProductoGanancia" format="#,##0.00"  locale="Localidad"/>' )">
		 		<td><bean:write name="x" property="cProductoCodigo" /></td>
				<td><bean:write name="x" property="vProductoNombre" /></td>
				<td>
				    <bean:write name="x" property="iProductoStockCantidad" />				    
				</td>
				<td>				    
				    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
				</td>				
				<td align="right"><bean:write name="x" property="fProductoPrecioCompra" format="#,##0.00"  locale="Localidad"/></td>
				<td align="right"><bean:write name="x" property="fProductoPrecioVenta" format="#,##0.00"  locale="Localidad"/></td>
				
	    	</tr>
	    	<logic:notEmpty name="x" property="preciosproductodetallles">
	    	
			<tr class="textInvisible">
   				 <td colspan="11"  align="right" id="tr_<bean:write name="x" property="iProductoId"/>">   				 
   				 <table class="tabladetalle" width="100%" border="0">
					<caption>Lista de Precios</caption>
					<thead>
						<tr>
						<th  align="center">Cantidad</th>						
						<th  align="center">Precio Compra</th>
						<th  align="center">Precio Venta</th>						
						<th align="right">Fecha Compra</th>
						</tr>
					</thead>
					<tbody>
					  <logic:iterate name="x" property="preciosproductodetallles" id="z">
					  <logic:notEqual name="x" property="iProductoStockCantidad" value="0">
					  <logic:equal name="z" property="cEstadoCodigo" value="AC">
					  <tr>				        
					       <td align="center"><bean:write name="z" property="iCantidadStock"/></td>					       
					       <td align="right"><bean:write name="z" property="fPrecioCompra" format="#,##0.00" locale="Localidad" /></td>					       
						   <td align="right"><bean:write name="z" property="fPrecioVenta" format="#,##0.00" locale="Localidad" /></td>
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
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="productosForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<div id="tablaDetalle">
<html:form action="productos" styleId="formProductos">
<table class="tabla" border="0" width="100%" id="tabla">
    <!-- caption>Detalle del producto</caption-->
       
    <tbody>
	   <tr>
	 		<td>Nombre de producto:</td>
			<td colspan="3">
			    <html:hidden property="iProductoId" styleId="iProductoId"/>
				<input type="text" id="vxProductoNombre" size="45"  class="text"/>
				 Precio Final:
				<input type="text" id="fProductoPrecioCompraFinal"  size="5" class="text" />
				<strong style="font-size: 15px">Total:</strong>
				 <input type="text" id="fTotal"  size="5" class="text" />
			</td>
	  </tr>
	  <tr>
	        <td>Cantidad:</td>
	        <td>
			   <html:text property="iProductoStockCantidad" styleId="iProductoStockCantidad"   styleClass="text" size="5" onblur="fn_CalcularTotal()" value="1"/>
			   <html:select  property="iUnidadMedidadId" styleId="iUnidadMedidadId" styleClass="comboCodigo" tabindex="6" style="width:140px" disabled="true">
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select>
			</td>
			<td>Capacidad:</td>
	        <td>
	           <html:text property="vProductoCapacidad" styleId="vProductoCapacidad"   styleClass="text" size="5" disabled="true" />
			   <html:select  property="iUnidadMedidadIdC" styleId="iUnidadMedidadIdC" styleClass="comboCodigo" tabindex="8" style="width:140px" disabled="true">
		          <option value="0">::SELECCIONE::</option> 
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select>  
			</td>
	  </tr>
	  <tr>
	        <td>Precio Compra:</td>
	        <td>
			   <html:text property="fProductoPrecioCompra" styleId="fProductoPrecioCompra" size="5" styleClass="text" onblur="fn_CalcularTotal()"/>
			   % Descuento:
			   <input type="text" id="fDescuento" size="5" class="text " value="0.0" onblur="fn_CalcularTotal()"/>
			   
			</td>
			 <td>% Ganancia:</td>
	        <td>
	            <input type="text" id="fGanancia" size="5" class="text" value="0.0" onblur="fn_CalcularTotal()" />
	            Precio Venta:
	            <html:text property="fProductoPrecioVenta" styleId="fProductoPrecioVenta"  size="5" styleClass="text"  disabled="disabled"/>
	            
	            
			   
			</td>	  
	 </tr>
	 
	 <tr>
	    <td id="detalleListaPrecio" colspan="4"></td>
	 </tr>
	 <tr height="50px">   
	    <td align="center" colspan="4">
	    <br>    
	     <button onclick="fn_agregarProducto()" class="button" type="button">
	          <span class='add' id="btnGuardar">Agregar</span></button>
	     <button onclick="cancelar('');" class="button" type="button"><span class='cancel'>Cancelar</span></button>
	     <br>
	    
	     <span id="m_mensaje" class="mensaje"></span>
	     <br>
	    </td>
    </tr>
		
    </tbody>
</table>
</html:form>
</div> 
<script>   
paginacion();

$("#iclasificacionId option[value=5]").attr('disabled', true);
function fn_cargarProducto(iProductoId,vNombreProducto,iUnidadMedidadId,iUnidadMedidadIdC,vProductoCapacidad,fProductoPrecioCompra,fProductoPrecioVenta,fGanancia){   
    $("#iProductoId").val(iProductoId);
	$("#vxProductoNombre").val(vNombreProducto);
	$("#iUnidadMedidadId").val(iUnidadMedidadId);
	$("#iUnidadMedidadIdC").val(iUnidadMedidadIdC);
	$("#vProductoCapacidad").val(vProductoCapacidad);	
	$("#fProductoPrecioCompra").val(fProductoPrecioCompra);
	$("#fProductoPrecioVenta").val(fProductoPrecioVenta);
	$("#fGanancia").val(fGanancia);
	$("#fProductoPrecioCompraFinal").val(dosDecimales(fProductoPrecioCompra));		
	$("#fTotal").val(dosDecimales(($("#iProductoStockCantidad").val()*$("#fProductoPrecioCompra").val()),''));   
	$("#detalleListaPrecio").html($("#tr_"+iProductoId).html());
   
}
function fn_CalcularTotal(){ 
	
	var iCantidad =parseFloat($("#iProductoStockCantidad").val());		
	var fPrecioCompra=$("#fProductoPrecioCompra").val();	
	var fDescuento =parseFloat(($("#fDescuento").val()/100));
	var fGanancia = parseFloat(($("#fGanancia").val()/100));
	$("#fProductoPrecioVenta").val(dosDecimales(fPrecioCompra)+dosDecimales(fPrecioCompra*fGanancia));
	$("#fProductoPrecioCompraFinal").val(dosDecimales(fPrecioCompra)-parseFloat(fPrecioCompra)*fDescuento);		
	$("#fTotal").val(dosDecimales((iCantidad*$("#fProductoPrecioCompraFinal").val()))); 
}
function fn_agregarProducto(){
	var id=$("#iProductoId").val();
	if(id!=''){
	var iCantidad=$("#iProductoStockCantidad").val();
	var fPrecioCompra=$("#fProductoPrecioCompra").val();
	var fDescuento=$("#fDescuento").val();	
	var fGanancia = $("#fGanancia").val();
	var fPrecioVenta =$("#fProductoPrecioVenta").val();
	var fTotal = $("#fTotal").val();
    var cad = "ingresoProducto.do?metodo=detalleIngresoProducto&id="+id+"&iCantidad="+iCantidad+
    		  "&fPrecioCompra="+fPrecioCompra+"&fDescuento="+fDescuento+
    		  "&fGanancia="+fGanancia+"&fPrecioVenta="+fPrecioVenta+"&fTotal="+fTotal+"&mode=I";
    
     
         $.getJSON(cad, function retorna(obj){
        	// alert("obje"+obj.cProductoCodigo);
        	 listar_detalleCompra(obj,'padre');
        	 });
	}
	else{
		alert("Debe de seleccionar producto");
	}
        
 }

 
 </script>  