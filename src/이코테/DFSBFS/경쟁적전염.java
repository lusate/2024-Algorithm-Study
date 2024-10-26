package 이코테.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * S초가 지난 후에 (X, Y)에 존재하는 바이러스의 종류
 */
class Virus{
    int x,y,virus,time;
    Virus(int x,int y,int virus,int time){
        this.x=x;
        this.y=y;
        this.virus=virus;
        this.time=time;
    }
}
public class 경쟁적전염 {
    static int n, k;
    static int s, row, col;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<Virus> q = new LinkedList<>();
    public static void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != 0) q.add(new Virus(i,j,map[i][j],0));
            }
        }
        while(!q.isEmpty()){
            Virus tmp = q.poll();

            if (tmp.time == s) {
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = tmp.x + dx[k];
                int ny = tmp.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = tmp.virus;
                    q.add(new Virus(nx, ny, tmp.virus, tmp.time + 1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        ArrayList<Virus> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) arr.add(new Virus(i, j, map[i][j], 0));
            }
        }

        /**
         * 리스트에 담겨있는 노드들을 바이러스가 오름차순이 되도록 정렬
         * 정렬해준 리스트들을 모두 큐에 넣고 BFS를 사용하여 증식이 될 때마다 시간을 증가
         * 그러면 모든 바이러스가 낮은 종류부터 동시에 처리됨.
         * 내림차순이라면
         * arr.sort(Comparator.comparingInt(o -> o.virus).reversed());
         */
        arr.sort((o1, o2) -> o1.virus - o2.virus);
//        arr.sort(Comparator.comparingInt(o -> o.virus)); // 오름차순

        for (Virus virus : arr) {
            q.add(virus);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(map[row - 1][col - 1]);
    }
}
