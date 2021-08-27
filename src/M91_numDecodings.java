/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/4/21 9:12
 **/
public class M91_numDecodings {

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new M91_numDecodings().numDecodings("26"));
    }
}
