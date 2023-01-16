package Level1;

import java.util.*;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        // 프로그래머스 코딩테스트 연습
        // Lv1. 로또의 최고 쉰위와 최저 순위

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        로또의최고순위와최저순위.Solution s = new 로또의최고순위와최저순위.Solution();
        int[] result = s.solution(lottos,win_nums);

        System.out.println("결과");
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println("\n기대값");
        System.out.println("3 5");
    }


    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            List<Integer> win = new ArrayList<>();
            for(int num: win_nums) {
                win.add(num);
            }

            int correct = 0;
            int zero = 0;
            for(int num: lottos) {
                if(num == 0) zero++;
                if(win.contains(num)) {
                    correct++;
                }
            }

            // 만약 zero가 모두 틀리면
            int low = calGrade(correct);

            //zero가 모두 맞으면
            int high = calGrade(correct+zero);

            int[] result = {high, low};
            return result;
        }

        int calGrade(int correct) {
            //6개 모두 일치 == 1등
            //2개 일치 == 5등
            //이외 - 6등
            return Math.min(6, 7-correct);
        }
    }
}
