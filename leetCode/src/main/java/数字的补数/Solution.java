package 数字的补数;

/**
 * @TaskCode:
 * @description:
 * @author: minshuai.chen
 * @create: 2021/10/18 13:57
 **/
public class Solution {
    public static int findComplement(int num) {
//        String str = binaryToDecimal(num);
        String str = Integer.toBinaryString(num);
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (chars[i]== '0') {
                sb.append(1);
            }else {
                sb.append(0);
            }
        }
        System.out.println(sb.toString());
       return Integer.parseInt(sb.toString(),2);
    }

    public static String binaryToDecimal(int n) {
        String str = "";
        while(n != 0){
            str = n%2 + str;
            n = n/2;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
        int complement = findComplement(5);
        System.out.println(complement);
    }
}
