package Miscellaneous.Sum_Is_Prime_Number;

import java.util.ArrayList;
import java.util.List;

public class Sum_Is_Prime_Number {
    
    public static void main(String[] args) {
        System.out.println(find2PrimNumbers(100));
    }


    public static List<Integer> find2PrimNumbers(int num){
        List<Integer> list = new ArrayList<>();
        
        for (int i = 2; i < num / 2; i++) {
            if(isPrime(i) && isPrime(num - i)){
                list.add(i);
                list.add(num-i);
                return list;
            }
        }
        return null;
    }

    public static boolean isPrime(int num){
        for (int j = 2; j * j < num; j++) {
            if(num % j == 0){
                return false;
            }
        }
        return true;
    }
}
