import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(int[] array) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : array) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        int answer = -1;
        int max = 0;
        boolean over = false;
        
        for(Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                answer = entry.getKey();
                max = entry.getValue();
                over = false;
            }
            else if(entry.getValue() == max) {
                over = true;
            }
        }
        
        return over ? -1 : answer;
    }
}