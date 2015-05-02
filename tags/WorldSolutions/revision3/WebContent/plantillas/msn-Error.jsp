<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<html>
<link href="css/scaf.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style><head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>.:: MENSAJE DE ERROR ::.</title>
    </head>
    <body oncontextmenu="return false">
    <table width="100%" height="100%" border="1" cellspacing="0" style="border: 1 solid #336699">
      <tr>
        <td style="font-family: Verdana; font-size: 8 pt; color: #FFFFFF; font-weight: bold" bgcolor="#336699" height="10%" colspan="3">&nbsp;Mensaje...</td>
      </tr>
      <tr>
        <td width="20%" height="17%" ><img src="${pageContext.request.contextPath}/media/images/error.gif" width="93" height="94"></td>
        <td width="80%" height="73%" colspan="2" class="textoRequerido" ><p align="center"><font color="#336699" size="3">ERROR EN REGISTRAR</font></p>
        <p align="center" class="textoRequerido"><a href="javascript:window.history.back()"><img src="${pageContext.request.contextPath}/media/images/right42.gif" name="imgright" width="22" height="23" border="0" id="imgright"></a> Retroceder</p></td>
      </tr>
    </table>
    </body>
</html>