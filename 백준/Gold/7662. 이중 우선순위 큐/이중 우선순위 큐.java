import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());

			Queue<Integer> minheap = new PriorityQueue<Integer>();
			Queue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
			Map<Integer, Integer> countMap = new HashMap<>();

			String[] input;
			while (k-- > 0) {
				input = br.readLine().split(" ");

				char oper = input[0].charAt(0);
				int num = Integer.parseInt(input[1]);

				if (oper == 'I') {
					minheap.offer(num);
					maxheap.offer(num);
					countMap.put(num, countMap.getOrDefault(num, 0) + 1);
					continue;
				}

				// oper == 'D'
				if (!countMap.isEmpty()) {

					if (num == 1) { // 최댓값 삭제
						while (true) {
							int n = maxheap.poll();

							int cnt = countMap.getOrDefault(n,0);
							if(cnt == 0) continue;
							
							if(cnt == 1)
								countMap.remove(n);
							else
								countMap.put(n, cnt - 1);
							break;
						}
					} else { // 최솟값 삭제
						while (true) {
							int n = minheap.poll();

							int cnt = countMap.getOrDefault(n,0);
							if(cnt == 0) continue;
							
							if(cnt == 1)
								countMap.remove(n);
							else
								countMap.put(n, cnt - 1);
							break;
						}
					}
				}

			}
			
			int max = 0, min = 0;
			while(!maxheap.isEmpty()) {
				max = maxheap.poll();
				if(countMap.getOrDefault(max, 0) != 0) break;
			}
			while(!minheap.isEmpty()) {
				min = minheap.poll();
				if(countMap.getOrDefault(min, 0) != 0) break;
			}
			
			// 결과
			if (countMap.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(max + " " + min);
			}

		}
	}

}
