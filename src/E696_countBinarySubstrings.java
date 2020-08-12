import java.util.ArrayList;

public class E696_countBinarySubstrings {
    public int countBinarySubstringsvegatable(String s) {
        ArrayList<StringBuffer> list = new ArrayList<>();
        int k = 0;
        list.add(new StringBuffer(s.charAt(0) + ""));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
                list.set(k, list.get(k).append("0"));
            } else if (s.charAt(i) == '1' && s.charAt(i - 1) == '1') {
                list.set(k, list.get(k).append("1"));
            } else {
                list.add(new StringBuffer(s.charAt(i) + ""));
                k++;
            }
        }
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            int num = Math.min(list.get(i).length(), list.get(i - 1).length());
            count = count + num;
        }
        return count;
    }

    public int countBinarySubstringslessvegatable(String s) {
        int[] lenths = new int[s.length()];
        int k = 0;
        lenths[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                lenths[k]++;
            } else {
                k++;
                lenths[k]++;
            }
        }
        int count = 0;
        for (int i = 1; i < lenths.length; i++) {
            if (lenths[i] != 0) count = count + Math.min(lenths[i], lenths[i - 1]);
        }
        return count;
    }
}
