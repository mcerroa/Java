package aa5_woodshops;

public enum TipoProducto {
    TABLERO("Tablero"),
    BARNIZ("Barniz"),
    ARTICULO("Articulo");

    private final String descripcion;

    TipoProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
