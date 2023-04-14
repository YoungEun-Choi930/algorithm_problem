import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String name : completion) {
            map.put(name, map.getOrDefault(name, 0) +1);
        }
        
        for(String name : participant) {
            int r = map.getOrDefault(name, -1);
            if(r <= 0) answer += name;
            map.put(name, r-1);
        }
        
        return answer;
    }
}