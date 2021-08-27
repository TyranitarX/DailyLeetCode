package bilibili20201;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class course1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
        System.out.println(Arrays.stream(s).collect(Collectors.joining(" ")));
    }

    static void swap(String[] s, int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
