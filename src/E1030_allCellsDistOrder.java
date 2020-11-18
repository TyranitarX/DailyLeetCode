import java.util.*;

public class E1030_allCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<int[], Integer> distancemap = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int[] position = {i, j};
                distancemap.put(position, Math.abs(i - r0) + Math.abs(j - c0));
            }
        }
        List<Map.Entry<int[], Integer>> list = new ArrayList(distancemap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[][] lists = new int[list.size()][2];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = list.get(i).getKey();
        }
        return lists;
    }
}
