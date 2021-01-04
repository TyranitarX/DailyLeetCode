public class E509_fib {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int[] list = new int[n + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        return list[n];
    }
}
