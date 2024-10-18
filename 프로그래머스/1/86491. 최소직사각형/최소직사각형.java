class Solution {
    public int solution(int[][] sizes) {
        
        int max1 = 0 , max2 = 0;
        
        for(int[] card : sizes) {
            int a = Math.max(card[0], card[1]);
            int b = Math.min(card[0], card[1]);
            
            if(a > max1) max1 = a;
            if(b > max2) max2 = b;
        }
        
        return max1 * max2;
    }
}