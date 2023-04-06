import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static class CCTV {
		int x, y, number;

		public CCTV(int x, int y, int number) {
			super();
			this.x = x;
			this.y = y;
			this.number = number;
		}
		
	}
	
	private static char[][] map;
	private static List<CCTV> cctvList;
	private static int N, M, obCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);	// (1 ≤ N, M ≤ 8)
		M = Integer.parseInt(input[1]);
		
		map = new char[N][M];
		cctvList = new ArrayList<>();
		List<CCTV> cctvList5 = new ArrayList<>();
		int emptyCnt = 0;
		for(int i = 0 ; i < N ; i++) {
			String in = br.readLine().replace(" ", "");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = in.charAt(j);
				if(map[i][j] >= '1' && map[i][j] <= '4') {
					cctvList.add(new CCTV(i,j,map[i][j]-'0'));
				}
				else if(map[i][j] == '5') cctvList5.add(new CCTV(i,j,map[i][j]));
				else if(map[i][j] == '0') emptyCnt++;
			}
		}
		// =============================================
		// solve
		
		//1. 5번 cctv 체크
		int cnt = 0;
		for(CCTV cctv : cctvList5) {
			for(int i = 0 ; i < 4; i++) {
				cnt += observe(cctv.x, cctv.y, i);
			}
		}
		emptyCnt -= cnt;
		
		// 2. 1~4 cctv 회전
		obCnt = 0;
		dfs(0,0);
		emptyCnt -= obCnt;
		

		// 출력
		System.out.println(emptyCnt);
	}
	
	
	private static void dfs(int curcc, int cnt) {
		if(curcc == cctvList.size()) {
			if(obCnt < cnt) obCnt = cnt;
			return;
		}
		
		char[][] tempmap = copy(map);
		CCTV curCCTV = cctvList.get(curcc);
		int number = curCCTV.number;
		if(number == 1) {
			for(int i = 0 ; i < 4; i++) {
				// 감시 구역 색칠.
				int n = observe(curCCTV.x, curCCTV.y, i);
				dfs(curcc+1, cnt + n);
				// 되돌리기
				map = copy(tempmap);
			}
		}
		else if(number == 2) {
			for(int i = 0 ; i < 2; i++) {
				// 감시 구역 색칠.
				int n1 = observe(curCCTV.x, curCCTV.y, i);
				int n2 = observe(curCCTV.x, curCCTV.y, i+2);
				dfs(curcc+1, cnt + n1+n2);
				// 되돌리기
				map = copy(tempmap);
			}
		}
		else if(number == 3) {
			for(int i = 0 ; i < 4; i++) {
				// 감시 구역 색칠.
				int n1 = observe(curCCTV.x, curCCTV.y, i%4);
				int n2 = observe(curCCTV.x, curCCTV.y, (i+1)%4);
				dfs(curcc+1, cnt + n1+n2);
				// 되돌리기
				map = copy(tempmap);
			}
		}
		else if(number == 4) {
			for(int i = 0 ; i < 4; i++) {
				// 감시 구역 색칠.
				int n1 = observe(curCCTV.x, curCCTV.y, i%4);
				int n2 = observe(curCCTV.x, curCCTV.y, (i+1)%4);
				int n3 = observe(curCCTV.x, curCCTV.y, (i+2)%4);
				dfs(curcc+1, cnt + n1+n2+n3);
				// 되돌리기
				map = copy(tempmap);
			}
		}
		
	}
	
	private static final int[][] deltaxy = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	private static char[][] copy(char[][] arr) {
		char[][] copymap = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			copymap[i] = Arrays.copyOf(arr[i], M);
		}
		return copymap;
	}

	private static int observe(int x, int y, int d) {
		int count = 0;
		while(true) {
			x += deltaxy[d][0];
			y += deltaxy[d][1];
			
			if(x < 0 || y < 0 || x >= N || y >= M) break;
			if(map[x][y] == '6') break;
			
			else if(map[x][y] == '0'){
				map[x][y] = '#';
				count++;
			}
		}
		
		return count;
	}
	
}
