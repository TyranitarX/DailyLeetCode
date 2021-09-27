import java.util.Collections;

public class M74_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i <= j) {
            int mid = (j - i + 1) / 2 + i;
            if (matrix[mid][0] < target)
                i = mid;
            else
                j = mid - 1;
        }
        int k = i;
        i = 0;
        j = matrix[k].length - 1;
        while (i <= j) {
            int mid = (j - i + 1) / 2 + i;
            if (matrix[k][mid] == target)
                return true;
            if (matrix[k][mid] <= target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        System.out.println(new M74_searchMatrix().searchMatrix(matrix, 1));
    }
}
