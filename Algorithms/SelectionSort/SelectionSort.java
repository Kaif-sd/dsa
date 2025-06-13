package Algorithms.SelectionSort;

public class SelectionSort {
    
    public static void selectionSort(int [] array){
        for (int i = 0; i < array.length; i++) {
            int smallOne = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[smallOne]){
                    smallOne =j;
                }
            }
            int temp = array[smallOne];
            array[smallOne] = array[i];;
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int [] array = {5,9,2,6,8,3,7,8,4};
        selectionSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
