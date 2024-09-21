package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * ArrayDeque 사용
 */
public class AC {
    static StringBuilder sb = new StringBuilder();

    public static void AC(String p, ArrayDeque<Integer> dq) {
        boolean flag = true;

        for(char c : p.toCharArray()) {
            if (c == 'R') { // 뒤집기
                flag = !flag; // 반전하기. 즉 flag가 false라면 true로 반전시킵니다
                continue; // c == R 이라면 현재 반복의 나머지 부분을 건너뛰고, 다음 문자로 넘어갑니다.
            }

            if (flag) { // c == D 이고 flag 가 true라면 앞에부터 제거시킵니다
                if(dq.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
            else { // 만약 반환된 원소가 없을 경우 error를 출력하도록 하고 함수 종료
                if(dq.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        result(dq, flag);
    }

    /**
     * 출력 결과 메서드
     */
    public static void result(ArrayDeque<Integer> dq, boolean flag) {
        sb.append('[');
        if (!dq.isEmpty()) {
            if (flag) {
                sb.append(dq.pollFirst());

                while(!dq.isEmpty()) {
                    sb.append(',').append(dq.pollFirst());
                }
            }

            else{
                sb.append(dq.pollLast());

                while(!dq.isEmpty()) {
                    sb.append(',').append(dq.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> dq;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String p = br.readLine();	// 문제에서 p에 해당하는 명령어
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            dq = new ArrayDeque<>();

            // 덱에 배열 원소를 넣어준다.
            for(int i = 0; i < N; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            AC(p, dq);
        }

        System.out.println(sb);
    }
}
/*
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]
 */


/**
 * 그냥 인덱스 사용
 * 속도는 그냥 인덱스가 더 빠르지만 메모리는 Deque가 유용
 */
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static String AC(String command, String[] nList, int size) {
        int start = 0, end = size-1;
        boolean isR = false;
        for(int i=0; i<command.length(); i++) {
            if(command.charAt(i) == 'R') {
                isR = !isR;
            }
            else if(command.charAt(i) == 'D') {
                if (start > end) {
                    sb.append("error\n");
                    return sb.toString();
                }
                else{
                    if (isR) end--;
                    else start++;
                }
            }
//            switch(command.charAt(i)) {
//                case 'R':
//                    isR = !isR;
//                    break;
//                case 'D':
//                    if(start > end){
//                        sb.append("error\n");
//                        return sb.toString();
//                    }
//                    else {
//                        if(isR)
//                            end--;
//                        else
//                            start++;
//                    }
//            }
        }

        sb.append("[");
        if(isR) {
            for(int i=end; i>=start; i--) {
                sb.append(nList[i]);
                if(i != start)
                    sb.append(",");
            }
        }
        else {
            for(int i=start; i<=end; i++) {
                sb.append(nList[i]);
                if(i != end)
                    sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tC = Integer.parseInt(br.readLine());

        String command;
        String input;
        String[] nList;
        int size;

        while(tC-- > 0) {
            command = br.readLine();
            size = Integer.parseInt(br.readLine());
            input = br.readLine();
            nList = input.substring(1, input.length()-1).split(",");

            AC(command, nList, size);
        }

        System.out.println(sb.toString());
    }
}*/