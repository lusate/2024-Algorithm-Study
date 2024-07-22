package DFS_BFS;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class 최대점수구하기 {
    static int n,m=0;
    static int answer=Integer.MIN_VALUE;
    public static void dfs(int L, int sum, int time, int[] ps, int[] pt) {
        
    }
    public static void main(String[] args) {
        최대점수구하기 T = new 최대점수구하기();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //문제 수
        m = sc.nextInt(); //제한 시간
        int[] ps = new int[n];
        int[] pt = new int[n];

        for(int i=0; i<n; i++){
            ps[i] = sc.nextInt();
            pt[i] = sc.nextInt();
        }
        T.dfs(0,0,0,ps,pt);
        System.out.println(answer);
    }
}
