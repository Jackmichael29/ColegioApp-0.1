<%-- 
    Document   : alumno-form-jsp
    Created on : 1 mar. 2023, 11:31:07
    Author     : walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
            <div class="row">
                <h1>Formulario de Matrícula</h1>               
            </div>
            
            
            <div class="row">        
                
          
            <form action="${pageContext.request.contextPath}/Matricula?action=insert" method="post">            
             
             
            <div class="mb-3">   
                <label>ID del Alumno</label>
                <input type="text" name="alumnoId" id="alumnoId" autocomplete="off" class="form-control"/>                         
            </div>  
             <button type="button" id="buscarAlumno">Buscar alumno</button>
                
            <div class="mb-3">    
                <label for="apellidosNombres" class="form-label">Apellidos y nombres</label>
                <input type="text" name="apellidosNombres" id="apellidosNombres" autocomplete="off" class="form-control"/>                     
            </div>  
            
          
            <div class="mb-3">   
                <label for="grado">Elige un grado:</label>
                <select name="grado" id="grado">
                    <option value="">--seleccionar--</option>
                    <option value="1" ${(matricula!=null && matricula.grado=="1")? "selected":""}>1</option>
                    <option value="2" ${(matricula!=null && matricula.grado=="2")? "selected":""}>2</option>
                    <option value="3" ${(matricula!=null && matricula.grado=="3")? "selected":""}>3</option>
                    <option value="4" ${(matricula!=null && matricula.grado=="4")? "selected":""}>4</option>
                    <option value="5" ${(matricula!=null && matricula.grado=="5")? "selected":""}>5</option>
                    <option value="6" ${(matricula!=null && matricula.grado=="6")? "selected":""}>6</option>
                </select>
            </div>                
                
                
            <div class="mb-3">
                <label for="nivel">Elige un nivel:</label>
                <select name="nivel" id="nivel">
                    <option value="">--seleccionar--</option>
                    <option value="I" ${(matricula!=null && matricula.nivel=="I")? "selected":""}>I</option>
                    <option value="P" ${(matricula!=null && matricula.nivel=="P")? "selected":""}>P</option>
                    <option value="S" ${(matricula!=null && matricula.nivel=="S")? "selected":""}>S</option>       
                </select>
            </div> 
                
            <div class="mb-3">
                <label for="turno">Elige un turno:</label>
                <select name="turno" id="turno">
                    <option value="">--seleccionar--</option>
                    <option value="m" ${(matricula!=null && matricula.turno=="M")? "selected":""}>M</option>
                    <option value="t" ${(matricula!=null && matricula.turno=="T")? "selected":""}>T</option>       
                </select>
            </div>    
                
                
            <div class="mb-3">   
                <label for="fecha" class="form-label">Fecha</label>
                <input type="date" name="fecha" id="fecha" value="${matricula!= null? matricula.fecha: ""}" class="form-control">            
                <c:if test="${errores != null && not empty errores.fecha}">
                <div style="color:red;">${errores.fecha}</div>
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
    
                
    <form id="form1" runat="server">
        <div id="dialog">

            Alumno: 
            <br><input  class="form-control" type="text" name="alumno" id="alumno" autocomplete="off"   size="50">
            <br><br>
            <div id="resultado"></div>
        </div>
    </form>           
                
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
 <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>  

                
    <script type="text/javascript">

        $(document).ready(function () {


            var dialogDiv = $('#dialog');

            dialogDiv.dialog({
                autoOpen: false,
                modal: true,
                height: "auto",
                width: "auto",
                buttons: {
                    'Buscar alumno': buscarAlumno,
                    'Cancel': function () {
                        dialogDiv.dialog('close');
                        clearInputFields();
                    }
                }
            });


        function buscarAlumno(){
          alumno = $('#alumno').val();
        var parametros = {
                "alumno" : alumno               
        };
        $.ajax({
                data:  parametros,
                url:   '${pageContext.request.contextPath}/Matricula?action=searchAlumByApenom',
                type:  'post',
/*                 beforeSend: function () {
                        $("#resultado").html("Procesando, espere por favor...");
                }, */
                success:  function (response) {
                        $("#resultado").html(response);
                }
        });
}

            function clearInputFields() {               
                $("#resultado").html('');
            }

            $('#buscarAlumno').click(function () {                
                dialogDiv.dialog("open");
            });





        });

        function changeIncidentValue(elem){

          var alumnoId=$(elem).find('td:first').text();       
          alert(alumnoId);     

          $.ajax({
          type:'POST',
          url:'${pageContext.request.contextPath}/Matricula?action=searchAlumById',
          data:{alumnoId:alumnoId},
          
          success:function(data){            
      
            let alumno = JSON.parse(JSON.stringify(data)); 
            
            $('#alumnoId').val(alumnoId);
            $('#apellidosNombres').val(alumno.apellidosNombres);
          }
          });
        }


    </script>            
                
                
                
     <%@ include file="/View/Container/footer.jsp" %>
    </body>
</html>
