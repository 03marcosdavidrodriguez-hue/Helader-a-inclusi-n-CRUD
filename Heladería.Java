import java.util.ArrayList;

public class Heladeria {
    public int id;
    private String direccion;
    private ArrayList<HeladoObj> helados;
    private ArrayList<MalteadaObj> malteadas;
    private ArrayList<ToppingLocal> toppings;
    private ArrayList<Pedido> pedidos;

    public Heladeria(int id, String direccion){
        this.id = id;
        this.direccion = direccion;
        this.helados = new ArrayList<HeladoObj>();
        this.malteadas = new ArrayList<MalteadaObj>();
        this.toppings = new ArrayList<ToppingLocal>();
        this.pedidos = new ArrayList<Pedido>();
    }

    // setters
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setHelados(ArrayList<HeladoObj> lista){
        this.helados = lista;
    }

    public void setMalteadas(ArrayList<MalteadaObj> lista){
        this.malteadas = lista;
    }

    public void setToppings(ArrayList<ToppingLocal> lista){
        this.toppings = lista;
    }

    public void addPedido(Pedido p){
        this.pedidos.add(p);
    }

    public void addHelado(HeladoObj h){
        this.helados.add(h);
    }

    public void addMalteada(MalteadaObj m){
        this.malteadas.add(m);
    }

    public void addTopping(ToppingLocal t){
        this.toppings.add(t);
    }

    // getters
    public String getDireccion(){
        return this.direccion;
    }

    public ArrayList<HeladoObj> getHelados(){
        return this.helados;
    }

    public ArrayList<MalteadaObj> getMalteadas(){
        return this.malteadas;
    }

    public ArrayList<ToppingLocal> getToppings(){
        return this.toppings;
    }

    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }

    @Override
    public String toString() {
        return "Heladeria {id=" + id + ", direccion='" + direccion + "', helados=" + helados.size()
                + ", malteadas=" + malteadas.size() + ", toppings=" + toppings.size() + ", pedidos=" + pedidos.size() + "}";
    }
}
