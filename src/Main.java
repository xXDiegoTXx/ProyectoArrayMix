import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int Random = Inventario.generarNumeroAleatorio();
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<Integer> stock = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        Inventario library = new Inventario(ids, nombres, stock, precios);

        Scanner sc = new Scanner(System.in);
        int option = 1;
        do {
            mostrarMenu();
            option = sc.nextInt();
            sc.nextLine();
            if (option == 0) {
                System.out.println("=========================");
                System.out.println("Terminando el programa...");
            } else if (option == 1) {
                System.out.println("=========================");
                System.out.print("Ingrese el nombre del nuevo producto: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese la cantidad del nuevo producto: ");
                int cantidad = sc.nextInt();
                sc.nextLine();
                System.out.print("Ingrese el precio del producto: ");
                double precio = sc.nextDouble();
                sc.nextLine();  // limpiar buffer
                library.agregarProducto(nombre, cantidad, precio, Random);
                System.out.println();
                System.out.println("=========================");
            } else if (option == 2) {
                System.out.println("=========================");
                library.consultarInventario();
                System.out.println("=========================");
            } else if (option == 3) {
                System.out.println("=========================");
                System.out.print("Ingrese el ID del producto a actualizar: ");
                int idActualizar = sc.nextInt();
                sc.nextLine();
                System.out.print("Ingrese el nuevo nombre del producto: ");
                String nuevoNombre = sc.nextLine();
                System.out.print("Ingrese el nueva cantidad del producto: ");
                int nuevoStock= sc.nextInt();
                sc.nextLine();
                System.out.print("Ingrese el nuevo precio: ");
                double nuevoPrecio = sc.nextDouble();
                sc.nextLine();
                library.actualizarProducto(idActualizar, nuevoNombre, nuevoPrecio);
                System.out.println("=========================");
            } else if (option == 4) {
                System.out.println("=========================");
                System.out.print("Ingrese el ID del producto a eliminar: ");
                int deleteId = sc.nextInt();
                sc.nextLine();
                library.eliminarProducto(deleteId);
                System.out.println("=========================");
            } else if (option == 5) {
                System.out.println("=========================");
                library.calcularValorTotal();
                System.out.println("=========================");
            } else if (option ==6) {
                System.out.println("=========================");
                library.about();
                System.out.println("=========================");
            }

        } while (option != 0);
    }

    private static void mostrarMenu() {
        System.out.println("--- MENÚ DE INVENTARIO ---");
        System.out.println("1. Agregar producto");
        System.out.println("2. Consultar inventario");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Calcular valor total del inventario");
        System.out.println("6. Acerca de");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
