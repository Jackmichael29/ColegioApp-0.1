<%-- 
    Document   : alumno-index
    Created on : May 25, 2023, 1:03:29 PM
    Author     : xbest
--%>

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
   
            <div class="row" >
                <h1>Inicio Pago</h1>
                <a href="${pageContext.request.contextPath}/Pago?action=new">Nuevo</a>
            </div>
            
            <div class="row">
        

        <form action="${pageContext.request.contextPath}/Pago?action=index" method="post">
            <div class="mb-3">   
                <label for="tipoPago">Elige un tipo de pago: </label>
                <select name="tipoPago" id="tipoPago">
                    <option value="">--seleccionar--</option>
                    <option value="1">Pago Matricula</option>
                    <option value="2">Pago Pensión</option>
                    <option value="3">Pago Varios</option>
                </select>
            </div>

            <input type="submit" value="Buscar" class="btn btn-secondary">

        </form>


        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Codigo</th>
                <th scope="col">Fecha</th>
                <th scope="col">Monto</th>
                <th scope="col">Alumno ID</th>
                <th scope="col">Observación</th>
                <th scope="col">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pagos}" var="p">
            <tr>
                <td>${p.pago_id}</td>
                <td>${p.fecha}</td>
                <td>${p.monto}</td>        
                <td>${p.alumno_id}</td>
                <td>${p.observacion}</td> 
                <td>
                    <a href="${pageContext.request.contextPath}/Pago?action=edit&id=${p.pago_id}" class="btn btn-secondary" role="button">Editar</a>
                    <a href="#delete" class="btn btn-secondary" role="button" data-id="${p.pago_id}" data-tipo="${p.tipo}">Eliminar</a>
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
          $(location).prop("href", "${pageContext.request.contextPath}/Pago?action=delete&id="+id);          
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
