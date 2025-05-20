package String.Reverse_String_Using_Recursion;

public class ReverseStringUsingRecursion {
    
    public static char []reverseString(char charArray [] , int left , int right){
        if(charArray == null || left >= right){
            return charArray;
        }

        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;

        return reverseString(charArray, ++left, --right);
    }

    public static void main(String[] args) {
        String string = "This is String for reversing using recursion";
        char charArray [] = string.toCharArray();
        int stringLength = string.length();
        charArray = reverseString(charArray , 0 , stringLength-1);
        string = new String(charArray);
        System.out.println(string);
    }
}
