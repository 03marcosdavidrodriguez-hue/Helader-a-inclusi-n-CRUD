import java.util.ArrayList;

public class Helado{
    public int id;
    public String nombre;
    public float precio;
    private float precioTopping;
    private ArrayList<String> sabores;
    private ArrayList<String> toppings;
    private int tipo;
    // Constructor de clase
    public Helado(int id, String nombre, float precio, ArrayList<String> sabores, int tipo){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.sabores = sabores;
        this.tipo = tipo;
        this.toppings = new ArrayList<String>();
        this.precioTopping = 500;
    }
    // Metodos de clase
    public float calcularPrecio(){
        float precioTotal = 0;
        int nroToppings = this.toppings.size();
        precioTotal = this.precio + (this.precioTopping * nroToppings);
        return precioTotal;
    }



    // Setters
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public void setPrecioTopping(float precioTopping){
        this.precioTopping = precioTopping;
    }
    //
    public void setSabores(ArrayList<String> sabores){
        this.sabores = sabores;
    }

    public void addTopping(String toppingType){
        this.toppings.add(toppingType);
    }
    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    // Getters
    public float getPrecio(){
        return this.precio;
    }

    public ArrayList<String> getSabores(){
        return this.sabores;
    }
    public ArrayList<String> getToppings(){
        return this.toppings;
    }
    public int getTipo(){
        return this.tipo;
    }
    public float getPrecioTopping(){
        return this.precioTopping;
    }

    @Override
    public String toString() {
        return "Helado {id=" + id + ", nombre='" + nombre + "', precioBase=" + precio + ", sabores=" + sabores + ", toppings=" + toppings + "}";
    }
}
