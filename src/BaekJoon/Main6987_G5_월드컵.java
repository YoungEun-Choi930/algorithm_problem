package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6987_G5_월드컵 {
	private static int[] inputw, inputd, inputl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		for(int i = 0 ; i < 4; i ++) {
			boolean flag = true;
			String[] input = br.readLine().split(" ");

			inputw = new int[6];
			inputd = new int[6];
			inputl = new int[6];
			map = new int[6][6];
			int sumw = 0;
			int suml = 0;
			int a = 0;
			for(int j = 0 ; j < 18 ; j = j+3, a++) {
				int w = Integer.parseInt(input[j]);
				int d = Integer.parseInt(input[j+1]);
				int l = Integer.parseInt(input[j+2]);
				inputw[a] = w;
				inputd[a] = d;
				inputl[a] = l;

				sumw += w;
				suml += l;

				if(w+d+l != 5) {
					flag = false;
					break;
				}
			}

			//solve
			// 1. 승과 패의 수는 같아야 한다.
			if(sumw != suml) flag = false;

			// 2. 무승부의 수가 매치가 되어야 한다.
			if(flag) {
				flag = confirmDraw(inputd);
			}

			// 3. 한 팀의 승이 5면 나머지 팀은 적어도 패가 1이 1개이상 있어야 한다.
			if(flag) {
				flag = confirm(0);
			}

			if(flag) sb.append("1 ");
			else sb.append("0 ");
			
			
		}
		// 출력
		System.out.println(sb);
	}

	private static boolean confirmDraw(int[] arrd) {
		// 1. 무승부 확인하기
		int cnt = 0;
		for(int idx = 0 ; idx < 6; idx++) {
			if(cnt == 0) cnt += arrd[idx];
			else cnt -= arrd[idx];
		}
		if(cnt != 0) return false;
		return true;


	}

	private static int[][] map = new int[6][6];
	
	private static boolean confirm(int idx) {
		if(idx == 6) {
			return true;
		}
		int w = inputw[idx];
		int d = inputd[idx];
		int l = inputl[idx];

		int cntw = 0;
		int cntl = 0;
		int cntd = 0;
		int temp = 0;
		for(int j = 0 ; j < 6; j++) {
			if(map[idx][j] == 1) cntw++;
			else if(map[idx][j] == -1) cntl++;
			else if(map[idx][j] == 2) cntd++;
			else temp++;
		}
		if(cntw > w || cntl > l || cntd > d) return false;

		temp--;

		//만약 승5,무5,패5라면
		if(w == 5 || l == 5 || d == 5) {
			int t = 0;
			int f = 0;
			if(w == 5) {
				t = 1; 
				f = -1;
			}
			if(l == 5) {
				t = -1; 
				f = 1;
			}
			if(d == 5) {
				t = 2;
				f = 2;
			}

			for(int j = 0 ;j < 6 ; j++) {
				if(idx != j) {
					int n1 = map[idx][j];
					int n2 = map[j][idx];

					if(n1 != t && n1 != 0) return false;
					else map[idx][j] = t;

					if(n2 != f && n2 != 0) return false;
					else map[j][idx] = f;
				}
			}
		}

		// 비어있는칸이랑 이긴 수, 진 수가 같으면
		if(w == temp || l == temp || d == temp) {
			int t = 0;
			int f = 0;
			if(w == temp) {
				t = 1; 
				f = -1;
			}
			if(l == temp) {
				t = -1; 
				f = 1;
			}
			if(d == temp) {
				t = 2;
				f = 2;
			}

			for(int j = 0 ;j < 6 ; j++) {
				if(idx != j && map[idx][j] == 0) {

					map[idx][j] = t;
					map[j][idx] = f;
				}
			}
		}
		return confirm(idx+1);

	}
	/*
	private static boolean confirmWinLose(int[] arrw, int[] arrd, int[] arrl) {
		// 2. 승 패 확인하기
		int[][] map = new int[6][6];
		for(int idx = 0 ; idx < 6; idx ++) {
			int w = arrw[idx];
			int d = arrd[idx];
			int l = arrl[idx];


			// 현재 들어있는 값이랑 map에서 count값이랑 같은지
			int cntw = 0;
			int cntl = 0;
			int cntd = 0;
			for(int j = 0 ; j < 6; j++) {
				if(map[idx][j] == 1) cntw++;
				else if(map[idx][j] == -1) cntl++;
				else if(map[idx][j] == 2) cntd++;
			}
			if(cntw > w || cntl > l || cntd > d) return false;

			//만약 승5,무5,패5라면
			if(w == 5 || l == 5 || d == 5) {
				int t = 0;
				int f = 0;
				if(w == 5) {
					t = 1; 
					f = -1;
				}
				if(l == 5) {
					t = -1; 
					f = 1;
				}
				if(d == 5) t = 2;

				for(int j = 0 ;j < 6 ; j++) {
					if(idx != j) {
						int n1 = map[idx][j];
						int n2 = map[j][idx];

						if(n1 != t && n1 != 0) return false;
						else map[idx][j] = t;

						if(n2 != f && n2 != 0) return false;
						else map[j][idx] = f;
					}
				}
			}


		}

		return true;
	}
	 */
}
