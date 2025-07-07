package Algorithms.QuickSort;

public class QuickSort {
    
    
    public static void quickSort(int [] array ,  int start , int end){
        if(start < end){
            int partitionIndex = partition(array,  start ,  end);
            quickSort(array, start, partitionIndex-1);
            quickSort(array, partitionIndex+1, end);
        }
    }

    private static int partition(int [] array, int start, int end) {

        int pivote = array[start];
        int i=start+1;
        int j= end;

        while (i <= j) {
            while (i <= end && array[i] <= pivote) {
                i++;
            }
 
            while (j >= start && array[j] > pivote) {
                j--;
            }

            if(i < j){ // swap only if pointers did not cross
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[start];
        array[start] = array[j];
        array[j] = temp;
        return j;
    }


    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};
        quickSort(array , 0 , array.length-1);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
