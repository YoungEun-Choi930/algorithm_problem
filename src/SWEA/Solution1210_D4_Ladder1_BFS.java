package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1210_D4_Ladder1_BFS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();	//tc
			
			//100x100
			char[][] map = new char[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				map[i] = br.readLine().replace(" ", "").toCharArray();
			}
			
			
			//solve
			
			// 1. 마지막 라인에서 출발 위치 찾기
			int start = -1;
			for(int i = 0 ; i < 100; i++) {
				if(map[99][i] == '2') {
					start = i;
					break;
				}
			}
			
			// 좌, 우 를 위로 가는것보다 먼저.
			int[][] delta = new int[][] {{0,-1},{0,1},{-1,0}};
			int result = -1;
			// 2. BFS
			Queue<Point1> queue = new LinkedList<Point1>();
			queue.offer(new Point1(99,start));
			
			while(!queue.isEmpty()) {
				Point1 cur = queue.poll();
				if(cur.x == 0) {
					result = cur.y;
					break;
				}
				
				//이동
				for(int d = 0 ; d < 3 ; d++) {
					int dx = cur.x + delta[d][0];
					int dy = cur.y + delta[d][1];
					
					// 길이 있으면 방문.
					if(dy >=0 && dy < 100 && map[dx][dy] == '1') {
						//방문처리
						map[dx][dy] = '3';
						queue.offer(new Point1(dx,dy));
						//방문하면 바로 끝내야함.
						break;
					}
				}
				
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}

class Point1 {
	int x;
	int y;
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
