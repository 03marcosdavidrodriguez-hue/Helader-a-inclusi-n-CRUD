import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Helpers: contiene las rutinas CRUD por categoría.
Mantengo cada CRUD por separado (heladerias, helados, malteadas, toppings)
para no romper la estructura original y que sea fácil de entender.
*/

public class Helpers {

    // ---------------------- CRUD HELADERÍAS ----------------------
    public static void crudHeladerias(ArrayList<Heladeria> listaHeladerias,
                                      ArrayList<Helado> listaHelados,
                                      ArrayList<MalteadaObj> listaMalteadas,
                                      ArrayList<Toppings> listaToppings,
                                      Scanner input) {
        Menus menuCrud = new Menus(40, '-', '1');
        ArrayList<String> options = new ArrayList<>();
        options.add("Crear Heladería");
        options.add("Ver Heladería (por ID)");
        options.add("Editar Heladería (direccion)");
        options.add("Eliminar Heladería");
        options.add("Listar todas las Heladerías");
        options.add("Volver");

        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- CRUD HELADERÍAS ---");
            int opcion = menuCrud.createMenu(options, false, input);

            switch (opcion) {
                case 1:
                    crearHeladeria(listaHeladerias, input);
                    break;
                case 2:
                    verHeladeria(listaHeladerias, input);
                    break;
                case 3:
                    editarHeladeria(listaHeladerias, input);
                    break;
                case 4:
                    eliminarHeladeria(listaHeladerias, input);
                    break;
                case 5:
                    listarHeladerias(listaHeladerias);
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void crearHeladeria(ArrayList<Heladeria> listaHeladerias, Scanner input) {
        System.out.println("Crear Heladería - ingresa datos:");
        System.out.print("ID (número): ");
        int id = safeReadInt(input);
        System.out.print("Dirección: ");
        String direccion = safeReadLine(input);
        Heladeria h = new Heladeria(id, direccion);
        listaHeladerias.add(h);
        System.out.println("Heladería creada: " + h.getDireccion() + " (id:" + h.id + ")");
    }

    private static void verHeladeria(ArrayList<Heladeria> listaHeladerias, Scanner input) {
        System.out.print("Escribe el ID de la heladería a ver: ");
        int id = safeReadInt(input);
        Heladeria encontrada = null;
        for (Heladeria h : listaHeladerias) {
            if (h.id == id) {
                encontrada = h;
                break;
            }
        }
        if (encontrada != null) {
            System.out.println(encontrada);
            // mostrar contenidos
            System.out.println("Helados disponibles (objetos): " + encontrada.getHelados());
            System.out.println("Malteadas disponibles: " + encontrada.getMalteadas());
            System.out.println("Toppings locales: " + encontrada.getToppings());
            System.out.println("Pedidos: " + encontrada.getPedidos());
        } else {
            System.out.println("No se encontró la heladería con id " + id);
        }
    }

    private static void editarHeladeria(ArrayList<Heladeria> listaHeladerias, Scanner input) {
        System.out.print("ID de la heladería a editar: ");
        int id = safeReadInt(input);
        for (Heladeria h : listaHeladerias) {
            if (h.id == id) {
                System.out.println("Dirección actual: " + h.getDireccion());
                System.out.print("Nueva dirección: ");
                String nueva = safeReadLine(input);
                h.setDireccion(nueva);
                System.out.println("Dirección actualizada.");
                return;
            }
        }
        System.out.println("Heladería no encontrada.");
    }

    private static void eliminarHeladeria(ArrayList<Heladeria> listaHeladerias, Scanner input) {
        System.out.print("ID de la heladería a eliminar: ");
        int id = safeReadInt(input);
        Heladeria objetivo = null;
        for (Heladeria h : listaHeladerias) {
            if (h.id == id) {
                objetivo = h;
                break;
            }
        }
        if (objetivo != null) {
            listaHeladerias.remove(objetivo);
            System.out.println("Heladería eliminada.");
        } else {
            System.out.println("No encontrada.");
        }
    }

    private static void listarHeladerias(ArrayList<Heladeria> listaHeladerias) {
        System.out.println("Lista de Heladerías:");
        if (listaHeladerias.isEmpty()) {
            System.out.println(" (vacía)");
            return;
        }
        for (Heladeria h : listaHeladerias) {
            System.out.println(h);
        }
    }

    // ---------------------- CRUD HELADOS (clase Helado) ----------------------
    public static void crudHelados(ArrayList<Helado> listaHelados, Scanner input) {
        Menus menuCrud = new Menus(40, '-', '1');
        ArrayList<String> options = new ArrayList<>();
        options.add("Crear Helado (detalle)");
        options.add("Ver Helado (por ID)");
        options.add("Editar Helado (precio)");
        options.add("Eliminar Helado");
        options.add("Listar todos los Helados");
        options.add("Volver");

        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- CRUD HELADOS (Clase Helado) ---");
            int opcion = menuCrud.createMenu(options, false, input);

            switch (opcion) {
                case 1:
                    crearHelado(listaHelados, input);
                    break;
                case 2:
                    verHelado(listaHelados, input);
                    break;
                case 3:
                    editarHelado(listaHelados, input);
                    break;
                case 4:
                    eliminarHelado(listaHelados, input);
                    break;
                case 5:
                    listarHelados(listaHelados);
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void crearHelado(ArrayList<Helado> listaHelados, Scanner input) {
        System.out.print("ID del helado: ");
        int id = safeReadInt(input);
        System.out.print("Nombre: ");
        String nombre = safeReadLine(input);
        System.out.print("Precio base (ej: 4200): ");
        float precio = safeReadFloat(input);
        System.out.print("Tipo (número entero): ");
        int tipo = safeReadInt(input);
        System.out.println("Ahora ingresa sabores (escribe 'fin' para terminar):");
        ArrayList<String> sabores = new ArrayList<>();
        while (true) {
            System.out.print("Sabor: ");
            String s = safeReadLine(input);
            if (s.equalsIgnoreCase("fin")) break;
            if (!s.trim().isEmpty()) sabores.add(s);
        }
        Helado h = new Helado(id, nombre, precio, sabores, tipo);
        listaHelados.add(h);
        System.out.println("Helado creado: " + h.nombre + " (id:" + h.id + ")");
    }

    private static void verHelado(ArrayList<Helado> listaHelados, Scanner input) {
        System.out.print("ID del helado a ver: ");
        int id = safeReadInt(input);
        for (Helado h : listaHelados) {
            if (h.id == id) {
                System.out.println("ID: " + h.id);
                System.out.println("Nombre: " + h.nombre);
                System.out.println("Precio base: " + h.getPrecio());
                System.out.println("Sabores: " + h.getSabores());
                System.out.println("Toppings aplicados: " + h.getToppings());
                System.out.println("Precio con toppings (calc): " + h.calcularPrecio());
                return;
            }
        }
        System.out.println("Helado no encontrado.");
    }

    private static void editarHelado(ArrayList<Helado> listaHelados, Scanner input) {
        System.out.print("ID del helado a editar: ");
        int id = safeReadInt(input);
        for (Helado h : listaHelados) {
            if (h.id == id) {
                System.out.println("Precio actual: " + h.getPrecio());
                System.out.print("Nuevo precio: ");
                float p = safeReadFloat(input);
                h.setPrecio(p);
                System.out.println("Precio actualizado.");
                return;
            }
        }
        System.out.println("Helado no encontrado.");
    }

    private static void eliminarHelado(ArrayList<Helado> listaHelados, Scanner input) {
        System.out.print("ID del helado a eliminar: ");
        int id = safeReadInt(input);
        Helado target = null;
        for (Helado h : listaHelados) {
            if (h.id == id) {
                target = h;
                break;
            }
        }
        if (target != null) {
            listaHelados.remove(target);
            System.out.println("Helado eliminado.");
        } else {
            System.out.println("No encontrado.");
        }
    }

    private static void listarHelados(ArrayList<Helado> listaHelados) {
        System.out.println("Helados registrados:");
        if (listaHelados.isEmpty()) {
            System.out.println(" (vacío)");
            return;
        }
        for (Helado h : listaHelados) {
            System.out.println("ID:" + h.id + " - " + h.nombre + " - Precio base: " + h.getPrecio() + " - Sabores: " + h.getSabores());
        }
    }

    // ---------------------- CRUD MALTEADAS (MalteadaObj) ----------------------
    public static void crudMalteadas(ArrayList<MalteadaObj> listaMalteadas, Scanner input) {
        Menus menuCrud = new Menus(40, '-', '1');
        ArrayList<String> options = new ArrayList<>();
        options.add("Crear Malteada");
        options.add("Ver Malteada (por ID)");
        options.add("Editar Malteada (precio)");
        options.add("Eliminar Malteada");
        options.add("Listar Malteadas");
        options.add("Volver");

        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- CRUD MALTEADAS ---");
            int opcion = menuCrud.createMenu(options, false, input);
            switch (opcion) {
                case 1:
                    crearMalteada(listaMalteadas, input);
                    break;
                case 2:
                    verMalteada(listaMalteadas, input);
                    break;
                case 3:
                    editarMalteada(listaMalteadas, input);
                    break;
                case 4:
                    eliminarMalteada(listaMalteadas, input);
                    break;
                case 5:
                    listarMalteadas(listaMalteadas);
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void crearMalteada(ArrayList<MalteadaObj> listaMalteadas, Scanner input) {
        System.out.print("ID: ");
        int id = safeReadInt(input);
        System.out.print("Sabor: ");
        String s = safeReadLine(input);
        System.out.print("Precio: ");
        double p = safeReadDouble(input);
        MalteadaObj m = new MalteadaObj(id, s, p);
        listaMalteadas.add(m);
        System.out.println("Malteada creada.");
    }

    private static void verMalteada(ArrayList<MalteadaObj> listaMalteadas, Scanner input) {
        System.out.print("ID de la malteada: ");
        int id = safeReadInt(input);
        for (MalteadaObj m : listaMalteadas) {
            if (m.getId() == id) {
                System.out.println("ID: " + m.getId());
                System.out.println("Sabor: " + m.getSabor());
                System.out.println("Precio: " + m.getPrecio());
                return;
            }
        }
        System.out.println("No encontrada.");
    }

    private static void editarMalteada(ArrayList<MalteadaObj> listaMalteadas, Scanner input) {
        System.out.print("ID de la malteada a editar: ");
        int id = safeReadInt(input);
        for (MalteadaObj m : listaMalteadas) {
            if (m.getId() == id) {
                System.out.println("Precio actual: " + m.getPrecio());
                System.out.print("Nuevo precio: ");
                double p = safeReadDouble(input);
                m.setPrecio(p);
                System.out.println("Precio actualizado.");
                return;
            }
        }
        System.out.println("No encontrada.");
    }

    private static void eliminarMalteada(ArrayList<MalteadaObj> listaMalteadas, Scanner input) {
        System.out.print("ID de la malteada a eliminar: ");
        int id = safeReadInt(input);
        MalteadaObj target = null;
        for (MalteadaObj m : listaMalteadas) {
            if (m.getId() == id) {
                target = m;
                break;
            }
        }
        if (target != null) {
            listaMalteadas.remove(target);
            System.out.println("Malteada eliminada.");
        } else {
            System.out.println("No encontrada.");
        }
    }

    private static void listarMalteadas(ArrayList<MalteadaObj> listaMalteadas) {
        System.out.println("Malteadas:");
        if (listaMalteadas.isEmpty()) {
            System.out.println(" (vacío)");
            return;
        }
        for (MalteadaObj m : listaMalteadas) {
            System.out.println("ID:" + m.getId() + " - " + m.getSabor() + " - Precio: " + m.getPrecio());
        }
    }

    // ---------------------- CRUD TOPPINGS (Toppings) ----------------------
    public static void crudToppings(ArrayList<Toppings> listaToppings, Scanner input) {
        Menus menuCrud = new Menus(40, '-', '1');
        ArrayList<String> options = new ArrayList<>();
        options.add("Crear Topping (cat simple)");
        options.add("Ver Topping (por nombre)");
        options.add("Editar Topping (precio)");
        options.add("Eliminar Topping");
        options.add("Listar Toppings");
        options.add("Volver");

        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- CRUD TOPPINGS ---");
            int opcion = menuCrud.createMenu(options, false, input);
            switch (opcion) {
                case 1:
                    crearTopping(listaToppings, input);
                    break;
                case 2:
                    verTopping(listaToppings, input);
                    break;
                case 3:
                    editarTopping(listaToppings, input);
                    break;
                case 4:
                    eliminarTopping(listaToppings, input);
                    break;
                case 5:
                    listarToppings(listaToppings);
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void crearTopping(ArrayList<Toppings> listaToppings, Scanner input) {
        System.out.print("Nombre del topping: ");
        String nombre = safeReadLine(input);
        System.out.print("Precio: ");
        float precio = safeReadFloat(input);
        Toppings t = new Toppings();
        t.setNombre(nombre);
        t.setPrecio(precio);
        ArrayList<String> ing = new ArrayList<>();
        System.out.println("Agrega ingredientes (escribe 'fin' para terminar):");
        while (true) {
            System.out.print("Ingrediente: ");
            String i = safeReadLine(input);
            if (i.equalsIgnoreCase("fin")) break;
            if (!i.trim().isEmpty()) ing.add(i);
        }
        t.setIngredientes(ing);
        listaToppings.add(t);
        System.out.println("Topping creado.");
    }

    private static void verTopping(ArrayList<Toppings> listaToppings, Scanner input) {
        System.out.print("Nombre del topping a ver: ");
        String nombre = safeReadLine(input);
        for (Toppings t : listaToppings) {
            if (t.getNombre() != null && t.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Nombre: " + t.getNombre());
                System.out.println("Precio: " + t.getPrecio());
                System.out.println("Ingredientes: " + t.getIngredientes());
                return;
            }
        }
        System.out.println("No encontrado.");
    }

    private static void editarTopping(ArrayList<Toppings> listaToppings, Scanner input) {
        System.out.print("Nombre del topping a editar: ");
        String nombre = safeReadLine(input);
        for (Toppings t : listaToppings) {
            if (t.getNombre() != null && t.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Precio actual: " + t.getPrecio());
                System.out.print("Nuevo precio: ");
                float p = safeReadFloat(input);
                t.setPrecio(p);
                System.out.println("Actualizado.");
                return;
            }
        }
        System.out.println("No encontrado.");
    }

    private static void eliminarTopping(ArrayList<Toppings> listaToppings, Scanner input) {
        System.out.print("Nombre del topping a eliminar: ");
        String nombre = safeReadLine(input);
        Toppings objetivo = null;
        for (Toppings t : listaToppings) {
            if (t.getNombre() != null && t.getNombre().equalsIgnoreCase(nombre)) {
                objetivo = t;
                break;
            }
        }
        if (objetivo != null) {
            listaToppings.remove(objetivo);
            System.out.println("Eliminado.");
        } else {
            System.out.println("No encontrado.");
        }
    }

    private static void listarToppings(ArrayList<Toppings> listaToppings) {
        System.out.println("Toppings registrados:");
        if (listaToppings.isEmpty()) {
            System.out.println(" (vacío)");
            return;
        }
        for (Toppings t : listaToppings) {
            System.out.println("Nombre: " + t.getNombre() + " - Precio: " + t.getPrecio() + " - Ingredientes: " + t.getIngredientes());
        }
    }

    // ---------------------- UTILIDADES de lectura seguras ----------------------
    // Lecturas seguras para evitar problemas con nextInt/nextLine
    private static int safeReadInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Por favor escribe un número válido: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // consumir resto de línea
        return val;
    }

    private static float safeReadFloat(Scanner sc) {
        while (!sc.hasNextFloat() && !sc.hasNextDouble()) {
            System.out.print("Por favor escribe un número válido (float): ");
            sc.next();
        }
        float val = sc.nextFloat();
        sc.nextLine();
        return val;
    }

    private static double safeReadDouble(Scanner sc) {
        while (!sc.hasNextDouble() && !sc.hasNextFloat()) {
            System.out.print("Por favor escribe un número válido (double): ");
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }

    private static String safeReadLine(Scanner sc) {
        String line = sc.nextLine();
        return line.trim();
    }
}
