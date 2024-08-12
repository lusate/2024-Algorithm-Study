package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대부분증가수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dy = new int[N];
        dy[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0; // if 조건이 만족하지 않으면 자기 혼자이므로 dy[i] 갓은 0이 된다. ex) 4, 6, 7, 2
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && dy[j]>max) max = dy[j];
            }
            dy[i] = max + 1; // 길이가 추가
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }
}

/*
8
5 3 7 8 6 2 9 4
 */