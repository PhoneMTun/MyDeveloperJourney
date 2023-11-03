import java.util.Date;
import java.text. SimpleDateFormat;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name, String date) {
        Date currentdate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EE");
        String currentday=format.format(currentdate);
        return String.format("Hello %s.Lovely to see you. What a beautiful %s", name, currentday);
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently" + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis")>-1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }else if (conversation.indexOf("Alfred")>-1){
            return"At your service. As you wish, naturally.";
        }else return "Right. And with that I shall retire.";
    }
    
    public String byeBye(String byebye){
        String a= "bye bye";
        String b= "see you";
        if (a.equals(byebye) || b.equals(byebye)){
            return "Ya Ya! Take care!!!";
        }else{
            return "Anything else I can help you with?";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

