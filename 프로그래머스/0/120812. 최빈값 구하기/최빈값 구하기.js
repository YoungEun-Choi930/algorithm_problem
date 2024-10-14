function solution(array) {
    
    let map = new Map();
    
    for(let num of array) {
        let v = map.has(num) ? map.get(num) : 0;
        map.set(num, v+1);
    }
    
    var answer = -1;
    var max = 0;
    var over = false;
    
    for(let [key, value] of map) {
        if(value > max) {
            max = value;
            answer = key;
            over = false;
        }
        else if(value == max) {
            over = true;
        }
    }
    
    return over ? -1 : answer;
}