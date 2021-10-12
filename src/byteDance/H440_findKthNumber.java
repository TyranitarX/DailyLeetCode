package byteDance;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * <p>
 * 注意：1 ≤ k ≤ n ≤ 109。
 * <p>
 * 将题目抽象化为一个树
 */
public class H440_findKthNumber {

    public int findKthNumber(int n, int k) {
        //当前数字
        int cur = 1;
        //计数指针
        int p = 1;
        while (p < k) {
            //获取当前层的前缀个数
            long count = countPrefix(cur, n);
            //如果now+当前层个数>k则说明在子树中 进入当前子树
            if (p + count > k) {
                cur *= 10;
                p++;
                //否则获取下一个前缀
            } else {
                cur++;
                //位置移动到下一个前缀处
                p += count;
            }
        }
        return cur;
    }

    //获取当前数列指定前缀的子树个数
    public int countPrefix(int prefix, int n) {
        //当前前缀
        long cur = prefix;
        //下一个前缀
        long next = prefix + 1;
        //总共数量
        int count = 0;
        while (cur <= n) {
            //判断下一个前缀与当前最大值谁小 获得当前层的数量
            count += Math.min(next, n + 1) - cur;
            //进行下一层
            cur *= 10;
            next *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new H440_findKthNumber().findKthNumber(13, 3));
    }
}
