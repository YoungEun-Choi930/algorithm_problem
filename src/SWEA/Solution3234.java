package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3234 {
	public static void main(String[] args) throws Exception{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sBuilder = new StringBuilder();
		
		int T = Integer.parseInt(bReader.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sBuilder.append("#").append(tc).append(" ");
			int N = Integer.parseInt(bReader.readLine());
			
			int[] array = new int[N];
			String[] inputStrings = bReader.readLine().split(" ");
			
			for(int i = 0 ; i < N; i++) {
				array[i] = Integer.parseInt(inputStrings[i]);
			}
			
			//solve
			Arrays.sort(array);
			
			//순서바꾸기
			Set<int[]> orderedList = makeOrderedList(array);
			
			
			//give up!!!!!!
			
			
			sBuilder.append(false).append("\n");
 		}
		
		System.out.println(sBuilder);
	}
	
	private static Set<int[]> makeOrderedList(int[] array) {
		Set<int[]> orderList = new HashSet<int[]>();
		orderList.add(array);
		
		for(int i = 0 ; i < array.length; i++) {
			
		}
		
		
		
		return orderList;
	}
}
