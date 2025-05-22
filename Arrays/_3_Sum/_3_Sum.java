package Arrays._3_Sum;

public class _3_Sum {

    public static int [][] find3Sum(int nums[]){        
        //below require to use arraylist for dynamically setting size of array as per requirements.
        int result [][] = new int[nums.length][3];
        int a=0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        result[a++] = new int[]{nums[i] , nums[j],nums[k]};
                    }
                    // System.out.println(i+" "+j+" "+k);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("hii");
        int nums [] = {-1,0,1,2,-1,-4};
        int result [][] = find3Sum(nums);


        System.out.println();
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.print(" ]");
        }
        System.out.print(" ]");

    }
    
}


// output :
// [ [ -1 0 1  ][ -1 2 -1  ][ 0 1 -1  ][ 0 0 0  ][ 0 0 0  ][ 0 0 0  ] ]

//Explaination :- 

// 9. 3Sum
//  Given an integer array nums, return all the triplets [nums[i],
//  nums[j], nums[k]]
//  such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//  Notice that the solution set must not contain duplicate triplets.
//  Input: nums = [-1,0,1,2,-1,-4]
//  Output: [[-1,-1,2],[-1,0,1]]
//  Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//  nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//  nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//  The distinct triplets are [-1,0,1] and [-1,-1,2].