
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="venta" styleId="formVenta">
<table width="1296" height="439" border="1" cellpadding="0" cellspacing="0" class="tabla" id="tabla">
     <tr style="height: 1px;">
      <td>
      <table width="100%" height="139" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="50%" height="0px"><img src="${pageContext.request.contextPath}/media/imagenes/MACROQUIMICA.png"/></td>
        <td width="50%" rowspan="2">
        <table width="100%" border="1" cellspacing="0" cellpadding="0" class="numeroBoleta">
            <tr>
              <td>R.U.C. 20509883921</td>
          </tr>
          <tr>
            <td style="border-bottom:2px solid #666; border-top: 2px solid #666; background-color: #E6E6E6">BOLETA DE VENTAS</td>
          </tr>
          <tr>
              <td  rowspan="2">001 - N�<html:text property="nVentaNumero"  styleId="nVentaNumero" maxlength="10" styleClass="text " /> </td>
          </tr>
        </table></td>
      </tr>
      <tr style="height: 1px;">
          <td>
          <table width="99%" border="1" cellspacing="0" cellpadding="0" id="empresa">
          <tr style="text-align: center">
            <td colspan="2">Jr. Meliton Carbajal N 531 - Urb. Ingenieria - S.M.P.</td>
          </tr>
          <tr style="text-align: center">
            <td colspan="2">Av. Puentre Piedra Mz, N Lt.5 - Puente Piedra</td>
          </tr>
          <tr style="text-align: center">
             <td colspan="2">381-6724 / 9817-5298 / 9817-5547 </td>
          </tr>
        </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr style="height: 1px;">
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr style="height: 1px;">
            <td width="50%"><table width="99%" border="0" cellspacing="0" cellpadding="0" class="cabecera">
          <tr>
            <td>Se�or(es) :</td>
            <td>
                  <html:text property="vClienteCodigo"  styleId="vClienteCodigo" maxlength="5" styleClass="textCodigo inputDisabled" />
	   			  <html:text property="vClienteRazonSocial"  styleId="vClienteRazonSocial"  styleClass="text textGrande inputDisabled" size="55%"/>
	              <span  onclick="popupModal('cliente.do?metodo=listaCliente&mode=LP',580,250)" class="imgpopup"/>
	              <span id="m_vClienteRazonSocial" class="importante">*</span>
	                  
	          
            </td>
          </tr>
          <tr>
            <td>Direccion :</td>
            <td>                     
	             <html:text property="vVentaPuntoLlegada" styleId="vVentaPuntoLlegada"  tabindex="1" size="67%"  styleClass="textExtraGrande inputDisabled" readonly="true" />
	            <span id="imgDireccion" onclick="cargar_direcciones();" class="imgpopup"/>
             </td>
          </tr>
        </table></td>
        <td width="50%">
          <table width="100%" border="1" cellspacing="0" cellpadding="0" class="cabecera">
          <tr>
            <td>Fecha :</td>
            <td ><html:text property="dVentaFecha" styleId="dVentaFecha" styleClass="text" readonly="true" tabindex="1"/></td>
            <td colspan="2">&nbsp;</td>
            
          </tr>
          <tr>
            <td>D.N.I :</td>
            <td><html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento" styleClass="text inputDisabled" /> </td>
             <td >FORMA DE PAGO :</td>
            <td  width="30%">
                <html:select  property="iFormaPago" styleId="iFormaPago" styleClass="combo">       
                 <html:options collection="listaFormapago" property="iFormaPago" labelProperty="vFormaPagoDescripcion"/>
                </html:select>
                <span id="m_iFormaPago" class="importante">*</span>
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
        <th width="12%">CAPACIDAD</th>
        <th>DESCRIPCI&Oacute;N</th>
        <!--th>C.Compra</th>
        <th>Ganancia(%)</th-->
        <th align="right">P.U.</th>
        <th align="right">TOTAL</th>
      </tr>
      <logic:notEmpty name="listaVentaDetalle" >      
      <logic:iterate id="x" name="listaVentaDetalle" indexId="i">
       <logic:equal  name="x"  property="cEstadoCodigo" value="AC">
         <tr id="fila${i}">
          <td><img src="${pageContext.request.contextPath}/media/imagenes/delete.png" onclick="fn_eliminar('${i}')" /></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td onclick="fn_ingresarCantidad('${i}','<bean:write name="x" property="producto.iProductoStockCantidad" />')">
	            <span id="cantidad${i}">
	               <bean:write name="x" property="iVentaDetalleCantidad" />
	           </span>
            </td>
            <td><bean:write name="x" property="producto.unidadMedida.vUnidadMedidaDescripcion" /></td>
            <td><bean:write name="x" property="producto.vProductoCapacidad" /> <bean:write name="x" property="producto.vUnidadMedidaDescripcionC" /></td>
            <td><bean:write name="x" property="producto.vProductoNombre" /></td>
            <td id="precio${i}" align="right"><bean:write name="x" property="producto.fProductoPrecioVenta" format="#,##0.00" locale="Localidad" /></td>
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
      <tr>
        <td><img src="${pageContext.request.contextPath}/media/imagenes/new.png" onclick="popupModal('productos.do?metodo=listaProducto&mode=LP',580,250)" /></td>
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
               <td width="80%">&nbsp;</td>  
                <td>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" >
		           <tr>
		                
		                <td align="right">TOTAL BRUTO:</td>
		                <td align="right">
		                  <input type="text" id="fVentaTotalR"  class="text inputDisabled textNumero" readonly="true"   onfocus="fn_calcularGlobal()" />
		                  <span id="m_fVentaTotalR" class="importante">*</span>
		                </td>
		            </tr>
		            <tr class="textInvisible">
		                <td width="50%" align="right">SUBTOTAL:</td>
		                <td align="right">
		                   <input type="text" id="fVentaSubTotalR"  class="textInvisible" readonly="true" />
		                 </td>
		            </tr>
		            <tr class="textInvisible">
		                
		                <td align="right">IGV(18%)</td>
		                <td align="right">
		                 <input type="text" id="fVentaIGVR"  class="textInvisible" readonly="true"  />
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
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iVentaId" />

 <html:text property="vClienteDireccion" styleId="vClienteDireccion" styleClass="textInvisible"/>
  

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iClienteId" styleId="iClienteId" />

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iTipoDocumentoId" styleId="iTipoDocumentoId" />

<html:hidden property="fVentaSubTotal" styleId="fVentaSubTotal" />
<html:hidden property="fVentaIGV" styleId="fVentaIGV" />
<html:hidden property="fVentaTotal" styleId="fVentaTotal" />



<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduVenta" styleId="metodo" />	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    $(".textInvisible").attr('disabled',true);
   
    document.getElementById('fVentaSubTotalR').value =formatCurrency($("#fVentaSubTotal").val(),'');
    document.getElementById('fVentaIGVR').value =formatCurrency($("#fVentaIGV").val(),'');
    document.getElementById('fVentaTotalR').value =formatCurrency($("#fVentaTotal").val(),'');
    
    
    if(mode=='I') {
        //document.getElementById('vVentaCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR VENTAS');	
        
        $(".combo.Departamento option[value='140000']").attr("selected",true);
        $(".combo.Provincia option[value='140500']").attr("selected",true);
        $(".combo.Distrito option[value='140501']").attr("selected",true);
       
    } else {
         document.getElementById('btnGuardar').textContent="Actualizar";
        $("#popupCabecera").text('ACTUALIZAR DATOS');	
        
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

    
    function fn_eliminar(key){
    	var suma = 0, total = 0;
        var cad = "venta.do?metodo=detalleVenta&id="+key+"&mode=D";
        
        $.getJSON(cad, function retorna(obj){
       	// alert("obje"+obj.cProductoCodigo);
       	 listar_detalleVenta(obj,'hijo');
       	 });
        $(document).find(".totales").each(function(key,val){
            if($("#"+this.id)){
            	//alert($.trim($("#"+this.id).text()));
             		suma = parseFloat(suma) +parseFloat($.trim($("#"+this.id).text()));/*numero*/	
               }
        });
        //alert("suma ="+suma +" resta ="+$("#total"+key).text())       ; 
        document.getElementById('fVentaTotal').value = parseFloat(suma) - parseFloat($.trim($("#total"+key).text())); 
        fn_calcularGlobal();
       
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
    function fn_ingresarCantidad(fila, cantidadStock) {
        var capa = 'cantidad'+fila;
        var cantidad = document.getElementById(capa).textContent;
        document.getElementById(capa).innerHTML = "<input type='text' id='numero' onBlur='fn_calcularTotal("+fila+","+cantidadStock+")'  />";
        document.getElementById('numero').value = cantidad;
        document.getElementById('numero').focus();
    }
    function fn_calcularTotal(fila,cantidadStock) {
        var suma = 0;
        var capa = 'cantidad'+fila;
        var total = 'total'+fila;
        var precio =  document.getElementById('precio'+fila).textContent;
        var cantidad = $.trim($("#numero").val());
       	 
    	 /*var stock = data.stock;
         var cad = 'La cantidad ingresada es mayor o igual al stock\nLo maximo a solicitar es: '+data.cantidad;
         if(stock=='0') alert(cad);
        */
        if(cantidad>cantidadStock){
        	var cad = 'La cantidad ingresada es mayor al stock\nLo maximo a solicitar es: '+cantidadStock;
        	alert(cad);
        	$("#cantidad"+fila).text(cantidadStock);
        	cantidad=cantidadStock;
        	
        }
        
        var precioTotal = parseFloat(cantidad) * parseFloat(precio);
        document.getElementById(capa).innerHTML = cantidad;        	
    	document.getElementById(total).innerHTML = precioTotal;   
    	 $("."+total).text( formatCurrency(precioTotal,''));
    
         $(document).find(".totales").each(function(key,val){
             if($("#"+this.id)){
              	if(key== fila){
              		suma = parseFloat(precioTotal)+ parseFloat(suma);/*numero*/
              	}
              	else{
              		suma = parseFloat(suma) +parseFloat($.trim($("#"+this.id).text()));/*numero*/	
              	}
             	
             	//($("#"+this.id).text());
             }
         });         
         document.getElementById('fVentaTotal').value = suma;
        var cad = "venta.do?metodo=detalleVenta&id="+fila+"&mode=U&cantidad="+cantidad;
        
        $.getJSON(cad, function retorna(obj){
       	      // 	 listar_detalleVenta(obj,'hijo');
        	
         });
       
   	
       fn_calcularGlobal();
       
    }

    function fn_calcularGlobal(){
    	
        var total = 0;    
       
        total = document.getElementById('fVentaTotal').value;
       /* document.getElementById('fVentaSubTotalR').value =formatCurrency(Math.round(total/1.18*100)/100,'');
        document.getElementById('fVentaIGVR').value =formatCurrency( Math.round(total/1.18*0.18*100)/100,'');
       
        
        document.getElementById('fVentaSubTotal').value =(Math.round(total/1.18*100)/100);
        document.getElementById('fVentaIGV').value =( Math.round(total/1.18*0.18*100)/100);*/
        document.getElementById('fVentaTotalR').value =formatCurrency(total,'');
        document.getElementById('fVentaTotal').value =(total);
        
        
    }

</script>