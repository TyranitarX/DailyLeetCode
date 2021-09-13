import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/13 9:13
 **/
public class M447_numberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int xnow = points[i][0];
            int ynow = points[i][1];
            Map<Integer, Integer> distancemap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int curx = points[j][0];
                    int cury = points[j][1];
                    int distance = (int) (Math.pow((curx - xnow), 2) + Math.pow((cury - ynow), 2));
                    distancemap.put(distance, distancemap.getOrDefault(distance, 0) + 1);
                }
            }
            for (Integer num : distancemap.values()) {
                ans += (num - 1) * num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(new M447_numberOfBoomerangs().numberOfBoomerangs(points));
    }
}
