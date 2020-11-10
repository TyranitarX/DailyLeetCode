import java.util.*;

public class M_973kClosest {
    public int[][] kClosest(int[][] points, int K) {
        Map<int[], Double> distancemap = new HashMap<>();
        int[][] resultlist = new int[K][2];
        for (int i = 0; i < points.length; i++) {
            distancemap.put(points[i], Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
        }
        List<Map.Entry<int[], Double>> list = new ArrayList<>(distancemap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (int i = 0; i < K; i++) {
            resultlist[i] = list.get(i).getKey();
        }
        return resultlist;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {-2, 4}, {5, -1}};
        int[][] closest = new M_973kClosest().kClosest(points, 1);
    }
}
