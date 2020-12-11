import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class M649_predictPartyVictory {
    public String predictPartyVictory(String senate) {
        HashMap<String, Integer> nums = new HashMap<>();
        nums.put("D", 0);
        nums.put("R", 0);
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R')
                nums.replace("R", nums.get("R") + 1);
            else
                nums.replace("D", nums.get("D") + 1);
        }
        while (nums.get("D") != 0 && nums.get("R") != 0) {
            char pre = senate.charAt(0);
            StringBuffer newsenate = new StringBuffer();
            newsenate.append(pre);
            int nowpower = 1;
            for (int i = 0; i < newsenate.length(); i++) {

            }
        }
        if (nums.get("D") == 0)
            return "Radient";
        else
            return "Dire";
    }

    public String predictPartyVictory2(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        String ll = "RDRD";
        System.out.println(new M649_predictPartyVictory().predictPartyVictory(ll));
    }
}
