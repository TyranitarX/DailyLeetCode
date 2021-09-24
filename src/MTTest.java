import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/23 9:31
 **/
public class MTTest {
    public int findmax(String[] texts) {
        Map<Character, Integer> resmap = new HashMap<>();
        for (int i = 0; i < texts.length; i++) {
            int num = Integer.parseInt(texts[i].substring(0, texts[i].length() - 1));
            char c = texts[i].charAt(texts[i].length() - 1);
            resmap.put(c, resmap.getOrDefault(c, 0) + num);
        }
        int max = 0;
        for (Map.Entry<Character, Integer> entry : resmap.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] texts = {"1a", "2b", "13c", "14a"};
        System.out.println(new MTTest().findmax(texts));
    }
}
