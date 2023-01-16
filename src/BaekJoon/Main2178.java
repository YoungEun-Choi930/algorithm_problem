package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2178 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		char[][] map = new char[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//solve
		/*
		 * 1 : 이동가능. 0: 이동불가
		 * (0,0) -> (N-1,M-1)
		 * bfs로 풀면 되겠다!
		 */
		
		int result = solve(map, N, M);
		
		System.out.println(result);
	}
	
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	
	private static int solve(char[][] map, int N, int M) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(0,0,1));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			int c = p.cnt;

			//System.out.println("("+x+","+y+")"+c);
			//도착
			if(x == N-1 && y == M-1) {
				return c;
			}
			
			
			for(int i = 0 ; i < 4; i++) {
				int movex = x+dx[i];
				int movey = y+dy[i];
				if(movex < 0 || movex >=N || movey < 0 || movey >= M)
					continue;
				
				char value = map[movex][movey];
				if(value == '0') continue;	//벽이면 못감
				else if(value == '2') continue; //이미 지나온 길
				
				queue.offer(new Point(x+dx[i], y+dy[i], c+1));
				map[x+dx[i]][y+dy[i]] = '2';
			}
		}
		return -1;
		
	}
	
	static class Point {
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.cnt = c;
		}
		
	}
	
}

