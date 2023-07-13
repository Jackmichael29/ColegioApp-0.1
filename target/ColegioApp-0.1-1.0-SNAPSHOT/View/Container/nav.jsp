<%-- 
    Document   : nav
    Created on : 25 may. 2023, 10:59:23
    Author     : xbest
--%>

  
    <div class="col-2">
        <nav>
        <ul>
            
        <!--<c:if test="${sessionScope.rol=='secretaria'}">            
            <li><a href="">Alumno</a></li>
            <li><a href="">Matricula</a></li>  
            <li><a href="">Reportes</a></li> 
            <li><a href="">Curso</a></li>
            <li><a href="">Pago</a></li>
        </c:if>
            
        <c:if test="${sessionScope.rol=='docente'}">             
            <li><a href="${pageContext.request.contextPath}/Nota?action=index">Notas</a></li>
            <li><a href="${pageContext.request.contextPath}/Nota?action=index">Asistencia Alumnos</a></li>
        </c:if>  
            
        <c:if test="${sessionScope.rol=='admin'}">  
            <li><a href="${pageContext.request.contextPath}/Alumno?action=index">Alumno</a></li>
            <li><a href="${pageContext.request.contextPath}/Matricula?action=index">Matricula</a></li>  
            <li><a href="">Reportes</a></li> 
            <li><a href="${pageContext.request.contextPath}/Curso?action=index">Curso</a></li>        
            <li><a href="${pageContext.request.contextPath}/Area?action=index">Area</a></li>        
            <li><a href="">Notas</a></li>   
            <li><a href="">Pagos</a></li>
            <li><a href="">Asistencia Docentes</a></li>
            <li><a href="${pageContext.request.contextPath}/Usuario?action=index">Usuarios</a></li>
            <li><a href="${pageContext.request.contextPath}/Docente?action=index">Docentes</a></li>
            <li><a href="${pageContext.request.contextPath}/Apoderado?action=index">Apoderados</a></li>
        </c:if> -->
            <li><a href="${pageContext.request.contextPath}/Alumno?action=index">Alumno</a></li>
            <li><a href="${pageContext.request.contextPath}/Matricula?action=new">Matricula</a></li>  
            <li><a href="${pageContext.request.contextPath}/Mantenimiento?action=index">Reportes</a></li>
            <li><a href="${pageContext.request.contextPath}/Curso?action=index">Curso</a></li>        
            <li><a href="${pageContext.request.contextPath}/Area?action=index">Area</a></li>        
            <li><a href="${pageContext.request.contextPath}/Nota?action=index">Notas</a></li>   
            <li><a href="${pageContext.request.contextPath}/Pago?action=index">Pagos</a></li>
<!--            <li><a href="${pageContext.request.contextPath}/AsistenciaDocentes?action=index">Asistencia Docentes</a></li>-->
            <li><a href="${pageContext.request.contextPath}/AsistenciaDocentesIngreso?action=index">Ingreso Docentes</a></li>
            <li><a href="${pageContext.request.contextPath}/AsistenciaDocentesSalida?action=index">Salida Docentes</a></li>
            <li><a href="${pageContext.request.contextPath}/AsistenciaAlumnos?action=index">Asistencia Alumnos</a></li>
            <li><a href="${pageContext.request.contextPath}/Usuario?action=index">Usuarios</a></li>
            <li><a href="${pageContext.request.contextPath}/Docente?action=index">Docentes</a></li>
            <li><a href="${pageContext.request.contextPath}/Apoderado?action=index">Apoderados</a></li>
        
        </ul>
        </nav>
    </div>   

