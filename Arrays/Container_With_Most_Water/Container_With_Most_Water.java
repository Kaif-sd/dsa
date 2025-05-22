package Arrays.Container_With_Most_Water;

public class Container_With_Most_Water {
    
    public static int findContainerWithMostWater(int height[]){
        int area =0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if(area < Math.min(height[i], height[j]) * (i - j)){
                    area = Math.min(height[i], height[j]) * (i - j);
                }
            }
        }
        return area;
    }
    public static void main(String[] args) {
        System.out.println("hii");
        int height [] =  {1,8,6,2,5,4,8,3,7};
        System.out.println(findContainerWithMostWater(height));
    }
}
