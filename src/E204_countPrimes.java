import java.util.Arrays;

public class E204_countPrimes {
    public int countPrimes(int n) {
        int count = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new E204_countPrimes().countPrimes(49979));
    }
}
