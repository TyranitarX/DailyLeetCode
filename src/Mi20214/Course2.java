package Mi20214;

import java.util.*;
/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/7 16:49
 **/
public class Course2 {
    public String unique_string(String s) {
        Set<Character> myset = new HashSet<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char now = sb.charAt(i);
            if (myset.contains(now))
                sb.replace(i,i+1," ");
            else
                myset.add(now);
        }
        return sb.toString().replaceAll("\\s","");
    }

    public static void main(String[] args) {        String s = "hellowelcometoxiaomi";
        System.out.println(new Course2().unique_string(s));
    }
}
