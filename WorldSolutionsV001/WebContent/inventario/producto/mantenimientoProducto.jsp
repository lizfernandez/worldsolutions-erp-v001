
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
<html:form action="productos" styleId="formProductos" enctype="multipart/form-data">
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
        <html:text property="cProductoCodigo" styleId="cProductoCodigo"  size="10" styleClass="text" maxlength="8"  onkeyup="return mayuscula('cProductoCodigo') " tabindex="3"/>
        <span id="m_cProductoCodigo" class="importante">*</span>
    </td>
      
</tr>
<tr> 
    <td align="right" width="25%">Nombre:</td>
    <td><html:text property="vProductoNombre" styleId="vProductoNombre" size="27" onkeyup="return mayuscula('vProductoNombre') " styleClass="text" tabindex="4" maxlength="45" />
      <span id="m_vProductoNombre" class="importante">*</span>
    </td>
    <td colspan="2"> 
      <html:file property="foto" styleId="foto" style="width:273px"></html:file>
      
    </td>
</tr>
<tr>
	 <td colspan="4">
	 <span id ="span1" class="btnOpcionesActivo"  onclick="subMenuOpciones('1')">Datos B&aacute;sicos:</span>
	 <span id ="span2" class="btnOpciones" onclick="subMenuOpciones('2')">Lista Precios</span>
	 <table class="tabla" id="tabla1">	  
		
		<tr>
		    <td align="right" width="20%">Cantidad:</td>
		    <td width="20%">
		    <html:text property="iProductoStockCantidad" styleId="iProductoStockCantidad" maxlength="7"  styleClass="text textNumero" tabindex="5" onkeypress="return Numeros(event)"/> 
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
			    <html:text property="fProductoPrecioCompra" styleId="fProductoPrecioCompra" styleClass="text textNumero" tabindex="9" onkeypress="return Numeros(event)"/>
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
		       <html:text property="fProductoGanancia"  styleId="fProductoGanancia" styleClass="text textNumero" onblur="fn_calcularGanancia('G')" tabindex="11" onkeypress="return Numeros(event)"/>
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
		      <html:text property="fProductoPrecioVenta" styleId="fProductoPrecioVenta" styleClass="text textNumero" onblur="fn_calcularGanancia('V')" tabindex="12" onkeypress="return Numeros(event)"/>
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
		    <td colspan="2"><html:text property="fProductoDescuento" styleId="fProductoDescuento" styleClass="text textNumero"  tabindex="13" onkeypress="return Numeros(event)"/></td>   <!-- onkeypress="return Numeros(event)" -->
		</tr>
		<tr>
		    <td align="right">Stock Min:</td>
		    <td colspan="2"><html:text property="iProductoStockMinimo" styleId="iProductoStockMinimo" styleClass="text textNumero"  tabindex="13" onkeypress="return Numeros(event)"/></td>   <!-- onkeypress="return Numeros(event)" -->
		</tr>
		<tr>
		    <td align="right">Stock Max:</td>
		    <td colspan="2"><html:text property="iProductoStockMaximo" styleId="iProductoStockMaximo" styleClass="text textNumero"  tabindex="14" onkeypress="return Numeros(event)"/></td>  <!-- onkeypress="return Numeros(event)" -->
		</tr>
		<tr>
		    <td align="right">Estado:</td>
		    <td colspan="2">
		      <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" tabindex="15">       
		       <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
		     </html:select>  
		    </td>
		</tr>

	 </table> 
	 <table class="tabla" id="tabla2" style="display: none">
	      
          <thead>
		       <tr id="tr_01">
					<td>Cantidad:</td>
					<td><input type="text" id="iCantidadStock" class="textN" size="5">
					    <input type="text" id="iPrecioProductoId" class="textInvisible" value="0" size="5"></td>
					<td>Precio Compra:</td>
					<td><input type="text" id="fPrecioCompra" class="textN" size="5"></td>
					<td>% ganancia:</td>
					<td><input type="text" id="fGanancia" class="textN" onblur="fn_calcularGananciaLista('G')" size="5" ></td>
					<td colspan="2"><button type="button" onclick="limpiar('tabla2')" class="button">
         				 <span class='refresh' id="btnLimpiar">Limpiar</span></button></td>
			  </tr>
			   <tr id="tr_02">				
					
					<td>% Desc.:</td>
					<td><input type="text" id="fDescuento" class="textN" size="5"></td>
					<td>Precio Venta:</td>
					<td><input type="text" id="fPrecioVenta" class="textN" size="5"></td>
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
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduProducto" styleId="metodo"/>



<html:hidden property="iUsuarioActualizaId" />
<html:hidden property="vFoto" />
<%-- hidden field que contiene el iUsuarioInsertaId del producto --%>
<html:hidden property="iUsuarioInsertaId" />
<html:hidden property="sizeIngresoproductodetalles" />
<html:hidden property="sizeVentaDetalles" />


</html:form>
<script>
   
    
   $(".comboCodigo.change").attr("disabled",true);
   $("#iMonedaId").change(function () {
    	var mival = $("#iMonedaId option:selected").val();
    	$(".comboCodigo.change option[value="+mival+"]").attr("selected",true); 
   })
   $("#iUnidadMedidadIdC").change(function () {
    	var mival = $("#iUnidadMedidadIdC option:selected").text();
    	if($("#iUnidadMedidadIdC option:selected").val()!="0")
    	  $("#vUnidadMedidaDescripcionC").val(mival);
    })
  
  // alert($("#iUnidadMedidadIdC").text()+"  "+$("#iUnidadMedidadIdC").val())
    var mode = document.getElementById('mode').value;	
    if(mode=='I') {
        document.getElementById('cProductoCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DATOS');	
        $("#span2").hide();
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

   // redimenciona();
</script>