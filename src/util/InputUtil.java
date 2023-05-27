package util;

import java.util.Scanner;

public class InputUtil {
    public static String requireText(String title){
        Scanner sc = new Scanner(System.in);
        System.out.print(title+":");
        String answer = sc.nextLine();
        return answer;
    }
    public static int requirNumber(String title){
        Scanner sc = new Scanner(System.in);
        System.out.print(title+":");
        int answer = sc.nextInt();
        return answer;
    }
}