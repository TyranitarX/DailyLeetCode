package byteDance;

import java.util.HashSet;
import java.util.Set;

public class M128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            numset.add(num);
        }
        int max = 0;
        for (int num : numset) {
            if (!numset.contains(num - 1)) {
                int currnum = num;
                int curmax = 1;
                while (numset.contains(currnum + 1)) {
                    currnum += 1;
                    curmax += 1;
                }
                max = Math.max(curmax, max);
            }
        }
        return max;
    }
}
