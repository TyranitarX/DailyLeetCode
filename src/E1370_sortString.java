public class E1370_sortString {
    public String sortString(String s) {
        StringBuffer S = new StringBuffer();
        int[] x = new int[26];
        for (int i = 0; i < s.length(); i++) {
            x[s.charAt(i) - 97] += 1;
        }
        while (isempty(x)) {
            for (int i = 0; i < x.length; i++) {
                if (x[i] != 0) {
                    S.append((char) (i + 97));
                    x[i] -= 1;
                }
            }
            for (int i = x.length - 1; i >= 0; i--) {
                if (x[i] != 0) {
                    S.append((char) (i + 97));
                    x[i] -= 1;
                }
            }
        }
        return S.toString();
    }

    public boolean isempty(int[] x) {
        for (int s : x) {
            if (s != 0)
                return true;
        }
        return false;
    }

}
