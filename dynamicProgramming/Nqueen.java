package dynamicProgramming;

import java.util.Arrays;

public class Nqueen {

    static boolean check(int[] queen,int row,int col){
        for (int i = 0; i < row; i++) {
            int prow = i;
            int pcol = queen[i];

            if(pcol == col || Math.abs(col-pcol)==Math.abs(row-prow) ){
                return false;
            }
        }

        return true; 
    }

    static int possibleWays(int[] queen, int n,int level){
        // level -> 

        // Pruning 

        // base case 
        if(level == n){
            return 1;
        }

        // compute
        int ans =0;
        for (int col = 0; col < n; col++) {
            if(check(queen,level,col)){
                queen[level] = col;
                ans+= possibleWays(queen,n,level+1);
                queen[level] = -1 ;
            }
        }
        return ans;
        // Move
    }

    public static void main(String[] args) {
        int[] queen = new int[20];
        Arrays.fill(queen, -1);
        System.out.println(possibleWays(queen, 8,0));
    }
}
