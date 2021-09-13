/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/6 10:00
 **/
public class E704_binarySearch {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(new E704_binarySearch().search(nums, 0));
    }
}
