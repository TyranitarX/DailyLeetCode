import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        int[][] obstacleGrid = {{1, 0}};
        System.out.println(new Test().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] != 1 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] != 1 ? dp[i - 1][0] : 0;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = obstacleGrid[0][i] != 1 ? dp[0][i - 1] : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] != 1 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }

}
