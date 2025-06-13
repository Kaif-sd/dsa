package Algorithms.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,4,6,8,9}, 8));
    }

    public static int search(int [] array , int num){
        int left =0, right = array.length;

        while (left <= right) {
            int mid =(left + right)/ 2;
            if(array[mid]  == num ){
                 return mid;
            }else if(array[mid] < num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return -1;
    }
}
