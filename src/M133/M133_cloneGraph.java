package M133;

import java.util.ArrayList;

public class M133_cloneGraph {
    public Node cloneGraph(Node node) {
        Node[] nodes = new Node[100];
        if (node == null) return null;
        if (node.neighbors == null) return new Node();
        if (node.neighbors.size() == 0) return new Node(1, new ArrayList<>());
        nodes = dfs(node, new Node(node.val, new ArrayList<>()), nodes);
        return nodes[1];
    }

    public Node[] dfs(Node olds, Node newnode, Node[] nodes) {
        nodes[olds.val] = newnode;
        int i = 0;
        for (Node node1 : olds.neighbors) {
            if (nodes[node1.val] != null) {
                newnode.neighbors.add(nodes[node1.val]);
                i++;
                continue;
            }
            newnode.neighbors.add(new Node(node1.val, new ArrayList<>()));
            nodes = dfs(node1, newnode.neighbors.get(i), nodes);
            i++;
        }
        return nodes;
    }

    public static void main(String args[]) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        System.out.println(new M133_cloneGraph().cloneGraph(node1).neighbors.get(0).neighbors.get(1).val);
    }
}
