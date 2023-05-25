<%-- 
    Document   : header
    Created on : 3 mar. 2023, 20:09:35
    Author     : walter
--%>


 
    <div class="col-12 py-3">
        <header>   
        <img src="${pageContext.request.contextPath}/View/Resources/img/logotipo.png" alt="logotipo" width="100" height="100">
        <div>
            Colegio San Pedro, innovando en educación.        
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

