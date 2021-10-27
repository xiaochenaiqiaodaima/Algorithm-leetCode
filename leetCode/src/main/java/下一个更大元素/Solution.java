package 下一个更大元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[] {-1};
        }
//        List<Integer> result = new ArrayList<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
//            boolean t = true;
            int a = nums1[i];
            int k = 0;
            for (int j = 0; j < nums2.length; j++ ) {
//                if (a == nums2[j]){
//                    if (nums2[j+1] > a){
//                        result.add(nums2[j+1]);
//                        t = false;
//                        break;
//                    }else{
//                        result.add(-1);
//                        t=false;
//                        break;
//                    }
//                }
                // 优化
                if (a == nums2[j]) {
                    k =j;
                }

            }
            int s = k+1;
            while (s < nums2.length && nums2[k] > nums2[s]){
                ++s;
            }
            result[i] = s < nums2.length? nums2[s] : -1;
//            if (t){
//            result.add(-1);
//            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4,1,2};
        int[] b = {1,3,4,2};
        int[] ints = nextGreaterElement(a, b);
        System.out.println(Arrays.toString(ints));
    }
}