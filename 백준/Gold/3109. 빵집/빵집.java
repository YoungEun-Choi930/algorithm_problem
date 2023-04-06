import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static char[][] map;
	private static int R, C, result, ans;
	private static final int[][] delta = {{-1,1},{0,1},{1,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// solve
		for(int i = 0 ; i < R; i++) {
			connectpipe(i,0,0);
		}
		

		// 출력
		System.out.println(result);
	}
	
	
	
	
	private static boolean connectpipe(int x, int y, int cnt) {
		if(y == C-1) {	// 오른쪽 끝에 도달하면
			result++;
			return true;
		}
		
		//파이프 설치하기
		for(int i = 0 ; i < delta.length; i++) {
			if(x == 0 && y == 0) result = 0;	//초기화
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];
			
			if(dx < 0 || dy < 0 || dx >= R || dy >= C) continue;
			
			if(map[dx][dy] == '.') {
				map[dx][dy] = '-';
				if(connectpipe(dx, dy, cnt)) {//방문
					return true;
				}
			}
		}
		
		return false;
		
	}
}
 