package M_144;

import java.util.ArrayList;
import java.util.List;

public class M144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null)
            return preorder(root, new ArrayList<>());
        else
            return new ArrayList<>();
    }

    public List<Integer> preorder(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if(node.left!=null)
            preorder(node.left, list);
        if(node.right!=null)
            preorder(node.right, list);
        return list;
    }
}


