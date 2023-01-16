package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2606 {
	public static void main(String[] args) throws Exception{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int T = Integer.parseInt(bReader.readLine());
		int[][] graph = new int[T+1][T+1];
		
		int link = Integer.parseInt(bReader.readLine());
		for(int cnt = 0; cnt < link; cnt++) {
			String[] input = bReader.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);
			
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}
		
		//solve
		boolean[] node_list = new boolean[T+1];
		Stack<Integer> infection_list = new Stack<>();
		infection_list.push(1);
		
		while(!infection_list.isEmpty()) {
			int node = infection_list.pop();
			
			if(node_list[node]) continue;	//이미 감염되었으면
			
			//감염 안되었으면
			node_list[node] = true;
			
			for(int i = 0 ; i <= T; i++) {
				if(graph[node][i] == 1) {
					infection_list.push(i);
				}
			}
			
		}
		
		
		//result
		int result = 0;
		for(boolean r :node_list) {
			if(r) result++;
		}
		
		System.out.println(result-1);
		
		
		
	}
	
}
