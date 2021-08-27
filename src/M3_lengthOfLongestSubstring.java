import java.util.*;

//
public class M3_lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> sitemap = new HashMap<>();

        }
        return max;
    }

    public static void main(String args[]) {
        String x = "aabcc";
        System.out.println(lengthOfLongestSubstring(x));
    }
}
