/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortgage;
import java.lang.Math;
import java.text.NumberFormat;
/**
 *
 * @author lyssa
 */
public class Amortization {
    
    private double monthlyPayment;
    private double principal;
    private double interest;
    private double monthlyInterest;
    private double term;
    
    public Amortization(double Principal, double Interest, double Term)
    {
        this.principal=Principal;
        this.interest=Interest;
        this.monthlyInterest=setMonthlyInterest(Interest);
        this.term=convertTermToMonths(Term);
        this.monthlyPayment=calculateMonthlyPayment();
        
    }
    public double getPrincipal(){
        return this.principal;
    }
    public double getInterest(){
        return this.interest;
    }
    public double getTerm(){
        return this.term;
    }
    private double setMonthlyInterest(double Interest)
    {
      return this.monthlyInterest=this.interest/100/12;
    }
    private double convertTermToMonths(double Term)
    {
        if(Term<=30)
        {
            Term*=12;
        }
        return Term;
    }

    private double calculateMonthlyPayment(){
       double M;
       double interestPlus=this.monthlyInterest+1;
       double interestPowered=Math.pow(interestPlus, -this.term);
       M=(this.principal*this.monthlyInterest)/(1-interestPowered);
       return Math.round(M);
    }
    public double getMonthlyPayment(){
        return this.monthlyPayment;
    }
    public String getMonthly(){
        String message = "Monthly Payment: "+this.getMonthlyPayment()+"\n";
        return message;
    }
    
    private double[][] getAmortizationArray(){
        double tempInterest=0;
        double tempPrincipal=0;
        double P=this.principal;
       
        int size = (int) this.term;
        double[][] amortization=new double[size][2];
                
        for(int i=0;i<size;i++)
        {
            tempInterest=P*this.monthlyInterest;
            amortization[i][0]=tempInterest;
            tempPrincipal=this.monthlyPayment-tempInterest;
            amortization[i][1]=tempPrincipal;
            P-=tempPrincipal;
            
        }
        return amortization;
    }
    public String getSchedule(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String message="";
        double[][]amortization=this.getAmortizationArray();
        for(int i=0;i<amortization.length;i++)
        {
            message+="Month "+(i+1)+"\n\t"+"Principal: "+currency.format(amortization[i][1])+"\n\t"
                    +"Interest: "+currency.format(amortization[i][0])+"\n\n\t";
        }
        return message;
    }
      
}
