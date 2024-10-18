class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for(String c : my_string.split("")) {
            for(int i = 0 ; i < n ; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}