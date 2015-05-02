
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="productos" styleId="formProductos">
<tr> <td colspan="2" ><span class="titulosTd"  id="po">Clasificaci&oacute;n:</span></td></tr>
<tr>
    <td align="right">Categor&iacute;a:</td>
    <td>
     <html:select  property="iCategoriaId" styleId="iCategoriaId" styleClass="combo">
           <option value="00">::SELECCIONE::</option> 
           <html:options collection="listaCategoria" property="iCategoriaId" labelProperty="vCategoriaDescripcion"/>
     </html:select>    
    </td>
</tr>

<tr class="trCodigo">
    <td align="right">C&oacute;digo:</td>
    <td>
        <html:text property="cProductoCodigo" styleId="cProductoCodigo" styleClass="text" maxlength="5" onkeypress="return LetrasNumeros(event)" onkeyup="return mayuscula('cProductoCodigo') "/>
        <span id="m_cProductoCodigo" class="importante">*</span>
    </td>
      
</tr>
<tr> <td colspan="2" >&emsp;</td></tr>
<tr> <td colspan="2" ><span class="titulosTd" >Informaci&oacute;n Basica:</span></td></tr>

<tr>
    <td align="right" width="25%">Nombre:</td>
    <td><html:text property="vProductoNombre" styleId="vProductoNombre" size="27" onkeyup="return mayuscula('vProductoNombre') " styleClass="text" maxlength="45" />
      <span id="m_vProductoNombre" class="importante">*</span>
    </td> 
</tr>
<tr>
    <td align="right">Cantidad:</td>
    <td>
    <html:text property="iProductoStockTotal" styleId="iProductoStockTotal" maxlength="7"  styleClass="text" onkeypress="return Numeros(event)" /> 
       <html:select  property="iUnidadMedidadId" styleId="iUnidadMedidadId" styleClass="comboCodigo">
          <option value="00">::SELECCIONE::</option> 
          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
     </html:select>  
      <span id="m_iProductoStockTotal" class="importante">*</span>
    </td>
</tr>
<tr>
     <td align="right">Capacidad:</td>
    <td><html:text property="iUMPedido" styleId="iUMPedido" maxlength="7"  styleClass="text" onkeypress="return LetrasNumeros(event)" /> <!-- onkeyup="return mayuscula('vProductoDescripcion')" -->
       <html:select  property="iUMBase" styleId="iUMBase" styleClass="comboCodigo">
          <option value="0">::SELECCIONE::</option> 
          <html:options collection="listaUnidadMedida" property="iUnidadMedidaId" labelProperty="vUnidadMedidaDescripcion"/>
     </html:select>  
    </td>
</tr>

<tr>
    <td align="right">Precio Compra:</td>
    <td>
	    <html:text property="fProductoPrecioCompra" styleId="fProductoPrecioCompra" styleClass="text"/>
	     <html:select  property="iMonedaId" styleId="iMonedaId" styleClass="comboCodigo">
	          <option value="00">::SELECCIONE::</option> 
	          <html:options collection="listaMoneda" property="iMonedaId" labelProperty="vMonedaDescripcion"/>
	     </html:select> 
	     <span id="m_fProductoPrecioCompra" class="importante">*</span>
     </td>
</tr>
<tr>
    <td align="right">Ganancia:</td>
    <td>
       <html:text property="fProductoGanancia"  styleId="fProductoGanancia" styleClass="text" onblur="fn_calcularGanancia('G')"/>
       <select class="comboCodigo" disabled="disabled" id="porcent" >
	          <option value=""/> %</option>
	     </select>
    </td>
</tr>
<tr>
    <td align="right">Precio Venta:</td>
    <td>
      <html:text property="fProductoPrecioVenta" styleId="fProductoPrecioVenta" styleClass="text" onblur="fn_calcularGanancia('V')"/>
       <html:select  property="iMonedaId" styleId="iMonedaId" styleClass="comboCodigo change">
              <option value="00">::SELECCIONE::</option> 
	          <html:options collection="listaMoneda" property="iMonedaId" labelProperty="vMonedaDescripcion"/>
	     </html:select>
	     <span id="m_fProductoPrecioVenta" class="importante">*</span>
      </td>
</tr>
<tr>
    <td align="right">Stock Min:</td>
    <td><html:text property="iProductoStockMinimo" styleId="iProductoStockMinimo" styleClass="text" onkeypress="return Numeros(event)"/></td>   <!-- onkeypress="return Numeros(event)" -->
</tr>
<tr>
    <td align="right">Stock Max:</td>
    <td><html:text property="iProductoStockMaximo" styleId="iProductoStockMaximo" styleClass="text" onkeypress="return Numeros(event)"/></td>  <!-- onkeypress="return Numeros(event)" -->
</tr>
<tr>
    <td align="right">Estado:</td>
    <td>
      <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo">       
       <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
     </html:select>  
    </td>
</tr>
<tr> <td colspan="2" >&emsp;</td></tr>
<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="buscar('tab-grupo')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>

<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iProductoId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />

<%-- hidden field que contiene el iclasificacionId --%>
<html:text property="iclasificacionId" styleId="iclasificacionId" styleClass="textInvisible" />

			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaProducto" styleId="metodo"/>

<html:hidden property="iUsuarioActualizaId" />
<%-- hidden field que contiene el iUsuarioInsertaId del producto --%>
<html:hidden property="iUsuarioInsertaId" />

</html:form>
<script>
   
    
   $(".comboCodigo.change").attr("disabled",true);
   $("#iMonedaId").change(function () {
    	var mival = $("#iMonedaId option:selected").val();
    	$(".comboCodigo.change option[value="+mival+"]").attr("selected",true);
    	
    	
   })
   
    var mode = document.getElementById('mode').value;	
    if(mode=='I') {
        document.getElementById('cProductoCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DATOS');	
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


   // redimenciona();
</script>