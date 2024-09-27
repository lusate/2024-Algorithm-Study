package 프로그래머스;

import java.util.*;

import static java.util.Comparator.reverseOrder;

public class 문자열_내림차순 {
    public String solution(String s) {
        // 대문자는 소문자보다 작은 것으로 간주
        String answer = "";
        int len = s.length();

        List<Character> arr = new ArrayList<>();
        for(int i=0; i<len; i++) {
            arr.add(s.charAt(i));
        }
        arr.sort(reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            sb.append(c);
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        문자열_내림차순 T = new 문자열_내림차순();
        System.out.println(T.solution("Zbcdefg"));
        System.out.println(T.solution("zfdecbg"));
    }
}

/*
gfedcbz
 */