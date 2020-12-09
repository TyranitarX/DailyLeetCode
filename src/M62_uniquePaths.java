public class M62_uniquePaths {
    /* 失败的DFS*/
//    int total = 0;
//
//    public int uniquePaths(int m, int n) {
//        int sm = 0;
//        int sn = 0;
//        dfs(m, n, sm, sn);
//        return total;
//    }
//
//    public void dfs(int m, int n, int sm, int sn) {
//        if (sm == m - 1 && sn == n - 1)
//            total += 1;
//        if (sm >= m || sn >= n)
//            return;
//        else {
//            dfs(m, n, sm + 1, sn);
//            dfs(m, n, sm, sn + 1);
//        }
//    }
    //DP
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            map[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new M62_uniquePaths().uniquePaths(23, 12));
    }
}
