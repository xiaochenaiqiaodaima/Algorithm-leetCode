package 外观数列;

/**
 * @TaskCode:
 * @description:
 * @author: minshuai.chen
 * @create: 2021/10/15 14:58
 **/
public class Solution {
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append((pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }

    public static void main(String[] args) {
//        String s = countAndSay(2);
//        System.out.println(s);
        String dfs = dfs(2-1, "1");
        System.out.println(dfs);
    }

    public static String dfs(int n,String res){
        if (n==0) return res;
        char tem = res.charAt(0);
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<res.length();i++){
            if (res.charAt(i) == tem){
                count++;
            }else{
                sb.append(count);
                sb.append(tem);
                count = 1;
                tem = res.charAt(i);
            }
            if (i==res.length()-1){
                sb.append(count);
                sb.append(tem);
            }
        }
        return dfs(n-1,sb.toString());
    }
}
