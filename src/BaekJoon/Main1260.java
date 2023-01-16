package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1260 {
	private static int N,M,V;
	public static void main(String[] args) throws Exception{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sBuilder = new StringBuilder();
		
		String[] inputStrings = bReader.readLine().split(" ");
		N = Integer.parseInt(inputStrings[0]);
		M = Integer.parseInt(inputStrings[1]);
		V = Integer.parseInt(inputStrings[2]);
		
		boolean[][] graph = new boolean[N+1][N+1];
		for(int cnt = 0; cnt < M; cnt++) {
			inputStrings = bReader.readLine().split(" ");
			int node1 = Integer.parseInt(inputStrings[0]);
			int node2 = Integer.parseInt(inputStrings[1]);
			
			graph[node1][node2] = true;
			graph[node2][node1] = true;
		}
		
		visited = new boolean[N+1];
		sBuilder.append(DFS(graph, V));
		sBuilder.append("\n");
		Arrays.fill(visited, false);
		sBuilder.append(BFS(graph, V));
		
		System.out.println(sBuilder);
		
	}
	
	// dfs는 재귀랑 stack 2가지 방법이 있다!!!!
	private static boolean[] visited;
	private static String DFS(boolean[][] graph, int nodenum) {
		String resultString = nodenum + " ";
		visited[nodenum] = true;
		for(int i = 1; i <= N; i++) {
			if(graph[nodenum][i] && !visited[i]) {
				resultString += DFS(graph, i);
			}
		}
		return resultString;
	}
	
	//bfs가 queue로 구현!!!
	private static String BFS(boolean[][] graph, int startnum) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startnum);
		
		String resultString = "";
		
		while(!queue.isEmpty()) {
			int nodenum = queue.poll();
			
			if(visited[nodenum]) continue;
			
			resultString += nodenum + " ";
			visited[nodenum] = true;
			
			for(int i = 1 ; i <=N; i++) {
				if(graph[nodenum][i]) queue.add(i);
			}
		}
		
		return resultString;
	}
}
