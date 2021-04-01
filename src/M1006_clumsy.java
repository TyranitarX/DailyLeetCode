import java.util.ArrayList;
import java.util.List;


public class M1006_clumsy {
    public int clumsy(int N) {
        char[] sign = {'*', '/', '+', '-'};
        List<String> str = new ArrayList<>();
        int j = 0;
        for (int i = N; i >= 1; i--) {
            if (i != 1) {
                str.add(i + "");
                str.add(sign[j] + "");
                j = (j + 1) % 4;
            } else
                str.add(i + "");
        }
        List<String> strnoplus = new ArrayList<>();
        strnoplus.add(str.get(0));
        int i = 1;
        while (i < str.size()) {
            int result = Integer.parseInt(strnoplus.get(strnoplus.size() - 1));
            String signnow = str.get(i);
            int next = Integer.parseInt(str.get(i + 1));
            if (signnow.equals("/")) {
                result = result / next;
                strnoplus.remove(strnoplus.get(strnoplus.size() - 1));
                strnoplus.add(result + "");
            } else if (signnow.equals("*")) {
                result = result * next;
                strnoplus.remove(strnoplus.get(strnoplus.size() - 1));
                strnoplus.add(result + "");
            } else {
                strnoplus.add(signnow);
                strnoplus.add(next + "");
            }
            i += 2;
        }
        int total = Integer.parseInt(strnoplus.get(0));
        i = 1;
        while (i < strnoplus.size()) {
            int next = Integer.parseInt(strnoplus.get(i + 1));
            String signnow = strnoplus.get(i);
            if (signnow.equals("+"))
                total += next;
            else
                total -= next;
            i += 2;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new M1006_clumsy().clumsy(8836));
    }
}
