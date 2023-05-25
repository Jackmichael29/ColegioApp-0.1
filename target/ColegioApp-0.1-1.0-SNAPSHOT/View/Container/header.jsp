<%-- 
    Document   : header
    Created on : 25 may. 2023, 10:59:23
    Author     : xbest
--%>


 
    <div class="col-12 py-3">
        <header>   
        <img src="${pageContext.request.contextPath}/View/Resources/img/logotipo.png" alt="logotipo" width="100" height="100">
        <div>
            Colegio Unicom La Molina, Educando a los lideres del Manana.        
        </div>
        <div>
            ${sessionScope.rol}            
        </div>
        <div>
            ${sessionScope.usuario}            
        </div>
        <div>
            ${sessionScope.apellidosNombres}            
        </div>
        </header>
    </div>        

