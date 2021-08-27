import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M797_allPathsSourceTarget {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> listnow = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[][] mygraph = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(mygraph[i], 0);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                mygraph[i][graph[i][j]] = 1;
            }
        }
        dfs(mygraph, 0);
        return res;
    }

    public void dfs(int[][] graph, int now) {
        listnow.add(now);
        if (now == graph.length - 1) {
            res.add(new ArrayList<>(listnow));
            return;
        }
        for (int i = 0; i < graph[now].length; i++) {
            if (graph[now][i] == 1) {
                dfs(graph, i);
                listnow.remove(listnow.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new M797_allPathsSourceTarget().allPathsSourceTarget(graph));
    }
}
