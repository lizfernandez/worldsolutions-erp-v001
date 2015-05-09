
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script>


    function fn_calcularGanancia(tipo) {
        var compra = parseFloat(($("#fProductoPrecioCompra").val()==null)?0:$("#fProductoPrecioCompra").val());
        var precio = parseFloat(($("#fProductoPrecioVenta").val()==null)?0:$("#fProductoPrecioVenta").val());
        var ganancia = parseFloat(($("#fProductoGanancia").val()==null)?0:$("#fProductoGanancia").val())+ parseFloat(($("#fProductoGastosAdm").val()==null)?0:$("#fProductoGastosAdm").val());
        
       
        if(precio!='' || ganancia!=''){
            if(compra!='' && compra!='0') {
               if(precio!='' && tipo=='V') {
                    ganancia = Math.round(((precio - compra)*100/compra)*100)/100;
                   
                    $("#fProductoGanancia").val(ganancia);
                    
               } 
               if(ganancia!='' && tipo=='G') {
                    precio =Math.round((compra+compra*ganancia/100) * 100) / 100;
                  
                  
                    $("#fProductoPrecioVenta").val(precio);
                   
                    
               }
            } else {
                alert('INGRESE PRECIO COMPRA');
            }
        } else {
            alert('INGRESE UTILIDAD');
        }
    }
    function fn_calcularGananciaLista(tipo) {
        var compra = parseFloat(($("#fPrecioCompra").val()==null)?0:$("#fPrecioCompra").val());
        var precio = parseFloat(($("#fPrecioVenta").val()==null)?0:$("#fPrecioVenta").val());
        var ganancia = parseFloat(($("#fGanancia").val()==null)?0:$("#fGanancia").val());
        
       
        if(precio!='' || ganancia!=''){
            if(compra!='' && compra!='0') {
               if(precio!='' && tipo=='V') {
                    ganancia = Math.round(((precio - compra)*100/compra)*100)/100;
                   
                    $("#fGanancia").val(ganancia);
                    
               } 
               if(ganancia!='' && tipo=='G') {                   
                    precioLista =Math.round((compra+compra*ganancia/100) * 100) / 100;
                  
                   
                    $("#fPrecioVenta").val(precioLista);
                    
               }
            } else {
                alert('INGRESE PRECIO COMPRA');
            }
        } else {
            alert('INGRESE PRECIO DE VENTA O GANANCIA');
        }
    }

 </script>
<html:form action="productos" styleId="formProductos" enctype="multipart/form-data">
<tr> <td colspan="4" ><span class="titulosTd"  id="po">Clasificaci&oacute;n:</span></td></tr>
<tr>
    <td align="right" width="23%">Categor&iacute;a:</td>
    <td>
     <html:select  property="iCategoriaId" styleId="iCategoriaId" styleClass="combo" onchange="listSubCategoria()" tabindex="1" style="width:205px" >
           <html:options collection="listaCategoria" property="iCategoriaId" labelProperty="vCategoriaDescripcion"/>
     </html:select>    
    </td>
    <td rowspan="3" width="9%">FOTO (ancho:225px):
    							    (alto:225px):</td>
     <td rowspan="3" colspan="3">
      <img  src="${pageContext.request.contextPath}/media/fotos/<bean:write property="vFoto" name="productosForm"/>" width="50%" height="30%" border="1"/>
     </td>
</tr>
<tr>
    <td align="right">SubCategor&iacute;a:</td>
    <td>
     <html:select  property="iSubCategoriaId" styleId="iSubCategoriaId" styleClass="combo" tabindex="2" style="width:205px">
           <html:options collection="listaSubCategoria" property="iSubCategoriaId" labelProperty="vSubCategoriaDescripcion"/>
     </html:select> 
     <span id="m_iSubCategoriaId" class="importante">*</span>     
    </td>
   
</tr>

<tr class="trCodigo">
    <td align="right" >C&oacute;digo:</td>
    <td>
        <html:text property="cProductoCodigo" styleId="cProductoCodigo"  size="10" styleClass="text" maxlength="8"  onkeyup="return mayuscula('cProductoCodigo') " tabindex="3"/>
        <span id="m_cProductoCodigo" class="importante">*</span>
    </td>
      
</tr>
<tr> 
    <td align="right" width="25%">Nombre:</td>
    <td><html:text property="vProductoNombre" styleId="vProductoNombre" size="27" onkeyup="return mayuscula('vProductoNombre') " styleClass="text" tabindex="4" maxlength="45" />
      <span id="m_vProductoNombre" class="importante">*</span>
    </td>
    <td colspan="2"> 
      <html:file property="foto" styleId="foto" style="width:273px"></html:file>
      
    </td>
</tr>
<tr>
	 <td colspan="4">
	 <span id ="span1" class="btnOpcionesActivo"  onclick="subMenuOpciones('1')">Datos B&aacute;sicos:</span>
	 <span id ="span3" class="btnOpciones" onclick="subMenuOpciones('3')">Almacen</span>
	 <span id ="span2" class="btnOpciones" onclick="subMenuOpciones('2')">Lista Precios</span>
	 <table class="tabla" id="tabla1">	  
		
		<tr>
		    <td align="right" width="20%">UM Base:</td>
		    <td width="20%">
		    <html:text property="iUMBase" styleId="iUMBase" maxlength="7"  styleClass="text textNumero" tabindex="5" onkeypress="return Numeros(event)"/> 
		     <span id="m_iUMBase" class="importante">*</span>   
		    </td>
		    <td colspan="2">
		      <html:select  property="iUMBaseId" styleId="iUMBaseId" styleClass="comboCodigo" tabindex="6" style="width:140px" >
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select> 
		    </td>
		</tr>
		<tr>
		     <td align="right">UM Pedido:</td>
		    <td><html:text property="iUMPedido" styleId="iUMPedido" maxlength="7"  styleClass="textN textNumero"  tabindex="7" onkeypress="return Numeros(event)"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    </td>
		    <td colspan="2">  
		       <html:select  property="iUMPedidoId" styleId="iUMPedidoId" styleClass="comboCodigo" tabindex="8" style="width:140px">
		          <option value="0">::SELECCIONE::</option> 
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select>  
		    </td>
		</tr>
		<tr>
		     <td align="right">UM Salida:</td>
		    <td><html:text property="vUMSalida" styleId="vUMSalida" maxlength="7"  styleClass="textN textNumero"  tabindex="9" onkeypress="return Numeros(event)"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    </td>
		    <td colspan="2">  
		       <html:select  property="iUMSalidaId" styleId="iUMSalidaId" styleClass="comboCodigo" tabindex="10" style="width:140px">
		          <option value="0">::SELECCIONE::</option> 
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select>  
		    </td>
		</tr>
	   <tr>
		     <td align="right">Stock Total:</td>
		    <td><html:text property="iProductoStockTotal" styleId="iProductoStockTotal" maxlength="7"  styleClass="text textNumero"  tabindex="11" onkeypress="return Numeros(event)"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		     <span id="m_iUnidadMedidadId" class="importante">*</span> 
		    </td>
		    <td colspan="2">  
		       <html:select  property="iUnidadMedidadId" styleId="iUnidadMedidadId" styleClass="text comboCodigo unidadFinal" tabindex="12" style="width:140px" >
		         
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>		          
		     </html:select>  
		      
		    </td>
		</tr>		
		<tr>
		    <td align="right">P.U Compra:</td>
		    <td>
			    <html:text property="fProductoPrecioCompra" styleId="fProductoPrecioCompra" styleClass="text textNumero" tabindex="13" onkeypress="return Numeros(event)"/>
			    <span id="m_fProductoPrecioCompra" class="importante">*</span>
			</td>
		      <td colspan="2">
			     <html:select  property="iMonedaId" styleId="iMonedaId" styleClass="comboCodigo" tabindex="14" style="width:140px">
			          <html:options collection="listaMoneda" property="iMonedaId" labelProperty="vMonedaDescripcion"/>
			     </html:select> 
			     
		     </td>
		</tr>
		<tr>
		    <td align="right">Gasto Adm:</td>
		    <td>
		       <html:text property="fProductoGastosAdm"  styleId="fProductoGastosAdm" styleClass="text textNumero" tabindex="15" onkeypress="return Numeros(event)"/>
		       </td>
		       <td colspan="2">
		        <select class="comboCodigo" disabled="disabled" id="porcent" style="width:140px">
			          <option value=""/> %</option>
			     </select>
		    </td>
		    
		</tr>
		<tr>
		    <td align="right">Utilidad:</td>
		    <td>
		       <html:text property="fProductoGanancia"  styleId="fProductoGanancia" styleClass="text textNumero" onblur="fn_calcularGanancia('G')" tabindex="16" onkeypress="return Numeros(event)"/>
		       </td>
		       <td colspan="2">
		        <select class="comboCodigo" disabled="disabled" id="porcent" style="width:140px">
			          <option value=""/> %</option>
			     </select>
		    </td>
		</tr>
		<tr>
		    <td align="right">P.U Venta:</td>
		    <td>
		      <html:text property="fProductoPrecioVenta" styleId="fProductoPrecioVenta" styleClass="text textNumero" tabindex="17" onkeypress="return Numeros(event)"/>
		      <span id="m_fProductoPrecioVenta" class="importante">*</span>
		    </td>
		    <td colspan="2">
		    <html:select  property="iMonedaId" styleId="iMonedaId" styleClass="comboCodigo change" style="width:140px">
			          <html:options collection="listaMoneda" property="iMonedaId" labelProperty="vMonedaDescripcion"/>
			     </html:select>
			     
		      </td>
		</tr>
		<tr>
		    <td align="right">% Descuento:</td>
		    <td colspan=""><html:text property="fProductoDescuento" styleId="fProductoDescuento" styleClass="text textNumero"  tabindex="18" onkeypress="return Numeros(event)"/></td>   <!-- onkeypress="return Numeros(event)" -->
		    <td align="right">Stock Min:</td>
		    <td colspan=""><html:text property="iProductoStockMinimo" styleId="iProductoStockMinimo" styleClass="text textNumero"  tabindex="19" onkeypress="return Numeros(event)"/></td>   <!-- onkeypress="return Numeros(event)" -->
		  
		</tr>
		<tr>
		     <td align="right">Stock Max:</td>
		     <td colspan=""><html:text property="iProductoStockMaximo" styleId="iProductoStockMaximo" styleClass="text textNumero"  tabindex="20" onkeypress="return Numeros(event)"/></td>  <!-- onkeypress="return Numeros(event)" -->
		     <td align="right" width="22%">Estado:</td>
		    <td colspan="2">
		      <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" tabindex="21" style="width:153px">       
		       <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
		     </html:select>  
		    </td>
		</tr>
		
	 </table> 
	 <table class="tabla" id="tabla3" style="display: none">
	      
          <thead>
          <logic:empty name="productosForm" property="producAlmacen">
				<tr>
					<td colspan="12">No hay informaci&oacute;n del Precio producto</td>
				</tr>
			</logic:empty>
			<logic:notEmpty name="productosForm" property="producAlmacen">		
			   
	        <logic:iterate name="productosForm" property="producAlmacen" id="x" indexId="i">
		       <tr id="tr_01">
			<td align="right" width="20%">Sucursal:</td>
			<td colspan="4"><bean:write name="x" property="almacen.sucursal.vSucursalNombre"/></td>
			<td align="right" width="20%">Almacen:</td>
			<td  colspan="9"><bean:write name="x" property="almacen.vAlmacenNombre"/>
			<input type="hidden" id="iAlmacenId${i}" value="<bean:write name="x" property="almacen.iAlmacenId"/>">
			<input type="hidden" id="iProductoAlmacenId${i}" value="<bean:write name="x" property="iProductoAlamcenId"/>">
			</td>
			</tr>
			<tr>
		    <td align="right" width="20%">UM Base:</td>
		    <td width="20%">
		    <input type="text" id="iUMBaseAlm${i}" maxlength="7"  value="<bean:write name="x" property="iUMBaseAlm"/>"
		    styleClass="text textNumero" onkeypress="return Numeros(event)" size="10" onblur="fn_totalProducto(${i})"/> 
		    <span id="m_iUMBase" class="importante">*</span>  
		    </td>
		    <td colspan="2">
		      <html:select  property="iUMBaseAlmId" styleId="iUMBaseAlmId" styleClass="comboCodigo iUMBaseAlmId" tabindex="6" style="width:140px" >
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select> 
		    </td>
		 
		     <!-- td align="right">UM Pedido:</td>
		    <td><input type="text" name="iUMPedidox" maxlength="7"  styleClass="textN textNumero iUMPedidox"  onkeypress="return Numeros(event)" size="10"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    <!-- /td>
		    <td colspan="2">  
		       <html:select  property="iUMPedidoId" styleId="iUMPedidoIdx" styleClass="comboCodigo iUMPedidoIdx"  style="width:140px">
		          <option value="0">::SELECCIONE::</option> 
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select>  
		    </td>
		
		     <td align="right">UM Salida:</td>
		    <td><input type="text" name="vUMSalidax" maxlength="7"  styleClass="textN textNumero vUMSalidax"  onkeypress="return Numeros(event)" size="10"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    <!-- /td>
		    <td colspan="2">  
		       <html:select  property="iUMSalidaId" styleId="iUMSalidaIdx" styleClass="comboCodigo iUMSalidaIdx" style="width:140px">
		          <option value="0">::SELECCIONE::</option> 
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select>  
		    </td-->
	
		     <td align="right">Stock Total:</td>
		    <td><input type="text" id="iProductoAlmStockTotal${i}" maxlength="7"  styleClass="textN textNumero" value="<bean:write name="x" property="iProductoAlmStockTotal"/>"  onkeypress="return Numeros(event)" size="10"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    </td>
		    <td colspan="2">  
		       <html:select  property="iUnidadMedidaAlmId" styleId="iUnidadMedidaAlmId" styleClass="comboCodigo unidadFinal"  style="width:140px" >
		          <option value="0">::SELECCIONE::</option> 
		          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
		     </html:select>  
		    </td>
		    
			 
			 
	</tr>
	</logic:iterate>
			
			 </logic:notEmpty>
			 
				  
				
		  
	 </table>
	 <table class="tabla" id="tabla2" style="display: none">
	      
          <thead>
		       <tr id="tr_01">
					<td>Cantidad:</td>
					<td><input type="text" id="iCantidadStock" class="textN" size="10">
					    <input type="text" id="iPrecioProductoId" class="textInvisible" value="0" size="10"></td>
					<td>Precio Compra:</td>
					<td><input type="text" id="fPrecioCompra" class="textN" size="10"></td>
					<td>% ganancia:</td>
					<td><input type="text" id="fGanancia" class="textN" onblur="fn_calcularGananciaLista('G')" size="10" ></td>
					<td colspan="2"><button type="button" onclick="limpiar('tabla2')" class="button">
         				 <span class='refresh' id="btnLimpiar">Limpiar</span></button></td>
			  </tr>
			   <tr id="tr_02">				
					
					<td>% Desc.:</td>
					<td><input type="text" id="fDescuento" class="textN" size="10"></td>
					<td>Precio Venta:</td>
					<td><input type="text" id="fPrecioVenta" class="textN" size="7"></td>
					<td>Estado:</td>
					<td>
					<html:select  property="cEstadoCodigo" styleId="cEstadoCodigoPrecio" styleClass="combo" tabindex="15">       
				       <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
				     </html:select>
		           </td>
		           <td colspan="2"><button type="button" onclick="agregarPrecio('tabla2')" class="button">
         				 <span class='add' id="btnAgregar" >Agregar</span></button></td>
				</tr>
				  
				
		     <tr style="background-color: silver;">		    
		        <th align="left" >Cantidad</th>		      
		        <th align="left">Precio Compra</th>
		        <th align="left">% Ganancia</th>
		        <th align="left">% Descuento</th>
		        <th align="left">Precio Venta</th>		        
		        <th align="left">Fecha</th>        
		        <th align="left">Estado</th>
		      </tr>
		    </thead>
		    <tbody id="tr_detalle">
		    <logic:empty name="productosForm" property="produc">
				<tr>
					<td colspan="12">No hay informaci&oacute;n del Precio producto</td>
				</tr>
			</logic:empty>
			<logic:notEmpty name="productosForm" property="produc">		
			   
	        <logic:iterate name="productosForm" property="produc" id="x" indexId="i">		    
				<tr id='tr_${i}' onclick="llenarDatos('${i}')">
				    <td class="iCantidadStock"><bean:write name="x" property="iCantidadStock"/></td>
					<td class="fPrecioCompra"><bean:write name="x" property="fPrecioCompra"/></td>
					<td class="fGanancia"><bean:write name="x" property="fGanancia"/></td>
					<td class="fDescuento"><bean:write name="x" property="fDescuento" /></td>
					<td class="fPrecioVenta"><bean:write name="x" property="fPrecioVenta"/></td>				    				   
					<td class="dFechaInserta"><bean:write name="x" property="dFechaInserta"  format="dd/MM/yyyy" locale="Localidad"/></td>
					<td class="cEstadoCodigoPrecio"><bean:write name="x" property="cEstadoCodigo" /></td>	   
				</tr>
				</logic:iterate>
			
			 </logic:notEmpty>
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
				<div class="btnPagInactivo" id="Next" >&emsp;  </div>
				<div class="btnPagInactivo" id="Final" >&emsp; </div>
			</logic:notEmpty>	  
			</div> 
			<script>   
			paginacion();
			</script>
      </td>
</tr>

<tr height="10px">   
    <td align="center" colspan="4">
    <br>    
     <button onclick="insertar('tab-grupo')" class="button" tabindex="22">
          <span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button" tabindex="23"><span class='cancel'>Cancelar</span></button>
     <br>
    
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iProductoId" styleId="iProductoId"/>

<%-- hidden field que contiene el id del producto --%>



<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />

			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduProducto" styleId="metodo"/>




<html:hidden property="vFoto" />
<%-- hidden field que contiene el iUsuarioInsertaId del producto --%>

<html:hidden property="sizeIngresoproductodetalles" />
<html:hidden property="sizeVentaDetalles" />


</html:form>
<script>
   
    
   $(".comboCodigo.change").attr("disabled",true);
   $("#iMonedaId").change(function () {
    	var mival = $("#iMonedaId option:selected").val();
    	$(".comboCodigo.change option[value="+mival+"]").attr("selected",true); 
   });
   $("#iUMBaseId").change(function () {
   	var mival = $("#iUMBaseId option:selected").val();
   	$(".comboCodigo.unidadFinal option[value="+mival+"]").attr("selected",true);
   	$(".comboCodigo.iUMBaseAlmId option[value="+mival+"]").attr("selected",true); 
   	var iUMBase=parseInt(($("#iUMBase").val()==null)?0:$("#iUMBase").val());
   	$("#iProductoStockTotal").val(iUMBase);
    });
   $("#iUMPedidoId").change(function () {
	   	var mival = $("#iUMPedidoId option:selected").val();
	   	$(".comboCodigo.unidadFinal option[value="+mival+"]").attr("selected",true); 
		$(".comboCodigo.iUMPedidoIdx option[value="+mival+"]").attr("selected",true); 
	   	var iUMBase=parseInt(($("#iUMBase").val()==null)?1:$("#iUMBase").val()) * parseInt(($("#iUMPedido").val()==null)?1:$("#iUMPedido").val());
	   	$("input[name*='iUMPedido']").val($("#iUMPedido").val());
	   	
	   	$("#iProductoStockTotal").val(iUMBase);
	});
   $("#iUMSalidaId").change(function () {
	   	var mival = $("#iUMSalidaId option:selected").val();
	   	$(".comboCodigo.unidadFinal option[value="+mival+"]").attr("selected",true); 
	   	$(".comboCodigo.iUMSalidaIdx option[value="+mival+"]").attr("selected",true);
		var iUMBase=parseFloat(($("#iUMBase").val()==null)?1:$("#iUMBase").val()) * parseFloat(($("#iUMPedido").val()==null)?1:$("#iUMPedido").val())*parseFloat(($("#vUMSalida").val()==null)?1:$("#vUMSalida").val());
		$("input[name*='vUMSalidax']").val($("#vUMSalida").val());
		$("#iProductoStockTotal").val(iUMBase);
   });
     var mode = document.getElementById('mode').value;	
    if(mode=='I') {
        document.getElementById('cProductoCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DATOS');	
        $("#span2").hide();
    } else {
        $(".trCodigo").show();
        document.getElementById('vProductoNombre').focus();
    	var mival1 = $("#iUnidadMedidadId option:selected").val();
	   	$(".comboCodigo.unidadFinal option[value="+mival1+"]").attr("selected",true); 
		var mival2 = $("#iUMPedidoId option:selected").val();	   	 
		$(".comboCodigo.iUMPedidoIdx option[value="+mival2+"]").attr("selected",true);
		var mival3 = $("#iUMBaseId option:selected").val();	   	
	   	$(".comboCodigo.iUMBaseAlmId option[value="+mival3+"]").attr("selected",true); 
        document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');
        //$("#span2").hide();
        if(mode=='F'){
        	$("#popupCabecera").text('BUSCAR DATOS');        	
         	/*$(":input").attr('disabled',true);
         	$(":hidden").attr('disabled',false);
         	$(":button").attr('disabled',false);*/
         	$("#btnGuardar").removeClass('save');
         	$("#btnGuardar").addClass('find');
        	$("#btnGuardar").text('Buscar');
         }
    }
 function listSubCategoria(){
	 var iCategoriaId = $("#iCategoriaId").val();
	 var cad = "categoria.do?metodo=cambioCategoria&id="+iCategoriaId;  	
	 var newHtml='';
 	
     $.getJSON(cad, function retorna(obj){
    	 $.each(obj,function(key,data){
    	 
    	 		newHtml+='<option value='+data.iSubCategoriaId+'>';
    	 			newHtml+=data.vSubCategoriaDescripcion;
    	 		newHtml+='</option>';
    	 	});
    	 $("#iSubCategoriaId").html(newHtml);
      });
     
    
    
 }
 function llenarDatos(id){
	 $("#iPrecioProductoId").val(id);
	 $(document).find('#tr_'+id+' td').each(function(key,val){ 		 
		  $("#"+$(this).attr('class')).val($( this ).text());
		
	   });
	$('#btnAgregar').text("Actualizar");
 }
 
 function agregarPrecio(id){
	var iCantidadStock =$("#iCantidadStock").val();
	var fPrecioCompra =$("#fPrecioCompra").val();
	var fGanancia =$("#fGanancia").val();
	var fDescuento =$("#fDescuento").val();
	var fPrecioVenta =$("#fPrecioVenta").val();
	var cEstadoCodigoPrecio =$("#cEstadoCodigoPrecio").val();
	var iProductoId = ($("#iProductoId").val()==null)?0:$("#iProductoId").val();
	var iPrecioProductoId = "";
	var newHtml ="";
	if($("#iPrecioProductoId").val()==0){
		iPrecioProductoId =0;
		mode = "I" ;
	}
	else{
		iPrecioProductoId = $("#iPrecioProductoId").val();
		mode = "U";
	}
	var f = new Date();
	var fecha = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();
	
	var cad = "productos.do?metodo=detalleListaPrecios&iPrecioProductoId="+iPrecioProductoId+"&iCantidadStock="+iCantidadStock+"&fPrecioCompra="+fPrecioCompra+"&fGanancia="+fGanancia+"&fDescuento="+fDescuento+
			   "&fPrecioVenta="+fPrecioVenta+"&cEstadoCodigoPrecio="+cEstadoCodigoPrecio+"&iProductoId="+iProductoId+"&mode="+mode;
	
	
	 
	 $.getJSON(cad, function retorna(obj){		 	
		 
    	 $.each(obj,function(key,data){
    		 newHtml+='<tr>';
    	 		newHtml+='<td>'+data.iCantidadStock+'</td>';
    	 		newHtml+='<td>'+data.fPrecioCompra+'</td>';
    	 		newHtml+='<td>'+data.fGanancia+'</td>';
    	 		newHtml+='<td>'+data.fDescuento+'</td>';
    	 		newHtml+='<td>'+data.fPrecioVenta+'</td>';
    	 		newHtml+='<td>'+fecha+'</td>';
    	 		newHtml+='<td>'+data.cEstadoCodigo+'</td>';
    	 	newHtml+='</tr>';
    	 	});
    	 
    	 $("#tr_detalle").html(newHtml);
      });
	
 }
 function fn_totalProducto(i){
	 
	 var iUMBase=parseFloat(($("#iUMBaseAlm"+i).val()=="")?1:$("#iUMBaseAlm"+i).val()) * parseFloat(($("#iUMPedido").val()=="0")?1:$("#iUMPedido").val())*parseFloat(($("#vUMSalida").val()=="0")?1:$("#vUMSalida").val());
	//alert($("#iUMBaseAlm"+i).val()+" "+$("#iUMPedido").val()+" "+$("#vUMSalida").val());	
	 $("#iProductoAlmStockTotal"+i).val(iUMBase);
	 var iAlmacenId = $("#iAlmacenId"+i).val();
	 var iProductoId = $("#iProductoId").val();
	 var iProductoAlmacenId=$("#iProductoAlmacenId"+i).val()==""?0:$("#iProductoAlmacenId"+i).val();
	 
	 var iUMBaseAlm = $("#iUMBaseAlm"+i).val();
	 
	 var iUMBaseAlmId= $("#iUMBaseAlmId").val();
	 var iProductoAlmStockTotal=$("#iProductoAlmStockTotal"+i).val();
	 var iUnidadMedidaAlmId	=$("#iUnidadMedidaAlmId").val();
		var cad = "productos.do?metodo=detalleProductoAlmacen&iAlmacenId="+iAlmacenId+"&iProductoId="+iProductoId+"&iProductoAlmacenId="+iProductoAlmacenId
				+"&iUMBaseAlm="+iUMBaseAlm+"&iUMBaseAlmId="+iUMBaseAlmId+
		   "&iProductoAlmStockTotal="+iProductoAlmStockTotal+"&iUnidadMedidaAlmId="+iUnidadMedidaAlmId+"&mode="+mode+"&i="+i;



$.getJSON(cad, function retorna(obj){
	 
	
});
 }
 

   // redimenciona();
</script>