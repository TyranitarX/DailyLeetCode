import java.util.ArrayList;
import java.util.List;

public class M22_generateParenthesis {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int left = n - 1;
        int right = n;
        StringBuilder sb = new StringBuilder("(");
        dfs(sb, left, right);
        return res;
    }

    public void dfs(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left != 0) {
            sb.append("(");
            dfs(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right != 0 && left < right) {
            sb.append(")");
            dfs(sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        new M22_generateParenthesis().generateParenthesis(3).forEach(System.out::println);
    }
}
