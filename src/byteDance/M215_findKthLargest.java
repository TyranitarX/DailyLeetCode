package byteDance;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/27 10:50
 **/
public class M215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int[] myheap = new int[k];
        for (int i = 0; i < k; i++) {
            myheap[i] = nums[i];
        }
        for (int i = myheap.length / 2 - 1; i >= 0; i--) {
            adjustHeap(myheap, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > myheap[0]) {
                myheap[0] = nums[i];
                adjustHeap(myheap, 0);
            }
        }
        return myheap[0];
    }

    public void adjustHeap(int[] heap, int i) {
        if (i > heap.length / 2 - 1) {
            return;
        }
        int now = heap[i];
        int left = heap[i * 2 + 1];
        int right = i * 2 + 2 >= heap.length ? Integer.MAX_VALUE : heap[i * 2 + 2];
        int min = Math.min(now, Math.min(left, right));
        if (left == min) {
            swap(heap, i, i * 2 + 1);
            adjustHeap(heap, i * 2 + 1);
        } else if (right == min) {
            swap(heap, i, i * 2 + 2);
            adjustHeap(heap, i * 2 + 2);
        }
    }

    public void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new M215_findKthLargest().findKthLargest(nums, 2));
    }
}
