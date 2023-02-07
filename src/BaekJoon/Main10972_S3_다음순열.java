package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main10972_S3_다음순열 {
	private static int N;
	private static List<int[]> sortingList;
	private static boolean[] isChecked;
	private static int[] resultArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력파일 객체화
		N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		/**
		 * 알고리즘 풀기
		 * 현재 array의 다음번에 오는 순열을 구하면 되니까
		 * 1. 오른쪽에서부터 (왼 < 오)가 되는 index를 찾는다
		 * 	    동시에 index 보다 앞에있는 숫자들은 checked처리해준다.
		 * 1-1. 없으면 -1 출력
		 * 2. 있으면 해당 index부터 숫자들 sorting해서 list에 넣는다.
		 * 	  list에서 입력받은 array의 index를 알아내고,
		 *    그 다음 index의 array를 결과로 출력한다.
		 *    
		 * N이 10_000까지 올 수 있으니까 원래 순열 구하던 대로 
		 * 경우의 수 다 저장하고 찾는다면 최악의경우 10000!.
		 * 
		 * 그냥 Arrays.copyOf 로 list에 넣고, list.indexOf로 찾으려고 했는데
		 * 값이 안찾아졌다. 아마 얕은복사 때문이지 않을까
		 */
		
		isChecked = new boolean[N+1];
		Arrays.fill(isChecked, true);
		int index = 0;
		for(index = N-1 ; index > 0 ; index--) {
			isChecked[array[index]] = false;
			
			if(array[index-1] < array[index]) {
				isChecked[array[index-1]] = false;
				break;
			}
		}
		
		if(index == 0) {	// 내림차순으로 정렬되어있는 경우
			sb.append("-1");
		}
		else {
			resultArray = Arrays.copyOf(array, N);
			sortingList = new ArrayList<int[]>();
			System.out.println(index-1);
			setList(index-1);
			
			int result = sortingList.indexOf(array);
			int[] resultlist = sortingList.get(result+1);
			System.out.println(result);
			
			for(int i = 0 ; i < N ; i++) {
				sb.append(resultlist[i]).append(" ");
			}
		}
		

		/**
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}
	
	private static void setList(int cnt) {
		
		if(cnt == N) {
			sortingList.add(resultArray.clone());
			return;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			if(isChecked[i]) continue;
			
			isChecked[i] = true;
			resultArray[cnt] = i;
			setList(cnt+1);
			
			isChecked[i] = false;
		}
	}
	
}
