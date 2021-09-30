package byteDance;

import java.util.HashMap;
import java.util.Map;

public class twoXOR {
    public int[] twoXOR(int[] nums, int target) {
        Map<Integer, Integer> xors = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            xors.put(nums[i] ^ target, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (xors.containsKey(nums[i] ^ target)) {
                return new int[]{i, xors.get(nums[i] ^ target)};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {

    }
}
