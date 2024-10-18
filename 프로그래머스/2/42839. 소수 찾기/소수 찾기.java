import java.util.Set;
import java.util.HashSet;

class Solution {
    private String[] splitNumbers;
    private Set<Integer> set;
    private int primeCnt = 0;
    
    public int solution(String numbers) {
        splitNumbers = numbers.split("");
        int[] index = new int[splitNumbers.length];
        set = new HashSet<>();
        
        for(int i = 1 ; i <= splitNumbers.length ; i++) {
            makeNumber(0,index, i,0);
        }
    
        return primeCnt;
    }
    
    private void makeNumber(int current, int[] index, int length, int check) {
        if(current == length) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < length ; i++)
                sb.append(splitNumbers[index[i]]);
            
            int num = Integer.parseInt(sb.toString());
            if(!set.contains(num) && isPrime(num))
                primeCnt++;
            set.add(num);
            return;
        }
        
        
        for(int i = 0 ; i < splitNumbers.length ; i++) {
            if((check & (1 << i)) > 0) continue;
            index[current] = i;
            makeNumber(current+1, index, length, (check | (1<<i)));
        }
    }
    
    private boolean isPrime(int number) {
        if(number <= 1) return false;
        for(int i = 2 ; i*i <= number; i++) {
            if(number % i == 0) return false;
        }
        
        System.out.println(number);
        return true;
    }
}