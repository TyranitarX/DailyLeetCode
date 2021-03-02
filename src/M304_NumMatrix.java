public class M304_NumMatrix {
    int[][] sum;

    public M304_NumMatrix(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int row = matrix.length;
            int col = matrix[0].length;
            sum = new int[row][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sum[i][j + 1] = sum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for (int i = row1; i <= row2; i++) {
            total += sum[i][col2 + 1] - sum[i][col1];
        }
        return total;
    }
}
