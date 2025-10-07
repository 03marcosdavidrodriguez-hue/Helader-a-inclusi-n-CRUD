public class Pedido {
    private int id;
    private String cliente;

    public Pedido(int id, String cliente){
        this.id = id;
        this.cliente = cliente;
    }

    // setters
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    // getters
    public int getId(){
        return this.id;
    }

    public String getCliente(){
        return this.cliente;
    }

    @Override
    public String toString() {
        return "Pedido {id=" + id + ", cliente='" + cliente + "'}";
    }
}
