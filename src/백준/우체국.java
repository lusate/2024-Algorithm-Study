package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 우체국 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int res = 0;
        int N = Integer.parseInt(br.readLine());
        int[][]map = new int[N][2];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            sum += map[i][1];
        }

        Arrays.sort(map, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int mid = (sum + 1) / 2;

        int idx = 0;
        for (int i = 0; i < N; i++) {
            idx += map[i][1];
            if (idx >= mid) {
                res = map[i][0];
                break;
            }
        }
        System.out.println("sum = " + sum);
        System.out.println(res);
    }
}
