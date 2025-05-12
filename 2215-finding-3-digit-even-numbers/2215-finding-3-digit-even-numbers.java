import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();

        // Generate all 3-digit numbers using unique positions
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        int d1 = digits[i];
                        int d2 = digits[j];
                        int d3 = digits[k];

                        // Check for leading zero and even number
                        if (d1 != 0 && d3 % 2 == 0) {
                            int number = d1 * 100 + d2 * 10 + d3;
                            result.add(number);
                        }
                    }
                }
            }
        }

        // Convert Set to array
        int[] ans = new int[result.size()];
        int index = 0;
        for (int num : result) {
            ans[index++] = num;
        }

        return ans;
    }
}
