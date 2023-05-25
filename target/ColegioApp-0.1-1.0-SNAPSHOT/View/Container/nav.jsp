<%-- 
    Document   : nav
    Created on : 3 mar. 2023, 20:06:39
    Author     : walter
--%>

  
    <div class="col-2 py-3">
        <nav>
        <ul>
            
        <c:if test="${sessionScope.rol=='secretaria'}">            
            <li><a href="">Alumno</a></li>
            <li><a href="">Matricula</a></li>  
            <li><a href="">Reportes</a></li> 
            <li><a href="">Curso</a></li>
        </c:if>
            
        <c:if test="${sessionScope.rol=='docente'}">             
            <li><a href="${pageContext.request.contextPath}/Nota?action=index">Notas</a></li>
        </c:if>  
            
        <c:if test="${sessionScope.rol=='admin'}">  
            <li><a href="">Alumno</a></li>
            <li><a href="">Matricula</a></li>  
            <li><a href="">Reportes</a></li> 
            <li><a href="">Curso</a></li>        
            <li><a href="">Notas</a></li>                   
        </c:if>        
        
        </ul>
        </nav>
    </div>   

