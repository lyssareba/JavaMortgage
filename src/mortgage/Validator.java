/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortgage;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import mortgage.Qualify;

/**
 *
 * @author lyssa
 */
public class Validator {
    public static String getString(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.next();  // read user entry
        sc.nextLine();  // discard any other data entered on the line
        return s;
    }
    public static String getString(Scanner sc, String prompt, String c1, String c2)
    {
        String s = "";
        boolean isValid=false;
        while(isValid==false)
        {
            System.out.print(prompt);
            s = sc.next();
            if (s.equalsIgnoreCase(c1)|| s.equalsIgnoreCase(c2))
            {
                isValid=true;
            }
            else
            {
                System.out.println("Error! Invalid choice. Try again.");
            }
            sc.nextLine();
        }
        
        
         // read user entry
          // discard any other data entered on the line
        return s;
    }
    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }
    public static double getDouble(Scanner sc, String prompt)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
    public boolean isPresent(JTextComponent c, String fieldName)
    {
        if(c.getText().length() == 0)
        {
            showMessage(c, fieldName + " is a required field.");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }
    public boolean isDouble(JTextComponent c, String fieldName)
    {
        try
        {
            double d= Double.parseDouble(c.getText());
            return true;
        }
        catch(NumberFormatException e)
        {
            showMessage(c, fieldName + " must be a valid number.");
            c.requestFocusInWindow();
            return false;
        }
    }
    public boolean isDebtFree(JTextComponent c, String fieldName)
    {
        showMessage(c, fieldName + " sets your debt-to-income ratio above 41%. "
                + "You may not qulify for a loan. Enter a lower debt amount.");
        c.requestFocusInWindow();
        return false;
    }

    private void showMessage(JTextComponent c, String message) {
        JOptionPane.showMessageDialog(c, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
}
