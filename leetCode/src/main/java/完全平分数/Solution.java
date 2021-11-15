package 完全平分数;

class Solution {
    public static boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            long squre = (long) mid*mid;
            if (squre < num){
                left = mid+1;
            }else if (squre > num){
                right = mid -1;
            }else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }
}