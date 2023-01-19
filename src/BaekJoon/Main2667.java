package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main2667 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i = 0 ; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//solve
		//bfs.
		int count = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N ;j++) {
				if(map[i][j] == '1') {
					count++;
					arr.add(visit(i,j));
				}
			}
		}
		
		Collections.sort(arr);
		
		
		System.out.println(count);
		for(Integer a : arr) {
			System.out.println(a);
		}
		
		
	}
	private static int N;
	private static char[][] map;
	private static int[] deltaX = {-1,1,0,0};
	private static int[] deltaY = {0,0,-1,1};
	
	private static int visit(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x,y));
		map[x][y] = '0';
		int count = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int dx = p.x;
			int dy = p.y;
			
			for(int i = 0 ; i < 4; i++) {
				int movex = dx + deltaX[i];
				int movey = dy + deltaY[i];
				
				if(movex < 0 || movey < 0 || movex >= N || movey >= N)
					continue;
				
				if(map[movex][movey] == '1') {
					map[movex][movey] = '0';
					count++;
					queue.add(new Point(movex, movey));
				}
			}
		}
		
		return count;
	}
	
	
}
class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
