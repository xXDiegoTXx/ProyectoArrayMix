import java.util.ArrayList;

/**
 * Clase que gestiona un inventario de productos.
 * Permite agregar, consultar, actualizar y eliminar productos,
 * así como calcular el valor total del inventario.
 */
public class Inventario {
    private ArrayList<String> nombres;
    private ArrayList<Integer> cantidades;
    private ArrayList<Double> precios;
    private ArrayList<Integer> ids;
    private int siguienteId;

    /**
     * Constructor de la clase Inventario.
     * @param nombres Lista de nombres de productos.
     * @param cantidades Lista de cantidades de productos.
     * @param precios Lista de precios de productos.
     * @param ids Lista de IDs de productos.
     */
    public Inventario(ArrayList<String> nombres, ArrayList<Integer> cantidades,
                      ArrayList<Double> precios, ArrayList<Integer> ids) {
        this.nombres = nombres;
        this.cantidades = cantidades;
        this.precios = precios;
        this.ids = ids;
        this.siguienteId = 1; // ID autoincremental
    }

    /**
     * Agrega un producto al inventario.
     * @param nombre Nombre del producto.
     * @param cantidad Cantidad del producto.
     * @param precio Precio del producto.
     */
    public void agregarProducto(String nombre, int cantidad, double precio) {
        nombres.add(nombre);
        cantidades.add(cantidad);
        precios.add(precio);
        ids.add(siguienteId++);
    }

    /**
     * Consulta el inventario y devuelve una representación en texto.
     * @return Cadena con la información del inventario.
     */
    public String consultarInventario() {
        if (nombres.isEmpty()) return "Inventario vacío.\n";

        StringBuilder sb = new StringBuilder("Inventario:\n");
        for (int i = 0; i < nombres.size(); i++) {
            sb.append("ID: ").append(ids.get(i))
                    .append(" | Nombre: ").append(nombres.get(i))
                    .append(" | Cantidad: ").append(cantidades.get(i))
                    .append(" | Precio: $").append(precios.get(i))
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * Actualiza los datos de un producto.
     * @param id ID del producto a actualizar.
     * @param nuevoNombre Nuevo nombre del producto.
     * @param nuevoPrecio Nuevo precio del producto.
     * @param nuevaCantidad Nueva cantidad del producto.
     * @return Mensaje indicando si la actualización fue exitosa.
     */
    public String actualizarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevaCantidad) {
        int index = ids.indexOf(id);
        if (index != -1) {
            nombres.set(index, nuevoNombre);
            precios.set(index, nuevoPrecio);
            cantidades.set(index, nuevaCantidad);
            return "Producto actualizado correctamente.";
        } else {
            return "Producto no encontrado.";
        }
    }

    /**
     * Elimina un producto del inventario.
     * @param id ID del producto a eliminar.
     * @return Mensaje indicando si la eliminación fue exitosa.
     */
    public String eliminarProducto(int id) {
        int index = ids.indexOf(id);
        if (index != -1) {
            nombres.remove(index);
            cantidades.remove(index);
            precios.remove(index);
            ids.remove(index);
            return "Producto eliminado correctamente.";
        } else {
            return "Producto no encontrado.";
        }
    }

    /**
     * Calcula el valor total del inventario.
     * @return Valor total del inventario.
     */
    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < precios.size(); i++) {
            total += precios.get(i) * cantidades.get(i);
        }
        return total;
    }

    /**
     * Devuelve información sobre el sistema.
     * @return Información del sistema.
     */
    public String about() {
        return "Sistema de Inventario" +
                "\nDesarrollado por: " +
                "\n Product Owner: Diego Nicolás Torres Vega" +
                "\n Scrum Master: Samuel Gómez Neira" +
                "\n Development Team: Rafael Lemus Guzmán " +
                "\n y Jerson Andrés Soledad Velandia" +
                "\n Versión 1.0";
    }
}
