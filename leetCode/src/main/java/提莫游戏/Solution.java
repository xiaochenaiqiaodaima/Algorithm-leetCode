package 提莫游戏;

class Solution {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i +1 <timeSeries.length) {
                if (timeSeries[i + 1] - timeSeries[i] > duration) {
                    time += duration;
                } else {
                    time += timeSeries[i + 1] - timeSeries[i];
                }
            }else {
                time += duration;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,3},2));
    }
}