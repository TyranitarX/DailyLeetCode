package MI202198;

import java.util.*;

public class Course2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] now = in.nextLine().split(" ");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < now.length; i++) {
            priorityQueue.offer(Integer.parseInt(now[i]));
        }
        while (!priorityQueue.isEmpty()){
            if(priorityQueue.size()!=1){
                System.out.print(priorityQueue.poll()+" ");
            }else {
                System.out.print(priorityQueue.poll());
            }
        }
    }
}
