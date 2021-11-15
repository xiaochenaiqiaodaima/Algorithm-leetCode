package 猜数字游戏;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static String getHint(String secret, String guess) {
        int a = 0;
        int[] cntS = new int[10], cntG = new int[10];
        char[] chars = secret.toCharArray();
        char[] chars1 = guess.toCharArray();
        for (int i = 0; i < chars.length; i++){
                if (chars[i] == chars1[i]){
                    ++a;
                } else {
                    cntG[chars[i]- '0']++;
                    cntS[chars1[i] -'0']++;
                }
            }
        int b =0;
        for (int i = 0; i < 10; i++){
            b+= Math.min(cntG[i],cntS[i]);
        }
        return a + "A" +b+ "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("11","10"));
    }
}