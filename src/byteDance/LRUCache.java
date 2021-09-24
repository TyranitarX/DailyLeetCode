package byteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/24 15:56
 **/
public class LRUCache {
    private int capacaty;
    private Node first;
    private Node last;
    private Map<Integer, Node> map;

    public LRUCache(int capacaty) {
        this.capacaty = capacaty;
        map = new HashMap<>(capacaty);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;
            if (map.size() == capacaty)
                removeLast();

            addToHead(node);
            map.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        if (node == first) {
            return;
        } else if (node == last) {
            last.prev.next = null;
            last = last.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = first;
        first.prev = node;
        first = node;
    }

    private void addToHead(Node node) {
        if (map.isEmpty()) {
            first = node;
            last = node;
        } else {
            first.prev = node;
            node.prev = null;
            node.next = first;
            first = node;
        }
    }

    private void removeLast() {
        map.remove(last.key);
        Node preNode = last.prev;
        if (preNode != null) {
            preNode.next = null;
            last = preNode;
        }
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);//【1】左边是最近使用的
        cache.put(2, 2);//【2，1】
        cache.put(3, 3);//【3，2，1】
        cache.get(1);//【1，3，2】
        cache.put(4, 3);//【4，1，3】
        System.out.println(cache);
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
}