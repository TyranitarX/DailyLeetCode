public class E198_rob {
    public int rob(int[] nums) {
        int[] result = doRob(nums, 0);
        return Math.max(result[0], result[1]);
    }
    public int[] doRob(int[] nums, int key) {
        if (nums.length == 0)
            return new int[2];
        if (key == nums.length)
            return new int[2];
        int val = nums[key];
        int[] result = new int[2];
        int[] next = doRob(nums, key + 1);
        result[0] = Math.max(next[1], next[0]);
        result[1] = val + next[0];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(new E198_rob().rob(nums));
    }

}
