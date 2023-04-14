class Solution {
    public String solution(String number, int k) {
        
        
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int start = 0;
        
        for(int i = 0 ; i < len ; i++) {
            
            char max = 0;
            int end = i + k;
            for(int j = start ; j <= end ; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
    
}