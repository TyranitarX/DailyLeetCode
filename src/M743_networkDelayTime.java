import java.util.Arrays;

public class M743_networkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 0x3f3f3f3f;
        int[][] net = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                net[i][j] = net[j][i] = i == j ? 0 : INF;
            }
        }
        for (int i = 0; i < times.length; i++) {
            int a = times[i][0], b = times[i][1], c = times[i][2];
            net[a][b] = c;
        }
        int[] dis = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        Arrays.fill(dis, INF);
        Arrays.fill(vis, false);
        dis[k] = 0;
        for (int p = 1; p <= n; p++) {
            int t = -1;
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && (t == -1 || dis[i] < dis[t])) t = i;
            }
            vis[t] = true;
            for (int i = 1; i <= n; i++) {
                dis[i] = Math.min(dis[i], dis[t] + net[t][i]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(dis[i], ans);
        }
        return ans == INF ? -1 : ans;
    }
}
