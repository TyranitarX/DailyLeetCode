package xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 作者：hit_zt
 * 链接：https://www.nowcoder.com/discuss/737778?type=all&order=time&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack
 * 来源：牛客网
 * <p>
 * 时间限制： 3000MS 内存限制： 589824KB
 * 【题目描述】 现在给你一个长度为n的01序列，你可以通过消除连续的1的序列来获取一定的分数。
 * 题目中将给你若干个长度和分数的对应关系，你需要正确求解出对应的答案。
 * 例如：现在给你一个长度为12的01序列111111011111。
 * 现在给你如下可以获取得分的消除方式：  消除三个连续的1，获取得分10  消除四个连续的1，获取得分15
 * 对于前面的六个连续的1，你的消除方案有两种：  消除一次连续的四个1，获得得分15，或者进行两次连续的三个1消除，获取得分20.  对于后面的五个连续的1，你有两种消除方案：  消除一次连续的四个1，获得得分15，或者消除一次连续的三个1，获得得分10    上述方案中可以获得的最大分数是20 + 15 = 35.    你的任务就是设法获得最大的消除分数。  请注意：不一定需要把所有的1的消除完毕，我们的目标是最大化分数而不是最大化消除个数。
 * 【输入描述】 第一行两个空格隔开的正整数n,m，分别表示01串的长度和消除规则的数量。
 * 接下来一行字符串长度为n，每个字符只能是0或者1中的一种。
 * 接下来m行，每行两个空格隔开的正整数k, x，为消除连续的k个1可以获得的分数x
 * 输出描述 输出可以获得的最大分数。
 * 样例输入 11 2 11111101111 3 10 4 15 样例输出 35  提示 n <= 100000, m <= 100  保证对于每个规则，k和x都在[1, 100]之间。
 *
 * 变种完全背包问题
 */
public class Course3 {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String[] arg = in.nextLine().split(" ");
        int len = Integer.parseInt(arg[0]);
        int k = Integer.parseInt(arg[1]);
        String nums = in.nextLine();
        int[] weight = new int[k];
        int[] value = new int[k];
        for (int i = 0; i < k; i++) {
            String[] aaa = in.nextLine().split(" ");
            weight[i] = Integer.parseInt(aaa[0]);
            value[i] = Integer.parseInt(aaa[1]);
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums.charAt(i) == '1')
                count++;
            if (count != 0 && (nums.charAt(i) == '0' || i == len - 1)) {
                int total = count;
                int[] dp = new int[total + 1];
                for (int j = 0; j < k; j++) {
                    for (int l = weight[j]; l <= count; l++) {
                        dp[l] = Math.max(dp[l], dp[l - weight[j]] + value[j]);
                    }
                }
                values.add(dp[total]);
                count = 0;
            }
        }
        int maxtotal = 0;
        for (int i = 0; i < values.size(); i++) {
            maxtotal += values.get(i);
        }
        System.out.println(maxtotal);
    }
}
