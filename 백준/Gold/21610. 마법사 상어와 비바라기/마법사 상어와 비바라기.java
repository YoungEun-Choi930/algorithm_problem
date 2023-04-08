import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static int N;
	private static int[][] map;
	private static final int[][] delta = {{},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	private static List<int[]> cloudlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		getMap(br);
		
		int result = moveMandgetSumResult(M, br);
		
		System.out.println(result);
 	}
	private static void getMap(BufferedReader br) throws IOException {
		map = new int[N][];
		for(int i = 0 ; i < N ; ++i) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}

	private static int moveMandgetSumResult(int m, BufferedReader br) throws IOException {
		cloudlist = new ArrayList<int[]>();
		cloudlist.add(new int[] {N-1,0});
		cloudlist.add(new int[] {N-1,1});
		cloudlist.add(new int[] {N-2,0});
		cloudlist.add(new int[] {N-2,1});
		
		String input;
		for(int i = 0 ; i < m ; ++i) {
			input = br.readLine();
			int d = input.charAt(0) - '0';
			int s = Integer.parseInt(input.substring(2));
			
			bibaragi(d,s);
		}
		
		return getSumWater();
	}
	
	private static int getSumWater() {
		int sum = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] > 0) sum += map[i][j];
			}
		}
		
		return sum;
	}

	private static void bibaragi(int d, int s) {
		// 구름이 생긴다. 이동한다
		// 구름이 있는 칸의 물 양이 +1
		moveCloudAddWater1(d, s);
		
		// 물이 증가한 칸에 물복사버그마법.
		copyWaterMagic();
		
		// 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고 물의 양이 2 줄어든다.
		// 이때 처음 구름이 생긴 칸 제외.
		removeWaterMorethan2();
		
	}
	
	private static void moveCloudAddWater1(int d, int s) {
		if( s > N ) s = s % N;
		
		for(int[] cloud : cloudlist) {
			cloud[0] += delta[d][0] * s;
			cloud[1] += delta[d][1] * s;
			
			if(cloud[0] >= N) cloud[0] %= N;
			else if(cloud[0] < 0) cloud[0] = (cloud[0] + N) % N;
			if(cloud[1] >= N) cloud[1] %= N;
			else if(cloud[1] < 0) cloud[1] = (cloud[1] + N) % N;
			
			map[cloud[0]][cloud[1]] ++;
		}
	}
	
	private static void copyWaterMagic() {
		//대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
		
		for(int[] cloud : cloudlist) {
			
			int x = cloud[0];
			int y = cloud[1];
			int cnt = 0;
			
			for(int j = 2 ; j <= 8 ; j+=2) {
				int dx = x + delta[j][0];
				int dy = y + delta[j][1];
				
				if(dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if(map[dx][dy] > 0) cnt++;
				}
			}
			
			map[x][y] += cnt;
		}
	}
	
	private static void removeWaterMorethan2() {
		// 구름이 모두 사라지고 새로운 구름
		List<int[]> newlist = new ArrayList<int[]>();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] < 2) continue;
				
				boolean flag = false;
				for(int[] cloud : cloudlist) {
					if(i == cloud[0] && j == cloud[1]) flag = true;
				}
				if(flag) continue;
				
				map[i][j] -= 2;
				newlist.add(new int[] {i,j});
			}
		}
		
		cloudlist = null;
		cloudlist = newlist;
	}

}
