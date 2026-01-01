package array;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 1; i < n/2; i++) {
            arr[i*2] = arr[i];
            arr[(i*2)+1]=arr[i]+arr[i+1];
        }
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
