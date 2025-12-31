package sorting;

import java.util.Arrays;

// O(N*N)
public class BubbleSort {

    // The XOR Swap Algorithm
    // The XOR operator works based on these properties: 
    // x ^ x is always 0.
    // x ^ 0 is always x.
    // XOR is commutative (x ^ y == y ^ x) and associative. 
    // By applying XOR three times, the values are effectively exchanged at the bit level: 
    static void swap(int a, int b) {
        // a = a ^ b; // a now holds the result of a XOR b
        // b = a ^ b; // b becomes (a ^ b) ^ b, which simplifies to the original a
        // a = a ^ b; // a becomes (a ^ b) ^ a (using the new a and b), which simplifies to the original b 
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public static void main(String[] args) {
        // int arr[] = {7, 8, 3, 1, 2};
        int arr[] = {1, 2, 3, 4, 5};

        // 0 to N-1
        for (int i = 0; i < arr.length - 1; i++) {
            // 0 to N-1-i
            System.out.println(i);
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j]^ arr[j+1];
                    arr[j+1] = arr[j]^arr[j+1];
                    arr[j] = arr[j]^arr[j+1];
                    swapped = true;
                }
            }
            if(!swapped) break;
        }

        System.out.println(Arrays.toString(arr));
    }
}
