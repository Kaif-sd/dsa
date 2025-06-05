package Pattern.CenteredNumberPyramid;

public class CenteredNumberPyramid {
    
    public static void main(String[] args) {
        System.out.println("hii");
        printPattern(5);
    }

    public static void printPattern(int x){

        for (int i = 1; i <= x; i++) {
            
            for (int s = i; s <= x; s++) {
                System.out.print("  ");
            }

            int j = i;
            
            while (j < 2 * i - 1) {
                System.out.print(j + " ");
                j++;
            }

            while (j >= i) {
                System.out.print(j + " ");
                j--;
            }
            System.out.println();
        }
    }

}


// Output :- 

//           1 
//         2 3 2 
//       3 4 5 4 3 
//     4 5 6 7 6 5 4 
//   5 6 7 8 9 8 7 6 5 
