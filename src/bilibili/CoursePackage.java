package bilibili;

import java.util.Scanner;

public class CoursePackage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int[] time = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            String[] values = in.nextLine().split(" ");
            time[i] = Integer.parseInt(values[0]);
            value[i] = Integer.parseInt(values[1]);
        }
        boolean x =true;
        String x1 ="123";
        int[][] dp = new int[n][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = time[0] <= i ? value[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= time[i]) {
                    dp[i][j] = Math.max(dp[i][j], value[i] + dp[i - 1][j - time[i]]);
                }
            }
        }


        System.out.println(dp[n - 1][m]);
    }
}
