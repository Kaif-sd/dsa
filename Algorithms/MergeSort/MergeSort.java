package Algorithms.MergeSort;

public class MergeSort {

    public static int []mergeSort(int [] array ,  int start , int end){
        if(start < end ){
            int mid = (start + end) /2;

            int [] array1 = mergeSort(array, start, mid);
            int [] array2 = mergeSort(array, mid+1, end);
            
            return combine(array1, array2);
        }
        return new int[]{array[start]};
    }

    public static int[] combine(int [] array1 , int [] array2){ 
        int []array = new int[array1.length + array2.length];

        int a=0,a1=0,a2=0;
        while (a1 < array1.length && a2 < array2.length) {
            if(array1[a1] < array2[a2]){
                array[a] = array1[a1];
                a1++;
            }else{
                array[a] = array2[a2];
                a2++;
            }
            a++;
        }

        while (a1 < array1.length) {
            array[a] = array1[a1];
            a++;
            a1++;
        }

        while (a2 < array2.length) {
            array[a] = array1[a2];
            a++;
            a2++;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};
        int[] ans = mergeSort(array , 0 , array.length-1);
        for (int i : ans) {
            System.out.println(i);
        }
    }

}
