
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
<html:form action="productos" styleId="formProductos" >
<tr><td></td></tr>
<tr><td>
<table class="tabla" border="0" width="100%" id="detalleProduccion">
  
    <thead>
    <tr >
        <th align="left"></th>
        <th align="left">Codigo</th> 
        <th align="left">Nombre</th>        
        <th align="left">Cantidad</th>
        <th align="left">P.U</th>   
        <th align="left">Descuento</th>       
        <th align="right">Costo Total</th>
      </tr>
    </thead>
    <tbody>
     <tr>
        <td><img src="${pageContext.request.contextPath}/media/imagenes/new.png" onclick="fn_listarProducto()" /></td>
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
<td>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="cabecera" >
		            <tr>		                
		                <td align="right" width="76%">TOTAL: <span class="tipoMoneda"></span> </td>
		                <td align="right">
		                  <input type="text" id="fCostoTotalR"  class="text inputDisabled textNumero" readonly="true" />
		                  <span id="m_fCostoTotalR" class="importante">*</span>
		                </td>
		            </tr>
                     <tr>		                
		                <td align="right" width="76%">Cantidad Obtenida: </td>
		                <td align="right">
		                  <input type="text" id="iCantidadR"  class="text inputDisabled textNumero" readonly="true" />
		                  <span id="m_iCantidadR" class="importante">*</span>
		                </td>
		            </tr>
		              <tr>		                
		                <td align="right" width="76%">Costo Unidad: </td>
		                <td align="right">
		                  <input type="text" id="fCostoUniR"  class="text inputDisabled textNumero" readonly="true" />
		                  <span id="fCostoUniR" class="importante">*</span>
		                </td>
		            </tr>	 
               </table>
               
</tr>
</td>
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
    if(mode=='I') {
        
        document.getElementById('btnGuardar').textContent="Insertar";
       
        $("#popupCabecera").text('INSERTAR GESTION DE LA PRODUCCION');	
       
    } else {
        $(".trCodigo").show();
        document.getElementById('vProductoNombre').focus();
       // document.getElementById('cProductoCodigo').disabled = 'disabled';
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
 function fn_listarProducto(){
 	var iclasificacionId = 2;
 	popupModal('productos.do?metodo=listaProducto&iclasificacionId='+iclasificacionId+'&mode=LPP',750,650);
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
       var total = 'total'+fila;
       var precio =  parseFloat($.trim($("#precio"+fila).val()));
       var cantidad = parseFloat($.trim($("#numero"+fila).val()));
       var fDescuento = parseFloat($.trim($("#descuento"+fila).val()));   	
   	var precioReal = (precio)-(precio*(fDescuento/100));
       var precioTotal = parseFloat(cantidad*precioReal);
       
       document.getElementById(total).innerHTML = precioTotal;   
	    $("."+total).text( formatCurrency(precioTotal,''));
 var cad = "productos.do?metodo=detalleProduccion&id="+fila+"&mode=U&iCantidad="+cantidad+"&fPrecioCompra="+precio+"&fDescuento="+fDescuento;

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
	 document.getElementById('fCostoTotalR').value=sumaTotalReal;
     document.getElementById('fCostoTotal').value=sumaTotal;
	// document.getElementById('fDescuento').value=sumaDescuento;
		 
 fn_calcularGlobal();
}
function fn_calcularGlobal(){
    var sumaTotalReal= document.getElementById('fCostoTotalR').value;
	var sumaTotal=document.getElementById('fCostoTotal').value;
	//var sumaDescuento=document.getElementById('fDescuento').value;  	

 
 document.getElementById('fCostoTotalR').value =formatCurrency(sumaTotal,'');
 document.getElementById('fCostoTotal').value =(sumaTotalReal);
 //document.getElementById('fDescuento').value =(sumaDescuento);
 
 
 
}

function fn_descuento(){    	
	$("#fCostoTotal").val(parseFloat($("#fCostoTotalR").val())-parseFloat(numeroFloat($("#fDescuentoR").val())));
	$("#fDescuento").val($("#fDescuentoR").val());
	fn_calcularGlobal();
}
   // redimenciona();
</script>