import java.util.*;
public class Hashmatique_HashMap {
    public static void main(String[]args) {
    HashMap<String, String> userMap= new HashMap<String, String>();

    //store keys and values
    userMap.put("Hello", "Hello from the other side!");
    userMap.put("Baby", "I know you love me. I know you care.");
    userMap.put("Fall", "Why the sky fall.....");
    userMap.put("Mirrors", "Mirrors on the world. Here we are again. For my rise and fall, you been my only friend.");

    //Pick a song and get it from the HashMap
    System.out.println("Pick your sonng...");
    String pick= System.console().readLine();
    String song1=userMap.get(pick);
    System.out.println(song1);

    // loop through keys to print keys and values
    Set<String> keys= userMap.keySet();
    for(String key : keys){
        System.out.println(key+": "+ userMap.get(key));
    }
}
    }