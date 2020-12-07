public class M861_matrixScore {
    public int matrixScore(int[][] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }
        int index = 1;
        for (int i = A[0].length - 1; i >= 0; i--) {
            int nowtotal1 = 0;
            int nowtotal2 = 0;
            for (int j = 0; j < A.length; j++) {
                nowtotal1 += index * A[j][i];
                nowtotal2 += index * (A[j][i] == 0 ? 1 : 0);
            }
            index *= 2;
            total += Math.max(nowtotal1, nowtotal2);
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] x = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(new M861_matrixScore().matrixScore(x));
    }
}
