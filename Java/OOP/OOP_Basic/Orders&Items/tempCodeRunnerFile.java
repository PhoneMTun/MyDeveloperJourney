import java.util.ArrayList;
public class Order{
    String name;
    double total;
    boolean ready;
    ArrayList<Item> items;

    public Order(String name){
        this.name = name;
        this.total =0;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public void additem(Item item){
        this.items.add(item);
        this.total+= item.price;

}
}