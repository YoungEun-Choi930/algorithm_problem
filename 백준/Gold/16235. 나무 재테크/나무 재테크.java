import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static class Tree implements Comparable<Tree>{
        int x, y, year;

        public Tree(int x, int y, int year) {
            this.x = x;
            this.y = y;
            this.year = year;
        }

        @Override
        public int compareTo(Tree o) {
            return this.year - o.year;
        }
    }

    private static int[][] delta = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int K = Integer.parseInt(in[2]);

        int[][] base = new int[N+1][N+1];
        int[][] curMap = new int[N+1][N+1];
        Queue<Tree> trees = new PriorityQueue<>();

        for(int i = 1 ; i <= N ; i++) {
            in = br.readLine().split(" ");
            for(int j = 1; j <= N ; j++) {
                base[i][j] = Integer.parseInt(in[j-1]);
            }
        }
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1; j <= N ; j++) {
                curMap[i][j] = 5;
            }
        }
        for(int m = 0 ; m < M ; m++) {
            in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            int z = Integer.parseInt(in[2]);

            trees.add(new Tree(x,y,z));
        }

        // solve
        for(int y = 0 ; y < K ; y++) {
            // 1. 봄. 나이작은순으로 확인
            Queue<Tree> newTrees = new PriorityQueue<>();
            Queue<Tree> deadTrees = new ArrayDeque<>();

            while(!trees.isEmpty()) {
                Tree cur = trees.poll();

                if(curMap[cur.x][cur.y] < cur.year) {
                    deadTrees.add(cur);
                }
                else {
                    curMap[cur.x][cur.y] -= cur.year;

                    if(++cur.year % 5 == 0) {
                        // 3. 가을. 5의배수면 번식.
                        for(int d = 0 ;d < delta.length ; d++) {
                            int dx = cur.x + delta[d][0];
                            int dy = cur.y + delta[d][1];

                            if(dx > 0 && dy > 0 && dx <= N && dy <= N) {
                                newTrees.add(new Tree(dx,dy,1));
                            }
                        }
                    }

                    newTrees.add(cur);
                }
            }

            // 2. 여름. 죽은나무 -> 양분
            while(!deadTrees.isEmpty()) {
                Tree dead = deadTrees.poll();
                curMap[dead.x][dead.y] += dead.year / 2;
            }

            // 4. 겨울
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1; j <= N ; j++) {
                    curMap[i][j] += base[i][j];
                }
            }

            trees = newTrees;
        }

        // 살아있는 나무 수
        System.out.println(trees.size());

    }
}
