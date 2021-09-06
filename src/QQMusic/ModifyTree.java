package QQMusic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ModifyTree {
    public TreeNode cutTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> myqueue = new LinkedList<>();
        myqueue.offer(root);
        Map<TreeNode, Father> parentmap = new HashMap<>();
        while (!myqueue.isEmpty()) {
            for (int i = 0; i < myqueue.size(); i++) {
                TreeNode now = myqueue.poll();
                if (now.left != null) {
                    myqueue.offer(now.left);
                    parentmap.put(now.left, new Father(now, true));
                }
                if (now.right != null) {
                    myqueue.offer(now.right);
                    parentmap.put(now.right, new Father(now, false));
                }
                if (now.left == null && now.right == null) {
                    Father grandfather = parentmap.get(parentmap.get(now).father);
                    if (grandfather == null)
                        return null;
                    TreeNode grand = grandfather.father;
                    if (grandfather.left)
                        grand.left = null;
                    else
                        grand.right = null;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node = new ModifyTree().cutTree(node);
        System.out.println(node);
    }
}

class Father{
    TreeNode father;
    boolean left;

    public Father(TreeNode father, boolean left) {
        this.father = father;
        this.left = left;
    }
}