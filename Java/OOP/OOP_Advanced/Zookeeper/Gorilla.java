public class Gorilla extends Mammal{
    public Gorilla(int energy) {
        super(energy);
    }
    public void throwSomething(){
        energy-=5;
        System.out.println("Gorilla has thrown something");
    }
    public void eatBanana(){
        energy+=10;
        System.out.println("Gorilla ys happy");
    }
    public void climb(){
        energy-=10;
        System.out.println("Gorilla has climbed the tree");
    }
    }

