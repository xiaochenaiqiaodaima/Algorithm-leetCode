package 下一个更大元素.官方解答_栈;

import java.util.*;

class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            System.out.println(stack.isEmpty());
            System.out.println(stack.peek());
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }

            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,1,2};
        int[] b = {1,3,4,2};
        int[] ints = nextGreaterElement(a, b);
        System.out.println(Arrays.toString(ints));
    }
}
