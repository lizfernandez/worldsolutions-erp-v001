
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div id="ykLoginRight">
	<div class="nameCompany">
	<img align="top" alt="Login" src="${pageContext.request.contextPath}/media/styles/default/graphics/img_loginTitle.png">
	Bienvenidos
	</div>
	<div id="ykLoginTop"></div>
	<div id="ykLoginContent">
		<p align="center">
			<img alt="Subtitulo" src="${pageContext.request.contextPath}/media/styles/default/graphics/img_loginSubtitle.png">
		</p>
		<p class="msgLoginError" id="m_advertencia"></p>
		<html:form action="login" styleId="formLogin">
			<dl class="zend_form">
				<dt id="login-label">&nbsp;</dt>
				<dd id="login-element">
					<fieldset id="fieldset-login">
						<dl>
						
							<div class="fields">
								<label class="label required" for="email">Usuario :</label>
								<html:text property="vUsuarioLogin" styleId="vUsuarioLogin" onkeyup="return mayuscula('vUsuarioLogin')" styleClass="text"/>
							    <span id="m_vUsuarioLogin" class="importante">*</span>
							</div>
							<div class="fields">
								<label class="label required" for="clave">Clave :</label>
								<html:text property="vUsuarioPassword" styleId="vUsuarioPassword"  styleClass="text" />
       							<span id="m_vUsuarioPassword" class="importante">*</span>
							</div>
						</dl>
					</fieldset>
				</dd>
				<span>
				   <button onclick="insertar('formLogin')" class="btnLogin">Ingresar</button>
					<!-- input id="enviar" class="btnLogin" type="button" value="Ingresar" name="enviar" onclick="insertar('formLogin')"> -->
				</span>
				<br>
     				<span id="m_mensaje" class="mensaje"></span>
     			 <br>
			</dl>
			<%-- hidden field que contiene el mode --%>
			<html:hidden property="mode" styleId="mode"  />
			
			<%-- hidden field que contiene el mode --%>
			<html:hidden property="mensaje" styleId="mensaje"  />
						
			<%-- set the parameter for the dispatch action --%>
			<html:hidden property="metodo" value="login" styleId="metodo" />
		</html:form>
	</div>
	<div id="ykLoginBottom"></div>
	<p class="footLogin">
		Olvidaste tu clave? da clic
		<a href="login.do?metodo=restablecer">Aqui</a>
	</p>
	<p class="footLogin">&copy; Copyright 2010. Todos los derechos reservados.</p>
</div>
<script>
var mensaje = $("#mensaje").val();
var mode = $("#mode").val();

  if(mensaje!=""){
    	 $("#"+mode).show().text(mensaje);
    }
var originalBtn = $("#vUsuarioPassword");
var newBtn = originalBtn.clone();
newBtn.attr("type", "password");
newBtn.insertBefore(originalBtn);
originalBtn.remove();
newBtn.attr("id", "vUsuarioPassword");


</script>