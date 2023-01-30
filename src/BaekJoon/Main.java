package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// solve
		/*
		 * 아이디어: 모든 자리에서 상하좌우로 바꾸고 해당하는 행,렬 에서 연속부분 길이 저장.
		 * 
		 */
		int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		int maxCount = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				char cur = map[i][j];
				// 상하좌우 확인
				for (int dt = 0; dt < 4; dt++) {
					int dx = i + delta[dt][0];
					int dy = j + delta[dt][1];

					if (dx < 0 || dy < 0 || dx >= N || dy >= N)
						continue;

					// 색깔 바꾸기
					char pre = map[dx][dy];
					map[dx][dy] = cur;
					map[i][j] = pre;

					// 행, 열에 대해 연속부분 count
					int cc = 1; // column count
					int mcc = 1; // max column count
					char cpre = '0'; // column previous
					int rc = 1; // row
					int mrc = 1;
					char rpre = '0';
					for (int index = 0; index < N; index++) {
						if (map[dx][index] == cpre) {
							cc++;
						} else {
							cpre = map[dx][index];
							mcc = Math.max(mcc, cc);
							cc = 1;
						}
						if (map[index][dy] == rpre) {
							rc++;
						} else {
							rpre = map[index][dy];
							mrc = Math.max(mrc, rc);
							rc = 1;
						}
					}

					// count 큰값으로 결과 저장
					// 여길 이렇게 무식하게 해도 되나 싶은데...
					cc = Math.max(mcc, cc);
					rc = Math.max(mrc, rc);
					cc = Math.max(cc, rc);
					maxCount = Math.max(cc, maxCount);

					// 색깔 원상복구
					map[dx][dy] = pre;
					map[i][j] = cur;

				}

			}
		}

		System.out.println(maxCount);

	}
}
