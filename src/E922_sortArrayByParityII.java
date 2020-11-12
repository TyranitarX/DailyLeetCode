public class E922_sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int ji[] = new int[A.length / 2];
        int ou[] = new int[A.length / 2];
        int j = 0;
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ou[j] = A[i];
                j++;
            } else {
                ji[k] = A[i];
                k++;
            }
        }
        j = 0;
        k = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = ou[j];
                j++;
            } else {
                A[i] = ji[k];
                k++;
            }
        }
        return A;
    }
}
