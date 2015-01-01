
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
    <!-- tr>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&mode=I',430,500)">
                <span class="new">Agregar Producto al Inventarios</span></button>
        <select id="selTipo" name="selTipo">
                <option value="1">DISTRIBUCION</option>
                <option value="2">PRODUCIDO</option>
            </select>
        </td>
    </tr> -->
     <tr>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&mode=I&iclasificacionId=1',700,635)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','productos.do?metodo=iduProducto&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&mode=F&iclasificacionId=1',700,580)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Productos </caption>
    <thead>
     <tr>
        <th colspan="4" width="5%">Operaciones</th>
        <th align="left">C&oacute;digo</th>
        <th width="23%" align="left">Nombre</th>
        <th width="9%" align="left">Foto</th>
        <th align="left">Cantidad</th>
        <th align="left">Capacidad</th>
        <th align="left">Precio Compra</th>
        <th align="left">Precio Venta</th>
        <th align="left">Stock Min</th>
        <th align="left">Stock Max</th>        
        <th align="left">Estado</th>
      </tr>
    </thead>
    <tbody>
    
<logic:empty name="productosForm" property="produc">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del producto</td>
			</tr>
</logic:empty>
<logic:notEmpty name="productosForm" property="produc">
      
	<logic:iterate name="productosForm" property="produc" id="x">
	
	<tr>
	    <td align="center"><input type="checkbox" id="<bean:write name="x" property="iProductoId" />"/></td> 
		<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('productos.do?metodo=mantenimientoProducto&mode=U&iclasificacionId=1&id=<bean:write name="x" property="iProductoId" />',600,660)" /></td>
		<td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iProductoId" />','productos.do?metodo=iduProducto&mode=D')" /></td>	
		
		<td align="center">
     		<img  src="${pageContext.request.contextPath}/media/imagenes/approve_notes.png"   title="Visualizar Kardex" 
     		onclick="popup('productos.do?metodo=listaKardex&mode=Kardex&id=<bean:write name="x" property="iProductoId" />',900,400)" />
		</td>
	    <td><bean:write name="x" property="cProductoCodigo" /></td>
		<td><bean:write name="x" property="vProductoNombre" /></td>
		<td><logic:notEqual name="x" property="vFoto" value=""> <img  src="${pageContext.request.contextPath}/media/fotos/<bean:write name="x" property="vFoto" />"  width="23%" height="20%" /></logic:notEqual></td>
		<td>
		    <bean:write name="x" property="iProductoStockCantidad" />
		    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
		</td>
		<td>
			<bean:write name="x" property="vProductoCapacidad" />
			<bean:write name="x" property="vUnidadMedidaDescripcionC" />
	    </td>
	    <td><bean:write name="x" property="fProductoPrecioCompra" /></td>
	    <td><bean:write name="x" property="fProductoPrecioVenta" /></td>
	    <td><bean:write name="x" property="iProductoStockMinimo" /></td>
		<td><bean:write name="x" property="iProductoStockMaximo" /></td>
		<td><bean:write name="x" property="cEstadoCodigo" /></td>
	   

	</tr>
	</logic:iterate>
</logic:notEmpty>

<!-- ?php }$i++; endforeach;?>
<?php endif;?> -->
 
</tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="productosForm" property="paginas">	
    <bean:size id="listSizes" name="productosForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="productosForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="productosForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#inventario, #producto").addClass("active");
function nuevo(){
	popup('productos.do?metodo=mantenimientoProducto&mode=I&iclasificacionId=1',600,600);
}
</script> 