public class TestOrders{
    public static void main(String[] args){

        // Iterms in the menu
        Item item1 = new Item("drip coffee", 1.60);
        Item item2 = new Item("capuccino", 2.45);
        Item item3 = new Item("iced coffee", 2.15);
        Item item4 = new Item("mocha", 3.10);

        //  orders for unspecified guests. Do not specify a name.
        Order order1 = new Order();
        Order order2 = new Order();

        // 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Phone");
        Order order4 = new Order("Kevin");
        Order order5 = new Order("Chelsea");

        // Add at least 2 items
        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item3);
        order2.addItem(item4);

        order3.addItem(item1);
        order3.addItem(item3);

        order4.addItem(item2);
        order4.addItem(item4);

        order5.addItem(item1);
        order5.addItem(item4);

        // Status
        System.out.println(order1.getStatusMessage());
        order5.setReady(true);
        System.out.println(order5.getStatusMessage());

        // total
        System.out.println(order1.getOrderTotal());

        // display all orders
        order1.display();
        order2.display();
        order3.display();
        order4.display();



    }
}