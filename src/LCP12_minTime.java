/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/10 11:28
 *
 * 二分系列
 * 「力扣」第 875 题：爱吃香蕉的珂珂（中等）
 * LCP 12. 小张刷题计划 （中等）
 * 「力扣」第 1482 题：制作 m 束花所需的最少天数（中等）
 * 「力扣」第 1011 题：在 D 天内送达包裹的能力（中等）
 * 「力扣」第 1552 题：两球之间的磁力（中等）
 **/
public class LCP12_minTime {
    public int minTime(int[] time, int m) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < time.length; i++) {
            max += time[i];
        }
        int left = min;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = getdays(time, mid);
            System.out.println(days);
            if (days > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int getdays(int[] time, int maxT) {
        int days = 1;
        int maxnow = time[0];
        int nowtotal = 0;
        for (int i = 0; i < time.length; i++) {
            maxnow = Math.max(maxnow, time[i]);
            nowtotal += time[i];
            if (nowtotal - maxnow > maxT) {
                days++;
                maxnow = time[i];
                nowtotal = time[i];
            }
        }
        return days;
    }

    public static void main(String[] args) {
        int[] time = {1, 2, 3};
        int m = 3;
        System.out.println(new LCP12_minTime().minTime(time, m));
    }
}
