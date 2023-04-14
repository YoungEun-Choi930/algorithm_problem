import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx = 0 ; idx < commands.length; idx++) {
            int[] cmd = commands[idx];
            int start = cmd[0]-1, end = cmd[1];
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            
            for(int i = start ; i < end ; i++) {
                queue.offer(array[i]);
            }
            
            for(int i = 1 ; i < cmd[2] ; i++) {
                queue.poll();
            }
            
            answer[idx] = queue.poll();
        }
        
        
        
        return answer;
    }
}