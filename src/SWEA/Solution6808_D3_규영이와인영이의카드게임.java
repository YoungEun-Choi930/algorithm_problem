package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Solution6808_D3_규영이와인영이의카드게임 {
	private static int[] input;
	private static boolean[] checked;
	private static int[] array;
	private static int[] numbers;
	private static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input = new int[9];
			boolean[] nums = new boolean[19];
			String[] inputstr = br.readLine().split(" ");
			for(int i = 0 ; i < 9 ; i++) {
				input[i] = Integer.parseInt(inputstr[i]);
				nums[input[i]] = true;
			}

			//next permutation
			int[] arrayB = new int[9];
			int c = 0;
			for(int i = 1 ; i < 19 ; i++) {
				if(!nums[i]) arrayB[c++] = i;
			}
			
			
			win = 0;
			lose = 0;
			do {
				int wcnt = 0;
				int lcnt = 0;
				for(int i = 0 ; i < 9 ; i++) {
					if(input[i] > arrayB[i])
						wcnt += input[i]+ arrayB[i];
					else if(input[i] < arrayB[i])
						lcnt += input[i]+ arrayB[i];
				}
				if(wcnt > lcnt) win++;
				else if(wcnt < lcnt) lose++;

			}while(np(arrayB));

			//			permutation(0,0);

			sb.append("#").append(tc).append(" ")
			.append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}


	private static void permutation(int cnt, int flag) {	//cnt : 현재까지 뽑은수의 갯수
		// 기저
		if(cnt == 9) {
			int wcnt = 0;
			int lcnt = 0;
			for(int i = 0 ; i < 9 ; i++) {
				if(input[i] > numbers[i])
					wcnt += input[i];
				else if(input[i] < numbers[i])
					lcnt += numbers[i];
			}
			if(wcnt > lcnt) win++;
			else if(wcnt < lcnt) lose++;
			return;
		}

		// 유도
		for(int i = 0; i < 9 ; i++) {
			if((flag & (1<<i)) != 0) {
				continue;
			}
			//숫자 뽑기
			numbers[cnt] = numbers[i]; 
			permutation(cnt+1, flag | (1<<i));
		}
	}

	private static boolean np(int[] input) {
		
		// 1.
		int n = input.length;
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) i--;
		
		if(i == 0) {
			return false;
		}
		
		// 2.
		int j = n-1;
		while(input[i-1] >= input[j]) --j;
		
		// 3.
		swap(input, i-1,j);
		
		// 4.
		int k = n-1;
		while(i < k) {
			swap(input, i++, k--);
		}
		
		
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
