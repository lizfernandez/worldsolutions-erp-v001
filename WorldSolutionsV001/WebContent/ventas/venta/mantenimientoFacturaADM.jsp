
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formVenta" enctype="echarset=utf-8">
<table border="1" cellpadding="0" cellspacing="0" class="tabla" id="tabla" style="width: 64%; float: left;">
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
                	<html:text property="dVentaFecha" styleId="dVentaFecha" styleClass="text textCodigo" readonly="true" />
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
	   				  <button type="button"  class="button" onclick="popupModal('cliente.do?metodo=listaCliente&mode=LP',580,350)" ><span class='imgpopup'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></button>
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
              <html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  styleClass="text textCodigo inputDisabled" readonly="true" />
           CLASIF:   
           <html:text property="vClasificacion" styleId="vClasificacion"  styleClass="text textCodigo inputDisabled" readonly="true" />
          %DESC:
           <html:text property="fDescuentoCliente" styleId="fDescuentoCliente"  styleClass="text inputDisabled" readonly="true" size="6" />
          </td>
          
           <td width="5%">ORDEN DE COMPRA :</td>
           <td width="14%">
              <html:text property="cVentaOrdenCompra"  styleId="cVentaOrdenCompra" styleClass="textN" />
           </td>
          </tr>
          <tr>
           <td width="5%">PUNTO DE LLEGADA :</td>
          <td colspan="3"  width="16%">
             <html:text property="vVentaPuntoLlegada" styleId="vVentaPuntoLlegada"   size="60%"  styleClass="textExtraGrande inputDisabled"/>
          </td>
           
                <td width="13%">VENDEDOR:</td>
                <td><html:text property="vPersonalNombres" styleId="vPersonalNombres" styleClass="textExtraGrande" readonly="true" /></td>
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
          <td><img  src="${pageContext.request.contextPath}/media/imagenes/delete.png" onclick="fn_eliminar('${i}')" class="imgDelete" /></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td>	           
	           <input type="text" class="inputderecha" id="numero${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="iVentaDetalleCantidad" />"/>
	           <input type='hidden' size='10' class='inputderecha' id='numeroReal${i}'  value='<bean:write name="x" property="producto.iProductoStockTotal" />'/>
            </td>
            <logic:notEqual name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion"  value="">
                <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            </logic:notEqual>
            <logic:equal name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion"  value="">
                <td><bean:write name="x" property="personal.vPersonalNombres" />&emsp;  <bean:write name="x" property="personal.vPersonalApellidoPaterno" /></td>
            </logic:equal>
            
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
 <tr style="height: 1px;">  
    <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
               <td width="60%">
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
<table border="1" cellpadding="0" cellspacing="0" class="tabla" id="tabla" style="width: 36%; float: right;">
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
		                  <input type="text" id="fVentaTotalRealR"  class="text inputDisabled textNumero" readonly="true"  size="10" />		                  
		                </td>
		            </tr>
		             <tr>
		                
		                <td align="right">Desc. Producto:</td>
		                <td align="right">
		                <span class="tipoMoneda"></span>
		                   <input type="text" id="fDescuentoR" class="text  textNumero" onblur="fn_descuentoProducto()"  size="10"/>	                 
		                 </td>
		             </tr>
		             <tr>
		                
		                <td align="right">Desc. Cliente:</td>
		                <td align="right">
		                <span class="tipoMoneda"></span>
		                   <input type="text" id="fDescClienteVentaR" class="text  textNumero" onblur="fn_descuentoCliente()"  size="10"/>	                 
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
		                   <input type="text" id="fVentaSubTotalR"
										class="text inputDisabled textNumero" readonly="true" size="10"/>
									</td>
		            </tr>
		            <tr>		                
		                <td align="right">IGV(<span class="IGVVentas"></span>%):</td>
		                <td align="right"><span class="tipoMoneda"></span>
		                 <input type="text" id="fVentaIGVR"  class="text inputDisabled textNumero" readonly="true"  size="10"/>
		                 </td>
		            </tr>
		            <tr>
		                
		                <td align="right">TOTAL  FINAL:</td>
		                <td align="right"><span class="tipoMoneda"></span>
		                  <input type="text" id="fVentaTotalR"  class="text inputDisabled textNumero" readonly="true" size="10" />
		                  
		                </td>
		            </tr>		           
               </table>
           </td>
           </tr>
           <tr>
	           
           <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" id="detallePago">                
		
		            <tr> 
		                <td align="left" colspan="2">
		                TIPO CAMBIO: <html:text property="fTipoCambio" styleId="fTipoCambio" styleClass="text  textNumero" size="3" onblur="fn_tipoPago()"  /> 
		                  
		                TIPO PAGO:
		                <input type="radio" id="monedaSoles" onclick="fn_tipoPago()"  class="textN"  name="iMoneda" />S/.
		                <input type="radio" id="monedaDolares" onclick="fn_tipoPago()"  class="textN" name="iMoneda" />$.
		                 </td>		              	                
		                 
		            </tr>
		           
		            <tr>		                
		                <td align="right">MONTO PAGO 
		                <html:select  property="iMedioPagoId1" styleId="iMedioPagoId1" styleClass="combo" style="width:110px" onchange="fn_PagoCredito()">        
                 <html:options collection="listamedioPago" property="iMedioPagoId" labelProperty="vNombre"/>
                </html:select>:</td>
		                <td align="right">
		                 S/.
		                 <input type="text" id="fMontoPagoSoles"  class="textN  textNumero" size="7" onblur="fn_tipoPago()" value="0"/>
		                 $.
		                 <input type="text" id="fMontoPagoDolares"  class="textN  textNumero"  size="7" onblur="fn_tipoPago()" value="0"/>
		                 </td>
		            </tr>
		             <tr>		                
		                <td align="right">MONTO PAGO 
		                <html:select  property="iMedioPagoId2" styleId="iMedioPagoId2" styleClass="combo" style="width:110px" onchange="fn_PagoCredito()">        
                 <html:options collection="listamedioPago" property="iMedioPagoId" labelProperty="vNombre"/>
                </html:select>:</td>
		                <td align="right">
		                 S/.
		                 <input type="text" id="fMontoPagoSolesCredito"  class="textN  textNumero" size="7" onblur="fn_tipoPago()" value="0"/>
		                 $.
		                 <input type="text" id="fMontoPagoDolaresCredito"  class="textN  textNumero"  size="7" onblur="fn_tipoPago()" value="0"/>
		                 </td>
		            </tr>
		            <tr>
		                
		                <td align="right">VUELTO:</td>
		                <td align="right">
		                  S/.
		                  <input type="text" id="fMontoVueltoSoles"  class="textN  textNumero" readonly="true" size="7" value="0"/>
		                  $.
		                  <input type="text" id="fMontoVueltoDolares"  class="textN  textNumero" readonly="true" size="7"  value="0"/>
		                  
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
				        <td align="left">
				           <button onclick="fn_imprimir()"  class="button" id="btnImprimir"><span class='savePrint' id="btnGuardar">Imprimir</span></button>
				           
				        </td>
				        <td><button onclick="cancelar('');" class="button" type="button" id="btnCancel"><span class='cancel'>Cancelar</span></button></td>
				    </tr>
				</table>
              </td>
               
        </table>
    </td>    
  </tr>

</table>



<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduVenta" styleId="metodo" />	

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iVentaId" styleId="iVentaId" />
<html:hidden property="identificador" styleId="identificador" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iClienteId" styleId="iClienteId" />
<html:hidden property="vImprimir" styleId="vImprimir" value="NO"/>
<html:hidden property="vTipoImpresion" styleId="vTipoImpresion" value="venta"/>


<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iTipoDocumentoId" styleId="iTipoDocumentoId" />
<html:hidden property="iclasificacionId" styleId="iclasificacionId" />
<html:hidden property="vEstadoDocumento" styleId="vEstadoDocumento" value="CANCELADO"/>
<html:hidden property="fVentaTotalReal" styleId="fVentaTotalReal" />
<html:hidden property="fDescuento" styleId="fDescuento" />
<html:hidden property="fDescClienteVenta" styleId="fDescClienteVenta" />
<html:hidden property="fVentaSubTotal" styleId="fVentaSubTotal" />
<html:hidden property="fVentaIGV" styleId="fVentaIGV" />
<html:hidden property="fVentaTotal" styleId="fVentaTotal" />
<html:hidden property="tipoMoneda" styleId="tipoMoneda" />
<html:hidden property="vTipoPago" styleId="vTipoPago" />
<html:hidden property="vTipoVenta" styleId="vTipoVenta" />
<html:hidden property="IGVVentas" styleId="IGVVentas" />
<html:hidden property="vIncluyeIGV" styleId="vIncluyeIGV" />
<html:hidden property="fMontoVuelto" styleId="fMontoVuelto" />
<html:hidden property="fMontoPago" styleId="fMontoPago" />
<html:hidden property="fMontoPagoCredito" styleId="fMontoPagoCredito" />
<html:hidden property="iSucursalId" styleId="iSucursalId" />


</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    document.getElementById('fVentaSubTotalR').value =formatCurrency($("#fVentaSubTotal").val(),'');
    document.getElementById('fVentaIGVR').value =formatCurrency($("#fVentaIGV").val(),'');
    document.getElementById('fVentaTotalR').value =formatCurrency($("#fVentaTotal").val(),'');
    document.getElementById('fVentaTotalRealR').value =formatCurrency($("#fVentaTotalReal").val(),'');
    document.getElementById('fDescuentoR').value =formatCurrency($("#fDescuento").val(),'');
    document.getElementById('fDescClienteVentaR').value =formatCurrency($("#fDescClienteVenta").val(),'');
    document.getElementById('vTipoVenta').value =$("#tipoMoneda").val();
    
    
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
        document.getElementById('btnGuardar').textContent="Guardar";
        $("#iMedioPagoId2 option[value='2']").attr("selected",true);
      
       // $("#btnImprimir").hide();
        $(".trCodigo").show();
        if($("#tipoMoneda").val()=="S/."){
        	$("#monedaSoles").attr("checked",true);
        	$("#vTipoPago").val('S/.');
        }
        if($("#tipoMoneda").val()=="$"){
        	$("#monedaDolares").attr("checked",true);
        	$("#vTipoPago").val('$');
        }
        $("#popupCabecera").text('INSERTAR VENTAS');	
        
        
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');	
        fn_PagoCredito();
	    var tipoCambio= parseFloat($("#fTipoCambio").val());
        $(".tipoMoneda").text($("#vTipoVenta").val());
	       
	        if($("#vTipoPago").val()=="S/."){
	        	$("#monedaSoles").attr("checked",true);
	        	
	        	$("#fMontoPagoDolares").val(dosDecimales(parseFloat($("#fMontoPago").val())/tipoCambio));
	        	$("#fMontoVueltoDolares").val(dosDecimales(parseFloat($("#fMontoVuelto").val())/tipoCambio));
	        	$("#fMontoPagoSoles").val(dosDecimales(parseFloat($("#fMontoPago").val())));
	        	$("#fMontoPagoSolesCredito").val(dosDecimales(parseFloat($("#fMontoPagoCredito").val())));
	        	$("#fMontoPagoDolaresCredito").val(dosDecimales(parseFloat($("#fMontoPagoCredito").val())/tipoCambio));
	        	$("#fMontoVueltoSoles").val(dosDecimales(parseFloat($("#fMontoVuelto").val())));
    			
	        }
	        if($("#vTipoPago").val()=="$"){
	        	$("#monedaDolares").attr("checked",true);
	        	$("#fMontoPagoDolares").val(dosDecimales(parseFloat($("#fMontoPago").val())));
	        	$("#fMontoVueltoDolares").val(dosDecimales(parseFloat($("#fMontoVuelto").val())));	        
	        	$("#fMontoPagoSoles").val(dosDecimales(parseFloat($("#fMontoPago").val())*tipoCambio));
	        	$("#fMontoVueltoSoles").val(dosDecimales(parseFloat($("#fMontoVuelto").val())*tipoCambio));
	        	$("#fMontoPagoDolaresCredito").val(dosDecimales(parseFloat($("#fMontoPagoCredito").val())));
	        	$("#fMontoPagoSolesCredito").val(dosDecimales(parseFloat($("#fMontoPagoCredito").val())*tipoCambio));
    		
	        }
	        if($("#vIncluyeIGV").val()=="siIgv"){
	        	$("#siIgv").attr("checked",true);
	        }
	        if($("#vIncluyeIGV").val()=="noIgv"){
	        	$("#noIgv").attr("checked",true);
	        }
        if(mode=='F'){
        	$("#popupCabecera").text('BUSCAR DATOS');        	
         	$("#btnGuardar").removeClass('save');
         	$("#btnGuardar").addClass('find');
        	$("#btnGuardar").text('Buscar');
         }
        if(mode=="U"){// visualizar venta
        	$(":input:text").addClass("inputDisabled").attr("disabled",true);        	
            $(".imgpopup, .imgDelete, .imgNew").hide();
            $("#btnImprimir, #btnCancel").removeClass("inputDisabled").attr("disabled",false);
            $("#detallePago :input").removeClass("inputDisabled").attr("disabled",false);
            
            
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
    	var iTipoDocumentoId= $("#iTipoDocumentoId").val();
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
        var precioTotal = parseFloat(cantidad*precioReal);
    
        	
        
      
      	document.getElementById(total).innerHTML = precioTotal;   
    	 $("."+total).text( (precioTotal));
  
        var cad = "venta.do?metodo=detalleVenta&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioVenta="+precio+"&fDescuento="+fDescuento;
        
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
    
    function fn_conIgv(){
    	var igvCompra =($('#IGVVentas').val())/100;
    	var total = parseFloat($('#fVentaTotal').val());
    	var totalReal = parseFloat($('#fVentaTotalReal').val());
    	var totalDescuento = parseFloat($('#fDescuento').val());
    	var fDescClienteVenta = parseFloat($('#fDescClienteVenta').val());
    	if($("#noIgv").is(":checked")){  
         	total = parseFloat(total)+parseFloat(total*igvCompra);
         	$("#vIncluyeIGV").val('noIgv');
         }
         else{
         	total = totalReal-totalDescuento-fDescClienteVenta;
         	$("#vIncluyeIGV").val('siIgv');
         }
    	 document.getElementById('fVentaTotal').value =(total);
    	 fn_calcularGlobal();
    }
    function fn_tipoPago(){
    	    var fVentaTotalR = parseFloat($("#fVentaTotal").val());
    	    var tipoCambio=parseFloat($("#fTipoCambio").val());  
    	    var montoPagoS=$("#fMontoPagoSoles").val()==""?0:parseFloat($("#fMontoPagoSoles").val());
    	    var montoPagoD=$("#fMontoPagoDolares").val()==""?0:parseFloat($("#fMontoPagoDolares").val());
    	    var montoPagoSCredito=$("#fMontoPagoSolesCredito").val()==""?0:parseFloat($("#fMontoPagoSolesCredito").val());
    	    var montoPagoDCredito=$("#fMontoPagoDolaresCredito").val()==""?0:parseFloat($("#fMontoPagoDolaresCredito").val());
    	    
    	   
    	    
    		 if($("#monedaDolares").is(":checked")){// mixto 
    			if(montoPagoD==""){
    				alert("Debe de ingresar monto en dolares");
    			}
    			else{
	    			 	     			 
	     			if($("#vTipoVenta").val()=='S/.'){
	        			$("#fMontoVueltoSoles").val(dosDecimales((montoPagoS+montoPagoSCredito)-fVentaTotalR));
	        			$("#fMontoVueltoDolares").val(dosDecimales(((montoPagoS+montoPagoSCredito)-fVentaTotalR)/tipoCambio));
	        			
	        		}
	        		else{
	        			$("#fMontoVueltoDolares").val(dosDecimales((montoPagoD+montoPagoDCredito)-fVentaTotalR));
	        			$("#fMontoVueltoSoles").val(dosDecimales(((montoPagoD+montoPagoDCredito-fVentaTotalR))*tipoCambio));
	        			
	        		}
	     			 $("#fMontoPagoSoles").val(dosDecimales((montoPagoD)*tipoCambio));
	     			 $("#fMontoPagoSolesCredito").val(dosDecimales((montoPagoDCredito)*tipoCambio));
	    			 $("#fMontoVuelto").val(dosDecimales($("#fMontoVueltoDolares").val()));
	     			 $("#fMontoPago").val(montoPagoD);
	     			 $("#fMontoPagoCredito").val(montoPagoDCredito);
	     			 $("#vTipoPago").val("$");
    			}
    		 }
    		 if($("#monedaSoles").is(":checked")){// mixto    	
    			
    			 if(montoPagoS=="" ){
     				alert("Debe de ingresar monto en Soles" +montoPagoSCredito +" montoPagoS=" +montoPagoS);
     			}
     			else{
	    			if($("#vTipoVenta").val()=='S/.'){
	        			$("#fMontoVueltoSoles").val(dosDecimales((montoPagoS+montoPagoSCredito)-fVentaTotalR));
	        			$("#fMontoVueltoDolares").val(dosDecimales(((montoPagoS+montoPagoSCredito)-fVentaTotalR)/tipoCambio));
	        			
	        			
	        		}
	        		else{
	        			$("#fMontoVueltoDolares").val(dosDecimales((montoPagoD+montoPagoDCredito)-fVentaTotalR));
	        			$("#fMontoVueltoSoles").val(dosDecimales((montoPagoD+montoPagoDCredito-fVentaTotalR)*tipoCambio));
	        			
	        		}
	    			 $("#fMontoPagoDolares").val(dosDecimales((montoPagoS)/tipoCambio));
	    			 $("#fMontoPagoDolaresCredito").val(dosDecimales((montoPagoSCredito)/tipoCambio));
	    			 
	    			 $("#fMontoVuelto").val($("#fMontoVueltoSoles").val());
	     			 $("#fMontoPago").val(montoPagoS);
	     			$("#fMontoPagoCredito").val(montoPagoSCredito);
	     			 $("#vTipoPago").val("S/.");
	     			
     			}
    		 }
    		
    		
    	
    }
   
    function fn_calcularTotales(){
	   	 $("#siIgv").attr("checked",true);
	   	 $("#vIncluyeIGV").val('siIgv');
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
    	 document.getElementById('fDescuento').value=sumaDescuento;
    	 document.getElementById('fDescClienteVenta').value=(sumaTotalReal-sumaDescuento)*(parseFloat($("#fDescuentoCliente").val())/100);
    	 document.getElementById('fVentaTotal').value=sumaTotal-$("#fDescClienteVenta").val();
    	
    		 
        fn_calcularGlobal();
    }
    function fn_calcularGlobal(){
    	var sumaTotalReal= document.getElementById('fVentaTotalReal').value;
    	var sumaTotal=document.getElementById('fVentaTotal').value;
    	var sumaDescuento=document.getElementById('fDescuento').value;
    	var sumaDescuentoCliente=document.getElementById('fDescClienteVenta').value;  

        
        var igvCompra =(document.getElementById('IGVVentas').value)/100;
        document.getElementById('fVentaSubTotalR').value =formatCurrency(Math.round(sumaTotal/(1+igvCompra)*100)/100,'');
        document.getElementById('fVentaIGVR').value =formatCurrency( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100,'');
        document.getElementById('fVentaTotalR').value =formatCurrency(sumaTotal,'');
        document.getElementById('fVentaTotalRealR').value =formatCurrency(sumaTotalReal,'');
        document.getElementById('fDescuentoR').value =formatCurrency(sumaDescuento,'');
        document.getElementById('fDescClienteVentaR').value =formatCurrency(sumaDescuentoCliente,'');
        
        document.getElementById('fVentaSubTotal').value =(Math.round(sumaTotal/(1+igvCompra)*100)/100);
        document.getElementById('fVentaIGV').value =( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100);
        document.getElementById('fVentaTotal').value =(sumaTotal);
        document.getElementById('fVentaTotalReal').value =(sumaTotalReal);
        document.getElementById('fDescuento').value =(sumaDescuento);
        
       
        
        
    }
    function fn_listarProducto(){
    	var iclasificacionId = $("#iclasificacionId").val();
    	var identificador = $("#identificador").val();
    	var iSucursalId = $("#iSucursalId").val();
    //	(Math.random() * 10.0);
    	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&tipo=ventas&mode=LP&identificador='+identificador+"&iSucursalId="+iSucursalId,750,560);
    	
    }
    
    function fn_imprimir(){
    	$("#vImprimir").val("SI");
    	insertar('tabla');
    	//alert("d");
    	/*
    	var id= $("#iVentaId").val();
        var tipoImpresion="venta";
    	var cad="venta.do?metodo=imprimir&id="+id+"&tipoImpresion="+tipoImpresion;
    	 
    	 $.ajax({
             type: "GET",
             url: cad,
             data: "",
             success: function(obj){   
           	  alert("OPERACION CON EXITO"); 
             }
         });
    	/*

        $.ajax({
            type: "GET",
            url: "perfil.do?metodo=iduPerfil",
            data: "",
            success: function(obj){   
          	  alert("OPERACION CON EXITO"); 
            }
        }); 
    	*/
    }

</script>