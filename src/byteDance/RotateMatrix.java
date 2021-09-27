package byteDance;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < m; i++) {
            int p = 0;
            int q = m - 1;
            while (p < q) {
                swap(matrix, i, p, i, q);
                p++;
                q--;
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
}
