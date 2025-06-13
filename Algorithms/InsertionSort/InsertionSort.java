package Algorithms.InsertionSort;

public class InsertionSort {
       
    public static void insertionSort(int [] array){
        for (int i = 1; i < array.length; i++) {
            int j=i-1;
            while (j >= 0 && array[j] > array[j+1]) {
                int temp = array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }

        }
    }

    public static void main(String[] args) {
        int [] array = {5,9,2,6,8,3,7,8,4};
        insertionSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
