package Strings.Valid_Palindrome;

public class Valid_Palindrome {

    public static boolean isValidPalindrome(String string){

        int start = 0;
        int end = string.length()-1;

        while (start < end) {
            if(string.charAt(start) != string.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static void main(String[] args) {

        System.out.println(isValidPalindrome("Madam") ? "is palindrome" : " is not palindrome ");

    }
}


// output:-

//  is not palindrome 