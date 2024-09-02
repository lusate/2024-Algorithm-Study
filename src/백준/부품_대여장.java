package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 부품_대여장 {
    static int fine;
    static long rentalTime;
    static Map<String, String> timeMap = new HashMap<>();
    static Map<String, Long> fineMap = new TreeMap<>();

    // 벌금 계산 위한 로직 ->
    private static long getFine(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dt1 = LocalDateTime.parse(startTime, formatter);
        LocalDateTime dt2 = LocalDateTime.parse(endTime, formatter);

        Duration duration = Duration.between(dt1, dt2);
        long time = duration.getSeconds() / 60 - rentalTime;
        if (time > 0)
            return time * fine;
        return 0;
    }

    // 대여 기간 분으로 바꾸기
    private static long getTimeLimit(String s) {
        String[] tl = s.split("/");
        String[] hhmm = tl[1].split(":");
        return stoi(tl[0]) * 24 * 60 + stoi(hhmm[0]) * 60 + stoi(hhmm[1]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] s = br.readLine().split(" ");
        int N = stoi(s[0]);
        rentalTime = getTimeLimit(s[1]);
        fine = stoi(s[2]);

        for (int tc = 0; tc < N; ++tc) {
            s = br.readLine().split(" ");
            String currentTime = s[0] + " " + s[1]; // YYYY-MM-DD hh:mm 구조
            String key = s[2] + s[3]; // 대여물품과 대여자를 하나로 묶어서 생각한다.
            if (timeMap.containsKey(key)) {
                // 빌린 기록이 있다면 대여시간을 충족하는지 확인해보자
                long total = getFine(timeMap.get(key), currentTime);
                if (total > 0) // 벌금이 존재한다.
                    fineMap.put(s[3], fineMap.getOrDefault(s[3], 0L) + total);
                timeMap.remove(key); // 같은 대여자가 같은 물품을 다시 빌리는 경우가 있다. 기존 값을 지우자.

            } else {
                timeMap.put(key, currentTime); // 최초로 빌리는 경우다.
            }
        }
//        System.out.println(fineMap);

        if (fineMap.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String key : fineMap.keySet())
                sb.append(key).append(" ").append(fineMap.get(key)).append("\n");

            System.out.println(sb); // 정렬해서 출력해야 함
        }
    }
}
