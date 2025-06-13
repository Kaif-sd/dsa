package Miscellaneous.Factorial;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(5));
    }

    public static int findFactorial(int num){
        if(num == 0){
            return 1;
        }
        return num * findFactorial( num -1);
    }
}
