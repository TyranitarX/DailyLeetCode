import java.util.Arrays;
import java.util.Comparator;

public class M452_findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])
        );
        int count = 1;
        int[] lasttemp = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lasttemp[1]) {
                count++;
                lasttemp = points[i];
            } else {
                lasttemp = new int[]{points[i][0], Math.min(lasttemp[1], points[i][1])};
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{9, 12}, {1, 10}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(new M452_findMinArrowShots().findMinArrowShots(points));
    }
}
