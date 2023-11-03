public class TestOrders {
    public static void main(String[] args){
        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();

        coffeeKiosk.addMenuItem("coffee", 4);
        coffeeKiosk.addMenuItem("matcha", 4.5);
        coffeeKiosk.addMenuItem("caramel", 5);


        coffeeKiosk.newOrder();
    }
}
