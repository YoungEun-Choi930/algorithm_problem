package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2751 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//기존 arr받아서 Arrays.sort하고 출력하는건 시간초과남.(2750)
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i = 0 ; i < N ; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			sb.append(queue.poll()+"\n");
		}
		System.out.println(sb);
	}
}
