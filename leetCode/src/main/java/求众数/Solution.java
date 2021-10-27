package 求众数;

import java.util.*;

public class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1) {
            return Arrays.asList(nums[0]);
        }
        if (nums.length == 2) {
            return Arrays.asList(nums[0],nums[1]);
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i]) +1);
                if (map.get(nums[i]) > n/3) {
                     if (! result.contains(nums[i])){
                        result.add(nums[i]);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = majorityElement(new int[]{0,0,0});
        System.out.println(list);
    }
}