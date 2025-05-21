package Arrays.Maximum_Product_Subarray;

public class Maximum_Product_Subarray {

    public static int findMaxSubarrayProdufct(int array[]){
        int maxSubarray = array[0];

        for (int i = 0; i < array.length-1; i++) {
            int nextMaxSubArray = array[i];

            for (int j = i+1; j < array.length; j++) {
                nextMaxSubArray *= array[j];
                if (maxSubarray < nextMaxSubArray) {
                    maxSubarray = nextMaxSubArray;
                }
            }
        }
        return maxSubarray;
    }

    public static void main(String[] args) {
        int array [] = {2,3,-2,4};
        System.out.println(findMaxSubarrayProdufct(array));
    }
}

//Explaination :- 

//  6. Maximum Product Subarray
//  Given an integer array nums, find a subarray that has the largest
//  product, and return the product.
//  Input: nums = [2,3,-2,4]
//  Output: 6
//  Explanation: [2,3] has the largest product 6.
//  Input: nums = [-2,0,-1]
//  Output: 0
//  Explanation: The result cannot be 2, because [-2,-1] is not a
//  subarray.