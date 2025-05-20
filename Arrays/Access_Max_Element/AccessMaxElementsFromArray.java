package Arrays.Access_Max_Element;

class AccessMaxElementsFromArray {

    public static int MaxElementFromArray(int array []){
        if(array == null){
            return 0;
        }
        
        int maxElement = array[0];
        for(int i=0; i<array.length; i++){
            if(maxElement < array[i]){
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        int array [] = {1,5,9,2,7,3,1,7,4};
        int maxElement = MaxElementFromArray(array);
        System.out.println(maxElement);
    }
    
}