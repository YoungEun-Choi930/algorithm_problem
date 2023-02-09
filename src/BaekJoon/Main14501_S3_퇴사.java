package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14501_S3_퇴사 {
	private static int N, result=0;
	private static int[][] timetable;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 입력파일 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 2. 입력파일 객체화
		N = Integer.parseInt(br.readLine());
		timetable = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			timetable[i][0] = Integer.parseInt(input[0]);
			timetable[i][1] = Integer.parseInt(input[1]);
		}

		// 3. 알고리즘 풀기
		/*
		 * dp...? 완탐..?
		 * 완탐? 3일짜리 선택하면 index값을 +3해서 보내는?
		 */
		choose(0,0);

		// 4. 정답 출력
		System.out.println(result);
	}

	private static void choose(int sum, int start) {
		if(start >= N) {
			result = Math.max(sum, result);
			return;
		}

		for(int i = start; i < N ; i++) {
			int day = timetable[i][0];
			int pay = timetable[i][1];

			if(i+day <= N)	
				choose(sum+pay, i+day);
			else if(i == N-1)
				choose(sum, N);
		}
	}
}
