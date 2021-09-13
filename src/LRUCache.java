import java.util.HashMap;
import java.util.LinkedList;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/9 16:13
 **/
public class LRUCache {
    int capacity;
    private LinkedList<Integer> list;
    private HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            return map.get(key);
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (list.size() == capacity) {
                int last = list.removeLast();
                map.remove(last);
            }
            map.put(key, value);
            list.addFirst(key);
        } else {
            list.removeFirstOccurrence(key);
            list.addFirst(key);
            map.put(key, value);
        }
    }
}
