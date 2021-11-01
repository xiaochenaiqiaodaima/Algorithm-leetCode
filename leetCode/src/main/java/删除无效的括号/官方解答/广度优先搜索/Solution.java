package 删除无效的括号.官方解答.广度优先搜索;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses(")())"));
    }
    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        Set<String> currSet = new HashSet<String>();

        currSet.add(s);
        while (true) {
            for (String str : currSet) {
                if (isValid(str)) { // 判断截取后是否符合规范
                    ans.add(str);
                }
            }
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> nextSet = new HashSet<String>();
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i ++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        String a = str.substring(0, i);
                        String a1 = str.substring(i + 1);
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }

    private static boolean isValid(String str) {
        char[] ss = str.toCharArray();
        int count = 0;

        for (char c : ss) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}
