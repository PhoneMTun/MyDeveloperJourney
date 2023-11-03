public class Bat extends Mammal{
    // super constructor
    public Bat(int energy){
        super(energy);
        
    }

    // Methods
    public void fly(){
        energy-=50;
        System.out.println("Bat is airborne");
    }
    public void eatHumans(){
        energy+=25;
        System.out.println("Bat is Happy eating Humans");
    }
    public void attackTown(){
        energy-=100;
        System.out.println("Bat is attackingTown");
    }


}