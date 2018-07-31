//implement an autocomplete system. That is, given a query string s and a set
// of all possible query strings, return all strings in the set that have s as a prefix.
//For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
import java.util.HashSet;

public class Problem9 {

    //auto complete function
    public HashSet autoComplete(HashSet<String> set, String s){

        //iterate through each words
        for(String words : set){
            //if the substring of the word is equal to s then we go on else we remove it from the set
            if(words.substring(0,s.length()).equals(s)) continue; else set.remove(words);
        }
        //we return the new set
        return set;
    }

    public static void main(String[] args) {
        Problem9 p9 = new Problem9();
        HashSet<String> set = new HashSet<>();
        set.add("dog");
        set.add("deer");
        set.add("deal");

        System.out.println(p9.autoComplete(set, "de"));

    }
}
