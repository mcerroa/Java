package aa5_woodshops;

import java.util.HashMap;
import java.util.Map;

public class Tienda {
    private String nombre;
    private Map<String, Producto> inventario = new HashMap<>();

    //Constructores
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.inventario = new HashMap<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Map<String, Producto> getInventario() {
        return inventario;
    }

    // Método para añadir un producto al inventario
    public void agregarProducto(Producto producto) {
        inventario.put(producto.getCodigo(), producto);
    }

    //Método para listar los productos de una tienda
    void listarProductos() {
        for (Producto producto : inventario.values()) {
            System.out.println(producto.getDescripcion());
        }
    }

    // Método para mostrar stock de un producto por código
    public void mostrarStock(String codigo) {
        if (inventario.containsKey(codigo)) {
            System.out.println("Stock: " + inventario.get(codigo).getStock());
        } else {
            System.out.println("Producto no disponible en esta tienda.");
        }
    }
}
