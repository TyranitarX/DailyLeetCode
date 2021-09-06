package QQMusic;

public class MaxNumber {
    public int getMax(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length() - k; i++) {
            int now = Integer.parseInt(s.substring(i, i + k));
            res = Math.max(now, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNumber().getMax("321", 2));
    }
}
