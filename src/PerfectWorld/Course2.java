package PerfectWorld;

public class Course2 {
    public int maxProfit(int k, int[] prices, int fee) {
        int n = prices.length;
        if (k == 0 || n == 0)
            return 0;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i] - fee);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], (i >= 2 ? dp[i - 2][k - 1][0] : 0) - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }


    public static void main(String[] args) {

    }
}
