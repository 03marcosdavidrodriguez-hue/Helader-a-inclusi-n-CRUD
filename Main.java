import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Heladeria> listaHeladerias = new ArrayList<Heladeria>();
    ArrayList<Helado> listaHelados = new ArrayList<Helado>();
    ArrayList<MalteadaObj> listaMalteadas = new ArrayList<MalteadaObj>();
    ArrayList<Toppings> listaToppings = new ArrayList<Toppings>();

    // Scanner global para reutilizarlo en todo el programa
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    // Menú principal y router hacia los CRUD
    public void run() {
        Menus menuPrincipal = new Menus(40, '-', '1');
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Heladerías");
        opciones.add("Helados");
        opciones.add("Malteadas");
        opciones.add("Toppings");
        opciones.add("Salir");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CADENA DE HELADERÍAS (MENU PRINCIPAL) ---");
            //pasar el booleano y el scanner por posición
            int opcion = menuPrincipal.createMenu(opciones, false, scanner);

            switch (opcion) {
                case 1:
                    Helpers.crudHeladerias(listaHeladerias, listaHelados, listaMalteadas, listaToppings, scanner);
                    break;
                case 2:
                    Helpers.crudHelados(listaHelados, scanner);
                    break;
                case 3:
                    Helpers.crudMalteadas(listaMalteadas, scanner);
                    break;
                case 4:
                    Helpers.crudToppings(listaToppings, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo... buena vibra ✌️");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        // Cierro scanner al final del programa
        scanner.close();
    }
}
