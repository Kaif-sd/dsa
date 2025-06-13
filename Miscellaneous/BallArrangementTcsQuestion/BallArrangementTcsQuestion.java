package Miscellaneous.BallArrangementTcsQuestion;

public class BallArrangementTcsQuestion {
    

    public static int ballArrangementNoOfWays(int g , int y , int r , String last){
        int ways =0;
        if(g==0 && y ==0 && r==0){
            return 1;
        }

        // System.out.println(g +" " +" "+y+" "+r);

        if(g > 0 && !last.equals("g")){
            ways += ballArrangementNoOfWays(g-1, y, r, "g");
        }

        if(y > 0 && !last.equals("y")){
            ways += ballArrangementNoOfWays(g, y-1, r, "y");
        }

        if(r> 0 && !last.equals("r")){
            ways += ballArrangementNoOfWays(g, y, r-1, "r");
        }

        return ways;
    }


    public static void main(String[] args) {
        System.out.println(ballArrangementNoOfWays(1, 10,1, "n"));
    }
}
