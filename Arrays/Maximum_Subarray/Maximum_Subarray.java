package Arrays.Maximum_Subarray;

public class Maximum_Subarray {

    public static int findMaxSubarray(int array [] ){

        int maxSubarray = array[0];

        for (int i = 0; i < array.length-1; i++) {
            int nextNumSem = array[i];

            for (int j = i + 1; j < array.length; j++) {
                nextNumSem += array[j];
                if(maxSubarray < nextNumSem){
                    maxSubarray = nextNumSem;
                }
            }
        }
        return maxSubarray;
    }

    public static void main(String[] args) {
        int array [] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMaxSubarray(array));
    }
}

//Explaination :-

// 5. Maximum Subarray
//  Given an integer array nums, find the subarray with the largest
//  sum, and return its sum.
//  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//  Output: 6
//  Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//  Input: nums = [1]
//  Output: 1
//  Explanation: The subarray [1] has the largest sum of 1.