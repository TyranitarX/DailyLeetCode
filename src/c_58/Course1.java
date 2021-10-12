package c_58;

import java.util.Stack;

public class Course1 {
    public String decodeString(String str) {
        Stack<Integer> numstack = new Stack<>();
        Stack<Character> signstack = new Stack<>();
        int m = str.length();
        StringBuilder prenum = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int left = 0;
        for (int i = 0; i < m; i++) {
            char cur = str.charAt(i);
            if (Character.isDigit(cur))
                prenum.append(cur);
            else if (cur == '[') {
                left++;
                signstack.push(cur);
                if (!prenum.toString().equals("")) {
                    numstack.push(Integer.parseInt(prenum.toString()));
                    prenum = new StringBuilder();
                } else {
                    numstack.push(1);
                }
            } else if (cur == ']') {
                left--;
                StringBuilder cursb = new StringBuilder();
                while (signstack.peek() != '[') {
                    cursb.append(signstack.pop());
                }
                int nums = numstack.pop();
                signstack.pop();
                cursb.reverse();
                StringBuilder curtotal = new StringBuilder();
                for (int j = 0; j < nums; j++) {
                    curtotal.append(cursb);
                }
                if (left == 0) {
                    res.append(curtotal);
                } else {
                    for (int j = 0; j < curtotal.length(); j++) {
                        signstack.push(curtotal.charAt(j));
                    }
                }
            } else {
                if(left==0)
                    res.append(cur);
                else
                signstack.push(cur);
            }
        }
        StringBuilder lastsb =new StringBuilder();
        while (!signstack.isEmpty()){
            char cur = signstack.pop();
            lastsb.append(cur);
        }
        lastsb.reverse();
        return res.append(lastsb).toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        System.out.println(new Course1().decodeString(input));

    }
}
