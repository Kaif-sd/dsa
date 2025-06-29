package Miscellaneous.NumberOfSubsequencefromArray;

public class NumberOfSubsequencefromArray {
    
// given a string s and an array of strings words , return the number of word[i] that is a subsequnce of s.
    public static int findSubSequnceOfString(String s, String [] arrayString){
        int result = 0;
        for(String word : arrayString ){
            int x = getScoreForWord(s, word, 0, 0);
            if(0 < x){
                result++;
            }
        }
        return result;
    }

    public static int getScoreForWord(String s, String word, int Wi, int score){  
        if(Wi == word.length()){
            return score;
        }  
        char wChar = word.charAt(Wi);
        int i;
        boolean flag = false;
        for (i = 0; i < s.length(); i++) {
            if(wChar ==  s.charAt(i)){
                score++;
                flag = true;
                break;
            }
        }

        if(!flag){
            return 0;
        }

        s = s.substring(i+1);
        return getScoreForWord(s, word, ++Wi, score);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String [] words = new String[]{"a", "z" ,"acde","ac"};

        int x = findSubSequnceOfString( s, words);
        System.out.println(x);

    }
}
