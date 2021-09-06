import java.util.*;

/**
 * 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），请写一个函数pickIndex，它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
 *
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 *
 *
 *
 * 前缀和
 */
public class M528_pickIndex {
    int total;
    int[] in;

    public M528_pickIndex(int[] w) {
        total = Arrays.stream(w).sum();
        in = new int[w.length];
        in[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            in[i] = in[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
//        for (int i = 0; i < in.length; i++) {
//            if (in[i] >= x)
//                return i;
//        }
        return binSearch(x);
    }

    public int binSearch(int x) {
        int i = 0;
        int j = in.length - 1;
        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (in[mid] < x) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
