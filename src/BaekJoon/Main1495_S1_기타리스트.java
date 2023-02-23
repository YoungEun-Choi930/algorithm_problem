package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1495_S1_기타리스트 {
<<<<<<< HEAD

=======
	
>>>>>>> 2ca90f1d79e8cfd56296f9efdcd1721df0dded6e
	private static int[] volumelist;
	private static int N, M, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);	//1 ≤ N ≤ 50
		int S = Integer.parseInt(input[1]);	//0 ≤ S ≤ M
		M = Integer.parseInt(input[2]);	//1 ≤ M ≤ 1,000
		
		volumelist = new int[N];
		input = br.readLine().split(" ");
		for(int i = 0 ; i < N ; i++) volumelist[i] = Integer.parseInt(input[i]);
		
		// solve
<<<<<<< HEAD
		
=======
		/*
>>>>>>> 2ca90f1d79e8cfd56296f9efdcd1721df0dded6e
		List<Integer> pre = new ArrayList<>();
		pre.add(S);
		
		for(int i = 0 ; i < N ; i++) {
			List<Integer> cur = new ArrayList<>();
			
			for(int vol : pre) {
				if(vol+volumelist[i] <= M) cur.add(vol+volumelist[i]);
				if(vol-volumelist[i] >= 0) cur.add(vol-volumelist[i]);
			}
			
			pre = cur;
<<<<<<< HEAD
			if(cur.isEmpty()) break;
			System.out.print(volumelist[i]);
			System.out.println(cur.toString());
=======
			if(cur.size() == 0) break;
>>>>>>> 2ca90f1d79e8cfd56296f9efdcd1721df0dded6e
		}
		
		int result = -1;
		for(int vol : pre) {
			if(result < vol) result = vol;
<<<<<<< HEAD
		}
		System.out.println(result);
		
	}
=======
		}*/
		System.out.println(result);
		
	}
	
	private static void move(int curindex, int curvolume) {
		
		if(curindex == N) {
			if(curvolume > result) result = curvolume;
			return;
		}
		
		
		int volume = volumelist[curindex];
		if(curvolume + volume <= M) {
			move(curindex+1, curvolume+ volume);
		}
		
		if(curvolume - volume >= 0) {
			
			move(curindex+1, curvolume-volume);
		}
		
			
	}
>>>>>>> 2ca90f1d79e8cfd56296f9efdcd1721df0dded6e
}
