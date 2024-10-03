package 백준.윈도우투포인터;

import java.util.*;
import java.io.*;
class 두용액{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer1 = 0;
        int answer2 = 0;

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = n - 1;
        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);
        while(lt < rt) {
            int sum = arr[lt]+arr[rt];

            if(min> Math.abs(sum)) {
                min = Math.abs(sum);

                answer1 = arr[lt];
                answer2 = arr[rt];

                if(sum==0) break;
            }

            if(sum > 0) lt++;
            else rt--;
        }

        System.out.println(answer1 + " " + answer2);
    }
}
