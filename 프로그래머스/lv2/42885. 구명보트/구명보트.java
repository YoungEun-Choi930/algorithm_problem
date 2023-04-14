import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        boolean[] check = new boolean[people.length];
        Arrays.sort(people);
        int start = people.length-1;
        
        for(int i = 0 ; i < people.length; i++) {
            if(check[i]) continue;
            if(limit - people[i] < 40) {
                answer++;
                continue;
            }
            
            //else
            int maxidx = -1;
            for(int j = start ; j > i ; j--) {
                if(people[i] + people[j] > limit) continue;
                start = j - 1;
                maxidx = j;
                break;
            }
            if(maxidx != -1) check[maxidx] = true;
            answer++;
        }
        
        return answer;
    }
}