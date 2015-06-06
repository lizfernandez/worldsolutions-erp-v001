
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="productos" styleId="formPersonal">
    <tr>
    	
	    <td align="right">Nro Salida:</td>
	    <td>   
	        <html:text property="vNroSalida"  styleId="vNroSalida"  onkeyup="return mayuscula('vNroSalida')" onkeypress="return LetrasNumeros(event)" maxlength="5" styleClass="textCodigo"/>
	        
	    </td>
        <td align="right">Fecha Salida:</td>
	   <td><html:text property="dFechaSalida" styleId="dFechaSalida"  onkeyup="return mayuscula('dFechaSalida')" onkeypress="return LetrasNumeros(event)" styleClass="text"/>
	        
	    </td>
	    <td rowspan="2"><button  class="button"  onclick="buscarPopup('tab-grupo')">
                <span class="find">Buscar</span>
            </button>
        </td>
	 </tr> 

<%-- hidden field que contiene el mode --%>
<html:text property="mode" styleId="mode"  styleClass="textInvisible"/>
<input type="text" id="tipo"  class="textInvisible"/>
<input type="text" id="identificador"  class="textInvisible"/>		
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaDistAlmacen" styleId="metodo"  />
</html:form>
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Producto</caption>
        <!-- tr>
            <th width="5%" >Apellidos Personal:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
        -->
    <thead>
    <tr >
       
        <th align="left">C&oacute;digo</th>
        <th width="20%" align="left">Tipo Operacion</th>
        <th width="20%" align="left">Almacen Salida</th>
        <th align="left">Almacen Entrada</th>
        <th align="left" width="8%" >Fecha Salida</th>
        <th align="left" width="8%" >Fecha Recepcion</th>        
        <th align="left">Estado</th>
        
      </tr>
    </thead>
   <logic:empty name="productosForm" property="produc">
			<tr>
				<td colspan="12">No hay informaci&oacute;n del producto</td>
			</tr>
</logic:empty>
<logic:notEmpty name="productosForm" property="produc">
		 <logic:iterate name="productosForm" property="produc" id="x" indexId="i">	
		 <logic:equal name="x" property="vTipoOperacion" value="S">
			<tr onclick="fn_cargarDistribucion('<bean:write name="x" property="iDistAlmacenId" />','<bean:write name="x" property="dFechaSalida" format="dd/MM/yyyy"  />')">
				<logic:equal name="x" property="vTipoOperacion" value="S">
				<td><bean:write name="x" property="vNroSalida" /></td>
				<td>SALIDA</td>
				</logic:equal>
			
			    <td><bean:write name="x" property="almacenSalida.vAlmacenNombre" /></td>
				<td><bean:write name="x" property="almacenEntrada.vAlmacenNombre" /></td>
				<td><bean:write name="x" property="dFechaSalida"  format="dd/MM/yyyy"/></td>
				<td><bean:write name="x" property="dFechaIngreso"  format="dd/MM/yyyy"/></td>
				<td><bean:write name="x" property="cEstadoCodigo" /></td>
						
	    	</tr>
	    		</logic:equal>
		</logic:iterate>
	  </logic:notEmpty>
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
	<div class="btnPagInactivo" id="Next" >&emsp; </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div>

<script>   
paginacion(); 
$("#tipo").val($_GET('tipo'));
$("#identificador").val($_GET('identificador'));
$("#dFechaSalida").datepicker(
        {
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            defaultDate: -1,
            minDate: 0,
            maxDate: '+30Y', 
    });
 function fn_cargarDistribucion(id, fecha){
	 var cad = "productos.do?metodo=detalleAlmacen&id="+id+"&mode=ID";
            	       
      $.getJSON(cad, function retorna(obj){
  
     		 listar_detalleDistribucionEntrada(obj, "padre",fecha);
     	   
     	   
     	  
     });
 }
	
 </script>  