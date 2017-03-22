package mortgage;
import java.util.Scanner;
/**
 * Description of the Project: Calculates the monthly payment on a loan using the
 * amount of the loan, term and rate provided by the user. It will then create
 * an amortization schedule if desired.
 * @author     Alyssa Watson
 * @created    February 10, 2016
 */

/**public class MortgageApp {
    
    /**public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable){
    
        };
         Welcome Menu
        System.out.println("Welcome to the Mortgage Calculator");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        // while loop for input
        while(choice.equalsIgnoreCase("y"))
        {
            double P=Validator.getDouble(sc, 
                    "Please enter the amount of the Loan: ");
            double T=Validator.getDouble(sc, 
                    "Please enter the Term of the loan: ");
            double I=Validator.getDouble(sc, 
                    "Please enter the Interest Rate: ");
            //creates a new object of type amortization
            Amortization loan = new Amortization(P,I,T);
            
            System.out.println(loan.getMonthly());
            // checks if an amortization schedule should be generated
            String schedule=Validator.getString(sc, 
                    "Would you like to generate an Amortization Schedule? ", "y", "n");
            if(schedule.equalsIgnoreCase("y"))
            {
                String message=loan.getSchedule();
                System.out.println(message);
            }
                System.out.print("Continue? (y/n): ");
                choice = sc.next();
                System.out.println();
        }*/
    } 
}
