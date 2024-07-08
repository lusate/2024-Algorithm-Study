package 문자열_조작;

import com.sun.tools.javac.Main;

import java.util.HashMap;

public class 학급회장 {
    public char solution(String s){
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        학급회장 T = new 학급회장();
        System.out.println(T.solution("BACBACCACCBDEDE"));
        System.out.println(T.solution("AAAAABBCCDDDD"));
    }
}
