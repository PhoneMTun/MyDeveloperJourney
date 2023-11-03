import java.util.*;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		// ArrayList<Integer> randomRolls = generator.getTenRolls();
		// System.out.println(randomRolls);
		
    	        //..
		// System.out.println(generator.getRandomLetterArray());
		// System.out.println(generator.getRandomLetter());
		// System.out.println(generator.generatePassword());
		// ArrayList<String> randomPass = generator.getNewPasswordSet(8);
		// System.out.println(randomPass);

		int[] randarray = {1,2,3,4,5};
		System.out.println(Arrays.toString(randarray));
		generator.shuffleArray(randarray);
		System.out.println(Arrays.toString(randarray));
	
	
}
}
