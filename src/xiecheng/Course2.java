package xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 作者：hit_zt
 * 链接：https://www.nowcoder.com/discuss/737778?type=all&order=time&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack
 * 来源：牛客网
 *
 * 时间限制： 3000MS 内存限制： 589824KB
 * 【题目描述】 有一个长度为n的序列A，序列中的第i个数为A[i] (1<=i<=n)，现在你可以将序列分成至多连续的k段。
 * 对于每一段，我们定义这一段的不平衡度为段内的最大值减去段内的最小值。显然，对于长度为1的段，其不平衡度为0。
 * 对于一种合法的分段方式（即每一段连续且不超过k段），我们定义这种分段方式的不平衡度为每一段的不平衡度的最大值。
 * 现在你需要找到不平衡度最小的分段方式，输出这种分段方式的不平衡度即可。
 * 【输入描述】 第一行两个空格隔开的整数n，k，分别表示序列的长度和最多可分成的段数。
 * 第二行是n个用空格隔开的整数，第i个数表示A[i]的值。  【输出描述】 一行一个整数，表示最小的不平衡度。   样例输入 5 3 3 5 5 2 5 样例输出 2  提示 数据范围：1<=n<=100000, 1<=A[i]<=100000  输入样例1  5 3  3 5 5 2 5  输出样例1  2  解释  最终分为[3 5 5] [2] [5]，该种分段方式的不平衡度为2。
 */
public class Course2 {
    static int minmax = 0x3f3f3f;
    static int nowmax = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arg = in.nextLine().split(" ");
        String[] nums = in.nextLine().split(" ");
        int len = Integer.parseInt(arg[0]);
        int k = Integer.parseInt(arg[1]);
        int[] num = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
        dfs(num, 0, 1, 1, k);
        System.out.println(minmax);
    }

    public static void dfs(int[] num, int i, int j, int k, int real) {
        if (k == real) {
            int[] nownum = Arrays.copyOfRange(num, i, num.length);
            nowmax = Math.max(nowmax, Arrays.stream(nownum).max().getAsInt() - Arrays.stream(nownum).min().getAsInt());
            minmax = nowmax;
            return;
        }
        int premax = nowmax;
        int[] nownum = Arrays.copyOfRange(num, i, j);
        nowmax = Math.max(nowmax, Arrays.stream(nownum).max().getAsInt() - Arrays.stream(nownum).min().getAsInt());
        dfs(num, j, j + 1, k + 1, real);
        nowmax = premax;
        dfs(num, i, j + 1, k, real);
    }
}
