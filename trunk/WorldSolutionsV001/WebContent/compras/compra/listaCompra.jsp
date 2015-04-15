
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table border="0">
    <tr>
            
        <!-- td> 
          <select id="iclasificacionId" name="iclasificacionId" class="text" style="width: 150px">
                <option value="1">PRODUCTOS</option>
                <option value="2">MATERIAS PRIMAS</option>
                <option value="3">SUMINISTROS Y REPUESTOS</option>
                <option value="4">ENVASES Y EMBALAJES</option>
               
           </select >
        </td-->
        <td> 
          <!-- select id="selTipoDocumento" name="selTipoDocumento" class="text" style="width: 150px">
                <option value="1">FACTURA</option>
                <option value="2">BOLETA</option>
                <!-- option value="3">NOTA DE DEBITO</option> -->
                <!-- option value="4">GUIA DE REMISI&Oacute;N</option>
                <!--<option value="5">PEDIDO</option> -->
           <!-- /select-->
        </td>
        <td><button  class="button" onclick="fn_nuevoDocumento()">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <!-- td><button  class="button" onclick="eliminar('tabla','','ingresoProducto.do?metodo=iduIngresoproducto&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td> -->
        <td><button  class="button" onclick="popup('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=F',580,470)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <td><button class="button" onclick="fn_exportarExcel('ingresoProducto.do?metodo=exportarExcel&plantilla=compra')">
                <span class="excel">Exportar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Compras</caption>
        <!-- tr>
            <th width="5%" >Nombre IngresoProducto:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        
          
	         
        <th colspan="1"width="5%" >Ope.</th>       
        <th align="left">Proveedor</th>
        <th align="left">Tipo Documento</th>
	    <th align="left">Nro. Documento</th>
	    <th align="left">Forma pago</th>
	    <th align="left">Fecha Emisi&oacute;n</th>
	    <th align="right">Monto Total</th>
	    <th align="left">Usuario</th>
        <th align="left">Estado Documento</th>
   
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="ingresoProductoForm" property="lista">
				<tr>
					<td colspan="13">No hay informaci&oacute;n de ingresoProductos</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="ingresoProductoForm" property="lista">
	    <logic:iterate name="ingresoProductoForm" property="lista" id="x">	
			<tr>
				<!-- td align="center"><input type="checkbox" id="<bean:write name="x" property="iIngresoProductoId" />"/></td--> 
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=U&id=<bean:write name="x" property="iIngresoProductoId" />&idTipoDocumento=<bean:write name="x" property="tipodocumento.iTipoDocumentoGestionId" />',1130,500)" /></td>
		 	    <!--  td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iIngresoProductoId" />','ingresoProducto.do?metodo=iduIngresoproducto&mode=D')" /></td-->	
				<td><bean:write name="x" property="proveedor.vProveedorRazonSocial" /></td>
				<td><bean:write name="x" property="tipodocumento.vTipoDocumentoDescripcion" /></td>
				<td><bean:write name="x" property="nIngresoProductoNumero" /></td>
				<td><bean:write name="x" property="formaPago.vFormaPagoDescripcion" /></td>
				<td><bean:write name="x" property="dIngresoProductoFecha"  format="dd/MM/yyyy"/></td>
				<td align="right"><bean:write name="x" property="fIngresoProductoTotal" format="#,##0.00" locale="Localidad" /></td>
				<td><bean:write name="x" property="usuario.personal.vPersonalNombres" /></td>					
				<td><bean:write name="x" property="vEstadoDocumento" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="ingresoProductoForm" property="paginas">	
    <bean:size id="listSizes" name="ingresoProductoForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="ingresoProductoForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="ingresoProductoForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp; </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion(); 
 function fn_nuevoDocumento(){
	var tipoDoc= 2;//$("#selTipoDocumento").val();
	var iclasificacionId= 1;//$("#iclasificacionId").val();
	 popup('ingresoProducto.do?metodo=mantenimientoIngresoproducto&mode=I&idTipoDocumento='+tipoDoc+"&iclasificacionId="+iclasificacionId,1090,700);
 }
 $("#compra,#mantCompras").addClass("active");
 </script> 
 