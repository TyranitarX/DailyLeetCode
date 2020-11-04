import java.util.ArrayList;
import java.util.List;


public class H57_insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newlist = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            newlist.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        newlist.add(newInterval);
        while (i < intervals.length) {
            newlist.add(intervals[i]);
            i++;
        }
        int[][] result = new int[newlist.size()][2];
        for (int j = 0; j < newlist.size(); j++) {
            result[j] = newlist.get(j);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newInterval = {4, 8};
        new H57_insert().insert(intervals, newInterval);
    }
}
