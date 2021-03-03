import java.util.ArrayList;
import java.util.HashSet;

public class M304_NumMatrix {
    int[][] sum;

    public M304_NumMatrix(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int row = matrix.length;
            int col = matrix[0].length;
            sum = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] + matrix[i][j] - sum[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col1 + 1] - sum[row1 + 1][col1] + sum[row1][col1];
    }
}
