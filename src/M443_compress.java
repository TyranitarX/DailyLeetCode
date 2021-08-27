public class M443_compress {
    public int compress(char[] chars) {
        int newlen = chars.length;
        int s = 0;
        int e = 0;
        while (e < newlen) {
            if (chars[s] == chars[e]) {
                e++;
            }
            if (e == newlen || chars[s] != chars[e]) {
                String value = String.valueOf(e - s);
                s++;
                if (!value.equals("1")) {
                    newlen -= ((e - s) - value.length());
                    for (int i = 0; i < value.length(); i++) {
                        chars[s] = value.charAt(i);
                        s++;
                    }
                    move(chars, s, e);
                }
                e = s;
            }
        }
        return newlen;
    }

    public void move(char[] chars, int s, int e) {
        while (e < chars.length) {
            chars[s] = chars[e];
            s++;
            e++;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c',};
        new M443_compress().compress(chars);
    }
}
