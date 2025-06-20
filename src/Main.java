import java.awt.*;
import javax.swing.*;

/**
 * Ventana principal del sistema de inventario.
 * Permite gestionar productos mediante una interfaz gráfica.
 */
public class Main extends JFrame {
    private Inventario inventario;
    private JTextArea areaTexto;

    /**
     * Constructor de la ventana principal.
     * Inicializa la interfaz gráfica y los componentes.
     */
    public Main() {
        setTitle("Sistema de Inventario");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inventario = new Inventario(
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>()
        );

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(7, 1));

        JButton btnAgregar = new JButton("Agregar Producto");
        JButton btnConsultar = new JButton("Consultar Inventario");
        JButton btnActualizar = new JButton("Actualizar Producto");
        JButton btnEliminar = new JButton("Eliminar Producto");
        JButton btnValorTotal = new JButton("Valor Total");
        JButton btnAcercaDe = new JButton("Acerca de");
        JButton btnSalir = new JButton("Salir");

        btnAgregar.addActionListener(e -> agregarProducto());
        btnConsultar.addActionListener(e -> mostrarTexto(inventario.consultarInventario()));
        btnActualizar.addActionListener(e -> actualizarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnValorTotal.addActionListener(e -> mostrarTexto("Valor total del inventario: $" + inventario.calcularValorTotal()));
        btnAcercaDe.addActionListener(e -> mostrarTexto(inventario.about()));
        btnSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(btnAgregar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnValorTotal);
        panelBotones.add(btnAcercaDe);
        panelBotones.add(btnSalir);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        getContentPane().add(panelBotones, BorderLayout.WEST);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Muestra un texto en el área de texto principal.
     * @param texto Texto a mostrar.
     */
    private void mostrarTexto(String texto) {
        areaTexto.setText(texto);
    }

    /**
     * Solicita los datos y agrega un producto al inventario.
     */
    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        String cantidadStr = JOptionPane.showInputDialog("Cantidad:");
        String precioStr = JOptionPane.showInputDialog("Precio:");

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            double precio = Double.parseDouble(precioStr);
            inventario.agregarProducto(nombre, cantidad, precio);
            mostrarTexto("Producto agregado correctamente.");
        } catch (Exception e) {
            mostrarTexto("Entrada inválida.");
        }
    }

    /**
     * Solicita los datos y actualiza un producto del inventario.
     */
    private void actualizarProducto() {
        String idStr = JOptionPane.showInputDialog("ID del producto a actualizar:");
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
        String nuevoPrecioStr = JOptionPane.showInputDialog("Nuevo precio:");
        String nuevaCantidadStr = JOptionPane.showInputDialog("Nueva cantidad:");

        try {
            int id = Integer.parseInt(idStr);
            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
            int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);

            String resultado = inventario.actualizarProducto(id, nuevoNombre, nuevoPrecio, nuevaCantidad);
            mostrarTexto(resultado);
        } catch (Exception e) {
            mostrarTexto("Entrada inválida.");
        }
    }

    /**
     * Solicita el ID y elimina un producto del inventario.
     */
    private void eliminarProducto() {
        String idStr = JOptionPane.showInputDialog("ID del producto a eliminar:");
        try {
            int id = Integer.parseInt(idStr);
            String resultado = inventario.eliminarProducto(id);
            mostrarTexto(resultado);
        } catch (Exception e) {
            mostrarTexto("Entrada inválida.");
        }
    }

    /**
     * Método principal. Inicia la aplicación.
     * @param args Argumentos de línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

