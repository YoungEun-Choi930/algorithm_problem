import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//서로소 집합
public class Solution {

	private static int N;
	private static int[] parents;
	
	// 단위 집합 생성
	private static void makeSet() {
		parents = new int[N+1];
		
//		for(int i = 1 ; i <= N ; i++) {
//			parents[i] = i;
//		}
	}
	
	private static int findSet(int a) {
		if(parents[a] == 0) return a;
//		if(parents[a] == a)
//			return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	private static int isSameParent(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot)
			return 1;
		
		return 0;
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot)
			return false;
		
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			makeSet();
			for(int i = 0 ; i < M ; i++) {
				input = br.readLine().split(" ");
				int oper = input[0].charAt(0)-'0';
				int a = Integer.parseInt(input[1]);
				int b = Integer.parseInt(input[2]);
				
				if(oper == 0) {
					union(a,b);
				}
				else if(oper == 1) {
					int r = isSameParent(a,b);
					sb.append(r);
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}