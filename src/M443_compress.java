import java.util.Arrays;

public class M443_compress {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 1;
        int count = 1;
        while (j < n) {
            if (chars[i] == chars[j]) {
                count++;
                j++;
            }
            if (j == n || chars[i] != chars[j]) {
                if (count == 1) {
                    i = j;
                    j = j + 1;
                    continue;
                }
                String countstr = String.valueOf(count);
                int coutlen = countstr.length();
                merge(chars, i + coutlen + 1, j, n);
                for (int k = 0; k < coutlen; k++) {
                    chars[i + k + 1] = countstr.charAt(k);
                }
                i = i + coutlen + 1;
                j = i + 1;
                n = n - count + coutlen + 1;
                count = 1;
            }
        }
        System.out.println(Arrays.toString(chars));
        return n;
    }

    public void merge(char[] chars, int i, int j, int n) {
        while (j < n) {
            chars[i] = chars[j];
            i++;
            j++;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c',};
        System.out.println(new M443_compress().compress(chars));

    }
}
