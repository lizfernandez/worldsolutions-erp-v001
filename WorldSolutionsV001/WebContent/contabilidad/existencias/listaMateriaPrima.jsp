
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
     <tr>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&iclasificacionId=2&mode=I',430,500)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','productos.do?metodo=iduProducto&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('productos.do?metodo=mantenimientoProducto&mode=F&iclasificacionId=2',430,500)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Materia Prima </caption>
    <thead>
     <tr>
        <th colspan="3">Operaciones</th>
        <th align="left">C&oacute;digo</th>
        <th width="23%" align="left">Nombre</th>
        <th align="left">Cantidad</th>
        <th align="left">Capacidad</th>
        <th align="left">Precio Compra</th>
        <th align="left">Stock Min</th>
        <th align="left">Stock Max</th>        
        <th align="left">Estado</th>
      </tr>
    </thead>
    <tbody>
    
<logic:empty name="contabilidadForm" property="lista">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del Insumo</td>
			</tr>
</logic:empty>
<logic:notEmpty name="contabilidadForm" property="lista"> 
	<logic:iterate name="contabilidadForm" property="lista" id="x">
	
	<tr>
	    <td align="center"><input type="checkbox" id="<bean:write name="x" property="iProductoId" />"/></td> 
		<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('productos.do?metodo=mantenimientoProducto&iclasificacionId=2&mode=U&id=<bean:write name="x" property="iProductoId" />',430,500)" /></td>
		<td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iProductoId" />','productos.do?metodo=iduProducto&mode=D')" /></td>	
		
		<td><bean:write name="x" property="cProductoCodigo" /></td>
		<td><bean:write name="x" property="vProductoNombre" /></td>
		<td>
		    <bean:write name="x" property="iProductoStockCantidad" />
		    <bean:write name="x" property="unidadMedida.vUnidadMedidaDescripcion" />
		</td>
		<td>
			<bean:write name="x" property="vProductoCapacidad" />
			<bean:write name="x" property="vUnidadMedidaDescripcionC" />
	    </td>
	    <td><bean:write name="x" property="fProductoPrecioCompra" /></td>
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
<logic:notEmpty name="contabilidadForm" property="paginas">	
    <bean:size id="listSizes" name="contabilidadForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="contabilidadForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="contabilidadForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#contabilidad").addClass("active");
$("#existencias").children('li').show();
$("#materiaPrima").css("background-image","linear-gradient(#21A8E7, #0D5DA2)");
$("#materiaPrima").children('a').css("color","#D0D2D7");

</script> 
 
