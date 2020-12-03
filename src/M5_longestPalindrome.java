public class M5_longestPalindrome {
    public String longestPalindrome(String s) {
        String maxstr = String.valueOf(s.charAt(0));
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) == s.charAt(i + 1)) {
                int left = i;
                int right = i;
                right++;
                while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
                    left--;
                    right++;
                }
                if (right - left + 1 > max) {
                    for (int j = left; j <= right; j++) {
                        sb.append(s.charAt(j));
                    }
                    maxstr = sb.toString();
                    max = sb.length();
                }
            }

            sb = new StringBuilder();
            int left = i;
            int right = i;
            while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left + 1 > max) {
                for (int j = left; j <= right; j++) {
                    sb.append(s.charAt(j));
                }
                maxstr = sb.toString();
                max = sb.length();
            }
        }
        return maxstr;
    }

    public static void main(String[] args) {
        System.out.println(new M5_longestPalindrome().longestPalindrome("babad"));
    }
}
