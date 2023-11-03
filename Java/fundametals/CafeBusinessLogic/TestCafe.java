import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        
        CafeUtil appTest = new CafeUtil();

    /* 
      You will need add 1 line to this file to create an instance 
      of the CafeUtil class. 
      Hint: it will need to correspond with the variable name used below..
    */
    	
        /* ============ App Test Cases ============= */


    
        // System.out.println("\n----- Streak Goal Test -----");
        // System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(11));
    
        // System.out.println("----- Order Total Test-----");
        // double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        // System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));Ph
        
        // System.out.println("----- Display Menu Test-----");
        
        // ArrayList<String> menu = new ArrayList<String>();
        // menu.add("drip coffee");
        // menu.add("cappuccino");
        // menu.add("latte");
        // menu.add("mocha");
        // appTest.displayMenu(menu);
    
        // System.out.println("\n----- Add Customer Test-----");
        // ArrayList<String> customers = new ArrayList<String>();
        // // --- Test 4 times ---
        // for (int i = 0; i < 4; i++) {
        //     appTest.addCustomer(customers);
        //     System.out.println("\n");
        // }

        // Ninja Bonuses
        // appTest.printPriceChart("coffee", 10.00, 3);

        ArrayList<String> menuItems= new ArrayList<String>();
        ArrayList<Double> prices= new ArrayList<Double>();

        menuItems.add("coffee");
        menuItems.add("latte");

        prices.add(4.00);
        prices.add(5.00);


        System.out.print(appTest.displayMenu(menuItems,prices));
    }
}
