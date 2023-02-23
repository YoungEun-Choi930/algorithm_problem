package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main6987_G5_월드컵 {
	private static int[][] scores;
	static List<int[]> verselist;
	private static int verseSize;
	private static int[] comnum;
	private final static int[][] ind = {{0,2},{1,1},{2,0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// verselist 초기화
		verselist = new ArrayList<>();
		comnum = new int[2];
		permutation(0,0);
		verseSize = verselist.size();

		// 입력파일 객체화
		for(int t = 0 ; t < 4; t ++) {
			boolean flag = true;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			scores = new int[6][3];
			for(int i = 0 ; i < 6 ; i++) {
				scores[i][0] = Integer.parseInt(st.nextToken());
				scores[i][1] = Integer.parseInt(st.nextToken());
				scores[i][2] = Integer.parseInt(st.nextToken());
				
				if(scores[i][0]+scores[i][1]+scores[i][2] != 5) flag = false;
			}

			//solve
			
			if(flag)
				flag = play(0);
			
			
			if(flag) sb.append("1 ");
			else sb.append("0 ");
		}
		// 출력
		System.out.println(sb);
	}
	
	private static boolean confirm() {
		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 0 ; j < 3; j++) {
				if(scores[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean play(int index) {
//		System.out.println(countryA + " : "+ countryB);
		if(index == verseSize) {
			return confirm();
		}
		
		int countryA = verselist.get(index)[0];
		int countryB = verselist.get(index)[1];
		
		for(int i = 0 ;i < 3; i++) {
			int a = scores[countryA][ind[i][0]];
			int b = scores[countryB][ind[i][1]];
			if(a > 0 && b > 0) {
//				System.out.println(i+"--");
				scores[countryA][ind[i][0]]--;
				scores[countryB][ind[i][1]]--;
				if(play(index+1)) return true;

				scores[countryA][ind[i][0]]++;
				scores[countryB][ind[i][1]]++;
			}
		}
		return false;
	}
	
	private static void permutation(int index, int cnt) {
		if(cnt == 2) {
			verselist.add(Arrays.copyOf(comnum, cnt));
			return;
		}
		
		for(int i = index; i < 6; i++) {
			comnum[cnt] = i;
			permutation(i+1, cnt+1);
		}
	}
}
