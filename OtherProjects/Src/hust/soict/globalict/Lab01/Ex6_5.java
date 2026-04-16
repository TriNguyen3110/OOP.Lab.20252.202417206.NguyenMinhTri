package hust.soict.globalict.Lab01;

import java.util.Scanner;

public class Ex6_5 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = keyboard.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i ++)
        {
            a[i] = keyboard.nextInt();
            sum += a[i];
        }
        double avg = (double) sum/n;
        for(int i = 0; i < n - 1; i ++)
        {
            for(int j = i + 1; j < n; j ++)
            {
                if(a[i] > a[j])
                {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        System.out.print("The array after sorting is: ");
        for(int i = 0; i < n; i ++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.print("\nSum = " + sum);
        System.out.print("\nAverage = " + avg);
        keyboard.close();
    }
}
