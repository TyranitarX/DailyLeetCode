import java.util.Arrays;

public class M59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = 0, status = 0;
        for (int k = 0; k < n * n; k++) {
            matrix[i][j] = k + 1;
            if (status == 0) {
                if (j + 1 >= n || matrix[i][j + 1] != 0){
                    status = (status + 1) % 4;
                    i++;
                }
                else
                    j++;
            } else if (status == 1) {
                if (i + 1 >= n || matrix[i + 1][j] != 0){
                    status = (status + 1) % 4;
                    j--;
                }
                else
                    i++;
            } else if (status == 2) {
                if (j - 1 < 0 || matrix[i][j - 1] != 0){
                    status = (status + 1) % 4;
                    i--;
                }
                else
                    j--;
            } else if (status == 3) {
                if (i - 1 < 0 || matrix[i - 1][j] != 0){
                    status = (status + 1) % 4;
                    j++;
                }
                else
                    i--;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(new M59_generateMatrix().generateMatrix(3));
    }
}
