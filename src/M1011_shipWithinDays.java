/**
 * 二分系列
 * 「力扣」第 875 题：爱吃香蕉的珂珂（中等）
 * LCP 12. 小张刷题计划 （中等）
 * 「力扣」第 1482 题：制作 m 束花所需的最少天数（中等）
 * 「力扣」第 1011 题：在 D 天内送达包裹的能力（中等）
 * 「力扣」第 1552 题：两球之间的磁力（中等）
 */
public class M1011_shipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.max(min, weights[i]);
            max += weights[i];
        }
        int left = min;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int nowdays = getDays(weights, mid);
            if (nowdays > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getDays(int[] weights, int maxweight) {
        int days = 1;
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            if (count + weights[i] > maxweight) {
                days++;
                count = 0;
            }
            count += weights[i];
        }
        return days;
    }
}
