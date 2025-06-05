package Strings.Longest_Substring_Without_Rep;

public class Longest_Substring_Without_Rep {

    public static int lengthOfLongestSubString(String string){
        return findLongSubString(string).length();
    }

    public static String findLongSubString(String string){
        String subString = "";
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                String temp = string.substring(i, j);
                if(temp.length() > subString.length() && !isRepeatation(temp)){
                    subString = temp;
                }

            }
        }
        return subString;
    }

    private static boolean isRepeatation(String temp) {
        for (int i = 0; i < temp.length()-1; i++) {
            String curr = String.valueOf(temp.charAt(i));
            if(temp.substring(i+1, temp.length()).contains(curr)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("abcabcb"));
    }
}

// output:-

// 3

//Explaination :- 

//  1. Longest Substring Without
//  Repeating Characters
//  Given a string s, find the length of the longest 
// substring without repeating characters.
//  Input: s = "abcabcbb"
//  Output: 3
//  Explanation: The answer is "abc", with a length of 3.