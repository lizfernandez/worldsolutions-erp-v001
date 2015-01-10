
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formVenta" enctype="echarset=utf-8">
<table width="1296" height="439" border="1" cellpadding="0" cellspacing="0" class="tabla" id="tabla">
    <tr style="height: 1px;">
      <td>
      
    </td>
  </tr>
  <tr style="height: 1px;">
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr style="height: 1px;">
            <td width="100%">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabla">
            <tr>
                <td width="14%">FECHA:</td>
                <td colspan="3">
                	<html:text property="dVentaFecha" styleId="dVentaFecha" styleClass="text textCodigo" readonly="true" tabindex="1"/>
    				<span id="m_dVentaFecha" class="importante">*</span>
                </td>
                
                <td>TIPO DOC.:</td>
                <td> 
                  <html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" onchange="fn_CambioTipoDoc()" style="width:162px">       
                   <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
                  </html:select>				    
				 </td>
                
                </tr>
            <tr>
                <td>CLIENTE:</td>
                <td colspan="3">
              		  <html:text property="vClienteCodigo"  styleId="vClienteCodigo" maxlength="5" styleClass="textCodigo inputDisabled" />	   				  
	   				  <html:text property="vClienteRazonSocial"  styleId="vClienteRazonSocial"  styleClass="text textGrande inputDisabled" size="55%"/>	 
	   				  <button type="button"  class="button" onclick="popupModal('cliente.do?metodo=listaCliente&mode=LP',580,350)" tabindex="1" ><span class='imgpopup'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></button>
	                <span id="m_vClienteRazonSocial" class="importante">*</span>
                </td>
                <td>NRO DOCUMENTO:</td>
                <td>                
				   <html:text property="nVentaNumero"  styleId="nVentaNumero" maxlength="15" styleClass="text " />
				   <span id="m_nVentaNumero" class="importante">*</span>
				 </td>
            </tr>
          <tr>
          <td>DIRECCI&Oacute;N :</td>
          <td colspan="3">
	          <html:text property="vClienteDireccion" styleId="vClienteDireccion"   styleClass="textExtraGrande inputDisabled" size="60%"/>         
	          <span id="imgDireccion" onclick="cargar_direcciones();" class="imgpopup"/>
           </td>
            <td>FORMA DE PAGO :</td>
            <td>
                <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo" style="width:160px" onchange="fn_PagoCredito()">        
                 <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
                </html:select>
                <span id="m_iFormaPago" class="importante">*</span>
            </td>
          </tr>
          <tr>
          <td>R.U.C :</td>
          <td colspan="3">
              <html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  styleClass="text textCodigo inputDisabled" readonly="true" /></td>
           <td width="5%">ORDEN DE COMPRA :</td>
           <td width="14%">
              <html:text property="cVentaOrdenCompra"  styleId="cVentaOrdenCompra" styleClass="textN" />
           </td>
          </tr>
          <tr>
           <td width="5%">PUNTO DE LLEGADA :</td>
          <td colspan="3"  width="16%">
             <html:text property="vVentaPuntoLlegada" styleId="vVentaPuntoLlegada"  tabindex="1" size="60%"  styleClass="textExtraGrande inputDisabled"/>
          </td>
           
                <td width="13%">VENDEDOR:</td>
                <td><html:text property="vPersonalNombres" styleId="vPersonalNombres" styleClass="textExtraGrande" readonly="true" tabindex="1"/></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr style="height: 1px;">
      <td><table width="100%" border="1" cellspacing="0" cellpadding="0" id="detalle">
      <tr>
        <th>&nbsp;</th>
        <th>C&Oacute;DIGO</th>
        <th width="12%">CANTIDAD</th>
        <th>UNID.</th>
        <th width="12%">CAPACIDAD</th>
        <th>DESCRIPCI&Oacute;N</th>
        <!--th>C.Compra</th>
        <th>Ganancia(%)</th-->
        <th align="right">P.U.</th>
        <th align="right">% DESC.</th>
        <th align="right">TOTAL</th>
      </tr>
      <logic:notEmpty name="listaVentaDetalle" >      
      <logic:iterate id="x" name="listaVentaDetalle" indexId="i">
       <logic:equal  name="x"  property="cEstadoCodigo" value="AC">
         <tr id="fila${i}">
          <td><img  src="${pageContext.request.contextPath}/media/imagenes/delete.png" onclick="fn_eliminar('${i}')" /></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td>	           
	           <input type="text" class="inputderecha" id="numero${i}" onBlur="fn_calcularTotal('${i}','<bean:write name="x" property="producto.iProductoStockCantidad" />','<bean:write name="x" property="iVentaDetalleCantidad" />')" value="<bean:write name="x" property="iVentaDetalleCantidad" />"/>
            </td>
            <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            <td><bean:write name="x" property="producto.vProductoCapacidad" /> <bean:write name="x" property="producto.vUnidadMedidaDescripcionC" /></td>
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td align="right">
                <input type="text" class="inputderecha" id="precio${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="fVentaDetallePrecio" format="#,##0.00" locale="Localidad" />"/>                
            </td>
             <td align="right">
                <input type="text" class="inputderecha" id="descuento${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="fDescuento" format="#,##0.00" locale="Localidad" />"/>                
            </td>            
            <td align="right">  
                   <span class="total${i}">
	                 <bean:write name="x" property="fVentaDetalleTotal" />
	                </span>
	               <span id="total${i}" class="totales">
	                 <bean:write name="x" property="fVentaDetalleTotal" />
	               </span>          
              </td>
        </tr> 
        </logic:equal>        
      </logic:iterate>      
    </logic:notEmpty>
      <tr>
        <td><img  src="${pageContext.request.contextPath}/media/imagenes/new.png" onclick="fn_listarProducto()" /></td>
        <td>&nbsp;</td>
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
 <tr style="height: 1px;">  
    <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
               <td width="70%">
	               <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera"  style="display: none;" id="formaPago">
			            <thead>
			            <tr> <td align="center" colspan="4"><strong> Forma de Pago a <span id="tipoFormaPago"> </span></strong></tr>
			            </thead>
			            <tr class="tr" > 
			                <td  align="left">Fecha Prox pago:</td>
			                <td align="left">
			                   <html:text property="dFechaProximoPago" styleId="dFechaProximoPago"   styleClass="textExtraGrande" />   
			                 </td>	
			                     		                
			                <td align="left"><span class="tr2"> Monto Adelanto:</span></td>
			                <td align="left"><span class="tr2">  <html:text property="fMontoAdelantado" styleId="fMontoAdelantado"   styleClass="textExtraGrande" /></span>
			                 
			                 </td>
			           
			             </tr>		           
			            <tr>	           		                
			                <td align="left">Numero de Dias:</span></td>
			                <td align="left"> <html:text property="iNumeroDias" styleId="iNumeroDias"   styleClass="textExtraGrande" /></td>
			                 <td align="left"><span class="tr3"> Max. de Letras:</span></td>
			                <td align="left">
			                <span class="tr3">
			                <html:text property="iNumeroLetras" styleId="iNumeroLetras"   styleClass="textExtraGrande" />
			                </span></td>
			            </tr> 
	               </table>
               </td>  
               <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" id="tablaImpuesto" >                
		             <tr>
		                
		                <td align="right">TOTAL<span class="tipoMoneda"></span> </td>
		                <td align="right">
		                  <input type="text" id="fVentaTotalRealR"  class="text inputDisabled textNumero" readonly="true" />		                  
		                </td>
		            </tr>
		             <tr>
		                
		                <td align="right">Descuento <span class="tipoMoneda"></span> </td>
		                <td align="right">
		                   <input type="text" id="fDescuentoR" class="text inputDisabled textNumero" onblur="fn_descuento()" />	                 
		                 </td>
		             </tr>		      
               </table>
              </td>
           </tr>
           <tr>
	           <td  width="70%">
	           </td>
           <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" >                
		
		            <tr> 
		                <td align="right" >
		                   <input type="radio" id="siIgv" onclick="fn_conIgv()"  class="text"  name="iIGV" checked="checked" />Si incluye IGV
		                 </td>
		                 <td align="right" >
		                   <input type="radio" id="noIgv" onclick="fn_conIgv()"  class="text" name="iIGV" />No incluye IGV
		                 </td>
		            </tr>
		            <tr> 
		                <td width="50%" align="right">Base Imponible <span class="tipoMoneda"></span></td>
		                <td align="right">
		                   <input type="text" id="fVentaSubTotalR"  class="text inputDisabled textNumero" readonly="true" />
		                 </td>
		            </tr>
		            <tr>		                
		                <td align="right"><!--  input type="checkbox"  checked="checked" onclick="fn_SinIGV()" id="sinIGV" />-->IGV(<span class="IGVVentas"></span>%)  <span class="tipoMoneda"></span> </td>
		                <td align="right">
		                 <input type="text" id="fVentaIGVR"  class="text inputDisabled textNumero" readonly="true"  />
		                 </td>
		            </tr>
		            <tr>
		                
		                <td align="right">TOTAL  FINAL<span class="tipoMoneda"></span> </td>
		                <td align="right">
		                  <input type="text" id="fVentaTotalR"  class="text inputDisabled textNumero" readonly="true" />
		                  <span id="m_fVentaTotalR" class="importante">*</span>
		                </td>
		            </tr>
		           
               </table>
           </td>
           </tr>
        </table>
    </td>    
  </tr> 
  <tr>  
    <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
               <td width="84%">&nbsp;</td>  
                <td>
                <table style="height: 100%" cellpadding="0" cellspacing="0" border="0">
				    <tr>
				        <td align="left">
				           <button onclick="insertar('tabla')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
				           
				        </td>
				        <td><button onclick="cancelar('');" class="button" type="button"><span class='cancel'>Cancelar</span></button></td>
				    </tr>
				</table>
              </td>
               
        </table>
    </td>    
  </tr> 
<tr height="50px">   
    <td align="center" colspan="2">
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iVentaId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iClienteId" styleId="iClienteId" />


<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iTipoDocumentoId" styleId="iTipoDocumentoId" />
<html:hidden property="iclasificacionId" styleId="iclasificacionId" />
<html:hidden property="vEstadoDocumento" styleId="vEstadoDocumento" value="CANCELADO"/>
<html:hidden property="fVentaTotalReal" styleId="fVentaTotalReal" />
<html:hidden property="fDescuento" styleId="fDescuento" />
<html:hidden property="fVentaSubTotal" styleId="fVentaSubTotal" />
<html:hidden property="fVentaIGV" styleId="fVentaIGV" />
<html:hidden property="fVentaTotal" styleId="fVentaTotal" />
<html:hidden property="tipoMoneda" styleId="tipoMoneda" />
<html:hidden property="IGVVentas" styleId="IGVVentas" />




<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduVenta" styleId="metodo" />	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    document.getElementById('fVentaSubTotalR').value =formatCurrency($("#fVentaSubTotal").val(),'');
    document.getElementById('fVentaIGVR').value =formatCurrency($("#fVentaIGV").val(),'');
    document.getElementById('fVentaTotalR').value =formatCurrency($("#fVentaTotal").val(),'');
    document.getElementById('fVentaTotalRealR').value =formatCurrency($("#fVentaTotalReal").val(),'');
    document.getElementById('fDescuentoR').value =formatCurrency($("#fDescuento").val(),'');

    $("#dIngresoProductoFecha").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    });
	  $("#dFechaProximoPago").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            minDate: '+0d'
	           
	    }); 
    $(".tipoMoneda").text($("#tipoMoneda").val());
    $(".IGVVentas").text($("#IGVVentas").val());
  

    $("#iNumeroLetras").val($("#iNumeroLetras").val()==0?1:$("#iNumeroLetras").val());
    
    
    if(mode=='I') {
        //document.getElementById('vVentaCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR VENTAS');	
        
        
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');	
        fn_PagoCredito();
        if(mode=='F'){
        	$("#popupCabecera").text('BUSCAR DATOS');        	
         	$("#btnGuardar").removeClass('save');
         	$("#btnGuardar").addClass('find');
        	$("#btnGuardar").text('Buscar');
         }
        if(mode=="ED"){// visualizar venta
        	$(":input").attr("disabled",true);
            $(".imgpopup").hide();
        }
    }

    function fn_PagoCredito(){
    	var i = $("#iFormaPago").val();
    	$("#formaPago, .tr, .tr2,  .tr3").css("display","none");
    	$("#tipoFormaPago").text($("#iFormaPago :selected").text());
    	$("#vEstadoDocumento").val("DEUDA");
    	$("#tablaImpuesto").css("height","82px");
    	if(i==1){$("#vEstadoDocumento").val("CANCELADO"); $("#tablaImpuesto").css("height","0px");}
		if(i==2||i==3||i==4){$("#formaPago").show();$(".tr, .tr2").show();}
		if(i==5||i==6){$("#formaPago").show();$(".tr, .tr3").show();}	
		if(i==2||i==5)$("#iNumeroDias").val(15);
		if(i==3||i==4||i==6)$("#iNumeroDias").val(30);
  
    }
    function fn_eliminar(key){
         var cad = "venta.do?metodo=detalleVenta&id="+key+"&mode=D";        
        $.getJSON(cad, function retorna(obj){
       	// alert("obje"+obj.cProductoCodigo);
       	 listar_detalleVenta(obj,'hijo');
       	 });
       
        fn_calcularTotales();
       
    }
    function fn_CambioTipoDoc(key){
    	var iTipoDocumentoId= $("#iTipoDocumentoId").val()
        var cad = "venta.do?metodo=obtenerCodigoVenta&iTipoDocumentoId="+iTipoDocumentoId;        
       $.getJSON(cad, function retorna(obj){
      	 $("#nVentaNumero").val(obj);
      	 
      	 });
      
       //fn_calcularTotales();
      
   }
   
    function cargar_direcciones(){
        var cliente = $("#iClienteId").val();
        if(cliente!='0') {
            var cad = "cliente.do?metodo=listaCliente&mode=LPD&id=" + cliente ;
            popupModal(cad,580,250);
        } else {
            alert('INGRESE UN CLIENTE');
        }
    }

    function fn_calcularTotal(fila,cantidadStock,cantidadventa) {    	
    	var cantiVenta = cantidadventa=="undefined"?0:parseFloat(cantidadventa);
    	
    	var cantiStock =  parseFloat(cantidadStock)+parseFloat(cantiVenta);
        var total = 'total'+fila;
        var precio =  parseFloat($.trim($("#precio"+fila).val()));
        var cantidad = parseFloat($.trim($("#numero"+fila).val()));
        var fDescuento = parseFloat($.trim($("#descuento"+fila).val()));   	
    	var precioReal = (precio)-(precio*(fDescuento/100));
        var precioTotal = parseFloat(cantidad*precioReal);
    
        if(cantidad>cantiStock){
        	alert('La cantidad ingresada es mayor al stock\nLo maximo a solicitar es: '+cantiStock); 
        	cantidad=cantiStock;
        	$("#numero"+fila).val(cantiStock);
        	
        	
        }
        
      
      	document.getElementById(total).innerHTML = precioTotal;   
    	 $("."+total).text( formatCurrency(precioTotal,''));
  
        var cad = "venta.do?metodo=detalleVenta&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioVenta="+precio+"&fDescuento="+fDescuento;
        
        $.getJSON(cad, function retorna(obj){
       	      // 	 listar_detalleIngresoProducto(obj,'hijo');
        	
         });
       
   	
        fn_calcularTotales();
       
    }
    function fn_descuento(){    	
    	$("#fVentaTotal").val(parseFloat($("#fVentaTotalReal").val())-parseFloat(numeroFloat($("#fDescuentoR").val())));
    	$("#fDescuento").val($("#fDescuentoR").val());
    	fn_calcularGlobal();
    }
    
    function fn_conIgv(){
    	var igvCompra =($('#IGVVentas').val())/100;
    	var total = parseFloat($('#fVentaTotal').val());
    	var totalReal = parseFloat($('#fVentaTotalReal').val());
    	var totalDescuento = parseFloat($('#fDescuento').val());
    	if($("#noIgv").is(":checked")){  
         	total = parseFloat(total)+parseFloat(total*igvCompra);
         }
         else{
         	total = totalReal-totalDescuento;
         }
    	 document.getElementById('fVentaTotal').value =(total);
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
    	 document.getElementById('fVentaTotalReal').value=sumaTotalReal;
         document.getElementById('fVentaTotal').value=sumaTotal;
    	 document.getElementById('fDescuento').value=sumaDescuento;
    		 
        fn_calcularGlobal();
    }
    function fn_calcularGlobal(){
    	var sumaTotalReal= document.getElementById('fVentaTotalReal').value;
    	var sumaTotal=document.getElementById('fVentaTotal').value;
    	var sumaDescuento=document.getElementById('fDescuento').value;  	

        
        var igvCompra =(document.getElementById('IGVVentas').value)/100;
        document.getElementById('fVentaSubTotalR').value =formatCurrency(Math.round(sumaTotal/(1+igvCompra)*100)/100,'');
        document.getElementById('fVentaIGVR').value =formatCurrency( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100,'');
        document.getElementById('fVentaTotalR').value =formatCurrency(sumaTotal,'');
        document.getElementById('fVentaTotalRealR').value =formatCurrency(sumaTotalReal,'');
        document.getElementById('fDescuentoR').value =formatCurrency(sumaDescuento,'');
        
        document.getElementById('fVentaSubTotal').value =(Math.round(sumaTotal/(1+igvCompra)*100)/100);
        document.getElementById('fVentaIGV').value =( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100);
        document.getElementById('fVentaTotal').value =(sumaTotal);
        document.getElementById('fVentaTotalReal').value =(sumaTotalReal);
        document.getElementById('fDescuento').value =(sumaDescuento);
        
       
        
        
    }
    function fn_listarProducto(){
    	var iclasificacionId = $("#iclasificacionId").val();
    	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&mode=LP',690,560);
    	
    }

</script>