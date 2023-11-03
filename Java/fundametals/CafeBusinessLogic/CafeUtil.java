import java.util.ArrayList;
import java.text.*;

public class CafeUtil{
    public int getStreakGoal(int numWeeks ){
        int sum= 0;
        for (int i = 1; i<=numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total=0;
        for (double price:prices){
            total+=price;
        }
        return total;
}
    public void displayMenu(ArrayList<String>menuitems){
        for (int i=0; i<=menuitems.size()-1; i++) {
            System.out.println(i +" "+ menuitems.get(i));
        }
}
    public void addCustomer(ArrayList<String>customers){
        System.out.println("Please enter your name:");
        String username = System.console().readLine();

        System.out.printf("Hello %s !",username);
        customers.add(username);

        System.out.printf("There are %s poeple in front of you.", customers.size());
        System.out.println("\n");
        System.out.println(customers);

}
    public void printPriceChart(String product, double price, int maxQuantity){
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double totalPrice = i * price-(0.5*i);
            String formattedPrice = myFormatter.format(totalPrice);
            System.out.printf("%d - $%s%n", i, formattedPrice);
        }
}
public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
    if (menuItems.size()!=prices.size()) {
        return false;
    }else{for (int i =0; i < menuItems.size(); i++){
        System.out.println(i+" "+menuItems.get(i)+"-- $"+  prices.get(i));
    }
    return true;
}
}
}