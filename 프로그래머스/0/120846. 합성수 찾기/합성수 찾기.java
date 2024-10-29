class Solution {
    public int solution(int n) {
        boolean[] arr = new boolean[101];
        
        int m = (int) Math.sqrt(n);
        for(int i = 2 ; i <= m ; i++) {
            if(arr[i]) continue;
            
            for(int j = i+i ; j <= n ; j += i) {
                arr[j] = true;
            }
        }
        
        int cnt = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(arr[i]) cnt++;
        }
        
        return cnt;
    }
}