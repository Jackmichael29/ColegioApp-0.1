<%-- 
    Document   : nav
    Created on : 25 may. 2023, 10:59:23
    Author     : xbest
--%>

  
    <div class="col-2 py-3">
        <nav>
        <ul>
            
        <c:if test="${sessionScope.rol=='secretaria'}">            
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
            <li><a href="">Alumno</a></li>
            <li><a href="">Matricula</a></li>  
            <li><a href="">Reportes</a></li> 
            <li><a href="">Curso</a></li>        
            <li><a href="">Notas</a></li>   
            <li><a href="">Pagos</a></li>
            <li><a href="">Asistencia Docentes</a></li>
        </c:if>        
        
        </ul>
        </nav>
    </div>   

