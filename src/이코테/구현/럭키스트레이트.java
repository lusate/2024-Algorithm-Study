package 이코테.구현;

import java.util.Arrays;

public class 럭키스트레이트 {
    public String solution(String s) {
        String answer = "";
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        int mid = s.length() / 2;
        int[] first = Arrays.copyOfRange(arr, 0, mid);
        int[] second = Arrays.copyOfRange(arr, mid, s.length());

        int firstSum = Arrays.stream(first).sum();
        int secondSum = Arrays.stream(second).sum();

        if(firstSum == secondSum) answer = "LUCKY";
        else answer = "READY";
        return answer;
    }
    public static void main(String[] args) {
        럭키스트레이트 T = new 럭키스트레이트();
        System.out.println(T.solution("123402"));
        System.out.println(T.solution("7755"));
    }
}
