package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N으로만들기 {
    static char[] arr;
    // set = [2 21 521, 1 21 521, 5 52 521, 2 52 521]
    static Set<String> set; // 어떤 방식으로 합쳐졌는지에 대한 Set
    public static void dfs(int lt, int rt, String s, String path) {
        if (lt == 0 && rt == arr.length - 1) {
            set.add(path);
            return;
        }

        // 왼쪽 붙이기 가능.
        if (lt - 1 >= 0) {
            dfs(lt - 1, rt, arr[lt - 1] + s, path + " " + arr[lt - 1] + s);
        }
        // 오른쪽 붙이기 가능.
        if(rt + 1 < arr.length){
            dfs(lt, rt + 1, s + arr[rt + 1], path + " " + s + arr[rt + 1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = st.nextToken().toCharArray();
        set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            dfs(i, i, String.valueOf(arr[i]), String.valueOf(arr[i]));
        }
//        System.out.println("set = " + set);

        System.out.println(set.size());
    }
}
