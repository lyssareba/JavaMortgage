/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortgage;
/**
 *
 * @author lyssa
 */
public class Qualify {
    private double salary;
    private double monthlyDebt;
    private double maxMonthlyAmt;
    private double maxBorrowAmt;
    
    public Qualify(double Salary, double Debt)
    {
        this.salary=Salary;
        this.monthlyDebt=Debt;
        this.maxMonthlyAmt=setMaxMonthly(Salary, Debt);
        this.maxBorrowAmt=setMaxBorrow();
    }

    private double setMaxMonthly(double salary, double debt)
    {
        double monthlyIncome=salary/12;
        double maxDebt=monthlyIncome*.43;
        double maxMonthly;
        if(maxDebt>debt)
        {
            maxMonthly=(maxDebt-debt);
        }
        else
            return 0;
        return maxMonthly;
    }
    public double getMax()
    {
        return this.maxMonthlyAmt;
    }
    public double setMaxBorrow()
    {
        //multiply the monthly payment by 12 months for 30 years
        double max=this.maxMonthlyAmt*360;
        return max;
    }
    public double getMaxBorrow()
    {
        return this.maxBorrowAmt;
    }
    
}
