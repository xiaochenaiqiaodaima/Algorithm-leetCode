package 接雨水;

import java.util.PriorityQueue;

/**
 * @TaskCode:
 * @description:
 * @author: minshuai.chen
 * @create: 2021/11/3 16:03
 **/
public class Solution {
    public static int trapRainWater(int[][] heightMap) {
        if (heightMap.length <=2 || heightMap[0].length <= 2){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n]; // 后续记录位置是否遍历了
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[2]-o2[2]));//优先队列，后续用来记录最外层的，按高度排序，
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]}); // 存放着最外层的方块
                    visit[i][j] = true;
                }
            }
        }

        int res = 0; // 储存的水量
        int[] disk = {-1,0,1,0,-1}; // 方向数组，上下左右，二维就是{-1，0}，{0,1,},{1,0},{0,-1},压缩成一维
        while ( !pq.isEmpty()) { // 对队列进行遍历
            int[] poll = pq.poll();// 以外围为原点，对四个方向进行方块遍历

            for (int k = 0; k < 4; k++) {//四个方向进行
                int nx = poll[0] + disk[k]; // 相当于X轴,二维的第一
                int ny = poll[1] + disk[k + 1]; // 相当于y轴，二维的第二维
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) { // 此处方块位置是否被遍历
                    if (poll[2] > heightMap[nx][ny]) { // 外围高度大于内部，可以储存水
                        res += poll[2] - heightMap[nx][ny];
                    }
                    pq.offer(new int[]{nx, ny, Math.max(poll[2], heightMap[nx][ny])});//更新位置
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
