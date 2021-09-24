package Tuya;


public class Course1 {

    public String longestPalindrome(String str) {
        int maxlen = 0;
        String res = "";
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                boolean ispal = isPalindrome(str, i, j);
                if (ispal && j - i + 1 > maxlen) {
                    res = str.substring(i, j + 1);
                    maxlen = j - i + 1;
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(new Course1().longestPalindrome(str));
    }
}
