package Matrix.Word_Search;

public class Word_Search {

public static boolean findWord(char [][]charGrid , int currX , int currY ,String word , int index ,String result){
        if(currX > charGrid.length-1 || currY > charGrid.length-1 || currX < 0|| currY <0){
            return false;
        }

        if(word.equals(result)){           
            return true;
        }

        if(charGrid[currX][currY] == word.charAt(index)){
            result += word.charAt(index);
            System.out.println("success for here : - " + word.charAt(index)+" and "+ charGrid[currX][currY]  +" with result :- " + result);
            index++;
            if(findWord(charGrid, currX, currY+1 , word, index,result)){
                return findWord(charGrid, currX, ++currY , word, index,result);

            }else if(findWord(charGrid,  currX+1, currY , word, index,result)){
                return findWord(charGrid,  ++currX, currY , word, index,result);

            }else if(findWord(charGrid,  currX-1, currY , word, index,result)){
                return findWord(charGrid,  --currX, currY , word, index,result);  

            }else if(findWord(charGrid, currX, currY-1 , word, index,result)){
                return findWord(charGrid,  currX, --currY , word, index,result);
            }
        }

        System.out.println("failed for here : - " + word.charAt(index)+" and "+ charGrid[currX][currY] );
        return false;
    }

    public static void main(String[] args) {
        char [][] charGrid = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
        System.out.println(findWord(charGrid , 0, 0 , "abeh", 0, ""));
    
    }
}

// output :-

// success for here : - a and a with result :- a
// success for here : - b and b with result :- ab
// failed for here : - e and c
// success for here : - e and e with result :- abe
// failed for here : - h and f
// success for here : - h and h with result :- abeh
// success for here : - h and h with result :- abeh
// success for here : - e and e with result :- abe
// failed for here : - h and f
// success for here : - h and h with result :- abeh
// success for here : - h and h with result :- abeh
// success for here : - b and b with result :- ab
// failed for here : - e and c
// success for here : - e and e with result :- abe
// failed for here : - h and f
// success for here : - h and h with result :- abeh
// success for here : - h and h with result :- abeh
// success for here : - e and e with result :- abe
// failed for here : - h and f
// success for here : - h and h with result :- abeh
// success for here : - h and h with result :- abeh
// true

// Explaination:-

//  4. Word Search
//  Given an m x n grid of characters board and a string word, return
//  true if the word exists in the grid.
//  The word can be constructed from letters of sequentially adjacent
//  cells, where adjacent cells are horizontally or vertically
//  neighboring. The same letter cell may not be used more than once.
//  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
//  word = "ABCCED"
//  Output: true

