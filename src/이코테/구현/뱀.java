package 이코테.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Snake{ // 뱀의 움직임
    int time;
    String dir;
    Snake(int time, String dir) {
        this.time = time;
        this.dir = dir;
    }
}
public class 뱀 {
    static int N, K, L;
    static int[][] map;
    // 뱀 시작이 오른쪽으로 이동이기 때문에 조심해야 합니다.
    static int[] dx = {0, 1, 0, -1}; // 오, 아래, 왼, 위
    static int[] dy = {1, 0, -1, 0};
//     뱀이 자기 몸에 부딪힘
    public static boolean check(Queue<int[]> q, int x, int y) {
        for (int[] body : q) {
            if(body[0] == x && body[1] == y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 보드 크기
        K = Integer.parseInt(br.readLine()); // 사과 개수

        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1; // 사과 위치에 1 설정
        }

        // 뱀의 방향 전환 / L이면 왼쪽 전환, D면 오른쪽 전환
        L = Integer.parseInt(br.readLine());
        Queue<Snake> moves = new LinkedList<>();

        for (int i = 0; i < L; i++) {
            st= new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            moves.add(new Snake(X, C));
        }

        Queue<int[]> q = new LinkedList<>(); // 뱀의 위치
        q.add(new int[]{0, 0}); // 시작점

        // 뱀 이동 명령
        Snake poll = moves.poll();
        int ntTime = poll.time;
        String ntDir = poll.dir;

        // 뱀 현재 위치
        int nowSec = 0;
        int x = 0, y = 0;
        int directionInd = 0;
        String dir = "";
        while(true) {
            nowSec++;
            // 방향에 따른 위치 이동. nx, ny로 하면 안됌
            // -> 벰이 현재 위치에서 이동했을 때 x가 이전 값을 유지하기 때문
            // nx로 할거라면 x = nx를 추가해야 합니다.
            x = x + dx[directionInd];
            y = y + dy[directionInd];

            if (x < 0 || x >= N || y < 0 || y >= N) break;
            if(check(q, x, y)) break; // 자기 몸에 부딪힐 경우

            q.add(new int[]{x, y});
            if (map[x][y] == 1) {
                map[x][y] = 0;
            } else q.poll();

            // 일정 시간이 지나면 방향 바꾸기
            if(nowSec == ntTime) {
                dir = ntDir;
                if (dir.equals("D")) {
                    directionInd = (directionInd + 1) % 4; // 오른족으로 90도 방향 전환
                }
                else if(dir.equals("L")) directionInd = (directionInd + 3) % 4; // 왼쪽으로 90도 방향 전환

                if(!moves.isEmpty()) {
                    poll = moves.poll();
                    ntTime = poll.time;
                    ntDir = poll.dir;
                }
            }
        }
        System.out.println(nowSec);
    }
}

/*
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D

9

10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L

13
 */