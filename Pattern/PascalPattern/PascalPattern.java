package Pattern.PascalPattern;

public class PascalPattern {
    
    public static void main(String[] args) {
        printPattern(20);
    }

    public static void printPattern(int x){

        for (int i = 0; i < x; i++) {
            
            for (int s = i; s < x; s++) {
                System.out.print(" ");
            }

            int num = 1;

            for (int j = 0; j <= i; j++) {
                System.out.print(num +" ");

                num = num * (i-j) / (j+1);
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