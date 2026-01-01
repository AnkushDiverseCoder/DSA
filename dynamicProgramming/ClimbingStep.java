package dynamicProgramming;

import java.util.Arrays;

public class ClimbingStep {

    static int climbingStair(int level, int[] dp,int n){

        // Base Case
        if(level == n){
            return 1;
        }

        if(dp[level] != -1){
            return dp[level];                    
        }
        int ans =0;
        for (int i = 1; i <= 3; i++) {
            if(level+i <=n){
                int ways = climbingStair(level+i,dp,n);
                ans+=ways;
            }
        }
        dp[level] = ans;
        return ans;   
    }

    public static void main(String[] args) {
        int[] dp = new int[100];
        Arrays.fill(dp,-1);
        System.out.println(climbingStair(0, dp,5));
    }

}
