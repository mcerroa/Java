package aa5_woodshops;

public class LineaDetalle {
    private String descripcion;
    private int cantidad;
    private double precioVenta;

    //Constructores
    public LineaDetalle(String descripcion, int cantidad, double precioVenta) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    //Getters y setters


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
