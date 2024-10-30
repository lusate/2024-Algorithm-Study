package 이코테.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 집인 1에서 출발해서 치킨인 2로 갈 때 최소 거리
 * 집과 치킨집 좌표를 구해야 함
 * 시작점과 치킨집 개수를 dfs에 줘서 시작
 * 치킨 집이 m가 됐다면 거리 계산
 */
public class 치킨배달 {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> choice = new ArrayList<>();
    static boolean[] visit;
    // x,y는 집의 좌표 (1, 1) 부터 시작
    public static void dfs(int start, int cnt) {
        int distance = 0;
        if(cnt == m){ // 원하는 치킨집 개수가 m이 되는 종료
            int sum = 0;
            for (int[] h : house) { // 모든 집 좌표와 치킨 집 좌표와의 거리 계싼
                int min = Integer.MAX_VALUE;
                for (int[] c : choice) { // 선택한 치킨집으로 골라야 함
                    distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(distance, min);
                }
                sum += min; // 집의 개수만큼 sum 계산
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if(!visit[i]){
                visit[i] = true;
                choice.add(chicken.get(i)); // 치킨집 좌표를 넣어줌
                dfs(i + 1, cnt + 1);
//                choice.remove(choice.size() - 1);
                choice.removeLast();
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 집과 치킨집 좌표 넣어주기
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
                else if(map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        // 치킨 좌표 사이즈를 넣어줘야 인덱스 에러가 발생하지 않음
        visit = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }
}
/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

5

5 1
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0

11
 */