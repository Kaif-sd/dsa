package Arrays.Contains_Duplicate;

import java.util.Set;

public class Contains_Duplicate {

    // public static boolean findDuplicateUsingSet(int array []){
    //     Set<Integer> set = new HashSet();
        
    //     for (int i = 0; i < array.length; i++) {
    //         if(set.contains(array[i])){
    //             return true;
    //         }else{
    //             set.add(array[i]);
    //         }
    //     }
    //     return false;
    // }

    public static boolean findDuplicateUsingForLoop(int array []){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int array [] = {1,3,7,4,5,6,2,9};
        System.out.println(findDuplicateUsingForLoop(array));
        // System.out.println(findDuplicateUsingSet(array));
    }
}
