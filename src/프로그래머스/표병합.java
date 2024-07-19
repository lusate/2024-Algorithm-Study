package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

public class 표병합 {
    static final String EMPTY = "EMPTY";
    static int[] unf = new int[2501];
    static String[] table = new String[2501];
    static ArrayList<String> result = new ArrayList<>();

    // public static
    private int Find(int v) {
        if(v==unf[v]){
            return unf[v];
        }
        else return unf[v] = Find(unf[v]);
    }

    private void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
//        if(fa != fb) unf[fa] = fb;

        if(fa != fb){
            table[fa] = getValue(fa, fb);
            table[fb] = null;
            unf[fb] = fa;
        }
    }

    private void updateValue(String[] s){
        if (s.length == 4) {
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);
            String value = s[3];

            int parent = Find(getIndex(x, y));
            table[parent] = value;
        }
        else if (s.length == 3) {
            String nowValue = s[1];
            String nextValue = s[2];

            for (int i = 1; i < unf.length; i++) {
                if (nowValue.equals(table[i])) {
                    table[i] = nextValue;
                }
            }
        }
    }
    private void mergeValue(String[] s) {
        int x1 = Integer.parseInt(s[1]);
        int y1 = Integer.parseInt(s[2]);
        int x2 = Integer.parseInt(s[3]);
        int y2 = Integer.parseInt(s[4]);


        Union(getIndex(x1, y1), getIndex(x2, y2));
    }

    public void unmergeValue(String[] s) {
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);

        for (int i = 1; i < unf.length; i++) {
            Find(i); // 부모 인덱스가 업데이트되지 않은 셀이 존재할 수 있어 순회하면서 업데이트
        }

        int parent = unf[getIndex(x, y)];
        String value = table[parent];
        for (int i = 1; i < unf.length; i++) {
            if (unf[i] == parent) {
                unf[i] = i;
                table[i] = null;
            }
        }
        table[getIndex(x, y)] = value;
    }

    private void printValue(String[] s) {
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);

        int parent = Find(getIndex(x, y));
        String value = table[parent];

        if(value == null) result.add(EMPTY);
        else result.add(value);
    }

    // 2차원 배열의 인덱스를 1차원 배열의 인덱스로 변경하여 리턴하는 방법. -> 즉 번호를 부여한 것.
    // 5x5 배열이라고 했을 때 (2,1)좌표에 위치하는 인덱스는 번호가 6이 된다.
    private int getIndex(int x, int y) {
        return 50 * (x - 1) + y;
    }

    private String getValue(int x, int y) {
        String value1 = table[x];
        String value2 = table[y];

        if (value1 != null) {
            return value1;
        }
        return value2;
    }

    public String[] solution(String[] commands) {
        String[] answer = {};
        for (int i = 1; i < unf.length; i++) {
            unf[i] = i;
        }

        for (String str : commands) {
            String[] s = str.split(" ");

            if(s[0].equals("UPDATE")){
                updateValue(s);
            }
            else if(s[0].equals("MERGE")){
                mergeValue(s);
            }
            else if(s[0].equals("UNMERGE")){
                unmergeValue(s);
            }
            else if(s[0].equals("PRINT")){
                printValue(s);
            }
        }


        return result.toArray(new String[0]);
    }
    public static void main(String[] args) {
        표병합 T = new 표병합();
        System.out.println(Arrays.toString(T.solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category",
                "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta",
                "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4",
                "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"})));

        System.out.println(Arrays.toString(T.solution(new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c",
                "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1",
                "UNMERGE 2 2", "PRINT 1 1"})));
    }
}
