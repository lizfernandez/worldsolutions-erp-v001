
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script>


    function fn_calcularGanancia(tipo) {
        var compra = parseFloat(($("#fProductoPrecioCompra").val()==null)?0:$("#fProductoPrecioCompra").val());
        var precio = parseFloat(($("#fProductoPrecioVenta").val()==null)?0:$("#fProductoPrecioVenta").val());
        var ganancia = parseFloat(($("#fProductoGanancia").val()==null)?0:$("#fProductoGanancia").val());
        
       
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
            alert('INGRESE PRECIO DE VENTA O GANANCIA');
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
<html:form action="productos" styleId="formProductos" enctype="multipart/form-data" >
<tr><td colspan="4"></td></tr>
<tr><td colspan="4">
<table class="tabla" border="0" width="100%" id="detalleProduccion">
  <caption>Lista de Producto</caption>
    <thead>
    <tr >
        <th align="left"></th>
        <th align="left">CODIGO</th> 
        <th align="left">NOMBRE</th>        
        <th align="left">CANTIDAD</th>
        <th align="left">P.U</th>   
        <th align="left">DESCUENTO</th>       
        <th align="right">COSTO TOTAL</th>
      </tr>
    </thead>
    <tbody>
     <logic:notEmpty name="listaProduccionDetalle" >      
      <logic:iterate id="x" name="listaProduccionDetalle" indexId="i">
       <logic:equal  name="x"  property="cEstadoCodigo" value="AC">
         <tr id="fila${i}">
          <td><img src="${pageContext.request.contextPath}/media/imagenes/delete.png" onclick="fn_eliminar('${i}')" /></td>
            <td><bean:write name="x" property="producto.cProductoCodigo" /></td>
            <td><bean:write name="x" property="vDescripcion" /></td>
            <td>
              <input type="text" class="inputderecha" id="numero${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="iCantidad" />"/>
	          <input type="hidden" class="inputderecha" id="numeroReal${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="producto.iProductoStockCantidad"/>"/>
	        </td>
            <td align="right">
                <input type="text" class="inputderecha" id="precio${i}" onBlur="fn_calcularTotal('${i}')" value="<bean:write name="x" property="fCostoUni" format="#,##0.00" locale="Localidad" />"/>                
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
        <td><img src="${pageContext.request.contextPath}/media/imagenes/new.png" onclick="fn_listarProducto(2,'LPP')" /></td>
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
    </tbody>
</table>    
</td>
</tr>


<tr>
<td colspan="4">
 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabla" >
	
                     <tr>		                
		                <td align="right" width="38%">Cantidad Obtenida: </td>
		                <td align="right">
		                  <input type="text" id="iCantidadR"  class="text  textNumero" value="1" onblur="fn_recarcular()" />
		                  <span id="m_iCantidadR" class="importante">*</span>
		                </td>
		                <td align="right" >Otros Costos </td>
		                <td align="right">
		                 <html:text property="fOtrosCostos" styleId="fOtrosCostos" styleClass="text textNumero"  onblur="fn_recarcular()"/>
		                  
		                  
		                </td>
		            </tr>
   	            <tr>		                
		                <td align="right">Costo Unidad: </td>
		                <td align="right">
		                  <input type="text" id="fCostoUniR"  class="text  textNumero" readonly="true" />
		                  <span id="fCostoUniR" class="importante">*</span>
		                </td>
		                 <td align="right">TOTAL: <span class="tipoMoneda"></span> </td>
		                <td align="right">
		                  <input type="text" id="fCostoTotalR"  class="text inputDisabled textNumero" readonly="true" />
		                  <span id="m_fCostoTotalR" class="importante">*</span>
		                </td>
		            </tr>
		            
</table>
               

</td>
</tr>
        <tr>
		                
             
             <td align="right" colspan="2">
                  Nombre de produccion:
             </td>
             <td align="left" colspan="2" >
             <html:text property="vDescripcion" styleId="vDescripcion" size="32" onkeyup="return mayuscula('vDescripcion') " 
             styleClass="text" /></td>
            
            
         </tr>
        <tr>
		                
             
             <td align="right">
                  <input type="radio" id="pNuevo" name="productos" class="text" onclick="fn_RegProductos(0)" />
             </td>
             <td align="left">Producto Nuevo</td>
             <td align="right">
                  <input type="radio" id="pNuevo"  name="productos" class="text" onclick="fn_RegProductos(1)"/>
             </td>
              <td align="left">Producto Existente</td>
            
         </tr>
         
         <tr id="tr_RegProductos" style="display: none">
             <td id="td_RegProductoNuevo" style="display: none" colspan="4">
             <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabla" id="tablaNuevoProducto" >     
			
					  <tr> <td colspan="4" ><span class="titulosTd"  id="po">Clasificaci&oacute;n:</span></td></tr>
						<tr>
						    <td align="right" width="23%">Categor&iacute;a:</td>
						    <td>
						     <html:select  property="iCategoriaId" styleId="iCategoriaId" styleClass="combo" onchange="listSubCategoria()" tabindex="1" style="width:205px">
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
						        <html:text property="cProductoCodigo" styleId="cProductoCodigo"  size="10" styleClass="textCodigo" maxlength="8"  onkeyup="return mayuscula('cProductoCodigo') " tabindex="3"/>
						        <span id="m_cProductoCodigo" class="importante">*</span>
						        <img id="td_RegProductoExistente"  src="${pageContext.request.contextPath}/media/imagenes/buscar.png" onclick="fn_listarProducto(1,'LPPU')" />
						    </td>
						      
						</tr>
						<tr> 
						    <td align="right" width="25%">Nombre:</td>
						    <td><html:text property="vProductoNombre" styleId="vProductoNombre" size="27" onkeyup="return mayuscula('vProductoNombre') " styleClass="text" tabindex="4"/>
						      <span id="m_vProductoNombre" class="importante">*</span>
						    </td>
						    <td colspan="2"> 
						      <html:file property="foto" styleId="foto" style="width:273px"></html:file>
						      
						    </td>
						</tr>
						<tr>
							 <td colspan="4">
							 <span id ="span1" class="btnOpcionesActivo"  onclick="subMenuOpciones('1')">Datos B&aacute;sicos:</span>
							 
							 <table class="tabla" id="tabla1">	  
								
								<tr>
								    <td align="right" width="20%">Cantidad:</td>
								    <td width="20%">
								    <html:text property="iProductoStockCantidad" styleId="iProductoStockCantidad" maxlength="7"  styleClass="text" tabindex="5" /> 
								    <span id="m_iProductoStockCantidad" class="importante">*</span>  
								    </td>
								    <td>
								      <html:select  property="iUnidadMedidadId" styleId="iUnidadMedidadId" styleClass="comboCodigo" tabindex="6" style="width:140px">
								          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
								     </html:select> 
								    </td>
								</tr>
								<tr>
								     <td align="right">Capacidad:</td>
								    <td><html:text property="vProductoCapacidad" styleId="vProductoCapacidad" maxlength="7"  styleClass="textN"  tabindex="7"/> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
								    </td>
								    <td>  
								       <html:select  property="iUnidadMedidadIdC" styleId="iUnidadMedidadIdC" styleClass="comboCodigo" tabindex="8" style="width:140px">
								          <option value="0">::SELECCIONE::</option> 
								          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
								     </html:select>  
								    </td>
								</tr>
								
								<tr>
								    <td align="right">Precio Compra:</td>
								    <td>
									    <html:text property="fProductoPrecioCompra" styleId="fProductoPrecioCompra" styleClass="text" tabindex="9"/>
									    <span id="m_fProductoPrecioCompra" class="importante">*</span>
									</td>
								      <td>
									     <html:select  property="iMonedaId" styleId="iMonedaId" styleClass="comboCodigo" tabindex="10" style="width:140px">
									          <html:options collection="listaMoneda" property="iMonedaId" labelProperty="vMonedaDescripcion"/>
									     </html:select> 
									     
								     </td>
								</tr>
								<tr>
								    <td align="right">Ganancia:</td>
								    <td>
								       <html:text property="fProductoGanancia"  styleId="fProductoGanancia" styleClass="text" onblur="fn_calcularGanancia('G')" tabindex="11"/>
								       </td>
								       <td>
								        <select class="comboCodigo" disabled="disabled" id="porcent" style="width:140px">
									          <option value=""/> %</option>
									     </select>
								    </td>
								</tr>
								<tr>
								    <td align="right">Precio Venta:</td>
								    <td>
								      <html:text property="fProductoPrecioVenta" styleId="fProductoPrecioVenta" styleClass="text" onblur="fn_calcularGanancia('V')" tabindex="12"/>
								      <span id="m_fProductoPrecioVenta" class="importante">*</span>
								    </td>
								    <td>
								    <html:select  property="iMonedaId" styleId="iMonedaId" styleClass="comboCodigo change" style="width:140px">
									          <html:options collection="listaMoneda" property="iMonedaId" labelProperty="vMonedaDescripcion"/>
									     </html:select>
									     
								      </td>
								</tr>
								<tr>
								    <td align="right">% Descuento:</td>
								    <td colspan="2"><html:text property="fProductoDescuento" styleId="fProductoDescuento" styleClass="text"  tabindex="13"/></td>   <!-- onkeypress="return Numeros(event)" -->
								</tr>
								<!-- tr>
								    <td align="right">Stock Min:</td>
								    <td colspan="2"><html:text property="iProductoStockMinimo" styleId="iProductoStockMinimo" styleClass="text"  tabindex="13"/></td>  
								</tr-->
								<!-- tr>
								    <td align="right">Stock Max:</td>
								    <td colspan="2"><html:text property="iProductoStockMaximo" styleId="iProductoStockMaximo" styleClass="text"  tabindex="14"/></td> 
								</tr-->
								<tr>
								    <td align="right">Estado:</td>
								    <td colspan="2">
								      <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" tabindex="15">       
								       <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
								     </html:select>  
								    </td>
								</tr>
						
							 </table> 
							 </td>
						</tr>
					
             </table>

             </td >
             <td id="td_RegProductoExistente" style="display: none">Producto Nuevo</td>
         </tr>
		            

<tr height="50px">   
    <td align="center" colspan="4">
    <br>    
     <button onclick="insertar('tab-grupo')" class="button">
          <span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
    
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iProductoId" styleId="iProductoId"/>

<html:hidden property="iProduccionId" styleId="iProduccionId"/>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="vUnidadMedidaDescripcionC"  styleId="vUnidadMedidaDescripcionC"/>


<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
<%-- hidden field que contiene el mode --%>
<html:hidden property="fCostoTotal" styleId="fCostoTotal" />
<%-- hidden field que contiene el mode --%>
<html:hidden property="iCantidad" styleId="iCantidad" />
<%-- hidden field que contiene el mode --%>
<html:hidden property="fCostoUni" styleId="fCostoUni" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduProduccion" styleId="metodo"/>




</html:form>
<script>
   
    
   
    var mode = document.getElementById('mode').value;	
    $("#iMonedaId").change(function () {
    	var mival = $("#iMonedaId option:selected").val();
    	$(".comboCodigo.change option[value="+mival+"]").attr("selected",true); 
   });
    if(mode=='I') {
        
        document.getElementById('btnGuardar').textContent="Insertar";
       
        $("#popupCabecera").text('INSERTAR GESTION DE LA PRODUCCION');	
       
    } else {
          document.getElementById('btnGuardar').textContent="Actualizar";
        $("#iCantidadR").val($("#iCantidad").val());
        $("#fCostoUniR").val($("#fCostoUni").val());
        $("#fCostoTotalR").val(parseFloat($("#fCostoTotal").val())+parseFloat($("#fOtrosCostos").val()));
        $("#tr_RegProductos").show();
        $("#td_RegProductoNuevo").show();
        
        
        $("#popupCabecera").text('ACTUALIZAR GESTION DE LA PRODUCCION');		
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
 function fn_listarProducto(iclasificacionId,mode){
	 
 	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&tipo=produccion&mode='+mode,750,400);
 }

 function fn_eliminar(key){
 	var suma = 0, total = 0;
     var cad = "productos.do?metodo=detalleProduccion&id="+key+"&mode=D";
     
     $.getJSON(cad, function retorna(obj){
    	// alert("obje"+obj.cProductoCodigo);
    	 listar_detalleProduccion(obj,'hijo');
    	 });
     $(document).find(".totales").each(function(key,val){
         if($("#"+this.id)){
         	//alert($.trim($("#"+this.id).text()));
          		suma = parseFloat(suma) +parseFloat($.trim($("#"+this.id).text()));/*numero*/	
            }
     });
     //alert("suma ="+suma +" resta ="+$("#total"+key).text())       ; 
     document.getElementById('fCostoTotal').value = parseFloat(suma) - parseFloat($.trim($("#total"+key).text())); 
     fn_calcularGlobal();
    
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
	    $("."+total).text( formatCurrency(precioTotal,''));
          var cad = "productos.do?metodo=detalleProduccion&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioCompra="+precio+"&fDescuento="+fDescuento;
  
 
		 $.getJSON(cad, function retorna(obj){
		      
			 
		 });


 fn_calcularTotales();

}
function fn_calcularTotales(){
	var sumaTotalReal=parseFloat(0.0);
	var sumaTotal=parseFloat(0.0);
	var sumaDescuento=parseFloat(0.0); 
	var sumaCantidad=parseFloat(0.0); 
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
      sumaCantidad=sumaCantidad+cantidad;

 }
	 document.getElementById('fCostoTotalR').value=dosDecimales(sumaTotal+parseFloat($("#fOtrosCostos").val()));
     document.getElementById('fCostoTotal').value=dosDecimales(sumaTotal);
     document.getElementById('iCantidadR').value=sumaCantidad;
     document.getElementById('iCantidad').value=sumaCantidad;
     document.getElementById('fCostoUniR').value=dosDecimales((parseFloat($("#fCostoTotalR").val()))/sumaCantidad);
     document.getElementById('fCostoUni').value=dosDecimales((parseFloat($("#fCostoTotalR").val()))/sumaCantidad);
     
    
		 
 fn_calcularGlobal();
}
function fn_calcularGlobal(){
    var sumaTotal= document.getElementById('fCostoTotalR').value;
	var sumaTotalReal=document.getElementById('fCostoTotal').value;
	
 document.getElementById('fCostoTotalR').value =dosDecimales(sumaTotal);
 document.getElementById('fCostoTotal').value =dosDecimales(sumaTotalReal);
  
 
}

function fn_descuento(){    	
	$("#fCostoTotal").val(parseFloat($("#fCostoTotalR").val())-parseFloat(numeroFloat($("#fDescuentoR").val())));
	$("#fDescuento").val($("#fDescuentoR").val());
	fn_calcularGlobal();
}
function fn_recarcular(){
	$("#fCostoTotalR").val(dosDecimales(parseFloat($("#fCostoTotal").val())+parseFloat(numeroFloat($("#fOtrosCostos").val())),''));
	$("#fCostoUni").val(parseFloat($("#fCostoTotalR").val())/parseFloat(numeroFloat($("#iCantidad").val())));
	$("#fCostoUniR").val(dosDecimales(parseFloat($("#fCostoTotalR").val())/parseFloat(numeroFloat($("#iCantidad").val())),''));	
	
}
function fn_RegProductos(tipo){
	$("#tr_RegProductos").show();
	$("#td_RegProductoNuevo").show();
	$("#iProductoStockCantidad").val($("#iCantidad").val());
	$("#fProductoPrecioCompra").val($("#fCostoUni").val());
	

if(tipo==0){// 0: producto nuevo
	
	$("#td_RegProductoExistente").hide();
	limpiar("tablaNuevoProducto");
	$("#cProductoCodigo").val($("#cProductoCodigo").val());
	$("#iProductoId").val(0);
 }
if(tipo==1){// 1: producto existente
	$("#td_RegProductoExistente").show();
	
 }
	
}

   // redimenciona();
</script>