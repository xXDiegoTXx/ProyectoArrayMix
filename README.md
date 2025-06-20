Proyecto de Gestión de Inventario

Este proyecto tiene como objetivo desarrollar un programa de Gestión de Inventario. El cuál debe funcionar mediante un menú interactivo que permita al usuario; agregar productos, consultar productos, actualizar productos y eliminar productos.

Funcionalidades:

1. Añadir Producto: Permite al usuario agregar nuevos productos al inventario generándole un ID.


2. Consultar Inventario: Permite al usuario consultar la lista de productos cn su nombre, cantidad y precio.


3. Actualizar Producto: Permite al usuario modificar y actualizar por su ID.


4. Eliminar Producto: Permite eliminar un producto de la lista del inventario por su ID.


5. Ficha Técnica: Muestra la información del equipo de desarrollo, roles y eslogan del proyecto.

Clase Inventario:
Clase que representa un sistema de gestión de inventario de productos.
Permite realizar operaciones CRUD (crear, leer, actualizar, eliminar)
y calcular el valor total del inventario.

Constructor:
Inventario(ArrayList<String> nombres, ArrayList<Integer> cantidades, ArrayList<Double> precios, ArrayList<Integer> ids)
Inicializa una nueva instancia del inventario con listas dadas de productos y configura el ID inicial en 1.

Atributos:
nombres	| ArrayList<String> | Lista de nombres de productos.
cantidades | ArrayList<Integer> |	Lista de cantidades disponibles de cada producto.
precios	| ArrayList<Double>	| Lista de precios unitarios por producto.
ids	| ArrayList<Integer> | Lista de IDs únicos asignados a cada producto.
siguienteId	| int	| Controla el ID autoincremental para los nuevos productos.

Métodos:
agregarProducto(String nombre, int cantidad, double precio)	| void	| Agrega un nuevo producto al inventario con un ID único autogenerado.
consultarInventario()	| String	| Devuelve una cadena con toda la información del inventario o un mensaje si está vacío.
actualizarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevaCantidad)	| String |	Actualiza la información de un producto según su ID. Retorna un mensaje de éxito o error.
eliminarProducto(int id) |	String	| Elimina un producto por su ID. Retorna un mensaje de confirmación o de error si no se encuentra.
calcularValorTotal()	| double |	Calcula y retorna el valor monetario total del inventario (precio * cantidad de cada producto).
about()	| String |	Devuelve información sobre el sistema y los desarrolladores del proyecto.


Tecnologías Utilizadas:
IntelliJ IDEA Community Edition.
GitBash.
GitHub.
JavaDoc.
Microsoft Teams.


Cómo Ejecutar el Proyecto

1. Instalar IntelliJ IDEA Community Edition y Java (cualquier versión) en el computador.


2. Descargar los archivos correspondientes.


3. Ejecutar IntelliJ IDEA Community Edition


4. Clonar el repositorio con la URL.


5. Ejecutar la clase Main.
