public class M213_rob {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length > 1) {
            int[] result1 = doRob(nums, 0, nums.length - 2);
            int[] result2 = doRob(nums, 1, nums.length - 1);
            return Math.max(Math.max(result1[0], result1[1]), Math.max(result2[0], result2[1]));
        } else
            return nums[0];
    }

    public int[] doRob(int[] nums, int key, int end) {
        if (nums.length == 0)
            return new int[2];
        if (key > end)
            return new int[2];
        int val = nums[key];
        int[] result = new int[2];
        int[] next = doRob(nums, key + 1, end);
        result[0] = Math.max(next[1], next[0]);
        result[1] = val + next[0];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(new M213_rob().rob(nums));
    }
}
