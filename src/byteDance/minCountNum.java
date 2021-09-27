package byteDance;

import java.util.Arrays;

/**
 * 给定不同质量的砝码，写一个函数可以计算凑出一个给定重量所需的最少砝码数，
 * 如果凑不出则返回-1每种重量的砝码数是无限的；
 * <p>
 * 完全背包
 */
public class minCountNum {
    public int count(int[] weights, int target) {
        Arrays.sort(weights);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int w : weights) {
                if (i >= w) {
                    dp[i] = Math.min(dp[i], dp[i - w] + 1);
                }
            }
        }
        return dp[target] != target + 1 ? dp[target] : -1;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 5};
        System.out.println(new minCountNum().count(weights, 11));
    }
}
