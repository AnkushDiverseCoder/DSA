package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonnaci {

    static int[] dp = new int[100000];

    static int fib(int n, int[] dp){
        dp[0]=0;
        dp[1]=1;

        if(dp[n] != -1 ){
            return dp[n];
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        Arrays.fill(dp, -1);
        System.out.println( fib(n, dp) );
    }
}
