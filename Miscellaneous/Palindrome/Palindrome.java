package Miscellaneous.Palindrome;

public class Palindrome {
    public static void main(String[] args) {
        String string = "raceaecar";
        // System.out.println(isPalindrome(string, 0, string.length()-1));
        System.out.println(isNumhberPalindrome(1));
    }

    public static boolean isPalindrome(String string , int start , int end){   
        if(start > end){
            return true;
        }  
        System.out.println(string + " and " + start + " " + end);
        if( string == null || string.charAt(start) != string.charAt(end)){
            return false;
        } 

        return isPalindrome(string , start+1 , end-1);
    }

    public static boolean isNumhberPalindrome(int n){
        if(n == reverse(n)){
            return true;
        }
        return false;
    }

    public static int reverse(int n){
        int newNum=0;
        while (n > 0) {
            newNum = newNum * 10 + n%10 ;
            n = n/10;
        }
        return newNum;
    }
}
