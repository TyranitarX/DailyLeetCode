package bilibili202101;

public class GetiCoinCount {
    public int GetCoinCount(int N) {
        N = 1024 - N;
        int count = 0;
        count += N / 64;
        int res1 = N % 64;
        count += res1 / 16;
        int res2 = res1 % 16;
        count += res2 / 4;
        count += res2 % 4;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new GetiCoinCount().GetCoinCount(200));
    }
}
