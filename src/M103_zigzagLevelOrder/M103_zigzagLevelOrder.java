package M103_zigzagLevelOrder;

import java.util.*;


public class M103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        boolean isleft = false;
        List<List<Integer>> result =new ArrayList<>();
        List<Stack<TreeNode>> queueList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        queueList.add(stack);
        List<Integer> now = new ArrayList<>();
        now.add(root.val);
        result.add(now);
        while (!queueList.get(queueList.size() - 1).isEmpty()) {
            now =new ArrayList<>();
            Stack<TreeNode> nowqueue = queueList.get(queueList.size() - 1);
            Stack<TreeNode> next = new Stack<>();
            while (!nowqueue.isEmpty()) {
                TreeNode node = nowqueue.pop();
                if (isleft) {
                    if (node.left != null){
                        next.add(node.left);
                        now.add(node.left.val);
                    }
                    if (node.right != null){
                        next.add(node.right);
                        now.add(node.right.val);
                    }
                } else {
                    if (node.right != null){
                        next.add(node.right);
                        now.add(node.right.val);
                    }
                    if (node.left != null){
                        next.add(node.left);
                        now.add(node.left.val);
                    }
                }
            }
            queueList.add(next);
            result.add(now);
            isleft = !isleft;
        }
        result.remove(result.size()-1);
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        System.out.println(new M103_zigzagLevelOrder().zigzagLevelOrder(treeNode));
    }
}
