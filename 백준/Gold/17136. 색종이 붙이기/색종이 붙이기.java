import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[][] map;  // 종이 10 X 10
	private static int[] paper;  // 크기별 색종이 카운터
	private static int totalCnt;  // 가려야 하는 칸의 수
	private static int answer;

	private static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		totalCnt = 0;  // 가려야 하는 칸의 수
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				if (map[i][j] == 1) {
					totalCnt++;
				}
			}
		}

		answer = Integer.MAX_VALUE;
		paper = new int[5];

		dfs(0, 0, 0);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		System.out.println(answer);
	}

	// 현재위치, 가려진 영역의 수
	private static void dfs(int startX, int startY, int cnt) {

		int sum = paper[0] + paper[1] + paper[2] + paper[3] + paper[4];
		if (sum >= answer) {  // 기존 최솟값보다 크면 가지치기
			return;
		}

		if (cnt == totalCnt) {
			if (sum < answer) {
				answer = sum;  // 최소값 갱신
			}
			return;
		}

		if (startY == 10) {
			dfs(startX + 1, 0, cnt);
			return;
		}

		if (map[startX][startY] == 1) {
			for (int pSize = 4; pSize >= 0; pSize--) {
				if (paper[pSize] < 5 && isAttach(startX, startY, pSize)) {
					
					int tempCnt = fill(startX, startY, pSize, 0);
					paper[pSize]++;

					// 다음
					dfs(startX, startY, cnt + tempCnt);

					fill(startX, startY, pSize, 1);
					paper[pSize]--;
				}
			}
			return;
		}
		else {
			dfs(startX, startY + 1, cnt);
		}
	}

	private static boolean isAttach(int x, int y, int size) {

		if (x+size >= 10 || y+size >= 10) {
			return false;
		}

		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= size; j++) {

				if (map[x + i][y + j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static int fill(int startX, int startY, int pSize, int value) {
		int cnt = 0;
		for (int x = startX; x <= startX + pSize; x++) {
			for (int y = startY; y <= startY + pSize; y++) {
				map[x][y] = value;
				cnt++;
			}
		}
		return cnt;
	}

}