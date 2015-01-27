       
        <div  class="btn_admin" id="sucursal" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="sucursal.do?metodo=listaSucursal">MANT. DE SUCURSAL</a>
       </div>
        <div  class="btn_admin" id="area" >
        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
        <a href="area.do?metodo=listaArea">MANT. DE AREA</a>
       </div>
       <div class="btn_admin" id="perfil">
           <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
           <a href="perfil.do?metodo=listaPerfil">MANT. DE PERFIL</a>
       </div>
      <div class="btn_admin" id="ocupacion">
           <img src="${pageContext.request.contextPath}/media/imagenes/cate.png" width="20" height="20" />
           <a href="ocupacion.do?metodo=listaOcupacion">MANT. DE OCUPACION</a>
       </div>
      
       <div class="btn_admin" id="personal">
       <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
        <a href="personal.do?metodo=listaPersonal" > MANT. DE PERSONAL</a>
       </div>
       <div class="btn_admin" id="usuarios">
       <img src="${pageContext.request.contextPath}/media/imagenes/cli.png" width="20" height="20" />
        <a href="usuario.do?metodo=listaUsuario">MANT. DE USUARIOS</a>
       </div>
       <div class="btn_admin" id="permisos">
       <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
        <a href="perfil.do?metodo=listaPermisos">MANT. DE PERMISOS</a>
       </div>
       <div id ="cont2" class="cont">
		        <ul id="configuracion">
		        <div onclick="submenu('configuracion')">
			        <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
			        <strong >CONFIGURACION</strong> <br>
			     </div>
		        <li id="ejercicioFiscal"><a href="configuracion.do?metodo=listaEjercicioFiscal">
		            <span class="gestion">Ejercicios fiscales</span></a>
		        </li>
		        <li id="periodo"><a href="configuracion.do?metodo=listaPeriodo">
		            <span class="gestion">Periodos</span></a>
		        </li>
		        <li id="impuestos"><a href="configuracion.do?metodo=listaImpuestos">
		            <span class="gestion">Impuestos</span></a>
		        </li>
		        <li id="general"><a href="configuracion.do?metodo=listaConfiguracion">
		            <span class="gestion">Conf. General</span></a>
		        </li>
		      </ul>   
         </div>
      