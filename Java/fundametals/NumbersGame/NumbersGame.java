import java.util.Random;
public class NumbersGame {
    public static void main(String[] args){
        while(true){
            System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
            System.out.println("*********************************************************");
            System.out.println("Can you guess the number?");
            System.out.println("If you are not up to the task, you can always type 'q' to quit.");
            System.out.println("You have 3 attempts.");
            int attempt = 0;
            while(attempt <= 3){
                attempt++;
                if (attempt>3){
                    System.out.println("No more attempts left.");
                    break;
                }

                int answer = new Random().nextInt(0,10);
                System.out.println("The answer is >>>>>>>>>>> " + answer);
                String guess = System.console().readLine();
                if(guess.equals("q")){
                    System.out.println("I knew you didn't have it in you.");
                    System.out.println("Shutting down...");
                    break;
                }
                try{
                    if(Integer.parseInt(guess)<0 || Integer.parseInt(guess)>10){
                        System.out.println("Guest number between 0 and 10");
                    }
                    if(Integer.parseInt(guess)==answer){
                        System.out.println("Lucky guess! But can you do it again?");
                        break;
                    }else{
                        System.out.println("Swing and a miss! Keep trying...");
                    }
                }catch(NumberFormatException e){
                    System.out.println("This is not a valid answer");
                };
            }
            System.out.println("Do you want to play agin y|n?");
            String yesorno = System.console().readLine();
            if (yesorno==null || yesorno.toLowerCase().equals("n")){
                System.out.println("Game over. Shutting down...");
                break;
            }   
        }
    }
}

