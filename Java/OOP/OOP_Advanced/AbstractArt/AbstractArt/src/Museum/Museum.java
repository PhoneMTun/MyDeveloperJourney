package Museum;

import java.util.ArrayList;
import java.util.Collections;



import Museum.*;

public class Museum {

	public static void main(String[] args) {
		ArrayList<Art> museum = new ArrayList<Art> ();
		museum.add(new Painting("Holo","Phone", "How to beome immortal", "Digital Graphics"));
		museum.add(new Painting("Rich","Zarni", "How to beome immortal", "Digital Graphics"));
		museum.add(new Painting("Chicken","Sandar", "How to beome immortal", "Digital Graphics"));
		museum.add(new Sculpture("Pork","Tun", "How to beome immortal", "Digital Graphics"));
		museum.add(new Sculpture("Sandwich","Alex", "How to beome immortal", "Digital Graphics"));
// TODO Auto-generated method stub
		Collections.shuffle(museum);
			museum.get(1).viewArt();
		
		

	}

}
