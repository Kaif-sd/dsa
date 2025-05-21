package Arrays.Product_of_Array_Except_Self;

public class Product_of_Array_Except_Self {

    // public static int [] arrayProductWithDivOperator(int array []){
    //     int resultArray [] = new int[array.length];
    //     int sum = 1;

    //     for (int i = 0; i < array.length; i++) {
    //         sum *= array[i];
    //     }

    //     for (int i = 0; i < resultArray.length; i++) {
    //         resultArray[i] = sum / array[i];
    //     }

    //     return resultArray;
    // }

    public static int [] arrayProductWithoutUsingDivOperator(int array []){
        int arrLength = array.length;
        int leftArray [] = new int[array.length];

        leftArray[0] = 1;
        for (int i = 1; i < leftArray.length; i++) {
            leftArray[i] = leftArray[i-1] * array[i-1];
        }

        int resultArray [] = new int[array.length];
        int rightArray [] = new int[array.length];
        rightArray[arrLength-1] = 1;
        resultArray[arrLength-1] = leftArray[arrLength-1];
        for (int i = resultArray.length-2; i >=0; i--) {
            rightArray[i] = rightArray[i+1] * array[i+1];
            resultArray[i] = leftArray[i] * rightArray[i];
        }

        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println("hii");
        int array [] = {1,2,3,4};
        array = arrayProductWithoutUsingDivOperator(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}


//Explaination :-

//  4. Product of Array Except Self
//  Given an integer array nums, return an array answer such that
//  answer[i] is equal to the product of all the elements of nums
//  except nums[I].
//  The product of any prefix or suffix of nums is guaranteed to fit in a
//  32-bit integer.
//  You must write an algorithm that runs in O(n) time and without
//  using the division operation.
//  Input: nums = [1,2,3,4]
//  Output: [24,12,8,6]