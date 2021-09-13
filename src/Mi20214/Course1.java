package Mi20214;

import java.util.*;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/7 16:00
 **/
public class Course1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now != '(' && now != ')') {
                System.out.println("NO");
                break;
            }
            if (stack.isEmpty() || now == '(') {
                stack.push(now);
            } else {
                if (stack.peek() == '(')
                    stack.pop();
            }
        }
        System.out.println(stack.isEmpty() ? "YES" : "NO");
    }
}
