package 이코테.DFSBFS;

public class 음료수얼려먹기 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    public void dfs(int x, int y, int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        visit[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(arr[nx][ny] == 0 && !visit[nx][ny]){
                visit[nx][ny] = true;
                dfs(nx, ny, arr);
            }
        }
    }
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visit[i][j]) {
                    dfs(i, j, arr);
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        음료수얼려먹기 T = new 음료수얼려먹기();
        System.out.println(T.solution(15,14,new int[][]{
                {0,0,0,0,0,1,1,1,1,0,0,0,0,0},
                {1,1,1,1,1,1,0,1,1,1,1,1,1,0},
                {1,1,0,1,1,1,0,1,1,0,1,1,1,0},
                {1,1,0,1,1,1,0,1,1,0,0,0,0,0},
                {1,1,0,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,0,1,1,1,1,1,1,1,1,1,0,0},
                {1,1,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,0,0,1,1},
                {1,1,1,0,0,0,1,1,1,1,1,1,1,1},
                {1,1,1,0,0,0,1,1,1,1,1,1,1,1},
        }));
    }
}

// ------------------------------------------------------------------

// 다른 방법
/*
public boolean dfs(int x, int y){
    if (x <= -1 || x >=n || y <= -1 || y >= m) {
        return false;
    }
    if (visit[x][y] == 0) {
        visit[x][y] = 1;
        dfs(x-1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);
        return true;
    }
    return false;
}

public static void main(String[] args) {
    int result = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // 현재 위치에서 DFS 수행
            if (dfs(i, j)) {
                result += 1;
            }
        }
    }
}*/
