package PerfectWorld;

import java.util.Arrays;

public class Course1 {
    public int minCost(int N, int[][] roads) {
        int INF = 0x3f3f3f;
        int[][] village = new int[N][N];
        boolean[][] isget = new boolean[N][N];
        for (int i = 0; i < roads.length; i++) {
            village[roads[i][0] - 1][roads[i][1] - 1] = roads[i][2];
        }
        for (int i = 0; i < roads.length; i++) {
            isget[roads[i][0] - 1][roads[i][1] - 1] = roads[i][3] == 1;
        }
        int dis[] = new int[N];
        boolean vis[] = new boolean[N];
        Arrays.fill(dis, INF);
        Arrays.fill(vis, false);
        dis[0] = 0;
        for (int p = 0; p < N; p++) {
            int t = -1;
            for (int j = 0; j < N; j++) {
                if (!vis[j] && (t == -1 || dis[j] < dis[t])) t = j;
            }
            vis[t] = true;
            for (int i = 0; i < N; i++) {
                if (!isget[t][i]) {
                    dis[i] = Math.min(dis[i], village[t][i] + dis[t]);
                } else {
                    dis[i] = Math.min(dis[i], dis[t]);
                }
            }
        }
        return dis[N - 1];
    }
}
