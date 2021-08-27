public class M926_minFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] ones = new int[n + 1];
        ones[0] = 0;
        for (int i = 1; i <= n; i++) {
            ones[i] = ones[i - 1] + (s.charAt(i - 1) - '0');
        }
        int ans = 0x3f3f3f;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, ones[i] + (n - i) - (ones[n] - ones[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new M926_minFlipsMonoIncr().minFlipsMonoIncr("00110"));
    }
}
