package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5644_무선충전 {

	private static int[][] BC;
	private static int ans, M, A;
	private static final int[][] delta = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// input, init
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			int[] personA = new int[M];
			int[] personB = new int[M];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < M ; i++) {
				personA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < M ; i++) {
				personB[i] = Integer.parseInt(st.nextToken());
			}
			
			BC = new int[A][4];
			for(int i = 0 ; i < A; i++) {
				st = new StringTokenizer(br.readLine()," ");
				BC[i][0] = Integer.parseInt(st.nextToken());	//x
				BC[i][1] = Integer.parseInt(st.nextToken());	//y
				BC[i][2] = Integer.parseInt(st.nextToken());	//c
				BC[i][3] = Integer.parseInt(st.nextToken());	//p
			}
			// ====================================================
			// solve
			ans = 0;
			
			int Ax = 1, Ay = 1, Bx = 10, By = 10;
			// 초기위치에서 확인
			Charge(Ax, Ay, Bx, By);
			
			//이동하면서 확인
			for(int time = 0 ; time < M ; time++) {
				// move
				Ax += delta[personA[time]][0];
				Ay += delta[personA[time]][1];
				Bx += delta[personB[time]][0];
				By += delta[personB[time]][1];
				
				System.out.println(time+"==move== "+Ax+","+Ay+" | "+Bx+","+By);
				// 이동한 자리에 BC가 있는지 확인
				Charge(Ax, Ay, Bx, By);
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void Charge(int Ax, int Ay, int Bx, int By) {
		int pA = 0, pB = 0;
		int idxA = -1, idxB = -1;
		boolean both = false;
		int sum = 0;
		for(int bc = 0 ; bc < A ; bc++) {
			boolean a = isBCRange(bc, Ax, Ay);
			boolean b = isBCRange(bc, Bx, By);
			int curp = BC[bc][3];
			if(a&&b) {	//동시에 충전하면 반반 나눠가진다.
				if(pA > curp/2) a = false;
				if(pB > curp/2) b = false;
				
				if(a&&b) {
					curp /= 2;
					pA = pB = curp;
					idxA = idxB = bc;
					both = true;
					a = b = false;
				}
			}
			if(a && pA < curp) {	//충전기 2개중에 성능 좋은곳 선택
				pA = curp;
				idxA = bc;
				if(both) {
					pB = BC[idxB][3];
					both = false;
				}
				System.out.println("charge A "+ bc + " : "+ curp);
			}
			if(b && pB < curp) {	//충전기 2개중에 성능 좋은곳 선택
				pB = curp;
				idxB = bc;
				if(both) {
					pA = BC[idxA][3];
					both = false;
				}
				System.out.println("charge B "+ bc + " : "+ curp);
			}
		}
		//충전량 다시 구하기.
//		if(idxA != -1) pA = BC[idxA][3];
//		if(idxB != -1) pB = BC[idxB][3];
//		if(idxA != -1 && idxA == idxB) {
//			pA /= 2;
//			pB /= 2;
//		}
		ans += pA + pB;
	}
	
	private static boolean isBCRange(int bc, int x, int y) {
		return Math.abs(BC[bc][1]-x)+Math.abs(BC[bc][0] -y) <= BC[bc][2];
	}
}
