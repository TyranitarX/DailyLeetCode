import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        Boolean[][] vis = new Boolean[n][m];
        for (int i = 0; i < vis.length; i++) {
            Arrays.fill(vis[i], false);
        }
        int i = 0, j = 0;
        int status = 0;//0右1下2左3上
        while (i >= 0 && j >= 0 && i < n && j < m && !vis[i][j]) {
            if (status == 0) {
                while (j < m && !vis[i][j]) {
                    vis[i][j] = true;
                    res.add(matrix[i][j]);
                    j++;
                }
                j--;
                status = (status + 1) % 4;
                i++;
            } else if (status == 1) {
                while (i < n && !vis[i][j]) {
                    vis[i][j] = true;
                    res.add(matrix[i][j]);
                    i++;
                }
                i--;
                status = (status + 1) % 4;
                j--;
            } else if (status == 2) {
                while (j >= 0 && !vis[i][j]) {
                    vis[i][j] = true;
                    res.add(matrix[i][j]);
                    j--;
                }
                j++;
                status = (status + 1) % 4;
                i--;
            } else if (status == 3) {
                while (i >= 0 && !vis[i][j]) {
                    vis[i][j] = true;
                    res.add(matrix[i][j]);
                    i--;
                }
                i++;
                status = (status + 1) % 4;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(new M54_spiralOrder().spiralOrder(matrix));
    }
}
