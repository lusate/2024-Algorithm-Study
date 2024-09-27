package 프로그래머스;

import java.util.*;

/**
 * 애니팡 같은 문제
 * 프로그래머스 인형 뽑기에서 변형된 문제
 */
class 마카롱 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 마카롱 떨어뜨리기
    public static void drop(int[][] arr, int idx, int num) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][idx] == 0) {
                arr[i][idx] = num;
                return;
            }
        }
    }

    // 마카롱 터뜨리기
    public static boolean burst(int[][] arr) {
        boolean isBurst = false;
        boolean[][] visit = new boolean[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] != 0 && !visit[i][j]) {
                    int count = bfs(arr, visit, i, j, arr[i][j]);
                    System.out.println(count);
                    if (count >= 3) {
                        isBurst = true;
                    }
                }
            }
        }

        // 터뜨릴 마카롱 제거
        if (isBurst) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (visit[i][j]) {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        return isBurst;
    }

    // 연결된 것 확인
    public static int bfs(int[][] arr, boolean[][] visit, int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if (nx >= 0 && nx < 6 && ny >= 0 && ny < 6) {
                    if (arr[nx][ny] == num && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // burst 한 후 다시 내려
    public static void dropMacarons(int[][] arr) {
        for (int j = 0; j < 6; j++) {
            int idx = 5; // 아래에서부터 쓰기
            for (int i = 5; i >= 0; i--) {
                if (arr[i][j] != 0) {
                    arr[idx--][j] = arr[i][j];
                }
            }
            while (idx >= 0) {
                arr[idx--][j] = 0; // 빈 공간으로 채우기
            }
        }
    }

    public String[] solution(int[][] macaron) {
        int[][] arr = new int[6][6];
        String[] answer = new String[6];

        for (int[] tmp : macaron) {
            int idx = tmp[0] - 1;
            int num = tmp[1];

            // 마카롱 아래로 떨어뜨리기
            drop(arr, idx, num);

            // 연결된 마카롱을 확인하고 터뜨림
            while (burst(arr)) {
                dropMacarons(arr);
            }
        }

        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                sb.append(arr[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        마카롱 T = new 마카롱();
        System.out.println(Arrays.toString(T.solution(new int[][]{
                {1, 1},
                {2,1},
                {1,2},
                {3,3},
                {6,4},
                {3,1},
                {3,3},
                {3,3},
                {3,4},
                {2,1},
        })));
    }
}

/*

 */