import javax.print.DocFlavor;
import java.util.HashMap;

public class M337_rob {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        HashMap<TreeNode, Integer> temps = new HashMap<>();
        int result[] = doRob2(root);
        return Math.max(result[0], result[1]);
    }

    //记忆化搜索递归DP
    public int doRob(TreeNode root, HashMap<TreeNode, Integer> temps) {
        if (root == null)
            return 0;
        if (temps.containsKey(root))
            return temps.get(root);
        int money = root.val;
        if (root.left != null) {
            money += doRob(root.left.left, temps) + doRob(root.left.right, temps);
        }
        if (root.right != null) {
            money += doRob(root.right.left, temps) + doRob(root.right.right, temps);
        }
        int result = Math.max(money, doRob(root.left, temps) + doRob(root.right, temps));
        temps.put(root, result);
        return result;
    }

    //dp降维优化
    public int[] doRob2(TreeNode root) {
        if (root == null)
            return new int[2];
        int val = root.val;
        int[] result = new int[2];
        int[] left = doRob2(root.left);
        int[] right = doRob2(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = val + left[0] + right[0];
        return result;
    }
}
