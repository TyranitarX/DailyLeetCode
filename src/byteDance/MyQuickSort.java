package byteDance;

import java.util.Arrays;

public class MyQuickSort {
    public void quicksort(int[] nums, int s, int e) {
        if (s >= e)
            return;
        int cur = nums[s];
        int i = s + 1;
        int j = e;
        while (i < j) {
            while (nums[j] > cur && i < j) {
                j--;
            }
            while (nums[i] < cur && i < j) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, s, i);
        quicksort(nums, s, i - 1);
        quicksort(nums, i + 1, e);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] i = {2, 3, 5, 1, 0, -1};
        new MyQuickSort().quicksort(i, 0, i.length - 1);
        System.out.println(Arrays.toString(i));
    }
}
