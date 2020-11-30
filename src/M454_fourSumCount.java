import java.util.HashMap;
import java.util.Map;

public class M454_fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int total = 0;
        Map<Integer, Integer> ABmap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (ABmap.containsKey(A[i] + B[j]))
                    ABmap.replace(A[i] + B[j], ABmap.get(A[i] + B[j]) + 1);
                else
                    ABmap.put(A[i] + B[j], 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (ABmap.containsKey(-(C[i] + D[j])))
                    total += ABmap.get(-(C[i] + D[j]));
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};
        System.out.println(new M454_fourSumCount().fourSumCount(A, B, C, D));
    }
}
