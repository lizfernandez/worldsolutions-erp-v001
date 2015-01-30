
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formVenta">
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
                <td>FECHA DEVOLUCI&Oacute;N:</td>
                <td >
                	<html:text property="dVentaDevFecha" styleId="dVentaDevFecha"  size="11%" styleClass="text"/>
                	&ensp;&ensp;&ensp;
                	FECHA VENTA:
                	<html:text property="dVentaFecha" styleId="dVentaFecha"  size="11%" disabled="true" styleClass="text"/>
    		     </td>
              <td>NRO. DOCUMENTO:</td>
                <td>
                  <html:text property="nVentaNumero" styleId="nVentaNumero" size="20%" styleClass="text" />
                 <button id="spanImgNroDoc" class="button"  type="button" onclick="popupModal('venta.do?metodo=listaVenta&mode=LP',950,350)"  >                  
                       <span  class="imgpopup">&nbsp;&nbsp;&nbsp;&nbsp;</span> 
                   </button>          
                </td>
                  
                </tr>
            <tr>
                <td>CLIENTE:</td>
                <td>
              		  <html:text property="vClienteCodigo"  styleId="vClienteCodigo"  styleClass="textCodigo" />
	   				  <html:text property="vClienteRazonSocial"  styleId="vClienteRazonSocial"  size="38%" styleClass="text"/>
	                
                <td>TIPO DOCUMENTO:</td>
                <td>    
                 <html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="combo" style="width:160px">       
                 <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
                </html:select>
                          
				
				</td>
            </tr>
          <tr>
          <td>DIRECCI&Oacute;N :</td>
          <td>
	          <html:text property="vClienteDireccion" styleId="vClienteDireccion" size="56%" styleClass="text"/>      
	      </td>
           <td>FORMA DE PAGO :</td>
            <td>
                <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo" style="width:160px">       
                 <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
                </html:select>
                
            </td>
          </tr>
          <tr>
          <td>R.U.C :</td>
          <td>
              <html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  disabled="true" styleClass="text" /></td>
           <td>ESTADO DOCUMENTO:</td>
           <td>
                <html:select  property="vEstadoDocumento" styleId="vEstadoDocumento" styleClass="combo" style="width:160px">       
                 <html:options collection="listaEstadoDocumento" property="vEstadoDescripcion" labelProperty="vEstadoDescripcion"/>
                </html:select>
                
            </td>
          </tr>
    
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr style="height: 1px;">
      <td><table width="100%" border="1" cellspacing="0" cellpadding="0" id="detalle">
      <tr>
        <th width="5%">&nbsp;</th>
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
      <logic:notEmpty name="listaVentaDetalleCompra" >      
      <logic:iterate id="x" name="listaVentaDetalleCompra" indexId="i">       
         <tr id="fila${i}">
         <logic:equal  name="x"  property="cEstadoCodigo" value="IN">
             <td><input type='checkbox' id='check${i}'  onclick="fn_eliminar('${i}','1')"/></td>
         </logic:equal> 
         <logic:equal  name="x"  property="cEstadoCodigo" value="AC">
             <td><input type='checkbox' id='check${i}' checked='checked' onclick="fn_eliminar('${i}','1')"/></td>
         </logic:equal>  
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td>
	            <span id="cantidadMax${i}">
	               <bean:write name="x" property="iVentaDetalleCantidad" />
	           </span>
            </td>
            <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            <td><bean:write name="x" property="producto.vProductoCapacidad" /> <bean:write name="x" property="producto.vUnidadMedidaDescripcionC" /> &ensp; </td>
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td align="right">
                <span id="precio${i}">
	               <bean:write name="x" property="fVentaDetallePrecio" format="#,##0.00" locale="Localidad" />
	           </span>
                 
            </td>
            <td align="right">
                <span id="descuento${i}">
	               <bean:write name="x" property="fDescuento" format="#,##0.00" locale="Localidad" />
	           </span>
                 
            </td>
            <td align="right">  
                   <span class="totalMax${i}">
	                 <bean:write name="x" property="fVentaDetalleTotal" format="#,##0.00"  locale="Localidad"/>
	                </span>
	                        
              </td>
        </tr> 
          
      </logic:iterate>      
    </logic:notEmpty>      
      <tr>
        <td colspan="7" id="iProductos"> <span id="m_iProductos" class="importante">Ingrese Productos</span></td>

      </tr>     
    </table></td>
  </tr>
 <tr style="height: 1px;">  
    <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
               <td width="84%">&nbsp;</td>  
                <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" >
		            <tr> 
		                <td width="50%" align="right">SUBTOTAL<span class="tipoMoneda">:</td>
		                <td align="right">
		                  <html:text property="fVentaSubTotal"  styleId="fVentaSubTotal" styleClass="text inputDisabled textNumero" readonly="true"  />
		                 </td>		                           
		                <td align="right">IGV(<span class="IGVVentas"></span>%)<span class="tipoMoneda">:</td>
		                <td align="right">
		                 <html:text property="fVentaIGV" styleId="fVentaIGV"  styleClass="text inputDisabled textNumero" readonly="true"  />
		                 </td>
		                <td align="right">TOTAL<span class="tipoMoneda">:</td>
		                <td align="right">
		                  <html:text property="fVentaTotal"  styleId="fVentaTotal" styleClass="text inputDisabled textNumero" readonly="true" />		                
		                  <input type="hidden" id="fVentaTotalr"  />
		                </td>
		            </tr>

               </table>
              </td>
               
        </table>
    </td>    
  </tr>  
 <tr style="height: 1px;"> 
 <th align="center">PRODUCTOS A DEVOLVER</th>
  </tr>
 <tr style="height: 1px;">
      <td><table width="100%" border="1" cellspacing="0" cellpadding="0" id="detalleDevolucion">
      <tr>
        <th width="5%">&nbsp;</th>
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
          <td id='elim'${i}><img src='${pageContext.request.contextPath}/media/imagenes/delete.png' onclick="fn_eliminar('${i}','2')"  /></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td>
               <input id="numero${i}"  class='inputderecha'  onblur="fn_calcularTotal('${i}')" type="text" value="<bean:write name="x" property="iVentaDetalleCantidad" />"/> 
	            
            </td>
            <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            <td><bean:write name="x" property="producto.vProductoCapacidad" /> <bean:write name="x" property="producto.vUnidadMedidaDescripcionC" /> &ensp; </td>
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td align="right">
                <span id="precio${i}">
	               <bean:write name="x" property="fVentaDetallePrecio" format="#,##0.00" locale="Localidad" />
	           </span>
                 
            </td>
            <td align="right">
                <span id="descuento${i}">
	               <bean:write name="x" property="fDescuento" format="#,##0.00" locale="Localidad" />
	           </span>
                 
            </td>
            <td align="right">  
                   <span class="total${i}">
	                 <bean:write name="x" property="fVentaDetalleTotal" format="#,##0.00"  locale="Localidad"/>
	                </span>
	               <span id="total${i}" class="totales">
	                 <bean:write name="x" property="fVentaDetalleTotal" />
	               </span>          
              </td>
        </tr> 
        </logic:equal>        
      </logic:iterate>      
    </logic:notEmpty>       
    </table></td>
  </tr> 
  <tr style="height: 1px;">  
    <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
               <td width="84%">&nbsp;</td>  
                <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" >
		            <tr> 
		                <td width="50%" align="right">SUBTOTAL<span class="tipoMoneda">:</td>
		                <td align="right">
		                    <input type="text" id="fVentaDevSubTotalr"  class="text inputDisabled textNumero" readonly="true" />
		                 </td>		                           
		                <td align="right">IGV(<span class="IGVVentas"></span>%)<span class="tipoMoneda"></td>
		                <td align="right">
		                 <input type="text" id="fVentaDevIGVr"  class="text inputDisabled textNumero" readonly="true"  />
		                 </td>
		                <td align="right">TOTAL <span class="tipoMoneda">:</td>
		                <td align="right">
		                  <input type="text" id="fVentaDevr"  class="text inputDisabled textNumero" readonly="true"   onfocus="fn_calcularGlobal()" />		                
		                </td>
		            </tr>
		            <!--tr><td>GANANCIA:</td>
		                <td><input name="txtGanancia" type="text" id="txtGanancia" size="10" value="<?php echo $this->ganancia?>" onBlur="fn_calcularGananciaGlobal(0)"/></td>
		            </tr>
		            <tr><td>TOTAL NETO:</td>
		                <td><input type="text" name="txtNeto" id="txtNeto" size="10" onBlur="fn_calcularGananciaGlobal(1)" "/></td>
		            </tr-->
               </table>
              </td>
               
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
				           <button onclick="insertar('tabla')" class="button"><span class='save' id="btnGuardar">Guardar</span></button>
				           
				        </td>
				        <td><button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button></td>
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


<%-- hidden field que contiene el mode --%>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iVentaDevolucionId" />

<html:hidden property="mode" styleId="mode" />
<html:hidden property="fVentaDevSubTotal" styleId="fVentaDevSubTotal"/>
<html:hidden property="fVentaDevIGV" styleId="fVentaDevIGV"/>
<html:hidden property="fVentaDev" styleId="fVentaDev"/>
<html:hidden property="tipoMoneda" styleId="tipoMoneda" />
<html:hidden property="IGVVentas" styleId="IGVVentas" />		
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduVentaDevolucion" styleId="metodo" />	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
	document.getElementById('fVentaDevSubTotalr').value = $("#fVentaDevSubTotal").val();
    document.getElementById('fVentaDevIGVr').value = $("#fVentaDevIGV").val();
    document.getElementById('fVentaDevr').value = $("#fVentaDev").val();
    document.getElementById('fVentaTotalr').value = $("#fVentaTotal").val();
    
    $(document).find(".text.inputDisabled.textNumero").each(function(key,val){                        
   	 $("#"+this.id).val(formatCurrency($("#"+this.id).val(),''));   
});
  //  $(".text.inputDisabled.textNumero").val(formatCurrency($(".text.inputDisabled.textNumero").val(),''));

    $("#dVentaDevFecha").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    })
	$(".textGrande, .textExtraGrande, .textCodigo").attr("disabled",true);
    $(".tipoMoneda").text($("#tipoMoneda").val());
    $(".IGVVentas").text($("#IGVVentas").val());
  
    if(mode=='I') {
        //document.getElementById('vVentaCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DEVOLUCION DE COMPRAS');	
        
      
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');	
        $("#spanImgNroDoc").hide();
      
    }

    
    function fn_eliminar(key,opc){
    	var cad = "venta.do?metodo=detalleVenta&id="+key+"&mode=D";        
        $.getJSON(cad, function retorna(obj){
        listar_detalleCompraDevolucion(obj,'hijo');
       	 fn_calcularGlobal();
       	 });
        /**se elimina el detalle de la devolucion**/
        if(opc=='2')
        	 $("#check"+key).attr("checked", false);       
      
    }
    
   
    function fn_calcularTotal(fila) {
        var total = 'total'+fila;
        var precio =  parseFloat($.trim($("#precio"+fila).text()));
        var cantidad = parseFloat($.trim($("#numero"+fila).val()));
        var fDescuento = parseFloat($.trim($("#descuento"+fila).text()));   	
    	 var precioReal = (precio)-(precio*(fDescuento/100));
        var precioTotal = parseFloat(cantidad*precioReal);
        var cantidadStock = parseInt($("#cantidadMax"+fila).text());
       
        if(cantidad>cantidadStock){
        	alert('La cantidad ingresada es mayor al stock\nLo maximo a solicitar es: '+cantidadStock); 
        	cantidad=cantidadStock;
        	
        }
        
      
      	document.getElementById(total).innerHTML = precioTotal;   
    	 $("."+total).text( formatCurrency(precioTotal,''));

        var cad = "venta.do?metodo=detalleVenta&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioVenta="+precio+"&fDescuento="+fDescuento;
        
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
          	  var cantidad =$.trim($("#cantidad"+key).text())==""?0: parseFloat($.trim($("#cantidad"+key).text()));
          	 var descuento = $.trim($("#descuento"+key).val())==""?0:parseFloat($.trim($("#descuento"+key).val()));
          	 var total = $.trim($("#total"+key).text())==""?0:parseFloat($.trim($("#total"+key).text()));
          	 
          	 sumaTotal =sumaTotal+parseFloat(total); 
               sumaTotalReal = sumaTotalReal+(precio*cantidad);
               sumaDescuento = sumaDescuento+(precio*(descuento/100))* cantidad;
        
          }
      	 document.getElementById('fVentaDev').value=sumaTotal;      	
          fn_calcularGlobal();
      }
      function fn_calcularGlobal(){
      	
      	var sumaTotal=document.getElementById('fVentaDev').value;
       	
        var igvCompra =(document.getElementById('IGVVentas').value)/100;
          document.getElementById('fVentaDevSubTotalr').value =formatCurrency(Math.round(sumaTotal/(1+igvCompra)*100)/100,'');
          document.getElementById('fVentaDevIGVr').value =formatCurrency( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100,'');
          document.getElementById('fVentaDevr').value =formatCurrency(sumaTotal,'');
          
          document.getElementById('fVentaDevSubTotal').value =(Math.round(sumaTotal/(1+igvCompra)*100)/100);
          document.getElementById('fVentaDevIGV').value =( Math.round(sumaTotal/(1+igvCompra)*(igvCompra)*100)/100);
          document.getElementById('fVentaDev').value =(sumaTotal);
          
         
          
          
      }
   function fn_listarProducto(){
    	var iclasificacionId = $("#iclasificacionId").val();
    	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&mode=LPC',750,350);
    }

</script>