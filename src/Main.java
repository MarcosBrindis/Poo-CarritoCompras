import models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean finalizarProgrma = true;
        ArrayList<Comprador> usuarios = new ArrayList<>();
        Tienda tienda = new Tienda();
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("*************************************");
            System.out.println("con que rol quieres iniciar?");
            System.out.println("1) administrador");
            System.out.println("2) comprador");
            System.out.println("3) finalizar");
            System.out.println("*************************************");
            /////////////////////////////////////////////////////////////////////////////////////////////////
            String selectorRol = keyboard.next();
            switch (selectorRol) {
                ///////////////////////////////////////////////////////////////////////////////////////////////
                case "1":
                    boolean salirAdm = true;
                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("1) Agregar producto");
                        System.out.println("2) mostrar informacion del producto");
                        System.out.println("3) validar ventas");
                        System.out.println("4) regresar");
                        System.out.println("------------------------------------------");
                        String selectoradmin = keyboard.next();

                        switch (selectoradmin) {
                            case "1"://agregar productos
                                boolean salirAgregar;
                                do {
                                    salirAgregar = agregarProducto(keyboard, tienda);
                                } while (salirAgregar);
                                break;
                            case "2"://imprimir productos
                                mostrarProductos(tienda);
                                break;
                            case "3"://validar ventas
                                System.out.println("Lista de compras realizadas:");
                                for (Compra compra : tienda.getCompras()) {
                                    System.out.println("Número de orden de compra: " + compra.getId());
                                    System.out.println("Fecha y hora de compra: " + compra.getFechaHoraCompra());
                                    System.out.println("Total de la compra: $" + compra.getTotalCompra());
                                    System.out.println("Estado de la compra: " + (compra.isStatus() ? "Aprobada" : "Pendiente"));
                                    System.out.println("-------------------------------------------------");
                                }
                                System.out.println("Ingrese el número de orden de compra que desea autorizar");
                                int numeroOrden = keyboard.nextInt();
                                if (numeroOrden > 0) {
                                    boolean encontrado = false;

                                    for (Compra compra : tienda.getCompras()) {
                                        if (compra.getId() == numeroOrden && !compra.isStatus()) {
                                            compra.setStatus(true);
                                            System.out.println("Compra marcada como aprovada");
                                            encontrado = true;
                                            break;
                                        }
                                    }
                                    if (!encontrado) {
                                        System.out.println("No se encontró una compra pendiente con ese número de orden.");
                                    }
                                } else {
                                    System.out.println("Número de orden no válido.");
                                }
                                break;
                            case "4":
                                salirAdm = false;
                                break;
                            default:
                                System.out.println("opcion incorrecta intente de nuevo");
                                break;

                        }
                    } while (salirAdm);
                    break;
                //////////////////////////////////////////////////////////////////////////////////
                case "2":
                    boolean salirComprador = true;
                    Comprador comprador = new Comprador();
                    Carrito carrito = new Carrito(comprador, tienda);

                    do {
                        System.out.println("------------------------------------------");
                        System.out.println("1) crear usuario");
                        System.out.println("2) ingresar usuario");
                        System.out.println("3) ver tienda");
                        System.out.println("4) regresar");
                        String selectorComprador = keyboard.next();
                        System.out.println("------------------------------------------");

                        switch (selectorComprador) {
                            case "1"://crear usuario
                                crearUsuario(keyboard, usuarios);
                                break;
                            case "2"://loguearse y mas
                                System.out.println("ingrese su usuario");
                                String nickName = keyboard.next();
                                for (Comprador u1 : usuarios) {
                                    if (nickName.equals(u1.getNickname())) {
                                        comprador = u1;
                                        carrito = new Carrito(comprador, tienda);

                                        boolean salirUsuario = true;
                                        for (int i = 0; i < 3 && salirUsuario; i++) {
                                            try {
                                                System.out.println("ingrese su contraseña");
                                                String passwordBusquda = keyboard.next();
                                                if (passwordBusquda.equals(u1.getPassword())) {
                                                    boolean cerrarSesion = true;
                                                    do {
                                                        System.out.println("************************");
                                                        System.out.println("*****bienvenido*********");
                                                        System.out.println("************************");

                                                        System.out.println("1) comprar productos");
                                                        System.out.println("2) abrir carrito de compras");
                                                        System.out.println("3) cerrar sesion");
                                                        String selectorComprasUsuar = keyboard.next();
                                                        System.out.println("------------------------------------------");
                                                        ////////////////////////////////////////////////////////////////////
                                                        switch (selectorComprasUsuar) {
                                                            case "1"://comprar productos
                                                                boolean regresarCompra = true;
                                                                do {
                                                                    mostrarProductosCliente(tienda);
                                                                    System.out.println("coloque el numero del articulo que desea agregar al carrito");
                                                                    System.out.println("0) regresar");
                                                                    int selectorCompra = keyboard.nextInt();
                                                                    System.out.println(carrito.agregarCarrito(selectorCompra));
                                                                    if (selectorCompra == 0) {
                                                                        regresarCompra = false;
                                                                    }
                                                                } while (regresarCompra);
                                                                break;
                                                            case "2"://abrir carrito de compras
                                                                boolean regresarCompra2 = true;
                                                                do {
                                                                    System.out.println(carrito.mostrarcarrito());
                                                                    System.out.println(carrito.totalaPagar());
                                                                    System.out.println("------------------------------------------");
                                                                    System.out.println("1) eliminar producto");
                                                                    System.out.println("2) generar peticion de compra");
                                                                    System.out.println("3) regresar");
                                                                    System.out.println("------------------------------------------");
                                                                    String selectorCarrito = keyboard.next();
                                                                    ////////////////////////////////////////////////////////////////////////////////////////////
                                                                    switch (selectorCarrito) {
                                                                        case "1"://eliminar producto del carrito
                                                                            System.out.println("escriba el numero del producto que quiere eliminar");
                                                                            System.out.println("0) cancelar");
                                                                            int seleccionarElim = keyboard.nextInt();
                                                                            String mensajeEliminar = carrito.eliminarProducto(seleccionarElim);
                                                                            System.out.println(mensajeEliminar);
                                                                            break;
                                                                        case "2"://generar peticion de compra
                                                                            boolean regresarCarrito = true;
                                                                            do {
                                                                                System.out.println(comprador);
                                                                                System.out.println("------------------------------------------");
                                                                                System.out.println("1) modificar datos");
                                                                                System.out.println("2) solicitar pago");
                                                                                System.out.println("3) status");
                                                                                System.out.println("4) regresar");
                                                                                System.out.println("------------------------------------------");
                                                                                String selectorpagos = keyboard.next();
                                                                                ////////////////////////////////////////////////////////////////////////////////////////
                                                                                switch (selectorpagos) {
                                                                                    case "1":
                                                                                        System.out.println("------------------------------------------");
                                                                                        System.out.println("1) modificar metodo de pago");
                                                                                        System.out.println("2) modificar direccion de envio");
                                                                                        System.out.println("3) regresar ");
                                                                                        System.out.println("------------------------------------------");
                                                                                        String selectorModificar = keyboard.next();
                                                                                        //////////////////////////////////////////////////////////////////////////
                                                                                        switch (selectorModificar) {
                                                                                            case "1":
                                                                                                FormaPago nuevaTarjeta = agregarTarjeta(keyboard);
                                                                                                u1.setFormaPago(nuevaTarjeta);
                                                                                                System.out.println("Tarjeta agregada correctamente");
                                                                                                break;
                                                                                            case "2":
                                                                                                DireccionEnvio nuevaDireccion = agregarDireccion(keyboard);
                                                                                                u1.setEnvio(nuevaDireccion);
                                                                                                System.out.println("Direccion agregada correctamente");
                                                                                                break;
                                                                                            case "3":
                                                                                                System.out.println();
                                                                                                break;
                                                                                            default:
                                                                                                System.out.println("opcion incorrecta intente de nuevo");
                                                                                                break;
                                                                                        }
                                                                                        ///////////////////////////////////////////////////////////////////////
                                                                                        break;
                                                                                    case "2": // solicitar pago
                                                                                        if (u1.getEnvio() != null && u1.getFormaPago() != null && !carrito.totalaPagar().equals("0.0")) {
                                                                                            System.out.println("Detalle del carrito:");
                                                                                            System.out.println(carrito.mostrarcarrito());

                                                                                            float totalCompra = carrito.totalaPagarusar();
                                                                                            System.out.println("Total de la compra: $" + totalCompra);

                                                                                            System.out.println("esta seguro de comprar esto? (s/n)");
                                                                                            String confirmacion = keyboard.next();

                                                                                            if (confirmacion.equalsIgnoreCase("s")) {
                                                                                                Compra nuevaCompra = new Compra(false, generarIdUnico(), LocalDateTime.now(), u1, totalCompra);
                                                                                                tienda.addCompra(nuevaCompra);
                                                                                                u1.getCarritoComp().clear();

                                                                                                System.out.println("Pago solicitado");
                                                                                                System.out.println("Número de orden de compra: " + nuevaCompra.getId());
                                                                                                System.out.println("Fecha y hora de compra: " + nuevaCompra.getFechaHoraCompra());
                                                                                                System.out.println("Total de la compra: $" + nuevaCompra.getTotalCompra());
                                                                                                System.out.println("----------------------------------------------------------------");

                                                                                                regresarCarrito = false;
                                                                                            } else {
                                                                                                System.out.println("Pago no autorizado por el administrador.");
                                                                                            }
                                                                                        } else {
                                                                                            System.out.println("Por favor, agregue los campos faltantes para poder procesar su pago");
                                                                                        }
                                                                                        break;
                                                                                    case "3"://status del pago
                                                                                        System.out.println("Lista de compras realizadas:");
                                                                                        for (Compra compra : tienda.getCompras()) {
                                                                                            System.out.println("Número de orden de compra: " + compra.getId());
                                                                                            System.out.println("Fecha y hora de compra: " + compra.getFechaHoraCompra());
                                                                                            System.out.println("Total de la compra: $" + compra.getTotalCompra());
                                                                                            System.out.println("Estado de la compra: " + (compra.isStatus() ? "Aprobada" : "Pendiente"));
                                                                                            System.out.println("--------------------------------------------------");
                                                                                        }

                                                                                        System.out.println("Ingrese el número de orden de compra para verificar su estado:");
                                                                                        int numeroOrdenVerificar = keyboard.nextInt();

                                                                                        if (numeroOrdenVerificar > 0) {
                                                                                            boolean encontrado = false;

                                                                                            for (Compra compra : tienda.getCompras()) {
                                                                                                if (compra.getId() == numeroOrdenVerificar) {
                                                                                                    System.out.println("Estado de la compra con número de orden " + numeroOrdenVerificar + ": " +
                                                                                                            (compra.isStatus() ? "Aprobada" : "Pendiente"));
                                                                                                    encontrado = true;
                                                                                                }
                                                                                            }

                                                                                            if (!encontrado) {
                                                                                                System.out.println("No se encontró una compra con ese número de orden.");
                                                                                            }
                                                                                        } else {
                                                                                            System.out.println("Número de orden no válido.");
                                                                                        }
                                                                                        break;

                                                                                    case "4":
                                                                                        regresarCarrito = false;
                                                                                        break;
                                                                                    default:
                                                                                        System.out.println("opcion incorrecta intente de nuevo");
                                                                                        break;
                                                                                }
                                                                            } while (regresarCarrito);
                                                                            break;
                                                                        case "3":
                                                                            regresarCompra2 = false;
                                                                            break;
                                                                        default:
                                                                            System.out.println("opcion incorrecta intente de nuevo");
                                                                            break;
                                                                    }
                                                                    /////////////////////////////////////////////////////
                                                                } while (regresarCompra2);
                                                                break;
                                                            case "3":
                                                                cerrarSesion = false;
                                                                break;
                                                            default:
                                                                System.out.println("opcion incorrecta intente de nuevo");
                                                                break;
                                                        }
                                                        ////////////////////////////////////////////////////////////////
                                                    } while (cerrarSesion);
                                                    salirUsuario = false;
                                                } else {
                                                    System.out.println("contraseña incorrecta");
                                                }
                                            } catch (java.util.InputMismatchException e) {
                                                System.out.println("contraseña incorrecta");
                                                keyboard.next();
                                            }
                                        }
                                    } else {
                                        System.out.println("user no encontrado");
                                    }
                                }
                                break;
                            case "3"://imprimir productos
                                System.out.println();
                                mostrarProductosCliente(tienda);
                                break;
                            case "4":
                                salirComprador = false;
                                break;
                            default:
                                System.out.println("opcion incorrecta intente de nuevo");
                                break;
                        }
                    } while (salirComprador);
                    break;
                /////////////////////////////////////////////////////////////////////////////////
                case "3":
                    System.out.println("hasta pronto");
                    finalizarProgrma = false;
                    break;
                default:
                    System.out.println("comando incorrecto intente de nuevo");
                    break;
            }
        } while (finalizarProgrma);
    }

    ///////////////////////////////////////////////////////////////////////////////
    //metodos/////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    public static boolean agregarProducto(Scanner keyboard, Tienda tienda) {
        Producto producto = new Producto();

        System.out.println("Ingrese nombre del producto:");
        producto.setNombreProd(keyboard.next());
        System.out.println("Ingrese una descripción del producto:");
        producto.setDescripcionProd(keyboard.next());
        try {
            System.out.println("Ingrese el precio:");
            producto.setPrecioProd(keyboard.nextFloat());
            System.out.println("¿Cuántos de estos productos estás agregando?");
            float cantidad = keyboard.nextFloat();
            LocalDate fechaActual = LocalDate.now();
            StockProducto stockProducto = new StockProducto(cantidad, fechaActual, producto);
            tienda.addproductos(stockProducto);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido");
            keyboard.next();
        }
        return preguntarAgregarOtro(keyboard);
    }

    public static boolean preguntarAgregarOtro(Scanner keyboard) {
        do {
            System.out.println("¿Desea agregar otro? (s/n)");
            String selec = keyboard.next();
            if (selec.equalsIgnoreCase("n")) {
                return false;
            } else if (selec.equalsIgnoreCase("s")) {
                return true;
            } else {
                System.out.println("Opción invalida, por favor ingrese 's' o 'n'");
            }
        } while (true);
    }

    public static void mostrarProductos(Tienda tienda) {
        ArrayList<StockProducto> stockProducto = tienda.getInventario();

        if (!stockProducto.isEmpty()) {
            System.out.println("Los productos son: ");
            int i = 1;
            for (StockProducto stockProductoActual : stockProducto) {
                Producto productoActual = stockProductoActual.getProducto();
                System.out.println(i + ") Nombre: " + productoActual.getNombreProd() +
                        "\n Descripción: " + productoActual.getDescripcionProd() +
                        "\n Precio: $" + productoActual.getPrecioProd() +
                        "\n Cantidad en inventario: " + stockProductoActual.getCantidadDelProducto() +
                        "\n Fecha de ingreso: " + stockProductoActual.getFecha() +
                        "\n ID: " + productoActual.getIdProd() +
                        "\n------------------------------------------------------------------------------");
                i++;
            }
        } else {
            System.out.println("No ha agregado productos");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void crearUsuario(Scanner keyboard, ArrayList<Comprador> usuarios) {
        System.out.println("Ingrese un nickname");
        String nickName = keyboard.next();
        Comprador nickName1 = new Comprador(nickName);
        if (!usuarios.contains(nickName1)) {
            System.out.println("Ingrese su nombre");
            String name = keyboard.next();
            System.out.println("Ingrese su apellido");
            String lastname = keyboard.next();
            System.out.println("Ingrese un email");
            String email = keyboard.next();
            System.out.println("Ingrese un numero de telefono");
            long phone = keyboard.nextLong();
            System.out.println("Escribe una contraseña");
            String password = keyboard.next();

            FormaPago formaPago = null;
            System.out.println("Quiere agregar un metodo de pago s/n");
            String selec = keyboard.next();
            if (selec.equalsIgnoreCase("s")) {
                formaPago = agregarTarjeta(keyboard);
            }

            DireccionEnvio direccionEnvio = null;
            System.out.println("Quiere agregar una direccion s/n");
            selec = keyboard.next();
            if (selec.equalsIgnoreCase("s")) {
                direccionEnvio = agregarDireccion(keyboard);
            }

            Comprador comprador = new Comprador(nickName, name, lastname, email, phone, password, formaPago, direccionEnvio);
            usuarios.add(comprador);
            System.out.println("Cuenta creada");
        } else {
            System.out.println("Usuario repetido");
        }
    }

    public static DireccionEnvio agregarDireccion(Scanner keyboard) {
        System.out.println("Ingrese su pais donde reside");
        String country = keyboard.next();
        System.out.println("Ingrese su estado donde reside");
        String estado = keyboard.next();
        System.out.println("Ingrese su ciudad donde reside");
        String city = keyboard.next();
        System.out.println("Ingrese su direccion");
        String direccion = keyboard.next();
        System.out.println("Ingresa tu codigo postal");
        int codigoPost = keyboard.nextInt();
        return new DireccionEnvio(country, estado, city, direccion, codigoPost);
    }

    public static FormaPago agregarTarjeta(Scanner keyboard) {
        System.out.println("Ingrese el tipo de tarjeta (debito o credito)");
        String tipoTarj = keyboard.next();
        System.out.println("Ingrese su numero de tarjeta");
        long numTarj = keyboard.nextLong();
        System.out.println("Ingrese fecha (MM)");
        int fechaMM = keyboard.nextInt();
        System.out.println("Ingrese fecha (AA)");
        int fechaAA = keyboard.nextInt();
        System.out.println("Ingrese CVV2/CVC2");
        int cvv = keyboard.nextInt();
        return new FormaPago(tipoTarj, numTarj, fechaMM, fechaAA, cvv);
    }

    public static void mostrarProductosCliente(Tienda tienda) {
        ArrayList<StockProducto> stockProducto = tienda.getInventario();

        if (!stockProducto.isEmpty()) {
            System.out.println("***********bienvenido************");
            System.out.println("       Los productos son: ");
            System.out.println("*********************************");
            int i = 1;
            for (StockProducto stockProductoActual : stockProducto) {
                Producto productoActual = stockProductoActual.getProducto();
                System.out.println(i + ") Nombre: " + productoActual.getNombreProd() +
                        "\n Descripción: " + productoActual.getDescripcionProd() +
                        "\n Precio: $" + productoActual.getPrecioProd() +
                        "\n Cantidad maxima que puede comprar: " + stockProductoActual.getCantidadDelProducto() +
                        "\n------------------------------------------------------------------------------");
                i++;
            }
        } else {
            System.out.println("No ha agregado productos");
        }
    }

    private static int contador = 0;

    public static int generarIdUnico() {
        long timestamp = System.currentTimeMillis();
        contador++;
        return (int) ((timestamp << 16) | (contador & 0xFFFF)) & Integer.MAX_VALUE;
    }
    ///////////////////////////////////////////////////////////////////////////
}