import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static String AC(String command, String[] nList, int size) {
        int start = 0, end = size-1;
        boolean isR = false;
        for(int i=0; i<command.length(); i++) {
            if(command.charAt(i) == 'R') {
                isR = !isR;
            }
            else if(command.charAt(i) == 'D') {
                if (start > end) {
                    sb.append("error\n");
                    return sb.toString();
                }
                else{
                    if (isR) end--;
                    else start++;
                }
            }
//            switch(command.charAt(i)) {
//                case 'R':
//                    isR = !isR;
//                    break;
//                case 'D':
//                    if(start > end){
//                        sb.append("error\n");
//                        return sb.toString();
//                    }
//                    else {
//                        if(isR)
//                            end--;
//                        else
//                            start++;
//                    }
//            }
        }

        sb.append("[");
        if(isR) {
            for(int i=end; i>=start; i--) {
                sb.append(nList[i]);
                if(i != start)
                    sb.append(",");
            }
        }
        else {
            for(int i=start; i<=end; i++) {
                sb.append(nList[i]);
                if(i != end)
                    sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tC = Integer.parseInt(br.readLine());

        String command;
        String input;
        String[] nList;
        int size;

        while(tC-- > 0) {
            command = br.readLine();
            size = Integer.parseInt(br.readLine());
            input = br.readLine();
            nList = input.substring(1, input.length()-1).split(",");

            AC(command, nList, size);
        }

        System.out.println(sb.toString());
    }
}

/*
11
10987654321
 */