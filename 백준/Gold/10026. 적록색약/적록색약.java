import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static char[][] map;
	private final static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// solve
		boolean[][] visited1 = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];
		int count1 = 0;
		int count2 = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				// 1. 적록색약이 아닐때
				if(!visited1[i][j]) {
					visit(i,j,visited1,false);
					count1++;
				}
				// 2. 적록색약일때
				if(!visited2[i][j]) {
					visit(i,j,visited2,true);
					count2++;
				}
			}
		}
		
		// 출력
		System.out.println(count1 + " " + count2);
	}
	
	private static void visit(int x, int y, boolean[][] visited, boolean GreenRed) {
		visited[x][y] = true;
		
		char cur = map[x][y];
		for(int i = 0 ; i < 4; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];
			
			if(dx >= 0 && dx < N && dy >= 0 && dy< N && !visited[dx][dy]) {
				if(map[dx][dy] == cur) {
					visit(dx,dy,visited,GreenRed);
				}
				else if(GreenRed && (cur == 'R' || cur == 'G') 
						&& (map[dx][dy] == 'R'||map[dx][dy] == 'G'))  {
					visit(dx,dy,visited,GreenRed);
				}
			}
		}
	}
}
