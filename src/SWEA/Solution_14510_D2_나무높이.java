package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_14510_D2_나무높이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <=T ; tc++) {
        	// input
            int N = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            int[] trees = new int[N];

            int max = Integer.MIN_VALUE;
            int n;
            for(int i = 0 ; i < N ; i++) {
                n = Integer.parseInt(split[i]);
                if(n > max) max = n;
                trees[i] = n;
            }
            // ========================================
            //solve
            int ans = 0;
            int just1 = 0;
            int just2 = 0;
            for(int idx = 0 ; idx < N ; idx++) {
            	int tree = trees[idx];
            	int dif = max - tree;
            	if(dif == 0) continue;
            	
            	//System.out.println("========="+dif);
            	int d = dif/3 * 2;
            	//System.out.println(d);
            	ans += d;
            	dif %= 3; // 0 1 22
            	
            	if(dif == 2) {
        			dif -= 2;
        			ans += 2;
        			just2++;
        			//System.out.println("(2)");
        		}
        		if(dif == 1) {
        			dif -= 1;
        			ans += 1;
        			just1++;
        			//System.out.println("(1)");
        		}
            }

            System.out.println(ans+" | "+just1+" | "+just2);
            
            // just2의 비어있는 칸에 just1을 넣을 수 있다.
            int min = Math.min(just1, just2);
            ans -= min;
            just1 -= min;
            just2 -= min;
            
            if(just1 > 1) {	//1이 더 많으면 1을 빈칸채우고 채워야하니까
            	ans += just1-1;
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

}