package Matrix.Rotate_Image;

public class Rotate_Image {
    
    public static int [][] ImageRotate(int[][] array){
        int result [][] = new int[array[0].length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length;j++) {
                result[i][j] = array[array.length-1-j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][]array = {{1,2,3},{4,5,6},{7,8,9}};

        int [][] result = ImageRotate(array);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// input array :-
//  1 2 3
//  4 5 6
//  7 8 9

//  output :-

//  7 4 1 
// 8 5 2
// 9 6 3


// Explaination :-

// 3. Rotate Image
//  You are given an n x n 2D matrix representing an image, rotate the
//  image by 90 degrees (clockwise).
//  You have to rotate the image in place, which means you have to
//  modify the input 2D matrix directly. DO NOT allocate another 2D
//  matrix and do the rotation.
//  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//  Output: [[7,4,1],[8,5,2],[9,6,3]]