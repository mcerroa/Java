package aa5_woodshops;

public abstract class Producto {
    private String codigo;
    private String descripcion;
    private Proveedor proveedor;
    private double precioVenta;
    private int stock;

    //Constructores
    public Producto(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock, TipoProducto tipoProducto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    //Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método abstracto para obtener el tipo de producto
    public abstract String getTipo();

}

