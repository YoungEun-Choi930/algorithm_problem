package Level1;

import java.util.Locale;

public class 신규아이디추천 {
    public static void main(String[] args) {
        // 프로그래머스 코딩테스트 연습
        // Lv1. 신규 아이디 추천


        신규아이디추천.Solution s = new 신규아이디추천.Solution();

        System.out.println("결과: "+s.solution("...!@BaT#*..y.abcde[fghi)jklm"));
        System.out.println("기대: bat.y.abcdefghi");
        System.out.println();
        System.out.println("결과: "+s.solution("z-+.^."));
        System.out.println("기대: z--");
        System.out.println();
        System.out.println("결과: "+s.solution("=.="));
        System.out.println("기대: aaa");
        System.out.println();
        System.out.println("결과: "+s.solution("abcdefghijklmn.p"));
        System.out.println("기대: abcdefghijklmn");
    }


    static class Solution {
        public String solution(String new_id) {

//            1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
            new_id = new_id.toLowerCase(Locale.ROOT);
//            2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            new_id = new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]","");
//            3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            new_id = new_id.replaceAll("\\.+",".");
//            4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            if(new_id.startsWith(".")) new_id = new_id.substring(1);
            if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);

//            6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            int length = new_id.length();
            if(length > 15) {
                new_id = new_id.substring(0,15);
                if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
            }
//            7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
            else if(length < 3) {
//            5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
                if(new_id.isEmpty()) new_id = "a";
                while(new_id.length() < 3) {
                    new_id += new_id.substring(new_id.length()-1);
                }
            }

            return new_id;
        }
    }
}
