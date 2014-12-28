
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:form action="contabilidad" styleId="formArea">
<tr>
    <td align="right">Fecha:</td>
    <td><html:text property="dFechaInserta" styleId="dFechaInserta"  onkeypress="return LetrasNumeros(event)" maxlength="7" styleClass="text"/>
    	<span id="m_dFechaInserta" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Tipo:</td>
    <td>
     <html:radio property="tipo" styleId="ingreso" styleClass="comboCuenta partidaI" value="1,2,3,7"  onclick="fn_cambioPartida('I',0)" />Ingreso &emsp;&emsp;&emsp;
     <html:radio property="tipo" styleId="egreso" styleClass="comboCuenta partidaE"  value="4,6" onclick="fn_cambioPartida('E',0)" />Egreso&emsp;&emsp;&emsp;
      <html:radio property="tipo" styleId="patrimonio" styleClass="comboCuenta partidaP"  value="5" onclick="fn_cambioPartida('P',0)" />Patrimonio
       <!-- html:radio property="tipo" styleId="saldo" styleClass="comboCuenta partidaS"  value="8" onclick="fn_cambioPartida('S',0)" />Saldos intermediarios de gestion -->
    </td>
</tr>
<tr>
    <td align="right">Elemento:</td>
    <td><html:select  property="iElementoCuentasId" styleId="iElementoCuentasId" styleClass="comboCuenta partida0 text" onchange="fn_cambioPartida(0,1)" style="width:160px">       
              <option value="00">::SELECCIONE::</option>   
                <html:options collection="listaElementoCuenta" property="iElementoCuentasId" labelProperty="vDescripcion"/>            
         </html:select>
    	<span id="m_dFechaInserta" class="importante">*</span>
    </td>
</tr>
<tr>
    <td align="right">Partida:</td>
    <td><html:select  property="iCuentasId1" styleId="iCuentasId1" styleClass="comboCuenta partida1 text" onchange="fn_cambioPartida(1,2)" style="width:160px">       
              <option value="00">::SELECCIONE::</option>   
              <html:options collection="listaCuenta" property="iCuentasId" labelProperty="vDescripcion"/>           
         </html:select>   
    	
    </td>
</tr>
<tr id="S2">
    <td align="right">Sub Partida1:</td>
    <td>
        <html:select  property="iCuentasId2"  styleClass="comboCuenta partida2 text" onchange="fn_cambioPartida(2,3)" style="width:160px">       
              <option value="00">::SELECCIONE::</option>
              <html:options collection="listaCuenta1" property="iCuentasId" labelProperty="vDescripcion"/>              
         </html:select>         
    </td>
</tr>
<tr id="S3">
    <td align="right">Sub Partida2:</td>
    <td>
         <html:select  property="iCuentasId3"  styleClass="comboCuenta partida3 text" onchange="fn_cambioPartida(3,4)" style="width:160px">       
              <option value="00">::SELECCIONE::</option>  
              <html:options collection="listaCuenta2" property="iCuentasId" labelProperty="vDescripcion"/>              
         </html:select>        
    </td>
</tr>
<tr id="S4">
    <td align="right">Sub Partida3:</td>
    <td>
         <html:select  property="iCuentasId4"  styleClass="comboCuenta partida4 text" onchange="fn_cambioPartida(4,5)"  style="width:160px">       
              <option value="00">::SELECCIONE::</option> 
              <html:options collection="listaCuenta3" property="iCuentasId" labelProperty="vDescripcion"/>               
         </html:select>         
    </td>
</tr>
<tr id="S5">
    <td align="right">Sub Partida4:</td>
    <td>
         <html:select  property="iCuentasId5"  styleClass="comboCuenta partida5 text" style="width:160px">       
              <option value="00">::SELECCIONE::</option>   
              <html:options collection="listaCuenta4" property="iCuentasId" labelProperty="vDescripcion"/>             
         </html:select>    	
    </td>
</tr>
<tr>
    <td align="right">Monto:</td>
    <td><html:text property="fMonto" styleId="fMonto"  onkeypress="return LetrasNumeros(event)" maxlength="7" styleClass="text" style="width:160px"/>
    	<span id="m_fMonto" class="importante">*</span>
    </td>
</tr>

<tr>
    <td align="right">Estado:</td>
    <td> <html:select  property="cEstadoCodigo" styleId="cEstadoCodigo" styleClass="combo" style="width:160px">       
              <html:options collection="listaEstado" property="cEstadoCodigo" labelProperty="vEstadoDescripcion"/>
         </html:select>
    </td>
    
</tr>
<tr height="50px">   
    <td align="center" colspan="2">
    <br>    
     <button onclick="insertar('tab-grupo')"  class="button"><span class='save' id="btnGuardar">Guardar</span></button>
     <button onclick="cancelar('');"  class="button" type="button"><span class='cancel'>Cancelar</span></button>
     <br>
     <br>
     <span id="m_mensaje" class="mensaje"></span>
     <br>
    </td>
</tr>
<%-- hidden field que contiene el id del producto --%>
<html:hidden property="iLibroDiarioId" />

<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
			
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="iduCuentas" styleId="metodo" />
<html:hidden property="iCuentasId" styleId="iCuentasId" />
<html:hidden property="iCuentasId1" styleId="iCuentasId3" />
<html:hidden property="iCuentasId2" styleId="iCuentasId3" />
<html:hidden property="iCuentasId3" styleId="iCuentasId3" />
<html:hidden property="iCuentasId4" styleId="iCuentasId4" />
<html:hidden property="iCuentasId5" styleId="iCuentasId5" />
<html:hidden property="vConceptoGeneral" styleId="vConceptoGeneral" />
<html:hidden property="cCajaBanco" styleId="cCajaBanco" />


	
</html:form>
<script>

     
    var mode = document.getElementById('mode').value;
   
    $(".combo, .partida0,.partida1, .partidaI, .partidaE").show();
    for (var i=1;i<6;i++){    	
    	if($("#iCuentasId"+i).val()==0)
      	    $("#S"+i).hide();
    	else
    		$("#S"+i).show();
     }
    $("#dFechaInserta").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    })
    
    
    
    if(mode=='I') {
        document.getElementById('btnGuardar').textContent="Insertar";
        $(".trCodigo").show();
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
    
    function fn_cambioPartida(origen,destino){
    	   
            var partida= $(".comboCuenta.partida"+origen).val();
           // alert(partida+"  "+clase);
            var cad = "contabilidad.do?metodo=cambioPartida&tipo="+origen+"&partida="+partida;
            $.getJSON(cad, function retorna(obj){listar_partida(obj,origen,destino);});
            
     }

        //CARGAMOS EL COMBO DE ESTADO
    function listar_partida(obj,origen,destino){
    	 var vconceptoGeneral ="";
        $("#iCuentasId").val($('.comboCuenta.partida'+origen).val());
            
      if(origen!="E" && origen!="I" && origen!="P" && origen!="S" ){
    	  for (var i=1; i<=origen;i++){
         	 vconceptoGeneral =vconceptoGeneral+$('.comboCuenta.partida'+i+' :selected ').text()+" / ";
         }
    	$("#vConceptoGeneral").val(vconceptoGeneral.substring(0,vconceptoGeneral.length-3));
      }
        
      var newHtml='';
    	if(obj.length>0){
    		newHtml+='<option value="00">::SELECCIONE::</option>';
        	$.each(obj,function(key,data){  
                 if(destino=='0')
                    newHtml+='<option value='+data.iElementoCuentasId+'>';
        		else 
        			newHtml+='<option value='+data.iCuentasId+'>';
        			newHtml+=data.vDescripcion;
        		newHtml+='</option>';
        	}); 
        	$("#S"+destino).show();
        	$('.comboCuenta.partida'+destino).html(newHtml).show();
    		
    	}
    	else{
    		$("#S"+destino).hide();
    	}
    	

    		 
        
    };

</script>