package Arrays.Search_in_Rotated_Sorted_Array;

public class Search_in_Rotated_Sorted_Array {


    public static int findInRotatedArray(int array[] , int target){

        int left =0, right = array.length -1;

        while(left <= right){

            int mid = (left + right) / 2;

            System.out.println(left + " " + mid+ " " + right);
            if(array[mid] == target){
                return mid;
            }else{
              if(array[left] <= array[mid]){
                if(array[left] <= target && target < array[mid]){
                    //searching in left as it is sorted
                    right = mid -1;
                }else{
                     //searching in right as it is sorted
                    left = mid+1;
                }
              }else{
                if(array[mid] < target && target <= array[right]){
                    //searching in left as it is sorted
                    left = mid +1;
                }else{
                    right = mid-1;
                }
              }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hii");
        int array [] = {5,6,7,0,1,2,3};
        System.out.println(findInRotatedArray(array, 3));

    }
    
}

// output 
// hii
// 0 3 6
// 4 5 6
// 6 6 6
// 6

// Explaination :-

//  8. Search in Rotated Sorted Array
//  Given the array nums after the possible rotation and an integer
//  target, return the index of the target if it is in nums, or -1 if it is not
//  in nums.
//  You must write an algorithm with O(log n) runtime complexity.
//  Input: nums = [4,5,6,7,0,1,2], target = 0
//  Output: 4
//  Input: nums = [4,5,6,7,0,1,2], target = 3
//  Output: -1