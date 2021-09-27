package byteDance;

import java.util.Stack;
import java.util.stream.Collectors;
import java.lang.String;

public class M394_decodeString {
    public String decodeString(String s) {
        Stack<Character> signstack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                signstack.push(c);
            } else {
                StringBuilder total = new StringBuilder();
                StringBuilder cur = new StringBuilder();
                while (signstack.peek() != '[') {
                    cur.append(signstack.pop());
                }
                cur.reverse();
                signstack.pop();
                StringBuilder num = new StringBuilder();
                while (!signstack.isEmpty() && Character.isDigit(signstack.peek())) {
                    num.append(signstack.pop());
                }
                int count = Integer.parseInt(num.reverse().toString());
                for (int i = 0; i < count; i++) {
                    total.append(cur);
                }
                for (int i = 0; i < total.length(); i++) {
                    signstack.push(total.charAt(i));
                }
            }
        }
        return signstack.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new M394_decodeString().decodeString(s));
    }
}
