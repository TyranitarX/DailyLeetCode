package PerfectWorld;

public class package01 {
    public int KnapPack(int[] w, int[] v, int c) {
        int n = w.length;
        if (n == 0 || c == 0)
            return 0;
        int[][] dp = new int[n][c + 1];
        for (int i = 0; i <= c; i++) {
            dp[0][i] = i >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[n - 1][c];
    }

    public static void main(String[] args) {
        int[] v = {5000, 4000, 3000, 500, 200};
        int[] w = {5, 4, 6, 3, 1};
        int count = 10;
        System.out.println(new package01().KnapPack(w, v, count));
    }
}
