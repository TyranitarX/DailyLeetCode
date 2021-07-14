import java.util.HashMap;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/5/7 17:25
 **/


public class M1143_longestCommonSubsequence {
    public String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        String dps[][] = new String[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dps[i][0] = "";
        }
        for (int i = 0; i <= n; i++) {
            dps[0][i] = "";
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dps[i][j] = dps[i - 1][j - 1] + text1.charAt(i - 1);
                } else {
                    dps[i][j] = dps[i - 1][j].length() > dps[i][j - 1].length() ? dps[i - 1][j] : dps[i][j - 1];
                }
            }
        }
        return dps[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new M1143_longestCommonSubsequence().longestCommonSubsequence(text1, text2));
    }
}
