import java.util.HashMap;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/5/7 17:25
 **/

/**
 * 斗鱼第二题
 */
public class M1143_longestCommonSubsequence {
    public String longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        StringBuilder[][] dps = new StringBuilder[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dps[i][0] = new StringBuilder();
        }
        for (int j = 0; j <= len2; j++) {
            dps[0][j] = new StringBuilder();
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char t1 = text1.charAt(i - 1);
                char t2 = text2.charAt(j - 1);
                if (t1 == t2) {
                    dps[i][j] = new StringBuilder(dps[i - 1][j - 1]).append(t1);
                } else {
                    dps[i][j] = dps[i - 1][j].length() > dps[i][j - 1].length() ? dps[i - 1][j] : dps[i][j - 1];
                }
            }
        }
        return dps[len1][len2].toString();
    }

    public static void main(String[] args) {
        String text1 = "1A2C3D4B56";
        String text2 = "B1D23A456A";
        System.out.println(new M1143_longestCommonSubsequence().longestCommonSubsequence(text1, text2));
    }
}
