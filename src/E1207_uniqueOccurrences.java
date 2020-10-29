import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E1207_uniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countmap = new HashMap<>();
        List<Integer> valuelist = new ArrayList<>();
        for (int i : arr) {
            if (!countmap.containsKey(i)) {
                countmap.put(i, 1);
            } else {
                int pre = countmap.get(i);
                countmap.put(i, pre + 1);
            }
        }
        for (int i : countmap.values()) {
            if (!valuelist.contains(i)) {
                valuelist.add(i);
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(new E1207_uniqueOccurrences().uniqueOccurrences(arr));
    }
}
