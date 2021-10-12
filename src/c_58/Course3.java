package c_58;

public class Course3 {
    public int StringSplit(String str) {
        int m = str.length();
        int[] counta = new int[m - 1];
        counta[0] = str.charAt(0) == 'a' ? 1 : 0;
        int[] countb = new int[m - 1];
        countb[m - 2] = str.charAt(m - 1) == 'b' ? 1 : 0;
        int max = 0;
        for (int i = 1; i < m - 1; i++) {
            char cur = str.charAt(i);
            if (cur == 'a')
                counta[i] = counta[i - 1] + 1;
            else
                counta[i] = counta[i - 1];
        }
        for (int i = m - 3; i >= 0; i--) {
            char cur = str.charAt(i+1);
            if (cur == 'b')
                countb[i] = countb[i + 1] + 1;
            else
                countb[i] = countb[i + 1];
        }
        for (int i = 0; i < m - 1; i++) {
            max = Math.max(counta[i] + countb[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abbbab";
        System.out.println(new Course3().StringSplit(s));
    }
}
