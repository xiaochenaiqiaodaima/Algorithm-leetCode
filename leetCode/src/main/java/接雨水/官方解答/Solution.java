package 接雨水.官方解答;

import java.util.PriorityQueue;

class Solution {
    public static int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i , j, heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int k = 0; k < 4; ++k) {
                int nx = curr[0]  + dirs[k];
                int ny = curr[1]  + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
                    if (curr[2] > heightMap[nx][ny]) {
                        res += curr[2] - heightMap[nx][ny];
                    }
                    pq.offer(new int[]{nx , ny, Math.max(heightMap[nx][ny], curr[2])});
                    visit[nx][ny] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] heightMap = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        int i = trapRainWater(heightMap);
        System.out.println(i);
    }
}
