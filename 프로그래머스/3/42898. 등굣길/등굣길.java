class Solution {
    private int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        
        boolean[][] map = new boolean[m+1][n+1];
        for(int[] point : puddles) {
            map[point[0]][point[1]] = true;
        }
        
        int[] count = new int[n+1];
        int[] precount = new int[n+1];
        precount[1] = 1;
        
        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if(map[i][j]) count[j] = 0;
                else count[j] = (precount[j] + count[j-1]) % MOD;
            }
            precount = count;
        }
        
        return count[n] % MOD;
    }
}