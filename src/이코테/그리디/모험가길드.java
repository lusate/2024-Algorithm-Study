package 이코테.그리디;

import java.util.ArrayList;
import java.util.Collections;

public class 모험가길드 {
    public int solution(int n, int[] num) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int k : num) {
            arr.add(k);
        }
        Collections.sort(arr);

        // 1 2 2 2 3
        // 공포도가 X인 모험가는 반드시 X명 이상으로 구성되어야 모험가 그룹에 참여
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            count++;
            if(count >= arr.get(i)){
                answer++;
                count = 0; // 구룹에 포함된 모험가의 수
            }
        }
        /**
         * 모험가 1, count 1
         * 모험가 2, count 1 그룹 1개
         * 모험가 2, count 2 그룹 2개 -> 그룹 A(1, 2) / B(2)
         * 모험가 2, count 1 그룹 2개 -> 그룹 A(1, 2) / B(2, 2)
         * 모험가 3, count 2 그룹 2개
         */

        return answer;
    }
    public static void main(String[] args) {
        모험가길드 T = new 모험가길드();
        System.out.println(T.solution(5, new int[]{2,3,1,2,2}));
    }
}
