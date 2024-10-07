function solution(n) {
    var half= Math.ceil(n/2);
    var arr = new Array(half);
    for(let i = 0 ; i < half ; i++) {
        arr[i] = i*2+1;
    }
    return arr;
}