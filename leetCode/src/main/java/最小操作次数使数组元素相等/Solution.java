package 最小操作次数使数组元素相等;

import java.util.Arrays;

public class Solution {

    public static int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = 0;
        for (int num : nums) {
            sum +=num-min;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = minMoves(new int[]{1,2,3});
        System.out.println(sum);
    }
}