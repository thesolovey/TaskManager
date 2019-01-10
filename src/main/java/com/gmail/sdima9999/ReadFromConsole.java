package com.gmail.sdima9999;

import java.util.Scanner;

public class ReadFromConsole {
    public static String readInputFromConsole(String inputText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputText);
        return scanner.nextLine();
    }
}
