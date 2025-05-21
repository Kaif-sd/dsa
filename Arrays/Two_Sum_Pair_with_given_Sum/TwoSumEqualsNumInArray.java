package Arrays.Two_Sum_Pair_with_given_Sum;

public class TwoSumEqualsNumInArray{

    public static boolean twoSum(int array [] , int sum){

           for (int i = 0; i < array.length; i++) {
            int toFind = sum - array[i];
            for(int j=i+1 ; j<array.length ;j++){
                if(array[j] == toFind){
                    System.out.println(toFind +" and  "+ array[i]);
                    return true;
                }
            }
           }
           return false;
    }

    public static void main(String[] args) {
        int array[] = {1,5,2,9,3} ;
        System.out.println("hii");
        System.out.println(twoSum(array ,9));
    }
}

//Explaination :- 

// Two Sum - Pair with given Sum

// Given an array arr[] of n integers and a target value, the task is to find whether there is a pair of elements in the array whose sum is equal to target. This problem is a variation of 2Sum problem.

// Examples: 

// Input: arr[] = [0, -1, 2, -3, 1], target = -2
// Output: true
// Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.

// Input: arr[] = [1, -2, 1, 0, 5], target = 0
// Output: false
// Explanation: There is no pair with sum equals to given target.