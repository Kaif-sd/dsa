package Strings.Minimum_Window_Substring;


public class Minimum_Window_Substring {
    
    public static String findMinWindString(String string , String target){
        String result= "";
        int startI = 0;
        int endI = 0;
        StringBuilder newString = new StringBuilder(String.valueOf(string));

        for (int i = 0; i < string.length(); i++) {
           for (int j = 0; j < target.length(); j++) {
                if( string.charAt(i) == target.charAt(j) ){
                    
                }
           }
        }

        System.out.println("at end starti :- " +startI+ " and endI is :-" + endI);
        return target.substring(startI,endI);
    }


    public static String findStringFromHere(String string , String target , int index){

        boolean flag = false;

        for (int i = index; i < string.length(); i++) {
            for (int j = 0; j < target.length(); j++) {
                if(string.charAt(i) ==  target.charAt(j) ){

                }
            }
        }
        return  "hii";
    }


    public static void main(String[] args) {
        System.out.println("hii");
        System.out.println(findMinWindString("ADOBECODEBANC","ABC"));
    }
}

// import java.util.HashMap;

// public class MinimumWindowSubstring {

//     public String minWindow(String s, String t) {
//         // Map to store character frequencies of string t
//         HashMap<Character, Integer> targetMap = new HashMap<>();
        
//         // Fill the targetMap with characters from t and their counts
//         for (char c : t.toCharArray()) {
//             targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
//         }

//         // Two pointers for the sliding window
//         int left = 0, right = 0;
//         // Variable to keep track of how many characters we have matched
//         int formed = 0;
//         // Map to store character frequencies in the current window
//         HashMap<Character, Integer> windowCounts = new HashMap<>();

//         // Answer format: [window length, left index, right index]
//         int[] ans = {-1, 0, 0};

//         // Total unique characters in t that need to be present in the window
//         int required = targetMap.size();

//         // Loop through the main string with right pointer
//         while (right < s.length()) {
//             // Add one character from the right to the window
//             char c = s.charAt(right);
//             windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

//             // If the current character's count matches with the targetMap, increase formed count
//             if (targetMap.containsKey(c) && windowCounts.get(c).intValue() == targetMap.get(c).intValue()) {
//                 formed++;
//             }

//             // Try to contract the window till it ceases to be 'desirable'
//             while (left <= right && formed == required) {
//                 // Save the smallest window so far
//                 if (ans[0] == -1 || right - left + 1 < ans[0]) {
//                     ans[0] = right - left + 1;
//                     ans[1] = left;
//                     ans[2] = right;
//                 }

//                 // Remove the character at the left from the window
//                 char ch = s.charAt(left);
//                 windowCounts.put(ch, windowCounts.get(ch) - 1);

//                 // If character is part of target and count falls below required, reduce formed
//                 if (targetMap.containsKey(ch) && windowCounts.get(ch).intValue() < targetMap.get(ch).intValue()) {
//                     formed--;
//                 }

//                 // Move the left pointer forward
//                 left++;
//             }

//             // Expand the window by moving right pointer forward
//             right++;
//         }

//         // Return the smallest window or empty string if no valid window was found
//         return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//     }

//     // Main method to test the function
//     public static void main(String[] args) {
//         MinimumWindowSubstring obj = new MinimumWindowSubstring(); // Creating object of the class
//         String s = "ADOBECODEBANC"; // Main string
//         String t = "ABC"; // Target string
//         System.out.println(obj.minWindow(s, t)); // Output should be "BANC"
//     }
// }
