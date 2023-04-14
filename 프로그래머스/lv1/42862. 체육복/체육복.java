import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        
        // 도난당한 학생이 여벌 체육복 있는 경우 count
        boolean[] lostcheck = new boolean[n+1];
        for(int i : lost) {
            lostcheck[i] = true;
        }
        
        boolean[] check = new boolean[n+2];
        for(int i : reserve) {
            if(lostcheck[i]) {
                lostcheck[i] = false;
                answer++;
            }
            else {
                check[i] = true;
            }
        }
        
        for(int i : lost) {
            if(!lostcheck[i]) continue;
            // 확인하기
            if(check[i-1]) {
                check[i-1] = false;
                answer++;
            }
            else if(check[i+1]) {
                check[i+1] = false;
                answer++;
            }
        }
        
        return answer;
    }
}