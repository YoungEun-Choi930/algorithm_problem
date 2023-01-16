package Programers.Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
    public static void main(String[] args) {
        // 프로그래머스 코딩테스트 연습
        // Lv1. 신고결과받기

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        Solution s = new Solution();
        int[] result = s.solution(id_list,report,2);

        System.out.println("결과");
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println("\n기대값");
        System.out.println("2 1 1 0");
    }


    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));         //중복 제거

            int[] result = new int[id_list.length];
            HashMap<String, Integer> countMap = new HashMap<>();    //신고 횟수 저장

            for(String s: reportSet) {    //신고 횟수 세기
                String user = s.split(" ")[1];

                countMap.put(user, countMap.getOrDefault(user,0) +1);
            }

            System.out.println("신고당한 횟수");
            System.out.println(countMap);

            HashMap<String, Integer> resultMap = new HashMap<>();

            for(String s: reportSet) {    // 신고한사람이 정지되었는지 세기
                String[] r = s.split(" ");
                String user1 = r[0];
                String user2 = r[1];

                if(countMap.get(user2) >= k) {
                    resultMap.put(user1, resultMap.getOrDefault(user1,0) +1);
                }
            }

            System.out.println("신고메일받는횟수");
            System.out.println(resultMap);

            for(int i = 0; i < id_list.length; i++) {
                String user = id_list[i];
                if(resultMap.containsKey(user)) {
                    result[i] = resultMap.get(user);
                }
                else {
                    result[i] = 0;
                }
            }

            return result;
        }
    }

}