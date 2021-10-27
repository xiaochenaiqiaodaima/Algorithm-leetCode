package 无重复字符的最长字串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @TaskCode:
 * @description:
 * @author: minshuai.chen
 * @create: 2021/10/11 15:34
 **/
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
//        if (s == null){
//            return 0;
//        }
        List<Character> list = new ArrayList<>();
        int lastDate = 0;
        int res = 0;

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            start = i;
            Character index = s.charAt(i);
            if (list.contains( index)){
//                size = list.size();
                list.remove(index);
            }
            list.add( index);
            res = Math.max(res,end-start+1);
        }
        // 记录字符上一次出现的位置
//        int[] last = new int[128];
//        for(int i = 0; i < 128; i++) {
//            last[i] = -1;
//        }
//        int n = s.length();
//
//        int res = 0;
//        int start = 0; // 窗口开始位置
//        for(int i = 0; i < n; i++) {
//            int index = s.charAt(i);
//            start = Math.max(start, last[index] + 1);
//            res   = Math.max(res, i - start + 1);
//            last[index] = i;
//        }
        return res;

    }

    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("pwwkew");
        System.out.println(a);

    }
}
