<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div>

<p align="center">
 <span class="font_00">
       <span class="color_11"><span class="color_11">ERP </span></span>                </span>
      <span class="font_00"> <span class="color_18">Bienvenido al Sistema de Gestion Empresarial   </span> </span>  
<div id="listatos" style="width: 45%">	

    <table class="tabla" border="0" width="100%" id="tabla">
    <caption>Productos con Stock Minimo </caption>
    <thead>
     <tr>
        <th colspan="" width="5%">Ope.</th>
        <th align="left">C&oacute;digo</th>
        <th width="23%" align="left">Nombre</th>
        <th align="left">Cantidad</th>        
        <th align="left">Precio Compra</th>
        <th align="left">Precio Venta</th>
        <th align="left">Stock Min</th>
      </tr>
    </thead>
    <tbody>
    
<logic:empty name="loginForm" property="lista">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del producto</td>
			</tr>
</logic:empty>
<logic:notEmpty name="loginForm" property="lista">
      
	<logic:iterate name="loginForm" property="lista" id="x">
	
	<tr>
	    
		<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('productos.do?metodo=mantenimientoProducto&mode=U&iclasificacionId=1&id=<bean:write name="x" property="iProductoId" />',600,660)" /></td>
		
	    <td><bean:write name="x" property="cProductoCodigo" /></td>
		<td><bean:write name="x" property="vProductoNombre" /></td>
		<td>
		    <bean:write name="x" property="iProductoStockCantidad" />
		    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
		</td>
		
	    <td><bean:write name="x" property="fProductoPrecioCompra" /></td>
	    <td><bean:write name="x" property="fProductoPrecioVenta" /></td>
	    <td><bean:write name="x" property="iProductoStockMinimo" /></td>
		
		
	   

	</tr>
	</logic:iterate>
</logic:notEmpty>

<!-- ?php }$i++; endforeach;?>
<?php endif;?> -->
 
</tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="loginForm" property="paginas">	
    <bean:size id="listSizes" name="loginForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="loginForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="loginForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
</div>
<div id="estadoCuentaClientes">	  </div> 
<div id="estadoCuentaClientesLetra">	  </div> 
<div id="estadoCuentaProveedores">	  </div>  
<div id="estadoCuentaProveedoresLetra">	  </div>  
          
</div>
 <script>   
 $(".menuVertical").hide();
 $("#btns").hide(); 
 $("#listado").css("width","99%");
 paginacion();
 
 </script> 