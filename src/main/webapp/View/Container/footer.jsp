<%-- 
    Document   : footer
    Created on : 25 may. 2023, 10:59:23
    Author     : xbest
--%>

<script src="js/jquery-3.4.1.min.js"></script>

<script>
    $(document).ready(() => {
        $('th').each(function(columna) {
            $(this).hover(function() {
                $(this).addClass('resaltar');
            }, function() {
                $(this).removeClass('resaltar');
            });

            $(this).click(function() {
                let registros = $('table').find('tbody > tr').get();

                registros.sort(function(a, b) {
                    let valor1 = $(a).children('td').eq(columna).text().toUpperCase();
                    let valor2 = $(b).children('td').eq(columna).text().toUpperCase();

                    return valor1 < valor2 ? -1 : valor1 > valor2 ? 1 : 0;
                });

                $.each(registros, function(indice, elemento) {
                    $('tbody').append(elemento);
                });
            });
        });
    });
</script>
    
<div class="row w-100">
    <div class="col-12 py-3">
        <footer> 
        <div>©2020 - www.unicomlamolina.com. Todos los derechos reservados. </div>
        <div>NUESTRO CAMPUS</div>
        <div>Dirección: - San Pedro</div>
        <div>Telefonos: </div>   
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
