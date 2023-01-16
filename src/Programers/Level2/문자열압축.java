package Programers.Level2;


public class 문자열압축 {
    public static void main(String[] args) {
        // 프로그래머스 코딩테스트 연습
        // Lv2. 문자열 압축


        문자열압축.Solution s = new 문자열압축.Solution();

        System.out.println("결과: "+s.solution("zzzbbabbabba"));
        System.out.println("기대: 7");
        System.out.println();
        System.out.println("결과: "+s.solution("xxxxxxxxxxyyy"));
        System.out.println("기대: 5(1)");
        System.out.println();

        System.out.println("결과: "+s.solution("aabbaccc"));
        System.out.println("기대: 7(1)");
        System.out.println();
        System.out.println("결과: "+s.solution("ababcdcdababcdcd"));
        System.out.println("기대: 9(8)");
        System.out.println();
        System.out.println("결과: "+s.solution("abcabcdede"));
        System.out.println("기대: 8(3)");
        System.out.println();
        System.out.println("결과: "+s.solution("abcabcabcabcdededededede"));
        System.out.println("기대: 14(6)");
        System.out.println();
        System.out.println("결과: "+s.solution("xababcdcdababcdcd"));
        System.out.println("기대: 17");
    }


    static class Solution {
        private String str;
        public int solution(String s) {

            int length = s.length();
            if(length < 3) return length;       //1 또는 2일땐 그대로
            else length /= 2;

            int min = length;
            this.str = s;

            for(int i = 1; i <= length; i++) {
                int complength = comp(i);
                if(complength < min) min = complength;
            }

            return min;
        }

        private int comp(int point) {

            String tempString = this.str;
            int length = tempString.length();

            String previous = "";
            int countOverlap = 1;
            for(int index = 0; index+point <= tempString.length(); index += point) {
                String s = tempString.substring(index, index+point);

//                System.out.print(" "+s);
                if(s.equals(previous)) {
                    countOverlap++;
//                    System.out.print("^"+countOverlap);
                    length -= point;
                    if(countOverlap == 2 || countOverlap == 10 || countOverlap == 100) length++;

                }
                else {
                    countOverlap = 1;
                    previous = s;
                }
            }

//            System.out.println(point+"씩 자르면 길이: "+length);
            return length;
        }
    }
}
