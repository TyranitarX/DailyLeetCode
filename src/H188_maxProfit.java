import java.util.Arrays;

public class H188_maxProfit {
    public int maxProfit(int k, int[] prices) {
        if (prices.length==0)
            return 0;
        int[][] nowmaxbuy = new int[prices.length][k + 1];
        int[][] nowmaxsold = new int[prices.length][k + 1];
        nowmaxbuy[0][0] = -prices[0];
        nowmaxsold[0][0] = 0;
        k = Math.min(k, prices.length / 2);
        for (int i = 1; i <= k; i++) {
            nowmaxbuy[0][i] = nowmaxsold[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < prices.length; i++) {
            nowmaxbuy[i][0] = Math.max(nowmaxbuy[i - 1][0], nowmaxsold[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                nowmaxbuy[i][j] = Math.max(nowmaxbuy[i - 1][j], nowmaxsold[i - 1][j] - prices[i]);
                nowmaxsold[i][j] = Math.max(nowmaxsold[i - 1][j], nowmaxbuy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(nowmaxsold[prices.length - 1]).max().getAsInt();
    }

    public int maxProfit1(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(new H188_maxProfit().maxProfit(k, prices));
    }
}
