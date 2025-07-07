package DP;
import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        int [] dpArray = new int[6];
        Arrays.fill(dpArray, -1);
        System.out.println(countWays( 0,5 , dpArray));
    }

    public static int countWays(int curr , int f , int [] dpArray){

        if(curr == f){
             return 1;
        }

        if(curr > f){
             return 0;
        }
                
        if(dpArray[curr] != -1){
            return dpArray[curr];
        }

        dpArray[curr] = countWays(curr +1 , f , dpArray) + countWays( curr + 2 , f , dpArray);
        return dpArray[curr];
    }

}
