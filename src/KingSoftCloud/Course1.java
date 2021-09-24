package KingSoftCloud;

import java.util.Arrays;
import java.util.Scanner;

public class Course1 {
    static int curmax = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], -1);
        }
        for (int i = 0; i < n; i++) {
            String[] nums = in.nextLine().split(" ");
            for (int j = 0; j < nums.length; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }
//        dfs(map, 0, 0, 0);
        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = map[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (i != n - 1)
                    dp[i][j] = Math.max(dp[i - 1][j] + map[i][j], dp[i][j - 1] + map[i][j]);
                else
                    dp[i][j] = dp[i - 1][j] + map[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] > max)
                max = dp[n - 1][i];
        }
        System.out.println(max);
    }

    static int[][] move = {{0, 1}, {1, 0}};

    public static void dfs(int[][] map, int i, int j, int current) {
        if (map[i][j] == -1)
            return;
        current += map[i][j];
        if (i == map.length - 1) {
            if (current > curmax)
                curmax = current;
            return;
        }
        for (int k = 0; k < move.length; k++) {
            dfs(map, i + move[k][0], j + move[k][1], current);
        }
    }
}
