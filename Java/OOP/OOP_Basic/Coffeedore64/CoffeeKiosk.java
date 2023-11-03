import java.util.*;
// variables
public class CoffeeKiosk{
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

// constructor
    public CoffeeKiosk(){
        this.menu= new ArrayList<Item>();
        this.orders= new ArrayList<Order>();
    }
// Methods
    public void addMenuItem(String name, double price){
        Item newitem= new Item(name, price);
        menu.add(newitem);
        newitem.setIndex(menu.indexOf(newitem));
    }
    public void displayMenu(){
        for (Item item : menu){
            System.out.printf(" %s %s -- $%s", item.getIndex(), item.getName(), item.getPrice());
    }
}
    // new new order method
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Order order = new Order(name);
        displayMenu();

        
    	// Prompts the user to enter an item number
        System.out.println("\nPlease enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            order.addItem(menu.get(Integer.parseInt(itemNumber)));

            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        order.display();
        // After you have collected their order, print the order details 
        
        
    }
    public void addMenuItemByInput(){
        System.out.println("Enter the item that you want to order:");
        String Item= System.console().readLine();
        System.out.println("Enter price  that you want to order:");
        String Price= System.console().readLine();
        addMenuItem(Item,Double.parseDouble(Price));
}

}
