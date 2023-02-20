package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9519_G5_졸려 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		int X = Integer.parseInt(br.readLine()); //X(1 ≤ X ≤ 1,000,000,000)
		char[] input = br.readLine().toCharArray(); //소문자로만, 길이는 구간 [3,1000]에 포함

		// solve
		int len = input.length -1;
		int halflen = len / 2;
		int start;
		char[] back = new char[halflen];
		char[] front;
		
		if(len % 2 == 0) {	//짝
			if(X > halflen) {// 짝수면 반만돌면 돌아온다
				X = X % (halflen+1);
			}
			start = halflen+1;
			front = new char[halflen];
		}
		else {	//홀
			if(X > len) { //홀수면 len만큼 돌면 돌아온다.
				X = X % len;
			}
			start = halflen+2;
			front = new char[halflen+1];
		}
		
		char[] temp = new char[input.length];
		temp[0] = input[0];
		
		
		for(int i = 0 ; i < X ; i++) {
			back = Arrays.copyOfRange(input, start, input.length);
			
			int bidx = halflen-1;
			int iidx = 0;
			
			for(int idx = 1; idx + 1 < input.length; idx++) {
				back[bidx--] = input[idx++];
				front[iidx++] = input[idx];
			}
			if(len%2 == 1) front[iidx] = input[input.length-1];
			//System.out.println(Arrays.toString(front));
			//System.out.println(Arrays.toString(back));
			System.arraycopy(front, 0, input, 1, front.length);
			System.arraycopy(back, 0, input, start, back.length);
			//System.out.println(Arrays.toString(input));
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < input.length; i++) {
			sb.append(input[i]);
		}
		System.out.println(sb);
	}
}
