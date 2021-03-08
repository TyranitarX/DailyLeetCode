import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M131_partition {
    boolean[][] f;
    int n;
    List<String> ans = new ArrayList<>();
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], true);
        }
        //首先预处理字符串S所有子串是否为回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String n = "aab";
        System.out.println(new M131_partition().partition(n));
    }
}
