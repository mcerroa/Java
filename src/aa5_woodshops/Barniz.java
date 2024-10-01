package aa5_woodshops;

public class Barniz extends Producto {
    private TipoBarniz tipo;
    private int mililitros;

    //Constructores
    public Barniz(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock, TipoBarniz tipo, int mililitros) {
        super(codigo, descripcion, proveedor, precioVenta, stock, null);
        this.tipo = tipo;
        this.mililitros = mililitros;
    }

    //Getters


    @Override
    public String getTipo() {
        return tipo.toString();
    }

    public int getMililitros() {
        return mililitros;
    }

}
