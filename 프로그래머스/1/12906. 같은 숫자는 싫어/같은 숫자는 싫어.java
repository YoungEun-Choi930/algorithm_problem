import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new LinkedList<>();
        
        int prev = -1;
        for(int n : arr) {
            if(prev != n) {
                list.add(n);
                prev = n;
            }
        }
        
        Integer[] ans = list.toArray(new Integer[list.size()]);
        int[] answer =Arrays.stream(ans).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}