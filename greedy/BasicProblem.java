package greedy;

import java.util.Arrays;

public class BasicProblem {
    
    // Arr=[1,2,1,7,6] N=5 Return smallest number u cannot create a subset sum
    // idea1 DP Subset Sum dp(level,sum_create/sum_left) not used where constraint is larger 10^5 or 10^9
    // Subset Generation in Greedy (Sorting is first idea if constraint are larger)
    // idea 2 build pre fix sum and compare and check where number is absent
   
    public static int problem1(int[] arr, int n){
        // Do in place return void
        Arrays.sort(arr);
        // [1,1,2,6,7] [1,2,4]
        int prefixSum =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= prefixSum+1 ){
                prefixSum += arr[i];
            }else{
                return prefixSum+1;
            }
        }
        return 0;
    }

    // https://www.youtube.com/watch?v=EvPnuMCF37k&list=PLqf9emQRQrnIJLYsRMDL_a38sOwUUMtvx&index=3
    // Problem 2:- can u dearrange them
    // Perumute A to B; So that A[i] != b[i] 
    // A = [1,5,3,1,2,1,3,3,2,3,1]
    // premute A to B; what if a is sorted by frequency
    // A' = [1,1,1,1,3,3,3,3,2,2,5]; generate using this array
    // B' = [3,2,2,5,1,1,1,1,3,3,3]; shifted by max frequency of 1  
    // with this idea with above idea from A to B not from A' to B'
    // Logic Max frequency must not exceed length of array/2


    // Problem 3:- Minimum Swaps to correct 
    // Given a Source Array A & a target Array B, find Minimum swaps needed on A so that ΑΓίζ = ΒΓίζ
    // (1) All elements are unique. [classical)
    // 2 Elements can repeat [non-classical]
    // A 135246
    // B 214356

    public static void main(String[] args) {
        
    }
}
