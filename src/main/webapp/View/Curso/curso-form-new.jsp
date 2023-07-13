<%-- 
    Document   : curso-form-new
    Created on : May 18, 2023, 1:42:44 PM
    Author     : xbest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="/View/Container/head.jsp" %>
  
    
    <body>
    
    <div class="row grow w-100">    
        
        
   <%@ include file="/View/Container/header.jsp" %>     
   <%@ include file="/View/Container/nav.jsp" %>
        
   
   <div class="main col-10 h-100 py-3">
   
   
        <div class="container">
            
            <div class="row">
                <h1>Datos de Curso Nuevo</h1>
                <a href="${pageContext.request.contextPath}/Curso?action=index">Regresar al inicio</a>
            </div>
            
            
            <div class="row">        
                
          
            <form action="${pageContext.request.contextPath}/Curso?action=insert" method="post">       
            
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" name="nombre" value="${curso!=null? curso.nombre:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty errores.nombre}">
                    <div style="color:red;">${errores.nombre}</div>
                    </c:if>                    
                </div>             

                <div class="mb-3">
                    <label for="nivel" class="form-label">Nivel</label> <br>
                    <select id="nivel" name="nivel" class="form-control">
                        <option value="0">Seleccionar</option>
                        <option value="I">Inicial</option>
                        <option value="P">Primaria</option>
                        <option value="S">Secundaria</option>
                    </select>                   
                    <c:if test="${errores != null && not empty errores.nivel}">
                    <div style="color:red;">${errores.nivel}</div>
                    </c:if>   
                </div>
                   
                <div class="mb-3">    
                    <label for="grado" class="form-label">Grado</label> <br>
                    <select id="grado" name="grado" class="form-control">
                        <option value="0">Seleccionar</option>
                        <option value="1">1er Grado</option>
                        <option value="2">2do Grado</option>
                        <option value="3">3er Grado</option>
                        <option value="4">4to Grado</option>
                        <option value="5">5to Grado</option>
                        <option value="6">6to Grado</option>
                    </select> 
                    <c:if test="${errores != null && not empty errores.grado}">
                    <div style="color:red;">${errores.grado}</div>
                    </c:if>    
                </div> 
                
                <div class="mb-3">
                    <label for="areaId" class="form-label">AreaId</label>
                    <input type="text" name="areaId" value="${curso!=null? curso.area_id:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty errores.area_id}">
                    <div style="color:red;">${errores.area_id}</div>
                    </c:if>             
                </div>    

                <div class="mb-3">
                    <input type="submit" value="Crear" class="btn btn-primary">            
                </div>
                
            </form>
                
                
        </div>
            
        </div>

    </div>
                
                
    </div>
                
                
     <%@ include file="/View/Container/footer.jsp" %>
    </body>
</html>
