package Pattern.PascalPattern;

public class PascalPattern {
    
    public static void main(String[] args) {
        // printPattern(5);
        printPascalPattern(5);
    }


    public static void printPascalPattern(int num){
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
                System.out.print(" ");
            }

            int n =1;
            for (int j2 = 0; j2 < i + 1; j2++) {
                System.out.print(n + " ");
                n = n * (i - j2);
                n = n  / (j2 + 1);
            }
            
            System.out.println();
        }
    }
}

// output :-

//      1 
//     1 1
//    1 2 1
//   1 3 3 1
//  1 4 6 4 1 