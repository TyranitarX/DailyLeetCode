package bilibili20201;

import java.util.Scanner;

public class Course3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int m = Integer.parseInt(in.nextLine());
        String[] w = in.nextLine().split(" ");
        String[] v = in.nextLine().split(" ");
        int[][] dp = new int[n][m + 1];
        for (int i = 0; i <= m; i++) {
            int weight = Integer.parseInt(w[0]);
            int value = Integer.parseInt(v[0]);
            dp[0][i] = i >= weight ? value : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                int weight = Integer.parseInt(w[i]);
                int value = Integer.parseInt(v[i]);
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i][j], value + dp[i - 1][j - weight]);
                }
            }
        }
        System.out.println(dp[n - 1][m]);
    }
}
