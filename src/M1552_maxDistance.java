import java.util.Arrays;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/10 15:26
 * <p>
 * <p>
 * 重点？？
 **/
public class M1552_maxDistance {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int minmag = 1;
        int maxmag = position[position.length - 1] - position[0];
        int left = minmag;
        int right = maxmag;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int balls = getBalls(position, mid);
            if (balls >= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int getBalls(int[] position, int m) {
        int pre = position[0], balls = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= m) {
                pre = position[i];
                balls += 1;
            }
        }
        return balls;
    }

    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(new M1552_maxDistance().maxDistance(position, m));
    }
}
