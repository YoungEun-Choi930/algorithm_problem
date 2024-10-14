function solution(arr)
{
    
    var ans = [];
    var prev = -1;
    
    for(let num of arr) {
        if(prev != num) {
            ans.push(num);
            prev = num;
        }
    }
    
    return ans;
}