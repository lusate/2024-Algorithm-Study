package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전_초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] check = new int[d + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 1; // 밑에 for문으로 값이 3이 되기 때문에 1로 시작
        check[c]++; // 쿠폰 있는 초밥 체크
        for (int i = 0; i < k; i++) { // 초기 check 설정
            if(check[arr[i]] == 0) res++;
            check[arr[i]]++; // 중복이라도 check 값이 2로 되어야 한다
        }

        int cnt = res;
        for (int i = 1; i < N; i++) { // 윈도우 이동 시
            int pop = arr[i - 1]; // 이동 시에 빠져야 하는 첫 인덱스
            check[pop]--; // 먹지 않게 되므로 빼준다

            if(check[pop] == 0) cnt--; // 먹지 않을 때 cnt를 줄여야 한다. 순서 바뀌지 않게 조심

            int add = arr[(i + k - 1) % N]; // 이동 시 추가되어야 하는 인덱스
            if(check[add] == 0) cnt++;
            check[add]++;

            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }
}

/*
8 30 4 30
7
9
7
30
2
7
9
25
 */