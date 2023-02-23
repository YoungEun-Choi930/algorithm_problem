import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		int X = Integer.parseInt(br.readLine()); //X(1 ≤ X ≤ 1,000,000,000)
		char[] input = br.readLine().toCharArray(); //소문자로만, 길이는 구간 [3,1000]에 포함
		char[] array = Arrays.copyOf(input, input.length);

		// solve
		int len = input.length -1;
		int halflen = len / 2;
		int start;
		char[] back = new char[halflen];
		char[] front;
		
		if(len % 2 == 0) {	//짝
			start = halflen+1;
			front = new char[halflen];
		}
		else {	//홀
			start = halflen+2;
			front = new char[halflen+1];
		}
		
		List<char[]> list = new ArrayList<char[]>();
		list.add(Arrays.copyOf(input, input.length));
		char[] temp = new char[input.length];
		temp[0] = input[0];
		
		int cnt = 0;
		while(true) {
			// 바꾸기======================================
			int bidx = halflen-1;
			int iidx = 0;
			
			for(int idx = 1; idx + 1 < input.length; idx++) {
				back[bidx--] = input[idx++];
				front[iidx++] = input[idx];
			}
			
			if(len%2 == 1) front[iidx] = input[input.length-1];
			System.arraycopy(front, 0, input, 1, front.length);
			System.arraycopy(back, 0, input, start, back.length);
			// ===========================================
			
			cnt++;
			if(Arrays.equals(array, input)) break;
			else if(cnt == X) break;
			else list.add(Arrays.copyOf(input, input.length));
		}

		if(cnt != X) {
			X %= cnt;
			input = list.get(X);
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < input.length; i++) {
			sb.append(input[i]);
		}
		System.out.println(sb);
	}
}
