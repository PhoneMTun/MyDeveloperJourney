import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items -- Item1,Item2,Item3,Item4
        Item Item1 = new Item("Mocha",4.50);
        Item Item2 = new Item("Latte",4.50);
        Item Item3 = new Item("Drip Coffe",4.00 );
        Item Item4 = new Item("cappuccino", 4.50);


        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        // Predict--Print order1 object 
        // System.out.println(order1);
        // Predict--Print order1.total object 
        // System.out.println(order1.total);
    
        //  Application Simulations
        // add item1 to order2
        // order2.additem(Item1);
        // order3.additem(Item4);
        // order4.additem(Item2);

        //Ready Order
        // order1.ready();
        // order2.ready();
        //order 2 more Sam
        // for (int i = 0; i<2; i++){
        //     order4.additem(Item2);
        }
        




        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}
