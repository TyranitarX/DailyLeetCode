import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/24 10:23
 **/
public class HeapSort {
    public int[] heapsort(int[] heap, int len) {
        if (len == 0)
            return new int[0];
        int[] myheap = new int[len];
        for (int i = 0; i < myheap.length; i++) {
            myheap[i] = heap[i];
        }
        for (int i = myheap.length / 2 - 1; i >= 0; i--) {
            adjustheap(myheap, i);
        }
        for (int i = myheap.length; i < heap.length; i++) {
            if (heap[i] < myheap[0]) {
                myheap[0] = heap[i];
                adjustheap(myheap, 0);
            }
        }
        return myheap;
    }

    public void adjustheap(int[] heap, int i) {
        if (i > (heap.length / 2 - 1))
            return;
        int left = heap[i * 2 + 1];
        int right = i * 2 + 2 >= heap.length ? 0 : heap[i * 2 + 2];
        int now = heap[i];
        int max = Math.max(left, Math.max(right, now));
        if (max == left) {
            swap(heap, i, i * 2 + 1);
            adjustheap(heap, i * 2 + 1);
        } else if (max == right) {
            swap(heap, i, i * 2 + 2);
            adjustheap(heap, i * 2 + 2);
        }
    }

    public void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        int[] heap = {4, 5, 1, 6, 2, 7, 3, 8};
        heap = new HeapSort().heapsort(heap, 0);
        System.out.println(Arrays.toString(heap));
    }
}
