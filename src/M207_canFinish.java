import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M207_canFinish {
    List<LinkedList<Integer>> pointlist;
    int[] visited;
    Boolean valid;

    //深度优先遍历
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        pointlist = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            LinkedList<Integer> point = new LinkedList<>();
            pointlist.add(point);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            pointlist.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        visited = new int[numCourses];
        valid = true;
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0)
                dfs(i);
        }
        return valid;
    }

    public void dfs(int i) {
        visited[i] = 1;
        for (int v : pointlist.get(i)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid)
                    return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }

    public static void main(String args[]) {
        int[][] prerequishites = {{1, 0}, {0, 1}};
        System.out.println(new M207_canFinish().canFinish(2, prerequishites));
    }
}
