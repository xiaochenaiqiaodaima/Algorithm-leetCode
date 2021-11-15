package 最长定差子序列;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a,map.getOrDefault(a - difference,0)+1);
            ans = Math.max(ans,map.get(a));
        }
        return ans;
    }
    public static int longestSubsequence1(int[] arr, int difference) {
        int count[]=new int[20001];//表示以（i-10000）的最长子串
        int ans=1;
        for(int i=0;i<arr.length;i++){
            if (arr[i] - difference >= -10000 && arr[i] - difference <= 10000) {
                count[arr[i] + 10000] = Math.max(count[arr[i] + 10000], count[arr[i] - difference + 10000] + 1);
            } else {
                count[arr[i] + 10000] = 1;
            }
            ans=Math.max(ans,count[arr[i]+10000]);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1,2,6,3,4},1));
    }
}