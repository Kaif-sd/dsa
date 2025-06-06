package Strings.LongestPalindromicSubstring;

public record LongestPalindromicSubstring() {
    
    public static void main(String[] args) {
        System.out.println("hii");
        System.out.println(findLongestPalindromicSubstring("babad"));
    }

    public static String findLongestPalindromicSubstring(String string){

        String longestOne = null ;

        for (int i = 0; i < string.length(); i++) {
            for (int j = string.length(); j > i ; j--) {
                String subString = string.substring(i,j);
                if(isPalindrome(subString) && subString.length() > (longestOne != null ? longestOne.length() : 0)){
                    longestOne = subString;
                }
            }   
        }
        return longestOne;
    }

    public static boolean isPalindrome(String string ){

        int start = 0 , end = string.length()-1;

        while(start < end ){
            if(string.charAt(start) != string.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
