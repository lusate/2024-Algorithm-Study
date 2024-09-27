package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;

public class 곡예비행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상승일 때 하강일 때 2가지 조건으로 해서 2 dp를 합치면 끝
        int[][] dpUp = new int[N][M];
        dpUp[N-1][0] = arr[N-1][0];
        for(int i = N-1; i>=0; i--) {
            if (i != N - 1) {
                dpUp[i][0] = dpUp[i + 1][0] + arr[i][0];
            }
            for (int j = 1; j < M; j++) {
                if(i != N-1){
                    dpUp[i][j] = Math.max(dpUp[i+1][j], dpUp[i][j-1]) + arr[i][j];
                }
                else{
                    dpUp[i][j] = dpUp[i][j - 1] + arr[i][j];
                }
            }
        }

        int[][] dpDown = new int[N][M];
        dpDown[N-1][M-1] = arr[N-1][M-1];
        for (int i = N - 1; i >= 0; i--) {
            if (i != N - 1) {
                dpDown[i][M - 1] = dpDown[i + 1][M - 1] + arr[i][M - 1];
            }
            for (int j = M - 2; j >= 0; j--) {
                if (i != N - 1) {
                    dpDown[i][j] = Math.max(dpDown[i + 1][j], dpDown[i][j + 1]) + arr[i][j];
                }
                else{
                    dpDown[i][j] = dpDown[i][j + 1] + arr[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(dpUp[i][j] + dpDown[i][j], max);
            }
        }
        System.out.println(max);
    }
}

/*
3 4
1 5 -6 1
3 -3 9 5
1 -1 1 -3

5 5
100 100 100 100 100
100 -100 -100 -100 100
100 -100 -100 -100 100
100 -100 -100 -100 100
100 -100 -100 -100 100

5 1
1
1
1
1
1
 */