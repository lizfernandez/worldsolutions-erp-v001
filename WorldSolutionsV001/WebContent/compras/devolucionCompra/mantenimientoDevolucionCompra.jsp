
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="ingresoProducto" styleId="formIngresoProducto" >
<table width="1296" height="439" border="1" cellpadding="0" cellspacing="0" class="tabla" id="tabla">
    <tr style="height: 1px;">
      <td>
      
    </td>
  </tr>
  <tr style="height: 1px;">
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr style="height: 1px;">
            <td width="100%">
                <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="tabla">
            <tr>
                <td>FECHA DEVOLUCI&oacute;N:</td>
                <td >
                	<html:text property="dIngresoProductoDevFecha" styleId="dIngresoProductoDevFecha"  size="11%" styleClass="text"/>
                	&ensp;&ensp;&ensp;
                	FECHA COMPRA:
                	<html:text property="dIngresoProductoFecha" styleId="dIngresoProductoFecha"  size="11%" disabled="true" styleClass="text"/>
    		     </td>
              <td>NRO. DOCUMENTO:</td>
                <td>
                  <html:text property="nIngresoProductoNumero" styleId="nIngresoProductoNumero" size="24%" styleClass="text" />
                  <button type="button"  id="spanImgNroDoc" class="button" onclick="popupModal('ingresoProducto.do?metodo=listaIngresoproducto&mode=LP',900,350)" >
                       <span  class="imgpopup">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
                   </button>          
                </td>
                  
                </tr>
            <tr>
                <td>PROVEEDOR:</td>
                <td>
              		  <html:text property="cProveedorCodigo"  styleId="cProveedorCodigo"  styleClass="textCodigo" />
	   				  <html:text property="vProveedorRazonSocial"  styleId="vProveedorRazonSocial"  size="32%" styleClass="text"/>
	                
                <td>TIPO DOCUMENTO:</td>
                <td>    
                 <html:select  property="iTipoDocumentoId" styleId="iTipoDocumentoId" styleClass="text" style="width:185px" disabled="true">       
                 <html:options collection="listaTipoDoc" property="iTipoDocumentoGestionId" labelProperty="vTipoDocumentoDescripcion"/>
                </html:select>
                          
				
				</td>
            </tr>
          <tr>
          <td>DIRECCI&Oacute;N :</td>
          <td>
	          <html:text property="vProveedorDireccion" styleId="vProveedorDireccion" size="50%" styleClass="text"/>      
	      </td>
           <td>FORMA DE PAGO :</td>
            <td>
                <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="text" style="width:185px" disabled="true">       
                 <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
                </html:select>
                
            </td>
          </tr>
          <tr>
          <td>R.U.C :</td>
          <td>
              <html:text property="nProveedorNumeroDocumento" styleId="nProveedorNumeroDocumento"  disabled="true" styleClass="text"/></td>
           <td>ESTADO DOCUMENTO:</td>
           <td>
                <html:select  property="vEstadoDocumento" styleId="vEstadoDocumento" styleClass="text" style="width:185px">       
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
        <th align="right">TOTAL</th>
      </tr>
      <logic:notEmpty name="listaIngresoProductoDetalleCompra" >      
      <logic:iterate id="x" name="listaIngresoProductoDetalleCompra" indexId="i">       
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
	               <bean:write name="x" property="iIngresoProductoDetalleCantidad" />
	           </span>
            </td>
            <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            <td><bean:write name="x" property="producto.vProductoCapacidad" /> <bean:write name="x" property="producto.vUnidadMedidaDescripcionC" /> &ensp; </td>
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td  onclick="fn_ingresarPrecio('${i}')" align="right">
                <span id="precio${i}">
	               <bean:write name="x" property="fIngresoProductoDetallePrecio" format="#,##0.00" locale="Localidad" />
	           </span>
                 
            </td>
            <td align="right">  
                   <span class="totalMax${i}">
	                 <bean:write name="x" property="fIngresoProductoDetalleTotal" format="#,##0.00"  locale="Localidad"/>
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
               <td width="27%">&nbsp;</td>  
                <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" >
		            <tr> 
		                <td width="14%" align="right">SUBTOTAL <span class="tipoMoneda"></span>:</td>
		                <td align="right">
		                  <html:text property="fIngresoProductoSubTotal"  styleId="fIngresoProductoSubTotal" styleClass="text inputDisabled textNumero" readonly="true"  />
		                 </td>		                           
		                <td align="right">IGV(<span class="IGVCompra"></span>%)  <span class="tipoMoneda"></span>:</td>
		                <td align="right">
		                 <html:text property="fIngresoProductoIGV" styleId="fIngresoProductoIGV"  styleClass="text inputDisabled textNumero" readonly="true"  />
		                 </td>
		                <td align="right">TOTAL <span class="tipoMoneda"></span>:</td>
		                <td align="right">
		                  <html:text property="fIngresoProductoTotal"  styleId="fIngresoProductoTotal" styleClass="text inputDisabled textNumero" readonly="true" />		                
		                  <input type="hidden" id="fIngresoProductoTotalr"  />
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
        <th align="right">TOTAL</th>
      </tr>
      <logic:notEmpty name="listaIngresoProductoDetalle" >      
      <logic:iterate id="x" name="listaIngresoProductoDetalle" indexId="i">
       <logic:equal  name="x"  property="cEstadoCodigo" value="AC">
         <tr id="fila${i}">
          <td id='elim'${i}><img src='${pageContext.request.contextPath}/media/imagenes/delete.png' onclick="fn_eliminar('${i}','2')"  /></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td onclick="fn_ingresarCantidad('${i}')">
	            <span id="cantidad${i}">
	               <bean:write name="x" property="iIngresoProductoDetalleCantidad" />
	           </span>
            </td>
            <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            <td><bean:write name="x" property="producto.vProductoCapacidad" /> <bean:write name="x" property="producto.vUnidadMedidaDescripcionC" /> &ensp; </td>
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td  onclick="fn_ingresarPrecio('${i}')" align="right">
                <span id="precio${i}">
	               <bean:write name="x" property="fIngresoProductoDetallePrecio" format="#,##0.00" locale="Localidad" />
	           </span>
                 
            </td>
            <td align="right">  
                   <span class="total${i}">
	                 <bean:write name="x" property="fIngresoProductoDetalleTotal" format="#,##0.00"  locale="Localidad"/>
	                </span>
	               <span id="total${i}" class="totales">
	                 <bean:write name="x" property="fIngresoProductoDetalleTotal" />
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
               <td width="27%">&nbsp;</td>  
                <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" >
		            <tr> 
		                <td width="14%" align="right">SUBTOTAL <span class="tipoMoneda"></span>:</td>
		                <td align="right">
		                    <input type="text" id="fIngresoProductoDevSubTotalr"  class="text inputDisabled textNumero" readonly="true" />
		                 </td>		                           
		                <td align="right">IGV (<span class="IGVCompra"></span>%)  <span class="tipoMoneda"></span>:</td>
		                <td align="right">
		                 <input type="text" id="fIngresoProductoDevIGVr"  class="text inputDisabled textNumero" readonly="true"  />
		                 </td>
		                <td align="right">TOTAL <span class="tipoMoneda"></span>:</td>
		                <td align="right">
		                  <input type="text" id="fIngresoProductoDevr"  class="text inputDisabled textNumero" readonly="true"   onfocus="fn_calcularGlobal()" />		                
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
				           <button onclick="insertar('tabla')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
				           
				        </td>
				        <td><button onclick="cancelar('');" type="button"  class="button"><span class='cancel'>Cancelar</span></button></td>
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
<html:hidden property="iIngresoProductoDevolucionId" />

<html:hidden property="mode" styleId="mode" />
<html:hidden property="fIngresoProductoDevSubTotal" styleId="fIngresoProductoDevSubTotal"/>
<html:hidden property="fIngresoProductoDevIGV" styleId="fIngresoProductoDevIGV"/>
<html:hidden property="fIngresoProductoDev" styleId="fIngresoProductoDev"/>
<html:hidden property="tipoMoneda" styleId="tipoMoneda" />
<html:hidden property="IGVCompra" styleId="IGVCompra" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduIngresoproductoDevolucion" styleId="metodo" />	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
	document.getElementById('fIngresoProductoDevSubTotalr').value = $("#fIngresoProductoDevSubTotal").val();
    document.getElementById('fIngresoProductoDevIGVr').value = $("#fIngresoProductoDevIGV").val();
    document.getElementById('fIngresoProductoDevr').value = $("#fIngresoProductoDev").val();
    document.getElementById('fIngresoProductoTotalr').value = $("#fIngresoProductoTotal").val();
    
    $(document).find(".text.inputDisabled.textNumero").each(function(key,val){                        
   	 $("#"+this.id).val(formatCurrency($("#"+this.id).val(),''));   
});
  //  $(".text.inputDisabled.textNumero").val(formatCurrency($(".text.inputDisabled.textNumero").val(),''));

    $("#dIngresoProductoDevFecha").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    })
	$(".textGrande, .textExtraGrande, .textCodigo").attr("disabled",true);
	$(".tipoMoneda").text($("#tipoMoneda").val());
    $(".IGVCompra").text($("#IGVCompra").val());
    if(mode=='I') {
        //document.getElementById('vIngresoProductoCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DEVOLUCION DE COMPRAS');	
        
      
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');	
        $("#spanImgNroDoc").hide();
      
    }

    
    function fn_eliminar(key,opc){
    	var cad = "ingresoProducto.do?metodo=detalleIngresoProducto&id="+key+"&mode=D";        
        $.getJSON(cad, function retorna(obj){
        listar_detalleCompraDevolucion(obj,'hijo');
       	 fn_calcularGlobal();
       	 });
        /**se elimina el detalle de la devolucion**/
        if(opc=='2')
        	 $("#check"+key).attr("checked", false);       
      
    }
    
    function fn_ingresarCantidad(fila) {
        var capa = 'cantidad'+fila;
        var cantidad = document.getElementById(capa).textContent;
        document.getElementById(capa).innerHTML = "<input type='text' id='numero' onBlur='fn_calcularTotal("+fila+")'  />";
        document.getElementById('numero').value = cantidad;
        document.getElementById('numero').focus();
    }
    
  function fn_calcularTotal(fila) {
        var capa = 'cantidad'+fila;
        var capaPrecio = 'precio'+fila;
        var total = 'total'+fila;
        var precio =   ($.trim($("#precio").val())=="")?$.trim($("#"+capaPrecio).text()):$.trim($("#precio").val());
        var cantidad = ($.trim($("#numero").val())=="")?$.trim($("#"+capa).text()):$.trim($("#numero").val());
       	
     if(parseInt(cantidad)>parseInt($("#cantidadMax"+fila).text())){
    	 alert("La cantidad ingresada debe ser menor o igual que "+$("#cantidadMax"+fila).text());
    	 cantidad = $.trim($("#cantidadMax"+fila).text()); 
     }
        var precioTotal = parseFloat(cantidad) * parseFloat(precio);
        document.getElementById(capa).innerHTML = cantidad;       
        document.getElementById(capaPrecio).innerHTML = precio; 
    	document.getElementById(total).innerHTML = precioTotal;   
    	 $("."+total).text( formatCurrency(precioTotal,''));
    
        var cad = "ingresoProducto.do?metodo=detalleIngresoProducto&id="+fila+"&mode=U&cantidad="+cantidad+"&precio="+precio;
        
        $.getJSON(cad, function retorna(obj){
       	      // 	 listar_detalleIngresoProducto(obj,'hijo');
        	fn_calcularGlobal();
        	
         });
       
   	
       
       
    }

    function fn_calcularGlobal(){    	
        var total = 0;    
       
          $(document).find(".totales").each(function(key,val){                        
            	 total = parseFloat(total) +parseFloat($.trim($("#"+this.id).text()));   
         });
          
        if(parseFloat(total)<parseFloat($("#fIngresoProductoTotalr").val()))
      	   $("#vEstadoDocumento").val("DEVOLUCION PARCIAL");
        else
          	 $("#vEstadoDocumento").val("DEVOLUCION TOTAL");
        
        
         
        if($("#IGVCompra").val()!='0.00'){
        	var igvCompra =(document.getElementById('IGVCompra').value)/100;        	
          
            
            document.getElementById('fIngresoProductoDevSubTotalr').value =formatCurrency(Math.round(total/(1+igvCompra)*100)/100,'');
            document.getElementById('fIngresoProductoDevIGVr').value =formatCurrency( Math.round(total/(1+igvCompra)*(igvCompra)*100)/100,'');
            document.getElementById('fIngresoProductoDevr').value =total;
            
            document.getElementById('fIngresoProductoDevSubTotal').value =(Math.round(total/(1+igvCompra)*100)/100);
            document.getElementById('fIngresoProductoDevIGV').value =( Math.round(total/(1+igvCompra)*(igvCompra)*100)/100);
            document.getElementById('fIngresoProductoDev').value =total;
            
            
        
           
        } 
        
        
    }
   function fn_listarProducto(){
    	var iclasificacionId = $("#iclasificacionId").val();
    	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&mode=LPC',750,350);
    }

</script>