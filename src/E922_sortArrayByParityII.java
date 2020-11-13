public class E922_sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] % 2 != 0) {
                while (A[j] % 2 != 0)
                    j += 2;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        int[] B = new E922_sortArrayByParityII().sortArrayByParityII(A);
        System.out.println(B[0]);
        System.out.println(B[1]);
        System.out.println(B[2]);
        System.out.println(B[3]);
    }
}
