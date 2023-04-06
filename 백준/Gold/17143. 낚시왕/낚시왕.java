import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	// d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.
	// X, 위, 아래, 오른쪽, 왼쪽
	private static final int[] dr = { 0, -1, 1, 0, 0 };
	private static final int[] dc = { 0, 0, 0, 1, -1 };

	private static class Shark implements Comparable<Shark> {
		public int r;  // 행
		public int c;  // 열
		public int s;  // 속력
		public int d;  // 이동방향
		public int z;  // 크기

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		// 땅과 가까운 순으로 정렬 (행 기준 오름차순 정렬)
		@Override
		public int compareTo(Shark o) {
			return this.r - o.r;
		}
	}


	public static void main(String args[]) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int R = Integer.parseInt(split[0]);
		int C = Integer.parseInt(split[1]);
		int M = Integer.parseInt(split[2]);

		PriorityQueue<Shark> pQueue = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			int s = Integer.parseInt(split[2]);
			int d = Integer.parseInt(split[3]);
			int z = Integer.parseInt(split[4]);

			pQueue.offer(new Shark(r, c, s, d, z));
		}

        // ===============================================
		int kingC = 0;  // 낚시왕의 위치 (열)
		int sum = 0;

		// 낚시왕이 격자판을 벗어날 때까지 반복한다.
		while (kingC < C) {

			// 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
			kingC++;

			// 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
			boolean isCatch = false;
			List<Shark> tempSharks = new ArrayList<>();
			while (!pQueue.isEmpty()) {

				// 상어를 꺼낸다.
				Shark curShark = pQueue.poll();

				// 낚시왕이 있는 열에 있는 상어를 최초 발견하면 잡는다. (이미 땅과 가까운 순으로 정렬되어 있으므로)
				if (curShark.c == kingC && isCatch == false) {

					// 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
					isCatch = true;
					sum += curShark.z;
				}
				// 그렇지 않은 상어는 임시 리스트에 담는다.
				else {
					tempSharks.add(curShark);
				}

			}

			// 3. 상어가 이동한다.
			// 상어가 이동을 마친 후에 한 칸에 상어가 두 마리 이상 있을 수 있다.
			// 이때는 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.
			// 한 칸에 두 마리 이상인지 체크하기 위해 이차원 배열을 사용한다.
			Shark[][] isVisited = new Shark[R + 1][C + 1];  // 0번 인덱스 사용 안함

			for (Shark curShark : tempSharks) {
				// 시간 초과 해결 부분 (이동 횟수를 나머지 연산을 통해 줄이자)
				int seconds = 0;
				// 위 혹은 아래 방향이면
				if (curShark.d == 1 || curShark.d == 2) {
					seconds = curShark.s % ((R - 1) * 2);
				}
				// 오른쪽 혹은 왼쪽 방향이면
				else if (curShark.d == 3 || curShark.d == 4) {
					seconds = curShark.s % ((C - 1) * 2);
				}

				// 1초씩 이동
				for (int i = 0; i < seconds; i++) {
					int testR = curShark.r + dr[curShark.d];
					int testC = curShark.c + dc[curShark.d];

					// 경계 안쪽이면 이동
					if ((0 < testR && testR <= R) && (0 < testC && testC <= C)) {
						curShark.r = testR;
						curShark.c = testC;
					}
					// 경계 밖이면 방향 전환
					else {
						// 위 혹은 아래 방향이면
						if (curShark.d == 1 || curShark.d == 2) {
							curShark.d = curShark.d == 1 ? 2 : 1;  // 위 아래 방향 전환 
						}
						// 오른쪽 혹은 왼쪽 방향이면
						else if (curShark.d == 3 || curShark.d == 4) {
							curShark.d = curShark.d == 3 ? 4 : 3;  // 오른쪽 왼쪽 방향 전환
						}

						// 전환한 방향으로 이동
						curShark.r += dr[curShark.d];
						curShark.c += dc[curShark.d];
					}
				}

				// 이동을 다 했다면 방문 표시
				if (isVisited[curShark.r][curShark.c] == null) {  // 상어가 없다면
					isVisited[curShark.r][curShark.c] = curShark;
				}
				else if (isVisited[curShark.r][curShark.c] != null) {  // 상어가 있다면
					if (isVisited[curShark.r][curShark.c].z < curShark.z) {  // 둘 중 큰 상어만 남기기
						isVisited[curShark.r][curShark.c] = curShark;
					}
				}
			}

			// isVisited 2차원 배열에 존재하는 상어들만 큐에 다시 넣는다.
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (isVisited[i][j] != null) {
						pQueue.offer(isVisited[i][j]);
					}
				}
			}
		}

		System.out.println(sum);
	}
}
