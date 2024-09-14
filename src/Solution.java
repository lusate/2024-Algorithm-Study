import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
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

        int total = 0, max = 0;
        for (int i = 0; i < k; i++) {
            if(check[arr[i]] == 0) total++;
            check[arr[i]]++;
        }
        max = total;

        for (int i = 1; i < N; i++) {
            if (max <= total) {
                if (check[c] == 0) {
                    max = total + 1;
                } else max = total;
            }

            check[arr[i - 1]]--;
            if(check[arr[i-1]] == 0) total--;

            if (check[arr[(i + k - 1) % N]] == 0) total++;
            check[arr[(i + k - 1) % N]]++;
        }
    }
}

/*
11
10987654321
 */