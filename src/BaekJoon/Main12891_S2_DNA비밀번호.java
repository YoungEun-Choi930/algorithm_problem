package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12891_S2_DNA비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		int S = Integer.parseInt(input[0]);	//문자열 길이 (1 ≤ |P| ≤ |S| ≤ 1,000,000)
		int P = Integer.parseInt(input[1]); //만들어 낼 길이
		
		String DNA = br.readLine();
		
		input = br.readLine().split(" ");
		int[] minACGT = new int[4];
		for(int i = 0 ; i < 4 ; i++) {
			minACGT[i] = Integer.parseInt(input[i]);
		}

		// solve
		int result = 0;
		int[] curACGT = new int[4];
		//첫번째
		for(int idx = 0 ; idx < S; idx++) {
			char c = DNA.charAt(idx);
			curACGT[getindex(c)]++;

			//P길이가 되기 전까지는 일단 갯수만 카운트한다.
			if(idx < P-1) continue;
			else if(idx >= P) {
				c = DNA.charAt(idx-P);
				curACGT[getindex(c)]--;	//지나간 자리는 -1 해준다.
			}
			
			//개수를 만족하는지 확인
			boolean flag = true;
			for(int i = 0 ; i < 4; i++) {
				if(curACGT[i] < minACGT[i]) {
					flag = false;
					break;
				}
			}
			
			// 만족하면
			if(flag) {
				result++;
			}
		}
		

		// 출력
		System.out.println(result);
	}
	
	private static int getindex(char c) {
		if(c == 'A') return 0;
		else if(c == 'C') return 1;
		else if(c == 'G') return 2;
		else if(c == 'T') return 3;
		return -1;
	}
}
