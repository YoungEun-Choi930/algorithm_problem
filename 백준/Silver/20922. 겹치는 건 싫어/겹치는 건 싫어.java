import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// solve
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		int length = 0;
		int maxLength = 0;
		int maxk = 0;
		int maxknum = 0;
		
		int p1 = 0;
		int p2 = 0;
		
		while(p2 < arr.length) {
			// 오른쪽 포인터를 옮기기
			if(maxk <= K) {
				int c = count.getOrDefault(arr[p2], 0)+1;
				if(c > maxk) {
					maxk = c;
					maxknum = arr[p2];
				}
				count.put(arr[p2], c);
				++length;
				// K개수 초과할때는 maxLength로 계산하지 않는다.
				if(maxk <= K && maxLength < length) maxLength = length;
				p2++;
			}
			
			//왼쪽 포인터를 옮기기
			else {
				count.put(arr[p1], count.get(arr[p1])-1);
				if(arr[p1] == maxknum) maxk--;
				length--;
				p1++;
			}
		}
		
		System.out.println(maxLength);
	}
}
