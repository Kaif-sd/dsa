package Strings.Reverse_String_Using_Stack;

import java.util.Stack;

public class ReverseStringUsingStack {

    public static String reverseString(String string){
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<string.length(); i++){
            stack.push(string.charAt(i));
        }

        string = "";
        while (!stack.isEmpty()) {
            char popedChar = stack.pop();
            string += popedChar;
        }
        return string;
    }

    public static void main(String[] args) {
        String string = "This is my String";
        string = reverseString(string);
        System.out.println(string);
    }
}
