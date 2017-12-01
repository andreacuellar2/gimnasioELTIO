function mostrarEmpleados() {
    var valueSucursal = document.getElementById('selectSucursales').value;
    console.log(valueSucursal);
    $
            .ajax(
                    {
                        url: 'http://localhost/parcialFPI_4_Servidor/index.php/empleadoController/getEmpleadoByIdSucursal/'
                                + valueSucursal,
                        dataType: 'json',
                        type: 'GET',
                    })
            .done(
                    function (response) {
                        console.log(response);
                        $('#empleadosLista').empty();
                        for (i = 0; i < response.length; i++) {
                            var node = document.createElement("LI");
                            var textnode = document
                                    .createTextNode(response[i].nombre_empleado);
                            node.appendChild(textnode);
                            document.getElementById("empleadosLista")
                                    .appendChild(node);
                        }
                    });
}
function mostrarPagos() {
    var valuePago = document.getElementById('selectPagos').value;
    console.log(valuePago);
    $
            .ajax(
                    {
                        url: 'http://localhost/parcialFPI_4_Servidor/index.php/pagoController/getPagoByIdCliente/'
                                + valuePago,
                        dataType: 'json',
                        type: 'GET',
                    }).done(function (response) {
        console.log(response);
        $('#listaPagos').empty();
        for (i = 0; i < response.length; i++) {
            var node = document.createElement("LI");
            var textnode = document.createTextNode(response[i].fecha);
            node.appendChild(textnode);
            document.getElementById("listaPagos").appendChild(node);
            mostrarTipoPago(response[i].idTipoPago);
        }
    });
}
function mostrarTipoPago(idTipo) {
    $
            .ajax(
                    {
                        url: 'http://localhost/parcialFPI_4_Servidor/index.php/tipo_pagoController/getTipoPagoById/'
                                + idTipo,
                        dataType: 'json',
                        type: 'GET',
                    })
            .done(
                    function (response) {
                        console.log(response);
                        for (i = 0; i < response.length; i++) {
                            var node = document.createElement("LI");
                            var textnode = document
                                    .createTextNode(response[i].nombre_tipopago);
                            node.appendChild(textnode);
                            document.getElementById("listaNombrePagos")
                                    .appendChild(node);
                        }
                    });
}
function agregarUser() {

    traerClientes($("#name").val(), $('input:radio[name=gender]:checked').val(), $("#selectSucursalCliente").val());
}
function traerClientes(nombre_cliente, genero_cliente, id_sucursalcliente) {
    // Para traer clientes
    $
            .ajax(
                    {
                        url: 'http://localhost/parcialFPI_4_Servidor/index.php/clienteController/getCliente',
                        dataType: 'json',
                        type: 'GET',
                    }).always(
            function (response) {
                console.log(response);
                for (var i = 0; i < response.length; i++) {
                    ultimoCliente = parseInt(response[i].id_cliente);
                }
                realizarPost((ultimoCliente + 1), nombre_cliente, genero_cliente, id_sucursalcliente);
            });
}
function realizarPost(id_cliente, nombre_cliente, genero_cliente, id_sucursalcliente) {

    var parametros = {
        "id_cliente": id_cliente,
        "nombre_cliente": nombre_cliente,
        "genero_cliente": genero_cliente,
        "activo_cliente": 1,
        "id_sucursalcliente": id_sucursalcliente
    };

    console.log(parametros);

    // POST del nuevo cliente
    $
            .ajax({
                data: parametros,
                url: 'http://localhost/parcialFPI_4_Servidor/index.php/clienteController/postCliente',
                dataType: 'json',
                type: 'POST'
            });

}
function agregarPago() {
    traerPagos($("#clientesPago").val(), $("#tipoPagoPago").val(), $("#fecha").val());
}

function traerPagos(idcliente, idTipoPago, fecha) {

    // Para traer pagos
    $
            .ajax(
                    {
                        url: 'http://localhost/parcialFPI_4_Servidor/index.php/pagoController/getPago',
                        dataType: 'json',
                        type: 'GET',
                    }).always(function (response) {
        console.log(response);
        for (var i = 0; i < response.length; i++) {
            ultimoPago = parseInt(response[i].idpago);
        }
        realizarPostPago((ultimoPago + 1), idcliente, idTipoPago, fecha);
    });
}
function realizarPostPago(idpago, idcliente, idTipoPago, fecha) {

    var parametros = {
        "idpago": idpago,
        "idcliente": idcliente,
        "idTipoPago": idTipoPago,
        "fecha": fecha
    };

    console.log(parametros);

    // POST del nuevo cliente
    $
            .ajax({
                data: parametros,
                url: 'http://localhost/parcialFPI_4_Servidor/index.php/pagoController/postPago',
                dataType: 'json',
                type: 'POST'
            });

}


//Metodos para ocultar divs
function ocultarDivsPagos() {
    console.log("No entro");
    $("#contenedorPagosPorCliente").style.display = "none !important";
    $("#contenedorAgregarPago").style.display = "none !important";
}


function eliminarUser() {
    var id_cliente = $("#selectClientes").val();
    var parametros = {
        "id_cliente": id_cliente,
        "activo_cliente": 0
    };

    $.ajax({
        data: parametros,
        url: 'http://localhost/parcialFPI_4_Servidor/index.php/clienteController/putCliente/' + id_cliente + '/',
        dataType: 'json',
        type: 'DELETE'
    });
}


function login() {

    var id = $("#name").val();
    var password = $("#email").val();

    $.ajax(
            {
                url: 'http://localhost/parcialFPI_4_Servidor/index.php/empleadoController/getEmpleado',
                dataType: 'json',
                type: 'GET',
            }).always(
            function (response) {
                for (var i = 0; i < response.length; i++) {
                    if (response[i].id_empleado == id) {
                        if (response[i].pass_empleado == password) {

//                            function createCookie(id) {
                                var b = new Date();
                                b.setTime(b.getTime() + ((60 * 1000) * 5));
                                var c = "; expires=" + b.toGMTString();
                                document.cookie = "usuario=" + id + c;
//                            }

                        }
                    }
                }
                location.reload();
            });
}

function cerrarsesion() {
	document.cookie="usuario=;expires=Thu, 01 Jan 1970 00:00:01 GMT;";
	location.href="/";
}