function solution(money) {
    var answer = [~~(money/5500), money%5500];
    return answer;
}