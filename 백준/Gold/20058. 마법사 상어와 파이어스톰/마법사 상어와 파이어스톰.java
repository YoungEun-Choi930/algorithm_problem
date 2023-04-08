import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	private static int[][] map;
	private static int N, pN;

	private static void inputMap(BufferedReader br) throws IOException {
		map = new int[pN][];
		for(int i = 0 ; i < pN; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);
		pN = (int) Math.pow(2, N);
		
		inputMap(br);
		
		int min = 7;
		input = br.readLine().split(" ");
		for(int i = 0 ; i < Q; i++) {
			int l = Integer.parseInt(input[i]);
			min = l < min ? l : min;
			run(l);
		}

		printOutput();
		
	}
	private static void printOutput() {
		int sum = 0;
		int max = 0;
		boolean[][] visited = new boolean[pN][pN];
		
		for(int i = 0 ; i < pN ; i++) {
			for(int j = 0 ; j < pN ; j++) {
				sum += map[i][j];
				if(map[i][j] != 0 && !visited[i][j]) {
					int r = getSize(i,j,visited);
					max = r > max ? r : max;
				}
			}
		}
		
		System.out.println(sum);
		System.out.println(max);
	}
	
	private static final int[][] delta = {{0,-1},{0,1},{1,0},{-1,0}};
	
	private static int getSize(int x, int y, boolean[][] visited) {
		int cnt = 0;
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {x,y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			cnt++;
			
			for(int d = 0 ; d < 4; d++) {
				int dx = cur[0] + delta[d][0];
				int dy = cur[1] + delta[d][1];
				
				if(dx >= 0 && dx < pN && dy >= 0 && dy < pN 
						&& map[dx][dy] != 0&&!visited[dx][dy]) {
					visited[dx][dy] = true;
					queue.offer(new int[] {dx,dy});
				}
			}
		}
		
		
		return cnt;
	}

	private static void run(int L) {
		int size = (int) Math.pow(2, L);
		if(size != 1) {
			for(int i = 0 ; i < pN; i+=size) {
				for(int j = 0 ; j < pN; j+=size) {
					spinArray(i,j, size);
				}
			}
		}

		// 이후 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
		checkNeare3();
	}
	
	private static void checkNeare3() {

		int[][] temp = new int[pN][pN];
		for(int i = 0 ; i < pN; i++) {
			for(int j = 0 ; j < pN; j++) {
				if(map[i][j] == 0) continue;
				
				// 4방확인
				int cnt = 0;
				for(int d = 0 ;d < 4 ; d++) {
					int dx = i + delta[d][0];
					int dy = j + delta[d][1];
					if(dx >= 0 && dx < pN && dy >= 0 && dy < pN && map[dx][dy] != 0)
						cnt++;
				}
				
				if(cnt < 3) temp[i][j] = map[i][j] -1;
				else temp[i][j] = map[i][j];
				
			}
		}
		
		map = temp;
	}
	
	private static void spinArray(int x, int y, int size) {
		
		int t = size / 2;
		for(int l = 0 ; l < t; l++) {
			int startx = x + l;
			int starty = y + l;
			int endx = startx + size -1;
			int endy = starty + size -1;
			// 복사
			int[] temp = new int[size];
			for(int i = 0 ; i < size ; i++) {
				temp[i] = map[startx][starty+i];
			}
			
			// 왼쪽을 위로
			for(int i = 0 ; i < size ; i++) {
				map[startx][endy-i] = map[startx+i][starty];
			}
			
			// 아래를 왼쪽으로
			for(int i = 0 ; i < size; i++) {
				map[startx+i][starty] = map[endx][starty+i];
			}
			
			// 오른쪽을 아래로
			for(int i = 0 ; i < size; i++) {
				map[endx][starty+i] = map[endx-i][endy];
			}
			
			// temp를 오른쪽으로
			for(int i = 0 ; i < size; i++) {
				map[startx+i][endy] = temp[i];
			} 
			
			size -=2;
		}
		
		
	}
} 