package Strings.PalindromicSubstrings;

public class PalindromicSubstrings {
    
    public static void main(String[] args) {
         System.out.println(findNumberOfPalindromicSubString("abccb"));
    }

    public static int findNumberOfPalindromicSubString(String string){
        int count = 0;
        for (int i = 0; i < string.length(); i++){
            for (int j = i + 1; j <= string.length(); j++){
                if(isPalindrome(string.substring(i, j))){
                    System.out.println(string.substring(i, j));
                    count++;
                }
            }
        }
        return count;
         
    }

    public static boolean isPalindrome(String string){        
        int start=0 , end = string.length()-1;

        while (start < end) {
            if(string.charAt(start) != string.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// output :-

// a
// b
// bccb
// c
// cc
// c
// b
// 7