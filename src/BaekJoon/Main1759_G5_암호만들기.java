package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1759_G5_암호만들기 {
	
	private static int L, C;
	private static StringBuilder result;
	private static char[] Alphabet;
	private static char[] alpha;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new StringBuilder();

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		// (3 ≤ L ≤ C ≤ 15)
		L = Integer.parseInt(input[0]); // 만들어야하는 길이
		C = Integer.parseInt(input[1]); // 문자갯수
		
		String instr = br.readLine();
		Alphabet = new char[C];
		alpha = new char[L];
		for(int i = 0 ; i < C; i++) {
			Alphabet[i] = instr.charAt(i*2);
		}

		// solve
		
		// 1. 입력받은 문자 오름차순으로 정렬
		Arrays.sort(Alphabet);
		
		// 2. cCl 조합
		Combination(0,0,0,0);

		// 출력
		System.out.println(result);
	}

	private static final String vowel = "aeiou";
	private static void Combination(int start, int count, int vowelCnt, int consonatsCnt) {
		if(count == L) {
			// 3. 조합 다 만들어지면  모음이 하나라도 있는지 확인. 자음 2개 있는지 확인
			if(vowelCnt != 0 && consonatsCnt >= 2) {
				for(int i = 0 ; i < L ; i++) result.append(alpha[i]);
				result.append('\n');
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			char c = Alphabet[i];
			alpha[count] = c;
			if(vowel.indexOf(c) != -1) {
				Combination(i+1, count+1,vowelCnt+1,consonatsCnt);
			}
			else {
				Combination(i+1, count+1,vowelCnt,consonatsCnt+1);
			}
		}
		
	}
}
