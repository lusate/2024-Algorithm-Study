package 이것이코딩테스트다.그리디;

import java.util.ArrayList;
import java.util.Collections;

public class 만들수없는금액 {
    public int solution(int n, int[] arr) {
        int answer = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);

        // 1 1 2 3 9
        for (int i = 0; i < n; i++) {
            if(answer < list.get(i)) {
                System.out.println("answer = " + answer);
                break;
            }


            answer += list.get(i);
            System.out.println("i = " + i + " answer = " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        만들수없는금액 T = new 만들수없는금액();
        System.out.println(T.solution(5, new int[]{3, 2, 1, 1, 9}));
    }
}
