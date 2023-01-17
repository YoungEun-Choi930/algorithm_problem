package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2141 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			
			int x = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			
			map[i][0] = x;
			map[i][1] = a;
		}
		
		//sort
		Arrays.sort(map, (o1,o2)-> {
			return o2[1] - o1[1];
		});
		
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0 ; i < N ; i++) {
			int point = map[i][0];
			int sum = 0;
			for(int j = 0 ; j < N ; j ++) {
				int distance = Math.abs(point - map[j][0]);
				sum += distance * map[j][1];
				if(sum > min) break;
			}
			if(sum < min) {
				min = sum;
				minIndex = point;
			}
		}
		
		System.out.println(minIndex);
	}
}
