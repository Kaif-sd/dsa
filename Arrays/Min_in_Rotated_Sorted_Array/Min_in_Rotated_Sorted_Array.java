

public class Min_in_Rotated_Sorted_Array {

    public static int findMininRotatedArray(int array[]){
        int left = 0, right = array.length-1;
        int mid=0;

        while (left < right) {
            mid = (left + right) /2;
            System.out.println(mid +" "+ left+" "+right);
            if(array[mid] > array[right]){
                left = mid +1;
            }
            else {
                right = mid;
            }
        }    

        return array[left];
    }

    public static void main(String[] args) {
        int array[] = {3,4,5,1,2} ;
        System.out.println(findMininRotatedArray(array));
    }
}

// output :-
// 2 0 4
// 3 3 4
// 1


//Explaination :-

// 7. Find the Minimum in Rotated
//  Sorted Array
//  Given the sorted rotated array nums of unique elements, return 
// the minimum element of this array.
//  You must write an algorithm that runs in O(log n) time.
//  Input: nums = [3,4,5,1,2]
//  Output: 1
//  Explanation: The original array was [1,2,3,4,5] rotated 3 times.