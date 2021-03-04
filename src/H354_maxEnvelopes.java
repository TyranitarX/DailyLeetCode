import java.util.Arrays;
import java.util.Comparator;

public class H354_maxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
            return 0;

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.print(envelopes[i][0] + " ");
            System.out.println(envelopes[i][1]);
        }
        int len[] = new int[n];
        int total = 1;
        Arrays.fill(len, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            total = Math.max(total, len[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] envlops = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println(new H354_maxEnvelopes().maxEnvelopes(envlops));
    }
}
