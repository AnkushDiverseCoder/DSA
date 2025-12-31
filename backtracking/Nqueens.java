
public class Nqueens {

    // public static int NQueen(int level){
    //     for(all choices){
    //         if(check(valid choice)){
    //             move(choice)
    //         }
    //     }
    // }
    public static int NQueen(boolean[][] board, int row) {
        if(row == board.length){
            // display(board);
            return 1;
        }
        int count = 0;
        // Placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            // place queen if it is safe 
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += NQueen(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col){
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        // diaognal left
        int maxLeft = Math.min(row, col);
        for (int i = 0; i < maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }
        // diaognal left
        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 0; i < maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println("[");
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]){
                    System.out.println("Q");
                }else{
                    System.out.println(" ,");
                }
            }
            System.out.println("]");
        }
    } 

    public static void main(String[] args) {
        int n=7;
        boolean[][] board = new boolean[n][n];
        System.out.println(NQueen(board, 0));   
    }
}
