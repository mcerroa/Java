package aa5_woodshops;

public class Proveedor {
    private String nif;
    private String nombre;

    //Constructores
    public Proveedor(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    //Getters

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }
}
