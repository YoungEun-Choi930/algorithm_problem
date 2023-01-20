package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1926 {
	private static char[][] paint;
	private static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//input
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		paint = new char[N][M];
		for(int i = 0; i < N ; i++) {
			paint[i] = br.readLine().replace(" ", "").toCharArray();
		}
		
		//solve
		//bfs.
		int count = 0;
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(paint[i][j] == '1') {
					count++;
					max = Math.max(max, draw(i,j));
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}
	
	private static int[][] delta = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	private static int draw(int x, int y) {
		Queue<Pointer> queue = new LinkedList<>();
		queue.add(new Pointer(x,y));
		
		paint[x][y] = '2';
		
		int count = 1;
		while(!queue.isEmpty()) {
			Pointer p = queue.poll();
			x = p.x;
			y = p.y;
			
			for(int index = 0 ; index < delta.length; index++) {
				int dx = x + delta[index][0];
				int dy = y + delta[index][1];
				
				if(dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				else if(paint[dx][dy]=='0')
					continue;
				else if(paint[dx][dy] == '1'){
					queue.add(new Pointer(dx, dy));
					paint[dx][dy] = '2';
					count++;
				}
			}
			
		}
		return count;
	}
	
	
}

class Pointer {
	int x;
	int y;
	public Pointer(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}


