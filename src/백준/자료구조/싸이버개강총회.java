package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = reader.readLine().split(" ");
        String s = tmp[0];
        String e = tmp[1];
        String q = tmp[2];
        String input;
        HashSet<String> enterMap = new HashSet<>();
        HashSet<String> outMap = new HashSet<>();

        while((input = reader.readLine()) != null){
            String[] member = input.split(" ");

            // s(개강 총회 시작 시간) - temp[0] (입장 등록 시간)을 해서 양수면 출석 완료
            if(s.compareTo(member[0]) >= 0){
                enterMap.add(member[1]);
            }
            // 퇴장 완료
            else if(e.compareTo(member[0]) <= 0 && q.compareTo(member[0]) >= 0){
                outMap.add(member[1]);
            }
        }

        int answer = 0;
        for(String str : enterMap){
            if(outMap.contains(str)){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
