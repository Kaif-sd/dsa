package Arrays.Rotate_An_Array;

public class Rotate_An_Array {

    public static int [] rotateArrayFromRight(int array[] , int byPositions){

        byPositions = byPositions % array.length;
        reverseArray(array, 0, array.length-1);
        
        reverseArray(array, 0, byPositions -1);

        reverseArray(array, byPositions , array.length-1);

        return array;
    }

    public static void reverseArray(int array [] , int start , int end ){
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end]  = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        System.out.println("hii");
        int array [] = {1,2,3,4,5,6};
        int byPositions = 2;
        int reverseArray [] = rotateArrayFromRight(array ,byPositions);
        
        for (int i = 0; i < reverseArray.length; i++) {
            System.out.println(reverseArray[i]);
        }


    }
    
}


