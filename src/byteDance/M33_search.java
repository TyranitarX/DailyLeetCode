package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/30 10:32
 **/
public class M33_search {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[i] < nums[mid]) {
                if (nums[i] <= target && target <= nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new M33_search().search(nums, target));
    }
}
