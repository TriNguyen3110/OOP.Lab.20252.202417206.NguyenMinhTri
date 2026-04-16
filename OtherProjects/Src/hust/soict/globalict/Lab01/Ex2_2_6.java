package hust.soict.globalict.Lab01;

import java.util.Scanner;

public class Ex2_2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose option:");
        System.out.println("1. Linear equation (ax + b = 0)");
        System.out.println("2. System of linear equations");
        System.out.println("3. Quadratic equation");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                solveLinear(sc);
                break;
            case 2:
                solveSystem(sc);
                break;
            case 3:
                solveQuadratic(sc);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }

    public static void solveLinear(Scanner sc){
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        if (a == 0){
            if (b == 0){
                System.out.println("Infinite solutions");
            }
            else{
                System.out.println("No solution");
            }
        } 
        else{
            double x = -b / a;
            System.out.println("Solution x = " + x);
        }
    }

    public static void solveSystem(Scanner sc){
        System.out.print("Enter a11, a12, b1: ");
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();

        System.out.print("Enter a21, a22, b2: ");
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0){
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Unique solution:");
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } 
        else{
            if (D1 == 0 && D2 == 0){
                System.out.println("Infinite solutions");
            }
            else{
                System.out.println("No solution");
            }
        }
    }

    public static void solveQuadratic(Scanner sc){
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a == 0){
            if (b == 0){
                if (c == 0){
                    System.out.println("Infinite solutions");
                }
                else{
                    System.out.println("No solution");
                }
            } 
            else{
                double x = -c / b;
                System.out.println("Linear solution x = " + x);
            }
            return;
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Two solutions:");
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } 
        else{
            if(delta == 0){
                double x = -b / (2 * a);
                System.out.println("Double root x = " + x);
            } 
            else{
                System.out.println("No real solution");
            }
        }
    }
}