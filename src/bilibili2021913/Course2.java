package bilibili2021913;

import java.util.*;

public class Course2 {
    public int[] GetSortedTasks(int[][] taskLists) {
        int i = 0;
        int j = 1;
        Deque<int[]> mytasks = new LinkedList<>();
        for (int k = 0; k < taskLists.length; k++) {
            mytasks.add(taskLists[k]);
        }
        while (mytasks.size() != 1) {
            int[] task1 = mytasks.poll();
            int[] task2 = mytasks.poll();
            mytasks.offer(mysort(task1, task2));
        }
        return mytasks.poll();
    }

    public int[] mysort(int[] task1, int[] task2) {
        int[] res = new int[task1.length + task2.length];
        int i = 0, j = 0, k = 0;
        while (i < task1.length && j < task2.length) {
            if (task1[i] < task2[j]) {
                res[k] = task1[i];
                i++;
            } else {
                res[k] = task2[j];
                j++;
            }
            k++;
        }
        while (i < task1.length) {
            res[k] = task1[i];
            i++;
            k++;
        }
        while (j < task2.length) {
            res[k] = task2[j];
            j++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] tasklist = {{1, 4, 5}, {1, 3, 4}, {2, 6, 7}};
        System.out.println(Arrays.toString(new Course2().GetSortedTasks(tasklist)));
    }
}
