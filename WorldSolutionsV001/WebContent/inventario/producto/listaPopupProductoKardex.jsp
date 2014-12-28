
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:form action="productos" styleId="formPersonal">
	<tr>
		<td align="right">Nombre:</td>
		<td><html:text property="producto.iProductoId" styleId="id"
				styleClass="textInvisible" /> <html:text
				property="producto.cProductoCodigo" styleId="cProductoCodigo"
				size="4" /> - <html:text property="producto.vProductoNombre"
				styleId="vProductoNombre" />
		<td align="right">Unidad Medida:</td>
		<td><html:text
				property="producto.unidadMedida.vUnidadMedidaDescripcion"
				styleId="vUnidadMedidaDescripcion" /></td>
		<td align="right">Estado:</td>
		<td><html:text property="producto.cEstadoCodigo" disabled="true" />
		</td>
	</tr>
	<tr>
		<td align="right">M&aacute;ximo:</td>
		<td><html:text property="producto.iProductoStockMaximo"
				styleId="iProductoStockMaximo" size="11" />
		<td align="right">M&iacute;mino:</td>
		<td><html:text property="producto.iProductoStockMinimo"
				styleId="iProductoStockMinimo" size="11" /></td>
		<td align="right">M&eacute;todo:</td>
		<td>PROMEDIO FIFO</td>
	</tr>

	<tr>
		<td align="right">Fecha Inicio:</td>
		<td><html:text property="dFechaInicio" styleId="dFechaInicio"
				size="11" maxlength="11" /></td>
		<td align="right">Fecha Fin:</td>
		<td><html:text property="dFechaFin" styleId="dFechaFin" size="11"
				maxlength="11" /></td>
		<td align="center"><button class="button"
				onclick="buscarPopup('tab-grupo')">
				<span class="find">Buscar</span>
			</button></td>
		<td align="center"><img onclick="fn_popupModales('',1080,830)"
			src="${pageContext.request.contextPath}/media/imagenes/paste.png"
			border="0" width="15%" /></td>
	</tr>

	<%-- hidden field que contiene el mode --%>
	<html:text property="mode" styleId="mode" styleClass="textInvisible" />
	<%-- set the parameter for the dispatch action --%>
	<html:hidden property="metodo" value="listaKardex" styleId="metodo" />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
	<caption>Movimiento del Producto - KARDEX</caption>
	<thead>
		<tr>
			<th align="left" rowspan="2">Fecha</th>
			<th align="left" rowspan="2">Detalle</th>
			<th align="center" colspan="3">Entrada</th>
			<th align="center" colspan="3">Salida</th>
			<th align="center" colspan="3">Existencias</th>
		</tr>
		<tr>
			<th align="left">Cant.</th>
			<th align="right">P.U.</th>
			<th align="right">Total</th>
			<th align="left">Cant.</th>
			<th align="right">P.U.</th>
			<th align="right">Total</th>
			<th align="left">Cant.</th>
			<th align="right">P.U</th>
			<th align="right">Total</th>
			<th align="right">Estado</th>

		</tr>
	</thead>
	<tbody>
		<logic:empty name="productosForm" property="produc">
			<tr>
				<td colspan="11">No hay informaci&oacute;n del movimiento de
					productos</td>
			</tr>
		</logic:empty>
		<logic:notEmpty name="productosForm" property="produc">
			<logic:iterate name="productosForm" property="produc" id="c">
				<tr>
					<td><bean:write name="c" property="dFecha" format="dd/MM/yyyy" /></td>
					<td><bean:write name="c" property="vConcepto" /></td>
					<td><logic:notEqual name="c" property="iCantIngresoProducto"
							value="0">
							<bean:write name="c" property="iCantIngresoProducto" />
						</logic:notEqual></td>
					<td align="right"><logic:notEqual name="c"
							property="fPuIngresoProducto" value="0">
							<bean:write name="c" property="fPuIngresoProducto"
								format="#,##0.00" locale="Localidad" />
						</logic:notEqual></td>
					<td align="right"><logic:notEqual name="c"
							property="fTotalngresoProducto" value="0">
							<bean:write name="c" property="fTotalngresoProducto"
								format="#,##0.00" locale="Localidad" />
						</logic:notEqual></td>
					<td><logic:notEqual name="c" property="iCantVenta" value="0">
							<bean:write name="c" property="iCantVenta" />
						</logic:notEqual></td>
					<td align="right"><logic:notEqual name="c" property="fPuVenta"
							value="0">
							<bean:write name="c" property="fPuVenta" format="#,##0.00"
								locale="Localidad" />
						</logic:notEqual></td>
					<td align="right"><logic:notEqual name="c"
							property="fTotalVenta" value="0">
							<bean:write name="c" property="fTotalVenta" format="#,##0.00"
								locale="Localidad" />
						</logic:notEqual></td>
					<td><bean:write name="c" property="iCantExistencia" /></td>
					<td align="right"><bean:write name="c"
							property="fPuExistencia" format="#,##0.00" locale="Localidad" /></td>
					<td align="right"><bean:write name="c"
							property="fTotalExistencia" format="#,##0.00" locale="Localidad" /></td>
					<td align="right"><bean:write name="c"
							property="cEstadoCodigo" /></td>
				</tr>
			</logic:iterate>
		</logic:notEmpty>
	</tbody>
</table>
<div id="paginacion">
	<logic:notEmpty name="productosForm" property="paginas">
		<bean:size id="listSizes" name="productosForm" property="paginas" />
		<input type="hidden" id="size" value="<bean:write name="listSizes" />" />
		<input type="hidden" id="pagInicio"
			value="<bean:write name="productosForm" property="pagInicio"/>" />
		<div class="btnPagInactivo" id="principio">&emsp;</div>
		<div class="btnPagInactivo" id="back">&emsp;</div>
		<div id="pag">
			<logic:iterate name="productosForm" property="paginas" id="p">
				<div class="btnPagInactivo" id="pg_<bean:write name="p" />"
					onclick="paginator('<bean:write name="p" />')">
					<bean:write name="p" />
				</div>
			</logic:iterate>
		</div>
		<div class="btnPagInactivo" id="Next">&emsp;</div>
		<div class="btnPagInactivo" id="Final">&emsp;</div>
	</logic:notEmpty>
</div>
<script>
	paginacion();
	$(":input:text").attr("disabled", true);
	$("#dFechaInicio,#dFechaFin").attr("disabled", false);
	$("#dFechaInicio,#dFechaFin").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'dd/mm/yy',
		defaultDate : -1,
		maxDate : '+0d'
	})
</script>
