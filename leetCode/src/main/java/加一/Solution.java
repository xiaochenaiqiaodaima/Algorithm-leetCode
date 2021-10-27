package 加一;

import java.util.Arrays;
import java.util.Vector;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; --i) {
            if (digits[i] != 9){
                ++digits[i];
                for ( int j = i + 1; j < n; j++ ) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] ints = new int[n+1];
        ints[0] = 1;
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{1, 2, 9});
        System.out.println(Arrays.toString(ints));
    }
}