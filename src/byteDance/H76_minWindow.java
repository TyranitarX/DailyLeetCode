package byteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/24 14:48
 **/
public class H76_minWindow {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> targetmap = new HashMap<>();
        Map<Character, Integer> realmap = new HashMap<>();
        String min = "";
        int len = Integer.MAX_VALUE;
        for (int p = 0; p < t.length(); p++) {
            targetmap.put(t.charAt(p), 0);
            realmap.put(t.charAt(p), realmap.getOrDefault(t.charAt(p), 0) + 1);
        }
        while (j < s.length()) {
            while (!isgetAll(targetmap, realmap) && j < s.length()) {
                if (targetmap.containsKey(s.charAt(j))) {
                    targetmap.put(s.charAt(j), targetmap.get(s.charAt(j)) + 1);
                }
                j++;
            }
            while (isgetAll(targetmap, realmap)) {
                String res = s.substring(i, j);
                if (res.length() < len) {
                    min = res;
                    len = res.length();
                }
                if (targetmap.containsKey(s.charAt(i))) {
                    targetmap.put(s.charAt(i), targetmap.get(s.charAt(i)) - 1);
                }
                i++;
            }
        }
        return min;
    }

    public boolean isgetAll(Map<Character, Integer> targetMap, Map<Character, Integer> realMap) {
        boolean res = true;
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (entry.getValue() < realMap.get(entry.getKey())) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new H76_minWindow().minWindow(s, t));
    }
}
