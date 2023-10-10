import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int[][] delta;
	
	private static void makeDelta() {
		delta = new int[8][3];
		int idx = 0;
		
		for(int i = 0 ; i < 3 ; i++) {
			delta[idx][0] = i;
			delta[idx][1] = i+3;
			delta[idx++][2] = i+6;
		}
		for(int i = 0; i < 9 ; i=i+3) {
			delta[idx][0] = i;
			delta[idx][1] = i+1;
			delta[idx++][2] = i+2;
		}
		delta[idx][0] = 0;
		delta[idx][1] = 4;
		delta[idx++][2] = 8;
		
		delta[idx][0] = 2;
		delta[idx][1] = 4;
		delta[idx++][2] = 6;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		makeDelta();
		while(true) {
			char[] input = br.readLine().toCharArray();
			if(input[0] == 'e') break;
			
			if(check(input)) sb.append("valid\n");
			else sb.append("invalid\n");
		}
		System.out.println(sb);
	}

	private static boolean check(char[] input) {
		
		int winX = 0;
		int winO = 0;
		int cntX = 0;
		int cntO = 0;
		
		for(int[] d : delta) {
			
			if(input[d[0]] == input[d[1]] && input[d[0]] == input[d[2]]) {
				if(input[d[0]] == 'X') winX++;
				else if(input[d[0]] == 'O') winO++;
			}
		}
		
		for(char c : input) {
			if(c=='X') cntX++;
			else if(c=='O') cntO++;
		}
		
		if(winX > 0 && winO > 0) return false;
		else if(winX > winO && cntX == cntO+1) return true;
		else if(winX < winO && cntX == cntO) return true;
		else if(winX == 0 && winO == 0 && cntX == 5 && cntO == 4) return true;
		return false;
	}

}
