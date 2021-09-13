import java.util.Arrays;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/10 11:03
 *
 *  二分系列
 *  「力扣」第 875 题：爱吃香蕉的珂珂（中等）
 *  LCP 12. 小张刷题计划 （中等）
 *  「力扣」第 1482 题：制作 m 束花所需的最少天数（中等）
 *  「力扣」第 1011 题：在 D 天内送达包裹的能力（中等）
 *  「力扣」第 1552 题：两球之间的磁力（中等）
 **/
public class M875_minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int mink = 1;
        int maxk = 0;
        for (int i = 0; i < piles.length; i++) {
            maxk = Math.max(piles[i], maxk);
        }
        int left = mink;
        int right = maxk;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = count(piles, mid);
            if (count > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int count(int[] piles, int speed) {
        int count = 0;
        for (int pile : piles) {
            count += (pile - 1) / speed + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        int h = 823855818;
        System.out.println(new M875_minEatingSpeed().minEatingSpeed(piles, h));
    }
}
