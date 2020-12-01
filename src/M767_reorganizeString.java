
public class M767_reorganizeString {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        int max = 0;
        for (int i = 0; i < S.length(); i++)
            counts[S.charAt(i) - 'a']++;
        for (int i = 0; i < S.length(); i++) {
            int count = counts[S.charAt(i) - 'a'];
            if (count > max) {
                max = count;
            }
        }
        if (max > (S.length() + 1) / 2)
            return "";
        char[] reorganizeArray = new char[S.length()];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = S.length() / 2;
        for (int i = 0; i < 26; i++) {
            char now = (char) (i + 'a');
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < S.length()) {
                reorganizeArray[oddIndex] = now;
                oddIndex += 2;
                counts[i]--;
            }
            while (counts[i] > 0 && evenIndex < S.length()) {
                reorganizeArray[evenIndex] = now;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return String.valueOf(reorganizeArray);
    }

    public static void main(String[] args) {
        System.out.println(new M767_reorganizeString().reorganizeString("vvvlo"));
    }
}
