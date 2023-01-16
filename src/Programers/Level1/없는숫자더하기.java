package Programers.Level1;

import java.util.ArrayList;

public class 없는숫자더하기 {

    public static void main(String[] args) {
        // 프로그래머스 코딩테스트 연습
        // Lv1. 숫자 문자열과 영단어


        없는숫자더하기.Solution s = new 없는숫자더하기.Solution();

        int[] numlist = new int[]{1,2,3,4,6,7,8,0};
        System.out.println("결과: "+s.solution(numlist));
        System.out.println("기대: 14");
        System.out.println();


        numlist = new int[]{5, 8, 4, 0, 6, 7, 9};
        System.out.println("결과: "+s.solution(numlist));
        System.out.println("기대: 6");
        System.out.println();
    }

    static class Solution {
        public int solution(int[] numbers) {

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < 10; i++)
                list.add(i);

            for(int num : numbers) {
                System.out.print(num+" ");
                list.remove((Integer) num);
            }

            int answer = 0;
            for(int num: list)
                answer += num;

            return answer;


            /*
            int sum = 45;
            for (int i : numbers) {
                sum -= i;
            }
            return sum;
             */

        }
    }
}
