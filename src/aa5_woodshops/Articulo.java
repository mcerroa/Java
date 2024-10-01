package aa5_woodshops;

public class Articulo extends Producto {
    private TipoArticulo tipo;

    //Constructor
    public Articulo(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock, TipoArticulo tipo) {
        super(codigo, descripcion, proveedor, precioVenta, stock, null);
        this.tipo = tipo;
    }

    //Getters
    @Override
    public String getTipo() {
        return tipo.toString();
    }
}
