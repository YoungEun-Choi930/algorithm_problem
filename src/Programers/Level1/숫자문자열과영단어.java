package Programers.Level1;


public class 숫자문자열과영단어 {

    public static void main(String[] args) {
        // 프로그래머스 코딩테스트 연습
        // Lv1. 숫자 문자열과 영단어


        숫자문자열과영단어.Solution s = new 숫자문자열과영단어.Solution();

        System.out.println("결과: "+s.solution("one4seveneight"));
        System.out.println("기대: 1478");
        System.out.println();
        System.out.println("결과: "+s.solution("23four5six7"));
        System.out.println("기대: 234567");
        System.out.println();
        System.out.println("결과: "+s.solution("2three45sixseven"));
        System.out.println("기대: 234567");
        System.out.println();
        System.out.println("결과: "+s.solution("123"));
        System.out.println("기대: 123");
        System.out.println();
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;

            System.out.println(s);
            while(s.length() > 0) {
                answer *= 10;

                int num = isNumber(s.substring(0,1));
                if(num == -1) {
                    num = str2num(s.substring(0, 2));
                    s = s.substring(sublength(num));
                }
                else {
                    s = s.substring(1);
                }

                answer += num;
                System.out.println(answer);
                System.out.println(s);
            }


            /*
            // 진짜 똑똑하다....
            String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

            for(int i=0; i<10; i++){
                s = s.replaceAll(alphabets[i], i);
            }
            return Integer.parseInt(s);
             */

            return answer;
        }

        private int isNumber(String s) {
            switch (s) {
                case "0": return 0;
                case "1": return 1;
                case "2": return 2;
                case "3": return 3;
                case "4": return 4;
                case "5": return 5;
                case "6": return 6;
                case "7": return 7;
                case "8": return 8;
                case "9": return 9;
                default: return -1;
            }
        }

        private int str2num(String s) {
            switch (s) {
                case "ze": return 0;
                case "on": return 1;
                case "tw": return 2;
                case "th": return 3;
                case "fo": return 4;
                case "fi": return 5;
                case "si": return 6;
                case "se": return 7;
                case "ei": return 8;
                case "ni": return 9;
                default: return -1;
            }
        }

        private int sublength(int num) {
            switch (num) {
                case 0:
                case 4:
                case 5:
                case 9:
                    return 4;
                case 1:
                case 2:
                case 6:
                    return 3;
                case 3:
                case 7:
                case 8:
                    return 5;
                default:
                    return 0;
            }
        }
    }
}
