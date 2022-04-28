package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {
    public static void main(String[] args) {
        // 프로그래머스 코딩테스트 연습
        // Lv2. 오픈채팅방


        오픈채팅방.Solution s = new 오픈채팅방.Solution();

        String[] result = s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        for(String a: result) {
            System.out.println(a);
        }
    }


    static class Solution {
        public String[] solution(String[] record) {
            List<HashMap> resultString = new ArrayList();
            HashMap<String, String> nameMap = new HashMap<>();

            for(String str: record) {
                String[] split = str.split(" ");

                switch (split[0]) {                 //첫글자만 charAt[0]해서 비교해도 됨!!!!!
                    case "Enter" :
                        nameMap.put(split[1], split[2]);
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("type", true);
                        map.put("uid", split[1]);
                        resultString.add(map);      //요부분 hashMap말고 class로 하면 더 좋겠다!!!
                        break;
                    case "Leave" :
                        HashMap<String, Object> map2 = new HashMap<>();
                        map2.put("type", false);
                        map2.put("uid", split[1]);
                        resultString.add(map2);
                        break;
                    case "Change" :
                        nameMap.put(split[1], split[2]);
                        break;
                }
            }

            String[] result = new String[resultString.size()];
            int index = 0;
            for(HashMap map: resultString) {
                String str = nameMap.get(map.get("uid"));
                if((boolean) map.get("type")) str += "님이 들어왔습니다.";
                else str += "님이 나갔습니다.";
                result[index++] = str;
            }


            /*
            이 코드를 쓰고싶었는데 머리에서 잘 안나오더라
            map함수!를 쓰면 할수있다!!!! 기억하기!

            return resultString.stream().map(map -> {
                String str = nameMap.get(map.get("uid"));
                if((boolean) map.get("type")) str += "님이 들어왔습니다.";
                else str += "님이 나갔습니다.";
                return str;
            }).toArray(ary -> new String[resultString.size()]);
             */

            String[] answer = result;
            return answer;
        }
    }

}
