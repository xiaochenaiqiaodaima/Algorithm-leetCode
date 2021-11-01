package 删除无效的括号.官方解答.回溯_剪枝;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static List<String> res = new ArrayList<String>();

    public static List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }
        System.out.println(lremove +" "+ rremove);
        helper(s, 0, 0, 0, lremove, rremove);

        return res;
    }

    private static void helper(String str, int start, int lcount, int rcount, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lcount, rcount, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lcount, rcount, lremove, rremove - 1);
            }
            if (str.charAt(i) == ')') {
                lcount++;
            } else if (str.charAt(i) == ')') {
                rcount++;
            }
            // 当前右括号的数量大于左括号的数量则为非法,直接返回.
            if (rcount > lcount) {
                break;
            }
        }
    }

    // 判断截取后是否符合规范
    private static boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }

    public static void main(String[] args) {
        removeInvalidParentheses(")()(");
    }
}
