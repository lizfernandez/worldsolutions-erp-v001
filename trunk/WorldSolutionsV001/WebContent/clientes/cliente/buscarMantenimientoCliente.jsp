
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="cliente" styleId="formCliente">
<tr class="trCodigo">
    <td align="right">C&oacute;digo:</td>
    <td width="35%"><html:text property="vClienteCodigo" styleId="vClienteCodigo" onkeyup="return mayuscula('vClienteCodigo')"  onkeypress="return LetrasNumeros(event)" maxlength="5" styleClass="textCodigo" tabindex="1"/>
    	<span id="m_vClienteCodigo" class="importante">*</span>
    </td>
    
</tr>
<tr>
   <td align="right" ><span id="razonSocial">Raz&oacute;n Social :</span></td>
    <td width="74%">        
        <html:text property="vClienteRazonSocial" styleId="vClienteRazonSocial" onkeyup="return mayuscula('vClienteRazonSocial')" styleClass="text" size="37" tabindex="2"/>
       <span id="m_vClienteRazonSocial" class="importante">*</span>
   </td>
</tr>
<tr>
    <td align="right"><span id="Ruc">Dni /Ruc:</span></td>
    <td>
        <html:text property="nClienteNumeroDocumento" styleId="nClienteNumeroDocumento"  styleClass="textN" maxlength="11" onkeypress="return Numeros(event)" tabindex="3" />
        <span id="m_nClienteNumeroDocumento" class="importante">*</span> 
    </td>    
</tr>
<tr>
    <td align="right">Tel&eacute;fono:</td>
    <td>
        <html:text property="nClienteTelefono" styleId="nClienteTelefono"  styleClass="textN" tabindex="4"/>
    </td>
</tr>
<tr>
    <td align="right">Direcci&oacute;n :</td>
    <td>        
        <html:text property="vDireccion" styleId="vDireccion" onkeyup="return mayuscula('vDireccion')" styleClass="text" size="37" tabindex="5"/>
        <span id="m_vDireccion" class="importante">*</span>
    </td>
   
</tr>
<tr>
<td align="right">Clasificaci&oacute;n:</td>
    <td>
    <html:select  property="iClasificacionClienteId" styleId="iClasificacionClienteId" styleClass="combo Departamento" style="width:160px" onchange="fn_cambio()" tabindex="6">       
              <html:options collection="listaClasificacion" property="iClasificacionClienteId" labelProperty="vNombre"/>
    </html:select>
   </td>
</tr>
<tr>
    <td align="right">% Descuento:</td>
    <td>        
        <html:text property="fDescuento" styleId="fDescuento" styleClass="textN"  tabindex="7" onkeypress="return Numeros(event)"/>
     
    </td>
   
</tr>
<tr>
<td align="right">Tipo Direcci&oacute;n:</td>
    <td>
    <select name="vPrincipal" id="vPrincipal" class="combo" style="width:160px" tabindex="8">
            <option value="1">PRINCIPAL</option>
            <option value="0">SEGUNDARIA</option>
    </select>
   </td>
</tr>

<tr>
	<td align="right">Departamento:</td>
     <td> <html:select  property="vDepartamento" styleId="vDepartamento" styleClass="combo Departamento" onchange="fn_cambioPoblacion('DEP')" style="width:160px" tabindex="9">       
               <option value="00">::SELECCIONE::</option>
              <html:options collection="listaDepartamento" property="cCodigo" labelProperty="vDescripcion"/>
           </html:select>
    </td>
</tr>
<tr>
    <td align="right">Provincia:</td>
     <td> <html:select  property="vProvincia" styleId="vProvincia" styleClass="combo Provincia" onchange="fn_cambioPoblacion('PRO')" style="width:160px" tabindex="10">       
               <option value="00">::SELECCIONE::</option>
              <html:options collection="listaProvincia" property="cCodigo" labelProperty="vDescripcion"/>
           </html:select>
    </td>
</tr>
<tr>
    <td align="right">Distrito</td>
     <td> <html:select  property="iPoblacionId" styleId="iPoblacionId" styleClass="combo Distrito" style="width:160px" tabindex="11">       
               <option value="00">::SELECCIONE::</option>
              <html:options collection="listaDistrito" property="cCodigo" labelProperty="vDescripcion" />
           </html:select>
      </td>
</tr>
<tr>
    <td align="right">Estado:</td>
    <td colspan="3"> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" style="width:160px" tabindex="12">       
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td>
 
</tr>

<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="buscar('tab-grupo')" tabindex="13"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');" type="button" tabindex="14"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iClienteId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="listaCliente" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    
    if(mode=='I') {
        document.getElementById('vClienteCodigo').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
        $("#popupCabecera").text('INSERTAR DATOS');	
        
        $(".combo.Departamento option[value='140000']").attr("selected",true);
        $(".combo.Provincia option[value='140500']").attr("selected",true);
        $(".combo.Distrito option[value='140501']").attr("selected",true);
       
    } else {
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

    
    
    function fn_cambioPoblacion(valor){
        if(valor=="DEP")    {
            var departamento = $(".combo.Departamento").val();
            var cad = "cliente.do?metodo=cambioPoblacion&tipo="+valor+"&poblacion="+departamento;
            $.getJSON(cad, function retorna(obj){listar_poblacion(obj,valor);});
            
         }
        else {
            var provincia = $(".combo.Provincia").val();
            var cad = "cliente.do?metodo=cambioPoblacion&tipo="+valor+"&poblacion="+provincia;
            $.getJSON(cad, function retorna(obj){listar_poblacion(obj,valor)});
            
            


         }
     }

        //CARGAMOS EL COMBO DE ESTADO
    function listar_poblacion(obj,valor){
        	
    	var newHtml='';
    	$.each(obj,function(key,data){
    		
    		newHtml+='<option value='+data.cCodigo+'>';
    			newHtml+=data.vDescripcion;
    		newHtml+='</option>';
    	});
        if(valor=='DEP'){
        	 $('.combo.Provincia').html(newHtml);	
        	 fn_cambioPoblacion('PRO');
        }
    	
        if(valor=='PRO')
    	$('.combo.Distrito').html(newHtml);
    };
</script>