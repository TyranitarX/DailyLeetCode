package bilibili202002;

import java.util.Scanner;

public class Course2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        for (int i = 1; i < Math.sqrt(2 * n); i++) {
            if((n-i*(i+1)/2)%i==0)ans++;
        }
        System.out.println(ans);
    }
}
