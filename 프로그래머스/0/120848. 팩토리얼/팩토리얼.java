class Solution {
    public int solution(int n) {
        int pacto = 1;
        int cur = 1;
        while(pacto <= n) {
            pacto *= ++cur;
        }
        return cur-1;
    }
}