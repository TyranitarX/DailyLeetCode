/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/13 11:06
 **/
public class M935_knightDialer {
    public int knightDialer(int n) {
        int[][] dp = new int[10][n];
        int MOD = (int) (Math.pow(10, 9) + 7);
        int[][] poss = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        for (int i = 0; i < 10; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < poss[j].length; k++) {
                    dp[poss[j][k]][i] += dp[j][i - 1];
                    dp[poss[j][k]][i] = dp[poss[j][k]][i] % MOD;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[i][n - 1];
            ans = ans % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new M935_knightDialer().knightDialer(3131));
    }
}
