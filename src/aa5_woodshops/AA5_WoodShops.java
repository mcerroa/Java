package aa5_woodshops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Chic
 */
public class AA5_WoodShops {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        WoodShops woodShops = new WoodShops();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Mostrar listado de clientes");
            System.out.println("3. Agregar un ticket de venta");
            System.out.println("4. Mostrar resumen de tickets de la tienda");
            System.out.println("5. Mostrar resumen de ventas de la tienda");
            System.out.println("0. Salir");

            System.out.println("Introduzca el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); //Limpiamos el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarCliente(woodShops, scanner);
                    break;
                case 2:
                    mostrarListadoClientes(woodShops);
                    break;
                case 3:
                    agregarTicketVenta(woodShops, scanner);
                    break;
                case 4:
                    mostrarResumenTickets(woodShops, scanner);
                    break;
                //Añadimos una nueva opción para mostrar el resumen de ventas por tienda
                case 5:
                    mostrarResumenVentas(woodShops, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo");
                    return;
                default:
                    System.out.println("Opcion no valida. Por favor, ingrese un numero valido.");
            }
        }
    }

    private static void agregarCliente (WoodShops woodShops, Scanner scanner) {

        System.out.println("¿Quieres registrar al cliente? (S/N):");
        String respuesta = scanner.nextLine();

        Cliente cliente;
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("\nIntroduzca los datos del cliente:");
            System.out.println("NIF: ");
            String nif = scanner.nextLine();
            System.out.println("Nombre:");
            String nombre = scanner.nextLine();
            cliente = crearClienteRegistrado(nif, nombre, scanner);
            if (cliente != null) {
                woodShops.agregarCliente(cliente);
                System.out.println("Cliente Registrado agregado correctamente.");
            } else {
                System.out.println("Tipo de cliente no valido. Cliente no dado de alta.");
            }
        } else {
            cliente = crearClienteNoRegistrado();
            woodShops.agregarCliente(cliente);
            System.out.println("Cliente No Registrado agregado correctamente.");
        }

    }

    private static Cliente crearClienteRegistrado(String nif, String nombre, Scanner scanner) {
        System.out.println("Tipo de cliente (Profesional/WoodFriend):");
        String tipoCliente = scanner.nextLine();

        switch (tipoCliente.toLowerCase()) {
            case "profesional":
                return crearClienteProfesional(nif, nombre, scanner);
            case "woodfriend":
                return crearClienteWoodFriend(nif, nombre, scanner);
            default:
                return null;
        }
    }

    private static Cliente crearClienteProfesional(String nif, String nombre, Scanner scanner) {
        System.out.println("Descuento del cliente profesional (sin decimales):");
        int descuento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return new ClienteProfesional(nif, nombre, descuento);
    }

    private static Cliente crearClienteWoodFriend(String nif, String nombre, Scanner scanner) {
        System.out.println("Código de socio del cliente WoodFriend:");
        String codigoSocio = scanner.nextLine();
        return new ClienteWoodFriend(nif, nombre, codigoSocio);
    }

    private static Cliente crearClienteNoRegistrado() {
        // No se requieren datos para un cliente no registrado
        return new ClienteNoRegistrado();
    }

    private static void mostrarListadoClientes (WoodShops woodShops) {
        System.out.println("\nListado de todos los clientes:");
        woodShops.mostrarListadoClientes();
    }

    private static void agregarTicketVenta (WoodShops woodShops, Scanner scanner) {
        System.out.println("\nIntroduzca los datos del ticket de venta:");
        System.out.println("Tienda: ");
        String tienda = scanner.nextLine();
        System.out.println("Numero de ticket: ");
        int numeroTicket = scanner.nextInt();
        scanner.nextLine(); //Limpiar el buffer

        //Obtener la fecha de venta del ticket
        System.out.println("Fecha del ticket de venta (dd/mm/yyyy): ");
        String fechaStr = scanner.nextLine();
        Date fecha;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fecha = sdf.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Error al leer la fecha. Formato incorrecto.");
            return;
        }

        //Obtener el ticket de venta
        System.out.println("NIF del cliente (dejar en blanco para cliente No Registrado): ");
        String nifCliente = scanner.nextLine();
        Cliente cliente = null;

        if (!nifCliente.isEmpty()) {
            //Buscamos el cliente por el nif
            for (Cliente c : woodShops.getClientes()) {
                if (c.getNif().equals(nifCliente)) {
                    cliente = c;
                    break;
                }
            }
            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                return;
            }
        }

        //Crear el ticket de venta
        TicketVenta ticket = new TicketVenta(tienda, numeroTicket, fecha, cliente);

        // Agregar líneas de detalle al ticket de venta
        while (true) {
            System.out.println("\nAgregar producto al ticket de venta:");

            // Obtener información del producto
            System.out.print("Codigo del producto (Introduzca 0 para terminar): ");
            String codigoProducto = scanner.nextLine();
            if (codigoProducto.equals("0")) {
                break;
            }
            boolean tipoValido;
            do {
                System.out.print("Introduce el tipo de producto (tablero, barniz, articulo): ");
                String tipoProducto = scanner.nextLine();
                // Convertir la entrada del usuario a minúsculas para comparar de manera insensible a mayúsculas/minúsculas
                tipoProducto = tipoProducto.toLowerCase();
                // Verificar si la entrada del usuario coincide con alguno de los tipos de producto válidos
                tipoValido = false;
                for (TipoProducto tipo : TipoProducto.values()) {
                    if (tipo.getDescripcion().toLowerCase().equals(tipoProducto)) {
                        tipoValido = true;
                        break;
                    }
                }
                // Si el tipo de producto no es válido, mostrar un mensaje de error
                if (!tipoValido) {
                    System.out.println("Tipo de producto no valido.");
                }
            } while (!tipoValido);
            System.out.print("Descripcion del producto: ");
            String descripcionProducto = scanner.nextLine();
            System.out.print("Precio de venta (con decimales, separado por ','): ");
            double precioVentaProducto = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            // Crear la línea de detalle
            LineaDetalle linea = new LineaDetalle(descripcionProducto, cantidad, precioVentaProducto);

            // Agregar la línea de detalle al ticket de venta
            ticket.agregarLineaDetalle(linea);
        }

        //Agregar el ticket a WoodShops
        woodShops.agregarTicketVenta(ticket);
    }

    private static void mostrarResumenTickets(WoodShops woodShops, Scanner scanner) {
        // Obtener fechas de inicio y fin para filtrar los tickets de venta
        System.out.print("\nFecha de inicio para filtrar los tickets (dd/mm/yyyy): ");
        String fechaInicioStr = scanner.nextLine();
        Date fechaInicio;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaInicio = sdf.parse(fechaInicioStr);
        } catch (ParseException e) {
            System.out.println("Error al leer la fecha de inicio. Formato incorrecto.");
            return;
        }

        System.out.print("Fecha de fin para filtrar los tickets (dd/mm/yyyy): ");
        String fechaFinStr = scanner.nextLine();
        Date fechaFin;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaFin = sdf.parse(fechaFinStr);
        } catch (ParseException e) {
            System.out.println("Error al leer la fecha de fin. Formato incorrecto.");
            return;
        }

        // Mostrar resumen de tickets en la tienda
        woodShops.mostarResumenTickets(fechaInicio, fechaFin);
    }

    //Añadimos el método para mostrar el resumen de ventas
    private static void mostrarResumenVentas(WoodShops woodShops, Scanner scanner) {
        //Obtenemos la tienda para filtrar las ventas
        System.out.println("\nNombre de la tienda para filtrar las ventas: ");
        String tienda = scanner.nextLine();

        // Mostrar resumen de ventas por tienda
        woodShops.mostrarResumenVentas(tienda);
    }
}
