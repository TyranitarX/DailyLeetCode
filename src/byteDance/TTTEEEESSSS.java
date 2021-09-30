package byteDance;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/29 20:16
 **/
public class TTTEEEESSSS {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int max = 0;
        Set<Character> cset = new HashSet<>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (cset.contains(right)) {
                cset.remove(left);
                i++;
            } else {
                max = Math.max(j - i + 1, max);
                cset.add(right);
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new TTTEEEESSSS().lengthOfLongestSubstring(s));

    }
}
