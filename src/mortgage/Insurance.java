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
public class Insurance {

    private double monthlyMI;
    private double LTV;
    private double housePrice;
    private double interestRate;
    private double term;
    private double downPmt;
    private double loanAmt;
    
    
    public Insurance(double HousePrice, double DownPmt)
    {
        this.LTV=setLTV(HousePrice, DownPmt);
        this.housePrice=HousePrice;
        this.term=30;
        this.downPmt=DownPmt;
        this.loanAmt=HousePrice-DownPmt;
    }
    
    private double setLTV(double HP, double DP)
    {
        double ltv=HP-DP;
        double ltvPercent=ltv/HP;
        return ltvPercent;
    }
    private double getLTV()
    {
        return this.LTV;
    }
    private double setMonthlyMI(double rate, double loan, double ufmip)
    {
        double totalLoan=loan+(ufmip*loan);
        double MI=(totalLoan*rate)/12;
        return MI;
    }
    public double setFHA(){
        
        double ufmip=0.0175;
        double mi=setMonthlyMI(.0085, this.loanAmt,ufmip);
        return mi;
    }
    public double setVA(){
        
        double ufmip=0.0215;
        double mi=0;
        return mi;
    }
    public double setUSDA(){
        
        double ufmip=0.01;
        double mi=setMonthlyMI(.0035, this.loanAmt,ufmip);
        return mi;
    }
    public double setConv(){
        double rate=0;
        double mi;
        double ltv=getLTV();
        if(ltv>=.9501)
            rate=.0131;
        if(ltv<=.9500 && ltv>=.9001)
            rate=.0089;
        if(ltv<=.9001 && ltv>=.8501)
            rate=.0057;
        if(ltv<=.85)
            rate=.0033;
        mi=setMonthlyMI(rate, this.loanAmt,1);
        return mi;
                
    }
    public double setUFMIP(double rate)
    {
        double ufmip=this.loanAmt*rate;
        double totalLoan=this.loanAmt+ufmip;
        return totalLoan;
    }
    
    
}
