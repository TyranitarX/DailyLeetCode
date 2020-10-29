package M_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M144_stackPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> liststack = new Stack<>();
        TreeNode node = root;
        while (!liststack.empty() || node != null) {
            while (node != null) {
                liststack.push(node);
                result.add(node.val);
                node = node.left;
            }
            node = liststack.pop();
            node = node.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new M144_stackPreorderTraversal().preorderTraversal(root));
    }
}
