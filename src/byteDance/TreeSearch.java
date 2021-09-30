package byteDance;

import java.util.ArrayList;

import java.util.List;


public class TreeSearch {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> searchTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode now) {
        if (now == null)
            return;
        cur.add(now.val);
        if (now.left == null && now.right == null) {
            res.add(new ArrayList<>(cur));
        }
        dfs(now.left);
        dfs(now.right);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new TreeSearch().searchTree(root));
    }
}
