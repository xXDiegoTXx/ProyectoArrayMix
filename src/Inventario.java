import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Inventario {

    private ArrayList<Integer> ids;
    private ArrayList<String> nombres;
    private ArrayList<Integer> stock;
    private ArrayList<Double> precios;
    private int contadorID = 1;

    public Inventario(ArrayList<Integer> ids, ArrayList<String> nombres, ArrayList<Integer> stock, ArrayList<Double> precios) {
        this.ids = ids;
        this.nombres = nombres;
        this.stock = stock;
        this.precios = precios;
    }

    public void agregarProducto(String nombre, int cantidad, double precio, int Random) {
        System.out.println();
        if (nombres.contains(nombre)) {
            System.out.println("Error: ya existe un producto con ese nombre en el inventario.");
            return;
        }
        ids.add(Random*contadorID ++);
        nombres.add(nombre);
        stock.add(cantidad);
        precios.add(precio);
        System.out.println("Producto agregado correctamente.");
        System.out.println();
    }
    public static int generarNumeroAleatorio() {
        Random random=new Random();
        return random.nextInt(10000) + 1;
    }
    public void consultarInventario() {
        System.out.println();
        if (nombres.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("Inventario actual:");
        Locale locale = new Locale("es", "CO");
        NumberFormat cop = NumberFormat.getNumberInstance(locale);

        for (int i = 0; i < nombres.size(); i++) {
            String precio = cop.format(precios.get(i));
            System.out.pintln( "Nombre: " + nombres.get(i));
            System.out.println("ID: " + ids.get(i));
            System.out.println("Cantidad: " + stock.get(i));
            System.out.println("Precio: $" + precio);
            System.out.println("--------------------------");
        }
        System.out.println();
    }

    public void actualizarProducto(int id, String nuevoNombre, double nuevoPrecio) {
        System.out.println();
        int index = ids.indexOf(id);
        if (index != -1) {
            nombres.set(index, nuevoNombre);
            precios.set(index, nuevoPrecio);
            precios.set(index, nuevoPrecio);
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("ID no encontrado en el inventario.");
        }
        System.out.println();
    }

    public void eliminarProducto(int id) {
        System.out.println();
        int index = ids.indexOf(id);
        if (index != -1) {
            ids.remove(index);
            nombres.remove(index);
            precios.remove(index);
            stock.remove(index);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("ID no encontrado.");
        }
        System.out.println();
    }
    public void calcularValorTotal(){
        System.out.println();
        Locale locale = new Locale("es", "CO");
        NumberFormat cop = NumberFormat.getNumberInstance(locale);
        boolean vacio=true;
        double valor=0;
        for (int i=0; i< nombres.size();i++){
            if (nombres.isEmpty()){
                break;
            }else {
                vacio=false;
                valor= valor+stock.get(i)* precios.get(i);
            }
        }
        String precio = cop.format(valor);
        if (vacio){
            System.out.println("El inventario está vacío.");
        }else {
            System.out.println("El valor total del inventario es de: $"+precio);
        }
        System.out.println();
    }
    public void about(){
        System.out.println();
        System.out.println("Product Owner: Diego Nicolás Torres Vega");
        System.out.println("Scrum Master: Samuel Gómez Neira");
        System.out.println("Development Team: Rafael Lemus Guzmán y Jerson Andrés Soledad Velandia");
        System.out.println();
    }
}
