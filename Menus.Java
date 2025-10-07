import java.util.ArrayList;
import java.util.Scanner;

/*
Menus: dibuja un "menu" simple en consola y lee la opción.
*/

public class Menus{
    private int windowWidth = 30;
    private char borderChar = '*';
    private char firstOption = '1';

    // Constructor de clase
    public Menus(int windowWidth, char borderChar, char firstOption){
        this.windowWidth = windowWidth;
        this.borderChar = borderChar;
        this.firstOption = firstOption;
    }

    // Crear el menu usando un arraylist con la lista de opciones del menu
    // Ahora recibe Scanner externo y devuelve un int (1..n)
    public int createMenu(ArrayList<String> options, boolean CENTERED, Scanner input){
        boolean DRAW_MENU = true;                       // permite controlar el escape del ciclo de dibujo
        char optionId = firstOption;
        int option = 0;                                 // variable que recibe la opcion del usuario

        while(DRAW_MENU){
            // primero dibujar el borde superior
            optionId = firstOption;                    // carga el identificador de la primera opcion
            System.out.println(borderLine());
            for(String optionText : options){           // Imprime el menu
                if(CENTERED)
                    System.out.println(padding(optionId + ". " + optionText));
                else
                    System.out.println(optionId + ". " + optionText);
                optionId++;
            }
            // dibujar el borde inferior
            System.out.println(borderLine());
            System.out.print("Seleccione una opción (número): ");
            if (input.hasNextInt()) {
                option = input.nextInt();
                input.nextLine(); // consumir resto de línea
                if(option >= 1 && option <= options.size()){
                    DRAW_MENU = false;
                } else {
                    System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor escribe un número.");
                input.nextLine(); // consumir entrada inválida
            }
        }
        return option;
    }

    private String borderLine(){
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < this.windowWidth; i++){
            b.append(this.borderChar);
        }
        return b.toString();
    }

    private String padding(String text){
        int len = text.length();
        if(len >= this.windowWidth - 2) return text;
        int left = (this.windowWidth - len) / 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < left; i++) sb.append(' ');
        sb.append(text);
        return sb.toString();
    }
}
