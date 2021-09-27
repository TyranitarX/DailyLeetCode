package byteDance;

import java.util.HashSet;
import java.util.Set;

public class M128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = 1;
                int curcount = 1;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    curcount += 1;
                }
                count = Math.max(cur, curcount);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new M128_longestConsecutive().longestConsecutive(nums));
    }
}
