/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Instructor
 */

 // Example 1 - superclass: CommissionEmployee.java
 public class CommissionEmployee {
   private final String firstName;                              
   private final String lastName;                               
   private final String socialSecurityNumber;                   
   private double grossSales; // gross weekly sales       
   private double commissionRate; // commission percentage
   // five-argument constructor //1. Error for line 9
  public CommissionEmployee (String firstName, String last,  String SS, double Sales,  double commission) { 
      this.firstName = firstName;    //2. Error here                                
      lastName = last;                                    
      socialSecurityNumber = SS;         
      grossSales = Sales;
      this.commissionRate = commission;
   } // end constructor 
   public String getFirstName() {
      return firstName; }
   // return last name
   public String getLastName( ){
      return lastName;}
   // return social security number
   public String getSocialSecurityNumber()  {
      return socialSecurityNumber;  } 
   // set gross sales amount
   public void setGrossSales(double grossSales){
      this.grossSales = grossSales;} 
   // return gross sales amount
   public double getGrossSales() {
      return grossSales; } 
   // set commission rate
   public void setCommissionRate(double commissionRate){
            this.commissionRate = commissionRate;} 
   // return commission rate
   public double getCommissionRate() {
      return commissionRate;   }
   // calculate earnings
   public double earnings()   {
      return getCommissionRate() * getGrossSales();   } 
   // return String representation of CommissionEmployee object
   @Override 
   public String toString()  {
      return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", 
         "commission employee", getFirstName(), getLastName(), 
         "social security number", getSocialSecurityNumber(),   "gross sales", getGrossSales(), 
         "commission rate", getCommissionRate()); } 
} // end class CommissionEmployee 