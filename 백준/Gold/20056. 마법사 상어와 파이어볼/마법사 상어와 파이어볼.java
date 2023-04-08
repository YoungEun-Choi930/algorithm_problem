import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	private static class FireBall {
		int r, c, m, s, d;
		FireBall next;

		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}
	
	private static int N;
	private static final int[][] delta = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		
		Queue<FireBall> balls = new ArrayDeque<>();
		
		for(int i = 0 ; i < M ;i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]) - 1;
			int c = Integer.parseInt(input[1]) - 1;
			int m = Integer.parseInt(input[2]);
			int s = Integer.parseInt(input[3]);
			int d = Integer.parseInt(input[4]);
			
			balls.add(new FireBall(r, c, m, s, d));
		}
		
		for(int i = 0 ; i < K ; i++) {
			balls = turn(balls);
		}
		
		// 남아있는 파이어볼 질량의 합
		int result = sum(balls);
		
		System.out.println(result);
	}

	
	
	private static int sum(Queue<FireBall> balls) {
		int sum = 0;
		while(!balls.isEmpty()) {
			FireBall cur = balls.poll();
			
			sum += cur.m;
		}
		
		return sum;
	}



	private static Queue<FireBall> turn(Queue<FireBall> balls) {

		FireBall[][] map = new FireBall[N][N];
		// 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
		while(! balls.isEmpty()) {
			FireBall ball = balls.poll();
			int dr = ball.r + delta[ball.d][0] * ball.s;
			int dc = ball.c + delta[ball.d][1] * ball.s;
			
			if(dr < 0) dr = (dr + N*10000) % N;
			else if(dr >= N) dr %= N;
			if(dc < 0) dc = (dc + N*10000) % N;
			else if(dc >= N) dc %= N;
			
			ball.r = dr;
			ball.c = dc;
			
			if(map[dr][dc] == null) {
				map[dr][dc] = ball;
			}
			else {
				ball.next = map[dr][dc];
				map[dr][dc] = ball;
			}
		}
		
		// 2. 이동이 끝난 뒤, 2개 이상의 파이어 볼이 있는 곳을 확인한다.
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] != null) {
					int cnt = 0;
					int dir = 0;
					int ssum = 0;
					int msum = 0;
					for(FireBall cur = map[i][j] ; cur != null; cur = cur.next) {
						cnt++;
						if(cur.d % 2 == 0) dir = dir | 1;	//01
						else dir = dir | 2;					//10
						ssum += cur.s;
						msum += cur.m;
					}
					
					if(cnt >= 2) {
						msum /= 5;
						ssum /= cnt;
						
						if(msum == 0) continue;	//질량이 0인 파이어볼은 소멸되어 없어진다.
						
						// 파이어볼은 4개로 나누어진다.
						int d = 0;			//0 2 4 8
						if(dir == 3) d = 1;	// 1 3 5 7
						for( ; d < 8 ; d += 2) {
							balls.offer(new FireBall(i, j, msum, ssum, d));
						}
					}
					else if(cnt == 1) {
						balls.offer(map[i][j]);
					}
				}
			}
		}
		
		return balls;
	}
	
}
