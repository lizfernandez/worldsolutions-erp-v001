<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="productos" styleId="formProductos" >
<tr>
	 <td colspan="4">
	 <span id ="span1" class="btnOpcionesActivo"  onclick="subMenuOpciones('1')">Salida</span>
	 <span id ="span2" class="btnOpciones" onclick="subMenuOpciones('2')">Recepcion</span>
	 <table class="tabla" id="tabla1">	 		
	   <tr>
		     <td align="right">Fecha Salida:</td>
		    <td>
		    <html:text property="dFechaSalida" styleId="dFechaSalida" maxlength="15"  styleClass="text "  tabindex="1" /> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    <span id="m_dFechaIngreso" class="importante">*</span>
		    </td>
		     <td align="right">Nro Salida :</td>
		    <td>
		    <html:text property="vNroSalida" styleId="vNroSalida" maxlength="15"  styleClass="text "  tabindex="2" onkeyup="return mayuscula('vNroSalida')"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		     <span id="m_vNroSalida" class="importante">*</span>
		    </td>
		    
		</tr>		
		<tr>
		    <td align="right">Almacen salida:</td>
		    <td>		
			 <html:select  property="iAlmacenSalidaId" styleId="iAlmacenSalidaId" styleClass="combo" tabindex="3" style="width:153px">       
		       <html:options collection="listaAlmacen" property="sucursal.iSucursalId" labelProperty="vAlmacenNombre" />
		       
		       
		     </html:select> 
			    <span id="m_iAlmacenSalidaId" class="importante">*</span>
			</td>
			<td align="right">Almacen Ingreso:</td>
		    <td>		
			 <html:select  property="iAlmacenEntradaId" styleId="iAlmacenEntradaId" styleClass="combo" tabindex="4" style="width:153px">       
		       <html:options collection="listaAlmacen" property="iAlmacenId" labelProperty="vAlmacenNombre"/>
		     </html:select> 
			    <span id="m_iAlmacenSalidaId" class="importante">*</span>
			</td>
		      
		</tr>
		
		<tr>
		    <td align="right">Personal de Entreda:</td>
		    <td colspan="3">
		    <html:text property="cPersonalCodigo"  styleId="cPersonalCodigo" maxlength="5" styleClass="textCodigo inputDisabled" />
	        <html:text property="vPersonalNombres"  styleId="vPersonalNombres"   styleClass="text inputDisabled" size="47"/>
	    <span id="m_cPersonalCodigo" class="importante"></span>
	    <input type="hidden" id="vOcupacionDescripcion"/>
	    <input type="hidden" id="fSueldo"/>
		       <html:hidden property="iUsuarioEntregaId"  styleId="iUsuarioEntregaId" />
		        <button type="button"  class="button" onclick="popupModal('personal.do?metodo=listaPersonal&mode=LP&iPersonalId=iUsuarioEntregaId&codigo=cPersonalCodigo&nombre=vPersonalNombres',580,250)"><span class='imgpopup'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></button>
		    </td>
		</tr>
		<tr>
		    <td align="right">Personal de Recepcion:</td>
		    <td colspan="3">
		     <html:text property="cPersonalCodigoRecep"  styleId="cPersonalCodigoRecepcion" maxlength="5" styleClass="textCodigo inputDisabled" />
	        <html:text property="vPersonalNombresRecep"  styleId="vPersonalNombresRecepcion"   styleClass="text inputDisabled" size="47"/>
	        <html:hidden property="iUsuarioRecepcionId"  styleId="iUsuarioRecepcionId" />
		    
		        <button type="button"  class="button" onclick="popupModal('personal.do?metodo=listaPersonal&mode=LP&iPersonalId=iUsuarioRecepcionId&codigo=cPersonalCodigoRecepcion&nombre=vPersonalNombresRecepcion',580,250)" ><span class='imgpopup'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></button>
		    </td>
		    
		</tr>
		<tr>
		    <td align="right">Punto de Salida:</td>
		    <td colspan="3">
		       <html:text property="vPuntoSalida"  styleId="vPuntoSalida" styleClass="textN " tabindex="7"  onkeyup="return mayuscula('vPuntoSalida')" size="72"/>
		    </td>
		</tr>
		<tr>
		    <td align="right">Punto de Llegada:</td>
		    <td colspan="3">
		       <html:text property="vPuntoLlegada"  styleId="vPuntoLlegada" styleClass="textN " tabindex="8" onkeyup="return mayuscula('vPuntoLlegada')" size="72"/>
		    </td>
		    
		</tr>
		<tr>
		    <td align="right">Observacion:</td>
		    <td colspan="3">
		       <html:text property="vObservacion"  styleId="vObservacion" styleClass="textN " tabindex="9" size="72"  onkeyup="return mayuscula('vObservacion')"/>
		    </td>		
		    
		</tr>
		<tr style="height: 1px;">
      <td colspan="4"><table width="100%" border="1" cellspacing="0" cellpadding="0" id="detalle">
      <tr>
        <th>&nbsp;</th>
        <th>C&Oacute;DIGO</th>
        <th width="12%">CANTIDAD</th>
        <th>UNID.</th>
        
        <th>DESCRIPCI&Oacute;N</th>
        <!--th>C.Compra</th>
        <th>Ganancia(%)</th-->
        <th align="right">P.U.</th>
        <th align="right">% DESC.</th>
        <th align="right">TOTAL</th>
      </tr>
      <logic:notEmpty name="listaDistAlmacenDetalle" >      
      <logic:iterate id="x" name="listaDistAlmacenDetalle" indexId="i">
       <logic:equal  name="x"  property="cEstadoCodigo" value="AC">
         <tr id="fila${i}">
          <td><img  src="${pageContext.request.contextPath}/media/imagenes/delete.png" onclick="fn_eliminar('${i}')" class="imgDelete" /></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td>	           
	           <input type="text" class="inputderecha" id="numero${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="iCantidad" />"/>
	           <input type='hidden' size='10' class='inputderecha' id='numeroReal${i}'  value='<bean:write name="x" property="iCantidad" />'/>
            </td>
            <logic:notEqual name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion"  value="">
                <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            </logic:notEqual>
             
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td align="right">
                <input type="text" class="inputderecha" id='precio${i}' disabled="true" value="<bean:write name="x" property="producto.fProductoPrecioVenta" format="#,##0.00" locale="Localidad" /> "/>                
            </td>
             <td align="right">
                <input type="text" class="inputderecha" id='descuento${i}' disabled="true" value="<bean:write name="x" property="producto.fProductoDescuento" format="#,##0.00" locale="Localidad" />"/>                
            </td>            
            <td align="right">  
                   <span class="total${i}">
	                 <bean:write name="x" property="fTotal" />
	                </span>
	               <span id="total${i}" class="totales">
	                 <bean:write name="x" property="fTotal" />
	               </span>          
              </td>
        </tr> 
        </logic:equal>        
      </logic:iterate>      
    </logic:notEmpty>
      <tr>
        <td><img  src="${pageContext.request.contextPath}/media/imagenes/new.png" onclick="fn_listarProducto()" class="imgNew" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        
      </tr> 
      <tr>
        <td colspan="7" id="iProductos"> <span id="m_iProductos" class="importante">Ingrese Productos</span></td>

      </tr>     
    </table></td>
  </tr>
		<tr> 
         <td align="right" colspan="3">TOTAL:</td>
         <td align="right">
         <span class="tipoMoneda"></span>
            <html:text property="fTotal" styleId="fTotal" maxlength="15"  styleClass="text inputderecha " readonly="true"  /> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
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
      <button onclick="fn_imprimir()"  class="button" id="btnImprimir"><span class='savePrint' id="btnGuardar">Imprimir</span></button>
     <button onclick="cancelar('');"  class="button" type="button" tabindex="23"><span class='cancel'>Cancelar</span></button>
     <br>
    
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iDistAlmacenId" styleId="iDistAlmacenId"/>

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />	
		
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduDistAlmacen" styleId="metodo"/>






</html:form>
<script>
   
     var mode = document.getElementById('mode').value;	
    if(mode=='I') {
       
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DATOS');	
        $("#span2").hide();
    } else {
        $(".trCodigo").show();
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');
        $(".imgNew, .imgDelete").hide();
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
    
 
    function fn_listarProducto(){
    	var iclasificacionId = 1;
    
    	var iSucursalId = $("#iAlmacenSalidaId").val();
  
    	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&tipo=ventas&mode=LPA&iSucursalId='+iSucursalId,750,560);
    	
    }
function fn_eliminar(key){
    	
    	
    	var cad = "productos.do?metodo=detalleAlmacen&id="+key+"&mode=D";        
        $.getJSON(cad, function retorna(obj){
       	// alert("obje"+obj.cProductoCodigo);
       	 
       	listar_detalleAlmacen(obj,'hijo');
       	 });
       
        fn_calcularTotales();
       
    }
    
function fn_calcularTotal(fila) {    
	var cantidad = parseFloat($.trim($("#numero"+fila).val()));
	   var cantidadReal = parseFloat($.trim($("#numeroReal"+fila).val()));
	 if(cantidadReal<cantidad){
		 alert('La cantidad ingresada es mayor al stock\nLo maximo a solicitar es: '+cantidadReal);
			$("#numero"+fila).val(cantidadReal);
			
		 }
	   cantidad = parseFloat($.trim($("#numero"+fila).val()));
	
    var total = 'total'+fila;
    var precio =  parseFloat($.trim($("#precio"+fila).val()));        
    var fDescuento = parseFloat($.trim($("#descuento"+fila).val()));   	
	var precioReal = (precio)-(precio*(fDescuento/100));
    var precioTotal = dosDecimales(parseFloat(cantidad*precioReal));

    	
    
  
  	document.getElementById(total).innerHTML = precioTotal;   
	$("."+total).text( (precioTotal));

	var identificador = $("#identificador").val();
    var cad = "venta.do?metodo=detalleVenta&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioVenta="+precio+"&fDescuento="+fDescuento+"&identificador="+identificador;
    
    $.getJSON(cad, function retorna(obj){
   	      // 	 listar_detalleIngresoProducto(obj,'hijo');
    	
     });
   
	
    fn_calcularTotales();
   
}
function fn_descuentoProducto(){    	
	$("#fVentaTotal").val(parseFloat($("#fVentaTotalReal").val())-parseFloat(numeroFloat($("#fDescuentoR").val()))-parseFloat(numeroFloat($("#fDescClienteVenta").val())));
	$("#fDescuento").val($("#fDescuentoR").val());
   	 $("#siIgv").attr("checked",true);
   	 $("#vIncluyeIGV").val('siIgv');
   	fn_calcularGlobal();
}
function fn_descuentoCliente(){    	
	$("#fVentaTotal").val(parseFloat($("#fVentaTotalReal").val())-parseFloat(numeroFloat($("#fDescuento").val()))-parseFloat(numeroFloat($("#fDescClienteVentaR").val())));
	$("#fDescClienteVenta").val($("#fDescClienteVentaR").val());
	 $("#siIgv").attr("checked",true);
	fn_calcularGlobal();
}
function fn_calcularTotales(){
 	var sumaTotalReal=parseFloat(0.0);
	var sumaTotal=parseFloat(0.0);
	var sumaDescuento=parseFloat(0.0);    	
	 for(var key=0;key<=50;key++){
        /*****************************************/
        /** Obtenemos el total y total descuento**/
        /*****************************************/
        var precio= $.trim($("#precio"+key).val())==""?0:parseFloat($.trim($("#precio"+key).val()));
   	 var cantidad =$.trim($("#numero"+key).val())==""?0: parseFloat($.trim($("#numero"+key).val()));
   	 var descuento = $.trim($("#descuento"+key).val())==""?0:parseFloat($.trim($("#descuento"+key).val()));
   	 var total = $.trim($("#total"+key).text())==""?0:parseFloat($.trim($("#total"+key).text()));
   	 
   	 sumaTotal =sumaTotal+parseFloat(total); 
        sumaTotalReal = sumaTotalReal+(precio*cantidad);
        sumaDescuento = sumaDescuento+(precio*(descuento/100))* cantidad;
 
   }
	 document.getElementById('fTotal').value=dosDecimales(sumaTotalReal-sumaDescuento);        
	
		 
   fn_calcularGlobal();
}
function fn_calcularGlobal(){
}
function fn_imprimir(){
	window.print();
	insertar('tabla');
}
   // redimenciona();
</script>