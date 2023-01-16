package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String inputString = bReader.readLine();
		int N = Integer.parseInt(inputString.split(" ")[0]);
		int K = Integer.parseInt(inputString.split(" ")[1]);
		
		int[] coin = new int[N];
		for(int i = 0 ; i< N; i++) {
			coin[i] = Integer.parseInt(bReader.readLine());
		}
		
		//solve
		/*
		 * 1. ��� -> �ð��ʰ� (top->down)
		 * ���� ��ġ�� ū ������ �������� �� �־��������� -1�� ����.
		 */
		/*
		Arrays.sort(coin);
		int result = calc(coin, K, coin.length-1);
		*/
		
		/*
		 * 2. ��ȭ�� (down->up)
		 */
		int result = calc2(coin, K);
		
		System.out.println(result);
	}
	private static int calc2(int[] coin, int K) {
		
		int[][] chart = new int[coin.length][K+1];	//coin�������� K���� ����� ����� ��
		
		//0������ �ʱ�ȭ
		int c = coin[0];
		for(int i = 0 ; i <= K ; i++) {
			if(i % c == 0) chart[0][i] = 1;
			else chart[0][i] = 0;
		}
		
		//��������
		for(int n = 1; n < coin.length; n++) {	//n:����
			c = coin[n];
			for(int i = 0 ; i <= K; i++) {		//i:K.����� �ݾ�
				if(i < c) {		//���� �������� ����� ���� ���̸� ���� �����ݾ� ����
					chart[n][i] = chart[n-1][i];
					continue;
				}
				int cases = 0;	//���� �� �ִ� ����� ��
				int div = i / c;	//K�ݾ׿��� �� �� �ִ� �ִ� ���絿�� ����
				
				for(int cnt = div; cnt >= 0; cnt--) {
					int remain = i - c*cnt;		//c������ cnt��ŭ ���� �� �����ϴ� ��
					cases += chart[n-1][remain];
				}
				chart[n][i] = cases;
			}
		}
		//printarray(chart,coin.length,K);
		return chart[coin.length-1][K];
	}
	
	/*
	private static void printarray(int[][] array,int n, int k) {
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j <= k; j++) {
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}
	*/
	
	/*
	private static int calc(int[] coin, int K, int index) {
		
		int value = coin[index];
		if(index == 0) {
			if(K % value != 0) return 0;
			else return 1;
		}
		
		int result = 0;
		for(int count = K/value ; count >= 0 ; count--) {
			result += calc(coin, K - value*count, index-1);
		}
		
		return result;
	}
	*/
	
}
