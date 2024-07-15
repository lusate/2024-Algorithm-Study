package 문자열_조작;

import java.util.*;
class 한번사용한최초문자{
    public int solution(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i+1; // 인덱스가 1부터 시작하므로 +1을 해준다.
            }
        }

        return -1;
    }

    public static void main(String args[]){
        한번사용한최초문자 T = new 한번사용한최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
    }

}


//답
//3
//-1
//3