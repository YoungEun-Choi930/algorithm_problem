import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] towers = new int[N];
		for(int i = 0; i < N ;i++) {
			towers[i] = Integer.parseInt(input[i]);
		}
		
		// solve
		int[] result = new int[N];
		List<Tower> canAccept = new LinkedList<>();
		for(int idx = 0 ; idx < N ; idx++) {
			int curlength = towers[idx];
			// 신호 보내기
			// 받을 수 있는 타워 찾기
			int acceptNum = 0;
			Iterator<Tower> it = canAccept.iterator();
			while(it.hasNext()) {
				Tower t = it.next();
				if(t.length >= curlength) {
					// 신호 받기
					acceptNum = t.index;
					break;
				}
			}
			result[idx] = acceptNum;
			
			
			// 신호 받을 수 있는 타워로 넣기
			for(int i = 0 ; i < canAccept.size() ; i++) {
				if(canAccept.get(0).length < curlength)
					canAccept.remove(0);
				else
					break;
			}
			canAccept.add(0, new Tower(idx+1, curlength));	//정답 index가 1부터라 +1
		}

		// 출력
		for(int num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
	
}

class Tower {
	int index;
	int length;
	public Tower(int index, int length) {
		super();
		this.index = index;
		this.length = length;
	}
}
