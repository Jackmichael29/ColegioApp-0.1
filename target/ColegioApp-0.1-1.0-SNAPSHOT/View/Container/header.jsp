<%-- 
    Document   : header
    Created on : 25 may. 2023, 10:59:23
    Author     : xbest
--%>


 
    <div class="col-12 py-3">
        <header>   
            <div class="banner">
                <div>
                    <img src="${pageContext.request.contextPath}/View/Resources/img/logo.PNG" alt="logotipo" width="100" height="100">
                </div>
                <div class="lema">
                    Colegio Unicom La Molina, Educando a los lideres del Manana.
                </div>
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

