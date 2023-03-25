import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	private static class Door {
		int x, y;
		Door next;

		public Door(int x, int y, Door next) {
			this.x = x;
			this.y = y;
			this.next = next;
		}
	}

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	private static char[][] map;
	private static int h, w, result;
	private static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	private static boolean[] keyList;
	private static Door[] DoorList;
	private static final char WALL = '*';
	private static final char EMPTY = '.';
	private static final char DOC = '$';
	private static final char DOORSTART = 'A';
	private static final char DOOREND = 'Z';
	private static final char KEYSTART = 'a';
	private static final char KEYEND = 'z';

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			h = Integer.parseInt(input[0]);
			w = Integer.parseInt(input[1]);

			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}

			String keys = br.readLine();

			// solve
			// 1. 현재 가지고 있는 키
			DoorList = new Door[26];
			keyList = new boolean[26];
			if (!"0".equals(keys)) {
				for (char key : keys.toCharArray()) {
					keyList[key - KEYSTART] = true;
				}
			}

			// BFS
			result = 0;
			stealDoc();

			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}

	private static Queue<Node> getStart() {
		Queue<Node> queue = new ArrayDeque<>();
		for (int j = 0; j < w; j++) {
			if (check(map[0][j], 0, j)) {
				queue.offer(new Node(0, j));
				map[0][j] = '*';
			}
			if (check(map[h - 1][j], h - 1, j)) {
				queue.offer(new Node(h - 1, j));
				map[h - 1][j] = '*';
			}
		}
		for (int i = 0; i < h; i++) {
			if (check(map[i][0], i, 0)) {
				queue.offer(new Node(i, 0));
				map[i][0] = '*';
			}
			if (check(map[i][w - 1], i, w - 1)) {
				queue.offer(new Node(i, w - 1));
				map[i][w - 1] = '*';
			}
		}
		return queue;
	}

	private static boolean check(char cur, int x, int y) {
		if (cur == EMPTY)
			return true;
		else if (cur == DOC) {
			result++;
			return true;
		}
		if (cur == WALL)
			return false;
		else if (KEYSTART <= cur && cur <= KEYEND) {
			keyList[cur - KEYSTART] = true;
			return true;
		} else if (DOORSTART <= cur && cur <= DOOREND) {
			if(keyList[cur-DOORSTART]) return true;
			else {
				DoorList[cur - DOORSTART] = new Door(x, y, DoorList[cur - DOORSTART]);
				return false;
			}
		}
		return false;
	}

	private static void stealDoc() {

		// 2. start지점 큐에 넣기. 테두리 체크
		Queue<Node> queue = getStart();

		// 3. 현재 열쇠중에 열 수 있는 문
		for (int i = 0; i < 26; i++) {
			if (keyList[i]) {
				for (Door door = DoorList[i]; door != null; door = door.next) {
					map[door.x][door.y] = '*';
					queue.offer(new Node(door.x, door.y));
				}
			}
		}

		// 4. 출발
		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int d = 0; d < delta.length; d++) {
				int dx = cur.x + delta[d][0];
				int dy = cur.y + delta[d][1];

				// 벽
				if (dx < 0 || dx >= h || dy < 0 || dy >= w)
					continue;
				if (map[dx][dy] == WALL)
					continue;

				// 이동
				if (DOORSTART <= map[dx][dy] && map[dx][dy] <= DOOREND) {
					int doorNum = map[dx][dy] - DOORSTART;
					if (!keyList[doorNum]) { // 키가 없으면 리스트에 추가.
						DoorList[doorNum] = new Door(dx, dy, DoorList[doorNum]);
						continue;
					}
					// else 키를 가지고 있으면 그냥 바로 방문.
				} else if (KEYSTART <= map[dx][dy] && map[dx][dy] <= KEYEND) {
					// 이미 방문한 길 중에서 해당 문이 있으면
					int keyNum = map[dx][dy] - KEYSTART;
					for (Door door = DoorList[keyNum]; door != null; door = door.next) {
						if (map[door.x][door.y] != '*') {
							map[door.x][door.y] = '*';
							queue.offer(new Node(door.x, door.y));
						}
					}
					DoorList[keyNum] = null;
					keyList[keyNum] = true;	//가지고 있는 열쇠에 추가하기
				} else if (map[dx][dy] == DOC) {
					result++;
				}

				// 방문처리하기
				map[dx][dy] = '*';
				queue.offer(new Node(dx, dy));
			}
		}

	}

}
