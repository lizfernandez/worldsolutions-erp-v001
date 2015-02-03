
/*$(document).keydown(function(tecla){
	alert(tecla.keyCode);
		    if (tecla.shiftKey && tecla.keyCode==78) { 
		    	alert("nuevo doc");
		    }else if(tecla.keyCode == 83) { 
		        $('.s').css({ 'background-color' : 'blue' });
			}else if(tecla.keyCode == 68){
		        $('.d').css({ 'background-color' : 'green' });
			}
		});
*/
$(document).keyup( function (e) {
	   
//	alert("e ="+e+" e.which  ="+e.which )
    if (e.which === 78 && e.shiftKey) { 
    	nuevo();
    }
    else if(e.which === 70 && e.shiftKey) { 
    	buscar();
	}
});
$( ".text" ).focus(function() {
	  alert( "Handler for .focus() called." );
	});

$(window).resize(function() {
	 var windowWidth = $(window).width();
	 var menuVerticalWidth=$(".menuVertical").width();
     var windowWidthpor=windowWidth-menuVerticalWidth-8;
 //  alert(windowWidth+" "+ menuVerticalWidth);
    // alert("windowWidth? "+windowWidth+" windowWidthpor="+windowWidthpor +"(windowWidth-windowWidthpor)/10 =" +((windowWidth-windowWidthpor)/10));
     
  //   if(windowWidthpor<844)windowWidthpor=844;
     $("#listado").css({ width: windowWidthpor });
     
     
});

$(document).ready(function(){
	$(".btn_admin").click(function() {
		location.href = $("#"+this.id+" a").attr('href');
	});
        $('#vUsuarioPassword').click(function(){
    		  $(this).get(0).type='password';
    		});
    	    	
       
               /*$('#dock2').Fisheye(
        {
            maxWidth: 30,
            items: 'a',
            itemsText: 'span',
            container: '.dock-container2',
            itemWidth: 50,
            proximity: 90,
            alignment : 'left',
            valign: 'bottom',
            halign : 'left'
        }
        ) */
    }
    );

function menu(valor,base,url){
    var i=1;
    for(i;i<=10;i++)	{
        if(valor==i){
            $('#cont'+valor).slideDown('slow');
            $('#div'+valor).removeClass('boton').addClass('botonActivo');
            $('#contenido').load("modulo/"+base+"/view/"+url);
        }
        else{
            $('#cont'+i).slideUp('slow');
            $('#div'+i).removeClass('botonActivo').addClass('boton');
        }
		 
    }
}
function subMenuOpciones(id){
	for(var i=1;i<=2;i++){
		if(i==id){
			$("#tabla"+i).show();
			$("#span"+i).removeClass("btnOpciones").addClass("btnOpcionesActivo");	
			
		}
		else{
			$("#tabla"+i).hide();
			$("#span"+i).removeClass("btnOpcionesActivo").addClass("btnOpciones");
		}
		
	}
	
}
function fn_acceso(item){
	alert("No tiene acceso a "+item+ ",\nComuniquese con el administrador!!");
	
}
function menuVertical(){
    var stylo=$(".menuVertical").css("display");
    if(stylo=="none"){
        $(".menuVertical").show();
        $("#btns").removeClass('btnSalida')
        $("#btns").addClass('btnEntrada');
        $("#listado").css("width","83%");
		
    }
    else{
        $(".menuVertical").hide();
        $("#btns").removeClass('btnEntrada')
        $("#btns").addClass('btnSalida');
        $("#listado").css("width","99%");
    }

}

function submenu(id){
 $(".cont ul").children('li').height("0px").hide();
 
 $("#"+id).children('li').show().animate({height: "20px"}, 500);/*.slideDown()*/
  
}
	

var newwindow;

/*function popup(url,width,heigth){
	alert(url+" "+width+" "+heigath)
	//popup('proveedor.do?metodo=mantenimientoProveedor&mode=I',350,350)
    transp=document.getElementById("transp");
    transp.style.display='block';
    	newwindow=window.open("view/"+url,'name','height=400,width=200');
	if (window.focus) {newwindow.focus()}
    window.showModalDialog(+url,"Dialogo","dialogWidth:"+width+"px;dialogHeight:"+heigth+"px;center:yes;estatus:off;");
    if(window.close){
        cancelar("popup");
    }
}
*/

function cancelar(opcion){
	
    if(opcion=="popup"){
        var transp=document.getElementById("transp");
        transp.style.display='none';
    }
    else{
    
    	window.location.reload(false);    
        window.close();
       }
}


function insertar(form){
	var error=0; 
	
        /** buscamos todos los input del formulario **/
		$(document).find('#'+form+' input:text.text, select.combo, input:password.text').each(function(key,val){ 	 
		      if(($.trim(this.value)=='' &&  $("#m_"+this.id).text()=="*" )||
		    	 ($.trim(this.value)=='' &&  $("#m_"+this.id).text()=='' ) ||
		         ($.trim(this.value)=='0.0' &&  $("#m_"+this.id).text()=='*' ) ||
		    //	 ($("#m_"+this.id).text()=="*" && $.trim(this.value)=='0') ||
		    //	 ($("#m_"+this.id).text()=="*" && $.trim(this.value)=='0.0') ||
		    	 this.value=='00'){
		    	  
		    	 error+=1;
		    	 
		    	  $("#m_"+this.id).css("display","block").text("*");
		    	  $("#"+this.id).addClass("error");
		    	   
		    	  
		    	  //clase=text; clase=error
                  //añadimos error al input
		    	  
			  	}
		    	else{
		    		
		    		$("#m_"+this.id).text("").hide();
		    		$("#"+this.id).removeClass("error");
		    	}
		      
			   $('input.text.error:first').focus();
	    	   $('select.combo.error:first').focus();
	    	   
		
		   });
		
	
 $("form").submit(function() {
	if(error==0){ // Cero errores.
	
	 $(".mensaje").text("").hide();
	 $("#btnGuardar").attr("disabled",true);	
	 //$("#formMantenimiento").attr("action", "/ControllerName/Method");
	 //$("#formMantenimiento").submit();
	// $("form").submit();
	 // return true;
	 this.submit();
	}
	else{
		
		$(".mensaje").text("Debe ingresar los datos que contienen *").show();
		    return false;	
    	}

	});
  
}

/**Realiza la busqueda***/
function buscar(form){
	var s = window.opener.document.location.search;
	var l=  s.split("?");
	var metodo = l[1].split("&");
	//alert(metodo[0]);
	var valor="";
	 /** buscamos todos los input del formulario **/
	$(document).find('#'+form+' input:text, input:text.textInvisible, select.combo').each(function(key,val){ 	 
	      if($.trim(this.value)!=''){
	    	  valor = valor+"&"+this.id+"="+this.value;
	    	 
	    	}	    	
	   });
	
	
	$("form").submit(function() {
		//metodo = $("#metodo").val();// obtenemos el metodo ejm=buscarPerfil;
		//redireccionamos al padre los valores, sin hacer doble recarga por el return false;
		window.opener.document.location.search = metodo[0]+valor;
		//window.opener.document.location.search = "metodo="+metodo+valor+"&pagina=1";
		window.close();
	    return false;
	});
    // 
}
function limpiar(id){
	$(document).find('#'+id+' input:text, input:text.textInvisible').each(function(key,val){ 	 
	     $(this).val(" ");
	    	     	
	   });
}
/**Realiza la busqueda popup***/
function buscarPopup(form){
	var valor="";
	 /** buscamos todos los input del formulario **/
	$(document).find('#'+form+' input:text, input:text.textInvisible, select.combo').each(function(key,val){ 	 
	      if($.trim(this.value)!=''){
	    	  valor = valor+"&"+this.id+"="+this.value;
	    	 
	    	}	    	
	   });
	
	
	$("form").submit(function() {
		metodo = $("#metodo").val();// obtenemos el metodo ejm=buscarPerfil;
		//redireccionamos al padre los valores, sin hacer doble recarga por el return false;
		window.document.location.search = "metodo="+metodo+valor;
		//window.opener.document.location.search = "metodo="+metodo+valor+"&pagina=1";
		//window.close();
	    return false;
	});
    // 
}
function pdf(){
	var url= window.document.location.href;
	var mode="&mode=pdf"
	window.document.location.href=url+mode;
	//window.document.location.search = "metodo="+metodo;
}
function paginator(pagina){
	
   var url= window.document.location.href;
   var posicion = url.lastIndexOf("&pagina="); 
   var nuev ="";
   if(posicion==-1){
	   nuev=url.substring(0,url.length);  
   }
   else{
	   nuev=url.substring(0,posicion);  
   }
    window.document.location.href= nuev+"&pagina="+pagina;
   
}
	function next(){
		 $("#Next").css("display","block").click(function() {paginator(pagina+1); });
		 for(var i=paginar+1; i<=size; ++i){
			 $("#pg_"+i).css("display","none");
		 }
	}
	
function paginacion(){
	
	var pagina = parseInt($("#pagInicio").val());
	var size = parseInt($("#size").val());
	var paginar = parseInt(5);
	var numero=(pagina-1);
	
	$(".btnPagActivo").addClass("btnPagInactivo");
	//if(((pagina-1)%paginar)==0){		 
		 numero =parseInt((pagina-1)/paginar);
		 pag=pagina;
		
		
		
	 //}
	//alert(" numero ="+numero+" pagina= "+pagina);
	for(var i=(1+paginar*numero);i<=paginar*(numero+1);i++){
			$("#pg_"+i).css("display","block");
	 }
	
	$("#pg_"+pagina).removeClass("btnPagInactivo");
	$("#pg_"+pagina).addClass("btnPagActivo");
	 
	 
	 if(size>paginar){ //8:3
		 $("#Next").css("display","block").click(function() {paginator(pagina+1); });
		 $("#Final").css("display","block").click(function() {paginator(size); });
	     		
		 if(pagina>paginar){////4:3  6:3			 
			 $("#back").css("display","block").click(function() {paginator(parseInt(pagina)-1); });
			 $("#principio").css("display","block").click(function() {paginator(1); });
			 if(pagina==size)
			   $("#Next,#Final").css("display","none");
    	 }
		
	 }
	 else{
		 $("#back,#Next").css("display","none");
	 }
	
}



function popup(url,width,heigth){   
	
	var transp=document.getElementById("transp");
	transp.style.display='block';
    window.showModalDialog(url,"Dialogo","dialogWidth:"+width+"px;dialogHeight:"+heigth+"px;center:yes;");
    if(window.close){
        cancelar("popup");
    }
    
}
/**/
function popupModal(url,width,heigth){
    window.showModalDialog(url,"Dialogoff","dialogWidth:"+width+"px;dialogHeight:"+heigth+"px;center:yes;");
    if(window.close){
        cancelar("popup");
    }
}



function busqueda(url, flag){
  nombre=$("#txtnombre").val();
  cadena='';
  if(flag == '1') {
    producto=$("#selTipo").val();
    cadena = '/producto/'+producto;
  }
  window.document.location.href=url+nombre+cadena;
}


function retornar(txtid,id,txtcod,cod,txtnom,nom,txtsueldo,sueldo,txtocup,ocup){

   window.opener.document.getElementById(txtid).value=id;/**/
   window.opener.document.getElementById(txtcod).value=cod;
   window.opener.document.getElementById(txtnom).value=nom;
   
   window.opener.document.getElementById(txtsueldo).value=sueldo;
   window.opener.document.getElementById(txtocup).value=ocup;
   
   window.close();
}
function retornarProv(txtid,id,txtcod,cod,txtnom,nom,txtruc, ruc, txtdir, dir, txtdir2){

	   window.opener.document.getElementById(txtid).value=id;/**/
	   window.opener.document.getElementById(txtcod).value=cod;
	   window.opener.document.getElementById(txtnom).value=nom;
	   window.opener.document.getElementById(txtruc).value=ruc;
	   window.opener.document.getElementById(txtdir).value=dir;
	   window.opener.document.getElementById(txtdir2).value=dir;
	  // $('#'+txtdir,window.opener.document).val(dir);
	 //  $("input[type='text'][name='"+txtdir+"']"+txtdir,window.opener.document).val(dir); 
	   
	 //  alert('svfs');
	   window.close();
	  // return false;
	  
	  /* $("form").submit(function() {
	    	alert('hola');
	    	 window.close();return false;	
	    	});*/
	   $('button').click(function(){
	        // code to cancel changes
	        return false;
	    });
	}
 function mayuscula(id) {
     $("#"+id).val( $("#"+id).val().toUpperCase()); 
    }
 
function LimpiaCar(num,nom,fname)
    {
        num=num.toUpperCase();
      //  this.num=Trim(num);
    this.num=BorCarEsp(this.num)
   // eval("document."+fname+"[nom].value=this.num");
    }

function LetrasNumeros(e) {
    tecla = (document.all)?e.keyCode:e.which;
    if (tecla==8) return true; 
    patron = /\w/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
    
  }
  function Letras(e) {
    tecla = (document.all)?e.keyCode:e.which;
    if (tecla==8) return true; // 3
    patron =/[A-Za-zñÑ\s]/;
    te = String.fromCharCode(tecla);
    
    return patron.test(te);
  }
   function Numeros(e) {
   
	   tecla = (document.all)?e.keyCode:e.which;
	   if (tecla==8||tecla==13||tecla==46){ return true;
	   }if(48<=tecla && tecla<=57){
	   patron = /[\d.-_-]/;/*/\d/;*/
	   te = String.fromCharCode(tecla);
	   return patron.test(te);
	   }
	   else{
	   //  window.alert('Sólo se aceptan números');
	   return false;
	   }
	  /* 
	   tecla = (document.all) ? e.keyCode : e.which; // 2
    if (tecla==8) return true; // 3
    patron =/[\d.-_-]/;//patron = /\d/; // 4
    te = String.fromCharCode(tecla); // 5
    return patron.test(te); // 6
*/
  }
function BorCarEsp(num)
    {
        expreg=/[@_:;<>Â°!"#$%=?Â¡Â¿'*\~{}\[\]{\\^`|Â¬Â´Â¨]/g;
    this.num=num.replace(expreg,"");
    return this.num;
    }

function eliminar(form,idform,URL) {
	var id="";
	var reg="";
	
	if(idform!='')
	{   $(":input").attr("checked",false);
		$("#"+idform).attr("checked",true);
		  id= id+idform+","; 
		  reg="registro?";
	}
	else{
		$(document).find('#'+form+' input, checkbox').each(function(key,val){
	    if($("#"+this.id).is(":checked"))	     	
	      { id= id+this.id+","; 	        
	      }  		
	    });
		reg="registros?";
	}		
	var ids= id.substring(0,(id.length)-1);
	if(ids!=''){
		if (confirm('Esta seguro que desea ELIMINAR '+reg)){
			$.ajax({
		        type: "GET",
		        url:URL+"&ids="+ids,
		        success: function(obj){
		        	 window.document.location.reload();
		        	// $(":input").attr("checked",false);
	                
		        }
		    });
		}
	}
	else{
		alert("Debe de seleccionar al menos un registro")
	}
	
}
function formatCurrency(num,simbolo)
{
	num = num.toString().replace(/\$|\,/g,'');	
	if (isNaN(num))
	num = '0';
	
	var signo = (num == (num = Math.abs(num)));
	num = Math.floor(num * 100 + 0.50000000001);
	centavos = num % 100;
	num = Math.floor(num / 100).toString();
	
	if (centavos < 10)
	centavos = '0' + centavos;
	
	for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
	num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
	
	return (((signo) ? '' : '-') + simbolo  + num + '.' + centavos);
}
function dosDecimales(num){
	num=Math.round(num * 100) / 100;
	return num;
}
function numeroFloat(num){
	return num.replace(",", "");
	
}
//CARGAMOS EL detalle de la venta
function listar_detalleVenta(obj,destino){
	var precio =0;		
	var newHtml='';
	newHtml+='<tbody>';
   newHtml+='<tr>';
   newHtml+='<th>&nbsp;</th>';
   newHtml+='<th>CODIGO</th>';
   newHtml+='<th>CANTIDAD</th>';
   newHtml+='<th>UNID.</th>';
   newHtml+='<th width="12%">CAPACIDAD</th>';
   newHtml+='<th>DESCRIPCION</th>';
   newHtml+='<th>P.U.</th>';
   newHtml+='<th>% DESC.</th>';
   newHtml+='<th>TOTAL</th>';
   newHtml+='</tr>';
	$.each(obj,function(key,data){
		if(data.cEstadoCodigo=="AC"){
			if(data.fVentaDetallePrecio!=0)
				precio = data.fVentaDetallePrecio;
			else
				precio = data['producto'].fProductoPrecioVenta;
			//fn_calcularVentasPadre(data.fVentaDetalleTotal,data['producto'].fProductoPrecioVenta, data.iVentaDetalleCantidad)
		newHtml+='<tr>';
		newHtml+="<td><img src='/WorldSolutionsV001/media/imagenes/delete.png' onclick=\"fn_eliminar('"+key+"')\"  /></td>";
		newHtml+='<td>';
			newHtml+=data['producto'].cProductoCodigo;
		newHtml+='</td>';
		newHtml+="<td '>";
		  newHtml+="<input type='text' class='inputderecha' id='numero"+key+"' onBlur=\"fn_calcularTotal('"+key+"','"+data['producto'].iProductoStockCantidad+"')\" value='"+data.iVentaDetalleCantidad+"'/>";
	   newHtml+='</td>';
		newHtml+='<td>';
			newHtml+=data['producto']['unidadMedida'].vUnidadMedidaDescripcion;
	    newHtml+='</td>';
		newHtml+='<td>';
		   if(data['producto'].vUnidadMedidaDescripcionC!=null)
			newHtml+=data['producto'].vProductoCapacidad+" "+data['producto'].vUnidadMedidaDescripcionC;
		   else
			   newHtml+=data['producto'].vProductoCapacidad+"&nbsp;";
		newHtml+='</td>';
		newHtml+='<td>';
			newHtml+=data['producto'].vProductoNombre;
		newHtml+='</td>';		
	    newHtml+="<td align='right'>";
		  newHtml+="<input type='text' class='inputderecha' id='precio"+key+"' onBlur=\"fn_calcularTotal('"+key+"','"+data['producto'].iProductoStockCantidad+"')\" value='"+formatCurrency(precio,' ')+"'/>";		  
	    newHtml+='</td>';
	    newHtml+="<td align='right'>";
		  newHtml+="<input type='text' class='inputderecha' id='descuento"+key+"' onBlur=\"fn_calcularTotal('"+key+"','"+data['producto'].iProductoStockCantidad+"')\" value='"+formatCurrency(data.fDescuento,' ')+"'/>";		  
	    newHtml+='</td>';
	    newHtml+="<td align='right'>";
		   newHtml+="<span class='total"+key+"' >"+formatCurrency(data.fVentaDetalleTotal,' ')+" </span>";
		   newHtml+="<span id='total"+key+"' class='totales' >"+data.fVentaDetalleTotal+" </span>";
		newHtml+='</td>';
		
		newHtml+='</tr>';
		}// if
	});
	 newHtml+='<tr>';
	 newHtml+="<td><img src='/WorldSolutionsV001/media/imagenes/new.png' onclick=\"fn_listarProducto()\"/></td>";
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+=' <td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='</tr>';
newHtml+='</tbody>';
	//$('.combo.Distrito').html(newHtml);

	 if(destino=="padre"){
		 window.opener.document.getElementById("detalle").innerHTML=newHtml;
		 opener.window.fn_calcularTotales(); 
		 window.close();
	 }
		
	 if(destino=="hijo"){
		 document.getElementById("detalle").innerHTML=newHtml;
		 window.fn_calcularTotales(); 
	 }
		 
	
	
//	$('#detalleVenta',window.opener.document).innerHTML=newHtml;
	
};

//CARGAMOS EL detalle de la Compra
function listar_detalleCompra(obj,destino){
    var precio =0;	
	var newHtml='';
	newHtml+='<tbody>';
   newHtml+='<tr>';
   newHtml+='<th>&nbsp;</th>';
   newHtml+='<th>CODIGO</th>';
   newHtml+='<th width="12%">CANTIDAD</th>';
   newHtml+='<th>UNID.</th>';
   newHtml+='<th width="12%">CAPACIDAD</th>';
   newHtml+='<th>DESCRIPCION</th>';
   newHtml+='<th>P.U.</th>';
   newHtml+='<th>% DESC.</th>';
   newHtml+='<th>TOTAL</th>';
   newHtml+='</tr>';
	$.each(obj,function(key,data){
		if(data.cEstadoCodigo=="AC"){
			
			if(data.fIngresoProductoDetallePrecio!=0)
				precio = data.fIngresoProductoDetallePrecio;
			else
				precio = data['producto'].fProductoPrecioCompra;
			
		newHtml+='<tr>';
		newHtml+="<td><img src='/WorldSolutionsV001/media/imagenes/delete.png' onclick=\"fn_eliminar('"+key+"')\"  /></td>";
		newHtml+='<td>';
			newHtml+=data['producto'].cProductoCodigo;
		newHtml+='</td>';
		newHtml+="<td '>";
			  newHtml+="<input type='text' class='inputderecha' id='numero"+key+"' onBlur=\"fn_calcularTotal('"+key+"')\" value='"+data.iIngresoProductoDetalleCantidad+"'/>";
		newHtml+='</td>';
		newHtml+='<td>';
			newHtml+=data['producto']['unidadMedida'].vUnidadMedidaDescripcion;
	    newHtml+='</td>';
		newHtml+='<td>';
		   if(data['producto'].vUnidadMedidaDescripcionC!=null)
			newHtml+=data['producto'].vProductoCapacidad+" "+data['producto'].vUnidadMedidaDescripcionC;
		   else
			   newHtml+=data['producto'].vProductoCapacidad+"&nbsp;";
		newHtml+='</td>';
		newHtml+='<td>';
			newHtml+=data['producto'].vProductoNombre;
		newHtml+='</td>';
		newHtml+="<td align='right'>";
		 newHtml+="<input type='text' class='inputderecha' id='precio"+key+"' onBlur=\"fn_calcularTotal('"+key+"')\" value='"+formatCurrency(precio,' ')+"'/>";		  
	    newHtml+='</td>';	
	    newHtml+="<td align='right'>";
		 newHtml+="<input type='text' class='inputderecha' id='descuento"+key+"' onBlur=\"fn_calcularTotal('"+key+"')\" value='"+formatCurrency(data.fDescuento,' ')+"'/>";		  
	    newHtml+='</td>';
		newHtml+="<td align='right'>";
		   newHtml+="<span class='total"+key+"' >"+formatCurrency(data.fIngresoProductoDetalleTotal,' ')+" </span>";
		   newHtml+="<span id='total"+key+"' class='totales' >"+data.fIngresoProductoDetalleTotal+" </span>";
		newHtml+='</td>';
		
		newHtml+='</tr>';
		}// if
	});
	 newHtml+='<tr>';
	 newHtml+="<td><img src='/WorldSolutionsV001/media/imagenes/new.png' onclick=\"fn_listarProducto()\"/></td>";
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+=' <td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='<td>&nbsp;</td>';
	 newHtml+='</tr>';
newHtml+='</tbody>';
	//$('.combo.Distrito').html(newHtml);

	 if(destino=="padre"){
		 window.opener.document.getElementById("detalle").innerHTML=newHtml;
		 opener.window.fn_calcularTotales(); 
		   window.close();
	 }
		
	 if(destino=="hijo"){	
		 document.getElementById("detalle").innerHTML=newHtml;
		 window.fn_calcularTotales(); 
	 }
	 
	 
	
};

//CARGAMOS EL detalle de la Compra
function listar_detalleCompraDevolucion(obj, destino, fecha){
	var datos='',datos1='',datos2='',datos3='';
	var newHtml='';
	var newHtmlD='';
	var newHtml1='';
	var newHtml2='';
	newHtml+='<tbody>';
   newHtml+='<tr>';
   newHtml+='<th width="5%">&nbsp;</th>';
   newHtml+='<th>CODIGO</th>';
   newHtml+='<th width="12%">CANTIDAD</th>';
   newHtml+='<th>UNID.</th>';
   newHtml+='<th width="12%">CAPACIDAD</th>';
   newHtml+='<th>DESCRIPCION</th>';
   newHtml+='<th>P.U.</th>';
   newHtml+='<th>TOTAL</th>';
   newHtml+='</tr>';
   newHtml1+=newHtml;
   newHtml2+=newHtml;
	
	$.each(obj,function(key,data){
		
		if(data.cEstadoCodigo=="AC"){						
		datos1=fecha+"*"+data['ingresoproducto'].fIngresoProductoIGV+"*"+data['ingresoproducto'].fIngresoProductoSubTotal+"*"+data['ingresoproducto'].fIngresoProductoTotal+"*"+data['ingresoproducto'].nIngresoProductoNumero+"*"; 
	    datos2=data['ingresoproducto']['proveedor'].iProveedorId+"*"+data['ingresoproducto']['proveedor'].cProveedorCodigo+"*"+data['ingresoproducto']['proveedor'].nProveedorNumeroDocumento+"*"+data['ingresoproducto']['proveedor'].vProveedorDireccion+"*"+data['ingresoproducto']['proveedor'].vProveedorRazonSocial+"*";
	    datos3=data['ingresoproducto']['tipodocumento'].iTipoDocumentoGestionId+"*"+data['ingresoproducto']['formaPago'].iFormaPago+"*"+data['ingresoproducto'].vEstadoDocumento;	
			newHtml+='<tr>';
			newHtml1+='<tr>';
			newHtml2+='<tr>';
			newHtmlD='';
			 
			newHtml1+="<td><input type='checkbox' id='check"+key+"' checked='checked' onclick=\"fn_eliminar('"+key+"','1')\"/> </td>";
			newHtml2+="<td id='elim"+key+"'><img src='/WorldSolutionsV001/media/imagenes/delete.png' onclick=\"fn_eliminar('"+key+"','2')\"  /> </td>";
			
			newHtmlD+='<td>';
			  newHtmlD+=data['producto'].cProductoCodigo;
		    newHtmlD+='</td>';
		    
		    newHtml1+=newHtmlD;
			newHtml2+=newHtmlD;
			newHtml+=newHtmlD;
		 
		    newHtml1+="<td>";
		      newHtml1+="<span id='cantidadMax"+key+"'>"+data.iIngresoProductoDetalleCantidad+"</span>";
		    newHtml1+='</td>';
		    
		    newHtml2+="<td  onclick=\"fn_ingresarCantidad('"+key+"','"+data.iIngresoProductoDetalleCantidad+"')\">";
		      newHtml2+="<span id='cantidad"+key+"'>"+data.iIngresoProductoDetalleCantidad+"</span>";
		    newHtml2+='</td>';
		    
		    newHtmlD='';
		
		 
		    newHtmlD+='<td>';
		      newHtmlD+=data['producto']['unidadMedida'].vUnidadMedidaDescripcion;
		    newHtmlD+='</td>';
		    newHtmlD+='<td>';
			   if(data['producto'].vUnidadMedidaDescripcionC!=null)
				   newHtmlD+=data['producto'].vProductoCapacidad+" "+data['producto'].vUnidadMedidaDescripcionC;
			   else
				   newHtmlD+=data['producto'].vProductoCapacidad+"&nbsp;";
		    newHtmlD+='</td>';
		    newHtmlD+='<td>';
		       newHtmlD+=data['producto'].vProductoNombre;
		    newHtmlD+='</td>';
		    newHtmlD+="<td align='right'>";
		       newHtmlD+="<span id='precio"+key+"'>"+formatCurrency(data.fIngresoProductoDetallePrecio,' ')+"</span>";
		    newHtmlD+='</td>';		
		    newHtmlD+="<td align='right'>";
		    
		    newHtml1+=newHtmlD;
			newHtml2+=newHtmlD;
			newHtml+=newHtmlD;
		 
		    
		       newHtml1+="<span class='totalMax"+key+"' >"+formatCurrency(data.fIngresoProductoDetalleTotal,' ')+" </span>";
		      
		       newHtml2+="<span class='total"+key+"' >"+formatCurrency(data.fIngresoProductoDetalleTotal,' ')+" </span>";
		       newHtml2+="<span id='total"+key+"' class='totales' >"+data.fIngresoProductoDetalleTotal+" </span>";
		       newHtmlD='';
		       
		    newHtmlD+='</td>';		
		    newHtmlD+='</tr>';
		    
			newHtml1+=newHtmlD;
			newHtml2+=newHtmlD;
			newHtml+=newHtmlD;
			  
		}// if
	});
	newHtml+='</tbody>';
	newHtml1+='</tbody>';
	newHtml2+='</tbody>';
	//$('.combo.Distrito').html(newHtml);
	//newHtml1=newHtml;
	
	if(destino=="padre"){
		datos=datos1+datos2+datos3;
		var i= datos.split("*");
		
		/***Informacion de la compra**/		
		window.opener.document.getElementById("dIngresoProductoFecha").value=i[0];
		window.opener.document.getElementById("fIngresoProductoIGV").value=formatCurrency(i[1],'');
		window.opener.document.getElementById("fIngresoProductoSubTotal").value=formatCurrency(i[2],'');
		window.opener.document.getElementById("fIngresoProductoTotal").value=formatCurrency(i[3],'');
		window.opener.document.getElementById("fIngresoProductoTotalr").value=i[3];
		
		
		window.opener.document.getElementById("fIngresoProductoDevIGV").value=i[1];
		window.opener.document.getElementById("fIngresoProductoDevSubTotal").value=i[2];
		window.opener.document.getElementById("fIngresoProductoDev").value=i[3];
		
		window.opener.document.getElementById("fIngresoProductoDevIGVr").value=formatCurrency(i[1],'');
		window.opener.document.getElementById("fIngresoProductoDevSubTotalr").value=formatCurrency(i[2],'');
		window.opener.document.getElementById("fIngresoProductoDevr").value=formatCurrency(i[3],'');
		

		window.opener.document.getElementById("nIngresoProductoNumero").value=i[4];
		
		

		/***Informacion del proveedor**/		
		window.opener.document.getElementById("cProveedorCodigo").value=i[6];
		window.opener.document.getElementById("nProveedorNumeroDocumento").value=i[7];
		window.opener.document.getElementById("vProveedorDireccion").value=i[8];
		window.opener.document.getElementById("vProveedorRazonSocial").value=i[9];
		
		/*****/
	//	  $("#iTipoDocumentoId option[value='"+i[10]+"']").attr("selected",true);
		
		 window.opener.document.getElementById("iTipoDocumentoId").value =i[10];
	     window.opener.document.getElementById("iFormaPago").value =i[11];
	     window.opener.document.getElementById("vEstadoDocumento").value = "DEVOLUCION TOTAL";//i[12];
		 
	     window.opener.$("#detalle").html(newHtml1);
	     window.opener.$("#detalleDevolucion").html(newHtml2);		 
		 
		/* window.opener.location.reload(false);
    	 self.close();
       //*/
	     window.close();
	 }
		
	 if(destino=="hijo"){
		// document.getElementById("detalle").innerHTML=newHtml1;
		 document.getElementById("detalleDevolucion").innerHTML=newHtml2;		 
		
	//	 document.getElementById("detalle").innerHTML=newHtml;
	 }	
	 
	
};
function listar_compraLetra(obj, fecha){
	var datos='',datos1='',datos2='',datos3='';
$.each(obj,function(key,data){
		
		if(data.cEstadoCodigo=="AC"){	
			
		/*datos1=fecha+"*"+data['ingresoproducto'].fIngresoProductoIGV+"*"+data['ingresoproducto'].fIngresoProductoSubTotal+"*"+data['ingresoproducto'].fIngresoProductoTotal+"*"+data['ingresoproducto'].nIngresoProductoNumero+"*"; 
	    datos2=data['ingresoproducto'].iIngresoProductoId+"*"+data['ingresoproducto']['proveedor'].iProveedorId+"*"+data['ingresoproducto']['proveedor'].cProveedorCodigo+"*"+data['ingresoproducto']['proveedor'].nProveedorNumeroDocumento+"*"+data['ingresoproducto']['proveedor'].vProveedorDireccion+"*"+data['ingresoproducto']['proveedor'].vProveedorRazonSocial+"*";
	    datos3=data['ingresoproducto']['tipodocumento'].iTipoDocumentoGestionId+"*"+data['ingresoproducto']['formaPago'].iFormaPago+"*"+data['ingresoproducto'].vEstadoDocumento;
	    datos=datos1+datos2+datos3;
		var i= datos.split("*");*/
	    /***Informacion del proveedor**/
		window.opener.document.getElementById("fIngresoProductoTotal").value=data['ingresoproducto'].fIngresoProductoTotal;
		window.opener.document.getElementById("nIngresoProductoNumero").value=data['ingresoproducto'].nIngresoProductoNumero;
		window.opener.document.getElementById("iIngresoProductoId").value=data['ingresoproducto'].iIngresoProductoId;
		window.opener.document.getElementById("iProveedorId").value=data['ingresoproducto']['proveedor'].iProveedorId;
		window.opener.document.getElementById("cProveedorCodigo").value=data['ingresoproducto']['proveedor'].cProveedorCodigo;
		window.opener.document.getElementById("nProveedorNumeroDocumento").value=data['ingresoproducto']['proveedor'].nProveedorNumeroDocumento;		
		window.opener.document.getElementById("vProveedorRazonSocial").value=data['ingresoproducto']['proveedor'].vProveedorRazonSocial;
		
		/*****/
		 window.opener.document.getElementById("iTipoDocumentoId").value =data['ingresoproducto']['tipodocumento'].iTipoDocumentoGestionId;
	     window.opener.document.getElementById("iFormaPago").value =data['ingresoproducto']['formaPago'].iFormaPago;
	  	}
});
window.close();
}

function listar_ventaLetra(obj, fecha){
	
$.each(obj,function(key,data){
		
		if(data.cEstadoCodigo=="AC"){				
	
	    /***Informacion del proveedor**/
		window.opener.document.getElementById("fVentaTotal").value=data['venta'].fVentaTotal;
		window.opener.document.getElementById("nVentaNumero").value=data['venta'].nVentaNumero;
		window.opener.document.getElementById("iVentaId").value=data['venta'].iVentaId;
		window.opener.document.getElementById("iClienteId").value=data['venta']['cliente'].iClienteId;
		window.opener.document.getElementById("vClienteCodigo").value=data['venta']['cliente'].vClienteCodigo;
		window.opener.document.getElementById("nClienteNumeroDocumento").value=data['venta']['cliente'].nClienteNumeroDocumento;		
		window.opener.document.getElementById("vClienteRazonSocial").value=data['venta']['cliente'].vClienteRazonSocial;
		
		/*****/
		 window.opener.document.getElementById("iTipoDocumentoId").value =data['venta']['tipoDocumento'].iTipoDocumentoGestionId;
	     window.opener.document.getElementById("iFormaPago").value =data['venta']['formaPago'].iFormaPago;
	  	}
});
window.close();
}

//CARGAMOS EL detalle de la venta
function listar_detalleVentaDevolucion(obj, destino, fecha, direccion){
	var datos='',datos1='',datos2='',datos3='';
	var newHtml='';
	var newHtmlD='';
	var newHtml1='';
	var newHtml2='';
	newHtml+='<tbody>';
   newHtml+='<tr>';
   newHtml+='<th width="5%">&nbsp;</th>';
   newHtml+='<th>CODIGO</th>';
   newHtml+='<th width="12%">CANTIDAD</th>';
   newHtml+='<th>UNID.</th>';
   newHtml+='<th width="12%">CAPACIDAD</th>';
   newHtml+='<th>DESCRIPCION</th>';
   newHtml+='<th>P.U.</th>';
   newHtml+='<th>% DESC.</th>';
   newHtml+='<th>TOTAL</th>';
   newHtml+='</tr>';
   newHtml1+=newHtml;
   newHtml2+=newHtml;
	
	$.each(obj,function(key,data){
		if(data.cEstadoCodigo=="AC"){						
		datos1=fecha+"*"+data['venta'].fVentaIGV+"*"+data['venta'].fVentaTotal+"*"+data['venta'].fVentaTotal+"*"+data['venta'].nVentaNumero+"*"; 
	    datos2=data['venta']['cliente'].iClienteId+"*"+data['venta']['cliente'].vClienteCodigo+"*"+data['venta']['cliente'].nClienteNumeroDocumento+"*"+direccion+"*"+data['venta']['cliente'].vClienteRazonSocial+"*";
	    datos3=data['venta']['tipoDocumento'].iTipoDocumentoGestionId+"*"+data['venta']['formaPago'].iFormaPago+"*"+data['venta'].vEstadoDocumento;	
			newHtml+='<tr>';
			newHtml1+='<tr>';
			newHtml2+='<tr>';
			newHtmlD='';
			 
			newHtml1+="<td><input type='checkbox' id='check"+key+"' checked='checked' onclick=\"fn_eliminar('"+key+"','1')\"/> </td>";
			newHtml2+="<td id='elim"+key+"'><img src='/WorldSolutionsV001/media/imagenes/delete.png' onclick=\"fn_eliminar('"+key+"','2')\"  /> </td>";
			
			newHtmlD+='<td>';
			  newHtmlD+=data['producto'].cProductoCodigo;
		    newHtmlD+='</td>';
		    
		    newHtml1+=newHtmlD;
			newHtml2+=newHtmlD;
			newHtml+=newHtmlD;
		 
		    newHtml1+="<td>";
		      newHtml1+="<span id='cantidadMax"+key+"'>"+data.iVentaDetalleCantidad+"</span>";
		    newHtml1+='</td>';
		    
		    newHtml2+="<td align='right'>";
		      newHtml2+="<input type='text' class='inputderecha' id='numero"+key+"' onBlur=\"fn_calcularTotal('"+key+"')\" value='"+data.iVentaDetalleCantidad+"'/>";
		     newHtml2+='</td>';
		    
		  
		    newHtmlD='';
		
		 
		    newHtmlD+='<td>';
		      newHtmlD+=data['producto']['unidadMedida'].vUnidadMedidaDescripcion;
		    newHtmlD+='</td>';
		    newHtmlD+='<td>';
			   if(data['producto'].vUnidadMedidaDescripcionC!=null)
				   newHtmlD+=data['producto'].vProductoCapacidad+" "+data['producto'].vUnidadMedidaDescripcionC;
			   else
				   newHtmlD+=data['producto'].vProductoCapacidad+"&nbsp;";
		    newHtmlD+='</td>';
		    newHtmlD+='<td>';
		       newHtmlD+=data['producto'].vProductoNombre;
		    newHtmlD+='</td>';
		    newHtmlD+="<td align='right'>";
		       newHtmlD+="<span id='precio"+key+"'>"+formatCurrency(data.fVentaDetallePrecio,' ')+"</span>";
		    newHtmlD+='</td>';	
		    newHtmlD+="<td align='right'>";
		       newHtmlD+="<span id='descuento"+key+"'>"+formatCurrency(data.fDescuento,' ')+"</span>";
		    newHtmlD+='</td>';
		    newHtmlD+="<td align='right'>";
		    
		    newHtml1+=newHtmlD;
			newHtml2+=newHtmlD;
			newHtml+=newHtmlD;
		 
		    
		       newHtml1+="<span class='totalMax"+key+"' >"+formatCurrency(data.fVentaDetalleTotal,' ')+" </span>";
		      
		       newHtml2+="<span class='total"+key+"' >"+formatCurrency(data.fVentaDetalleTotal,' ')+" </span>";
		       newHtml2+="<span id='total"+key+"' class='totales' >"+data.fVentaDetalleTotal+" </span>";
		       newHtmlD='';
		       
		    newHtmlD+='</td>';		
		    newHtmlD+='</tr>';
		    
			newHtml1+=newHtmlD;
			newHtml2+=newHtmlD;
			newHtml+=newHtmlD;
			  
		}// if
	});
	newHtml+='</tbody>';
	newHtml1+='</tbody>';
	newHtml2+='</tbody>';
	//$('.combo.Distrito').html(newHtml);
	//newHtml1=newHtml;
	
	if(destino=="padre"){
		datos=datos1+datos2+datos3;
		var i= datos.split("*");
		
		/***Informacion de la compra**/		
		window.opener.document.getElementById("dVentaFecha").value=i[0];
		window.opener.document.getElementById("fVentaIGV").value=formatCurrency(i[1],'');
		window.opener.document.getElementById("fVentaSubTotal").value=formatCurrency(i[2],'');
		window.opener.document.getElementById("fVentaTotal").value=formatCurrency(i[3],'');
		window.opener.document.getElementById("fVentaTotalr").value=i[3];
		
		
		window.opener.document.getElementById("fVentaDevIGV").value=i[1];
		window.opener.document.getElementById("fVentaDevSubTotal").value=i[2];
		window.opener.document.getElementById("fVentaDev").value=i[3];
		
		window.opener.document.getElementById("fVentaDevIGVr").value=formatCurrency(i[1],'');
		window.opener.document.getElementById("fVentaDevSubTotalr").value=formatCurrency(i[2],'');
		window.opener.document.getElementById("fVentaDevr").value=formatCurrency(i[3],'');
		

		window.opener.document.getElementById("nVentaNumero").value=i[4];
		
		

		/***Informacion del proveedor**/		
		window.opener.document.getElementById("vClienteCodigo").value=i[6];
		window.opener.document.getElementById("nClienteNumeroDocumento").value=i[7];
		window.opener.document.getElementById("vClienteDireccion").value=i[8];
		window.opener.document.getElementById("vClienteRazonSocial").value=i[9];
		
		/*****/
	//	  $("#iTipoDocumentoId option[value='"+i[10]+"']").attr("selected",true);
		
		 window.opener.document.getElementById("iTipoDocumentoId").value =i[10];
	     window.opener.document.getElementById("iFormaPago").value =i[11];
	     window.opener.document.getElementById("vEstadoDocumento").value = "DEVOLUCION TOTAL";//i[12];
		 
		 window.opener.document.getElementById("detalle").innerHTML=newHtml1;
		 window.opener.document.getElementById("detalleDevolucion").innerHTML=newHtml2;		 
		 window.close();
	 }
		
	 if(destino=="hijo"){
		// document.getElementById("detalle").innerHTML=newHtml1;
		 document.getElementById("detalleDevolucion").innerHTML=newHtml2;		 
		
	//	 document.getElementById("detalle").innerHTML=newHtml;
	 }	
	 

	
};
function fn_exportarExcel(urlmetodo){
	var s = window.document.location.search;
	var l=  s.split("?");
	var metodo = l[1].split("&");
	var nuev=l[1].substring(metodo[0].length,l[1].length);  
	
	popup(urlmetodo+''+nuev,350,220);
};


