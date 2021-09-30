package byteDance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/29 21:35
 **/
public class M236_lowestCommonAncestor {
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visit.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visit.contains(q.val))
                return q;
            else {
                q = parent.get(q.val);
            }
        }
        return new TreeNode(-1);
    }

    public void dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new M236_lowestCommonAncestor().lowestCommonAncestor(root, root.left, root.right).val);
    }
}
