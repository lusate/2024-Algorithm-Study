package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 숫자고르기 {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void dfs(int st, int num) {

        if (arr[st] == num) {
            result.add(num);
        }

        if(!visit[arr[st]]){
            visit[arr[st]] = true;
            dfs(arr[st], num);
            visit[arr[st]] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        result = new ArrayList<>();
        visit = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        /**
         * 일부 숫자를 뽑을 때는 visit를 생각해보자.
         */
        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

/*
7
3
1
1
5
5
4
6
 */