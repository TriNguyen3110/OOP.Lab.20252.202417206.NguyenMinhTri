package hust.soict.globalict.Lab01;

import javax.swing.JOptionPane;

public class Ex2_2_5 {
    public static void main(String[] args) {
        double a, b;

        String strA = JOptionPane.showInputDialog("Enter the first number:");
        String strB = JOptionPane.showInputDialog("Enter the second number:");

        a = Double.parseDouble(strA);
        b = Double.parseDouble(strB);

        double sum = a + b;
        double diff = a - b;
        double product = a * b;

        String messgae = "Sum: " + sum + "\nDifference: " + diff + "\nProduct: " + product;
        if(b != 0)
        {
            double quotient = a / b;
            messgae += "\nQuotient: " + quotient;
        }
        else
        {
            messgae += "\nQuotient: Cannot divide by 0";
        }

        JOptionPane.showMessageDialog(null, messgae);
        System.exit(0);
    }
}
