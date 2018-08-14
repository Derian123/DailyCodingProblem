public class Problem12 {

    public boolean isAMatch(String s, String regex){

        //we check to see if s matches to the regular expression
        //if it does we return true else we return false
        if(s.matches(regex))return true; return false;
    }

    public static void main(String[] args) {
        Problem12 p12 = new Problem12();

        System.out.println(p12.isAMatch("ray", "ra."));//true
        System.out.println(p12.isAMatch("raymond", "ra."));//false
        System.out.println(p12.isAMatch("chat", ".*at"));//true
        System.out.println(p12.isAMatch("chats", "ra.")); //false
    }
}
