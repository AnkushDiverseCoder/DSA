package string;

import java.util.*;

public class MaxResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        if (num.length() == 0) {
            System.out.println(-1);
            return;
        }

        if (num.length() == 1) {
            System.out.println(num);
            return;
        }

        // Step 1: Use HashSet to store unique digits
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length(); i++) {
            set.add(num.charAt(i) - '0'); // correct digit conversion
        }

        // Step 2: Convert set to list
        List<Integer> list = new ArrayList<>(set);

        // Step 3: Sort in descending order
        Collections.sort(list, Collections.reverseOrder());

        // Step 4: Build the result number
        int result = 0;
        for (int digit : list) {
            result = result * 10 + digit;
        }

        System.out.println(result);
    }
}
