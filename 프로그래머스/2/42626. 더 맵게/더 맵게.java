import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num : scoville) {
            queue.add(num);
        }
        
        int resultCnt = 0;
        
        while(!queue.isEmpty()) {
            // System.out.println(queue.poll());
            if(queue.peek() >= K) break;
            if(queue.size() < 2) {
                resultCnt = -1;
                break;
            }
            
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a + b * 2);
            resultCnt++;
        }
        
        return resultCnt;
        
    }
}