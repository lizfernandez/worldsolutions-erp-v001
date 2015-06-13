
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="productos" styleId="formPersonal">
    <tr>
    	<td> <html:select  property="iSucursalId" styleId="iSucursalId" styleClass="combo" style="width:150px">       
              <html:options collection="listaSucursal" property="iSucursalId" labelProperty="vSucursalNombre"/>
           </html:select>
        </td>
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
<input type="text" id="tipo"  class="textInvisible"/>
<input type="text" id="identificador"  class="textInvisible"/>		
			
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
        <th align="left">Foto</th>      
        <th align="left">Stock</th>
        <th align="left">Unidad Medida</th>
        <th align="left">% Desc</th>
        <th align="right">P. Venta Producto</th>
        <th align="right">P. Instalacion</th>
        <th align="right">P. Venta </th>
        
      </tr>
    </thead>
    <tbody>
	     <logic:empty name="productosForm" property="produc">
				<tr>
					<td colspan="11">No hay informaci&oacute;n del productos</td>
				</tr>
	     </logic:empty>
         <logic:notEmpty name="productosForm" property="produc">
		 <logic:iterate name="productosForm" property="produc" id="x" indexId="i">	
		 
			<tr onclick="fn_cargarProducto('<bean:write name="x" property="iProductoId" />',
			               '<bean:write name="x" property="stockSucursal" />',
			               '<bean:write name="x" property="vProductoNombre" />',
			               '<bean:write name="x" property="fProductoDescuento" />',
			               '<bean:write name="x" property="unidadMedida.iUnidadMedidaId" />',			               
			               '<bean:write name="x" property="iUMBase" />',
			               '<bean:write name="x" property="iUMPedido" />',
			               '<bean:write name="x" property="fProductoPrecioCompra" format="###0.00"  locale="Localidad"/>',
			               '<bean:write name="x" property="fProductoPrecioVenta" format="###0.00"  locale="Localidad"/>',
			               '<bean:write name="x" property="fProductoDescuento" format="###0.00"  locale="Localidad"/>',
			               '<bean:write name="x" property="iProductoalmacenId" />')">
		 		<td><bean:write name="x" property="cProductoCodigo" /></td>
				<td><bean:write name="x" property="vProductoNombre" /></td>
				<td>
			<div class="viewport">
        			<a href="#" class="view${i}" id="${i}">
            		<span class="dark-background" style="display: none;"></span>
            		<logic:notEqual name="x" property="vFoto" value=""> <img  src="${pageContext.request.contextPath}/media/fotos/<bean:write name="x" property="vFoto" />"  style="height: 25px; display: inline; left: -20px; top: -20px; width: 30px;"/></logic:notEqual>
            		
            		
        			</a>
    			  </div>
    			  </td>
				<td>
				    <bean:write name="x" property="stockSucursal" />				    
				</td>
				<td>
				    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
				</td>
				<td align="right"><bean:write name="x" property="fProductoDescuento" format="###0.00" locale="Localidad" /></td>
				<td align="right"><bean:write name="x" property="fProductoPrecioVentaProducto" format="###0.00"  locale="Localidad"/></td>
				<td align="right"><bean:write name="x" property="fPrecioInstalacion" format="###0.00"  locale="Localidad"/></td>
				<td align="right"><bean:write name="x" property="fProductoPrecioVenta" format="###0.00"  locale="Localidad"/></td>
						
	    	</tr>
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
<html:form action="productos" styleId="formProductos">
<table class="tabla" border="0" width="100%" id="tabla">
    <!-- caption>Detalle del producto</caption-->
       
    <tbody>
	   <tr>
	 		<td>Nombre de producto:</td>
			<td>
			    <html:hidden property="iProductoId" styleId="iProductoId"/>
			    <input type="hidden" id="iStock"/>
				<input type="text" id="vxProductoNombre" size="45"  class="text"/>
			</td>
	        <td>Cantidad:</td>
	        <td>
	        	<input type="hidden" id="iProductoalmacenId"> 
			   	<html:text property="stockSucursal" styleId="stockSucursal"   styleClass="text" size="5" onblur="fn_CalcularTotal()" value="1"/>
			   	<html:select  property="iUnidadMedidadId" styleId="iUnidadMedidadId" styleClass="comboCodigo" tabindex="6" style="width:140px" disabled="true">
		        	<html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     	</html:select>
			</td>
	  </tr>
	  <tr>
	        <td>Precio Venta:</td>
	        <td>
	        <input type="hidden" id="fPrecioCompra"> 
	        <html:text property="fProductoPrecioVenta" styleId="fProductoPrecioVenta"  size="5" styleClass="text" onblur="fn_CalcularTotal()"/>
			  
			   % Descuento:
			   <input type="text" id="fDescuento" size="5" class="text " value="0.0" onblur="fn_CalcularTotal()"/>
			   
			</td>
			 <td>Precio Final:</td>
	        <td>	           
	           <input type="text" id="fProductoPrecioVentaFinal"  size="5" class="text" />
	           <strong style="font-size: 15px">&nbsp;&nbsp;&nbsp;Total:</strong>
	           <input type="text" id="fTotal"  size="5" class="text" />
			</td>	  
	 </tr>	 
	 <tr>
	    <td id="detalleListaPrecio" colspan="4"></td>
	 </tr>
	 
	 <tr>
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
$("#tipo").val($_GET('tipo'));
$("#identificador").val($_GET('identificador'));
 function fn_cargarProducto(iProductoId,iStock,vNombreProducto,fProductoDescuento,iUnidadMedidadId,iUMBase,iUMPedido,fProductoPrecioCompra,fProductoPrecioVenta,fProductoDescuento,iProductoalmacenId){   
	    $("#iProductoId").val(iProductoId);
	    $("#iStock").val(iStock);
		$("#vxProductoNombre").val(vNombreProducto);
		$("#iUnidadMedidadId").val(iUnidadMedidadId);
		$("#iUMBase").val(iUMBase);
		$("#iUMPedido").val(iUMPedido);
		$("#fProductoPrecioVenta").val(fProductoPrecioVenta);
		$("#fProductoDescuento").val(fProductoDescuento);
		$("#fPrecioCompra").val(fProductoPrecioCompra);
		$("#fDescuento").val(fProductoDescuento);
		$("#iProductoalmacenId").val(iProductoalmacenId);
		var fDescuento =parseFloat(($("#fDescuento").val()/100));		
		$("#fProductoPrecioVentaFinal").val(dosDecimales(fProductoPrecioVenta)-parseFloat(fProductoPrecioVenta)*fDescuento);		
		$("#fTotal").val(dosDecimales(($("#stockSucursal").val()*$("#fProductoPrecioVentaFinal").val()),'')); 
		$("#detalleListaPrecio").html($("#tr_"+iProductoId).html());
		
	}
   function fn_cargarPrecio(fPrecioVenta,fPrecioCompra,fDescuento){	  
	   $("#fProductoPrecioVenta").val(fPrecioVenta);
	   $("#fPrecioCompra").val(fPrecioCompra);
	   $("#fDescuento").val(fDescuento);
	   $("#fProductoPrecioVentaFinal").val(dosDecimales(fPrecioVenta-parseFloat((fPrecioVenta)*fDescuento/100)));	
	  	$("#fTotal").val(dosDecimales(($("#stockSucursal").val()*$("#fProductoPrecioVentaFinal").val()),'')); 
		
	   
   }
	function fn_CalcularTotal(){ 
		var iStock = parseFloat($("#iStock").val());
		var iCantidad =parseFloat($("#stockSucursal").val());
		if(iCantidad>iStock){
			alert('La cantidad ingresada es mayor al stock\nLo maximo a solicitar es: '+iStock);
			$("#stockSucursal").val(iStock);
			iCantidad=iStock;
		}		
		var fPrecioVenta=$("#fProductoPrecioVenta").val();
		var fDescuento =parseFloat(($("#fDescuento").val()/100));		
		$("#fProductoPrecioVentaFinal").val(dosDecimales(fPrecioVenta)-parseFloat(fPrecioVenta)*fDescuento);		
		$("#fTotal").val(dosDecimales((iCantidad*$("#fProductoPrecioVentaFinal").val()))); 
	}
	
	function fn_agregarProducto(){
		var id=$("#iProductoId").val();
		if(id!=''){
		var iCantidad=$("#stockSucursal").val();		
		var fDescuento=$("#fDescuento").val();			
		var fPrecioVenta =$("#fProductoPrecioVenta").val();
		var fPrecioCompra =$("#fPrecioCompra").val();
		var fTotal = $("#fTotal").val();
		var iPersonalId=0;
		var iProductoalmacenId = $("#iProductoalmacenId").val();
	    var cad = "venta.do?metodo=detalleVenta&id="+id+"&iCantidad="+iCantidad+
	    		  "&fDescuento="+fDescuento+"&fPrecioVenta="+fPrecioVenta+"&fPrecioCompra="+fPrecioCompra+
	    		  "&fTotal="+fTotal+"&mode=I"+"&iPersonalId="+iPersonalId+"&identificador="+$_GET("identificador")+
	    		  "&iProductoalmacenId="+iProductoalmacenId;
	         $.getJSON(cad, function retorna(obj){
	        	// alert("obje"+obj.cProductoCodigo);
	        	 listar_detalleVenta(obj,'padre',$_GET("identificador"));
	        	 });
		}
		else{
			alert("Debe de seleccionar producto");
		}
	        
	 }
 
	
 </script>  