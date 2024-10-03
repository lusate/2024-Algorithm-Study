package 이것이코딩테스트다.구현;

public class 게임개발 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int turn_left(int d) {
        d -= 1;
        if(d == -1) d = 3;
        return d;
    }
    public int solution(int n, int m, int x, int y, int d, int[][] arr) {
        int answer = 1;

        int[][] visit = new int[n][m];
        visit[x][y] = 1;

        int turn_time = 0;
        while (true) {
            d = turn_left(d);
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (arr[nx][ny] == 0 && visit[nx][ny] == 0) {
                visit[nx][ny] = 1; // 방문처리
                x = nx;
                y = ny;
                answer += 1;
                turn_time = 0;
                continue;
            } else turn_time += 1; // 가지 못하는 경우 회전

            // 더 이상 앞으로 나아갈 수 없어 뒤로 이동하여 이전 위치로 돌아감.
            // 이동하여 새로운 위치 탐색
            if (turn_time == 4) {
                nx = x - dx[d];
                ny = y - dy[d];

                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else break; // 뒤로 이동할 수 없는 경우 종료
                turn_time = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        게임개발 T = new 게임개발();
        System.out.println(T.solution(4,4,1, 1, 0,
                new int[][]{{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}}));
    }
}
