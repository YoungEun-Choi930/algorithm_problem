package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main5430_G5_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			String order = br.readLine().replaceAll("RR", "");
			
			int N = Integer.parseInt(br.readLine());
			String in = br.readLine();
 			List<Integer> list= new ArrayList<>(N);
 			int start = 1;
 			int end = 1;
 			for(int i = 0 ; i < N ; i++) {
 				while(in.charAt(end) != ',' && in.charAt(end) != ']')
 					end++;
 				
 				list.add(Integer.parseInt(in.substring(start,end)));
 				start = ++end;
 			}
			
			int length = order.length();
			boolean flag = true;
			boolean direction = true;
			for(int i = 0 ; i < length; i++) {
				char command = order.charAt(i);
				if(command == 'R') {
					direction = !direction;
				}
				else if(command == 'D') {
					if(N == 0) {
						flag = false;
						break;
					}
					
					//else
					N--;
					if(direction) {
						list.remove(0);
					}
					else {
						list.remove(N);
					}
				}
			}
			
			if(flag) {
				if(!direction) 
					Collections.reverse(list);
				String s = list.toString().replace(" ", "");
				sb.append(s).append("\n");
			}
			else {
				sb.append("error\n");
			}
		}
		
		System.out.println(sb);
	}
}
