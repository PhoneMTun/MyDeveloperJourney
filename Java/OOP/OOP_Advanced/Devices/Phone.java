
public class Phone extends Device {
    public void makeCall(){
        if (battery>=10){
            System.out.println("Battery critical");
        }

        System.out.println("Making a call...");
        battery -= 5;
        System.out.println("Battery decrease by 5 percent...");
    }
    public void playGame(){
        System.out.print(">>>>>>>>"+battery +"%");
        if (battery<=25){
            System.out.print("Battery below 25 charge your phone.") ;
            if (battery>=10){
            System.out.println("Battery critical");
            }
            return;
        }
        System.out.println("Playing game...");
        battery -= 20;
        System.out.println("Battery decrease by 20 percent...");
    }
    public void batteryCharge(){
        System.out.println("Charging battery...");
        battery += 50;
        System.out.println("Charging battery increase by 50 percent...");
    }


}
