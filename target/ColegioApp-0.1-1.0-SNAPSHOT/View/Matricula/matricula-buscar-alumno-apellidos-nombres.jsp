<%-- 
    Document   : alumno-index
    Created on : 2 mar. 2023, 13:03:50
    Author     : walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 
     <%@ include file="/View/Container/head.jsp" %>
     
    <body>
        <div class="container">       
        
        
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">codigo</th>               
                <th scope="col">Apellidos y Nombres</th>                
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${alumnos}" var="a">
            <tr onclick="changeIncidentValue(this)">
                <td>${a.alumno_id}</td>             
                <td>${a.apellidosNombres}</td>                             
            </tr>
            </c:forEach>
            </tbody>
        </table>  
        
       </div>  
            
            
            
            
            
    </body>
</html>
