import java.math.BigInteger;
import java.util.Scanner;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/8 11:13
 **/
public class Jump3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("1");
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 3]);
        }
        System.out.println(dp[n].toString());
    }
}
