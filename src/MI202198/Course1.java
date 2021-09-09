package MI202198;

import java.util.Scanner;

public class Course1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine().trim();
        String b = in.nextLine().trim();
        if(a.length()==0||b.length()==0){
            System.out.println(0);
            return;
        }
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
