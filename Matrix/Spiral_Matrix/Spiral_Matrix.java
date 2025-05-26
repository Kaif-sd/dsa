package Matrix.Spiral_Matrix;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Spiral_Matrix {
    
    public static Set<Integer> spiralMatrixRun(int [][] array){

        Set<Integer> visited = new LinkedHashSet();

        int top =0, 
        bottom = array.length-1,
        left = 0 , 
        right = array[top].length-1;

        while(left <= right && top <= bottom){

            for (int i = left; i <= right; i++) {
                visited.add(array[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                visited.add(array[i][right]);
            }
            right--;

            for (int i = right; i >=left; i--) {
                visited.add(array[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >=top; i--) {
                visited.add(array[i][left]);
            }
            left++;

        }
        return visited;
    }

    public static void main(String[] args) {

        int [][] array = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        Set<Integer> result = spiralMatrixRun(array);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

// input:- 
// 1 2 3
// 4 5 6
// 7 8 9
// 10 11 12

// output :-

// 1 2 3 6 9 12 11 10 7 4 5 8 


// Explaination :-

//  2. Spiral Matrix
//  Given an m x n matrix, return all elements of the matrix in spiral
//  order.
//  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//  Output: [1,2,3,6,9,8,7,4,5]