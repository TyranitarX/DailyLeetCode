/**
 * 前缀和变种 差分数组
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 *
 *
 * 在区间内同时增加 可利用差分数组解决 当i~k 同时加n时 对差分数组 res[i]+n res[k+1]-n 若 k为最后一个元素时 则不必-n
 */
public class M1109_corpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] delres = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int s = bookings[i][0];
            int e = bookings[i][1];
            int mul = bookings[i][2];
            delres[s - 1] += mul;
            if (e < n) {
                delres[e] -= mul;
            }
        }
        for (int i = 1; i < n; i++) {
            delres[i] += delres[i - 1];
        }
        return delres;
    }
}
