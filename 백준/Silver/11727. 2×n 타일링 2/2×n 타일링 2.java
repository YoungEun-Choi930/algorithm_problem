import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());
		
		int n1 = 1;
		int n2 = 3;
		int n = 3;
		if(N == 1) n = 1;
		
		for(int i = 3 ; i <= N ; i++ ) {
			
			n = ( ((n1*2) % 10_007) + n2 ) % 10_007 ;
			
			n1 = n2;
			n2 = n;
		}
		
		// 출력
		System.out.println(n);
	}
}
