//Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
//
//For example, given the string "([])[]({})", you should return true.
//
//Given the string "([)]" or "((()", you should return false.


import java.util.Stack;

public class Problem13 {

    public boolean isValid(String s){

        //Transform the string into char array
        char[] symbols = s.toCharArray();
        //Make a stack to hold the opening brackets
        Stack<Character> stack = new Stack();

        //check to see if there is something already in the stack and to see if s is greater than 1 since anything less than 1
        //means it's false
        if(!stack.isEmpty() || s.length() <= 1) return false;

        //one iteration to go through the whole array
        for(int i = 0; i < symbols.length; i++){

            //checking to see if the bracket is an opening and if it is when put it onto the stack
            if(open(symbols[i])) stack.push(symbols[i]);

            //else we check to see if the open and closing match. If not then we return false
            else{
                if(!helper(symbols[i],stack.pop())) return false;
            }
        }
        //if the stack is not empty in the end we return false as we assume that not everything has found its match
        if(!stack.isEmpty()) return false;

        //In the end of everything passes and the stack is empty then the string must be valid
        return true;
    }

    //This checks whether or not the opening bracket matches with the closing bracket
    public boolean helper(char c1, char c2){

        if((c2 == '[' && c1 != ']') || (c2 == '{' && c1 != '}') || (c2 == '(' && c1 != ')')) return false;

        return true;
    }
    //This just checks if the current item at i is an opening bracket
    public boolean open(char c){
        if(c == '(' || c == '{' || c == '[') return true;

        return false;
    }

    public static void main(String[] args) {

        Problem13 p13 = new Problem13();
        String s = "((()))"; //true


        System.out.println(p13.isValid(s));


    }
}
