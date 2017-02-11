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
    private double term;
    
    public Amortization(double Principal, double Interest, double Term)
    {
        this.principal=Principal;
        this.interest=convertInterest(Interest);
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
    public double convertInterest(double Interest)
    {
        Interest/=100;
        Interest/=12;
        return Interest;
    }
    public double convertTermToMonths(double Term)
    {
        if(Term<=30)
        {
            Term*=12;
        }
        return Term;
    }
    public void setMonthlyPayment(){
        this.monthlyPayment=calculateMonthlyPayment();
    }
    public double calculateMonthlyPayment(){
       double P=getPrincipal();
       double I=getInterest();
       double T=getTerm();
       double M;
       double interestPlus=I+1;
       double interestPowered=Math.pow(interestPlus, -T);
       M=(P*I)/(1-interestPowered);
       return Math.round(M);
    }
    public double getMonthlyPayment(){
        return this.monthlyPayment;
    }
    public String getMonthly(){
        String message = "Monthly Payment: "+this.getMonthlyPayment()+"\n";
        return message;
    }
    
    public double[][] getPaymentArray(){
        double tempInterest=0;
        double tempPrincipal=0;
        double P=getPrincipal();
        double I=getInterest();
        double T=getTerm();
        int size = (int) T;
        
        double M=getMonthlyPayment();
        double[][] amortization=new double[size][2];
                
        for(int i=0;i<T;i++)
        {
            tempInterest=P*I;
            amortization[i][0]=tempInterest;
            tempPrincipal=M-tempInterest;
            amortization[i][1]=tempPrincipal;
            P-=tempPrincipal;
            
        }
        return amortization;
    }
    public String getSchedule(){
        String message="";
        double[][]amortization=this.getPaymentArray();
        for(int i=0;i<amortization.length;i++)
        {
            message+="Month "+(i+1)+"\n\t"+"Principal: "+amortization[i][1]+"\n\t"
                    +"Interest: "+amortization[i][0]+"\n\t";

        }
        return message;
    }
      
}
