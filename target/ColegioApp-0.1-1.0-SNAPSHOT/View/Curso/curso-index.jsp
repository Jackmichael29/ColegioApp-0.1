<%-- 
    Document   : curso-index
    Created on : May 25, 2023, 1:03:29 PM
    Author     : xbest
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  
import= "JavaBean.Curso, java.util.ArrayList"
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
   
            <div class="row" >
                <h1>Inicio Curso</h1>
                <a href="${pageContext.request.contextPath}/Curso?action=new">Nuevo Curso</a>
            </div>
            
            <div class="row">
        

        <form action="${pageContext.request.contextPath}/Curso?action=index" method="post">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" name="nombre" id="nombre" value="" autocomplete="off" class="form-control"/>

            <input type="submit" value="Buscar" class="btn btn-secondary">

        </form>


        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Curso id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Nivel</th>
                <th scope="col">Grado</th>
                <th scope="col">Area id</th>
                <th scope="col">Operaciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cursos}" var="c">
            <tr>
                <td>${c.curso_id}</td>
                <td>${c.nombre}</td>
                <td>${c.nivel}</td>        
                <td>${c.grado}</td>
                <td>${c.area_id}</td>
                <td>
                <a href="${pageContext.request.contextPath}/Curso?action=edit&id=${c.curso_id}" class="btn btn-secondary" role="button">Editar</a>                
                <a href="#delete" class="btn btn-secondary" role="button" data-id="${c.curso_id}">Eliminar</a>
                </td>                    
            </tr>
            </c:forEach>
            </tbody>
        </table>
            
            </div>
            </div>
            </div>
   
 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
 <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
      
  
   $( function() { 
    
   $( "#dialog-confirm" ).hide();  
      
      
   $('a[href="#delete"]').click(function(){
        var id=$(this).attr("data-id");        
        
      $( "#dialog-confirm" ).dialog({
      resizable: false,
      height: "auto",
      width: 400,
      modal: true,
      buttons: {
        "Si": function() {         
          $( this ).dialog( "close" );                 
          $(location).prop("href", "${pageContext.request.contextPath}/Curso?action=delete&id="+id);          
        },
        "No": function() {
          $( this ).dialog( "close" );
        }
      }
    });
        
        
    });   
      
      
   } );
      
 
  </script>           
            
            
  <%@ include file="/View/Container/footer.jsp" %>
</body>

<div id="dialog-confirm" title="¡Alerta!">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Esta seguro de eliminar este registro?</p>
</div>

</html>
