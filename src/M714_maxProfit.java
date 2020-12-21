public class M714_maxProfit {
    public int maxProfit(int[] prices, int fee) {
        int[][] status = new int[prices.length][2];
        status[0][0] = 0;
        status[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            status[i][0] = Math.max(status[i - 1][0], status[i - 1][1] + prices[i] - fee);
            status[i][1] = Math.max(status[i - 1][1], status[i - 1][0] - prices[i]);
        }
        return Math.max(status[prices.length - 1][0], status[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new M714_maxProfit().maxProfit(prices, fee));
    }
}
