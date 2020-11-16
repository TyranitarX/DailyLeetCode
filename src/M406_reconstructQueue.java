import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][];
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        for (int i = 0; i < people.length; ++i) {
            int nums = people[i][1] + 1;
            for (int j = 0; j < people.length; ++j) {
                if (queue[j] == null) {
                    nums--;
                    if (nums == 0) {
                        queue[j] = people[i];
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < queue.length; i++) {
            System.out.println(Arrays.toString(queue[i]));
        }
        return queue;
    }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    public int[][] reconstructQueue3(int[][] people) {
        // 排序规则
        // 1、h不同，h按从大到小
        // 2、h相同，k按从小到大
        Arrays.sort(people, new Comparator<int[]> () {
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        for(int i=0;i< people.length;i++){
            System.out.println(Arrays.toString(people[i]));
        }
        // 排完序，以k作为索引插入列表
        List<int[]> list = new ArrayList<>(people.length);
        for (int[] p : people) {
            System.out.println(p[1]);
            list.add(p[1], p);
        }
        for(int i=0;i<list.size();i++){
            System.out.println(Arrays.toString(list.get(i)));
        }
        // 将list还原为array
        int[][] ans = new int[people.length][2];
        list.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] people = {{4, 4}, {5, 0}, {5, 2}, {6, 1}, {7, 0}, {7, 1}};
        new M406_reconstructQueue().reconstructQueue3(people);
    }
}
