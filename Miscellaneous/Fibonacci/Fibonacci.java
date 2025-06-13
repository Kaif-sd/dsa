package Miscellaneous.Fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciSeries(5));
    }
    
    public static List<Integer> fibonacciSeries(int n){ 
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int i=2;
        while (i <= n) {
            list.add(list.get(i-1) + list.get(i-2));
            i++;
        }
        return list;
    }
}
