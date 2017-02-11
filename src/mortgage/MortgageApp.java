/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortgage;
import java.util.Scanner;
/**
 *
 * @author lyssa
 */
public class MortgageApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to the Mortgage Calculator");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while(choice.equalsIgnoreCase("y"))
        {
            double P=Validator.getDouble(sc, 
                    "Please enter the amount of the Loan: ");
            double T=Validator.getDouble(sc, 
                    "Please enter the Term of the loan: ");
            double I=Validator.getDouble(sc, 
                    "Please enter the Interest Rate: ");

            Amortization test= new Amortization(P,I,T);
            
            System.out.println(test.getMonthly());
            String schedule=Validator.getString(sc, 
                    "Would you like to generate an Amortization Schedule? ", "y", "n");
            if(schedule.equalsIgnoreCase("y"))
            {
                String message=test.getSchedule();
                System.out.println(message);
            }
            else
            {
                System.out.print("Continue? (y/n): ");
                choice = sc.next();
                System.out.println();
            }
        }
      
    }
    
}
