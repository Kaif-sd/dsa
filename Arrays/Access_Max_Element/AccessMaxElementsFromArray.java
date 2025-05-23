package Arrays.Access_Max_Element;

class AccessMaxElementsFromArray {

    public static int MaxElementFromArray(int array []){
        if(array == null){
            throw new IllegalArgumentException("Array should not be empty");
        }

        int maxElement = array[0];
        for(int i=1; i<array.length; i++){
            if(maxElement < array[i]){
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        int array [] = {};
        int maxElement = MaxElementFromArray(array);
        System.out.println(maxElement);
    }
    
}