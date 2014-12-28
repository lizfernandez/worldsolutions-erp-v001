<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>  
        <title><tiles:getAsString name="title" ignore="true"/></title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.core.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.widget.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.datepicker.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/general.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery-ui.min.js"></script>

    </head>
    <link href="${pageContext.request.contextPath}/media/styles/css/principal.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/css/menu.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/css/tabla.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/css/botones.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/css/paginacion.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/default/jquery-ui-1.7.1.custom.css" rel="stylesheet" type="text/css"  />
    <link href="${pageContext.request.contextPath}/media/styles/css/formulario.css"rel="stylesheet" type="text/css"  />
    <link href="${pageContext.request.contextPath}/media/styles/css/jquery-ui-multiselect-widget.css"rel="stylesheet" type="text/css"  />
   
    <body>
        <table class="tabla" border="0" width="100%" id="tab-grupo">
            <caption id="popupCabecera"></caption>
             <tbody>
                <tiles:insert attribute="body"/>
            </tbody>
        </table>
      </body>
</html>