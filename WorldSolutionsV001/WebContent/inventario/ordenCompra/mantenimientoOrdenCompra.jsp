
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="ingresoProducto" styleId="formIngresoProducto" >
<table border="1" cellpadding="0" cellspacing="0" class="tabla" id="tabla" style="width: 70%; float: left;" >
  <tr style="height: 1px;">
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr style="height: 1px;">
            <td width="100%">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabla">
            <tr>
                <td>FECHA:</td>
                <td colspan="3">
                	<html:text property="dFechaPedido" styleId="dFechaPedido" styleClass="text" readonly="true" tabindex="1" />
    				<span id="m_dFechaPedido" class="importante">*</span>
                </td>
                <!-- td>CODIGO:</td>
                <td><html:text property="cPersonalCodigo" styleId="cPersonalCodigo" styleClass="textN" readonly="true" tabindex="1"/></td-->
                <td>TIPO DOC.:</td>
                <td> 
                  <html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" onchange="fn_CambioTipoDoc()" style="width:162px">       
                   <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
                  </html:select>
                             
				    
				 </td>
                </tr>
            <tr>
                <td>PROVEEDOR:</td>
                <td colspan="3" width="50%" align="left">
              		  <html:text property="cProveedorCodigo"  styleId="cProveedorCodigo" maxlength="5" styleClass="textCodigo inputDisabled"/>
	   				  <html:text property="vProveedorRazonSocial"  styleId="vProveedorRazonSocial"  styleClass="text textGrande inputDisabled" size="55%"/>
	   				  <input type="hidden" id="vClasificacion"  class="text textCodigo inputDisabled" readonly="true" />
                      <input type="hidden" id="fDescuentoProveedor"  class="text inputDisabled" readonly="true" size="6" />
  
	   				   <button type="button"  class="button" onclick="popupModal('proveedor.do?metodo=listaProveedor&mode=LP',580,350)" tabindex="1" ><span class='imgpopup'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></button>
	                  
	                  <span id="m_vProveedorRazonSocial" class="importante">*</span>
                </td>
                <td>NRO DOCUMENTO:</td>
                <td><html:text property="vNroOrden"  styleId="vNroOrden" maxlength="10" styleClass="text " tabindex="1"/>
				   <span id="m_vNroOrden" class="importante">*</span>
				 </td>
                
            </tr>
          <tr>
          <td>DIRECCI&Oacute;N :</td>
          <td colspan="3">
	          <html:text property="vProveedorDireccion" styleId="vProveedorDireccion"   styleClass="textExtraGrande inputDisabled" size="60%" />         
	         
           </td>
           <td>FORMA DE PAGO :</td>
            <td>
                <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo" onchange="fn_PagoCredito()" tabindex="1" style="width:162px">       
                 <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
                </html:select>
                <span id="m_iFormaPago" class="importante">*</span>
            </td>
          </tr>
          <tr>
          <td>R.U.C :</td>
          <td colspan="3">
              <html:text property="nProveedorNumeroDocumento" styleId="nProveedorNumeroDocumento"  styleClass="text inputDisabled" readonly="true" tabindex="1"/></td>
          <td>VENDEDOR:</td>
                <td><html:text property="vPersonalNombres" styleId="vPersonalNombres" styleClass="textExtraGrande" readonly="true"/></td>
           
          </tr>
          <tr style="display: none;">
           <td width="5%">PUNTO DE LLEGADA :</td>
          <td colspan="3"  width="16%">
             <html:text property="vIngresoProductoPuntoLlegada" styleId="vIngresoProductoPuntoLlegada" size="60%"  styleClass="textExtraGrande inputDisabled" readonly="true" tabindex="1"/>
          </td>
            <td width="5%"></td>
            <td width="14%">
               
            </td>
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
        <th>DESCRIPCI&Oacute;N</th>
        <th align="right">P.U.</th>
        <th align="right">% DESC.</th>
        <th align="right">TOTAL</th>
      </tr>
      <logic:notEmpty name="listaIngresoProductoDetalle" >      
      <logic:iterate id="x" name="listaIngresoProductoDetalle" indexId="i">
       <logic:equal  name="x"  property="cEstadoCodigo" value="AC">
         <tr id="fila${i}">
          <td><img src="${pageContext.request.contextPath}/media/imagenes/delete.png" onclick="fn_eliminar('${i}')"  class="imgDelete"/></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td>
              <input type="text" class="inputderecha" id="numero${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="iCantidad" />"/>
	        </td>
            <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
         
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td align="right">
                <input type="text" class="inputderecha" id="precio${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="fPrecioUnitario" format="#,##0.00" locale="Localidad" />"/>                
            </td>
             <td align="right">
                <input type="text" class="inputderecha" id="descuento${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="fDescuento" format="#,##0.00" locale="Localidad" />"/>                
            </td>
            <td align="right">  
                   <span class="total${i}">
	                 <bean:write name="x" property="fTotal" format="#,##0.00"  locale="Localidad"/>
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
        <td><img src="${pageContext.request.contextPath}/media/imagenes/new.png" onclick="fn_listarProducto()" class="imgNew" /></td>
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
               <td width="60%" >
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
               
           </tr>
           
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
</table>
<table border="1" cellpadding="0" cellspacing="0" class="tabla" id="tabla" style="width: 30%; float: right;">
<tr style="height: 1px;"> 
    <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
        
               <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" id="tablaImpuesto" >                
		             <tr>
		                
		                <td align="right">TOTAL:</td>
		                <td align="right">
		                  <span class="tipoMoneda"></span> 
		                  <input type="text" id="fIngresoProductoTotalRealR"  class="text inputDisabled textNumero" size="13"  readonly="true" />		                  
		                </td>
		            </tr>
		             <tr>
		                
		                <td align="right">Desc. Producto:</td>
		                <td align="right">
		                    <span class="tipoMoneda"></span> 
		                   <input type="text" id="fDescuentoR" class="text  textNumero" onblur="fn_descuento()" size="13" />	                 
		                 </td>
		             </tr>			      
               </table>
              </td>
           </tr>
           <tr>
	           
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
		                <td width="50%" align="right">Base Imponible:</td>
		                <td align="right">
		                    <span class="tipoMoneda"></span>
		                   <input type="text" id="fIngresoProductoSubTotalR"  class="text inputDisabled textNumero" readonly="true" size="13" />
		                 </td>
		            </tr>
		            <tr>		                
		                <td align="right">IGV(<span class="IGVCompra"></span>%): </td>
		                <td align="right">
		                   <span class="tipoMoneda"></span>
		                 <input type="text" id="fIngresoProductoIGVR"  class="text inputDisabled textNumero" readonly="true"  size="13"  />
		                 </td>
		            </tr>
		
		            <tr>
		                
		                <td align="right">TOTAL FINAL: </td>
		                <td align="right">
		                   <span class="tipoMoneda"></span>
		                  <input type="text" id="fIngresoProductoTotalR"  class="text inputDisabled textNumero" readonly="true" size="13"  />
		                  <span id="m_fIngresoProductoTotalR" class="importante">*</span>
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
				          <html:select  property="impresoraID" styleId="impresoraID" styleClass="combo" style="width:100px" onchange="fn_PagoCredito()">        
                            <html:options collection="listaImpresora" property="impresoraID" labelProperty="impresoraID"/>
                        </html:select>
				        </td>
				        <td align="left">
				           <button onclick="insertar('tabla')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
				           
				        </td>
				        <!-- td align="left">
				           <button onclick="imprimir('tabla')"  class="button" id="btnImprimir"><span class='savePrint' id="btnGuardar">Imprimir</span></button>
				           
				        </td -->
				        <td><button onclick="cancelar('');" class="button" type="button" id="btnCancel"><span class='cancel'>Cancelar</span></button></td>
				    </tr>
				</table>
              </td>
               
        </table>
    </td>    
  </tr>

</table>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iOrdenCompraId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iProveedorId" styleId="iProveedorId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iTipoDocumentoId" styleId="iTipoDocumentoId" />
<html:hidden property="iclasificacionId" styleId="iclasificacionId" />
<html:hidden property="vEstadoDocumento" styleId="vEstadoDocumento" value="CANCELADO"/>


<html:hidden property="fIngresoProductoTotalReal" styleId="fIngresoProductoTotalReal" />
<html:hidden property="fDescuento" styleId="fDescuento" />
<html:hidden property="fIngresoProductoSubTotal" styleId="fIngresoProductoSubTotal" />
<html:hidden property="fIngresoProductoIGV" styleId="fIngresoProductoIGV" />
<html:hidden property="fIngresoProductoTotal" styleId="fIngresoProductoTotal" />
<html:hidden property="tipoMoneda" styleId="tipoMoneda" />
<html:hidden property="IGVCompra" styleId="IGVCompra" />
<html:hidden property="IGVPercepcion" styleId="IGVPercepcion" />
<html:hidden property="vTipoPago" styleId="vTipoPago" />
<html:hidden property="vTipoCompra" styleId="vTipoCompra" />
<html:hidden property="vIncluyeIGV" styleId="vIncluyeIGV" />
<html:hidden property="fMontoVuelto" styleId="fMontoVuelto" />
<html:hidden property="fMontoPago" styleId="fMontoPago" />
<html:hidden property="iSucursalId" styleId="iSucursalId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduOrdenCompra" styleId="metodo" />	

</html:form>
<script>

    
    var mode = document.getElementById('mode').value;
    
    document.getElementById('fIngresoProductoSubTotalR').value =formatCurrency($("#fIngresoProductoSubTotal").val(),'');
    document.getElementById('fIngresoProductoIGVR').value =formatCurrency($("#fIngresoProductoIGV").val(),'');
    document.getElementById('fIngresoProductoTotalR').value =formatCurrency($("#fIngresoProductoTotal").val(),'');
    document.getElementById('fIngresoProductoTotalRealR').value =formatCurrency($("#fIngresoProductoTotalReal").val(),'');
    document.getElementById('fDescuentoR').value =formatCurrency($("#fDescuento").val(),'');
   // document.getElementById('fDescClienteVentaR').value =formatCurrency($("#fDescClienteVenta").val(),'');
    document.getElementById('vTipoCompra').value =$("#tipoMoneda").val();
    $("#impresoraID option[value='BIXOLON SRP-270']").attr("selected",true); 
   
    $("#dFechaPedido").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    });
	      
	    
	$(".tipoMoneda").text($("#tipoMoneda").val());
    $(".IGVCompra").text($("#IGVCompra").val());
    $(".IGVPercepcion").text($("#IGVPercepcion").val());

    $("#iNumeroLetras").val($("#iNumeroLetras").val()==0?1:$("#iNumeroLetras").val());
   
    if(mode=='I') {
        document.getElementById('nIngresoProductoNumero').focus();
        document.getElementById('btnGuardar').textContent="Guardar";
        $(".trCodigo").show();
        if($("#tipoMoneda").val()=="S/."){
        	$("#monedaSoles").attr("checked",true);
        	$("#vTipoPago").val('S/.');
        }
        if($("#tipoMoneda").val()=="$"){
        	$("#monedaDolares").attr("checked",true);
        	$("#vTipoPago").val('$');
        }
        $("#popupCabecera").text('REGISTROS DE NUEVAS COMPRAS');	
        
      
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');	
        fn_PagoCredito();
        $("#fIngresoProductoIGV").val()=='0.0'?$("#sinIGV").attr("checked",false):$("#sinIGV").attr("checked",true);
        var tipoCambio= parseFloat($("#fTipoCambio").val());
        $(".tipoMoneda").text($("#vTipoVenta").val());
	       
	        if($("#vTipoPago").val()=="S/."){
	        	$("#monedaSoles").attr("checked",true);
	        	
	        	$("#fMontoPagoDolares").val(dosDecimales(parseFloat($("#fMontoPago").val())/tipoCambio));
	        	$("#fMontoVueltoDolares").val(dosDecimales(parseFloat($("#fMontoVuelto").val())/tipoCambio));
	        	$("#fMontoPagoSoles").val(dosDecimales(parseFloat($("#fMontoPago").val())));
	        	$("#fMontoVueltoSoles").val(dosDecimales(parseFloat($("#fMontoVuelto").val())));
    			
	        }
	        if($("#vTipoPago").val()=="$"){
	        	$("#monedaDolares").attr("checked",true);
	        	$("#fMontoPagoDolares").val(dosDecimales(parseFloat($("#fMontoPago").val())));
	        	$("#fMontoVueltoDolares").val(dosDecimales(parseFloat($("#fMontoVuelto").val())));	        
	        	$("#fMontoPagoSoles").val(dosDecimales(parseFloat($("#fMontoPago").val())*tipoCambio));
	        	$("#fMontoVueltoSoles").val(dosDecimales(parseFloat($("#fMontoVuelto").val())*tipoCambio));
    		
	        }
	        if($("#vIncluyeIGV").val()=="siIgv"){
	        	$("#siIgv").attr("checked",true);
	        }
	        if($("#vIncluyeIGV").val()=="noIgv"){
	        	$("#noIgv").attr("checked",true);
	        }
        if(mode=='F'){
        	$("#popupCabecera").text('BUSCAR DATOS');        	
         	/*$(":input").attr('disabled',true);
         	$(":hidden").attr('disabled',false);
         	$(":button").attr('disabled',false);*/
         	$("#btnGuardar").removeClass('save');
         	$("#btnGuardar").addClass('find');
        	$("#btnGuardar").text('Buscar');
         }
        if(mode=="U"){// visualizar venta
        	$(":input").addClass("inputDisabled").attr("disabled",true);
            $(".imgpopup, .imgDelete, .imgNew").hide();
            $("#btnImprimir, #btnCancel").removeClass("inputDisabled").attr("disabled",false);
            $("#detallePago :input").removeClass("inputDisabled").attr("disabled",false);
            
            
        }
    }

    function fn_CambioTipoDoc(){
    	$("#iTipoDocumentoId").val($("#selTipoDocumento").val());
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
    	var suma = 0, total = 0;
        var cad = "ingresoProducto.do?metodo=detalleIngresoProducto&id="+key+"&mode=D";
        
        $.getJSON(cad, function retorna(obj){
       	// alert("obje"+obj.cProductoCodigo);
       	 listar_detalleCompra(obj,'hijo');
       	 });
        $(document).find(".totales").each(function(key,val){
            if($("#"+this.id)){
            	//alert($.trim($("#"+this.id).text()));
             		suma = parseFloat(suma) +parseFloat($.trim($("#"+this.id).text()));/*numero*/	
               }
        });
        //alert("suma ="+suma +" resta ="+$("#total"+key).text())       ; 
        document.getElementById('fIngresoProductoTotal').value = parseFloat(suma) - parseFloat($.trim($("#total"+key).text())); 
        fn_calcularGlobal();
       
    }
    
    function cargar_direcciones(){
        var proveedor = $("#iProveedorId").val();
        if(proveedor!='0') {
            var cad = "proveedor.do?metodo=listaProveedor&mode=LPD&id=" + proveedor ;
            popupModal(cad,580,250);
        } else {
            alert('INGRESE UN CLIENTE');
        }
    }

    function fn_calcularTotal(fila) {
  	        var total = 'total'+fila;
  	        var precio =  parseFloat($.trim($("#precio"+fila).val()));
  	        var cantidad = parseFloat($.trim($("#numero"+fila).val()));
  	        var fDescuento = parseFloat($.trim($("#descuento"+fila).val()));   	
  	    	var precioReal = (precio)-(precio*(fDescuento/100));
  	        var precioTotal = parseFloat(cantidad*precioReal);
              
  	        document.getElementById(total).innerHTML = precioTotal;   
    	    $("."+total).text( formatCurrency(precioTotal,''));
        var cad = "ingresoProducto.do?metodo=detalleIngresoProducto&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioCompra="+precio+"&fDescuento="+fDescuento;
       
        $.getJSON(cad, function retorna(obj){
       	      // 	 listar_detalleIngresoProducto(obj,'hijo');
        	
         });
   	
        fn_calcularTotales();
       
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
    	 document.getElementById('fIngresoProductoTotalReal').value=sumaTotalReal;
         document.getElementById('fIngresoProductoTotal').value=sumaTotal;
    	 document.getElementById('fDescuento').value=sumaDescuento;
    		 
        fn_calcularGlobal();
    }
    function fn_calcularGlobal(){
        var sumaTotalReal= document.getElementById('fIngresoProductoTotalReal').value;
    	var sumaTotal=document.getElementById('fIngresoProductoTotal').value;
    	var sumaDescuento=document.getElementById('fDescuento').value;  	

        
        var igvCompra =(document.getElementById('IGVCompra').value)/100;
        document.getElementById('fIngresoProductoSubTotalR').value =formatCurrency(Math.round(sumaTotal/(1+igvCompra)*100)/100,'');
        document.getElementById('fIngresoProductoIGVR').value =formatCurrency( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100,'');
        document.getElementById('fIngresoProductoTotalR').value =formatCurrency(sumaTotal,'');
        document.getElementById('fIngresoProductoTotalRealR').value =formatCurrency(sumaTotalReal,'');
        document.getElementById('fDescuentoR').value =formatCurrency(sumaDescuento,'');
        
        document.getElementById('fIngresoProductoSubTotal').value =(Math.round(sumaTotal/(1+igvCompra)*100)/100);
        document.getElementById('fIngresoProductoIGV').value =( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100);
        document.getElementById('fIngresoProductoTotal').value =(sumaTotal);
        document.getElementById('fIngresoProductoTotalReal').value =(sumaTotalReal);
        document.getElementById('fDescuento').value =(sumaDescuento);
        
        
        
    }
    
    function fn_descuento(){    	
    	$("#fIngresoProductoTotal").val(parseFloat($("#fIngresoProductoTotalReal").val())-parseFloat(numeroFloat($("#fDescuentoR").val())));
    	$("#fDescuento").val($("#fDescuentoR").val());
    	$("#siIgv").attr("checked",true);
	   	$("#vIncluyeIGV").val('siIgv');
    	fn_calcularGlobal();
    }
    
    function fn_conIgv(){
    	var igvCompra =($('#IGVCompra').val())/100;
    	var total = parseFloat($('#fIngresoProductoTotal').val());
    	var totalReal = parseFloat($('#fIngresoProductoTotalReal').val());
    	var totalDescuento = parseFloat($('#fDescuento').val());
    	if($("#noIgv").is(":checked")){  
         	total = parseFloat(total)+parseFloat(total*igvCompra);
         	$("#vIncluyeIGV").val('noIgv');
         }
         else{
         	total = totalReal-totalDescuento;
         	$("#vIncluyeIGV").val('siIgv');
         }
    	 document.getElementById('fIngresoProductoTotal').value =(total);
    	 fn_calcularGlobal();
    }
    function fn_tipoPago(){
	    var fCompraTotalR = parseFloat($("#fIngresoProductoTotal").val());
	    var tipoCambio=parseFloat($("#fTipoCambio").val());  
	    var montoPagoS=$("#fMontoPagoSoles").val()==""?0:parseFloat($("#fMontoPagoSoles").val()); 
	    var montoPagoD=$("#fMontoPagoDolares").val()==""?0:parseFloat($("#fMontoPagoDolares").val()); 
	   
	    
		 if($("#monedaDolares").is(":checked")){// mixto 
			if(montoPagoD==""){
				alert("Debe de ingresar monto en dolares");
			}
			else{
    			 
     			if($("#vTipoCompra").val()=='S/.'){
        			$("#fMontoVueltoSoles").val(dosDecimales(montoPagoS-fCompraTotalR));
        			$("#fMontoVueltoDolares").val(dosDecimales((montoPagoS-fCompraTotalR)/tipoCambio));
        			
        		}
        		else{
        			$("#fMontoVueltoDolares").val(dosDecimales(montoPagoD-fCompraTotalR));
        			$("#fMontoVueltoSoles").val(dosDecimales((montoPagoD-fCompraTotalR)*tipoCambio));
        			
        		}
     			 $("#fMontoPagoSoles").val(dosDecimales(montoPagoD*tipoCambio));
    			 $("#fMontoVuelto").val(dosDecimales($("#fMontoVueltoDolares").val()));
     			 $("#fMontoPago").val(montoPagoD);
     			 $("#vTipoPago").val("$");
     		
			}
		 }
		 if($("#monedaSoles").is(":checked")){// mixto    	
			
			 if(montoPagoS==""){
 				alert("Debe de ingresar monto en Soles");
 			}
 			else{
    			
     			if($("#vTipoCompra").val()=='S/.'){
        			$("#fMontoVueltoSoles").val(dosDecimales(montoPagoS-fCompraTotalR));
        			$("#fMontoVueltoDolares").val(dosDecimales((montoPagoS-fCompraTotalR)/tipoCambio));
        			
        		}
        		else{
        			$("#fMontoVueltoDolares").val(dosDecimales(montoPagoD-fCompraTotalR));
        			$("#fMontoVueltoSoles").val(dosDecimales((montoPagoD-fCompraTotalR)*tipoCambio));
        			
        		}
     			 $("#fMontoPagoDolares").val(dosDecimales(montoPagoS/tipoCambio));
    			 $("#fMontoVuelto").val($("#fMontoVueltoSoles").val());
     			 $("#fMontoPago").val(montoPagoS);
     			 $("#vTipoPago").val("S/.");
 			}
		 }
		
		
	
}
	 
    	 
    
   function fn_listarProducto(){
    	var iclasificacionId = $("#iclasificacionId").val();
    	var iSucursalId= $("#iSucursalId").val();
    	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&iSucursalId='+iSucursalId+'tipo=compras&mode=LPC',750,650);
    }

</script>