import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }
        
        int cnt = set.size();
        
        return cnt < nums.length/2 ? cnt : nums.length / 2;
    }
}