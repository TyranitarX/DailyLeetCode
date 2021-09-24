
public class Testtt {
    public String LCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        String[][] mydp = new String[m + 1][n + 1];
        for (int i = 0; i < mydp.length; i++) {
            for (int j = 0; j < mydp[0].length; j++) {
                mydp[i][j] = "";
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a1 = s1.charAt(i - 1);
                char a2 = s2.charAt(j - 1);
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    mydp[i][j] = mydp[i - 1][j];
                } else {
                    mydp[i][j] = mydp[i][j - 1];
                }
                if (a1 == a2) {
                    if (dp[i][j] > dp[i - 1][j - 1] + 1) {
                        mydp[i][j] = mydp[i][j];
                    } else {
                        mydp[i][j] = mydp[i - 1][j - 1] + a1;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return !mydp[m][n].equals("") ? mydp[m][n] : "-1";
    }

    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        System.out.println(new Testtt().LCS(s1, s2));
    }
}
