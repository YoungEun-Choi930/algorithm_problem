package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2141 {	//그리디
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][2];
		//long!!!!!!!
		long peoplecount = 0;
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			
			int x = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			
			map[i][0] = x;
			map[i][1] = a;
			peoplecount += a;
		}
		
		//sort 거리 가까운 순으로 정렬
		Arrays.sort(map, (o1,o2)-> {
			return o1[0] - o2[0];
		});
		
		//좌 우 사람이 똑같이 나누어지는 지점을 찾는다
		long sum = 0;
		peoplecount = (peoplecount+1)/2;	//홀수인경우 생각해줘야해서 +1하고 /2해야함
		int i = 0;
		for(; i < N; i++) {
			sum += map[i][1];
			if(sum >= peoplecount) {
				break;
			}
		}
		
		int minIndex = map[i][0];
		
		System.out.println(minIndex);
	}
}
