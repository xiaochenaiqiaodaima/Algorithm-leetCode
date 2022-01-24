package 灯泡开关;

class Solution {
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n +0.5 ); // 加0.5进行四舍五入的意思
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(9));
        System.out.println();
    }
}