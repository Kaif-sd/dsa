package Strings.Valid_Anagram;

public class Valid_Anagram {

    public static boolean isValidAnagram(String string , String target){

        char [] targetCharArray = target.toCharArray();
        char [] stringCharArray = string.toCharArray();

        if(targetCharArray.length != stringCharArray.length){
            return false;
        }

        boolean flag = false;
        for (int i = 0; i < stringCharArray.length; i++) {
            for (int j = 0; j < targetCharArray.length; j++) {
                if(stringCharArray[i] == targetCharArray[j]){
                    flag = true;
                    targetCharArray[j]  = '0';
                    break;
                }
            }
            
            if(flag == false){
                return false;
            }else{
                flag = false;
            }

        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isValidAnagram("anagram", "nagaram"));
    }
}
