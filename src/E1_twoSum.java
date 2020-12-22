import java.util.HashMap;
import java.util.Map;

public class E1_twoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        //字典法
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
           int rest = target-nums[i];
        }
        return result;
    }

    public static void main(String args[]) {
        int[] in = {2, 7, 11, 15};
        System.out.println(E1_twoSum.twoSum(in, 9)[1]);
    }
}

