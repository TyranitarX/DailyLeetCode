import com.sun.javafx.logging.JFRInputEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class E455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int total = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j < s.length) {
                total++;
                j++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        System.out.println(new E455_findContentChildren().findContentChildren(g, s));
    }
}
