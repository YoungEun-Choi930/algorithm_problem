function solution(numbers) {
    var sum = numbers.reduce((prev, n) => prev+n);
    console.log(sum)
    return sum / numbers.length;
}