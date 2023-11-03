public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double coffee = 2.5;
        double latte = 4.5;
        double cappuccino = 4.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;//Cinduri
        boolean isReadyOrder2 = true;//Sam
        boolean isReadyOrder3 = true;//Jimmy
        boolean isReadyOrder4 = true;//Noah

    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        // for Cindhuri
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        if (isReadyOrder1) {
            System.out.println(customer1+ readyMessage);
        }else{
            System.out.println(displayTotalMessage + coffee);
            System.out.println(customer1 + pendingMessage); 
        }

        // for Noah 
        System.out.println(customer4+" ordered cappuccino.");
        if (isReadyOrder4){
            System.out.println(customer4+readyMessage);
            System.out.println(displayTotalMessage+ cappuccino);
        } else{
            System.out.println(customer4+pendingMessage);
        }
        //for Sam
        System.out.println(customer2+" ordered 2 lattes.");
        System.out.println(displayTotalMessage+ latte*2);
        if (isReadyOrder2==false){
            System.out.println(customer2+pendingMessage);
        } else{
            System.out.println(customer2+readyMessage);
        }
        //for Jimmy
        System.out.println(customer3+" was wrongly charged.");
        String custoemr4order="latte";
        if (custoemr4order=="latte"){
            System.out.println(customer3+" "+ displayTotalMessage+ latte+ " not $" + coffee);
        }
    }
}

