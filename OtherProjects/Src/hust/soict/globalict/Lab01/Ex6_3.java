package hust.soict.globalict.Lab01;

import java.util.Scanner;

public class Ex6_3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = keyboard.nextInt();
        for(int i = 1; i <= n; i ++){
            // Print the space
            for(int j = 1; j <= n - i; j ++)
            {
                System.out.print(" ");
            }
            // Print "*"
            for(int j = 1; j <= 2*i - 1; j ++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
        keyboard.close();;
    }
}
