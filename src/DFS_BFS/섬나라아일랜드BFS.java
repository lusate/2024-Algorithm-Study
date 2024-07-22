package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Point{
    int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class 섬나라아일랜드BFS {
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0, n;
    Queue<Point> Q = new LinkedList<>();
    public void BFS(int x, int y, int[][] board){
        Q.offer(new Point(x, y)); //출발점 넣기
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0; i<8; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
//                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                if(nx < 0 || nx >= n || ny <0 || ny >= board.length) continue;

                board[nx][ny] = 0;
                Q.offer(new Point(nx, ny));
            }
        }
    }

    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){ //육지를 만나면
                    answer++; //섬 개수
                    board[i][j] = 0; //바다로 만듦
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        섬나라아일랜드BFS T = new 섬나라아일랜드BFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}


/* 입력
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
*/

/* 출력
5
*/