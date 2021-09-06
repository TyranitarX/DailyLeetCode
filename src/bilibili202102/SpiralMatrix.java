package bilibili202102;

import java.util.Arrays;

public class SpiralMatrix {
    int[] posx = {0, 1, 0, -1};
    int[] posy = {1, 0, -1, 0};

    public int[] spiralMatrix(int[][] matrix) {
        int i = 0;
        int j = 0;
        int sw = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        boolean[][] visit = new boolean[m][n];
        for (int p = 0; p < res.length; p++) {
            res[p] = matrix[i][j];
            visit[i][j] = true;
            if (!(i + posx[sw] >= 0 && i + posx[sw] < matrix.length && j + posy[sw] >= 0 && j + posy[sw] < matrix[0].length
                    && !visit[i + posx[sw]][j + posy[sw]])
            ) {
                sw = (sw + 1) % 4;
            }
            i = i + posx[sw];
            j = j + posy[sw];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] str = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(new SpiralMatrix().spiralMatrix(str)));
    }
}
