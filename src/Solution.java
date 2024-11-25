import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        //+, - 들어갈 리스트
        ArrayList<String> arr = new ArrayList<>();

        int n = sc.nextInt();
        //1 ~ n이 들어갈 배열
        int[] list = new int[n];

        for(int i=0; i<n; i++) {
            list[i] = sc.nextInt(); //숫자 입력
        }

        int index = 0; //수열 index
        for(int i=1; i<=n; i++) {
            stack.push(i);
            arr.add("+"); //stack에 넣으면 +를 arr에 추가
            while(!stack.isEmpty()) {//stack이 비어있지 않을 때
                //stack의 top값과 list[index] 가 같은 경우
                if(stack.peek() == list[index]) {
                    stack.pop();
                    arr.add("-");
                    index++; //list의 index를 옮김.
                }
                else {
                    break;
                }
            }
            System.out.println("stack = " + stack);
        }
        if(!stack.isEmpty()) {//stack이 비어있지 않으면
            System.out.println("NO"); // +나 - 연산을 주는 것이 불가능한 경우
        }
        else {
            for(String st : arr) {
                System.out.println(st);
            }
        }
    }
}

/*
11
10987654321
 */