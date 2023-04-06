import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[102][102];
		
		// 입력 자연수니까 1부터, 100이하. 
		for(int n = 0 ; n < N; n++) {
			String[] input = br.readLine().split(" ");
			int y = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			
			for(int i = x ; i < x+10; i++) {
				for(int j = y ; j < y+10; j++) {
					map[i][j] = true;
				}
			}
		}
		// ======================================
		// solve
		/*
		 * 가로방향, 세로방향으로 한번씩 확인해준다.
		 * 만약 좌/우가 상/하가 다른 색깔이라면 길이를 +1 추가해준다.
		 */
		int length = 0;
		
		for(int i = 0 ; i < 102; i++) {
			for(int j = 1 ; j < 102; j++) {
				
				if(map[i][j-1] != map[i][j]) {
					length++;
				}
				
				if(map[j-1][i] != map[j][i]) {
					length++;
				}
			}
		}
		
		
		System.out.println(length);
		
	}
}