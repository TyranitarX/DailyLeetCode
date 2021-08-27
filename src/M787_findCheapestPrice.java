import java.util.Arrays;

public class M787_findCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int[][] flys = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flys[i][j] = flys[j][i] = i == j ? 0 : INF;
            }
        }
        for (int i = 0; i < flights.length; i++) {
            int a = flights[i][0], b = flights[i][1], c = flights[i][2];
            flys[a][b] = c;
        }
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] clone = dis.clone();
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    dis[b] = Math.min(dis[b], clone[a] + flys[a][b]);
                }
            }
        }
        return dis[dst] == INF ? -1 : dis[dst];
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 4}, {0, 2, 3}, {1, 2, -2}};
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println(new M787_findCheapestPrice().findCheapestPrice(n, flights, src, dst, k));
    }
}
