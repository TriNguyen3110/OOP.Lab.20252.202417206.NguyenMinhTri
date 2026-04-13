package hust.soict.globalict.Lab01;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your name?");
        String StrName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mr/Mrs. " + StrName + ", " + iAge + "years old. " + "Your height is " + dHeight + ".");
    }
}
