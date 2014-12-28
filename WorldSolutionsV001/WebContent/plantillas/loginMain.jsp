<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>


<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
   <title><tiles:getAsString name="title" ignore="true"/></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/jquery.ui.datepicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/media/scripts/general.js"></script>
    <link href="${pageContext.request.contextPath}/media/styles/default/default.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/media/styles/css/botones.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/media/styles/css/formulario.css"rel="stylesheet" type="text/css"  />
  </head>
  <body class="bgBodyLogin">
    <div id="ykWrapper">
      <div id="ykLogin">
        <div id="ykLoginLeft">
          <div class="loginLogo">&nbsp;</div>
        </div>
        <tiles:insert attribute="logueo"/> 
      </div>
    </div>
  </body>
</html>
