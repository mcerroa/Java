package aa5_woodshops;

public class Cliente {
    private String nif;
    private String nombre;

    //Constructores
    public Cliente(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    //Getters y setters

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
