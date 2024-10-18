function solution(my_string, letter) {
    return [...my_string].filter((c)=>c!=letter).join('');
}