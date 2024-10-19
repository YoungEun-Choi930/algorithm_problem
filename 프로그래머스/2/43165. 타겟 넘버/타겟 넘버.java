class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    public int dfs(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length) {
            if(sum == target) return 1;
            else return 0;
        }
        
        int cnt = 0;
        cnt += dfs(numbers, index+1, sum+numbers[index], target);
        cnt += dfs(numbers, index+1, sum-numbers[index], target);
        return cnt;
    }
}