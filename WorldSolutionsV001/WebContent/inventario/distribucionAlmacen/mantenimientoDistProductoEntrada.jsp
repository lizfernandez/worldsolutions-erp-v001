<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="productos" styleId="formProductos" >
<tr>
	 <td colspan="4">
	 <span id ="span1" class="btnOpcionesActivo"  onclick="subMenuOpciones('1')">Entrada</span>
	 
	 <table class="tabla" id="tabla1">	 		
	   <tr>
		     <td align="right">Fecha Ingreso:</td>
		    <td>
		    <html:text property="dFechaIngreso" styleId="dFechaIngreso" maxlength="15"  styleClass="text "  tabindex="1" /> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    <span id="m_dFechaIngreso" class="importante">*</span>
		    </td>
		     <td align="right">Nro Recepci&oacute;n :</td>
		     
		    <td>
		    <html:text property="vNroIngreso" styleId="vNroIngreso" size="13"  styleClass="text "  tabindex="2" onkeyup="return mayuscula('vNroSalida')"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		     <span id="m_vNroIngreso" class="importante">*</span>
		    </td>
		    
		</tr>
		<tr>
		     <td align="right">Fecha Salida:</td>
		    <td>
		    <html:text property="dFechaSalida" styleId="dFechaSalida" maxlength="15"  styleClass="text "  tabindex="1" /> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		    <span id="m_dFechaSalida" class="importante">*</span>
		    </td>
		     <td align="right">Nro Salida :</td>
		     
		    <td>
		    <html:text property="vNroSalida" styleId="vNroSalida" size="13"  styleClass="text "  tabindex="2" onkeyup="return mayuscula('vNroSalida')"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
		     <span id="m_vNroSalida" class="importante">*</span>
		      <button type="button"  class="button" onclick="popupModal('productos.do?metodo=listaDistAlmacen&mode=LP',580,250)"><span class='imgpopup'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></button>
		    </td>
		    
		</tr>		
		<tr>
		    <td align="right">Almacen Salida:</td>
		    <td>		
			 <html:select  property="iAlmacenSalidaId" styleId="iAlmacenSalidaId" styleClass="combo" tabindex="3" style="width:153px" onchange="fn_cambioAlmacen('iAlmacenSalidaId','salida')">       
		       <html:options collection="listaAlmacen" property="iAlmacenId" labelProperty="vAlmacenNombre" />
		     </html:select> 
			    <span id="m_iAlmacenSalidaId" class="importante">*</span>
			    <html:text property="iSucursalId" styleId="iSucursalId" styleClass="textInvisible" />
			</td>
			<td align="right">Almacen Recepci&oacute;n:</td>
		    <td>		
			 <html:select  property="iAlmacenEntradaId" styleId="iAlmacenEntradaId" styleClass="combo" tabindex="4" style="width:153px" onchange="fn_cambioAlmacen('iAlmacenEntradaId','entrada')">       
		       <html:options collection="listaAlmacen" property="iAlmacenId" labelProperty="vAlmacenNombre"/>
		     </html:select> 
			    <span id="m_iAlmacenSalidaId" class="importante">*</span>
			</td>
		      
		</tr>
		
		<tr>
		    <td align="right">Personal Resp. de Entrega:</td>
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
		    <td align="right">Personal Resp. de Recepcion:</td>
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
      <td colspan="4">
      <table width="100%" border="1" cellspacing="0" cellpadding="0" id="detalle">
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
            <input type="text" id="fTotalx" maxlength="15"  class="text inputderecha " readonly="true"  /> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
</td>
</tr>
<tr style="height: 1px;">
      <td colspan="4">
      <table width="100%" border="1" cellspacing="0" cellpadding="0" id="detalleDevolucion">
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

<html:hidden property="vTipoOperacion" styleId="vTipoOperacion"  value="E"/>		
		
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduDistAlmacen" styleId="metodo"/>






</html:form>
<script>


$("#dFechaSalida").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            minDate: 0,
            maxDate: '+30Y', 
    });
$("#dFechaIngreso").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            minDate: 0,
            maxDate: '+30Y', 
    });
     var mode = document.getElementById('mode').value;	
    if(mode=='IE' || mode=='IS' ) {
       
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DATOS');	
        
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
    
    	var iSucursalId = $("#iSucursalId").val();
  
    	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&tipo=inventario&mode=LPA&iSucursalId='+iSucursalId,750,560);
    	
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
    var cad = "productos.do?metodo=detalleAlmacen&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioVenta="+precio+"&fDescuento="+fDescuento+"&identificador="+identificador;
    
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
 	var sumaTotalReale=parseFloat(0.0);
	var sumaTotale=parseFloat(0.0);
	var sumaTotal=parseFloat(0.0);
	var sumaDescuento=parseFloat(0.0);    	
	 for(var key=0;key<=150;key++){
        /*****************************************/
        /** Obtenemos el total y total descuento**/
        /*****************************************/
     var precio= $.trim($("#precio"+key).val())==""?0:parseFloat($.trim($("#precio"+key).val()));
   	 var cantidad =$.trim($("#numero"+key).val())==""?0: parseFloat($.trim($("#numero"+key).val()));
   	 var descuento = $.trim($("#descuento"+key).val())==""?0:parseFloat($.trim($("#descuento"+key).val()));
   	 var total = $.trim($("#total"+key).text())==""?0:parseFloat($.trim($("#total"+key).text()));
   	var totale = $.trim($("#totale"+key).text())==""?0:parseFloat($.trim($("#totale"+key).text()));
   	 
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
function fn_cambioAlmacen(id,tipo){
	var ids = $("#"+id).val();
	  var cad = "productos.do?metodo=json&mode=almacen&id="+ids;
	 $.getJSON(cad, function retorna(obj){
  	 if(tipo=="entrada"){
  		$("#vPuntoLlegada").val(obj['sucursal'].vSucursalDireccion);
  	 }
  	 if(tipo=="salida"){
  		 $("#iSucursalId").val(obj['sucursal'].iSucursalId);
  		 $("#vPuntoSalida").val(obj['sucursal'].vSucursalDireccion);
  	 }  
   	
    });
}
   // redimenciona();
</script>