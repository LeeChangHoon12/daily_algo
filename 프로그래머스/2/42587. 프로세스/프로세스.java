import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Task> wait = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            wait.addLast(new Task(i, priorities[i]));
        }

        int cnt = 0;

        while (!wait.isEmpty()) {
            Task now = wait.pollFirst();

            boolean hasHigher = false;
            
            for (Task tmp : wait) {
                if (tmp.priority > now.priority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                wait.addLast(now); // 다시 큐의 뒤로 보냄
            } else {
                cnt++; // 출력됨
                if (now.index == location) {
                    return cnt;
                }
            }
        }

        return cnt;
    }

    public class Task {
        int index;
        int priority;

        public Task(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}