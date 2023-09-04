
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final static int line = 5;
    private static int[][] map;

    public static void main(String[] args) throws IOException {		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[line][line];

        for(int i = 0 ; i < line ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < line ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(find(r,c,0,0));	//현재위치는 빈칸이다.
    }

    private final static int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};

    private static int find(int r, int c, int depth, int apple) {
//    	System.out.println(r+","+c+" : d"+depth+" / a"+apple);
    	if(apple == 2) return 1;
        if(depth > 2) return 0; //세 번 이하의 이동

        for(int d = 0 ; d < 4 ; d++) {
            int dr = r + delta[d][0];
            int dc = c + delta[d][1];

            if(dr >= 0 && dr < line && dc >= 0 && dc < line) {
            	if(map[dr][dc] != -1) {
            		int t = map[r][c];
            		map[r][c] = -1;
            		// 현재 사과 수(1,0)을 추가해서 보낸다.
                    if(find(dr, dc, depth+1, apple+map[dr][dc]) == 1) return 1;
                    map[r][c] = t;
            	}
            }
        }
        return 0;
    }

}
