package byteDance;

import java.util.*;

/**
 * @description:
 * @author: Tyranitar
 * @date: 2021/9/28 19:14
 **/
class FreqStack {
    Map<Integer, Integer> numcount;
    Map<Integer, Stack<Integer>> freqstack;
    int maxfreq;

    public FreqStack() {
        numcount = new HashMap<>();
        freqstack = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int val) {
        int total = numcount.getOrDefault(val, 0) + 1;
        if (total > maxfreq)
            maxfreq = total;
        freqstack.computeIfAbsent(total, s -> new Stack<>()).push(val);
    }

    public int pop() {
        int x = freqstack.get(maxfreq).pop();
        numcount.put(x, numcount.get(x) - 1);
        if (freqstack.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}
