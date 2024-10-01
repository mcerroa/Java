package aa5_woodshops;

public class ClienteProfesional extends ClienteRegistrado{
    private int descuento;

    //Constructores
    public ClienteProfesional(String nif, String nombre, int descuento) {
        super(nif, nombre);
        this.descuento = descuento;
    }

    //Getters y setters

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
