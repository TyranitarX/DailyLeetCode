package bilibili202101;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidExp {
    public boolean IsValidExp(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if (!stack.isEmpty() && s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else
                return false;
        }
        return true;
    }
}
