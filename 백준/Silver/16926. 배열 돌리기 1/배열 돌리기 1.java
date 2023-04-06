import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);	//2 ≤ N, M ≤ 300
		int M = Integer.parseInt(input[1]);
		int R = Integer.parseInt(input[2]);	//1 ≤ R ≤ 1,000
		
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			map[i] = Arrays.stream(input).mapToInt(s->Integer.parseInt(s)).toArray();
		}
		
		// solve
		
		/*
		 * 1. R에대한 최적화 필요.
		 * 회전 크기: 가로길이*2+세로길이*2 -4.
		 * 회전 수 = R % 크기.
		 * 
		 * 2. 회전은 어떻게 할껀데.
		 * result배열을 만들어 놓고. 회전 수만큼 이동한 칸에 저장.
		 * 3. 이동? 델타로?
		 * 시작 위치에따라서 델타 시작이 달라지겠다.
		 * 
		 * 0. 네모상자가 몇개 나오는가.
		 * min(N,M)/2개 만큼.
		 */
		
		// 0.
		int[][] result = new int[N][M];
		int square = Math.min(N, M) /2;
		
		int[][] delta = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
		
		for(int depth = 0; depth < square; depth++) {
			// 1.
			int size = (N-2*depth)*2 + (M-2*depth)*2 - 4;
			int spin = R % size;
			
			int curX = depth;
			int curY = depth;
			int curD = 0;
			// 2. 현재 네모의 숫자만큼.
			for(int i = 0 ; i < size ; i++) {
				
				//이동할 칸 찾기
				int spinD = -1;	//이동해야 할 방향
				if(curY == depth)
					spinD = 0;
				if(curX == N-depth-1)	//curY == depth면서 curX == N-depth-1이면 1니까
					spinD = 1;
				if(curY == M-depth-1)
					spinD = 2;
				if(curX == depth)
					spinD = 3;
				if(curX == depth && curY == depth)
					spinD = 0;
				
				//이동해서 result에 넣기
				int moveX = curX;
				int moveY = curY;
				int tspin = spin;	//temp
				while(tspin > 0) {
					moveX = moveX + delta[spinD][0];
					moveY = moveY + delta[spinD][1];
					
					if(moveX == N-depth-1 && moveY == depth) {
						spinD = 1;
					}
					else if(moveX == N-depth-1 && moveY == M-depth-1) {
						spinD = 2;
					}
					else if(moveX == depth && moveY == M-depth-1) {
						spinD = 3;
					}
					else if(moveX == depth && moveY == depth) {
						spinD = 0;
					}
					tspin--;
				}
				
				//저장
				result[moveX][moveY] = map[curX][curY];
				
				
				//현재 좌표 이동
				curX += delta[curD][0];
				curY += delta[curD][1];
				
				if(curX == N-depth-1 && curY == depth) {
					curD = 1;
				}
				else if(curX == N-depth-1 && curY == M-depth-1) {
					curD = 2;
				}
				else if(curX == depth && curY == M-depth-1) {
					curD = 3;
				}
				else if(curX == depth && curY == depth) {
					curD = 0;
				}
				
			}
			
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		

		// 출력
		System.out.println(sb);
	}
}
