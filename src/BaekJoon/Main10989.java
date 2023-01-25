package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10989 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//기존 queue방법으로는 메모리 초과가 나기때문에 새로운 방법으로 해야함.(2751)
		//counting sort!!!! 처음 보는 개념
		int N = Integer.parseInt(br.readLine());
		int[] countMap = new int[10001];
		for(int i = 0 ; i < N ; i++) {
			int a = Integer.parseInt(br.readLine());
			countMap[a]++;
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int num = 0; num < 10001 ; num++) {
			int c = countMap[num];
			if(c == 0) continue;
			else {
				for(int i = 0 ; i < c; i++) {
					sb.append(num).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}