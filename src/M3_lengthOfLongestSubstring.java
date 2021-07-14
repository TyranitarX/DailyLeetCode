import java.util.*;

//
public class M3_lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = 0;
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    length++;
                } else
                    break;
            }
            if (length > max)
                max = length;
        }
        return max;
    }

    public static void main(String args[]) {
        String x = "aabcc";
        System.out.println(lengthOfLongestSubstring(x));
    }
}
