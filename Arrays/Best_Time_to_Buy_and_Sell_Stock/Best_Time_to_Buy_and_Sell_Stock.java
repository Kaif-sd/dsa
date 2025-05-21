package Arrays.Best_Time_to_Buy_and_Sell_Stock;

public class Best_Time_to_Buy_and_Sell_Stock {

    public static int maxProfit(int prices []){

        int maxP = 0, iIndex=0, jIndex=0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
               if(maxP < (prices[j] - prices[i])){
                maxP = prices[j] - prices[i];
                iIndex = i;
                jIndex = j;
               }
            }
        }
        System.out.println("Buy on " + ( iIndex +1 ) + " and sell on " + ( jIndex +1 ));
        return maxP;
    }

    public static void main(String[] args) {
        int prices [] = {7,1,5,3,6,4,8,10,223,11111132};
        System.out.println("hii");
        System.out.println(maxProfit(prices));
    }
    
}
