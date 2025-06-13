package Algorithms.BubbleSort;

public class BubbleSort {
    
    public static void bubbleSort(int [] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {1,5,9,2,6,8,3,7,8,4};
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
