package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main1202 {
	public static void main(String[] args) throws Exception{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputStrings = bReader.readLine().split(" ");
		
		int N = Integer.parseInt(inputStrings[0]);
		int K = Integer.parseInt(inputStrings[1]);
		
		Jewelry[] jewelries = new Jewelry[N];
		
		for(int i = 0 ; i < N ; i++) {
			inputStrings = bReader.readLine().split(" ");
			int m = Integer.parseInt(inputStrings[0]);
			int v = Integer.parseInt(inputStrings[1]);
			jewelries[i] = new Jewelry(m,v);
		}
		
		Integer[] bag = new Integer[K];
		for(int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(bReader.readLine());
		}
		
		/*
		 * 최대가격을 구해야한다.
		 * 가격이 높은것부터 내림차순정렬해서
		 * 가방에 넣을 수 있으면. 최대한 무게에 알맞게 넣어야함.
		 * result무게 += 보석무게
		 * -> 시간초과!!!!! O(NK)
		 */
		
		
		/*
		int result = 0;
		Arrays.sort(bag);
		Arrays.sort(jewelries, new Comparator<Jewelry>() {

			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return o2.price - o1.price;
			}

		});
		
		boolean[] full = new boolean[K];
		for(Jewelry jewelry : jewelries) {
			int weight = jewelry.weight;
			for(int index=0; index < K; index++) {
				if(full[index]) continue;
				if(bag[index] < weight) continue;
				else {
					result += jewelry.price;
					full[index] = true;
					break;
				}
			}
		}
		*/
		
		/*
		 * 방법2. priority queue
		 */
		
		Arrays.sort(bag);
		Arrays.sort(jewelries);
		
		long result = 0;
		int cnt=0;
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i = 0 ; i < K; i++) {
			while(cnt<N && jewelries[cnt].weight <= bag[i]) {
				queue.add(-jewelries[cnt].price);
				cnt++;
			}
			if(!queue.isEmpty()) {
				result += Math.abs(queue.poll());
			}
		}
		
		System.out.println(result);
		
	}
	
	private static class Jewelry implements Comparable<Jewelry>{
		int weight;
		int price;
		
		public Jewelry(int m, int v) {
			this.weight = m;
			this.price = v;
		}

		@Override
		public int compareTo(Jewelry o) {
			return this.weight - o.weight;
		}

	}
}
