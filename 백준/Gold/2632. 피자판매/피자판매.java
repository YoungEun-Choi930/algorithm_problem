import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);

		int[] arr1 = new int[N + 1];
		int[] sum1 = new int[K + 1];
		int[] arr2 = new int[M + 1];
		int[] sum2 = new int[K + 1];

		// 입력받으면서 누적합 구하기.
		int n;
		for (int i = 1; i <= N; i++) {
			n = Integer.parseInt(br.readLine());
			arr1[i] = arr1[i - 1] + n;
			if (n <= K) sum1[n]++;
		}

		for (int i = 1; i <= M; i++) {
			n = Integer.parseInt(br.readLine());
			arr2[i] = arr2[i - 1] + n;
			if (n <= K) sum2[n]++;
		}

		// 2개, 3개, ....N개 더했을때 만들 수 있는 크기
		n = 1;
		int s;
		while (true) {
			if (++n > N && n > M)
				break;

			for (int i = n; i <= N; i++) {
				s = arr1[i] - arr1[i - n];
				if (s <= K) sum1[s]++;
			}
			if(n < N) {
				for (int i = 1; i < n; i++) {
					s = arr1[i] + arr1[N] - arr1[N - n + i];
					if (s <= K) sum1[s]++;
				}
			}

			for (int i = n; i <= M; i++) {
				s = arr2[i] - arr2[i - n];
				if (s <= K) sum2[s]++;
			}
			if(n < M) {
				for (int i = 1; i < n; i++) {
					s = arr2[i] + arr2[M] - arr2[M - n + i];
					if (s <= K) sum2[s]++;
				}
			}
			
		}

		// 결과적으로 K를 만드는 경우
		int count = 0;
		int i = -1, j = K + 1;
		sum1[0] = 1;
		sum2[0] = 1;

		while (true) {
			if (i >= K) break;
			count += sum1[++i] * sum2[--j];
		}

		System.out.println(count);
	}
}
