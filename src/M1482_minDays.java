/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/10 14:41
 * 二分系列
 * 「力扣」第 875 题：爱吃香蕉的珂珂（中等）
 * LCP 12. 小张刷题计划 （中等）
 * 「力扣」第 1482 题：制作 m 束花所需的最少天数（中等）
 * 「力扣」第 1011 题：在 D 天内送达包裹的能力（中等）
 * 「力扣」第 1552 题：两球之间的磁力（中等）
 **/
public class M1482_minDays {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = 0;
        int max = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(bloomDay[i], max);
        }
        int left = min;
        int right = max;
        int flowers = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            flowers = getnums(bloomDay, mid, k);
            if (left == right)
                break;
            if (flowers < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return flowers >= m ? left : -1;
    }

    public int getnums(int[] bloomDay, int maxday, int k) {
        int count = 0;
        int flowers = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= maxday)
                count++;
            if (count != 0 && (bloomDay[i] > maxday || i == bloomDay.length - 1)) {
                flowers += (count / k);
                count = 0;
            }
        }
        return flowers;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1000000000, 1000000000};
        int k = 1;
        int m = 1;
        System.out.println(new M1482_minDays().minDays(bloomDay, m, k));
    }
}
