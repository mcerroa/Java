package aa5_woodshops;

public class ClienteWoodFriend extends ClienteRegistrado{
    private String codigoSocio;

    //Constructores
    public ClienteWoodFriend(String nif, String nombre, String codigoSocio) {
        super(nif, nombre);
        this.codigoSocio = codigoSocio;
    }

    //Getters y setters

    public String getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(String codigoSocio) {
        this.codigoSocio = codigoSocio;
    }
}
