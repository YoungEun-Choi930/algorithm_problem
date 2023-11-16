import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int paperM1 = 0;
	private static int paper0 = 0;
	private static int paper1 = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		countPaper(N, 0,0,map);
		System.out.println(paperM1+"\n"+paper0+"\n"+paper1);
	}

	private static void countPaper(int length, int startX, int startY, int[][] map) {
		// 1. 같은지 검사
		int prev = map[startX][startY];
		boolean flag = true;
		
		loop : for(int i = startX, endi = startX+length ; i < endi ; i++) {
			for(int j = startY, endj = startY+length ; j < endj ; j++) {
				if(prev != map[i][j]) {
					flag = false;
					break loop;
				}
			}
		}
		
		// 같으면 count
		// 기저조건. length가 1이면 무조건 flag는 true
		if(flag) {
			if(prev == -1) paperM1++;
			else if(prev == 0) paper0++;
			else paper1++;
			return;
		}
		
		// 2. 같지않다면 9등분으로 나누기
		int L = length/3;
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				countPaper(L, startX + i*L , startY + j*L , map);
			}
		}
	}

}
