package 프로그래머스;

public class 동영상재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        동영상재생기 T = new 동영상재생기();
        System.out.println(T.solution("34:33", "13:00", "00:55", "02:55",
                new String[]{"next", "prev"}));
        System.out.println(T.solution("10:55", "00:05", "00:15", "06:55",
                new String[]{"prev", "next", "next"}));
        System.out.println(T.solution("07:22", "04:05", "00:15", "04:07",
                new String[]{"next"}));
    }
}
