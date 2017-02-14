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
    private double convertInterest(double Interest)
    {
        Interest/=100;
        Interest/=12;
        return Interest;
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
       double interestPlus=this.interest+1;
       double interestPowered=Math.pow(interestPlus, -this.term);
       M=(this.principal*this.interest)/(1-interestPowered);
       return Math.round(M);
    }
    private double getMonthlyPayment(){
        return this.monthlyPayment;
    }
    public String getMonthly(){
        String message = "Monthly Payment: "+this.getMonthlyPayment()+"\n";
        return message;
    }
    
    private double[][] getPaymentArray(){
        double tempInterest=0;
        double tempPrincipal=0;
        double P=getPrincipal();
       
        int size = (int) this.term;
        
        double M=getMonthlyPayment();
        double[][] amortization=new double[size][2];
                
        for(int i=0;i<size;i++)
        {
            tempInterest=P*this.interest;
            amortization[i][0]=tempInterest;
            tempPrincipal=this.monthlyPayment-tempInterest;
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
