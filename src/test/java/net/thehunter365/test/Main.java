package net.thehunter365.test;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
            System.out.println("|| " + scanner.nextLine().replace(" ", "|| || ") + " ||");
    }
}
