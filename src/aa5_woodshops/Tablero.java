package aa5_woodshops;

public class Tablero extends Producto {
    private TipoTablero tipo;
    private double altura;
    private double anchura;

    //Constructores
    public Tablero(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock, TipoTablero tipo, double altura, double anchura) {
        super(codigo, descripcion, proveedor, precioVenta, stock, null);
        this.tipo = tipo;
        this.altura = altura;
        this.anchura = anchura;
    }

    //Getters


    @Override
    public String getTipo() {
        return tipo.toString();
    }

    public double getAltura() {
        return altura;
    }

    public double getAnchura() {
        return anchura;
    }

}
