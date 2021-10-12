import java.util.Scanner;

public class WeiDianCourse1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int i = 0;
        int j = 0;
        boolean is = false;
        while (i < a.length()) {
            if (a.charAt(i) == b.charAt(j))
                j++;
            i++;
            if (j >= b.length()) {
                is = true;
                break;
            }
        }
        System.out.println(is ? "yes" : "no");
    }
}
