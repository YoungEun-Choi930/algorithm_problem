package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1247_D5_최적경로 {
	
	private static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	private static List<int[]> visitOrder;
	private static int[] numbers;
	private static boolean[] isVisited;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());	//2≤N≤10
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Point[] people = new Point[N];
			
			//회사
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point start = new Point(x,y);
			
			//집
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Point end = new Point(x,y);
			
			//고객
			for(int i = 0 ; i < N ; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				people[i] = new Point(x,y);
			}
			
			//solve np
			numbers = new int[N];
			for(int i = 0 ; i < N ; i++ ) {
				numbers[i] = i;
			}
			
			
			
			int minDistance = Integer.MAX_VALUE;
			do {
//				System.out.println(Arrays.toString(numbers));
				
				int sumDistance = 0;
				
				Point p = people[numbers[0]];
				sumDistance += distance(start, p);
				for(int idx = 1 ; idx < N ; idx++) {
					Point p1 = people[numbers[idx-1]];
					Point p2 = people[numbers[idx]];
					
					sumDistance += distance(p1, p2);
				}
				p = people[numbers[N-1]];
				sumDistance += distance(end, p);
				
				
				if(sumDistance < minDistance) minDistance = sumDistance;
				
				
			}while(np(numbers));
			
			
			/*
			// solve
			// 1. 방문 순서를 구한다.
			visitOrder = new ArrayList<>();
			numbers = new int[N];
			isVisited = new boolean[N];
			Permutation(0);
			
			
			// 2. 방문 순서에 따른 거리를 구한다.
			int minDistance = Integer.MAX_VALUE;
			for(int[] order : visitOrder) {
				int sumDistance = 0;
				
				Point p = people[order[0]];
				sumDistance += distance(start, p);
				for(int idx = 1 ; idx < N ; idx++) {
					Point p1 = people[order[idx-1]];
					Point p2 = people[order[idx]];
					
					sumDistance += distance(p1, p2);
				}
				p = people[order[N-1]];
				sumDistance += distance(end, p);
				
				
				if(sumDistance < minDistance) minDistance = sumDistance;
			}
			*/
			
			// output
			sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int distance(Point p1, Point p2) {
		int dx = p1.x - p2.x;
		if(dx < 0) dx = p2.x - p1.x;
		
		int dy = p1.y - p2.y;
		if(dy < 0) dy = p2.y - p1.y;
		
		return dx + dy;
	}

//	private static void Permutation(int count) {
//		if(count == N) {
//			visitOrder.add(Arrays.copyOf(numbers, N));
//			return;
//		}
//		
//		for(int i = 0 ; i < N ; i++) {
//			if(isVisited[i]) continue;
//			
//			isVisited[i] = true;
//			numbers[count] = i;
//			Permutation(count+1);
//			isVisited[i] = false;
//		}
//	}
	

	private static boolean np(int[] input) {
		
		// 1.
		int n = input.length;
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) i--;
		
		if(i == 0) {
			return false;
		}
		
		// 2.
		int j = n-1;
		while(input[i-1] >= input[j]) --j;
		
		// 3.
		swap(input, i-1,j);
		
		// 4.
		int k = n-1;
		while(i < k) {
			swap(input, i++, k--);
		}
		
		
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
