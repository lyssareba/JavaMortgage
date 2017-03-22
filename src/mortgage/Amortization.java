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
<<<<<<< HEAD
        this.interest=Interest;
        this.monthlyInterest=setMonthlyInterest(Interest);
=======
        //this might be strange for people.  If they enter 3.75 as the interst rate
        //and then later call getInterst they'll get 3.75/100/12.
        //that will be confusing
        //maybe add a private variable calle periodicRate
        //this.interest = Interest;
        //this.periodicRate = setPeriodicRate(Interest);
        this.interest=convertInterest(Interest);
>>>>>>> 8350b4870e6b72343840de2cb6bd568227624c5d
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
<<<<<<< HEAD
    private double setMonthlyInterest(double Interest)
    {
      return this.monthlyInterest=this.interest/100/12;
=======
    //change to private void setPeriodicRate(double Interest)
    private convertInterest(double Interest)
    {
        Interest/=100;
        Interest/=12;
        //erase the above and replace with
        //this.periodicRate = this.Interest/100/12;
        return Interest;
>>>>>>> 8350b4870e6b72343840de2cb6bd568227624c5d
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
    //for the record, returning strings from classes that is used for screen output is almost
    //never done in real code. You could create a function called getMonthlyPaymentFormatted()
    //and have it return a monthly payment like $1,405.67
    //then in your main app you would output
    //string payment = Amortization.getMonthlyPaymentFormatted();
    //System.out.println("The monthly payment is " message); not really sure how java handles string concatenation, but you get the point
    public String getMonthly(){ //there are double curlys here - this will probably cause an error
    } //second curly here
        //this.monthlyPayment should be set. No need to use the getter.
        String message = "Monthly Payment: "+this.getMonthlyPayment()+"\n";
        return message;
    }
<<<<<<< HEAD
    
    private double[][] getAmortizationArray(){
        double tempInterest=0;
        double tempPrincipal=0;
        double P=this.principal;
       
        int size = (int) this.term;
=======
    //it isn't exactly clear what this does. You should name it better
    //like getAmortizationArray maybe
    private double[][] getPaymentArray(){
        double tempInterest=0;
        double tempPrincipal=0;
        //this.principal should be set why call the getter from within the class?
        double P=getPrincipal();
       
        int size = (int) this.term;
        //this.monthlyPayment should already be set why are you calling getMonthlyPayment()
        double M=getMonthlyPayment();
>>>>>>> 8350b4870e6b72343840de2cb6bd568227624c5d
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
    //this likely doesn't belong in the Amortization class because it is output. but for this simple
    //app you can leave it. But I might call it getAmortizationFormatted()

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
