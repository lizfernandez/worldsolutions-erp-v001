
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="estadoCuentaProveedor" styleId="formArea">
<tr>
    <td align="right">Vendedor:</td>
    <td><html:text property="sVendedor" styleId="sVendedor" onkeyup="return mayuscula('sVendedor')"   styleClass="text"/>
    </td>
</tr>
<tr>
    <td align="right">Fecha Pago:</td>
    <td><html:text property="dFechaPago" styleId="dFechaPago"  maxlength="11" styleClass="text" readonly="true"/>
    	<span id="m_dFechaPago" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Monto :</td>
    <td><html:text property="fMontoPago" styleId="fMontoPago"  maxlength="11" styleClass="text" onkeypress="return Numeros(event)"/>
    	<span id="m_fMontoPago" class="importante">*</span></td>
</tr>


<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="insertar('tab-grupo')"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iEstadoCuentaProveedor" />

<html:hidden property="iIngresoProductoId" />

<html:hidden property="iProveedorId" />
<html:text property="montoTotal" styleClass="textInvisible" styleId="montoTotal"/>
<html:text property="pagoTotal" styleClass="textInvisible" styleId="pagoTotal"/>



<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduEstadoCuentaProveedor" styleId="metodo" />
	
</html:form>
<script>
    var mode = document.getElementById('mode').value;
    $("#dFechaPago").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    })
	
	     var y = $("#montoTotal").val().split(","); 
	     var z = $("#pagoTotal").val().split(","); 
	   //  alert(y[0]+" DSF "+y.length)
	     if(y.length>1)
	     	$("#montoTotal").val(y[0]+y[1]);	    	 
	     else
	    	 $("#montoTotal").val(y[0]);
	     if(z.length>1)
		     	$("#pagoTotal").val(z[0]+z[1]);	    	 
		     else
		    	 $("#pagoTotal").val(z[0]); 
	     
	     
    if(mode=='I') {
        document.getElementById('sVendedor').focus();
        document.getElementById('btnGuardar').textContent="Insertar";
        $("#popupCabecera").text('INSERTAR DATOS');	
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
  function validarMonto(){
	  alert("hols");
	   
	   
	     var monto = parseFloat($("#fMontoPago").val());
	     var montoTotal=parseFloat($("#montoTotal").val());
	     var pagoTotal=parseFloat($("#pagoTotal").val());
	     var msg=0;
	     alert("montoTotal="+$("#montoTotal").val()+"pagoTotal="+pagoTotal);
	     if((monto)>montoTotal || (monto)>((montoTotal-pagoTotal))){
	    	 msg=msg+1;
	    	 
	     	alert("EL MONTO INGRESADO DEBE SER MENOR  \n   O IGUAL QUE EL MONTO DE VENTA= "+(montoTotal-pagoTotal));
	    	$("#fMontoPago").focus();
	      return false;	
	     }
	     if(msg==0) {	    	 
	    	 $(".mensaje").text("");	    	 
	        insertar('tab-grupo');
	     }
  }
</script>