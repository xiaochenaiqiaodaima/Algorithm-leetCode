package 删除无效的括号;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        set.add(s);
        while (true){
            for (String str : set){ // 判断截取是否符合规范
                if (isValid(str)){
                    res.add(str);
                }
            }

            if (res.size() > 0){
                return res;
            }

            Set<String> curset = new HashSet<>();
            for (String str : set){
                for (int i = 0 ; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i-1)) { // 当第i个与第i-1相同时，截取的与第i个是相同的，
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        curset.add(str.substring(0,i)+str.substring(i + 1));
                    }
                }
            }
            set = curset;
        }

    }

    // 判断左右括号是否符合匹配数量
    public static boolean isValid(String str) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                count ++;
            }else if (c == ')'){
                count --;
                if (count < 0){
                    return false;
                }
            }
        }
        return count == 0;// 最后判断是否左右数量一致
    }

    public static void main(String[] args) {
        String s = ")()";

        System.out.println(removeInvalidParentheses(s));
    }
}