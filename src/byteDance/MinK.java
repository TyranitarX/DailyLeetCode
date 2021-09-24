package byteDance;

import java.util.Arrays;

public class MinK {
    public int[] heapminK(int[] input, int k) {
        int[] myheap = new int[k];
        for (int i = 0; i < k; i++) {
            myheap[i] = input[i];
        }
        for (int i = (k / 2 - 1); i >= 0; i--) {
            adjustHeap(myheap, i);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < myheap[0]) {
                myheap[0] = input[i];
                adjustHeap(myheap, 0);
            }
        }
        return myheap;
    }

    public void adjustHeap(int[] heap, int i) {
        if (i > heap.length / 2 - 1)
            return;
        int now = heap[i];
        int left = heap[i * 2 + 1];
        int right = i * 2 + 2 >= heap.length ? 0 : heap[i * 2 + 2];
        int max = Math.max(now, Math.max(left, right));
        if (left == max) {
            swap(heap, i, i * 2 + 1);
            adjustHeap(heap, i * 2 + 1);
        } else if (right == max) {
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
        int[] nums = {4, 5, 8, 6, 9, 1, 1, 1};
        System.out.println(Arrays.toString(new MinK().heapminK(nums, 3)));
    }
}
