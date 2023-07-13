<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  
import= "JavaBean.Alumno, java.util.ArrayList"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>   
    
 <%@ include file="/View/Container/head.jsp" %>  


<body>
    
   <div class="row grow w-100">  
            
   <%@ include file="/View/Container/header.jsp" %>     
   <%@ include file="/View/Container/nav.jsp" %>
    
    <div class="main col-10 h-100 py-3">            
        
        <div class="container">      
        

        <form action="${pageContext.request.contextPath}/Nota?action=reportNotasPorAula" method="post">
            
            
            <div class="mb-3">   
                <label for="grado">Elige un grado:</label>
                <select name="grado" id="grado">
                    <option value="">--seleccionar--</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select>
            </div>   
            
            
            <div class="mb-3">
                <label for="nivel">Elige un nivel:</label>
                <select name="nivel" id="nivel">
                    <option value="">--seleccionar--</option>
                    <option value="P">P</option>
                    <option value="S">S</option>       
                </select>
            </div>
            

            <input type="submit" value="Exportar PDF" class="btn btn-secondary">

        </form>

            
            </div>
            </div>
            </div>
            
  <%@ include file="/View/Container/footer.jsp" %>
</body>


</html>