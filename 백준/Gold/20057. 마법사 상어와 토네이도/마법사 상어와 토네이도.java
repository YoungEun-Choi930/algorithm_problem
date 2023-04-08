import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][];
		for(int i = 0 ; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int result = startTornado();
		System.out.println(result);
	}

	private static int startTornado() {
		int sumresult = 0;	// 격자 밖으로 나간 모래의 양 
		
		int n = N/2;
		sumresult += tornado(n, n, 0);
		for(int r = 1 ; r < n+1 ; r++) {
			
			// 하
			for(int i = n-r+1; i < n+r; i++) {
				sumresult += tornado(i, n-r, 1);
			}
			
			// 우
			for(int j = n-r ; j < n+r; j++) {
				sumresult += tornado(n+r, j, 2);
			}
			
			// 상
			for(int i = n+r ; i >= n-r+1 ; i--) {
				sumresult += tornado(i, n+r, 3);
			}
			
			// 좌
			for(int j = n+r; j >= n-r; j--) {
				sumresult += tornado(n-r, j, 0);
			}
			
		}
		
		
		return sumresult;
	}
	
	private static final int[][] D = {{0, 2, 5}, {3, 1, 7}, {3, 2, 2}, {1, 1, 7}, {1, 2, 2}};
	private static final int[][] delta = {{0,-1},{1,0},{0,1},{-1,0}};
	private static final int[][] diago = {{1,-1,10},{1,1,1},{-1,1,1},{-1,-1,10}};
	
	private static int tornado(int x, int y, int dir) {
		// 모래 흩날린다.
		int dx = x + delta[dir][0];
		int dy = y + delta[dir][1];
		
		if(x == 0 && y == 0) return 0;	//제일 마지막 0,0은 안한다.
		int a = map[dx][dy];
		map[dx][dy] = 0;
		
		int sum = 0;
		int remain = a;
		
		for(int i = 0 ; i < 5; i++) {
			int weight = a * D[i][2] / 100;
			remain -= weight;
			if(!add(dx + delta[(dir+D[i][0])%4][0]*D[i][1], dy + delta[(dir+D[i][0])%4][1]*D[i][1], weight)) {
				sum += weight;
			}
		}
		
		for(int i = 0 ; i < 4; i++) {
			int weight = a * diago[i][2] / 100;
			remain -= weight;
			if(!add(dx + diago[(dir+i)%4][0], dy + diago[(dir+i)%4][1], weight)) {
				sum += weight;
			}
		}
		// 비율이 적힌 칸으로 이동하지 않은 남은 모래의 양.
		if(!add(dx + delta[dir][0], dy + delta[dir][1], remain)) sum += remain;
		
		return sum;
	}
	
	private static boolean add(int x, int y, int v) {
		if(x >= 0 && x < N && y >= 0 && y < N) {
			map[x][y] += v;
			return true;
		}
		return false;
	}
}
