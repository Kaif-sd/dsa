package Matrix.Set_Matrix_Zeroes;

import java.util.ArrayList;

public class Set_Matrix_Zeroesb {
    
    public static void setMatrixZeros(int [][] array){
        ArrayList<int []> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == 0){
                    arrayList.add(new int[]{i,j});
                }
            }
        }

        for (int[] is : arrayList) {
            setZerosInGivenRows(array, is[0], is[1]);
        }
        
        printMatrix(array);
    }

    public static void setZerosInGivenRows(int [][] array , int row ,int column){
        for (int i = 0; i < array[row].length; i++) {
            array[row][i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            array[i][column] = 0;
        }
    }

    public static void printMatrix(int [][] array){
        System.out.println("printing Matrix ....");
        for (int[] is : array) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [][] array = {{1,1,1},{1,0,1},{1,1,1}};
        printMatrix(array);
        setMatrixZeros(array);
    }
}

// output :-

// printing Matrix ....
// 1 1 1 
// 1 0 1 
// 1 1 1 

// printing Matrix ....
// 1 0 1 
// 0 0 0
// 1 0 1


// Explaination:-

//  1. Set Matrix Zeroes
//  Given an m x n integer matrix, if an element is 0, set its entire row
//  and column to 0's. You must do it in place.
//  Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//  Output: [[1,0,1],[0,0,0],[1,0,1]]