package byteDance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0, 30],[5, 10],[15, 20]]
 * <p>
 * Output: 2
 */
public class M253_meetingroom2 {
    public int meetingrooms(int[][] times) {
        Arrays.sort(times, Comparator.comparingInt(time -> time[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            if (!queue.isEmpty() && queue.peek() < times[i][0]) queue.poll();
            queue.offer(times[i][1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] times = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(new M253_meetingroom2().meetingrooms(times));
    }
}
