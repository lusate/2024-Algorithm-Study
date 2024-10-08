package 백준.자료구조;

import java.util.*;
import java.io.*;
class 문자열폭발{
    static String s, bomb;
    static Stack<Character> stack = new Stack<>();

    public String solution(String s, String bomb) {
        for(int i=0; i<s.length(); i++){
            //스택에 s를 한 번에 다 넣는 것이 아님.
            stack.push(s.charAt(i));

            //스택에 있는 문자열의 길이가 bomb보다 길어야 함.
            if(stack.size() >= bomb.length()){
                boolean contain = true; //bomb에 있는 문자가 s에 포함되면 true
                for(int j=0; j<bomb.length(); j++){
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        //포함되어 있지 않으면 false
                        contain = false;
                        break;
                    }
                }
                if(contain){ //포함된 경우 pop
                    for(int j=0; j<bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
            //System.out.println(stack);
        }


        // 쪼개져있는 문자들을 문자열로 만들어주기
        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }

        // 문자열의 길이가 0이라면 FRULA 출력, 아니라면 문자열 출력
        return sb.length() == 0 ? "FRULA" : sb.toString();

    }
    public static void main(String[] args) throws Exception {
        문자열폭발 T = new 문자열폭발();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        bomb = br.readLine();

        System.out.println(T.solution(s, bomb));
    }
}

