package aa5_woodshops;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class WoodShops {
    private ArrayList<Cliente> clientes;
    private ArrayList<TicketVenta> tickets;

    //Constructores
    public WoodShops() {
        this.clientes = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    //Método para gestionar clientes
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    //Método para mostrar un listado de los clientes
    public void mostrarListadoClientes() {
        for (Cliente cliente : clientes) {
            if (cliente instanceof ClienteRegistrado) {
                if (cliente instanceof ClienteProfesional) {
                    System.out.println("Tipo: Profesional - NIF: " + cliente.getNif() + ", Nombre: " + cliente.getNombre()
                    + ", Descuento: " + ((ClienteProfesional) cliente).getDescuento());
                } else if (cliente instanceof ClienteWoodFriend) {
                    System.out.println("Tipo: WoodFriend - NIF: " + cliente.getNif() + ", Nombre: " + cliente.getNombre()
                    + ", Codigo de cliente: " + ((ClienteWoodFriend) cliente).getCodigoSocio());
                }
            } else if (cliente instanceof ClienteNoRegistrado) {
                System.out.println("Tipo: No Registrado - NIF: Desconocido, Nombre: Desconocido");
            }
        }
    }

    //Método para agregar nuevos clientes
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    //Método para gestionar tickets
    public ArrayList<TicketVenta> obtenerTicketsVenta() {
        return tickets;
    }

    //Método para agregar tickets en la tienda y mostrar el ticket completo
    public void agregarTicketVenta (TicketVenta ticket) {
        tickets.add(ticket);
        System.out.println("--------------------");
        System.out.println("Ticket agregado correctamente en la tienda " + ticket.getNombre() + ": ");
        System.out.println("Numero de ticket: " + ticket.getNumeroTicket());
        System.out.println("Fecha: " + ticket.obtenerFechaFormateada());
        Cliente cliente = ticket.getCliente();

        if (cliente != null) {
            System.out.println("Cliente - NIF: " + cliente.getNif() + ", Nombre: " + cliente.getNombre());
        } else {
            System.out.println("Cliente: No Registrado");
        }
    }

    //Método para mostrar un resumen de los tickets, por fecha
    public void mostarResumenTickets(Date fechaInicio, Date fechaFin) {
        System.out.println("\nResumen de tickets (por fecha): ");

        for (TicketVenta ticket : tickets) {
            Date fechaTicket = ticket.getFecha();

            if (fechaTicket.after(fechaInicio) && fechaTicket.before(fechaFin)) {
                System.out.println("--------------------");
                System.out.println("Tienda: " + ticket.getNombre());
                System.out.println("Numero de ticket: " + ticket.getNumeroTicket());
                System.out.println("Fecha: " + ticket.obtenerFechaFormateada());
                Cliente cliente = ticket.getCliente();

                if (cliente != null) {
                    System.out.println("Cliente - NIF: " + cliente.getNif() + ", Nombre: " + cliente.getNombre());
                } else {
                    System.out.println("Cliente: No Registrado");
                }

                double total = 0;
                for (LineaDetalle linea : ticket.obtenerLineasDetalle()) {
                    String descripcion = linea.getDescripcion();
                    int cantidad = linea.getCantidad();
                    total += cantidad * linea.getPrecioVenta();
                }

                System.out.println("Total del importe del ticket: " + total);
            }
        }
    }

    //Añadimos el método para mostrar el resumen de ventas por tienda
    public void mostrarResumenVentas(String tienda) {
        System.out.println("\nResumen de ventas para la tienda: " + tienda);

        for (TicketVenta ticket : tickets) {
            if (ticket.getNombre().equalsIgnoreCase(tienda)) {
                System.out.println("--------------------");
                System.out.println("Fecha: " + ticket.obtenerFechaFormateada());
                Cliente cliente = ticket.getCliente();

                if (cliente != null) {
                    System.out.println("Cliente - NIF: " + cliente.getNif() + ", Nombre: " + cliente.getNombre());
                } else {
                    System.out.println("Cliente: No Registrado");
                }

                double total = 0;
                for (LineaDetalle linea : ticket.obtenerLineasDetalle()) {
                    String descripcion = linea.getDescripcion();
                    int cantidad = linea.getCantidad();
                    total += cantidad * linea.getPrecioVenta();
                    System.out.println("Producto - Descripción: " + descripcion + ", Cantidad: " + cantidad + ", Precio: " + linea.getPrecioVenta());
                }

                System.out.println("Total del importe de la venta: " + total);
            }
        }
    }
}
