import java.util.Deque;
import java.util.LinkedList;

public class H42_trapWater {
    public int trap(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int top = deque.pop();
                if (deque.isEmpty())
                    break;
                int left = deque.peek();
                int len = i - left - 1;
                int high = Math.min(height[i], height[left]) - height[top];
                total += len * high;
            }
            deque.push(i);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new H42_trapWater().trap(arr));
    }
}
