import java.util.*;


public class PuzzleJava{
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> random10= new ArrayList<Integer>();
        Random randno= new Random();
        for (int i=1; i<=10; i++){
            random10.add(randno.nextInt(20)+1);
    }
    return random10;
    }
    
    public String getRandomLetterArray(){
        Random randletter= new Random();
        String atoz= "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet= new String[26];
        for (int i=0; i<26; i++){
            alphabet[i]=String.valueOf(atoz.charAt(i));
        }
        return alphabet[randletter.nextInt(26)];

}
    public String getRandomLetter() {

        Random rand = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        char randomChar = alphabetString.charAt(rand.nextInt(26));

        return String.valueOf(randomChar);
    }
    public String generatePassword() {
        String password="";
        for (int i=0; i<=8; i++){
            password=password+getRandomLetter();
        }
        return password;

            
        }
    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> passwordSet= new ArrayList<String>();
        for (int i=0; i<length; i++){
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }
    public void shuffleArray(int[] array){
        Random rand = new Random();
        for( int i=0; i < array.length; i++ ){
            int randindex= rand.nextInt(array.length);

        // Constantly swapping
        int temp= array[i];
        array[i]=array[randindex];
        array[randindex]=temp;
        }
}
}