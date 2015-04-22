
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('venta.do?metodo=mantenimientoVenta&mode=IE',470,380)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button"onclick="popup('venta.do?metodo=mantenimientoVenta&mode=FE',470,380)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Estado Cuenta de Clientes</caption>
        <!-- tr>
            <th width="5%" >Nombre EstadoCuentaProveedor:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        <th colspan="1"width="5%" >Operaciones</th>
        <th  align="left">C&oacute;digo</th>
        <th width="25%" align="left">Proveedor</th>
        <th  align="left">Total Doc.</th>
        <th  align="left">1ra Fecha Emisi&oacute;n</th>
        <th  align="left">Ult. Fecha Pago</th>
        <th  align="right">Monto Total</th>
        <th  align="right">Pago Total</th>
        <th  align="right">Saldo Total</th>
        <th  align="left">Estado</th>
       
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="estadoCuentaClienteForm" property="lista">
				<tr>
					<td colspan="12">No hay informaci&oacute;n del estado Cuenta de Proveedores</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="estadoCuentaClienteForm" property="lista">
	     	<logic:iterate name="estadoCuentaClienteForm" property="lista" id="x">	
			<tr>
				 
				<td align="center"><img title="Ver Documentos" src="${pageContext.request.contextPath}/media/imagenes/control.png"
		                     onclick="popup('venta.do?metodo=listaVenta&mode=LEP&id=<bean:write name="x" property="idClienteProveedor" />',1000,450)" /></td>
		 	 	 <td><bean:write name="x" property="cProveedorCodigo" /></td>
				 <td><bean:write name="x" property="nombreClienteProveedor" /></td>
				 <td><bean:write name="x" property="totalDocumentos" /></td>
				 <td><bean:write name="x" property="primerFechaEmision" /></td>
				 <td><bean:write name="x" property="ultFechaPagos" /></td>
				 <td align="right"><bean:write name="x" property="montoTotal"/></td>
				 <td align="right"><bean:write name="x" property="pagoTotal" /></td>
				 <td align="right"><bean:write name="x" property="saldoTotal" /></td>
				 <td><bean:write name="x" property="cCodigoEstado" /></td>
			</tr>
			<logic:notEqual name="x" property="montosTotales" value="">
				 <tr>
					 <td colspan="5"></td>
					 <td align="right"><strong>Monto Totales:</strong></td>
					  <td align="right"><bean:write name="x" property="montosTotales" /></td>
					 <td align="right"><bean:write name="x" property="pagosTotales" /></td>
					 <td align="right"><bean:write name="x" property="saldosTotales" /></td>
					 <td align="right"></td>
					
				</tr>
			</logic:notEqual>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="estadoCuentaClienteForm" property="paginas">	
    <bean:size id="listSizes" name="estadoCuentaClienteForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="estadoCuentaClienteForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="estadoCuentaClienteForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#cliente").addClass("active");
</script> 
 