package bilibili202102;

public class GetFragment {
    public int GetFragment(String str) {
        if (str.length() == 0)
            return 0;
        int count = 0;
        int n = str.length();
        StringBuilder pre = new StringBuilder(str.charAt(0) + "");
        count++;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == pre.charAt(0)) {
                pre.append(str.charAt(0));
            } else {
                count++;
                pre = new StringBuilder(str.charAt(i) + "");
            }
        }
        return str.length() / count;
    }

    public static void main(String[] args) {
        String str = "aaabbb";
        System.out.println(new GetFragment().GetFragment(str));
    }
}
