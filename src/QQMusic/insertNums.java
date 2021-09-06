package QQMusic;

/**
 * 给定一个长度为n下标从0开始的正整形数组a，有一些数字被删除了 删除的数字位为0
 * 向0处填入数字保证整个数列不减且 1<=填入数字<=max 问有几种填法 可能会很大 取10^9+7
 */
public class insertNums {
    public int countinsertnums(int[] nums, int max) {
        int n = 10 ^ 9 + 7;
        int min = 1;
        int nowmax = max;
        int s = 0;
        int e = 0;
        int total = 0;
        while (e < nums.length) {
            while (e < nums.length && nums[s] != 0) {
                min = nums[s];
                s++;
                e++;
            }
            while (e < nums.length && nums[e] == 0) {
                e++;
            }
            nowmax = e < nums.length ? nums[e] : max;
            int count = e - s;
            s = e;
            total++;
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 0, 4, 0, 0, 0, 7};
        System.out.println(new insertNums().countinsertnums(nums, 10));
    }
}
