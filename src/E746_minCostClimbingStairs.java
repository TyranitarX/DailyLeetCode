public class E746_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[][] total = new int[cost.length][2];
        total[0][1] = cost[0];
        total[1][0] = total[0][1];
        total[1][1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            total[i][0] = total[i - 1][1];
            total[i][1] = Math.min(cost[i] + total[i - 2][1], cost[i] + total[i - 1][1]);
        }
        return Math.min(total[cost.length - 1][0], total[cost.length - 1][1]);
    }

    public static void main(String args[]) {
        int[] cost = {10, 15, 20};
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new E746_minCostClimbingStairs().minCostClimbingStairs(cost1));
    }
}
