package bilibili2021913;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Course1 {
    public int[] GetLeastNumbers(int[] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.offer(input[i]);
            } else {
                int max = queue.poll();
                if (input[i] < max) {
                    queue.offer(input[i]);
                } else {
                    queue.offer(max);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k-i-1] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1, 7, 7, 7, 7, 7, 7, 7, 7, 4, 3};
        System.out.println(Arrays.toString(new Course1().GetLeastNumbers(input, 4)));
    }
}
