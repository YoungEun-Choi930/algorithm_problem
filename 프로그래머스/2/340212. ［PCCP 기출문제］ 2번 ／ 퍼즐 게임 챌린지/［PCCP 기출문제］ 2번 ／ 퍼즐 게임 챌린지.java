import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        // 1부터 maxDiff 사이의 값 중 limit > sum인 최소 level을 구한다.
        int level = find(1, 300_000, limit, diffs, times);
        return level;
    }
    
    private int find(int minLevel, int maxLevel, long limit, int[] diffs, int[] times) {
        if(maxLevel <= minLevel) return maxLevel;
        
        int half = (maxLevel + minLevel) / 2;
        long halfTime = getTime(half, diffs, times);
        
        if(limit < halfTime) return find(half+1, maxLevel, limit, diffs, times);
        else return find(minLevel, half, limit, diffs, times);
    }
    
    private long getTime(int level, int[] diffs, int[] times) {
        long sum = 0;
        
        for(int i = 0 ; i < diffs.length ; i++) {
            if(diffs[i] > level) {
                sum += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
            else sum += times[i];
        }
        
        return sum;
    }
}