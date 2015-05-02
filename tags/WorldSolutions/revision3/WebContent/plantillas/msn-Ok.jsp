<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<head>
    <title>.:: MENSAJE ::.</title>
    <link rel="stylesheet" href="w_estilos.css" type="text/css"/>
</head>
<body oncontextmenu="return false" onkeydown="return false" topmargin="0" leftmargin="0">
    <script>
        var limit="0:2"
        if (document.images){
            var parselimit=limit.split(":")
            parselimit=parselimit[0]*60+parselimit[1]*1
        }

        function begintimer(){
            if (!document.images)
                return

            if (parselimit==1) {
                var flag = "<?php echo $this->codigo ?>";
                var id = "<?php echo $this->id ?>";
                var tipo = "<?php echo $this->tipo ?>";
                /**
                 * Parametros para letras en masivo.
                 * idCliente, cantLetras
                 */
                var idCliente = "<?php echo $this->idCliente ?>";
                var cantLetras = "<?php echo $this->cantLetras ?>";
                var mode = "<?php echo $this->mode?>";
                var guardar = "";
                if (flag == "C") {
                    if(confirm("Se va a imprimir la venta\nDesea guardar la venta?")) {
                        guardar = "/guardar/1";
                    }
                    if(tipo=="Letras" && mode!='D') document.location.href = "<?php echo $this->baseUrl('/reportes/pdf/pdfreportes/tipo/imprimir_letras/id/')?>"+id+"/idCliente/"+idCliente+"/cantLetras/"+cantLetras;
                    if(tipo=="factura") document.location.href = "<?php echo $this->baseUrl('/reportes/pdf/pdfreportes/tipo/1/id/')?>"+id+guardar;
                    if(tipo=="boleta") document.location.href = "<?php echo $this->baseUrl('/reportes/pdf/pdfreportes/tipo/2/id/')?>"+id+guardar;
                    if(tipo=="nota") document.location.href = "<?php echo $this->baseUrl('/reportes/pdf/pdfreportes/tipo/3/id/')?>"+id+guardar;
                    if(tipo=="guia") document.location.href = "<?php echo $this->baseUrl('/reportes/pdf/pdfreportes/tipo/4/id/')?>"+id+guardar;
                    if(tipo=="pedido") document.location.href = "<?php echo $this->baseUrl('/reportes/pdf/pdfreportes/tipo/5/id/')?>"+id+guardar;
                    setTimeout("cerrarVentana()",2000);
                } else {
                    window.opener.document.location.reload();
                    window.close();
                }
            }
            else{
                parselimit-=1
                curmin=Math.floor(parselimit/60)
                cursec=parselimit%60
                if (curmin!=0)
                    curtime=curmin+" minutes and "+cursec+" seconds left"
                else
                    curtime=cursec+" segundos"
                window.status=curtime
                setTimeout("begintimer()",1000);
            }
        }

        function cerrarVentana(){
            window.close();
        }

        begintimer()
    </script>
    <table border="0" cellpadding="0" cellspacing="0" width="100%"  height="100%"style="border: 1 solid #336699">
        <tr>
            <td style="font-family: Verdana; font-size: 8 pt; color: #FFFFFF; font-weight: bold" bgcolor="#336699" height="10%" colspan="3">&nbsp;Mensaje...</td>
        </tr>
        <tr>
            <td width="80%" height="90%" rowspan="2"><p align="center">
                <p align="center"><b><font color="#336699" size="3">OPERACION CON EXITO</font></b>
                <p></td>
            <td width="20%"></td>
        </tr>
        <tr>
            <td width="307"><img border="0" src="${pageContext.request.contextPath}/media/images/CHECKB.GIF" width="32" height="32"></td>
        </tr>
    </table>
</body>
