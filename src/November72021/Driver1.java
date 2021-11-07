package November72021;

import java.util.Stack;

public class Driver1 {

    public static String superReducedString(String s) {
        String result = "";
        //Use a stack to keep track of chars
        Stack<Character> check = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //If the stack isn't empty and the current character is currently on the stack
            if(!check.isEmpty() && c == check.peek()) {
                //Remove that character from the stack
                check.pop();
            } else {
                //Push the new character onto the stack since there isn't a pair
                check.push(c);
            }
        }

        //If the stack is empty then return "Empty String"
        if(check.isEmpty()) {
            return "Empty String";
        } else {
            //Loop through the stack and append each character to a string to return
            for(char c : check) {
                result += c;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "aaabccddd";
        String input2 = "baab";

        System.out.println(superReducedString(input));
        System.out.println(superReducedString(input2));
    }
}
