package Strings.ValidParentheses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Stack;

public class ValidParentheses {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Strings/Valid_Palindrome/Valid_Palindrome.java");
        FileReader fileReader = new FileReader(file);
        String string = fileReader.toString();  
        System.out.println(isValidParenthesis(string));  //here we are passing whole file to check its parenthesis are correct or not
    }

    public static boolean isValidParenthesis(String string){

        Stack<Character> stack = new Stack<>();
        char ch = ' ';

        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i);

            if(ch == '('|| ch == '{' ||  ch == '['){
                stack.push(ch);
            }
            else if(ch == ')' ){
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
            else if(ch == '}'){
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
            else if(ch == ']'){
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }

        }

        return stack.isEmpty();
        
    }
}


// output :-

// true

// here we can pass whole code and check for parenthesis are correct or not .