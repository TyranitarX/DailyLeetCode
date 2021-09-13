import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/13 10:10
 **/
public class M1197_minKnightMoves {
    public int minKnightMoves(int x, int y) {
        int[][] pos = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {-1, 2}, {-1, -2}, {1, -2}};
        int count = 0;
        Deque<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{0, 0});
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] now = queue.poll();
                for (int[] po : pos) {
                    if (now[0] + po[0] == x && now[1] + po[1] == y)
                        return count;
                    else
                        queue.offer(new Integer[]{now[0] + po[0], now[1] + po[1]});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new M1197_minKnightMoves().minKnightMoves(1,1));
    }
}
