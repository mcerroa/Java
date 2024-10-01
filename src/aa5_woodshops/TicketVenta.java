package aa5_woodshops;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TicketVenta extends Tienda{
    private int numeroTicket;
    private Date fecha;
    private  Cliente cliente;
    private ArrayList<LineaDetalle> lineasDetalle;
    private Tienda tienda;

    //Constructores
    public TicketVenta(String nombre, int numeroTicket, Date fecha, Cliente cliente) {
        super(nombre);
        this.numeroTicket = numeroTicket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineasDetalle = new ArrayList<>();
        this.tienda = tienda;
    }

    //Métodos para gestionar líneas de detalle
    public void agregarLineaDetalle(LineaDetalle linea) {
        lineasDetalle.add(linea);
    }

    public ArrayList<LineaDetalle> obtenerLineasDetalle() {
        return lineasDetalle;
    }

    // Método para obtener la fecha formateada
    public String obtenerFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    //Getters y setters


    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
