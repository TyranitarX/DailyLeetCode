import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M399_calcEquation {
    double[][] graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (List<String> equation : equations) {
            for (String e : equation) {
                if (!map.containsKey(e)) {
                    map.put(e, index);
                    index++;
                }
            }
        }
        graph = new double[index + 1][index + 1];
        index = 0;
        for (List<String> equation : equations) {
            int a = map.get(equation.get(0));
            int b = map.get(equation.get(1));
            graph[a][b] = values[index];
            graph[b][a] = 1 / values[index];
            index++;
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> temp = queries.get(i);
            if (!map.containsKey(temp.get(0)) || !map.containsKey(temp.get(1))) {
                result[i] = -1;
                continue;
            }
            boolean[] vis = new boolean[graph.length];
            int a = map.get(temp.get(0));
            int b = map.get(temp.get(1));
            result[i] = dfs(a, b, vis);
        }
        return result;
    }

    public double dfs(int a, int b, boolean[] vis) {
        if (graph[a][b] != 0)
            return graph[a][b];
        vis[a] = true;
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && graph[a][i] != 0) {
                double temp = dfs(i, b, vis);
                if (temp != -1) {
                    return graph[a][i] * temp;
                }
            }
        }
        return -1;
    }
}
